package com.hd.jy.oasm.domain;

public class Lbdafx {
    private int xh;   //���

    private String sjxmc;  //����������

    private String yz;  //����

    private Short yzfz;  //���ӷ�ֵ

    private String sjxbm;  //���ݱ�ţ���Ӧ������������ֶ����������ֶ�������������Ƶķ�ֵ��������

    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public String getSjxmc() {
        return sjxmc;
    }

    public void setSjxmc(String sjxmc) {
        this.sjxmc = sjxmc == null ? null : sjxmc.trim();
    }

    public String getYz() {
        return yz;
    }

    public void setYz(String yz) {
        this.yz = yz == null ? null : yz.trim();
    }

    public Short getYzfz() {
        return yzfz;
    }

    public void setYzfz(Short yzfz) {
        this.yzfz = yzfz;
    }

    public String getSjxbm() {
        return sjxbm;
    }

    public void setSjxbm(String sjxbm) {
        this.sjxbm = sjxbm == null ? null : sjxbm.trim();
    }
}