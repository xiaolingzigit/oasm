/**
 * @auto quite
 * 
 */
package com.hd.jy.oasm.domain;

import java.util.Date;

/**
 * TODO
 * @author quite
 * @data 2017��12��26��
 * @see   ӳ���ļ�VPgbgListMapper.xml
 * 
 */
public class BGjbxx {
//	private String rwid;	//varchar(35) 	primary key,--��������id,������(����_�������� _����ʱ��yyyymmddhhmm)
	private String jy;	//varchar(60) 	,--����
	private String jq;		//varchar(20) 	,--����
	private String fjq;		//varchar(20) 	,--�ּ���
	private String qh;		//varchar(10) 	not null,--����						 
	private String xm;		//varchar(60)		,--����,����zf_jbxx��������ʵ�������	 
	private String xb;		//varchar(2)		,--�Ա�*����						
	private String bm;		//varchar(100)	,--����,����ʽ�����������������������.2��
	private Date csrq;	//date			,--��������	
	private int nl;		//tinyint			,--���䣬���ݳ������ں�����	 
	private String gj;		//varchar(50)		,--����/����	
	private String mz;		//varchar(10)		,--����*����	
	private String whcd;	//varchar(20) 	,--���Ļ��̶�*����
	private String zzmm;	//varchaR(50)		--������ò,����ϵ��ZF_SHGX.MM
	private BGxxxx bgxxxx; //����bgxxxx
	
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
