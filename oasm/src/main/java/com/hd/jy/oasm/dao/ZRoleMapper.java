package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.GroupMan;
import com.hd.jy.oasm.domain.SysAdmin;
import com.hd.jy.oasm.domain.ZRole;

/***
 * 
 * @author quite
 *param �ܽ�ɫDao������GroupMan��Dao
 *extends ȫ��ѯ�ķ��� 
 *�����ӿ�ΪjyxxService
 */
public interface ZRoleMapper extends BaseDao<ZRole>{
    int deleteByPrimaryKey(Integer id);

    int insert(ZRole record);

    int insertSelective(ZRole record);

    ZRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZRole record);

    int updateByPrimaryKey(ZRole record);
    
    List<ZRole> selectAllGroupMan(Integer id);  //�����ܽ�ɫ��������ѯְ��
    
    int insertGroupMan(GroupMan record);  //���ְ��-------���б�Ҫ������������
    
    List<SysAdmin> selectSomeGroupMan(String name);	//ϵͳ�û�ְ����
    
}