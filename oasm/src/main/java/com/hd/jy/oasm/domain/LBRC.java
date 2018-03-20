package com.hd.jy.oasm.domain;
/***
 * 
 * @author quite
 *日常因子量表 对应日常时所使用到的行为观察等答题情况使用
 *
 *存到到量表库LBKM中
 */
public class LBRC {
    private String rclbbh; //日常量表编号

    private String fl; //分类
 
    private String wd; //维度

    private int yzbm;//因子编码

    private String yz;//因子

    private int fs;//分数

    private int qz;//权重
    
    private WD wdbm;  //根据wd关联维度表

    public WD getWdbm() {
		return wdbm;
	}

	public void setWdbm(WD wdbm) {
		this.wdbm = wdbm;
	}

	public String getRclbbh() {
        return rclbbh;
    }

    public void setRclbbh(String rclbbh) {
        this.rclbbh = rclbbh == null ? null : rclbbh.trim();
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