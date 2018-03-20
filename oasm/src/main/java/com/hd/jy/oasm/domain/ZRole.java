package com.hd.jy.oasm.domain;

public class ZRole {
    private int id;

    private String zrname;

    private int states;
    
    private GroupMan groupMan; //关联职务
    
    public GroupMan getGroupMan() {
		return groupMan;
	}

	public void setGroupMan(GroupMan groupMan) {
		this.groupMan = groupMan;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZrname() {
        return zrname;
    }

    public void setZrname(String zrname) {
        this.zrname = zrname == null ? null : zrname.trim();
    }

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }
}