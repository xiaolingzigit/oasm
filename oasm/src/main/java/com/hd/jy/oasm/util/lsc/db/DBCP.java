package com.hd.jy.oasm.util.lsc.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.log4j.Logger;

import com.hd.jy.oasm.util.lsc.PropUtil;

/**
 * ���ݿ����ӳ�
 * 
 * commons-dbcp.jar+common-collection.jar+commons-pool.jar
 * 
 * @author ander
 *
 */
public class DBCP extends DBCommom {
	public static Logger logger = com.hd.jy.oasm.util.lsc.Log4jUtil.getLogger(DBCP.class);

	private static String mConfigFile = "D:/testConf/hj_dbcp.properties";

	private static DataSource ds;// ���ӳض���

	/**
	 * ʹ�ñ�����Ĭ�ϵ�confFile�ļ�mConfigFile���������ݿ�����
	 */
	public DBCP() {
		init(null, null, false);
	}

	/**
	 * ʹ��configFile�������ݿ�����
	 * 
	 * @param configFile
	 *            �����ļ���null��ʹ�ñ�����Ĭ�ϵ�confFile�ļ����������ݿ�����
	 * @param charset
	 *            null��ָ�����룬���properties�ļ������ģ������ָ������
	 * @param inSrc
	 *            �Ƿ���srcĿ¼��
	 */
	public DBCP(String configFile, String charset, boolean inSrc) {
		init(configFile, charset, inSrc);
	}

	/**
	 * ��ʼ�����ݿ����ӳ�
	 * 
	 * @param configFile
	 *            �����ļ���null��ʹ�ñ�����Ĭ�ϵ�confFile�ļ�mConfigFile���������ݿ�����
	 * @param charset
	 *            null��ָ�����룬���properties�ļ������ģ������ָ������
	 * @param inSrc
	 *            �Ƿ���srcĿ¼��
	 */
	public void init(String configFile, String charset, boolean inSrc) {
		if (configFile == null) {
			configFile = mConfigFile;
		}

		try {
			Properties prop = PropUtil.properties(configFile, charset, inSrc);

			if (prop == null) {
				throw new Exception("get properties failed");
			}

			// �õ�һ�����ӳض���
			ds = BasicDataSourceFactory.createDataSource(prop);

			showConnUrl();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(
					"dataSource initialization failed, please check "
							+ "property file[" + mConfigFile
							+ "] and driver, details:" + e.toString());
		}
	}

	/**
	 * �����ݿ����ӳ��л�ȡһ������
	 * 
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Connection getConnection() throws SQLException {

		if (ds == null) {
			init(null, null, false);
		}

		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new SQLException("Get connection failed:"+e.getMessage(), e);
		}
	}
		
	public static void main(String[] args) throws SQLException {
		QueryMeta qMeta = new DBCP().query("select * from jyxx", null);
		ResultSet rs = qMeta.getResultSet();
		while (rs.next()){
			System.out.println(rs.getString(1));
			
		}
	}
}
