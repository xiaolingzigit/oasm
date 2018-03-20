package com.hd.jy.oasm.domain;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * 答题结果类
 * 
 * @author quite 映射文件:testMapper.xml 业务操作接口:TestMapper.java
 */
public class TestNote extends BasicModel {
	private String taskId; // 任务编号

	private double score; // 总分成绩

	private String levl; // 等级

	private String answer; // 答案

	private String result; // 结果

	private int dbStatus;

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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getDbStatus() {
		return dbStatus;
	}

	public void setDbStatus(int dbStatus) {
		this.dbStatus = dbStatus;
	}
}
