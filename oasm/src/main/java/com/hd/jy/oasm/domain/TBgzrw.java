package com.hd.jy.oasm.domain;

import java.util.Date;
//��������
public class TBgzrw {
    private int id;
 
    private int gzrwmc;  //��������

    private Date scsj;  //����ʱ��

    private Date kssj;  //��ʼʱ��

    private Date zjsj;  //��ֹʱ��

    private int status;  //���״̬

    private int gzlx;  //��������

    private int jcxx; //������Ϣ

    private int qh; //����

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGzrwmc() {
        return gzrwmc;
    }

    public void setGzrwmc(int gzrwmc) {
        this.gzrwmc = gzrwmc;
    }

    public Date getScsj() {
        return scsj;
    }

    public void setScsj(Date scsj) {
        this.scsj = scsj;
    }

    public Date getKssj() {
        return kssj;
    }

    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    public Date getZjsj() {
        return zjsj;
    }

    public void setZjsj(Date zjsj) {
        this.zjsj = zjsj;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGzlx() {
        return gzlx;
    }

    public void setGzlx(int gzlx) {
        this.gzlx = gzlx;
    }

    public int getJcxx() {
        return jcxx;
    }

    public void setJcxx(int jcxx) {
        this.jcxx = jcxx;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }
}