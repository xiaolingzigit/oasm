package com.hd.jy.oasm.domain;

public class Lbdafx {
    private int xh;   //序号

    private String sjxmc;  //数据项姓名

    private String yz;  //因子

    private Short yzfz;  //因子分值

    private String sjxbm;  //数据编号，对应档案分析表的字段名，根据字段名查出数据名称的分值或者因子

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