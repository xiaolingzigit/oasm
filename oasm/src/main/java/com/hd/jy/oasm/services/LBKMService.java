package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.LBKM;

import com.hd.jy.oasm.domain.WD;
import com.hd.jy.oasm.domain.ZCYCYQPC;
/**
 * 
 * @author quite
 *���������߼��ӿڣ�����ȫ��ѯ����
 */
public interface LBKMService {
	public List<LBKM> selectAllkm(); //��ѯ��ʾ���е��������
	
	public List<LBKM> selectRDLB(String str); //��ѯ��ʾĳ���׶ε�������
	
	
    
    
    public List<LBKM> cjlbtmyz(String fl);  //����������ݷ���Ҫ�������Ŀ����
	
	public int closeOrstartLBKMisLive(String lbbh);  //�رջ���������
	    
	public List<WD> selectAllWd();	//��ѯ����ά��
	
	public List<ZCYCYQPC> selectYCYQ(String yqztbh); //����String���͵����Ų�ѯ�쳣����
	
	//********************************************************
	public String scaleRelatById(int scaleId); //���������Ų�ѯ���Ӻ�ά�ȣ��ں�̨��������ʹ��
}
