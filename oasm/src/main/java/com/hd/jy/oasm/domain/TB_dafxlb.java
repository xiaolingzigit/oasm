package com.hd.jy.oasm.domain;

public class TB_dafxlb {
    private int id;

    private String blx;

    private String lb;

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

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb == null ? null : lb.trim();
    }
}