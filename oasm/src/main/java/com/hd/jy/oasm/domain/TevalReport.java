package com.hd.jy.oasm.domain;

import java.util.Date;
/***
 * ������������ڶ����������ͳ�ƣ�Σ�ճ̶ȵ�ͳ��
 * TODO
 * @author quite
 * @data 2017��12��26��
 * @see  
 *
 */
public class TevalReport {
    private String taskId; //��������

    private String crimNo; //����

    private Double score; //�ܷ�

    private String levl; //Σ�յȼ�

    private Date crTime; //��������ʱ��

    private String report; //����

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getCrimNo() {
        return crimNo;
    }

    public void setCrimNo(String crimNo) {
        this.crimNo = crimNo == null ? null : crimNo.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getLevl() {
        return levl;
    }

    public void setLevl(String levl) {
        this.levl = levl == null ? null : levl.trim();
    }

    public Date getCrTime() {
        return crTime;
    }

    public void setCrTime(Date crTime) {
        this.crTime = crTime;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report == null ? null : report.trim();
    }
}