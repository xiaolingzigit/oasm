package com.hd.jy.oasm.domain;
//ά�ȱ�
public class WD {
    private String wdbm; //ά�ȱ���

    private String wd;  //ά��

    private int xz; //ѡ��

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