package com.hd.jy.oasm.domain;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * 
 * �����;�Ա��ϵ�������ڷ�����������ѡ���б�
 * 
 * @author admin
 *
 */
public class CrimCopInfo extends BasicModel {
	private String crimNo;
	private String crimName;
	private String inTime;
	private String prison;
	private String subPrison;
	private String stage; //�׶�-�յ���ϵͳ���ڼ࣬�ѳ���
	private String cop1No; //ר�ܾ���
	private String cop1Name; //ר�ܾ���
	private String cop2No; //Э������
	private String cop2Name;//Э������
	
	public CrimCopInfo() {
	
	}
	
	public CrimCopInfo(String crimNo, String crimName, String inTime,
			String prison, String subPrison, String stage, String cop1No,
			String cop1Name, String cop2No, String cop2Name) {
		this.crimNo = crimNo;
		this.crimName = crimName;
		this.inTime = inTime;
		this.prison = prison;
		this.subPrison = subPrison;
		this.stage = stage;
		this.cop1No = cop1No;
		this.cop1Name = cop1Name;
		this.cop2No = cop2No;
		this.cop2Name = cop2Name;
	}

	public String getCrimNo() {
		return crimNo;
	}

	public void setCrimNo(String crimNo) {
		this.crimNo = crimNo;
	}

	public String getCrimName() {
		return crimName;
	}

	public void setCrimName(String crimName) {
		this.crimName = crimName;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getPrison() {
		return prison;
	}

	public void setPrison(String prison) {
		this.prison = prison;
	}

	public String getSubPrison() {
		return subPrison;
	}

	public void setSubPrison(String subPrison) {
		this.subPrison = subPrison;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getCop1No() {
		return cop1No;
	}

	public void setCop1No(String cop1No) {
		this.cop1No = cop1No;
	}

	public String getCop1Name() {
		return cop1Name;
	}

	public void setCop1Name(String cop1Name) {
		this.cop1Name = cop1Name;
	}

	public String getCop2No() {
		return cop2No;
	}

	public void setCop2No(String cop2No) {
		this.cop2No = cop2No;
	}

	public String getCop2Name() {
		return cop2Name;
	}

	public void setCop2Name(String cop2Name) {
		this.cop2Name = cop2Name;
	}
}
