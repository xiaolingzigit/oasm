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
 * 数据库连接池
 * 
 * commons-dbcp.jar+common-collection.jar+commons-pool.jar
 * 
 * @author ander
 *
 */
public class DBCP extends DBCommom {
	public static Logger logger = com.hd.jy.oasm.util.lsc.Log4jUtil.getLogger(DBCP.class);

	private static String mConfigFile = "D:/testConf/hj_dbcp.properties";

	private static DataSource ds;// 连接池对象

	/**
	 * 使用本类中默认的confFile文件mConfigFile，配置数据库连接
	 */
	public DBCP() {
		init(null, null, false);
	}

	/**
	 * 使用configFile配置数据库连接
	 * 
	 * @param configFile
	 *            配置文件，null则使用本类中默认的confFile文件，配置数据库连接
	 * @param charset
	 *            null则不指定编码，如果properties文件含中文，则必须指定编码
	 * @param inSrc
	 *            是否在src目录内
	 */
	public DBCP(String configFile, String charset, boolean inSrc) {
		init(configFile, charset, inSrc);
	}

	/**
	 * 初始化数据库连接池
	 * 
	 * @param configFile
	 *            配置文件，null则使用本类中默认的confFile文件mConfigFile，配置数据库连接
	 * @param charset
	 *            null则不指定编码，如果properties文件含中文，则必须指定编码
	 * @param inSrc
	 *            是否在src目录内
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

			// 得到一个连接池对象
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
	 * 从数据库连接池中获取一个连接
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
