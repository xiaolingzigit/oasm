package com.hd.jy.oasm.domain;

import java.util.Date;

public class TB_dafxlrjgb {
    private int id;

    private int qh;

    private String tm;

    private String xx;

    private Date lrrq;

    private int zf;

    private String sjfs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm == null ? null : tm.trim();
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx == null ? null : xx.trim();
    }

    public Date getLrrq() {
        return lrrq;
    }

    public void setLrrq(Date lrrq) {
        this.lrrq = lrrq;
    }

    public int getZf() {
        return zf;
    }

    public void setZf(int zf) {
        this.zf = zf;
    }

    public String getSjfs() {
        return sjfs;
    }

    public void setSjfs(String sjfs) {
        this.sjfs = sjfs == null ? null : sjfs.trim();
    }
}