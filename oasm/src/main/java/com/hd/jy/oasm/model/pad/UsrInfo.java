package com.hd.jy.oasm.model.pad;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

public class UsrInfo extends BasicModel{
	private String usr;
	private String pwd;
	private String token;

	public UsrInfo() {
	}

	public UsrInfo(String token) {
		this.token = token;
	}

	public UsrInfo(String usr, String pwd) {
		this.usr = usr;
		this.pwd = pwd;
	}
	
	public UsrInfo(String usr, String pwd, String token) {
		this.usr = usr;
		this.pwd = pwd;
		this.token = token;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public String getTrimedToken() {
		return token == null ? null : token.trim();
	}

	public void setToken(String token) {
		this.token = token;
	}
}
