package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.VTjpgbg;

public interface VTjpgbgService {
	/**
	 * 
	 * <p>Title: getAllVT</p>   
	 * <p>Description: ��Σ�ճ̶ȡ�������ѯ�ﷸ��Ϣ</p>   
	 * @param vTjpgbg
	 * @return   
	 */
	List<VTjpgbg> getAllVT(VTjpgbg vTjpgbg);
	
	/**
	 * <p>Title: getVTjpgbg</p>   
	 * <p>Description: ͳ�Ƹ�������Σ�ճ̶ȵ����� </p>   
	 * @param jq	��������
	 * @return   
	 */
	List<VTjpgbg> getVTjpgbg(String jq);

}
