package com.hd.jy.oasm.domain;
//危险类别表
public class TBwxlbb {
    private int id;

    private String wxdjlb;  //危险等级类别

    private int qh;	//罪犯信息

    private int pglxb; //评估类型表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxdjlb() {
        return wxdjlb;
    }

    public void setWxdjlb(String wxdjlb) {
        this.wxdjlb = wxdjlb == null ? null : wxdjlb.trim();
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public int getPglxb() {
        return pglxb;
    }

    public void setPglxb(int pglxb) {
        this.pglxb = pglxb;
    }
}