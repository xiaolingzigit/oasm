package com.hd.jy.oasm.domain;
//������
public class JQB {
    private Integer id;

    private String jqmc;  //��������

    private Integer jqfzrxm;  //��������������

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJqmc() {
        return jqmc;
    }

    public void setJqmc(String jqmc) {
        this.jqmc = jqmc == null ? null : jqmc.trim();
    }

    public Integer getJqfzrxm() {
        return jqfzrxm;
    }

    public void setJqfzrxm(Integer jqfzrxm) {
        this.jqfzrxm = jqfzrxm;
    }
}