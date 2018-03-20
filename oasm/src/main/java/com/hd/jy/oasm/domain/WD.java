package com.hd.jy.oasm.domain;
//维度表
public class WD {
    private String wdbm; //维度编码

    private String wd;  //维度

    private int xz; //选择

    public String getWdbm() {
        return wdbm;
    }

    public void setWdbm(String wdbm) {
        this.wdbm = wdbm == null ? null : wdbm.trim();
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd == null ? null : wd.trim();
    }

    public int getXz() {
        return xz;
    }

    public void setXz(int xz) {
        this.xz = xz;
    }
}