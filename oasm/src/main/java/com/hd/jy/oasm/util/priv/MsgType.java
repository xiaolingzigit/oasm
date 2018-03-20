package com.hd.jy.oasm.util.priv;

import com.hd.jy.oasm.util.lsc.DataUtil;

public class MsgType {

	/** 连接控制报文 */
	public static final String TOUCH = "oasm";
	/** 结构性访谈-入监 */
	public static final String TALK_IN = "b1";
	/** 结构性访谈-中期 */
	public static final String TALK_MID = "b2";
	/** 结构性访谈-出监 */
	public static final String TALK_OUT = "b3";
	/** 行为观察-入监 */
	public static final String BEHAV_IN = "c1"; // behavior observation
	/** 行为观察-日常 */
	public static final String BEHAV_DLY = "c2";
	/** 行为观察-中期 */
	public static final String BEHAV_MID = "c3";
	/** 行为观察-出监 */
	public static final String BEHAV_OUT = "c4";
	/**COPA-PI*/
	public static final String MT_COPA_PI = "dc1";
	/** SCL-90 */
	public static final String MT_SCL_90 = "ds1";
	/** 新收押罪犯心理测试 */
	public static final String MT_NEW_IN = "dx";
	/** 社会适应性心里测试 */
	public static final String MT_OUT = "dsa";
	
	/**警员信息&囚犯信息 */
	public static final String COP_CRIM_RELAT = "si1";
	
	/** 警员信息 */
	public static final String COP_INFO = "pol";

	/** 囚犯信息 */
	public static final String CRIM_INFO = "cri";

	/** 断开连接 */
	public static final String END_CONN = "end";

	/** 更新APP */
	public static final String UPDATE_APP = "gx";

	/** 获取待办任务（即发布，未完成的） */
	public static final String GET_TASK = "rw";
	
	/**登录*/
	public static final String LOGIN = "lgin";
	
	/**TOKEN*/
	public static final String TOKEN = "tkn";
	
	/**注销登录*/
	public static final String LOGOUT = "lgot";

	/**异常报文*/
	public static final String ERROR = "err";
	
	
	/**
	 * 获取报文中的报文类型id=10,len=4
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
	 * 获取报文中的报文类型id=10,len=4
	 * 
	 * @param msgData
	 * @return
	 */
	public static String typeName(byte[] msgData) {
		return typeName(type(msgData));
	}

	/**
	 * 根据报文类型代码获取其对应名称
	 * 
	 * @param msgTypeCode
	 * @return
	 */
	public static String typeName(String msgTypeCode) {

		switch (msgTypeCode) {
		case TOUCH:
			return "连接控制报文";

		case TALK_IN:
			return "结构性访谈-入监";

		case TALK_MID:
			return "结构性访谈-中期";

		case TALK_OUT:
			return "结构性访谈-出监";

		case BEHAV_IN:
			return "行为观察-入监";

		case BEHAV_DLY:
			return "行为观察-日常";

		case BEHAV_MID:
			return "行为观察-中期";

		case BEHAV_OUT:
			return "行为观察-出监";

		case MT_COPA_PI:
			return "COPA-1";

		case MT_SCL_90:
			return "SCL-90";

		case MT_NEW_IN:
			return "新收押罪犯心理测试";

		case MT_OUT:
			return "社会适应性心里测试";

		case COP_CRIM_RELAT:
			return "警员信息&囚犯信息,关系";

		case COP_INFO:
			return "警员信息";

		case CRIM_INFO:
			return "囚犯信息";

		case END_CONN:
			return "断开连接";

		case UPDATE_APP:
			return "更新APP";

		case GET_TASK:
			return "获取任务（即发布，未完成的）";
			
		case LOGIN:
			return "登录";
			
		case TOKEN:
			return "TOKEN验证";
			
		case LOGOUT:
			return "注销登录";
			
		case ERROR:
			return "异常报文";

		default:
			return "UNKNOWN";
		}
	}

}
