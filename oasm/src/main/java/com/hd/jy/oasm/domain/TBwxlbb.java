package com.hd.jy.oasm.domain;
//Σ������
public class TBwxlbb {
    private int id;

    private String wxdjlb;  //Σ�յȼ����

    private int qh;	//�ﷸ��Ϣ

    private int pglxb; //�������ͱ�

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxdjlb() {
        return wxdjlb;
    }

    public void setWxdjlb(String wxdjlb) {
        this.wxdjlb = wxdjlb == null ? null : wxdjlb.trim();
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