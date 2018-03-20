package com.hd.jy.oasm.util.lsc.db;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.FileUtil;
import com.hd.jy.oasm.util.lsc.excpts.IllegalException;
import com.hd.jy.oasm.util.lsc.excpts.NullException;

/**
 * 数据库操作 公共基础工具
 * 
 * @author lsc
 */
public abstract class DBCommom {
	public static Logger logger = Logger.getLogger(DBCommom.class);

	// TODO BASE

	/**
	 * @param tableName
	 *            要检查是否存在的表名
	 * @return
	 * @throws SQLException
	 */
	public boolean isTableExists(String tableName) throws SQLException {
		// 检查oracle表名区分大小写，但jdbc对sql语句做了toUpperCase()处理
		if (DataUtil.isEmpty(tableName)) {
			throw new NullException("tableName", "");
		} else {
			tableName = tableName.toUpperCase();
		}

		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = getConnection();
			DatabaseMetaData meta = conn.getMetaData();

			// 目录,数据库schema（用户名等）,表名掩码%,表的种类："TABLE"、"VIEW"、"SYSTEM TABLE"、"GLOBAL TEMPORARY"、"LOCAL TEMPORARY"、"ALIAS"
			// 和 "SYNONYM"
			rs = meta
					.getTables(null, null, tableName, new String[] { "TABLE" });

			if (rs.next()) {
				// String msg = "Table[" + tableName
				// + "] exists and TABLE_SCHEM = "
				// + rs.getString("TABLE_SCHEM");
				// logger.info(msg);
				return true;
			} else {
				// String msg = "Table[" + tableName + "] not exist";
				// logger.info(msg);
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException("check if table[" + tableName
					+ "] exist failed", e);
		} finally {
			closeAll(conn, null, rs);
		}
	}

	/**
	 * 
	 * 检查以创建缺少的表格
	 * 
	 * @param tableName
	 *            要创建的表格的名称，如果空则使用sql脚本中table名字
	 * @param sqlScriptFile
	 *            sql脚本
	 * @throws Exception
	 */
	public void ensureTableExist(String tableName, String sqlScriptFile,
			Charset scriptCharset) throws Exception {

		if (tableName != null) {
			tableName = tableName.toUpperCase();
		}

		try {
			if (isTableExists(tableName)) {// tableName=null会抛异常
				logger.info("table [" + tableName + "] exists, ignore create");

			} else {
				logger.info("table [" + tableName
						+ "] is not exists, create table [" + tableName
						+ "]...");
				// sqlScriptFile=null会抛异常
				String sql = FileUtil.readAsString(sqlScriptFile,
						scriptCharset, null).trim();
				int len = sql.length();
				if (len > 0 && ";".equals(sql.substring(len - 1, len))) {
					sql = sql.substring(0, len - 1);
				}

				sql = sql.toUpperCase();

				String tableNameInSqlScript = sql.substring(
						sql.indexOf(" TABLE ") + 7, sql.indexOf("("));// 7=" TABLE ".length()+1
				sql = sql.replace(tableNameInSqlScript, tableName + " ");

				update(sql, null, true);

				boolean isExist = isTableExists(tableName);

				if (isExist) {
					logger.info("table [" + tableName
							+ "] is created successfully");

				} else {
					throw new SQLException("table [" + tableName
							+ "] is created failed");
				}
			}
		} catch (Exception e) {
			throw new Exception("ensureTableExist failed, tableName="
					+ tableName + ", sqlScriptFile" + sqlScriptFile
					+ ", scriptCharset=" + scriptCharset, e);
		}
	}

	/**
	 * 统计表格中的数据条数
	 * 
	 * @param tableName
	 *            表格数据
	 * @param wheres
	 *            过滤条件
	 * @param vals
	 * @return
	 * @throws SQLException
	 */
	public int countData(String tableName, String wheres, Object[] vals)
			throws SQLException {

		if (DataUtil.isEmpty(tableName)) {
			throw new IllegalException("tableName", tableName,
					"the value of tableName cannot be null or include nothing");
		}

		QueryMeta qm = null;
		int countResult = -1;

		logger.info("count data of table [" + tableName + "]...");

		try {
			String sql = "SELECT COUNT(*) FROM " + tableName;
			if (!DataUtil.isEmpty(wheres)) {
				sql += " WHERE " + wheres;
			}

			qm = query(sql, vals);

			if (qm.getResultSet().next()) {
				countResult = Integer.parseInt(qm.getResultSet().getString(1));
			}

			logger.info("total data of table[" + tableName + "]：" + countResult);

			return countResult;
		} catch (SQLException e) {
			throw new SQLException("count whole of table[" + tableName
					+ "] failed", e);
		} finally {
			closeAll(qm);
		}
	}

	/**
	 * 删除表中符合where条件的数据
	 * 
	 * @param tableName
	 * @param wheres
	 * @param vals
	 * @param delReference
	 *            要删除的数量参考值，不等则不删除。若不需设定参考值，则设负值
	 * @return 删除数量，失败返回-1
	 * @throws SQLException
	 */
	public int delete(String tableName, String wheres, Object[] vals,
			int delReference) throws SQLException {

		if (DataUtil.isEmpty(tableName)) {
			throw new IllegalException("tableName", tableName,
					"the value of tableName cannot be null or include nothing");
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql;
		int countResult = -1;
		try {
			sql = "DELETE FROM " + tableName;
			if (!DataUtil.isEmpty(wheres)) {
				sql += " WHERE " + wheres;
			}

			conn = getConnection();

			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);
			setPstmtVal(pstmt, vals);

			countResult = pstmt.executeUpdate();

			// 如果设置了删除量参考值，并且删除量与参考值不一致时，删除操作回滚
			if (delReference >= 0 && delReference != countResult) {
				logger.warn("the number of data gonna delete from table ["
						+ tableName + "] does not match delReference("
						+ delReference + "). SQL:" + sql + ",values:"
						+ DataUtil.toString(vals, ",", false)
						+ ", do rockback...");
				if (rollback(conn) == 1) {
					countResult = -1;
				}
			} else {// 否则提交事务
				conn.commit();
			}
		} catch (SQLException e) {
			rollback(conn);
			throw new SQLException("delete data from table " + tableName
					+ " failed", e);
		} finally {
			setAutoCommit(conn, true);
			closeAll(conn, pstmt, null);
		}

		return countResult;
	}

	/**
	 * 将表srcTableName中startTime（含）和endTime（不含）之间的数据转移到dstTableName表
	 * 
	 * @throws SQLException
	 * 
	 */
	public int transferData(String srcTableName, String dstTableName,
			String wheres, Object[] vals) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			int goToTransfer = countData(srcTableName, wheres, vals); // 要备份的数据条数
			int alreadyIn = 0;// 在目标表中已经存在的数据条数
			int countInsert = 0; // 插入备份表数据计数
			int alreadyInAfter; // 插入操作后，在备份表中已经存在的数据条数
			int countDel = 0;// 数据转移后，重源表删除的数据量

			if (goToTransfer == 0) {
				logger.info("no data need to be transfered");
				return 0;
			}

			alreadyIn = countData(dstTableName, null, null);

			if (!DataUtil.isEmpty(wheres)) {
				wheres = " WHERE " + wheres;
			} else {
				wheres = "";
			}

			String sql = "INSERT INTO " + dstTableName + " (SELECT * FROM "
					+ srcTableName + wheres + ")";

			conn = getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);
			setPstmtVal(pstmt, vals);

			countInsert = pstmt.executeUpdate();

			if (goToTransfer == countInsert) {
				conn.commit();

				logger.info("transfer data from table[" + srcTableName
						+ "] to [" + dstTableName + "] success: " + countInsert);

				countDel = delete(srcTableName, wheres, vals, goToTransfer);
				alreadyInAfter = countData(dstTableName, null, null);

				if (alreadyInAfter != countDel + alreadyIn) {
					throw new SQLException(
							"after inserted, the num of data in table["
									+ dstTableName
									+ "]("
									+ alreadyInAfter
									+ ") mismatch sum of data that exist in table["
									+ dstTableName + "](" + alreadyIn
									+ ") before insert and  delete from table["
									+ srcTableName + "](" + countDel + ")");
				}

				return countInsert;

			} else {
				String msg = "insert failed: the num of data inserted("
						+ countInsert + ")  mismatch which need transfered("
						+ goToTransfer + ")";

				throw new SQLException(msg);
			}
		} catch (SQLException e) {
			rollback(conn);
			throw new SQLException("transfer data from table[" + srcTableName
					+ "] to [" + dstTableName + "] failed.", e);

		} finally {
			setAutoCommit(conn, true);
			closeAll(conn, pstmt, null);
		}
	}

	/**
	 * 通过以字符串equals的方式比较指定数据表特定列中的内容是否相等
	 * 
	 * @param tableName
	 *            表名，不可为空
	 * @param colName
	 *            列名，不可为空
	 * @param compareContent
	 *            要比较的内容
	 * @param wheres
	 *            where过滤条件
	 * @param vals
	 *            where过滤条件占位符的值
	 * @param trimBeforeCompare
	 *            是否去除字符串两端空格再比较
	 * @return
	 * @throws SQLException
	 */
	public boolean isStringMatched(String tableName, String colName,
			String compareContent, String wheres, Object[] vals,
			boolean trimBeforeCompare) throws SQLException {

		if (tableName == null || colName == null) {
			throw new NullException("tableName or colName cannot be NULL");
		}

		if (compareContent != null && trimBeforeCompare) {
			compareContent = compareContent.trim();
		}

		if (DataUtil.isNothing(wheres)) {
			wheres = "";
		} else {
			wheres = " where " + wheres;
		}

		String sql = "select " + colName + " from " + tableName + wheres;
		QueryMeta qm = query(sql, vals);
		ResultSet rs = qm.getResultSet();
		String s = null;
		try {

			while (rs.next()) {
				s = rs.getString(1);
				if (s != null && trimBeforeCompare) {
					s = s.trim();
				}

				if ((compareContent != null && !compareContent.equals(s))
						|| (compareContent == null && s != null)) {
					return false;
				}
			}

			return true;
		} catch (SQLException e) {
			throw new SQLException("compare content of table[" + tableName
					+ "]col[" + colName + "] failed", e);
		} finally {
			closeAll(qm);
		}
	}

	/**
	 * 通过以double方式比较指定数据表特定列中的内容是否相等
	 * 
	 * @param tableName
	 *            表名，不可为空
	 * @param colName
	 *            列名，不可为空
	 * @param compareVal
	 *            要比较的内容
	 * @param wheres
	 *            where过滤条件
	 * @param vals
	 *            where过滤条件占位符的值
	 * @return
	 * @throws SQLException
	 */
	public boolean isDoubleMatched(String tableName, String colName,
			double compareVal, String wheres, Object[] vals)
			throws SQLException {

		if (tableName == null || colName == null) {
			throw new NullException("tableName or colName cannot be NULL");
		}

		if (DataUtil.isNothing(wheres)) {
			wheres = "";
		} else {
			wheres = " where " + wheres;
		}

		String sql = "select " + colName + " from " + tableName + wheres;
		QueryMeta qm = query(sql, vals);
		ResultSet rs = qm.getResultSet();
		try {

			while (rs.next()) {
				if (rs.getDouble(1) != compareVal) {
					return false;
				}
			}

			return true;
		} catch (SQLException e) {
			throw new SQLException("compare double val of table[" + tableName
					+ "]col[" + colName + "] failed", e);
		} finally {
			closeAll(qm);
		}

	}

	// TODO BASE

	/**
	 * 添加、更新、删除数据，如果设置autoClose=false,操作完记得调用closeAll(UpdateMeta
	 * updateMeta)方法关闭数据库连接资源
	 * 
	 * @param sql
	 *            要执行的SQL语句
	 * @param val
	 *            SQL语句中占位符的匹配值
	 * @return 返回包含Connection，PreparedStatement，影响结果数[int]effectCount的
	 *         UpdateMeta对象。autoClose=true时，返回的Connection、Statement为null
	 * @throws SQLException
	 */
	public UpdateMeta update(String sql, Object[] val, boolean autoClose)
			throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int effectCount = 0;

		try {

			conn = getConnection();

			// 完全正常执行再提交
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);

			setPstmtVal(pstmt, val);

			effectCount = pstmt.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			StringBuilder vals = new StringBuilder();

			if (val != null) {

				for (int i = 0; i < val.length; i++) {
					vals.append(String.valueOf(val[i]));
					if (i < val.length - 1) {
						vals.append(",");
					}
				}
			}

			rollback(conn);
			throw new SQLException("Execute SQL[" + sql + "] with vals["
					+ vals.toString() + "] failed", e);

		} finally {
			setAutoCommit(conn, true);
			if (autoClose) {
				closeAll(conn, pstmt, null);
			}
		}

		if (autoClose) {
			return new UpdateMeta(null, null, effectCount);
		} else {
			return new UpdateMeta(conn, pstmt, effectCount);
		}
	}

	/**
	 * 数据库查询，使用完后，记得调用closeAll(QueryMeta queryMeta)方法关闭数据库连接资源
	 * 
	 * @param sql
	 *            要执行的SQL语句
	 * @param val
	 *            SQL语句中占位符的匹配值
	 * @return 返回包含Connection，PreparedStatement，ResultSet的QueryMeta对象
	 * 
	 * @throws SQLException
	 * 
	 */

	public QueryMeta query(String sql, Object[] val) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// ResultSet.TYPE_SCROLL_INSENSITIVE,一次查询的结果可能存在数据库端的内存缓冲中，
			// 也可以直接发送到JVM的内存中，
			// 如果结果集很小，会直接发送到JVM层，然后被next定位，转换数据类型，显示，或者缓存在数据库内存中。
			// 总之，查询结果已经和数据库脱离，这时如果数据库记录被其它进程更新，则结果集无法得知，还是使用缓存的记录。

			// ResultSet.TYPE_SCROLL_SENSITIVE，一次查询的结果并不是直接的记录被缓存下来，只是符合条件的记录的“原始ROWID”
			// 被缓存了，这个原始ROWID并非特指Oracle的ROWID，而是数据库底层定位记录的索引值。
			// 只能更新操作敏感，其它的插入操作和删除操作不会及时地反映到结果集
			// ResultSet.TYPE_SCROLL_SENSITIVE

			// ResultSet.CONCUR_UPDATABLE //设置rs为可更新
			// ResultSet.CONCUR_READ_ONLY//设置rs为只读

			pstmt = conn.prepareStatement(sql);

			setPstmtVal(pstmt, val);

			rs = pstmt.executeQuery();

			return new QueryMeta(conn, pstmt, rs);
		} catch (SQLException e) {
			closeAll(conn, pstmt, rs);
			String vals = val == null ? "" : " with val["
					+ DataUtil.toString(val, ",", false) + "]";

			throw new SQLException("Execute SQL[" + sql + "]" + vals
					+ " failed", e);
		}
	}

	/**
	 * 批量执行非查询类sql
	 * 
	 * @param sqls
	 * @return
	 * @throws SQLException
	 */
	public int[] doBatch(List<String> sqls) throws SQLException {
		if (sqls == null || sqls.size() == 0) {
			return null;
		}

		Connection conn = null;
		Statement stmt = null;
		int[] rs = null;

		try {
			conn = getConnection();

			// 取消自动提交
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			for (String sql : sqls) {
				stmt.addBatch(sql);
			}

			rs = stmt.executeBatch();// 提交上面的命令
			conn.commit();// 提交事务
		} catch (SQLException e) {
			throw new SQLException("Execute sqls " + sqls + " failed", e);

		} finally {
			setAutoCommit(conn, true);
			closeAll(conn, stmt, null);
		}

		return rs;
	}

	// TODO BASE

	/**
	 * 为PreparedStatement设置占位符参数
	 * 
	 * @param pstmt
	 * @param val
	 * @throws SQLException
	 */
	public static void setPstmtVal(PreparedStatement pstmt, Object[] vals)
			throws SQLException {
		if (vals != null) {
			for (int i = 0; i < vals.length; i++) {
				pstmt.setObject(i + 1, vals[i]);
			}
		}
	}

	/**
	 * 设置自动提交
	 * 
	 * @param conn
	 * @return 成功执行返回1，没有执行（connection=null）返回0，执行失败返回-1
	 */
	public static int setAutoCommit(Connection conn, boolean autoCommit) {
		if (conn == null) {
			// logger.warn("Connection is null, ignore setAutoCommit.");
			return 0;
		}

		try {
			conn.setAutoCommit(autoCommit);
			return 1;
		} catch (SQLException e) {
			logger.error("Set autoCommit=" + autoCommit + " failed", e);
			return -1;
		}
	}

	/**
	 * 数据库回滚
	 * 
	 * @param conn
	 * @return 成功执行返回1，没有执行（connection=null）返回0，执行失败返回-1
	 */
	public static int rollback(Connection conn) {
		if (conn == null) {
			// logger.warn("Connection is null, ignore rollback.");
			return 0;
		}
		try {
			conn.rollback();
			logger.info("Rollback success.");
			return 1;
		} catch (SQLException e) {
			logger.error("Rollback failed", e);
			return -1;
		}
	}

	/**
	 * 显示连接URL
	 * 
	 * @throws SQLException
	 */
	public void showConnUrl() throws SQLException {

		Connection conn = getConnection();
		DatabaseMetaData dbmd = conn.getMetaData();
		logger.info("connected to " + dbmd.getURL());
		conn.close();
	}

	// TODO BASE

	/**
	 * 从数据库连接池中获取一个连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public abstract Connection getConnection() throws SQLException;

	/**
	 * 关闭数据库连接资源
	 * 
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static boolean closeAll(Connection conn, Statement stmt, ResultSet rs) {
		boolean isRsClosed = true;
		boolean isStmtClosed = true;
		boolean isConnClosed = true;

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				isRsClosed = false;
				logger.warn("Close resaultSet failed", e);
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				isStmtClosed = false;
				logger.warn("Close preparedStatement failed", e);
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				isConnClosed = false;
				logger.warn("Close connection failed", e);
			}
		}

		return isRsClosed && isStmtClosed && isConnClosed;
	}

	/**
	 * 关闭数据库连接资源
	 * 
	 * @param updateMeta
	 */
	public static boolean closeAll(UpdateMeta updateMeta) {
		if (updateMeta == null) {
			return true;
		}

		Connection conn = updateMeta.getConnection();
		Statement pstmt = updateMeta.getPreparedStatement();

		return closeAll(conn, pstmt, null);
	}

	/**
	 * 关闭数据库连接资源
	 * 
	 * @param queryMeta
	 */
	public static boolean closeAll(QueryMeta queryMeta) {
		if (queryMeta == null) {
			return true;
		}

		Connection conn = queryMeta.getConnection();
		Statement pstmt = queryMeta.getPreparedStatement();
		ResultSet rs = queryMeta.getResultSet();

		return closeAll(conn, pstmt, rs);
	}

	/**
	 * 执行update()方法是返回的对象，包含Connection、PreparedStatement、effectCount（int）
	 * 
	 * @author ander
	 * 
	 */
	public static class UpdateMeta {
		private Connection connection;
		private PreparedStatement preparedStatement;
		private int effectCount;

		public UpdateMeta(Connection conn, PreparedStatement pstmt,
				int effectCount) {
			this.connection = conn;
			this.preparedStatement = pstmt;
			this.effectCount = effectCount;
		}

		public Connection getConnection() {
			return connection;
		}

		public PreparedStatement getPreparedStatement() {
			return preparedStatement;
		}

		public int getEffectCount() {
			return effectCount;
		}
	}

	/**
	 * 执行query()方法是返回的对象，包含Connection、PreparedStatement、ResultSet
	 * 
	 * @author ander
	 * 
	 */
	public static class QueryMeta {
		private Connection connection;
		private PreparedStatement preparedStatement;
		private ResultSet resultSet;

		public QueryMeta(Connection conn, PreparedStatement pstmt, ResultSet rs) {
			this.connection = conn;
			this.preparedStatement = pstmt;
			this.resultSet = rs;
		}

		public Connection getConnection() {
			return connection;
		}

		public PreparedStatement getPreparedStatement() {
			return preparedStatement;
		}

		public ResultSet getResultSet() {
			return resultSet;
		}
	}
}
