/**
 * @auto quite
 * 
 */
package com.hd.jy.oasm.domain;

import java.util.Date;

/**
 * TODO
 * @author quite
 * @data 2017年12月26日
 * @see   映射文件VPgbgListMapper.xml
 * 
 */
public class BGjbxx {
//	private String rwid;	//varchar(35) 	primary key,--评估任务id,报告编号(囚号_任务类型 _发布时间yyyymmddhhmm)
	private String jy;	//varchar(60) 	,--监狱
	private String jq;		//varchar(20) 	,--监区
	private String fjq;		//varchar(20) 	,--分监区
	private String qh;		//varchar(10) 	not null,--囚号						 
	private String xm;		//varchar(60)		,--姓名,根据zf_jbxx姓名和真实姓名获得	 
	private String xb;		//varchar(2)		,--性别*代码						
	private String bm;		//varchar(100)	,--别名,处理方式详见《评估报告数据项整理.2》
	private Date csrq;	//date			,--出生日期	
	private int nl;		//tinyint			,--年龄，根据出生日期和评估	 
	private String gj;		//varchar(50)		,--国籍/籍贯	
	private String mz;		//varchar(10)		,--民族*代码	
	private String whcd;	//varchar(20) 	,--现文化程度*代码
	private String zzmm;	//varchaR(50)		--政治面貌,社会关系表ZF_SHGX.MM
	private BGxxxx bgxxxx; //关联bgxxxx
	
	public BGxxxx getBgxxxx() {
		return bgxxxx;
	}
	public void setBgxxxx(BGxxxx bgxxxx) {
		this.bgxxxx = bgxxxx;
	}
	public String getJy() {
		return jy;
	}
	public void setJy(String jy) {
		this.jy = jy;
	}
	public String getJq() {
		return jq;
	}
	public void setJq(String jq) {
		this.jq = jq;
	}
	public String getFjq() {
		return fjq;
	}
	public void setFjq(String fjq) {
		this.fjq = fjq;
	}
	public String getQh() {
		return qh;
	}
	public void setQh(String qh) {
		this.qh = qh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getBm() {
		return bm;
	}
	public void setBm(String bm) {
		this.bm = bm;
	}
	public Date getCsrq() {
		return csrq;
	}
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}
	public int getNl() {
		return nl;
	}
	public void setNl(int nl) {
		this.nl = nl;
	}
	public String getGj() {
		return gj;
	}
	public void setGj(String gj) {
		this.gj = gj;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	
	
}
