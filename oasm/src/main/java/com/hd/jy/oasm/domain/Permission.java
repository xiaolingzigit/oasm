package com.hd.jy.oasm.domain;

public class Permission {
    private int id;

    private String zpname;

    private int states;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZpname() {
        return zpname;
    }

    public void setZpname(String zpname) {
        this.zpname = zpname == null ? null : zpname.trim();
    }

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }
}