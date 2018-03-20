package com.hd.jy.oasm.domain.newDomain;

import java.util.List;

//≈‰÷√¿‡◊™JSON¿‡
public class Config {
    private int confNo; //≈‰÷√±‡∫≈
    
    private String confName; //≈‰÷√√˚≥∆
    
    private String orgId; //º‡”¸∫≈
    
    private int status; //≈‰÷√ «∑Ò…˙–ß
    
    private List<Scale> scale;
    
	
	public Config() {
		super();
	}




	public Config(int confNo, String confName, String orgId, int status, List<Scale> scale) {
		super();
		this.confNo = confNo;
		this.confName = confName;
		this.orgId = orgId;
		this.status = status;
		this.scale = scale;
	}




	public int getConfNo() {
		return confNo;
	}




	public void setConfNo(int confNo) {
		this.confNo = confNo;
	}




	public String getConfName() {
		return confName;
	}




	public void setConfName(String confName) {
		this.confName = confName;
	}




	public String getOrgId() {
		return orgId;
	}




	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}




	public int getStatus() {
		return status;
	}




	public void setStatus(int status) {
		this.status = status;
	}




	public List<Scale> getScale() {
		return scale;
	}




	public void setScale(List<Scale> scale) {
		this.scale = scale;
	}

	
}
