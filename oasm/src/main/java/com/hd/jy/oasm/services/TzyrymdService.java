package com.hd.jy.oasm.services;

import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.Tzyrymd;

public interface TzyrymdService {
	public Tzyrymd selectBDJCbyqh(long qh); //�������Ų�������ľ���
	
	public int updateRjftzt(long qh); //�������Ÿ����ѷ�̸״̬,jd=1
	
	public int updateGczt(long qh);  //�������Ÿ����ѹ۲��״̬,jd=1
	
	public int updateRcgczt(long qh); //�������Ÿ����ճ�����Ϊ�۲��״̬,jdΪ2
	    
	    
    public  int updateZqftzt(long qh); //�������Ÿ��������ѽṹ��̸��״̬,jdΪ3
	    
    public  int updateZqGczt(long qh); //������������Ϊ�۲��״̬,jdΪ3
	    
	    
    public int updateCjftzt(long qh); //���ĳ����ѽṹ��̸��״̬��jdΪ4
	    
	public int updateCjgczt(long qh); //���ĳ�������Ϊ�۲��״̬��jdΪ4
	
	public int crimPlaceSaveOrUpdate(Tjczjdx record); //ʹ��excel������ﷸ�뾯��Ĺ�����Ϣ
}
