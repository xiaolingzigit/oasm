package com.hd.jy.oasm.domain;
/***
 * ��������������������ƥ�䵵���Ļ������ݣ��õ����Ӻͷ��������ɵ�������
 * @author quite
 * ��Sjjgft.xml�е���
 *
 */
public class LBjcdafx {
    private int id; //���

    private String wd; //ά��

    private String yz; //����

    private int minfz; //��С����

    private int maxfz; //������

    private int fs; //����

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMinfz() {
        return minfz;
    }

    public void setMinfz(int minfz) {
        this.minfz = minfz;
    }

    public int getMaxfz() {
        return maxfz;
    }

    public void setMaxfz(int maxfz) {
        this.maxfz = maxfz;
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }
}