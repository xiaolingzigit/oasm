package com.hd.jy.oasm.domain;
//危险等级
public class TBwxdj {
    private int id;

    private String wxdj; //危险等级

    private int qh;  //罪犯信息

    private int pglxb;  //评估类型表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxdj() {
        return wxdj;
    }

    public void setWxdj(String wxdj) {
        this.wxdj = wxdj == null ? null : wxdj.trim();
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