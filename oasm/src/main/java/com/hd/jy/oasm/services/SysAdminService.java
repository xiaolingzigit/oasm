package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.SysAdmin;
/***
 * 
 * @author quite
 *系统管理员操作接口，包括登录，验证，添加，删除，修改密码
 */
public interface SysAdminService {
    public int selectByUser(SysAdmin record);  //根据用户名密码查询
    
    public String checkByUsername(String username);  //通过用户名查出密码存储到令牌中
    
    public int insertSelective(SysAdmin record); //添加管理员
    
    public int check_username_add(String username); //验证添加的管理员是否可用
    
    public int updateByPrimaryKeySelective(SysAdmin record); //修改后台的密码
    
    public int updateByCurrentUsername(SysAdmin record);  //根据当前登录的账号修改密码
    
    public List<SysAdmin> selectAdminByStatus();  //列出所有状态为1的普通管理员
    
    public int updateBySuperAdminStatus(SysAdmin record); //超级管理员通过修改status逻辑删除普通管理员
    
    public List<SysAdmin> selectByAdminLikeKey(String key);  //普通管理员搜索框
}
