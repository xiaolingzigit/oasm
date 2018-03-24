package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.GroupMan;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.domain.ZRole;

/***
 * 
 * @author quite
 * param警员信息操作接口，包括登录，添加警员，添加职务，角色查询
 *
 */
public interface JyxxService {
	public int insertSelective(JYXX record);
	
	public JYXX selectCheck(String jh);
	
	public int selectCheckUser(JYXX record);
	
	public List<ZRole> selectAllZroll();  //调用全查询方法
	
	public List<ZRole> selectAllGroupMan(Integer id);  //根据总角色的主键查询职务
	
	public int insertGroupMan(GroupMan record);  //添加职务
	
	public List<JYXX> selectJyxx(); //全查询警员信息
	
	public int updateByPrimaryKeySelective(JYXX record); //修改警员信息
	
	public int updateCerrurJh(JYXX record); //根据当前登录警号修改密码
	
	public JYXX infoSetting(String jh); //根据警号查询管理犯人的数量，以及人物信息显示
	
	public JYXX otherInfoSetting(String jh);
	
	public GroupMan checkZW(String zwName); //根据职务名称查询是否有该职务
}
