package com.hd.jy.oasm.domain;
/***
 * 
 * @author quite
 * @param 用户角色权限全部在这里操作
 */
public class GrolePermiss {
    private int id;

    private int grid;
    
    private GroupMan grouMan;  //关联组员角色表

    private int pid;
    
    private Permission permission;  //关联权限表

    private int jh;  //关联警号
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrid() {
        return grid;
    }

    public void setGrid(int grid) {
        this.grid = grid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

	public int getJh() {
		return jh;
	}

	public void setJh(int jh) {
		this.jh = jh;
	}

	public GroupMan getGrouMan() {
		return grouMan;
	}

	public void setGrouMan(GroupMan grouMan) {
		this.grouMan = grouMan;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
    
}
