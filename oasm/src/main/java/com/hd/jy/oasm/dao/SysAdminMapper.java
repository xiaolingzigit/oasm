package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.SysAdmin;

public interface SysAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAdmin record);

    int insertSelective(SysAdmin record);

    SysAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SysAdmin record);
    
    int updateByPrimaryKeySelective(SysAdmin record); //��������Ա�޸���ͨ����Ա������

    int updateByCurrentUsername(SysAdmin record);  //���ݵ�ǰ��¼���˺��޸�����
    
    int selectByUser(SysAdmin record);  //�����û��������ѯ
    
    String checkByUsername(String username);  //ͨ���û����������洢��������
    
    int check_username_add(String username); //��֤��ӵĹ���Ա�Ƿ����
    
    List<SysAdmin> selectAdminByStatus();  //�г�����״̬Ϊ1����ͨ����Ա
    
    int updateBySuperAdminStatus(SysAdmin record); //�߼�ɾ����ͨ����Ա
    
    List<SysAdmin> selectByAdminLikeKey(String key);  //��ͨ����Ա������
}