package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.SysAdmin;

public interface ZRoleService {
	
	List<SysAdmin> selectSomeGroupMan(String name);	//系统用户职务级联

}
