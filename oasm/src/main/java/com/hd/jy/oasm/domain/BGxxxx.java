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
 * @see  ӳ���ļ�VPgbgListMapper.xml
 * 
 */
public class BGxxxx {
//	private String rwid; //varchar(35) 	primary key,  --��������id,������(����_�������� _����ʱ��yyyymmddhhmm)
	private String qh; //varchar(10)	,--����
	//--�����������t_eval_report
	//--pgsj	//date			,--����ʱ��
	//--pgfs	//varchar(10)		,--��������
	//--wzdj	//varchar(20)		,--Σ�յȼ�
//	private String wxxpgfs;	//varchar(max)	,--Σ������������
	//-----------------------------------------
	private String bqzy; //varchar(100), --��ǰְҵ
	private String zjlx; //varchar(100), --֤������,�ַ���ƴ��,���ŷָ�*����
	private String sg; //varchar(5) , --���cm
	private String tz; // varchar(5), --����kg
	private String htzk; //varchar(20), --����״��zf_hybd.hyzk*����
	private String hjdz; //varchar(200), --����סַ
	private String jtzz; //varchar(200), --��ͥסַ
	private String hygx; //varchar(20), --������ϵ,zf_hybd.hyzk*���룬ȡ����
	private String jtzc; //varchar(100),--��֧ͥ��
	private String jtbg; //varchar(100),--��ͥ���
	private String wcnfjtzk; // varchar(100),--δ���그��ͥ״��*����
	private String sfdszn; //varchar(5), --�Ƿ������Ů
	//----------------------------------------
	private String zmmc;    //varchar(100) 	,--��������zf_zm.zmmc��ƴ���ַ��������Ÿ���
	private Date rjrq; 	//date			,--�������zf_jbxx.rjrq
	private String fylx;	//varchar(10)		,--��Ѻ����zf_jbxx.fylx		
	private String gtfzlx;	//varchar(20)		,--��ͬ�����������zf_jbxx_fb.gtfzlx*��ͬ����������ʹ���
	private String bdlb;	//varchar(20)		,--�̷��䶯zf_xfzb_fb���ֵ���̷��䶯�������
	private String xq;		//varchar(6)		,--����,ȡ�����޸����ڵġ�ӳ����ַ�����zf_xfzbx.xq��ʽ��9995,����,9996����,9997����,yymmdd������
	private String aflb;	//varchar(50)		,--�������zf_xfzb.aflb*����������
	private String bznx;	//varchar(6) 		,--��������Ȩ������zf_xfzb.bznx,99����/yymmdd
	private String qzcj;	//varchar(2)		,--�Ƿ��������
	private String xzjx;	//varchar(2)		,--�Ƿ����Ƽ���zf_xfzb.xzjx,0��1��
	private String fz;     //	decimal(16,2) 	,--����zf_xfzb_fb.fj
	private String mscc;  	//varchar(500)	,--û�ղƲ����zf_xfzb_fb.mscc
	private String fzss;   	//varchar(max)   	,--������ʵzf_xfzb_fb.fzss,text
	private String zklb;	//varchar(20)		,--�ؿ����,��Σ���ص��ﷸ��zf_wwzk.zklb*����
	private String zkxz1;	//varchar(20)		,--�ؿ�����1,��Σ���ص��ﷸ��zf_wwzk.zkxz1*����
	private String zkxz2;	//varchar(20)		,--�ؿ�����2,��Σ���ص��ﷸ��zf_wwzk.zkxz2*����
	private String rzlb;	//varchar(20)		,--����������jy_rzfp.rzlb*����    
	private int xfcs;	//tinyint         ,--�����̷�����zf_jbxx.xfcs 
	private String hfgdj;  // varchar(10)		,--�ֹܵȼ�zf_fgdj.hfgdj*����,����׼���ڻ�ȡ���µ�(��ʼֵ����)
	private String sfsw;   	//varchar(2)		,--�Ƿ����ޡ��ﷸ                   
	private String sfsj;   //	varchar(2)		,--�Ƿ������ﷸ 
	private String ynsalb; 	//varchar(10)		,--���ڰ��������������,�������Ŵ�zc_ynaj_sazf��ȡzc_ynaj.gui�ٻ�ȡ(paajlb)�ư��϶��������*����	
	private String ldnl;	//varchar(25)		,--�Ͷ�����sw_bfgl.ldnl
	private String jblb;	//varchar(35)		,--�������sw_bfgl_jd.jblb
	private String tafqx;	//varchar(100)	--ͬ����ȥ��
	private String zmfl; //��������
	
	public String getQh() {
		return qh;
	}
	public void setQh(String qh) {
		this.qh = qh;
	}
	public String getBqzy() {
		return bqzy;
	}
	public void setBqzy(String bqzy) {
		this.bqzy = bqzy;
	}
	public String getZjlx() {
		return zjlx;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	public String getSg() {
		return sg;
	}
	public void setSg(String sg) {
		this.sg = sg;
	}
	public String getTz() {
		return tz;
	}
	public void setTz(String tz) {
		this.tz = tz;
	}
	public String getHtzk() {
		return htzk;
	}
	public void setHtzk(String htzk) {
		this.htzk = htzk;
	}
	public String getHjdz() {
		return hjdz;
	}
	public void setHjdz(String hjdz) {
		this.hjdz = hjdz;
	}
	public String getJtzz() {
		return jtzz;
	}
	public void setJtzz(String jtzz) {
		this.jtzz = jtzz;
	}
	public String getHygx() {
		return hygx;
	}
	public void setHygx(String hygx) {
		this.hygx = hygx;
	}
	public String getJtzc() {
		return jtzc;
	}
	public void setJtzc(String jtzc) {
		this.jtzc = jtzc;
	}
	public String getJtbg() {
		return jtbg;
	}
	public void setJtbg(String jtbg) {
		this.jtbg = jtbg;
	}
	public String getWcnfjtzk() {
		return wcnfjtzk;
	}
	public void setWcnfjtzk(String wcnfjtzk) {
		this.wcnfjtzk = wcnfjtzk;
	}
	public String getSfdszn() {
		return sfdszn;
	}
	public void setSfdszn(String sfdszn) {
		this.sfdszn = sfdszn;
	}
	public String getZmmc() {
		return zmmc;
	}
	public void setZmmc(String zmmc) {
		this.zmmc = zmmc;
	}
	public Date getRjrq() {
		return rjrq;
	}
	public void setRjrq(Date rjrq) {
		this.rjrq = rjrq;
	}
	public String getFylx() {
		return fylx;
	}
	public void setFylx(String fylx) {
		this.fylx = fylx;
	}
	public String getGtfzlx() {
		return gtfzlx;
	}
	public void setGtfzlx(String gtfzlx) {
		this.gtfzlx = gtfzlx;
	}
	public String getBdlb() {
		return bdlb;
	}
	public void setBdlb(String bdlb) {
		this.bdlb = bdlb;
	}
	public String getXq() {
		return xq;
	}
	public void setXq(String xq) {
		this.xq = xq;
	}
	public String getAflb() {
		return aflb;
	}
	public void setAflb(String aflb) {
		this.aflb = aflb;
	}
	public String getBznx() {
		return bznx;
	}
	public void setBznx(String bznx) {
		this.bznx = bznx;
	}
	public String getQzcj() {
		return qzcj;
	}
	public void setQzcj(String qzcj) {
		this.qzcj = qzcj;
	}
	public String getXzjx() {
		return xzjx;
	}
	public void setXzjx(String xzjx) {
		this.xzjx = xzjx;
	}
	public String getFz() {
		return fz;
	}
	public void setFz(String fz) {
		this.fz = fz;
	}
	public String getMscc() {
		return mscc;
	}
	public void setMscc(String mscc) {
		this.mscc = mscc;
	}
	public String getFzss() {
		return fzss;
	}
	public void setFzss(String fzss) {
		this.fzss = fzss;
	}
	public String getZklb() {
		return zklb;
	}
	public void setZklb(String zklb) {
		this.zklb = zklb;
	}
	public String getZkxz1() {
		return zkxz1;
	}
	public void setZkxz1(String zkxz1) {
		this.zkxz1 = zkxz1;
	}
	public String getZkxz2() {
		return zkxz2;
	}
	public void setZkxz2(String zkxz2) {
		this.zkxz2 = zkxz2;
	}
	public String getRzlb() {
		return rzlb;
	}
	public void setRzlb(String rzlb) {
		this.rzlb = rzlb;
	}
	public int getXfcs() {
		return xfcs;
	}
	public void setXfcs(int xfcs) {
		this.xfcs = xfcs;
	}
	public String getHfgdj() {
		return hfgdj;
	}
	public void setHfgdj(String hfgdj) {
		this.hfgdj = hfgdj;
	}
	public String getSfsw() {
		return sfsw;
	}
	public void setSfsw(String sfsw) {
		this.sfsw = sfsw;
	}
	public String getSfsj() {
		return sfsj;
	}
	public void setSfsj(String sfsj) {
		this.sfsj = sfsj;
	}
	public String getYnsalb() {
		return ynsalb;
	}
	public void setYnsalb(String ynsalb) {
		this.ynsalb = ynsalb;
	}
	public String getLdnl() {
		return ldnl;
	}
	public void setLdnl(String ldnl) {
		this.ldnl = ldnl;
	}
	public String getJblb() {
		return jblb;
	}
	public void setJblb(String jblb) {
		this.jblb = jblb;
	}
	public String getTafqx() {
		return tafqx;
	}
	public void setTafqx(String tafqx) {
		this.tafqx = tafqx;
	}
	public String getZmfl() {
		return zmfl;
	}
	public void setZmfl(String zmfl) {
		this.zmfl = zmfl;
	}
	
}
