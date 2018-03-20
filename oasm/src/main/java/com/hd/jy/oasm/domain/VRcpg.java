package com.hd.jy.oasm.domain;

public class VRcpg {
    private String rcwxdj;

    private Integer rcsl;

    public String getRcwxdj() {
        return rcwxdj;
    }

    public void setRcwxdj(String rcwxdj) {
        this.rcwxdj = rcwxdj == null ? null : rcwxdj.trim();
    }

    public Integer getRcsl() {
        return rcsl;
    }

    public void setRcsl(Integer rcsl) {
        this.rcsl = rcsl;
    }
}