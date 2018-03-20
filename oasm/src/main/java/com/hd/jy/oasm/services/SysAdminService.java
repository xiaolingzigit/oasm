package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.SysAdmin;
/***
 * 
 * @author quite
 *ϵͳ����Ա�����ӿڣ�������¼����֤����ӣ�ɾ�����޸�����
 */
public interface SysAdminService {
    public int selectByUser(SysAdmin record);  //�����û��������ѯ
    
    public String checkByUsername(String username);  //ͨ���û����������洢��������
    
    public int insertSelective(SysAdmin record); //��ӹ���Ա
    
    public int check_username_add(String username); //��֤��ӵĹ���Ա�Ƿ����
    
    public int updateByPrimaryKeySelective(SysAdmin record); //�޸ĺ�̨������
    
    public int updateByCurrentUsername(SysAdmin record);  //���ݵ�ǰ��¼���˺��޸�����
    
    public List<SysAdmin> selectAdminByStatus();  //�г�����״̬Ϊ1����ͨ����Ա
    
    public int updateBySuperAdminStatus(SysAdmin record); //��������Աͨ���޸�status�߼�ɾ����ͨ����Ա
    
    public List<SysAdmin> selectByAdminLikeKey(String key);  //��ͨ����Ա������
}
