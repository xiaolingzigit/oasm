package com.hd.jy.oasm.domain;

import java.util.Date;

public class Sjjtft {
    private String jtftid;//���

    private String qh;//����

    private String xm;//����

    private Date sj;//����ʱ��

    private String jg;//���

    private Integer zfs;//����

    private Integer zt;//״̬

    public String getJtftid() {
        return jtftid;
    }

    public void setJtftid(String jtftid) {
        this.jtftid = jtftid == null ? null : jtftid.trim();
    }

    public String getQh() {
        return qh;
    }

    public void setQh(String qh) {
        this.qh = qh == null ? null : qh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg == null ? null : jg.trim();
    }

    public Integer getZfs() {
        return zfs;
    }

    public void setZfs(Integer zfs) {
        this.zfs = zfs;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }
}