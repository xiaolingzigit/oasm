package com.hd.jy.oasm.model.pad;

import com.hd.jy.oasm.util.lsc.GsonUtil;
import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

public class CodeMsg extends BasicModel {
	private int code;
	private String msg;
	private String data;

	public CodeMsg(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		setData(data);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(Object data) {
		if (data != null) {
			this.data = GsonUtil.toJson(data);
		} else {
			this.data = null;
		}
	}
}
