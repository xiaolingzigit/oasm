package com.hd.jy.oasm.model;

import com.google.gson.JsonElement;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.lsc.GsonUtil;
import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

public class Resp extends BasicModel {
	
	private int status;
	private String msg;
	private JsonElement data;
	private JsonElement page;

	public JsonElement getPage() {
		return page;
	}

	public void setPage(JsonElement page) {
		this.page = page;
	}

	public Resp() {
	}

	public Resp(int status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		if (data != null) {
			this.data = GsonUtil.objToJsonElement(data);
		} else {
			this.data = null;
		}
	}

	public Resp(int status, String msg, Object data, Page<?> page) {
		this.status = status;
		this.msg = msg;
		if (data != null) {
			this.data = GsonUtil.objToJsonElement(data);
		} else {
			this.data = null;
		}
		this.page = GsonUtil.objToJsonElement(page);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data == null ? null : GsonUtil.toJson(data);
	}

	public void setData(JsonElement data) {
		if (data != null) {
			this.data = GsonUtil.objToJsonElement(data);
		} else {
			this.data = null;
		}
	}

	public String toJson() {
		return GsonUtil.toJson(this);
	}

}
