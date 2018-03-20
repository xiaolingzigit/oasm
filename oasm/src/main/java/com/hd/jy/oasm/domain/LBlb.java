package com.hd.jy.oasm.domain;

import java.util.Date;
//量表
public class LBlb {
    private int id;

    private String lbmc;  //量表名称

    private int lblx;  //量表类型

    private Date scsj;  //生成时间

    private int status;  //标志（是否启用）

    private int zfxh;  //罪犯序号

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