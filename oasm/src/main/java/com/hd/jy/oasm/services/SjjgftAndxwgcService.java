package com.hd.jy.oasm.services;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.domain.ViewDafxjg;

/***
 * 
 * @author quite
 *�ṹ��̸����Ϊ�۲��߼��ӿ�
 *
 *����SjjgftAndxwgcServiceImpl�߼�ʵ���ദ��
 */
public interface SjjgftAndxwgcService {
  //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 //***************************�����������ݲ���****************************************
		/***
		 * 1.ȫ��ѯ�Ѿ��еĵ�����������,�����ڴ���ԭ���ĵ�����������
		 * 2.�����¼���Ż�ȡ����������������json����
		 * ��dafxViewController�е���
		 * @auto quite
		 * @param jcdaid
		 * @returna
		 * ����2:43:37
		 * Sjdafx
		 */
		public TestNote searchDafxjg(String jcdaid); //1
		
		public List<ViewDafxjg> selectDafxjgbg(Map<String,Object> map); //ȫ��ѯ������������б���ͼ��ҳ���б���ʾ
		
}
