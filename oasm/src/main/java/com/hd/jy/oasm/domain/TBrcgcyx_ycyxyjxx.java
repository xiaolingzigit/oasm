package com.hd.jy.oasm.domain;

import java.util.Date;

public class TBrcgcyx_ycyxyjxx {
    private int id;

    private String yjyy;

    private String yjlx;

    private Date yjsj;

    private int qh;

    private String pglxb;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYjyy() {
        return yjyy;
    }

    public void setYjyy(String yjyy) {
        this.yjyy = yjyy == null ? null : yjyy.trim();
    }

    public String getYjlx() {
        return yjlx;
    }

    public void setYjlx(String yjlx) {
        this.yjlx = yjlx == null ? null : yjlx.trim();
    }

    public Date getYjsj() {
        return yjsj;
    }

    public void setYjsj(Date yjsj) {
        this.yjsj = yjsj;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public String getPglxb() {
        return pglxb;
    }

    public void setPglxb(String pglxb) {
        this.pglxb = pglxb == null ? null : pglxb.trim();
    }
}