package com.hd.jy.oasm.domain;
//���췽��
public class TBgzfa {
    private int id;

    private String ldgz; //�Ͷ�����

    private String whxx; //�Ļ�ѧϰ

    private String zyjn; //ְҵ����

    private String xxhb; //˼��㱨

    private String zzfk; //���η���

    private String rcbx; //�ճ�����

    private int qh; //����

    private int pglxb; //�������ͱ�

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLdgz() {
        return ldgz;
    }

    public void setLdgz(String ldgz) {
        this.ldgz = ldgz == null ? null : ldgz.trim();
    }

    public String getWhxx() {
        return whxx;
    }

    public void setWhxx(String whxx) {
        this.whxx = whxx == null ? null : whxx.trim();
    }

    public String getZyjn() {
        return zyjn;
    }

    public void setZyjn(String zyjn) {
        this.zyjn = zyjn == null ? null : zyjn.trim();
    }

    public String getXxhb() {
        return xxhb;
    }

    public void setXxhb(String xxhb) {
        this.xxhb = xxhb == null ? null : xxhb.trim();
    }

    public String getZzfk() {
        return zzfk;
    }

    public void setZzfk(String zzfk) {
        this.zzfk = zzfk == null ? null : zzfk.trim();
    }

    public String getRcbx() {
        return rcbx;
    }

    public void setRcbx(String rcbx) {
        this.rcbx = rcbx == null ? null : rcbx.trim();
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