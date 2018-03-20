package com.hd.jy.oasm.domain;

public class SysAdmin {
    private int id;//编号

    private String username;//用户名

    private String password;//密码

    private int gmid;//角色id
    
    private int status;//状态 0删除，1普通管理员，2超级管理员
    
    private GroupMan groupMan; //关联职务
    
    public GroupMan getGroupMan() {
		return groupMan;
	}

	public void setGroupMan(GroupMan groupMan) {
		this.groupMan = groupMan;
	}

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public int getGmid() {
        return gmid;
    }

    public void setGmid(int gmid) {
        this.gmid = gmid;
    }
}