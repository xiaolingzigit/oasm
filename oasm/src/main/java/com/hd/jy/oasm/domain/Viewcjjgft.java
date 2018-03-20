package com.hd.jy.oasm.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @author quite
 *出监结构访谈
 */
public class Viewcjjgft {
    private String qh;

    private String xm;

    private String gyjq;

    private Date sj;

    private int fs;

    private String jhxm;

    private String ftzt; //访谈状态

    private BigDecimal cjftid;

    private String jh;

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

    public String getGyjq() {
        return gyjq;
    }

    public void setGyjq(String gyjq) {
        this.gyjq = gyjq == null ? null : gyjq.trim();
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }

    public String getJhxm() {
        return jhxm;
    }

    public void setJhxm(String jhxm) {
        this.jhxm = jhxm == null ? null : jhxm.trim();
    }

    public String getFtzt() {
        return ftzt;
    }

    public void setFtzt(String ftzt) {
        this.ftzt = ftzt == null ? null : ftzt.trim();
    }

    public BigDecimal getCjftid() {
        return cjftid;
    }

    public void setCjftid(BigDecimal cjftid) {
        this.cjftid = cjftid;
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh == null ? null : jh.trim();
    }
}