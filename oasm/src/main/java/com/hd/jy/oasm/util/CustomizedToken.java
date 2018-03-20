package com.hd.jy.oasm.util;

import org.apache.shiro.authc.UsernamePasswordToken;

@SuppressWarnings("serial")
public class CustomizedToken extends UsernamePasswordToken{
	/**
	 * 
	 */
	//��¼���ͣ��ж��ǹ���Ա��ʡ����������ͨ����Ա
    private String loginType;
    public CustomizedToken(final String username, final String password,String loginType) {
        super(username,password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
