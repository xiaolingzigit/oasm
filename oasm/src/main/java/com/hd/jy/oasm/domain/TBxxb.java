package com.hd.jy.oasm.domain;
//ѡ���
public class TBxxb {
    private int id;

    private String xx;	//ѡ��

    private int fs;  //��ֵ

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx == null ? null : xx.trim();
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }
}