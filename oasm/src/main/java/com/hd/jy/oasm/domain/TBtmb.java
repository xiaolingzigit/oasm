package com.hd.jy.oasm.domain;
//��Ŀ��
public class TBtmb {
    private int id;

    private String tm;  //��Ŀ

    private String xx;  //ѡ��

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