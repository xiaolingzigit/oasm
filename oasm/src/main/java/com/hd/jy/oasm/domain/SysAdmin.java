package com.hd.jy.oasm.domain;

public class SysAdmin {
    private int id;//���

    private String username;//�û���

    private String password;//����

    private int gmid;//��ɫid
    
    private int status;//״̬ 0ɾ����1��ͨ����Ա��2��������Ա
    
    private GroupMan groupMan; //����ְ��
    
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