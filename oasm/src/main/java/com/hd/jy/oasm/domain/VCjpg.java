package com.hd.jy.oasm.domain;

public class VCjpg {
    private String cjwxdj;

    private Integer cjsl;

    public String getCjwxdj() {
        return cjwxdj;
    }

    public void setCjwxdj(String cjwxdj) {
        this.cjwxdj = cjwxdj == null ? null : cjwxdj.trim();
    }

    public Integer getCjsl() {
        return cjsl;
    }

    public void setCjsl(Integer cjsl) {
        this.cjsl = cjsl;
    }
}