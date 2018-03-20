package com.hd.jy.oasm.services;

import com.hd.jy.oasm.dao.VtjbhMapper;

/**
 * @ClassName: VtjbhService 
 * @Description: 保存统计数据
 * @author liangjiaying
 * @date 2018年1月13日 上午10:17:17
 */
public interface VtjbhService extends VtjbhMapper{
		
	/**
	 * @Title: autoSave  
	 * @Description: 保存统计数据:
	 * 	<p>1.保存危险类型统计数据;<p>
	 * 	<p>2.保存再犯罪统计数据;<p>
	 * 	<p>3.保存危险程度统计数据<p>
	 */
	void autoSave();

}
