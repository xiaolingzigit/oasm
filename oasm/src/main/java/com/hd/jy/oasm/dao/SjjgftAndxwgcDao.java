package com.hd.jy.oasm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hd.jy.oasm.domain.LBjcdafx;
import com.hd.jy.oasm.domain.Sjrjjgft;
import com.hd.jy.oasm.domain.ViewDafxjg;

/***
 * 
 * @author quite
 *�ṹ��̸����Ϊ�۲�����¼ҵ��ӿ�
 *
 *����SjjgftAndxwgcService�߼��ӿڴ���
 */
public interface SjjgftAndxwgcDao{ 
	//***************************************�ṹ��̸����*****************************************
	int rjjgftInsertSelective(Sjrjjgft record); //�������ṹ��̸
	
	//************************start****�����¼�����ҵ����Ӧ������ƥ�䵽����*****ͬʱ���������Dao��selectyzAndfsByyzbm����ƥ�����ӷ���*****************************************
	//-------------------------��ಿ��--------------------------------------
	Sjrjjgft selectByRjjgftidFindYz(String rjjgftid); //�������ṹ��̸�¼����ƥ�䵽���Ӻ͵������� ��ZuoTiService.java�����
	
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//***************************������������ҵ��ӿ�********************************************************
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	List<ViewDafxjg> selectDafxjgbg(Map<String,Object> map); //ȫ��ѯ������������б���ͼ��ҳ���б���ʾ
	
	LBjcdafx selectMoreDafxParam(@Param("wd")String wd,@Param("fz")int fz); //�������������õ������������� ��Sjjgft.xml
	
	/**
	 * ����������ʾ���˵��������������������Ŀ�����ﷸ��Ϣ��ѯ ��ʾ
	 * @auto quite
	 * @param qh
	 * @returna
	 * ����3:02:49
	 * List<ViewDafxjg>
	 */
	List<ViewDafxjg> crimInfoDafxjg(String qh); 
}
