package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.Tzyrymd;

public interface TzyrymdMapper {
    int insert(Tzyrymd record);

    int insertSelective(Tzyrymd record);
    
    Tzyrymd selectBDJCbyqh(long qh); //�������Ų�������ľ���
    
    int updateCjftzt(long qh); //���ĳ����ѽṹ��̸��״̬��jdΪ4
    
    int updateCjgczt(long qh); //���ĳ�������Ϊ�۲��״̬��jdΪ4
    
    List<Tzyrymd> useZyyrymdProduce(); //���õ������ݵ���Ѻ��Ա�����ӿڵĴ洢���̷��ض������
    
    int crimPlaceSaveOrUpdate(Tjczjdx record); //ʹ��excel������ﷸ�뾯��Ĺ�����Ϣ
}