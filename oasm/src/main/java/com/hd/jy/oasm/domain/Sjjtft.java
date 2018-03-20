package com.hd.jy.oasm.domain;

import java.util.Date;

public class Sjjtft {
    private String jtftid;//编号

    private String qh;//囚号

    private String xm;//姓名

    private Date sj;//保存时间

    private String jg;//结果

    private Integer zfs;//分数

    private Integer zt;//状态

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