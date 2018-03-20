package com.hd.jy.oasm.domain;

public class CodeName {
	private String code; 
	private String Name;
	
	public CodeName() {
	} 
	
	public CodeName(String code, String name) {
		this.code = code;
		Name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	} 
}
