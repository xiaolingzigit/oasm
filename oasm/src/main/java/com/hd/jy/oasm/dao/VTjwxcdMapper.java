package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.VPgbgWxlx;
import com.hd.jy.oasm.domain.VTjwxcd;
import com.hd.jy.oasm.domain.VTjwxlx;
import com.hd.jy.oasm.domain.Vtjzfz;
import com.hd.jy.oasm.domain.Vwxlx;

public interface VTjwxcdMapper {
	
	/**
	 * <p>Title: listVTjwxcd</p>   
	 * <p>Description: 危险程度统计</p>   
	 */
	List<VTjwxcd> listVTjwxcd();
	
	/**
	 * <p>Title: getVjy</p>   
	 * <p>Description: 监狱的危险程度统计数据</p>   
	 */
	List<VTjwxcd> getVjy();
	
	/**
	 * <p>Title: getVPgbgWxlx</p>   
	 * <p>Description: 极高度危险类型列表</p>   
	 */
	List<VPgbgWxlx> getVPgbgWxlx();
	
	/**
	 * <p>Title: getVTjwxlx</p>   
	 * <p>Description: 统计各个监区高危险倾向数量</p>   
	 */
	List<VTjwxlx> getVTjwxlx();
	
	/**
	 * <p>Title: listTjWxlx</p>   
	 * <p>Description: 统计各个监区危险类别数量</p>   
	 */
	List<Vwxlx> listTjWxlx();

	/**
	 * <p>Title: listTjZfz</p>   
	 * <p>Description: 	统计再犯罪倾向</p>   
	 */
	List<Vtjzfz> listTjZfz();
}

