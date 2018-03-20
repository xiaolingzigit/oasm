package com.hd.jy.oasm.domain;

import java.util.Date;
//人工操作记录
public class TBrgczjl {
    private int id;

    private int qh;  //罪犯信息

    private int jh;  //警察信息

    private Date sj;  //时间

    private String fcjl;  //封存记录

    private String xgx;  //修改项

    private String gqz;  //改前值

    private String ghz;  //改后值

    private int pglxb;  //评估类型表

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

    public int getJh() {
        return jh;
    }

    public void setJh(int jh) {
        this.jh = jh;
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getFcjl() {
        return fcjl;
    }

    public void setFcjl(String fcjl) {
        this.fcjl = fcjl == null ? null : fcjl.trim();
    }

    public String getXgx() {
        return xgx;
    }

    public void setXgx(String xgx) {
        this.xgx = xgx == null ? null : xgx.trim();
    }

    public String getGqz() {
        return gqz;
    }

    public void setGqz(String gqz) {
        this.gqz = gqz == null ? null : gqz.trim();
    }

    public String getGhz() {
        return ghz;
    }

    public void setGhz(String ghz) {
        this.ghz = ghz == null ? null : ghz.trim();
    }

    public int getPglxb() {
        return pglxb;
    }

    public void setPglxb(int pglxb) {
        this.pglxb = pglxb;
    }
}