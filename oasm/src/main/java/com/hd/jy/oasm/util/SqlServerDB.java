package com.hd.jy.oasm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SqlServerDB {
	/**
	 * 
	 * @auto quite
	 * @returna
	 * 上午9:43:51
	 * Connection 测试sql server工具类
	 */
	public static Connection getConne(){
		 Connection conn=null;
		 try {
			Properties pro = new Properties();
			//使用jdbc连接时，有时候properties的路径问题报空指针，加/
			 pro.load(SqlServerDB.class.getResourceAsStream("/jdbc.properties"));
			 String driver = pro.getProperty("jdbc.driverClassName");
			 Class.forName(driver).newInstance();
			 String url = pro.getProperty("jdbc.url");
			 String username = pro.getProperty("jdbc.username");
			 String password = pro.getProperty("jdbc.password");
			 conn=DriverManager.getConnection(url, username, password);
			 if(conn!=null){
				 System.out.println("连接成功");
			 }else
			 {
				 System.out.println("连接失败");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	 }
	 public static void main(String[] args) {
		 getConne();
	  }
}
