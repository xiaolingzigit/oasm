package com.hd.jy.oasm.model;

import com.google.gson.JsonElement;
import com.hd.jy.oasm.domain.Task;
import com.hd.jy.oasm.util.lsc.GsonUtil;

public class JsonResp {

	private String status;
	private String msg;
	private JsonElement data;

	public JsonResp() {
	}

	public JsonResp(String status, String msg, JsonElement data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public JsonElement getData() {
		return data;
	}

	public void setData(JsonElement data) {
		this.data = data;
	}

	public static void main(String[] args) {

		JsonResp jrspJsonResp = GsonUtil
				.toInstance(
						"{'status':'200','msg':'成功','data':{'taskId':123,'crimNo':null,'type':null,'taskBasis':null,'taskDescrib':null,'deadline':null,'copNo1':null,'copNo2':null,'creator':null,'createTime':null,'lastModif':null,'modifier':null,'status':0,'operation':null}}",
						JsonResp.class);

		System.out.println(GsonUtil.toInstance(
				jrspJsonResp.getData().toString(), Task.class).getTaskId());

		System.out.println(GsonUtil.toJson(new JsonResp("200", "成功", GsonUtil
				.objToJsonElement("wwww"))));
	}

}
