package com.hd.jy.oasm.domain;


public class VPgbgList {
    private String taskId;//����id

    private String crimNo;//����

    private String type;//����

    private String deadline;//�������

    private String lastModif;//����޸�ʱ��

    private int status;//����״̬

    private Double score;//����

    private String levl;//�ȼ�

    private int stat;//����״̬

    private String xm;//����

    private String gyjqmc;//����

    private String jh;//����

    private String jhxm;//��������

    private String xjbh;//Э�̾���

    private String xjxm;//Э������
    
    private TCzsh tczsh;//�������洦��������
    
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