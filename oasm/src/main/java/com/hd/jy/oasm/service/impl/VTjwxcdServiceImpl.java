package com.hd.jy.oasm.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.dao.VTjwxcdMapper;
import com.hd.jy.oasm.domain.Vtjzfz;
import com.hd.jy.oasm.services.VTjwxcdService;

@Service("vTjwxcdServiceImpl")
public class VTjwxcdServiceImpl implements VTjwxcdService{

	private static Logger logging = Logger.getLogger(VTjwxcdServiceImpl.class);
	
	@Autowired
	private VTjwxcdMapper vTjwxcdMapper;
	
	/**
	 * <p>Title: listTjZfz</p>   
	 * <p>Description: 统计再犯罪倾向</p>   
	 * @return   
	 * @see com.hd.jy.oasm.services.VTjwxcdService#listTjZfz()
	 */
	@Override
	public List<Vtjzfz> listTjZfz() {
		List<Vtjzfz> listTjZfz = null;
		try {
			listTjZfz = vTjwxcdMapper.listTjZfz();
		} catch (Exception e) {
			logging.error("VTjwxcdService#listTjZfz():出错！"+e);
		}
		return listTjZfz;
	}


}
