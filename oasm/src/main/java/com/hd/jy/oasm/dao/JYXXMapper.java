package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.GroupMan;
import com.hd.jy.oasm.domain.JYXX;

public interface JYXXMapper {

    int insert(JYXX record);

    int insertSelective(JYXX record);

    JYXX selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JYXX record); //修改警员信息
    
    JYXX selectCheck(String jh);
	
	int selectCheckUser(JYXX record);

    int updateByPrimaryKey(JYXX record);
    
    List<JYXX> selectJyxx(); //全查询警员信息
    
    int updateCerrurJh(JYXX record); //根据当前登录警号修改密码
    
    JYXX infoSetting(String jh); //根据警号查询管理犯人的数量，以及人物信息显示
    
    GroupMan checkZW(String zwName); //根据职务名称查询是否有该职务
}