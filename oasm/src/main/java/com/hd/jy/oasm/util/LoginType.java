package com.hd.jy.oasm.util;

public enum LoginType {
	CUSTOMERS("Customers"),PROVINCE("Province"),ADMIN("Admin");
	private String type;
    private LoginType(String type){
    	this.type=type;
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.type.toString();
    }
}
