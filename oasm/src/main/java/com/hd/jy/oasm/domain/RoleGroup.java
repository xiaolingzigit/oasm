package com.hd.jy.oasm.domain;

public class RoleGroup {
    private int id;

    private String rgname;

    private int zrid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRgname() {
        return rgname;
    }

    public void setRgname(String rgname) {
        this.rgname = rgname == null ? null : rgname.trim();
    }

    public int getZrid() {
        return zrid;
    }

    public void setZrid(int zrid) {
        this.zrid = zrid;
    }
}