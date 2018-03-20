package com.hd.jy.oasm.domain;
//量表类型
public class LBlblx {
    private int id;

    private String lblx;  //量表类型名称

    private int jd;  //关联阶段

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLblx() {
        return lblx;
    }

    public void setLblx(String lblx) {
        this.lblx = lblx == null ? null : lblx.trim();
    }

    public int getJd() {
        return jd;
    }

    public void setJd(int jd) {
        this.jd = jd;
    }
}