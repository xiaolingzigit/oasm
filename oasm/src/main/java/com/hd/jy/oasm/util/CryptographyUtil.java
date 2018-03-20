package com.hd.jy.oasm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

//加密
public class CryptographyUtil {
	//Base64加密
		public static String enBase64(String str)
		{
			return Base64.encodeToString(str.getBytes());
		}
		//Base64解密
		public static String decBase64(String str)
		{
			return Base64.decodeToString(str.getBytes());
		}
		//MD5加密不可逆
		public static String MD5(String str)
		{
			return new Md5Hash(str,"com.hd.jy.oasm.util").toString();//使用密码+时间的方式对密码加盐
		}
		
		//
		/**
		 * @author 
		 *	获取当前时间并且格式化
		 * @return String
		 */
		public String SimplDateToString(){
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			
		}
		
		public static void main(String[] args) {
			String str = "xiaohua&&123456&&";
			String dstr = "YWRtaW4mJjEyMw==";
//			String string = MD5("123");
//			System.out.println(string);
//			System.out.println(new CryptographyUtil().SimplDateToString());
			System.out.println(CryptographyUtil.enBase64(str));
//			System.out.println(new CryptographyUtil().decBase64(dstr));
		}
}
