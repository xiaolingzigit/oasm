package com.hd.jy.oasm.domain;

import java.util.Date;

public class TLbqysy {
	
    private Integer qyspid;//启用审批表编号

    private String pzid;//量表配置表编号

    private Integer dxid;//试用对象编号

    private String bpr;//报批人

    private Date bpsj;//报批时间

    private String spr;//审批人

    private Date spsj;//审批时间

    private String spzt;//审批状态（0 没通过，1 通过）

    private String zy;//摘要

    public Integer getQyspid() {
        return qyspid;
    }

    public void setQyspid(Integer qyspid) {
        this.qyspid = qyspid;
    }

    public String getPzid() {
        return pzid;
    }

    public void setPzid(String pzid) {
        this.pzid = pzid == null ? null : pzid.trim();
    }

    public Integer getDxid() {
        return dxid;
    }

    public void setDxid(Integer dxid) {
        this.dxid = dxid;
    }

    public String getBpr() {
        return bpr;
    }

    public void setBpr(String bpr) {
        this.bpr = bpr == null ? null : bpr.trim();
    }

    public Date getBpsj() {
        return bpsj;
    }

    public void setBpsj(Date bpsj) {
        this.bpsj = bpsj;
    }

    public String getSpr() {
        return spr;
    }

    public void setSpr(String spr) {
        this.spr = spr == null ? null : spr.trim();
    }

    public Date getSpsj() {
        return spsj;
    }

    public void setSpsj(Date spsj) {
        this.spsj = spsj;
    }

    public String getSpzt() {
        return spzt;
    }

    public void setSpzt(String spzt) {
        this.spzt = spzt == null ? null : spzt.trim();
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy == null ? null : zy.trim();
    }
}