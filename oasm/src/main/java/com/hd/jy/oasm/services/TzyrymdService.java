package com.hd.jy.oasm.services;

import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.Tzyrymd;

public interface TzyrymdService {
	public Tzyrymd selectBDJCbyqh(long qh); //�������Ų�������ľ���
  
    public int updateCjftzt(long qh); //���ĳ����ѽṹ��̸��״̬��jdΪ4
	    
	public int updateCjgczt(long qh); //���ĳ�������Ϊ�۲��״̬��jdΪ4
	
	public int crimPlaceSaveOrUpdate(Tjczjdx record); //ʹ��excel������ﷸ�뾯��Ĺ�����Ϣ
}
