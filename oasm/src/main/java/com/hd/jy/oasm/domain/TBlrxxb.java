package com.hd.jy.oasm.domain;
//¼��ѡ���
public class TBlrxxb {
    private int id;

    private int lrtm; //¼����Ŀ

    private String xxmc;//ѡ������

    private int fz;//��ֵ

    private int tsxx;//����ѡ��

    private int qh; //��������

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLrtm() {
        return lrtm;
    }

    public void setLrtm(int lrtm) {
        this.lrtm = lrtm;
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