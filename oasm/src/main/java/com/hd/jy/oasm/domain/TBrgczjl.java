package com.hd.jy.oasm.domain;

import java.util.Date;
//�˹�������¼
public class TBrgczjl {
    private int id;

    private int qh;  //�ﷸ��Ϣ

    private int jh;  //������Ϣ

    private Date sj;  //ʱ��

    private String fcjl;  //����¼

    private String xgx;  //�޸���

    private String gqz;  //��ǰֵ

    private String ghz;  //�ĺ�ֵ

    private int pglxb;  //�������ͱ�

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public int getJh() {
        return jh;
    }

    public void setJh(int jh) {
        this.jh = jh;
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getFcjl() {
        return fcjl;
    }

    public void setFcjl(String fcjl) {
        this.fcjl = fcjl == null ? null : fcjl.trim();
    }

    public String getXgx() {
        return xgx;
    }

    public void setXgx(String xgx) {
        this.xgx = xgx == null ? null : xgx.trim();
    }

    public String getGqz() {
        return gqz;
    }

    public void setGqz(String gqz) {
        this.gqz = gqz == null ? null : gqz.trim();
    }

    public String getGhz() {
        return ghz;
    }

    public void setGhz(String ghz) {
        this.ghz = ghz == null ? null : ghz.trim();
    }

    public int getPglxb() {
        return pglxb;
    }

    public void setPglxb(int pglxb) {
        this.pglxb = pglxb;
    }
}