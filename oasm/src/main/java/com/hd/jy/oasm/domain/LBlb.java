package com.hd.jy.oasm.domain;

import java.util.Date;
//����
public class LBlb {
    private int id;

    private String lbmc;  //��������

    private int lblx;  //��������

    private Date scsj;  //����ʱ��

    private int status;  //��־���Ƿ����ã�

    private int zfxh;  //�ﷸ���

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc == null ? null : lbmc.trim();
    }

    public int getLblx() {
        return lblx;
    }

    public void setLblx(int lblx) {
        this.lblx = lblx;
    }

    public Date getScsj() {
        return scsj;
    }

    public void setScsj(Date scsj) {
        this.scsj = scsj;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getZfxh() {
        return zfxh;
    }

    public void setZfxh(int zfxh) {
        this.zfxh = zfxh;
    }
}