package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.LBCJ;
import com.hd.jy.oasm.domain.LBKM;
import com.hd.jy.oasm.domain.WD;
/**
 * 
 * @author quite
 *�����ҵ��ӿ� �̳�BaseDaoȫ��ѯ����
 *
 *����lbrj��lbrc��lbzq��lbcj��ҵ��㼯����lbkm��
 */
public interface LBKMMapper extends BaseDao<LBKM>{
    int deleteByPrimaryKey(String lbbh);

    int insert(LBKM record);

    int insertSelective(LBKM record);

    LBKM selectByPrimaryKey(String lbbh);

    int updateByPrimaryKeySelective(LBKM record);

    int updateByPrimaryKey(LBKM record);
    
    
    
    
    List<LBKM> cjlbtmyz(String fl);  //����������ݷ���Ҫ�������Ŀ����
    
    int closeOrstartLBKMisLive(String lbbh);  //�ر������õ�����
    
    List<WD> selectAllWd(); 		//��ѯά��

    List<LBKM> selectRDLB(String str); //��ѯ��ʾĳ���׶ε�������
    
    //*************************����¼�����ӵķ�������ʾ���ӵĲ���************************************************************
    
    LBCJ selectCjyzAndfsByyzbm(int yzbm); //�������ӱ�����㵥�����Ӻͷ���  ��ZuoTiService�����
    
    
    
    
  
}