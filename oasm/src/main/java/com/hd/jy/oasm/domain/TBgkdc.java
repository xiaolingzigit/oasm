package com.hd.jy.oasm.domain;
//�ܿضԲ�
public class TBgkdc {
    private int id;

    private String fyyj;  //��Ѻ���

    private String yzglb;  //��������

    private String ldgzb; //�Ͷ����첿

    private String jygzb; //�������첿

    private String xljzb; //������β�

    private String ynzcb; //������鲿

    private String xfzxb; //�̷�ִ�в�

    private String shwsb; //����������

    private int qh; //����

    private int pglxb; //��������

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFyyj() {
        return fyyj;
    }

    public void setFyyj(String fyyj) {
        this.fyyj = fyyj == null ? null : fyyj.trim();
    }

    public String getYzglb() {
        return yzglb;
    }

    public void setYzglb(String yzglb) {
        this.yzglb = yzglb == null ? null : yzglb.trim();
    }

    public String getLdgzb() {
        return ldgzb;
    }

    public void setLdgzb(String ldgzb) {
        this.ldgzb = ldgzb == null ? null : ldgzb.trim();
    }

    public String getJygzb() {
        return jygzb;
    }

    public void setJygzb(String jygzb) {
        this.jygzb = jygzb == null ? null : jygzb.trim();
    }

    public String getXljzb() {
        return xljzb;
    }

    public void setXljzb(String xljzb) {
        this.xljzb = xljzb == null ? null : xljzb.trim();
    }

    public String getYnzcb() {
        return ynzcb;
    }

    public void setYnzcb(String ynzcb) {
        this.ynzcb = ynzcb == null ? null : ynzcb.trim();
    }

    public String getXfzxb() {
        return xfzxb;
    }

    public void setXfzxb(String xfzxb) {
        this.xfzxb = xfzxb == null ? null : xfzxb.trim();
    }

    public String getShwsb() {
        return shwsb;
    }

    public void setShwsb(String shwsb) {
        this.shwsb = shwsb == null ? null : shwsb.trim();
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