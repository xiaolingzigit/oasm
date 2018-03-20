package com.hd.jy.oasm.model.pad;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicMsg;
import com.hd.jy.oasm.util.priv.C;

public class OasmMsg extends BasicMsg {

	public OasmMsg() {
		
	}

	public OasmMsg(String msgType, CodeMsg codeMsg) {
		setFlag(C.MSG_FLAG_JY);
		setMsgType(msgType);
		setContent(codeMsg == null ? "" : codeMsg);
	}

	/**
	 * 将报文转化为明文字符串
	 * 
	 * @param msgData
	 * @return
	 */
	public static String toString(byte[] msgData) {
		if (msgData == null) {
			return null;
		}

		return new String(msgData, C.MSG_CHARSET);
	}

	public byte[] toBytes() {
		return super.toBytes(C.MSG_CHARSET);
	}
	
	public OasmMsg fromBytes(byte[] data) {
		super.fromBytes(data, C.MSG_CHARSET);
		return this;
	}
}
