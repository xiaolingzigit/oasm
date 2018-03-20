package com.hd.jy.oasm.domain;

import java.util.Date;

public class Tzyrymd {
    private String qh; //囚号

    private String xm; //姓名

    private Date sj; //时间

    private String gyjq; //监区

    private String gyjy; //监狱

    private String ftzt; //访谈状态

    private String xwzt; //行为状态

    private String xlzt; //心理状态

    private String jd; //阶段
    
    private Tjczjdx tjczjdx; //关联tjczjdx
    

    public Tjczjdx getTjczjdx() {
		return tjczjdx;
	}

	public void setTjczjdx(Tjczjdx tjczjdx) {
		this.tjczjdx = tjczjdx;
	}

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

    public String getGyjq() {
        return gyjq;
    }

    public void setGyjq(String gyjq) {
        this.gyjq = gyjq == null ? null : gyjq.trim();
    }

    public String getGyjy() {
        return gyjy;
    }

    public void setGyjy(String gyjy) {
        this.gyjy = gyjy == null ? null : gyjy.trim();
    }

    public String getFtzt() {
        return ftzt;
    }

    public void setFtzt(String ftzt) {
        this.ftzt = ftzt == null ? null : ftzt.trim();
    }

    public String getXwzt() {
        return xwzt;
    }

    public void setXwzt(String xwzt) {
        this.xwzt = xwzt == null ? null : xwzt.trim();
    }

    public String getXlzt() {
        return xlzt;
    }

    public void setXlzt(String xlzt) {
        this.xlzt = xlzt == null ? null : xlzt.trim();
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd == null ? null : jd.trim();
    }
}