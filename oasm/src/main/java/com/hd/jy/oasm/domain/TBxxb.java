package com.hd.jy.oasm.domain;
//选项表
public class TBxxb {
    private int id;

    private String xx;	//选项

    private int fs;  //分值

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