package com.hd.jy.oasm.domain;
//ѡ���
public class LBxxb {
    private int id;

    private int tm;  //��Ŀ

    private String xxmc;  //ѡ������

    private int fz;  //����
 
    private int tsxx;  //����ѡ��

    private int qh;   //����

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTm() {
        return tm;
    }

    public void setTm(int tm) {
        this.tm = tm;
    }

    public String getXxmc() {
        return xxmc;
    }

    public void setXxmc(String xxmc) {
        this.xxmc = xxmc == null ? null : xxmc.trim();
    }

    public int getFz() {
        return fz;
    }

    public void setFz(int fz) {
        this.fz = fz;
    }

    public int getTsxx() {
        return tsxx;
    }

    public void setTsxx(int tsxx) {
        this.tsxx = tsxx;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }
}