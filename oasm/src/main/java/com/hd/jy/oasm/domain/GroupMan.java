package com.hd.jy.oasm.domain;

public class GroupMan {
	
    private int id;//���

    private String gmname;//ְ��

    private int states;//״̬  0���ã�1ʹ��

    private int zrid;//��ɫid

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