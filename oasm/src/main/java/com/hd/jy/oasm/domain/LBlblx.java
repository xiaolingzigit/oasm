package com.hd.jy.oasm.domain;
//��������
public class LBlblx {
    private int id;

    private String lblx;  //������������

    private int jd;  //�����׶�

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