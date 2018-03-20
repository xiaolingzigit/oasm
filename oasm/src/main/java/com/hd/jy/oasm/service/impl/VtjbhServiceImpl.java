package com.hd.jy.oasm.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.dao.VtjbhMapper;
import com.hd.jy.oasm.services.VtjbhService;

@Service("vtjbhServiceImpl")
public class VtjbhServiceImpl implements VtjbhService{
	
	private static Logger log = Logger.getLogger(VtjbhServiceImpl.class);

	@Autowired
	private VtjbhMapper vtjbhMapper;
	/**
	 * <p>Title: autoSave</p>   
	 * <p>Description: </p>   
	 * <p> 1.保存危险类型统计数据;<p>
	 * <p> 2.保存再犯罪统计数据;<p>
	 * <p> 3.保存危险程度统计数据<p>
	 * @see com.hd.jy.oasm.services.VtjbhService#autoSave()
	 */
	@Override
	public void autoSave() {
		try {
			vtjbhMapper.autoSave();
		} catch (Exception e) {
			log.error("VtjbhService#autoSave():出错！"+e);
		}
	}

}
