package com.hd.jy.oasm.domain;

import java.math.BigDecimal;

public class VPgbgWxlx {
    private String taskId;//报告编号
    
    private String gyjq;

    private String crimNo;//囚号

    private String xm;//姓名

    private String crTime;//任务时间

    private Double score;//分数

    private String levl;//等级

    private BigDecimal tt;//脱逃分数

    private BigDecimal xx;//行凶分数

    private BigDecimal zfz;//再犯罪分数

    private BigDecimal zs;//自杀分数

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }
    
    public String getGyjq() {
		return gyjq;
	}
    
    public void setGyjq(String gyjq) {
		this.gyjq = gyjq == null ? null : gyjq.trim();
	}

    public String getCrimNo() {
        return crimNo;
    }

    public void setCrimNo(String crimNo) {
        this.crimNo = crimNo == null ? null : crimNo.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getCrTime() {
        return crTime;
    }

    public void setCrTime(String crTime) {
        this.crTime = crTime;
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

    public BigDecimal getTt() {
        return tt;
    }

    public void setTt(BigDecimal tt) {
        this.tt = tt;
    }

    public BigDecimal getXx() {
        return xx;
    }

    public void setXx(BigDecimal xx) {
        this.xx = xx;
    }

    public BigDecimal getZfz() {
        return zfz;
    }

    public void setZfz(BigDecimal zfz) {
        this.zfz = zfz;
    }

    public BigDecimal getZs() {
        return zs;
    }

    public void setZs(BigDecimal zs) {
        this.zs = zs;
    }
}