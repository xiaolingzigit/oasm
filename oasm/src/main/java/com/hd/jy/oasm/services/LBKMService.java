package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.LBKM;
/**
 * 
 * @author quite
 *���������߼��ӿڣ�����ȫ��ѯ����
 */
import com.hd.jy.oasm.domain.WD;
import com.hd.jy.oasm.domain.ZCYCYQPC;
public interface LBKMService {
	public List<LBKM> selectAllkm(); //��ѯ��ʾ���е��������
	
	public List<LBKM> selectRDLB(String str); //��ѯ��ʾĳ���׶ε�������
	
	public List<LBKM> rjlbtmyz(String lbbh);  //����������lbbhѡ��Ҫ�������Ŀ����
	
    public List<LBKM> rclbtmyz(String fl);  //�ճ�������ݷ���ѡ��Ҫ�������Ŀ����
    
    public List<LBKM> zqlbtmyz(String fl); //�����������ѡ��Ҫ�������Ŀ����
    
    public List<LBKM> cjlbtmyz(String fl);  //����������ݷ���Ҫ�������Ŀ����
	
	public int closeOrstartLBKMisLive(String lbbh);  //�رջ���������
	    
	public List<WD> selectAllWd();	//��ѯ����ά��
	
	public List<ZCYCYQPC> selectYCYQ(String yqztbh); //����String���͵����Ų�ѯ�쳣����
	
	//********************************************************
	public String scaleRelatById(int scaleId); //���������Ų�ѯ���Ӻ�ά�ȣ��ں�̨��������ʹ��
}
