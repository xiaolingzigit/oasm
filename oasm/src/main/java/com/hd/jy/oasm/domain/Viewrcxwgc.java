package com.hd.jy.oasm.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @author quite
 *日常行为观察
 */
public class Viewrcxwgc {
    private String qh; //囚号

    private String xm; //姓名

    private String gyjq; //关押监区

    private Date sj;  //时间

    private int fs;  //分数

    private String jhxm; //警号姓名

    private String xwzt; //行为状态

    private BigDecimal rcgcid; //事件编号

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

    public String getXwzt() {
        return xwzt;
    }

    public void setXwzt(String xwzt) {
        this.xwzt = xwzt == null ? null : xwzt.trim();
    }

    public BigDecimal getRcgcid() {
        return rcgcid;
    }

    public void setRcgcid(BigDecimal rcgcid) {
        this.rcgcid = rcgcid;
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh == null ? null : jh.trim();
    }
}