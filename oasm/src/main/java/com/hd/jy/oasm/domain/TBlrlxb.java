package com.hd.jy.oasm.domain;
//录入类型表
public class TBlrlxb {
    private int id;

    private String blx; //表类型

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlx() {
        return blx;
    }

    public void setBlx(String blx) {
        this.blx = blx == null ? null : blx.trim();
    }
}