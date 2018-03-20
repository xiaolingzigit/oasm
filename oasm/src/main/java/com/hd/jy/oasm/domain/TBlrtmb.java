package com.hd.jy.oasm.domain;
//录入题目
public class TBlrtmb {
    private int id;

    private String tm;//题目

    private int lrb;//关联录入表

    private int qh; //关联囚号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm == null ? null : tm.trim();
    }

    public int getLrb() {
        return lrb;
    }

    public void setLrb(int lrb) {
        this.lrb = lrb;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }
}