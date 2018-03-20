package com.hd.jy.oasm.domain;

public class VTjwxlx {
	
	private String gyjq;//监区
	
	private int zsl;//监区总人数 
	
	private int zssl;//高自杀倾向数量
	
	private int xxsl;//高行凶倾向数量
	
	private int ttsl;//高脱逃倾向数量
	
	private int zfzsl;//高再犯罪倾向数量
	
	public String getGyjq() {
		return gyjq;
	}

	public void setGyjq(String gyjq) {
		this.gyjq = gyjq == null ? null : gyjq.trim();
	}
	
	public int getZsl() {
		return zsl;
	}
	public void setZsl(int zsl) {
		this.zsl = zsl;
	}
	
	public int getZssl() {
		return zssl;
	}

	public void setZssl(int zssl) {
		this.zssl = zssl;
	}

	public int getXxsl() {
		return xxsl;
	}

	public void setXxsl(int xxsl) {
		this.xxsl = xxsl;
	}

	public int getTtsl() {
		return ttsl;
	}

	public void setTtsl(int ttsl) {
		this.ttsl = ttsl;
	}

	public int getZfzsl() {
		return zfzsl;
	}

	public void setZfzsl(int zfzsl) {
		this.zfzsl = zfzsl;
	}

}
