package com.hd.jy.oasm.domain;

import java.math.BigDecimal;

public class VPgbgWxlx {
    private String taskId;//������
    
    private String gyjq;

    private String crimNo;//����

    private String xm;//����

    private String crTime;//����ʱ��

    private Double score;//����

    private String levl;//�ȼ�

    private BigDecimal tt;//���ӷ���

    private BigDecimal xx;//���׷���

    private BigDecimal zfz;//�ٷ������

    private BigDecimal zs;//��ɱ����

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