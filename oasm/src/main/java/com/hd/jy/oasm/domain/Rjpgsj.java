package com.hd.jy.oasm.domain;

public class Rjpgsj {
    private Long qh;

    private String zsxm;

    private String jq;

    private String lx;

    private String fx;

    private String yz;

    private Integer fs;

    public Long getQh() {
        return qh;
    }

    public void setQh(Long qh) {
        this.qh = qh;
    }

    public String getZsxm() {
        return zsxm;
    }

    public void setZsxm(String zsxm) {
        this.zsxm = zsxm == null ? null : zsxm.trim();
    }

    public String getJq() {
        return jq;
    }

    public void setJq(String jq) {
        this.jq = jq == null ? null : jq.trim();
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx == null ? null : lx.trim();
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx == null ? null : fx.trim();
    }

    public String getYz() {
        return yz;
    }

    public void setYz(String yz) {
        this.yz = yz == null ? null : yz.trim();
    }

    public Integer getFs() {
        return fs;
    }

    public void setFs(Integer fs) {
        this.fs = fs;
    }
}