package com.hd.jy.oasm.domain;

import java.util.Date;
/**
 * 用来替换原来的sj_dafx,显示档案分析数据列表
 * TODO
 * @author quite
 * @data 2017年12月23日
 * @see  映射文件Sjjgft.xml
 *
 */
public class ViewDafxjg {
    private String qh;  //囚号

    private String xm; //姓名

    private Date sj; //入监时间

    private String jq; //监区

    private String fjq; //分监区

    private String jy; //监狱

    private String taskId; //任务编号

    private Date deadline; //任务截止时间

    private Date crTime; //创建时间

    private Date lastModif; //最后修改时间

    private int status; //状态
    
    private String answer; //回答情况

    private String result; //报告，心理专用

    private Double score; //档案分析总分析

    private String levl; //档案分析出危险程度

    public String getQh() {
        return qh;
    }

    public void setQh(String qh) {
        this.qh = qh == null ? null : qh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getJq() {
        return jq;
    }

    public void setJq(String jq) {
        this.jq = jq == null ? null : jq.trim();
    }

    public String getFjq() {
        return fjq;
    }

    public void setFjq(String fjq) {
        this.fjq = fjq == null ? null : fjq.trim();
    }

    public String getJy() {
        return jy;
    }

    public void setJy(String jy) {
        this.jy = jy == null ? null : jy.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCrTime() {
        return crTime;
    }

    public void setCrTime(Date crTime) {
        this.crTime = crTime;
    }

    public Date getLastModif() {
        return lastModif;
    }

    public void setLastModif(Date lastModif) {
        this.lastModif = lastModif;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    
}