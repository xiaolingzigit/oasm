package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.VTjpgbg;

public interface VTjpgbgService {
	/**
	 * 
	 * <p>Title: getAllVT</p>   
	 * <p>Description: 按危险程度、监区查询罪犯信息</p>   
	 * @param vTjpgbg
	 * @return   
	 */
	List<VTjpgbg> getAllVT(VTjpgbg vTjpgbg);
	
	/**
	 * <p>Title: getVTjpgbg</p>   
	 * <p>Description: 统计各个监区危险程度的人数 </p>   
	 * @param jq	（监区）
	 * @return   
	 */
	List<VTjpgbg> getVTjpgbg(String jq);

}
