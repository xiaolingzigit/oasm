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
 * @see  映射文件VPgbgListMapper.xml
 * 
 */
public class BGxxxx {
//	private String rwid; //varchar(35) 	primary key,  --评估任务id,报告编号(囚号_任务类型 _发布时间yyyymmddhhmm)
	private String qh; //varchar(10)	,--囚号
	//--在评估报告表t_eval_report
	//--pgsj	//date			,--评估时间
	//--pgfs	//varchar(10)		,--评估分数
	//--wzdj	//varchar(20)		,--危险等级
//	private String wxxpgfs;	//varchar(max)	,--危险性评估分析
	//-----------------------------------------
	private String bqzy; //varchar(100), --捕前职业
	private String zjlx; //varchar(100), --证件类型,字符串拼接,逗号分隔*代码
	private String sg; //varchar(5) , --身高cm
	private String tz; // varchar(5), --体重kg
	private String htzk; //varchar(20), --婚姻状况zf_hybd.hyzk*代码
	private String hjdz; //varchar(200), --户籍住址
	private String jtzz; //varchar(200), --家庭住址
	private String hygx; //varchar(20), --婚姻关系,zf_hybd.hyzk*代码，取最新
	private String jtzc; //varchar(100),--家庭支持
	private String jtbg; //varchar(100),--家庭变故
	private String wcnfjtzk; // varchar(100),--未成年犯家庭状况*代码
	private String sfdszn; //varchar(5), --是否独生子女
	//----------------------------------------
	private String zmmc;    //varchar(100) 	,--罪名名称zf_zm.zmmc，拼接字符串，逗号隔开
	private Date rjrq; 	//date			,--入监日期zf_jbxx.rjrq
	private String fylx;	//varchar(10)		,--分押类型zf_jbxx.fylx		
	private String gtfzlx;	//varchar(20)		,--共同犯罪参与类型zf_jbxx_fb.gtfzlx*共同犯罪参与类型代码
	private String bdlb;	//varchar(20)		,--刑罚变动zf_xfzb_fb类别值域：刑罚变动分类代码
	private String xq;		//varchar(6)		,--刑期,取最新修改日期的。映射成字符串，zf_xfzbx.xq格式：9995,无期,9996死缓,9997死刑,yymmdd年月天
	private String aflb;	//varchar(50)		,--案犯类别zf_xfzb.aflb*案犯类别代码
	private String bznx;	//varchar(6) 		,--剥夺政治权利期限zf_xfzb.bznx,99终身/yymmdd
	private String qzcj;	//varchar(2)		,--是否驱逐出境
	private String xzjx;	//varchar(2)		,--是否限制减刑zf_xfzb.xzjx,0否1是
	private String fz;     //	decimal(16,2) 	,--罚金zf_xfzb_fb.fj
	private String mscc;  	//varchar(500)	,--没收财产情况zf_xfzb_fb.mscc
	private String fzss;   	//varchar(max)   	,--犯罪事实zf_xfzb_fb.fzss,text
	private String zklb;	//varchar(20)		,--重控类别,顽危及重点罪犯表zf_wwzk.zklb*代码
	private String zkxz1;	//varchar(20)		,--重控性质1,顽危及重点罪犯表zf_wwzk.zkxz1*代码
	private String zkxz2;	//varchar(20)		,--重控性质2,顽危及重点罪犯表zf_wwzk.zkxz2*代码
	private String rzlb;	//varchar(20)		,--认罪服判类别，jy_rzfp.rzlb*代码    
	private int xfcs;	//tinyint         ,--既往刑罚次数zf_jbxx.xfcs 
	private String hfgdj;  // varchar(10)		,--分管等级zf_fgdj.hfgdj*代码,按批准日期获取最新的(初始值在哪)
	private String sfsw;   	//varchar(2)		,--是否“三无”罪犯                   
	private String sfsj;   //	varchar(2)		,--是否三假罪犯 
	private String ynsalb; 	//varchar(10)		,--狱内案件立案案件类别,根据囚号从zc_ynaj_sazf获取zc_ynaj.gui再获取(paajlb)破案认定案件类别*代码	
	private String ldnl;	//varchar(25)		,--劳动能力sw_bfgl.ldnl
	private String jblb;	//varchar(35)		,--疾病类别sw_bfgl_jd.jblb
	private String tafqx;	//varchar(100)	--同案犯去向
	private String zmfl; //罪名分类
	
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
