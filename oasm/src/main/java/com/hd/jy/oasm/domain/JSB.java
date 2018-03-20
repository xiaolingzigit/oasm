package com.hd.jy.oasm.domain;
//监舍表
public class JSB {
    private int id;

    private String jsmc;  //监舍名称

    private int jsfzr;  //监舍负责人

    private int jqmc;  //监区名称

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