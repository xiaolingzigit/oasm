package com.hd.jy.oasm.domain;
//Σ������
import java.util.Date;

public class TBwxys {
    private int id;

    private String yjyy;  //Ԥ��ԭ��

    private String yjlx;	//Ԥ������

    private Date yjsj;	//Ԥ��ʱ��

    private int wxyslx; //Σ����������

    private int qh; //�ﷸ��Ϣ

    private int pglxb;	//�������ͱ�

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYjyy() {
        return yjyy;
    }

    public void setYjyy(String yjyy) {
        this.yjyy = yjyy == null ? null : yjyy.trim();
    }

    public String getYjlx() {
        return yjlx;
    }

    public void setYjlx(String yjlx) {
        this.yjlx = yjlx == null ? null : yjlx.trim();
    }

    public Date getYjsj() {
        return yjsj;
    }

    public void setYjsj(Date yjsj) {
        this.yjsj = yjsj;
    }

    public int getWxyslx() {
        return wxyslx;
    }

    public void setWxyslx(int wxyslx) {
        this.wxyslx = wxyslx;
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