package com.hd.jy.oasm.domain;
//改造方案
public class TBgzfa {
    private int id;

    private String ldgz; //劳动改造

    private String whxx; //文化学习

    private String zyjn; //职业技能

    private String xxhb; //思想汇报

    private String zzfk; //政治法规

    private String rcbx; //日常表现

    private int qh; //囚号

    private int pglxb; //评估类型表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLdgz() {
        return ldgz;
    }

    public void setLdgz(String ldgz) {
        this.ldgz = ldgz == null ? null : ldgz.trim();
    }

    public String getWhxx() {
        return whxx;
    }

    public void setWhxx(String whxx) {
        this.whxx = whxx == null ? null : whxx.trim();
    }

    public String getZyjn() {
        return zyjn;
    }

    public void setZyjn(String zyjn) {
        this.zyjn = zyjn == null ? null : zyjn.trim();
    }

    public String getXxhb() {
        return xxhb;
    }

    public void setXxhb(String xxhb) {
        this.xxhb = xxhb == null ? null : xxhb.trim();
    }

    public String getZzfk() {
        return zzfk;
    }

    public void setZzfk(String zzfk) {
        this.zzfk = zzfk == null ? null : zzfk.trim();
    }

    public String getRcbx() {
        return rcbx;
    }

    public void setRcbx(String rcbx) {
        this.rcbx = rcbx == null ? null : rcbx.trim();
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public int getPglxb() {
        return pglxb;
    }

    public void setPglxb(int pglxb) {
        this.pglxb = pglxb;
    }
}