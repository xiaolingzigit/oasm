package com.hd.jy.oasm.domain;

import java.util.Date;

public class TLbqysy {
	
    private Integer qyspid;//������������

    private String pzid;//�������ñ���

    private Integer dxid;//���ö�����

    private String bpr;//������

    private Date bpsj;//����ʱ��

    private String spr;//������

    private Date spsj;//����ʱ��

    private String spzt;//����״̬��0 ûͨ����1 ͨ����

    private String zy;//ժҪ

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