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
 * TODO�������棬������JSON��������ķ�װ�Ĵ������
 * @author quite
 * @data 2017��12��22��
 * @see  
 * 
 */
public class Pgbg {
	private String ctaskId; //������id
	
	private String taskType; //��������
	
	private String results; //������
	
	private String records; //����ר�õĲ��Լ�¼
	
	private String taskfs; //�������������ܷ���
	
	private String wxqxpg; //Σ����������
	
	private List<BGjcxxpg> jcxxpg; //������Ϣ����
	
	private List<BGgtft> gtftpg; //�����̸�������
	
	private List<BGjtft> jtftpg; //�����̸�������
	
	private List<BGxwgc> xwgcpg; //��Ϊ�۲��������
	
	private List<PgXlcsJg> sclpg; //��װscl�Ĳ����������

	private List<PgXlcsJg> xlcepg; //��װ��������������
	
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
