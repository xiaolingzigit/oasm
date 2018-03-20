package com.hd.jy.oasm.domain;
//量表题目
public class LBtm {
    private int id;

    private int lb;  //关联的量表

    private String tm;  //题目

    private int zfxh;  //关联罪犯序号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLb() {
        return lb;
    }

    public void setLb(int lb) {
        this.lb = lb;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm == null ? null : tm.trim();
    }

    public int getZfxh() {
        return zfxh;
    }

    public void setZfxh(int zfxh) {
        this.zfxh = zfxh;
    }
}