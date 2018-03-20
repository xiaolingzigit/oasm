package com.hd.jy.oasm.domain;

import java.util.Date;

public class Vjtft {
	//sj_jtft表:编号，囚号，姓名，时间，结果，分数，状态
    private String jtftid;

    private String qh;

    private String xm;

    private Date sj;

    private String jg;

    private Integer zfs;

    private Integer zt;
    //在押表：监区,分监区，监狱
    private String gyjq;

    private String fjq;

    private String gyjy;
    //专教对象表：警号，警察姓名，协教，协教姓名
    private String jh;

    private String jhxm;

    private String xjbh;

    private String xjxm;

    public String getJtftid() {
        return jtftid;
    }

    public void setJtftid(String jtftid) {
        this.jtftid = jtftid == null ? null : jtftid.trim();
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

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg == null ? null : jg.trim();
    }

    public Integer getZfs() {
        return zfs;
    }

    public void setZfs(Integer zfs) {
        this.zfs = zfs;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public String getGyjq() {
        return gyjq;
    }

    public void setGyjq(String gyjq) {
        this.gyjq = gyjq == null ? null : gyjq.trim();
    }

    public String getFjq() {
        return fjq;
    }

    public void setFjq(String fjq) {
        this.fjq = fjq == null ? null : fjq.trim();
    }

    public String getGyjy() {
        return gyjy;
    }

    public void setGyjy(String gyjy) {
        this.gyjy = gyjy == null ? null : gyjy.trim();
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