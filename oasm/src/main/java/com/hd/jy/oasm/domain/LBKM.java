package com.hd.jy.oasm.domain;

import java.util.Date;
/**
 * 
 * @author quite
 *����⣬ȷ�������ã�δ���ã�����������
 */
public class LBKM {
    private String lbbh; //������

    private String xindu; //�Ŷ�

    private String xiaodu; //Ч��

    private String yzz;  //������

    private Date sj;  //ʱ��

    private String jy; //����

    private String sm; //˵��

    private String bz; //��ע

    private int zt; //״̬
    
    private int jd; //�׶�
    
    //������ʹ�õ�������ŵ��������
//    private LBRJ lbrj; //����lbbh�����������
//    
//    private LBRC lbrc; //����lbbh�����ճ�����
//    
//    private LBZQ lbzq; //����lbbh������������
    
    private LBCJ lbcj; //����lbbh������������
    
	public int getJd() {
		return jd;
	}

	public void setJd(int jd) {
		this.jd = jd;
	}

//	public LBRJ getLbrj() {
//		return lbrj;
//	}
//
//	public void setLbrj(LBRJ lbrj) {
//		this.lbrj = lbrj;
//	}
//
//	public LBRC getLbrc() {
//		return lbrc;
//	}
//
//	public void setLbrc(LBRC lbrc) {
//		this.lbrc = lbrc;
//	}
//
//	public LBZQ getLbzq() {
//		return lbzq;
//	}
//
//	public void setLbzq(LBZQ lbzq) {
//		this.lbzq = lbzq;
//	}

	public LBCJ getLbcj() {
		return lbcj;
	}

	public void setLbcj(LBCJ lbcj) {
		this.lbcj = lbcj;
	}

	public String getLbbh() {
        return lbbh;
    }

    public void setLbbh(String lbbh) {
        this.lbbh = lbbh == null ? null : lbbh.trim();
    }

    public String getXindu() {
        return xindu;
    }

    public void setXindu(String xindu) {
        this.xindu = xindu == null ? null : xindu.trim();
    }

    public String getXiaodu() {
        return xiaodu;
    }

    public void setXiaodu(String xiaodu) {
        this.xiaodu = xiaodu == null ? null : xiaodu.trim();
    }

    public String getYzz() {
        return yzz;
    }

    public void setYzz(String yzz) {
        this.yzz = yzz == null ? null : yzz.trim();
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getJy() {
        return jy;
    }

    public void setJy(String jy) {
        this.jy = jy == null ? null : jy.trim();
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm == null ? null : sm.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public int getZt() {
        return zt;
    }

    public void setZt(int zt) {
        this.zt = zt;
    }
}