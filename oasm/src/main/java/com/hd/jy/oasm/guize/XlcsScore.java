package com.hd.jy.oasm.guize;

/**
 * 
* @ClassName: XlcsScore 
* @Description:  计算scl-90 分数
* @author liangjiaying
* @date 2017年10月24日 下午8:26:27 
*
 */
public class XlcsScore {
	
	/**
	 * 
	 * @Date: 2017年10月24日
	 * @Title: scoreValue   
	 * @Description: 计算scl-90 分数
	 * @param: @param key
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int scoreValue(String key){
		switch (key) {
		   	case "没有":
		   		return 0;	
			case "很轻":
				return 1;
			case "中等":
				return 2;
			case "偏重":
				return 3;
			case "严重":
				return 4;
		}
		return -1;
	}

}
