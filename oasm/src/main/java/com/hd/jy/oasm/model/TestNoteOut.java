package com.hd.jy.oasm.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * ��������
 * 
 * @author quite ӳ���ļ�:testMapper.xml ҵ������ӿ�:TestMapper.java
 */
public class TestNoteOut extends BasicModel {
	private String taskId; // ������

	private double score; // �ֳܷɼ�

	private String levl; // �ȼ�

	private JsonArray answer; // ��

	private JsonObject result; // ���



	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getLevl() {
		return levl;
	}

	public void setLevl(String levl) {
		this.levl = levl;
	}

	public JsonArray getAnswer() {
		return answer;
	}

	public void setAnswer(JsonArray answer) {
		this.answer = answer;
	}

	public JsonObject getResult() {
		return result;
	}

	public void setResult(JsonObject result) {
		this.result = result;
	}
}
