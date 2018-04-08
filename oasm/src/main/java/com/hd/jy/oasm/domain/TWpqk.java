package com.hd.jy.oasm.domain;

import java.util.Date;

public class TWpqk {
	//编号
    private Integer wpid;

    //极高危险人数
    private Integer jg;

    //高度危险人数
    private Integer gd;

    //中度危险人数
    private Integer zd;

    //低度危险人数
    private Integer dd;

    //监区
    private String jq;

    //监区总人数
    private Integer jqrs;

    //保存时间
    private Date sj;

    
    public Integer getWpid() {
        return wpid;
    }

    public void setWpid(Integer wpid) {
        this.wpid = wpid;
    }

    public Integer getJg() {
        return jg;
    }

    public void setJg(Integer jg) {
        this.jg = jg;
    }

    public Integer getGd() {
        return gd;
    }

    public void setGd(Integer gd) {
        this.gd = gd;
    }

    public Integer getZd() {
        return zd;
    }

    public void setZd(Integer zd) {
        this.zd = zd;
    }

    public Integer getDd() {
        return dd;
    }

    public void setDd(Integer dd) {
        this.dd = dd;
    }

    public String getJq() {
        return jq;
    }

    public void setJq(String jq) {
        this.jq = jq == null ? null : jq.trim();
    }

    public Integer getJqrs() {
        return jqrs;
    }

    public void setJqrs(Integer jqrs) {
        this.jqrs = jqrs;
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }
}