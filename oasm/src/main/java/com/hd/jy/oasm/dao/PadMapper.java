package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.model.pad.padmodel.CriminalInfo;
import com.hd.jy.oasm.model.pad.padmodel.PoliceInfo;

public interface PadMapper {

	/**
	 * ��ȡ��Ա��Ϣ
	 * 
	 * @param jh
	 * @return
	 */
	List<PoliceInfo> getCopInfo(String jh);
	
	
	/**
	 * ��ȡ������Ϣ
	 * 
	 * @param jh
	 * @return
	 */
	List<CriminalInfo> getCrimInfo(String jh);
	
	
	

}
