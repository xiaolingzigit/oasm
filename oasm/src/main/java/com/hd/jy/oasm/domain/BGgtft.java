package com.hd.jy.oasm.domain;

/***
 * �ṹ��̸�ع����ӱ�
 * TODO
 * @author quite
 * @data 2018��1��2��
 * @see  ӳ���ļ�TestMapper.xml
 *
 */
public class BGgtft{
    private String rwid; //������
    
    private String qh; //����

    private int fs; //����

    private String wd; //ά��

    private String yz; //����

    public String getRwid() {
        return rwid;
    }

    public void setRwid(String rwid) {
        this.rwid = rwid == null ? null : rwid.trim();
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd == null ? null : wd.trim();
    }

    public String getYz() {
        return yz;
    }

    public void setYz(String yz) {
        this.yz = yz == null ? null : yz.trim();
    }

    public String getQh() {
        return qh;
    }

    public void setQh(String qh) {
        this.qh = qh == null ? null : qh.trim();
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }
}