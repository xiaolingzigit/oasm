package com.hd.jy.oasm.services;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.ViewDasjfx;
import com.hd.jy.oasm.domain.Viewcjjgft;
import com.hd.jy.oasm.domain.Viewcjxwgc;
import com.hd.jy.oasm.domain.Viewrcxwgc;
import com.hd.jy.oasm.domain.Viewrjjgft;
import com.hd.jy.oasm.domain.Viewrjxwgc;
import com.hd.jy.oasm.domain.Viewzqjgft;
import com.hd.jy.oasm.domain.Viewzqxwgc;
import com.hd.jy.oasm.domain.newDomain.Viewpggl;

public interface ViewftjgAndxwgcService {
	//*************************ҳ����ݾ��Ų�ѯ�ṹ��̸****************************************************
		public List<Viewrjjgft> showViewrjjgft(String jh);  //���ݾ�����ʾ����̸������ͼ
		
		public List<Viewzqjgft> showViewzqjgft(String jh);   //���ݾ�����ʾ���ڷ�̸������ͼ
		
		public List<Viewcjjgft> showViewcjjgft(String jh);    //���ݾ�����ʾ�����̸������ͼ
		
		//*************************ҳ����ݾ��Ų�ѯ��Ϊ�۲�*****************************************************
		public List<Viewrjxwgc> findViewrjxwgc(String jh);   //���ݾ�����ʾ����̸�ṹ��ͼ
		
		public List<Viewrcxwgc> findViewrcxwgc(String jh);   //���ݾ�����ʾ����̸�ṹ��ͼ
		
		public List<Viewzqxwgc> findViewzqxwgc(String jh);   //���ݾ�����ʾ����̸�ṹ��ͼ
		
		public List<Viewcjxwgc> findViewcjxwgc(String jh);   //���ݾ�����ʾ����̸�ṹ��ͼ
		
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//*****************************���ϴ������************************************************************
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//***************����v_pggl��ͼ	���ɶ���࣬�ճ������ڣ�������ͼ���ݽ���չʾ*******************
		public List<Viewpggl> rjjgftViewpggl(Map<String,Object> map); //�������ṹ��̸��¼�Ĺ������Ŷ�̬��ѯ��ͼ
		
		public List<Viewpggl> rjxwgcViewpggl(Map<String,Object> map); //���������Ϊ�۲쾯�Ŷ�̬��ѯ��ͼ
		
		public List<Viewpggl> rcxwgcViewpggl(Map<String,Object> map); //�ճ���Ϊ�۲춯̬��ͼ
		    
		public List<Viewpggl> zqjgftViewpggl(Map<String,Object> map);//���ڷ�̸��̬������ͼ
		    
		public List<Viewpggl> zqxwgcViewpggl(Map<String,Object> map); //���ڹ۲춯̬������ͼ
		    
		public List<Viewpggl> cjjgftViewpggl(Map<String,Object> map);//�����̸��̬������ͼ
		    
		public List<Viewpggl> cjxwgcViewpggl(Map<String,Object> map);//����۲춯̬������ͼ
		
}
