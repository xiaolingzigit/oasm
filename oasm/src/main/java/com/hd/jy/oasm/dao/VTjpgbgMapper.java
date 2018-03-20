package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.VTjpgbg;

public interface VTjpgbgMapper {
	
	List<VTjpgbg> getAllVT(VTjpgbg vTjpgbg);//按危险程度查询罪犯信息
	
	List<VTjpgbg> getVTjpgbg(String jq);//统计各个监区危险程度的人数 
	
	
}