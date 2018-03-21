package com.hd.jy.oasm.util;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * Mybatis - ͨ�÷�ҳ������
 * @author liuzh/abel533/isea
 * Created by liuzh on 14-4-15.
 * modified by ljy on 2017-11-18
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class PageHelper implements Interceptor {
    private static final Logger logger = Logger.getLogger(PageHelper.class);
    
    private static Pattern FROM_PATTERN = Pattern.compile("from");
    
    private static Pattern ORDER_PATTERN = Pattern.compile("order");

    public static final ThreadLocal<Page> localPage = new ThreadLocal<Page>();

    /**
     * ��ʼ��ҳ
     * @param pageNum
     * @param pageSize
     */
    public static void startPage(int pageNum, int pageSize) {
        localPage.set(new Page(pageNum, pageSize));
    }

    /**
     * ������ҳ�����ؽ�����÷������뱻���ã�����localPage��һֱ������ȥ��ֱ����һ��startPage
     * @return
     */
    public static Page endPage() {
        Page page = localPage.get();
        localPage.remove();
        return page;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (localPage.get() == null) {
            return invocation.proceed();
        }
        if (invocation.getTarget() instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            // ������������(����Ŀ������ܱ�������������أ��Ӷ��γɶ�δ���ͨ�����������ѭ��
            // ���Է������ԭʼ�ĵ�Ŀ����)
            while (metaStatementHandler.hasGetter("h")) {
                Object object = metaStatementHandler.getValue("h");
                metaStatementHandler = SystemMetaObject.forObject(object);
            }
            // �������һ����������Ŀ����
            while (metaStatementHandler.hasGetter("target")) {
                Object object = metaStatementHandler.getValue("target");
                metaStatementHandler = SystemMetaObject.forObject(object);
            }
            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
            //��ҳ��Ϣif (localPage.get() != null) {
            Page page = localPage.get();
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            // ��ҳ������Ϊ��������parameterObject��һ������
            String sql = boundSql.getSql();
            // ��дsql
            String pageSql = buildPageSql(sql, page);
            //��д��ҳsql
            metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
            Connection connection = (Connection) invocation.getArgs()[0];
            // �����ҳ���������ҳ����
            setPageParameter(sql, connection, mappedStatement, boundSql, page);
            // ��ִ��Ȩ������һ��������
            return invocation.proceed();
        } else if (invocation.getTarget() instanceof ResultSetHandler) {
            Object result = invocation.proceed();
            Page page = localPage.get();
            page.setResult((List) result);
            return result;
        }
        return null;
    }

    /**
     * ֻ�������������͵�
     * <br>StatementHandler
     * <br>ResultSetHandler
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler || target instanceof ResultSetHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * �޸�ԭSQLΪ��ҳSQL
     * @param sql
     * @param page
     * @return
     */
    private String buildPageSql(String sql, Page page) {
        StringBuilder pageSql = new StringBuilder(200);
//        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
//        pageSql.append(sql);
//        pageSql.append(" ) temp where rownum <= ").append(page.getEndRow());
//        pageSql.append(") where row_id > ").append(page.getStartRow());
        
        pageSql.append(sql);
        pageSql.append(" LIMIT ");
        pageSql.append(page.getStartRow());
        pageSql.append(" , ");
        pageSql.append(page.getPageSize());
        return pageSql.toString();
       
    }

    /**
     * ��ȡ�ܼ�¼��
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param page
     */
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
                                  BoundSql boundSql, Page page) {
//    	logger.info("����PageHrlper.setPageParameter");
        // ��¼�ܼ�¼��
    	//������ָ�sql��䣬ȡ����
    	sql = sql.toLowerCase();
		Pattern compile = FROM_PATTERN;
		String[] split = compile.split(sql);
		sql = split[1];
		compile = ORDER_PATTERN;
		split = compile.split(sql);
		sql = split[0];
		
        String countSql = "select count(1) from " + sql;
        logger.info(countSql);
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
            rs = countStmt.executeQuery();
            int totalCount = 0;
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
//            logger.info("totalCount  ------------"+totalCount);
            page.setTotal(totalCount);
            int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);
            page.setPages(totalPage);
        } catch (SQLException e) {
            logger.error("Ignore this exception", e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
            try {
                countStmt.close();
            } catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
        }
    }

    /**
     * �������ֵ
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
                               Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }

    
}
