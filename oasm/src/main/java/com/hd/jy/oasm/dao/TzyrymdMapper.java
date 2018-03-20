package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.Tzyrymd;

public interface TzyrymdMapper {
    int insert(Tzyrymd record);

    int insertSelective(Tzyrymd record);
    
    Tzyrymd selectBDJCbyqh(long qh); //�������Ų�������ľ���
    
    int updateRjftzt(long qh); //�������Ÿ����ѷ�̸״̬״̬��jdΪ1
    
    int updateGczt(long qh);  //�������Ÿ����ѹ۲��״̬״̬,jdΪ1
    
    
    int updateRcgczt(long qh); //�������Ÿ����ճ�����Ϊ�۲��״̬,jdΪ2
    
    
    int updateZqftzt(long qh); //�������Ÿ��������ѽṹ��̸��״̬,jdΪ3
    
    int updateZqGczt(long qh); //������������Ϊ�۲��״̬,jdΪ3
    
    
    int updateCjftzt(long qh); //���ĳ����ѽṹ��̸��״̬��jdΪ4
    
    int updateCjgczt(long qh); //���ĳ�������Ϊ�۲��״̬��jdΪ4
    
    List<Tzyrymd> useZyyrymdProduce(); //���õ������ݵ���Ѻ��Ա�����ӿڵĴ洢���̷��ض������
    
    int crimPlaceSaveOrUpdate(Tjczjdx record); //ʹ��excel������ﷸ�뾯��Ĺ�����Ϣ
}