package com.hd.jy.oasm.services;

import com.hd.jy.oasm.dao.VtjbhMapper;

/**
 * @ClassName: VtjbhService 
 * @Description: ����ͳ������
 * @author liangjiaying
 * @date 2018��1��13�� ����10:17:17
 */
public interface VtjbhService extends VtjbhMapper{
		
	/**
	 * @Title: autoSave  
	 * @Description: ����ͳ������:
	 * 	<p>1.����Σ������ͳ������;<p>
	 * 	<p>2.�����ٷ���ͳ������;<p>
	 * 	<p>3.����Σ�ճ̶�ͳ������<p>
	 */
	void autoSave();

}
