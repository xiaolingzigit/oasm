package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.ViewDasjfx;

/***
 * 
 * @author quite
 *��̸�������Ϊ�۲�ҵ��ӿ�
 */
public interface ViewftjgAndxwgcDao{ 
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//*********************�������������ݲ���**********************************************************
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * ͨ����ѯ�������ݵ���Ϣ ��ZuoTiSvervice�ӿ��߼��ӿ��е��� ��Viewftjg.xml
	 * 
	 * @auto quite
	 * @returna
	 * ����2:24:31
	 * List<ViewDasjfx>
	 */
	List<ViewDasjfx> seachDasjfxByBh();  //��࣬�ճ������൵������
	
	List<ViewDasjfx> tbgzDasjfxByBh(String bh); //ͨ�����Ż�ȡ����ر��ע����
	
	List<ViewDasjfx> cjDasjfxByRelat(); //���൵������
	
	
}
