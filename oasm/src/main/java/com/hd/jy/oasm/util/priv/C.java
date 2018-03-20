package com.hd.jy.oasm.util.priv;

import java.nio.charset.Charset;

/**
 * constant������
 * 
 * @author admin
 *
 */
public class C {
	/** �������ֱ�־ */
	public static final String MSG_FLAG_JY = "JY";
	/** �ַ����� */
	public static Charset MSG_CHARSET = Charset.forName("GBK");
	
	/** �������ʧ�� */
	public static final int OP_FAILED = 0;
	/** ��������ɹ� */
	public static final int OP_SUCCESS = 1;
	/** ��������쳣 */
	public static final int OP_EXCEPTION = -1;
	/** ��������������˲��� */
	public static final int OP_TO_DO = -2;
	
	public static final String UNKNOWN = "UNKNOWN";
	public static final String NOT_FOUND = "NOT_FOUND";
	public static final String NOTHING = "_nothing";
	public static final String ERROR = "_error";
	public static final String COMMOA = ",";
	public static final String COMMOA_BANK = ", ";

	/** ��ͬ */
	public static final String J_EE = "eae";
	/** ���� */
	public static final String J_LL = "lal";
	/** ���϶� */
	public static final String J_GG = "gag";
	/** ����ͬ */
	public static final String J_NE = "nae";
	/** ��ߴ����ұߣ�Լ����0С�ڿ϶�1 */
	public static final String J_GL = "gal";
	/** ���С���ұߣ�Լ����0С�ڿ϶�1 */
	public static final String J_LG = "lag";

	public static final String REGEX_RELAT = J_EE + "|" + J_LL + "|" + J_GG
			+ "|" + J_NE + "|" + J_GL + "|" + J_LG;
}
