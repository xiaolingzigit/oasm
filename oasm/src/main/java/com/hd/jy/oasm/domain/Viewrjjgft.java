package com.hd.jy.oasm.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @author quite
 *入监行为观察视图
 *
 *jgft的映射文件为：Viewftjg.xml
 *xwgc的映射文件为：Viewxwgc.xml
 *
 *统一的业务接口为: ViewftjgAndxwgcDao
 *
 *
 */
public class Viewrjjgft {
    private String qh;//囚号

    private String xm;//姓名

    private String gyjq; //关押监区

    private Date sj;//时间

    private int fs; //总分

    private String jhxm; //警号姓名

    private String ftzt; //访谈状态

    private BigDecimal rjftid; //事件编号

    private String jh;//警号

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

    public BigDecimal getRjftid() {
        return rjftid;
    }

    public void setRjftid(BigDecimal rjftid) {
        this.rjftid = rjftid;
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh == null ? null : jh.trim();
    }
}