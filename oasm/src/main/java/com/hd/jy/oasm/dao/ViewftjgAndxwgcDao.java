package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.ViewDasjfx;
import com.hd.jy.oasm.domain.Viewcjjgft;
import com.hd.jy.oasm.domain.Viewcjxwgc;
import com.hd.jy.oasm.domain.Viewrcxwgc;
import com.hd.jy.oasm.domain.Viewrjjgft;
import com.hd.jy.oasm.domain.Viewrjxwgc;
import com.hd.jy.oasm.domain.Viewzqjgft;
import com.hd.jy.oasm.domain.Viewzqxwgc;

/***
 * 
 * @author quite
 *��̸�������Ϊ�۲�ҵ��ӿ�
 */
public interface ViewftjgAndxwgcDao{ 
	//*************************ҳ����ݾ��Ų�ѯ�ṹ��̸****************************************************
	List<Viewrjjgft> showViewrjjgft(String jh);  //���ݾ�����ʾ����̸������ͼ
	
	List<Viewzqjgft> showViewzqjgft(String jh);   //���ݾ�����ʾ���ڷ�̸������ͼ
	
	List<Viewcjjgft> showViewcjjgft(String jh);    //���ݾ�����ʾ�����̸������ͼ
	
	//*************************ҳ����ݾ��Ų�ѯ��Ϊ�۲�*****************************************************
	List<Viewrjxwgc> findViewrjxwgc(String jh);   //���ݾ�����ʾ����̸�ṹ��ͼ
	
	List<Viewrcxwgc> findViewrcxwgc(String jh);   //���ݾ�����ʾ����̸�ṹ��ͼ
	
	List<Viewzqxwgc> findViewzqxwgc(String jh);   //���ݾ�����ʾ����̸�ṹ��ͼ
	
	List<Viewcjxwgc> findViewcjxwgc(String jh);   //���ݾ�����ʾ����̸�ṹ��ͼ
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
