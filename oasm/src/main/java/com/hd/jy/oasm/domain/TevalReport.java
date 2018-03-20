package com.hd.jy.oasm.domain;

import java.util.Date;
/***
 * 评估报告表，用于对评估报告的统计，危险程度的统计
 * TODO
 * @author quite
 * @data 2017年12月26日
 * @see  
 *
 */
public class TevalReport {
    private String taskId; //总任务编号

    private String crimNo; //囚号

    private Double score; //总分

    private String levl; //危险等级

    private Date crTime; //报告生成时间

    private String report; //报告

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