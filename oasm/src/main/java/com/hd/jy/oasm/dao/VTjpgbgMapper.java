package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.VTjpgbg;

public interface VTjpgbgMapper {
	
	List<VTjpgbg> getAllVT(VTjpgbg vTjpgbg);//��Σ�ճ̶Ȳ�ѯ�ﷸ��Ϣ
	
	List<VTjpgbg> getVTjpgbg(String jq);//ͳ�Ƹ�������Σ�ճ̶ȵ����� 
	
	
}