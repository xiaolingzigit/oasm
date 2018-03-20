package com.hd.jy.oasm.util.priv;

import java.nio.charset.Charset;

/**
 * constant常量类
 * 
 * @author admin
 *
 */
public class C {
	/** 报文区分标志 */
	public static final String MSG_FLAG_JY = "JY";
	/** 字符编码 */
	public static Charset MSG_CHARSET = Charset.forName("GBK");
	
	/** 请求操作失败 */
	public static final int OP_FAILED = 0;
	/** 请求操作成功 */
	public static final int OP_SUCCESS = 1;
	/** 请求操作异常 */
	public static final int OP_EXCEPTION = -1;
	/** 请求操作请求做此操作 */
	public static final int OP_TO_DO = -2;
	
	public static final String UNKNOWN = "UNKNOWN";
	public static final String NOT_FOUND = "NOT_FOUND";
	public static final String NOTHING = "_nothing";
	public static final String ERROR = "_error";
	public static final String COMMOA = ",";
	public static final String COMMOA_BANK = ", ";

	/** 相同 */
	public static final String J_EE = "eae";
	/** 均否定 */
	public static final String J_LL = "lal";
	/** 均肯定 */
	public static final String J_GG = "gag";
	/** 不相同 */
	public static final String J_NE = "nae";
	/** 左边大于右边，约定否定0小于肯定1 */
	public static final String J_GL = "gal";
	/** 左边小于右边，约定否定0小于肯定1 */
	public static final String J_LG = "lag";

	public static final String REGEX_RELAT = J_EE + "|" + J_LL + "|" + J_GG
			+ "|" + J_NE + "|" + J_GL + "|" + J_LG;
}
