package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/**
 * 修改设计因子维度关系表
 * @author quite
 *映射文件tyskAndwd.xml
 */
public class Twdyzgx{
	private int wdid;//维度ID

    private int yzid;//因子ID
	
    private String sm;//说明	

    private int qyzt; //启用状态，值域：启用状态码	

    private Date cjsj;//创建时间

    private String cjrbh;//创建人编号，警号

    private Date xgsj;//修改时间

    private String xgrbh;//修改人编号		

	/**
	 * @return the wdid
	 */
	public int getWdid() {
		return wdid;
	}

	/**
	 * @param wdid the wdid to set
	 */
	public void setWdid(int wdid) {
		this.wdid = wdid;
	}

	/**
	 * @return the yzid
	 */
	public int getYzid() {
		return yzid;
	}

	/**
	 * @param yzid the yzid to set
	 */
	public void setYzid(int yzid) {
		this.yzid = yzid;
	}

	/**
	 * @return the sm
	 */
	public String getSm() {
		return sm;
	}

	/**
	 * @param sm the sm to set
	 */
	public void setSm(String sm) {
		this.sm = sm;
	}

	/**
	 * @return the qyzt
	 */
	public int getQyzt() {
		return qyzt;
	}

	/**
	 * @param qyzt the qyzt to set
	 */
	public void setQyzt(int qyzt) {
		this.qyzt = qyzt;
	}

	/**
	 * @return the cjsj
	 */
	public Date getCjsj() {
		return cjsj;
	}

	/**
	 * @param cjsj the cjsj to set
	 */
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	/**
	 * @return the cjrbh
	 */
	public String getCjrbh() {
		return cjrbh;
	}

	/**
	 * @param cjrbh the cjrbh to set
	 */
	public void setCjrbh(String cjrbh) {
		this.cjrbh = cjrbh;
	}

	/**
	 * @return the xgsj
	 */
	public Date getXgsj() {
		return xgsj;
	}

	/**
	 * @param xgsj the xgsj to set
	 */
	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	/**
	 * @return the xgrbh
	 */
	public String getXgrbh() {
		return xgrbh;
	}

	/**
	 * @param xgrbh the xgrbh to set
	 */
	public void setXgrbh(String xgrbh) {
		this.xgrbh = xgrbh;
	}

    
}