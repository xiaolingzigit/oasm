/**
 * 
 */
package com.hd.jy.oasm.util.file;

import java.util.regex.Pattern;

/**
 * @author quite
 *验证导入文件的内容是否符合规范
 */
public class FileDataCheck {
   private static final String CHECK_NAME = "\\d{7}"; 
   
   private static final String CHCK_PASSWORD = "[a-zA-Z0-9_]{3,20}";
   
   public static boolean checkName(String xm){
	   boolean cname = false;
	try {
		cname = Pattern.matches(FileDataCheck.CHECK_NAME, xm);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return cname;
   }
   
   public static boolean checkPassword(String ma){
	   boolean cma = false;
	try {
		cma = Pattern.matches(FileDataCheck.CHCK_PASSWORD, ma);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return cma;
   }
   
   public static void main(String[] args) {
	   boolean name = checkPassword("103_800808R0ew890rw9");
	   System.out.println(name);
}
}
