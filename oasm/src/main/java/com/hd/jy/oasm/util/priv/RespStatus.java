package com.hd.jy.oasm.util.priv;

import java.util.HashMap;



/**
 * HTTP请求，自定义响应码,8开头四位数字：
 * 8000  成功
 * 8001  请求处理失败
 * @author admin *
 */
public class RespStatus {
	
	/**请求处理成功*/
	public static final int SUCESS = 8000;
	/**请求处理失败*/
	public static final int FAILED = 8001;
	/**未登录*/
	public static final int TO_LOGIN = 8002;
	
	private static final HashMap<Integer,String> map = new HashMap<Integer, String>();
	
	static{
		map.put(SUCESS, "请求处理成功");
		map.put(FAILED, "请求处理失败");
		map.put(TO_LOGIN, "未登录");
	}

	
	/**
	 * 获取状态码的名称
	 * @param statusCode
	 * @return
	 */
	public static String name(int statusCode){
		return map.get(statusCode);
	}
	
}
