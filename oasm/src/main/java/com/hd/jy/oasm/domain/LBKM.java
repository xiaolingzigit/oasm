package com.hd.jy.oasm.domain;

import java.util.Date;
/**
 * 
 * @author quite
 *量表库，确定已启用，未启用，在研制量表
 */
public class LBKM {
    private String lbbh; //量表编号

    private String xindu; //信度

    private String xiaodu; //效度

    private String yzz;  //研制者

    private Date sj;  //时间

    private String jy; //监狱

    private String sm; //说明

    private String bz; //备注

    private int zt; //状态
    
    private int jd; //阶段
    
    //把所有使用到的量表放到量表库中
//    private LBRJ lbrj; //根据lbbh关联入监量表
//    
//    private LBRC lbrc; //根据lbbh关联日常量表
//    
//    private LBZQ lbzq; //根据lbbh关联中期量表
    
    private LBCJ lbcj; //根据lbbh关联出监量表
    
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