package com.hd.jy.oasm.domain;

import java.math.BigDecimal;

public class SclBz {
    private String xmid;

    private String xm;

    private BigDecimal jz;

    private BigDecimal bzc;

    public String getXmid() {
        return xmid;
    }

    public void setXmid(String xmid) {
        this.xmid = xmid == null ? null : xmid.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public BigDecimal getJz() {
        return jz;
    }

    public void setJz(BigDecimal jz) {
        this.jz = jz;
    }

    public BigDecimal getBzc() {
        return bzc;
    }

    public void setBzc(BigDecimal bzc) {
        this.bzc = bzc;
    }
}