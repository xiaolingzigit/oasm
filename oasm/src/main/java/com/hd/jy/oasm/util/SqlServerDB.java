package com.hd.jy.oasm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SqlServerDB {
	/**
	 * 
	 * @auto quite
	 * @returna
	 * ����9:43:51
	 * Connection ����sql server������
	 */
	public static Connection getConne(){
		 Connection conn=null;
		 try {
			Properties pro = new Properties();
			//ʹ��jdbc����ʱ����ʱ��properties��·�����ⱨ��ָ�룬��/
			 pro.load(SqlServerDB.class.getResourceAsStream("/jdbc.properties"));
			 String driver = pro.getProperty("jdbc.driverClassName");
			 Class.forName(driver).newInstance();
			 String url = pro.getProperty("jdbc.url");
			 String username = pro.getProperty("jdbc.username");
			 String password = pro.getProperty("jdbc.password");
			 conn=DriverManager.getConnection(url, username, password);
			 if(conn!=null){
				 System.out.println("���ӳɹ�");
			 }else
			 {
				 System.out.println("����ʧ��");
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
