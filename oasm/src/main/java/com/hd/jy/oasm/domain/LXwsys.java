package com.hd.jy.oasm.domain;
//Σ������
public class LXwsys {
    private int id;

    private String wsysmc; //Σ����������

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