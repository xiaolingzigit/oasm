package com.hd.jy.oasm.domain;

public class VRjpg {
    private String rjwxdj;

    private Integer rjsl;

    public String getRjwxdj() {
        return rjwxdj;
    }

    public void setRjwxdj(String rjwxdj) {
        this.rjwxdj = rjwxdj == null ? null : rjwxdj.trim();
    }

    public Integer getRjsl() {
        return rjsl;
    }

    public void setRjsl(Integer rjsl) {
        this.rjsl = rjsl;
    }
}