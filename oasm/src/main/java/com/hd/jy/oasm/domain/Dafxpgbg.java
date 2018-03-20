package com.hd.jy.oasm.domain;

import java.util.Date;

public class Dafxpgbg {
    private Long qh;

    private String zsxm;

    private Date bgscsj;

    private int dafxfz;

    private int status;

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

    public Date getBgscsj() {
        return bgscsj;
    }

    public void setBgscsj(Date bgscsj) {
        this.bgscsj = bgscsj;
    }

    public int getDafxfz() {
        return dafxfz;
    }

    public void setDafxfz(int dafxfz) {
        this.dafxfz = dafxfz;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}