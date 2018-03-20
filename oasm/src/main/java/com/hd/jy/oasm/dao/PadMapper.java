package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.model.pad.padmodel.CriminalInfo;
import com.hd.jy.oasm.model.pad.padmodel.PoliceInfo;

public interface PadMapper {

	/**
	 * 获取警员信息
	 * 
	 * @param jh
	 * @return
	 */
	List<PoliceInfo> getCopInfo(String jh);
	
	
	/**
	 * 获取囚犯信息
	 * 
	 * @param jh
	 * @return
	 */
	List<CriminalInfo> getCrimInfo(String jh);
	
	
	

}
