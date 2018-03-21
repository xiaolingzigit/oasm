package com.hd.jy.oasm.domain;

/***
 * 档案数据分析视图，把导过来的罪犯档案数据进行档案分析，把分析结果插入到Sjdafx里面去
 * @author quite
 *映射文件:集成到Viewftjg.xml
 *业务接口文件:集成到ViewftjgAndxwgcDao
 */
public class ViewDasjfx {
	  private String bh; //编号  --囚犯编号

	  private String xm; //姓名

	  private String xq; //刑期 ---格式yyMMdd

	  private int csrq; //出生日期  --格式yyyy-MM-dd

	  private String bqwhcd; //捕前文化程度   使用代码 如文盲 92

	  private Byte xfcs; //既往刑罚次数 

	  private String gtfzlx; //共同犯罪参与类型1,2

	  private String tbgzlb; //特别关注类别   格式10累犯,11惯犯

	public String getBh() {
		return bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXq() {
		return xq;
	}

	public void setXq(String xq) {
		this.xq = xq;
	}

	public String getBqwhcd() {
		return bqwhcd;
	}

	public void setBqwhcd(String bqwhcd) {
		this.bqwhcd = bqwhcd;
	}

	public Byte getXfcs() {
		return xfcs;
	}

	public void setXfcs(Byte xfcs) {
		this.xfcs = xfcs;
	}

	public String getGtfzlx() {
		return gtfzlx;
	}

	public void setGtfzlx(String gtfzlx) {
		this.gtfzlx = gtfzlx;
	}

	public String getTbgzlb() {
		return tbgzlb;
	}

	public void setTbgzlb(String tbgzlb) {
		this.tbgzlb = tbgzlb;
	}

	public int getCsrq() {
		return csrq;
	}

	public void setCsrq(int csrq) {
		this.csrq = csrq;
	}
	

}