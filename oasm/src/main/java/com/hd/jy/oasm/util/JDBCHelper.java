package com.hd.jy.oasm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
//��������oracle
public class JDBCHelper {
 public static Connection getConne(){
	 Connection conn=null;
	 try {
		Properties pro = new Properties();
		//ʹ��jdbc����ʱ����ʱ��properties��·�����ⱨ��ָ�룬��/
		 pro.load(JDBCHelper.class.getResourceAsStream("/jdbc.properties"));
		 String driver = pro.getProperty("dbcp.driver");
		 Class.forName(driver);
		 String url = pro.getProperty("dbcp.url");
		 String username = pro.getProperty("dbcp.user");
		 String password = pro.getProperty("dbcp.pwd");
		 conn=DriverManager.getConnection(url, username, password);
		 if(conn!=null){
			 System.out.println("���ӳɹ�");
		 }else
		 {
			 System.out.println("����ʧ��");
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
//		System.out.println("��������ʧ��");
		e.printStackTrace();
	}
	return conn;
 }
 public static void main(String[] args) {
	 getConne();
  }
}
