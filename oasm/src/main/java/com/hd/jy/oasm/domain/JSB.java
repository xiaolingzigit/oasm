package com.hd.jy.oasm.domain;
//�����
public class JSB {
    private int id;

    private String jsmc;  //��������

    private int jsfzr;  //���Ḻ����

    private int jqmc;  //��������

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJsmc() {
        return jsmc;
    }

    public void setJsmc(String jsmc) {
        this.jsmc = jsmc == null ? null : jsmc.trim();
    }

    public int getJsfzr() {
        return jsfzr;
    }

    public void setJsfzr(int jsfzr) {
        this.jsfzr = jsfzr;
    }

    public int getJqmc() {
        return jqmc;
    }

    public void setJqmc(int jqmc) {
        this.jqmc = jqmc;
    }
}