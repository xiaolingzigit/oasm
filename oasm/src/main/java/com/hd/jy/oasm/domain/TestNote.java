package com.hd.jy.oasm.domain;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * ��������
 * 
 * @author quite ӳ���ļ�:testMapper.xml ҵ������ӿ�:TestMapper.java
 */
public class TestNote extends BasicModel {
	private String taskId; // ������

	private double score; // �ֳܷɼ�

	private String levl; // �ȼ�

	private String answer; // ��

	private String result; // ���

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
