package com.hd.jy.oasm.domain;
/***
 * 
 * @author quite
 *������������ ��Ӧ����ʱ��ʹ�õ��Ľṹ��̸����Ϊ�۲�ȴ������ʹ��
 *
 *�浽�������LBKM��
 */
public class LBCJ {
    private String cjlbbh; //����������

    private String fl; //����

    private String wd; //ά��

    private int yzbm; //���ӱ���

    private String yz; //����

    private int fs; //����

    private int qz; //Ȩ��
    
    private WD wdbm;  //����wd����ά�ȱ�

    public WD getWdbm() {
		return wdbm;
	}

	public void setWdbm(WD wdbm) {
		this.wdbm = wdbm;
	}

	public String getCjlbbh() {
        return cjlbbh;
    }

    public void setCjlbbh(String cjlbbh) {
        this.cjlbbh = cjlbbh == null ? null : cjlbbh.trim();
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl == null ? null : fl.trim();
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd == null ? null : wd.trim();
    }

    public int getYzbm() {
        return yzbm;
    }

    public void setYzbm(int yzbm) {
        this.yzbm = yzbm;
    }

    public String getYz() {
        return yz;
    }

    public void setYz(String yz) {
        this.yz = yz == null ? null : yz.trim();
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }

    public int getQz() {
        return qz;
    }

    public void setQz(int qz) {
        this.qz = qz;
    }
}