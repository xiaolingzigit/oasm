package com.hd.jy.oasm.domain;
//题目表
public class TBtmb {
    private int id;

    private String tm;  //题目

    private String xx;  //选项

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

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx == null ? null : xx.trim();
    }
}