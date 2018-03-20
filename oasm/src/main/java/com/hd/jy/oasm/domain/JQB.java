package com.hd.jy.oasm.domain;
//监区表
public class JQB {
    private Integer id;

    private String jqmc;  //监区名称

    private Integer jqfzrxm;  //监区负责人姓名

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