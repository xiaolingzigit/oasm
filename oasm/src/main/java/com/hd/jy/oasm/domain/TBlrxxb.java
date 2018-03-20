package com.hd.jy.oasm.domain;
//录入选项表
public class TBlrxxb {
    private int id;

    private int lrtm; //录入题目

    private String xxmc;//选项名称

    private int fz;//分值

    private int tsxx;//特殊选项

    private int qh; //关联囚号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLrtm() {
        return lrtm;
    }

    public void setLrtm(int lrtm) {
        this.lrtm = lrtm;
    }

    public String getXxmc() {
        return xxmc;
    }

    public void setXxmc(String xxmc) {
        this.xxmc = xxmc == null ? null : xxmc.trim();
    }

    public int getFz() {
        return fz;
    }

    public void setFz(int fz) {
        this.fz = fz;
    }

    public int getTsxx() {
        return tsxx;
    }

    public void setTsxx(int tsxx) {
        this.tsxx = tsxx;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }
}