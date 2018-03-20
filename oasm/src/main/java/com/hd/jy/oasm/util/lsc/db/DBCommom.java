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
 * ���ݿ���� ������������
 * 
 * @author lsc
 */
public abstract class DBCommom {
	public static Logger logger = Logger.getLogger(DBCommom.class);

	// TODO BASE

	/**
	 * @param tableName
	 *            Ҫ����Ƿ���ڵı���
	 * @return
	 * @throws SQLException
	 */
	public boolean isTableExists(String tableName) throws SQLException {
		// ���oracle�������ִ�Сд����jdbc��sql�������toUpperCase()����
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

			// Ŀ¼,���ݿ�schema���û����ȣ�,��������%,������ࣺ"TABLE"��"VIEW"��"SYSTEM TABLE"��"GLOBAL TEMPORARY"��"LOCAL TEMPORARY"��"ALIAS"
			// �� "SYNONYM"
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
	 * ����Դ���ȱ�ٵı��
	 * 
	 * @param tableName
	 *            Ҫ�����ı������ƣ��������ʹ��sql�ű���table����
	 * @param sqlScriptFile
	 *            sql�ű�
	 * @throws Exception
	 */
	public void ensureTableExist(String tableName, String sqlScriptFile,
			Charset scriptCharset) throws Exception {

		if (tableName != null) {
			tableName = tableName.toUpperCase();
		}

		try {
			if (isTableExists(tableName)) {// tableName=null�����쳣
				logger.info("table [" + tableName + "] exists, ignore create");

			} else {
				logger.info("table [" + tableName
						+ "] is not exists, create table [" + tableName
						+ "]...");
				// sqlScriptFile=null�����쳣
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
	 * ͳ�Ʊ���е���������
	 * 
	 * @param tableName
	 *            �������
	 * @param wheres
	 *            ��������
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

			logger.info("total data of table[" + tableName + "]��" + countResult);

			return countResult;
		} catch (SQLException e) {
			throw new SQLException("count whole of table[" + tableName
					+ "] failed", e);
		} finally {
			closeAll(qm);
		}
	}

	/**
	 * ɾ�����з���where����������
	 * 
	 * @param tableName
	 * @param wheres
	 * @param vals
	 * @param delReference
	 *            Ҫɾ���������ο�ֵ��������ɾ�����������趨�ο�ֵ�����踺ֵ
	 * @return ɾ��������ʧ�ܷ���-1
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

			// ���������ɾ�����ο�ֵ������ɾ������ο�ֵ��һ��ʱ��ɾ�������ع�
			if (delReference >= 0 && delReference != countResult) {
				logger.warn("the number of data gonna delete from table ["
						+ tableName + "] does not match delReference("
						+ delReference + "). SQL:" + sql + ",values:"
						+ DataUtil.toString(vals, ",", false)
						+ ", do rockback...");
				if (rollback(conn) == 1) {
					countResult = -1;
				}
			} else {// �����ύ����
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
	 * ����srcTableName��startTime��������endTime��������֮�������ת�Ƶ�dstTableName��
	 * 
	 * @throws SQLException
	 * 
	 */
	public int transferData(String srcTableName, String dstTableName,
			String wheres, Object[] vals) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			int goToTransfer = countData(srcTableName, wheres, vals); // Ҫ���ݵ���������
			int alreadyIn = 0;// ��Ŀ������Ѿ����ڵ���������
			int countInsert = 0; // ���뱸�ݱ����ݼ���
			int alreadyInAfter; // ����������ڱ��ݱ����Ѿ����ڵ���������
			int countDel = 0;// ����ת�ƺ���Դ��ɾ����������

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
	 * ͨ�����ַ���equals�ķ�ʽ�Ƚ�ָ�����ݱ��ض����е������Ƿ����
	 * 
	 * @param tableName
	 *            ����������Ϊ��
	 * @param colName
	 *            ����������Ϊ��
	 * @param compareContent
	 *            Ҫ�Ƚϵ�����
	 * @param wheres
	 *            where��������
	 * @param vals
	 *            where��������ռλ����ֵ
	 * @param trimBeforeCompare
	 *            �Ƿ�ȥ���ַ������˿ո��ٱȽ�
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
	 * ͨ����double��ʽ�Ƚ�ָ�����ݱ��ض����е������Ƿ����
	 * 
	 * @param tableName
	 *            ����������Ϊ��
	 * @param colName
	 *            ����������Ϊ��
	 * @param compareVal
	 *            Ҫ�Ƚϵ�����
	 * @param wheres
	 *            where��������
	 * @param vals
	 *            where��������ռλ����ֵ
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
	 * ��ӡ����¡�ɾ�����ݣ��������autoClose=false,������ǵõ���closeAll(UpdateMeta
	 * updateMeta)�����ر����ݿ�������Դ
	 * 
	 * @param sql
	 *            Ҫִ�е�SQL���
	 * @param val
	 *            SQL�����ռλ����ƥ��ֵ
	 * @return ���ذ���Connection��PreparedStatement��Ӱ������[int]effectCount��
	 *         UpdateMeta����autoClose=trueʱ�����ص�Connection��StatementΪnull
	 * @throws SQLException
	 */
	public UpdateMeta update(String sql, Object[] val, boolean autoClose)
			throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int effectCount = 0;

		try {

			conn = getConnection();

			// ��ȫ����ִ�����ύ
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
	 * ���ݿ��ѯ��ʹ����󣬼ǵõ���closeAll(QueryMeta queryMeta)�����ر����ݿ�������Դ
	 * 
	 * @param sql
	 *            Ҫִ�е�SQL���
	 * @param val
	 *            SQL�����ռλ����ƥ��ֵ
	 * @return ���ذ���Connection��PreparedStatement��ResultSet��QueryMeta����
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

			// ResultSet.TYPE_SCROLL_INSENSITIVE,һ�β�ѯ�Ľ�����ܴ������ݿ�˵��ڴ滺���У�
			// Ҳ����ֱ�ӷ��͵�JVM���ڴ��У�
			// ����������С����ֱ�ӷ��͵�JVM�㣬Ȼ��next��λ��ת���������ͣ���ʾ�����߻��������ݿ��ڴ��С�
			// ��֮����ѯ����Ѿ������ݿ����룬��ʱ������ݿ��¼���������̸��£��������޷���֪������ʹ�û���ļ�¼��

			// ResultSet.TYPE_SCROLL_SENSITIVE��һ�β�ѯ�Ľ��������ֱ�ӵļ�¼������������ֻ�Ƿ��������ļ�¼�ġ�ԭʼROWID��
			// �������ˣ����ԭʼROWID������ָOracle��ROWID���������ݿ�ײ㶨λ��¼������ֵ��
			// ֻ�ܸ��²������У������Ĳ��������ɾ���������ἰʱ�ط�ӳ�������
			// ResultSet.TYPE_SCROLL_SENSITIVE

			// ResultSet.CONCUR_UPDATABLE //����rsΪ�ɸ���
			// ResultSet.CONCUR_READ_ONLY//����rsΪֻ��

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
	 * ����ִ�зǲ�ѯ��sql
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

			// ȡ���Զ��ύ
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			for (String sql : sqls) {
				stmt.addBatch(sql);
			}

			rs = stmt.executeBatch();// �ύ���������
			conn.commit();// �ύ����
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
	 * ΪPreparedStatement����ռλ������
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
	 * �����Զ��ύ
	 * 
	 * @param conn
	 * @return �ɹ�ִ�з���1��û��ִ�У�connection=null������0��ִ��ʧ�ܷ���-1
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
	 * ���ݿ�ع�
	 * 
	 * @param conn
	 * @return �ɹ�ִ�з���1��û��ִ�У�connection=null������0��ִ��ʧ�ܷ���-1
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
	 * ��ʾ����URL
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
	 * �����ݿ����ӳ��л�ȡһ������
	 * 
	 * @return
	 * @throws SQLException
	 */
	public abstract Connection getConnection() throws SQLException;

	/**
	 * �ر����ݿ�������Դ
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
	 * �ر����ݿ�������Դ
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
	 * �ر����ݿ�������Դ
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
	 * ִ��update()�����Ƿ��صĶ��󣬰���Connection��PreparedStatement��effectCount��int��
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
	 * ִ��query()�����Ƿ��صĶ��󣬰���Connection��PreparedStatement��ResultSet
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
