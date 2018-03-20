package com.hd.jy.oasm.util.priv;

import java.util.HashMap;



/**
 * HTTP�����Զ�����Ӧ��,8��ͷ��λ���֣�
 * 8000  �ɹ�
 * 8001  ������ʧ��
 * @author admin *
 */
public class RespStatus {
	
	/**������ɹ�*/
	public static final int SUCESS = 8000;
	/**������ʧ��*/
	public static final int FAILED = 8001;
	/**δ��¼*/
	public static final int TO_LOGIN = 8002;
	
	private static final HashMap<Integer,String> map = new HashMap<Integer, String>();
	
	static{
		map.put(SUCESS, "������ɹ�");
		map.put(FAILED, "������ʧ��");
		map.put(TO_LOGIN, "δ��¼");
	}

	
	/**
	 * ��ȡ״̬�������
	 * @param statusCode
	 * @return
	 */
	public static String name(int statusCode){
		return map.get(statusCode);
	}
	
}
