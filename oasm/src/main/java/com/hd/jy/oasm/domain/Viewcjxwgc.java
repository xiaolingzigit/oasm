package com.hd.jy.oasm.domain;

import java.math.BigDecimal;
import java.util.Date;
/***
 * 
 * @author quite
 *������Ϊ�۲�
 */
public class Viewcjxwgc {
    private String qh;

    private String xm;

    private String gyjq; //��Ѻ״̬

    private Date sj;

    private int fs;

    private String jhxm;

    private String xwzt; //��Ϊ״̬

    private BigDecimal cjgcid; //�����¼����

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

    public BigDecimal getCjgcid() {
        return cjgcid;
    }

    public void setCjgcid(BigDecimal cjgcid) {
        this.cjgcid = cjgcid;
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh == null ? null : jh.trim();
    }
}