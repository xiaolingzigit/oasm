package com.hd.jy.oasm.domain;

public class DafxjgView {
	//档案分值由结果自动生成
    private String qh; //囚号

    private String zsxm;//姓名

    private String xq;//刑期

    private String fylx;//分押类型

    private String lbc;//老病残

    private String ypzm;//原判罪名

    private String csrq;//出生日期

    private String nl;//年龄

    private String xb;//性别

    private String gj;//国籍

    private String bqzw;//埔前职务

    private String bqwhcd;//捕前文化程度

    private String fzss;//犯罪事实

    private String ypxq;//原判刑期

    private String fzscnf;//犯罪时成年否

    private byte[] scsj;//结果生成时间
    
    private String mz;//民族

    public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getQh() {
        return qh;
    }

    public void setQh(String qh) {
        this.qh = qh == null ? null : qh.trim();
    }

    public String getZsxm() {
        return zsxm;
    }

    public void setZsxm(String zsxm) {
        this.zsxm = zsxm == null ? null : zsxm.trim();
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq == null ? null : xq.trim();
    }

    public String getFylx() {
        return fylx;
    }

    public void setFylx(String fylx) {
        this.fylx = fylx == null ? null : fylx.trim();
    }

    public String getLbc() {
        return lbc;
    }

    public void setLbc(String lbc) {
        this.lbc = lbc == null ? null : lbc.trim();
    }

    public String getYpzm() {
        return ypzm;
    }

    public void setYpzm(String ypzm) {
        this.ypzm = ypzm == null ? null : ypzm.trim();
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq == null ? null : csrq.trim();
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl == null ? null : nl.trim();
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    public String getGj() {
        return gj;
    }

    public void setGj(String gj) {
        this.gj = gj == null ? null : gj.trim();
    }

    public String getBqzw() {
        return bqzw;
    }

    public void setBqzw(String bqzw) {
        this.bqzw = bqzw == null ? null : bqzw.trim();
    }

    public String getBqwhcd() {
        return bqwhcd;
    }

    public void setBqwhcd(String bqwhcd) {
        this.bqwhcd = bqwhcd == null ? null : bqwhcd.trim();
    }

    public String getFzss() {
        return fzss;
    }

    public void setFzss(String fzss) {
        this.fzss = fzss == null ? null : fzss.trim();
    }

    public String getYpxq() {
        return ypxq;
    }

    public void setYpxq(String ypxq) {
        this.ypxq = ypxq == null ? null : ypxq.trim();
    }

    public String getFzscnf() {
        return fzscnf;
    }

    public void setFzscnf(String fzscnf) {
        this.fzscnf = fzscnf == null ? null : fzscnf.trim();
    }

    public byte[] getScsj() {
        return scsj;
    }

    public void setScsj(byte[] scsj) {
        this.scsj = scsj;
    }
}