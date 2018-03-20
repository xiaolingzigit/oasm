package com.hd.jy.oasm.domain;
//危险类型
public class LXwsys {
    private int id;

    private String wsysmc; //危险类型名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWsysmc() {
        return wsysmc;
    }

    public void setWsysmc(String wsysmc) {
        this.wsysmc = wsysmc == null ? null : wsysmc.trim();
    }
}