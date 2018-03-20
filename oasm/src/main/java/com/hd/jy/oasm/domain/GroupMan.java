package com.hd.jy.oasm.domain;

public class GroupMan {
	
    private int id;//编号

    private String gmname;//职务

    private int states;//状态  0不用，1使用

    private int zrid;//角色id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGmname() {
        return gmname;
    }

    public void setGmname(String gmname) {
        this.gmname = gmname == null ? null : gmname.trim();
    }

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }

	public int getZrid() {
		return zrid;
	}

	public void setZrid(int zrid) {
		this.zrid = zrid;
	}
   
}