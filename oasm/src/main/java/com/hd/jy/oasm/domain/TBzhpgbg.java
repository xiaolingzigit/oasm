package com.hd.jy.oasm.domain;
//�ۺ���������
public class TBzhpgbg {
    private int id;

    private int jdfs;	//���Է���

    private int pgfs;	//��������

    private String wxdj;	//Σ�յȼ�

    private String wxqx;	//Σ������

    private String sjjx;	//���ݽ���

    private String zdbj;	//�ص���

    private int qh;	//�ﷸ��Ϣ

    private int pglxb;	//�ص���

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJdfs() {
        return jdfs;
    }

    public void setJdfs(int jdfs) {
        this.jdfs = jdfs;
    }

    public int getPgfs() {
        return pgfs;
    }

    public void setPgfs(int pgfs) {
        this.pgfs = pgfs;
    }

    public String getWxdj() {
        return wxdj;
    }

    public void setWxdj(String wxdj) {
        this.wxdj = wxdj == null ? null : wxdj.trim();
    }

    public String getWxqx() {
        return wxqx;
    }

    public void setWxqx(String wxqx) {
        this.wxqx = wxqx == null ? null : wxqx.trim();
    }

    public String getSjjx() {
        return sjjx;
    }

    public void setSjjx(String sjjx) {
        this.sjjx = sjjx == null ? null : sjjx.trim();
    }

    public String getZdbj() {
        return zdbj;
    }

    public void setZdbj(String zdbj) {
        this.zdbj = zdbj == null ? null : zdbj.trim();
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