package com.hd.jy.oasm.domain;
//录入表
public class TBlrbb {
    private int id;

    private int qh;//关联罪犯信息

    private int lrlxb;//录入类型

    private int ztbz;//状态标识

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public int getLrlxb() {
        return lrlxb;
    }

    public void setLrlxb(int lrlxb) {
        this.lrlxb = lrlxb;
    }

    public int getZtbz() {
        return ztbz;
    }

    public void setZtbz(int ztbz) {
        this.ztbz = ztbz;
    }
}