/**
 * @auto quite
 * 
 */
package com.hd.jy.oasm.domain.newDomain;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.BGgtft;
import com.hd.jy.oasm.domain.BGjcxxpg;
import com.hd.jy.oasm.domain.BGjtft;
import com.hd.jy.oasm.domain.BGxwgc;
import com.hd.jy.oasm.domain.PgXlcsJg;

/**
 * TODO评估报告，用来存JSON评估报告的封装的答题情况
 * @author quite
 * @data 2017年12月22日
 * @see  
 * 
 */
public class Pgbg {
	private String ctaskId; //子任务id
	
	private String taskType; //任务类型
	
	private String results; //答题结果
	
	private String records; //心理专用的测试记录
	
	private String taskfs; //整个评估报告总分数
	
	private String wxqxpg; //危险倾向评估
	
	private List<BGjcxxpg> jcxxpg; //基础信息评估
	
	private List<BGgtft> gtftpg; //个体访谈评估结果
	
	private List<BGjtft> jtftpg; //集体访谈评估结果
	
	private List<BGxwgc> xwgcpg; //行为观察评估结果
	
	private List<PgXlcsJg> sclpg; //封装scl的测试评估结果

	private List<PgXlcsJg> xlcepg; //封装心理测试评估结果
	
	public Pgbg() {
		super();
	}
    
	public List<PgXlcsJg> getSclpg() {
		return sclpg;
	}



	public void setSclpg(List<PgXlcsJg> sclpg) {
		this.sclpg = sclpg;
	}



	public List<PgXlcsJg> getXlcepg() {
		return xlcepg;
	}


	public void setXlcepg(List<PgXlcsJg> xlcepg) {
		this.xlcepg = xlcepg;
	}


	public List<BGjcxxpg> getJcxxpg() {
		return jcxxpg;
	}

	public void setJcxxpg(List<BGjcxxpg> jcxxpg) {
		this.jcxxpg = jcxxpg;
	}

	public List<BGgtft> getGtftpg() {
		return gtftpg;
	}

	public void setGtftpg(List<BGgtft> gtftpg) {
		this.gtftpg = gtftpg;
	}

	public List<BGjtft> getJtftpg() {
		return jtftpg;
	}

	public void setJtftpg(List<BGjtft> jtftpg) {
		this.jtftpg = jtftpg;
	}

	public List<BGxwgc> getXwgcpg() {
		return xwgcpg;
	}

	public void setXwgcpg(List<BGxwgc> xwgcpg) {
		this.xwgcpg = xwgcpg;
	}

	public String getWxqxpg() {
		return wxqxpg;
	}


	public void setWxqxpg(String wxqxpg) {
		this.wxqxpg = wxqxpg;
	}


	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getCtaskId() {
		return ctaskId;
	}

	public void setCtaskId(String ctaskId) {
		this.ctaskId = ctaskId;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public String getTaskfs() {
		return taskfs;
	}

	public void setTaskfs(String taskfs) {
		this.taskfs = taskfs;
	}
	
}
