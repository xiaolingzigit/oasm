package com.hd.jy.oasm.domain;
//¼�����ͱ�
public class TBlrlxb {
    private int id;

    private String blx; //������

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