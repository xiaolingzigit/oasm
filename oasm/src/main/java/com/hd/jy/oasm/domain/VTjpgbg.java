package com.hd.jy.oasm.domain;

import java.util.Date;

public class VTjpgbg {
    private String crimNo;//����

    private String xm;//����

    private String gyjqmc;//����

    private Double score;//����

    private String levl;//�ȼ�

    private Date crTime;//ʱ��
    
    private int sl;//����
    
    public int getSl() {
		return sl;
	}
    
    public void setSl(int sl) {
		this.sl = sl;
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

    public String getGyjqmc() {
        return gyjqmc;
    }

    public void setGyjqmc(String gyjqmc) {
        this.gyjqmc = gyjqmc == null ? null : gyjqmc.trim();
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
}