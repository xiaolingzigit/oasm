package com.hd.jy.oasm.domain;
//Σ�յȼ��仯
import java.util.Date;

public class TBwxdjbh {
    private int id;

    private int wxfs;  //Σ�շ���

    private Date pgsj;	//����ʱ��

    private int qh;	//�ﷸ��Ϣ

    private int pglxb;	//�������ͱ�


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWxfs() {
        return wxfs;
    }

    public void setWxfs(int wxfs) {
        this.wxfs = wxfs;
    }

    public Date getPgsj() {
        return pgsj;
    }

    public void setPgsj(Date pgsj) {
        this.pgsj = pgsj;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public int getPglxb() {
        return pglxb;
    }

    public void setPglxb(int pglxb) {
        this.pglxb = pglxb;
    }
}