package com.hd.jy.oasm.domain;

import java.util.Date;

public class TWpqk {
	//���
    private Integer wpid;

    //����Σ������
    private Integer jg;

    //�߶�Σ������
    private Integer gd;

    //�ж�Σ������
    private Integer zd;

    //�Ͷ�Σ������
    private Integer dd;

    //����
    private String jq;

    //����������
    private Integer jqrs;

    //����ʱ��
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