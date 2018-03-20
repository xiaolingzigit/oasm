package com.hd.jy.oasm.domain;


public class VPgbgList {
    private String taskId;//任务id

    private String crimNo;//囚号

    private String type;//类型

    private String deadline;//完成期限

    private String lastModif;//最后修改时间

    private int status;//任务状态

    private Double score;//分数

    private String levl;//等级

    private int stat;//报告状态

    private String xm;//姓名

    private String gyjqmc;//监区

    private String jh;//警号

    private String jhxm;//警察姓名

    private String xjbh;//协教警号

    private String xjxm;//协教姓名
    
    private TCzsh tczsh;//评估报告处置审核意见
    
    public void setTczsh(TCzsh tczsh) {
		this.tczsh = tczsh;
	}
    public TCzsh getTczsh() {
		return tczsh;
	}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline  == null ? null : deadline.trim();
    }

    public String getLastModif() {
        return lastModif;
    }

    public void setLastModif(String lastModif) {
        this.lastModif = lastModif  == null ? null : lastModif.trim();
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

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getGyjqmc() {
        return gyjqmc;
    }

    public void setGyjqmc(String gyjqmc) {
        this.gyjqmc = gyjqmc == null ? null : gyjqmc.trim();
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh == null ? null : jh.trim();
    }

    public String getJhxm() {
        return jhxm;
    }

    public void setJhxm(String jhxm) {
        this.jhxm = jhxm == null ? null : jhxm.trim();
    }

    public String getXjbh() {
        return xjbh;
    }

    public void setXjbh(String xjbh) {
        this.xjbh = xjbh == null ? null : xjbh.trim();
    }

    public String getXjxm() {
        return xjxm;
    }

    public void setXjxm(String xjxm) {
        this.xjxm = xjxm == null ? null : xjxm.trim();
    }
}