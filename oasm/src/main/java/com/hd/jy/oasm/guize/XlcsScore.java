package com.hd.jy.oasm.guize;

/**
 * 
* @ClassName: XlcsScore 
* @Description:  ����scl-90 ����
* @author liangjiaying
* @date 2017��10��24�� ����8:26:27 
*
 */
public class XlcsScore {
	
	/**
	 * 
	 * @Date: 2017��10��24��
	 * @Title: scoreValue   
	 * @Description: ����scl-90 ����
	 * @param: @param key
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int scoreValue(String key){
		switch (key) {
		   	case "û��":
		   		return 0;	
			case "����":
				return 1;
			case "�е�":
				return 2;
			case "ƫ��":
				return 3;
			case "����":
				return 4;
		}
		return -1;
	}

}
