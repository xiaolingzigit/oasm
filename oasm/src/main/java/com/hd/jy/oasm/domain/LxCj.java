package com.hd.jy.oasm.domain;

public class LxCj {
    private Long qh;

    private String xm;

    private Integer zfzfs;

    private String zfzdj;

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

    public Integer getZfzfs() {
        return zfzfs;
    }

    public void setZfzfs(Integer zfzfs) {
        this.zfzfs = zfzfs;
    }

    public String getZfzdj() {
        return zfzdj;
    }

    public void setZfzdj(String zfzdj) {
        this.zfzdj = zfzdj == null ? null : zfzdj.trim();
    }
}