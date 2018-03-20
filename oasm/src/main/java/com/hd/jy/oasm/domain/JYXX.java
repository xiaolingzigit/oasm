package com.hd.jy.oasm.domain;

import java.util.Date;
//警察信息表
public class JYXX {
    private String jh;

    private String xm; //警察姓名
    
    private String ma;  //密码

    private int zw;  //职务
    
    private GroupMan groupMan;
    
    private Date cjsj; //生成时间

    private Date scdlsj;  //wu:上次登录时间

    private int status; //状态

    private String jq;  //监区

    private String xjq; //分监区
    
    private int cnum; //别名，不需要映射
    
    private Tjczjdx tjczjdx; //关联专管对应表
    
    private String zwName; //别名，职务名字
    
    private String xb; //性别

    private Date sr; //生日

    private String bmh; //部门

    private String dz; //地址

    private String dh; //电话

    private String dzyj; //电子邮箱

    private String bz; //备注

    private Integer zt; //用于标识添加或者修改
    
	/**
	 * @return the xb
	 */
	public String getXb() {
		return xb;
	}

	/**
	 * @param xb the xb to set
	 */
	public void setXb(String xb) {
		this.xb = xb;
	}

	/**
	 * @return the sr
	 */
	public Date getSr() {
		return sr;
	}

	/**
	 * @param sr the sr to set
	 */
	public void setSr(Date sr) {
		this.sr = sr;
	}

	/**
	 * @return the bmh
	 */
	public String getBmh() {
		return bmh;
	}

	/**
	 * @param bmh the bmh to set
	 */
	public void setBmh(String bmh) {
		this.bmh = bmh;
	}

	/**
	 * @return the dz
	 */
	public String getDz() {
		return dz;
	}

	/**
	 * @param dz the dz to set
	 */
	public void setDz(String dz) {
		this.dz = dz;
	}

	/**
	 * @return the dh
	 */
	public String getDh() {
		return dh;
	}

	/**
	 * @param dh the dh to set
	 */
	public void setDh(String dh) {
		this.dh = dh;
	}

	/**
	 * @return the dzyj
	 */
	public String getDzyj() {
		return dzyj;
	}

	/**
	 * @param dzyj the dzyj to set
	 */
	public void setDzyj(String dzyj) {
		this.dzyj = dzyj;
	}

	/**
	 * @return the bz
	 */
	public String getBz() {
		return bz;
	}

	/**
	 * @param bz the bz to set
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}

	/**
	 * @return the zt
	 */
	public Integer getZt() {
		return zt;
	}

	/**
	 * @param zt the zt to set
	 */
	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getZwName() {
		return zwName;
	}

	public void setZwName(String zwName) {
		this.zwName = zwName;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public Tjczjdx getTjczjdx() {
		return tjczjdx;
	}

	public void setTjczjdx(Tjczjdx tjczjdx) {
		this.tjczjdx = tjczjdx;
	}

	public GroupMan getGroupMan() {
		return groupMan;
	}

	public void setGroupMan(GroupMan groupMan) {
		this.groupMan = groupMan;
	}

    /**
	 * @return the jh
	 */
	public String getJh() {
		return jh;
	}

	/**
	 * @param jh the jh to set
	 */
	public void setJh(String jh) {
		this.jh = jh;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}


	public int getZw() {
		return zw;
	}

	public void setZw(int zw) {
		this.zw = zw;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public Date getCjsj() {
		return cjsj;
	}

	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	public Date getScdlsj() {
		return scdlsj;
	}

	public void setScdlsj(Date scdlsj) {
		this.scdlsj = scdlsj;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getJq() {
		return jq;
	}

	public void setJq(String jq) {
		this.jq = jq;
	}

	public String getXjq() {
		return xjq;
	}

	public void setXjq(String xjq) {
		this.xjq = xjq;
	}
    
	
}