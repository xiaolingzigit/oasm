package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.Daftdc;

public interface DaftdcService {
	public int ftSaveOrUpdate(Daftdc record);  //访谈调查答案
	
	
	public List<Daftdc> selectFtdc(); //访谈调查选项卡分数
}
