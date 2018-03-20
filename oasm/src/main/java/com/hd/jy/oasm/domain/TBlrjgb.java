package com.hd.jy.oasm.domain;
//录入结果表
public class TBlrjgb {
    private int id;

    private int lb; //关联录入类型

    private int tm; //关联题目

    private int xx;//关联选项

    private int fz; //分值

    private int zf; //总分

    private int qh; //关联罪犯

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

    public int getTm() {
        return tm;
    }

    public void setTm(int tm) {
        this.tm = tm;
    }

    public int getXx() {
        return xx;
    }

    public void setXx(int xx) {
        this.xx = xx;
    }

    public int getFz() {
        return fz;
    }

    public void setFz(int fz) {
        this.fz = fz;
    }

    public int getZf() {
        return zf;
    }

    public void setZf(int zf) {
        this.zf = zf;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }
}