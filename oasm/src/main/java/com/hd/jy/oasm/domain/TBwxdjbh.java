package com.hd.jy.oasm.domain;
//危险等级变化
import java.util.Date;

public class TBwxdjbh {
    private int id;

    private int wxfs;  //危险分数

    private Date pgsj;	//评估时间

    private int qh;	//罪犯信息

    private int pglxb;	//评估类型表


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWxfs() {
        return wxfs;
    }

    public void setWxfs(int wxfs) {
        this.wxfs = wxfs;
    }

    public Date getPgsj() {
        return pgsj;
    }

    public void setPgsj(Date pgsj) {
        this.pgsj = pgsj;
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