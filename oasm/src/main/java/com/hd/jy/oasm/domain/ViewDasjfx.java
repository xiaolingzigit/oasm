package com.hd.jy.oasm.domain;

/***
 * �������ݷ�����ͼ���ѵ��������ﷸ�������ݽ��е����������ѷ���������뵽Sjdafx����ȥ
 * @author quite
 *ӳ���ļ�:���ɵ�Viewftjg.xml
 *ҵ��ӿ��ļ�:���ɵ�ViewftjgAndxwgcDao
 */
public class ViewDasjfx {
	  private String bh; //���  --�������

	  private String xm; //����

	  private String xq; //���� ---��ʽyyMMdd

	  private int csrq; //��������  --��ʽyyyy-MM-dd

	  private String bqwhcd; //��ǰ�Ļ��̶�   ʹ�ô��� ����ä 92

	  private Byte xfcs; //�����̷����� 

	  private String gtfzlx; //��ͬ�����������1,2

	  private String tbgzlb; //�ر��ע���   ��ʽ10�۷�,11�߷�

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