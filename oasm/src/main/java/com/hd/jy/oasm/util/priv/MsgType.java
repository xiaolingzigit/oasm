package com.hd.jy.oasm.util.priv;

import com.hd.jy.oasm.util.lsc.DataUtil;

public class MsgType {

	/** ���ӿ��Ʊ��� */
	public static final String TOUCH = "oasm";
	/** �ṹ�Է�̸-��� */
	public static final String TALK_IN = "b1";
	/** �ṹ�Է�̸-���� */
	public static final String TALK_MID = "b2";
	/** �ṹ�Է�̸-���� */
	public static final String TALK_OUT = "b3";
	/** ��Ϊ�۲�-��� */
	public static final String BEHAV_IN = "c1"; // behavior observation
	/** ��Ϊ�۲�-�ճ� */
	public static final String BEHAV_DLY = "c2";
	/** ��Ϊ�۲�-���� */
	public static final String BEHAV_MID = "c3";
	/** ��Ϊ�۲�-���� */
	public static final String BEHAV_OUT = "c4";
	/**COPA-PI*/
	public static final String MT_COPA_PI = "dc1";
	/** SCL-90 */
	public static final String MT_SCL_90 = "ds1";
	/** ����Ѻ�ﷸ������� */
	public static final String MT_NEW_IN = "dx";
	/** �����Ӧ��������� */
	public static final String MT_OUT = "dsa";
	
	/**��Ա��Ϣ&������Ϣ */
	public static final String COP_CRIM_RELAT = "si1";
	
	/** ��Ա��Ϣ */
	public static final String COP_INFO = "pol";

	/** ������Ϣ */
	public static final String CRIM_INFO = "cri";

	/** �Ͽ����� */
	public static final String END_CONN = "end";

	/** ����APP */
	public static final String UPDATE_APP = "gx";

	/** ��ȡ�������񣨼�������δ��ɵģ� */
	public static final String GET_TASK = "rw";
	
	/**��¼*/
	public static final String LOGIN = "lgin";
	
	/**TOKEN*/
	public static final String TOKEN = "tkn";
	
	/**ע����¼*/
	public static final String LOGOUT = "lgot";

	/**�쳣����*/
	public static final String ERROR = "err";
	
	
	/**
	 * ��ȡ�����еı�������id=10,len=4
	 * 
	 * @param msgData
	 * @return
	 */
	public static String type(byte[] msgData) {
		// 14 = 2+8+4
		if (msgData.length < 14) {
			return null;
		}

		return new String(DataUtil.byteArrCut(msgData, 10, 4), C.MSG_CHARSET)
				.trim();
	}

	/**
	 * ��ȡ�����еı�������id=10,len=4
	 * 
	 * @param msgData
	 * @return
	 */
	public static String typeName(byte[] msgData) {
		return typeName(type(msgData));
	}

	/**
	 * ���ݱ������ʹ����ȡ���Ӧ����
	 * 
	 * @param msgTypeCode
	 * @return
	 */
	public static String typeName(String msgTypeCode) {

		switch (msgTypeCode) {
		case TOUCH:
			return "���ӿ��Ʊ���";

		case TALK_IN:
			return "�ṹ�Է�̸-���";

		case TALK_MID:
			return "�ṹ�Է�̸-����";

		case TALK_OUT:
			return "�ṹ�Է�̸-����";

		case BEHAV_IN:
			return "��Ϊ�۲�-���";

		case BEHAV_DLY:
			return "��Ϊ�۲�-�ճ�";

		case BEHAV_MID:
			return "��Ϊ�۲�-����";

		case BEHAV_OUT:
			return "��Ϊ�۲�-����";

		case MT_COPA_PI:
			return "COPA-1";

		case MT_SCL_90:
			return "SCL-90";

		case MT_NEW_IN:
			return "����Ѻ�ﷸ�������";

		case MT_OUT:
			return "�����Ӧ���������";

		case COP_CRIM_RELAT:
			return "��Ա��Ϣ&������Ϣ,��ϵ";

		case COP_INFO:
			return "��Ա��Ϣ";

		case CRIM_INFO:
			return "������Ϣ";

		case END_CONN:
			return "�Ͽ�����";

		case UPDATE_APP:
			return "����APP";

		case GET_TASK:
			return "��ȡ���񣨼�������δ��ɵģ�";
			
		case LOGIN:
			return "��¼";
			
		case TOKEN:
			return "TOKEN��֤";
			
		case LOGOUT:
			return "ע����¼";
			
		case ERROR:
			return "�쳣����";

		default:
			return "UNKNOWN";
		}
	}

}
