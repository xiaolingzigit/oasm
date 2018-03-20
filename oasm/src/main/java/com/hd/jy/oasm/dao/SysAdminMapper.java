package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.SysAdmin;

public interface SysAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAdmin record);

    int insertSelective(SysAdmin record);

    SysAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SysAdmin record);
    
    int updateByPrimaryKeySelective(SysAdmin record); //超级管理员修改普通管理员的密码

    int updateByCurrentUsername(SysAdmin record);  //根据当前登录的账号修改密码
    
    int selectByUser(SysAdmin record);  //根据用户名密码查询
    
    String checkByUsername(String username);  //通过用户名查出密码存储到令牌中
    
    int check_username_add(String username); //验证添加的管理员是否可用
    
    List<SysAdmin> selectAdminByStatus();  //列出所有状态为1的普通管理员
    
    int updateBySuperAdminStatus(SysAdmin record); //逻辑删除普通管理员
    
    List<SysAdmin> selectByAdminLikeKey(String key);  //普通管理员搜索框
}