package com.hd.jy.oasm.domain;

public class CrimCopRelat {
	private String crimCode;
	private String cop1Code;
	private String cop2Code;

	public CrimCopRelat() {
	}

	public CrimCopRelat(String crimCode, String cop1Code, String cop2Code) {
		this.crimCode = crimCode;
		this.cop1Code = cop1Code;
		this.cop2Code = cop2Code;
	}

	public String getCrimCode() {
		return crimCode;
	}

	public void setCrimCode(String crimCode) {
		this.crimCode = crimCode;
	}

	public String getCop1Code() {
		return cop1Code;
	}

	public void setCop1Code(String cop1Code) {
		this.cop1Code = cop1Code;
	}

	public String getCop2Code() {
		return cop2Code;
	}

	public void setCop2Code(String cop2Code) {
		this.cop2Code = cop2Code;
	}
}
