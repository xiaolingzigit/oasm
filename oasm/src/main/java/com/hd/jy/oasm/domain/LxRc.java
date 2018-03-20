package com.hd.jy.oasm.domain;

public class LxRc {
    private Long qh;

    private String xm;

    private Integer zsfs;

    private String zsdj;

    private Integer ttfs;

    private String ttdj;

    private Integer kgfs;

    private String kgdj;

    public Long getQh() {
        return qh;
    }

    public void setQh(Long qh) {
        this.qh = qh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public Integer getZsfs() {
        return zsfs;
    }

    public void setZsfs(Integer zsfs) {
        this.zsfs = zsfs;
    }

    public String getZsdj() {
        return zsdj;
    }

    public void setZsdj(String zsdj) {
        this.zsdj = zsdj == null ? null : zsdj.trim();
    }

    public Integer getTtfs() {
        return ttfs;
    }

    public void setTtfs(Integer ttfs) {
        this.ttfs = ttfs;
    }

    public String getTtdj() {
        return ttdj;
    }

    public void setTtdj(String ttdj) {
        this.ttdj = ttdj == null ? null : ttdj.trim();
    }

    public Integer getKgfs() {
        return kgfs;
    }

    public void setKgfs(Integer kgfs) {
        this.kgfs = kgfs;
    }

    public String getKgdj() {
        return kgdj;
    }

    public void setKgdj(String kgdj) {
        this.kgdj = kgdj == null ? null : kgdj.trim();
    }
}