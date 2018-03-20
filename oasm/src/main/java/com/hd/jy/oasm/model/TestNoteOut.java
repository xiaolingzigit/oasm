package com.hd.jy.oasm.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * 答题结果类
 * 
 * @author quite 映射文件:testMapper.xml 业务操作接口:TestMapper.java
 */
public class TestNoteOut extends BasicModel {
	private String taskId; // 任务编号

	private double score; // 总分成绩

	private String levl; // 等级

	private JsonArray answer; // 答案

	private JsonObject result; // 结果



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
