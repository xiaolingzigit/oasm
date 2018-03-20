package com.hd.jy.oasm.domain;
//选项表
public class LBxxb {
    private int id;

    private int tm;  //题目

    private String xxmc;  //选项名称

    private int fz;  //分数
 
    private int tsxx;  //特殊选项

    private int qh;   //囚号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTm() {
        return tm;
    }

    public void setTm(int tm) {
        this.tm = tm;
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