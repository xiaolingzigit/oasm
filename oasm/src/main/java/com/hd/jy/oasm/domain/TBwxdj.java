package com.hd.jy.oasm.domain;
//Σ�յȼ�
public class TBwxdj {
    private int id;

    private String wxdj; //Σ�յȼ�

    private int qh;  //�ﷸ��Ϣ

    private int pglxb;  //�������ͱ�

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxdj() {
        return wxdj;
    }

    public void setWxdj(String wxdj) {
        this.wxdj = wxdj == null ? null : wxdj.trim();
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public int getPglxb() {
        return pglxb;
    }

    public void setPglxb(int pglxb) {
        this.pglxb = pglxb;
    }
}