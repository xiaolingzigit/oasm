package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.Daftdc;

public interface DaftdcService {
	public int ftSaveOrUpdate(Daftdc record);  //��̸�����
	
	
	public List<Daftdc> selectFtdc(); //��̸����ѡ�����
}
