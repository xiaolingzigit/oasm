package com.hd.jy.oasm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
//测试连接oracle
public class JDBCHelper {
 public static Connection getConne(){
	 Connection conn=null;
	 try {
		Properties pro = new Properties();
		//使用jdbc连接时，有时候properties的路径问题报空指针，加/
		 pro.load(JDBCHelper.class.getResourceAsStream("/jdbc.properties"));
		 String driver = pro.getProperty("dbcp.driver");
		 Class.forName(driver);
		 String url = pro.getProperty("dbcp.url");
		 String username = pro.getProperty("dbcp.user");
		 String password = pro.getProperty("dbcp.pwd");
		 conn=DriverManager.getConnection(url, username, password);
		 if(conn!=null){
			 System.out.println("连接成功");
		 }else
		 {
			 System.out.println("连接失败");
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
//		System.out.println("加载驱动失败");
		e.printStackTrace();
	}
	return conn;
 }
 public static void main(String[] args) {
	 getConne();
  }
}
