package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.GroupMan;
import com.hd.jy.oasm.domain.SysAdmin;
import com.hd.jy.oasm.domain.ZRole;

/***
 * 
 * @author quite
 *param 总角色Dao，集成GroupMan的Dao
 *extends 全查询的方法 
 *操作接口为jyxxService
 */
public interface ZRoleMapper extends BaseDao<ZRole>{
    int deleteByPrimaryKey(Integer id);

    int insert(ZRole record);

    int insertSelective(ZRole record);

    ZRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZRole record);

    int updateByPrimaryKey(ZRole record);
    
    List<ZRole> selectAllGroupMan(Integer id);  //根据总角色的主键查询职务
    
    int insertGroupMan(GroupMan record);  //添加职务-------如有必要，不设置自增
    
    List<SysAdmin> selectSomeGroupMan(String name);	//系统用户职务级联
    
}