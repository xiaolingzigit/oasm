package com.hd.jy.oasm.domain;

import java.util.Date;

public class TByqpcxtyc_ycyxyjxx {
    private int id;

    private String yjyy;

    private String yjlx;

    private Date yjsj;

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
}