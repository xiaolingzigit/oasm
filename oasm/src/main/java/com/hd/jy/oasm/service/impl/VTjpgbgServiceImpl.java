package com.hd.jy.oasm.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.dao.VTjpgbgMapper;
import com.hd.jy.oasm.domain.VTjpgbg;
import com.hd.jy.oasm.services.VTjpgbgService;

@Service("vTjpgbgServiceImpl")
public class VTjpgbgServiceImpl implements VTjpgbgService{

	private static Logger logging = Logger.getLogger(VTjpgbgServiceImpl.class);
	
	@Autowired
	private VTjpgbgMapper vTjpgbgMapper;
	
	/**
	 * 
	 * <p>Title: getAllVT</p>   
	 * <p>Description: 按危险程度、监区查询罪犯信息</p>   
	 * @param vTjpgbg
	 * @return   
	 * @see com.hd.jy.oasm.services.VTjpgbgService#getAllVT(java.lang.String)
	 */
	@Override
	public List<VTjpgbg> getAllVT(VTjpgbg vTjpgbg) {
		// TODO Auto-generated method stub
		List<VTjpgbg> allVT = null;
		try {
			allVT =	vTjpgbgMapper.getAllVT(vTjpgbg);
		} catch (Exception e) {
			// TODO: handle exception
			logging.error("VTjpgbgServiceImpl.getAllVT()方法出错;"+e);
		}
		return allVT;
	}

	/**
	 * 
	 * <p>Title: getVTjpgbg</p>   
	 * <p>Description: 统计各个监区危险程度的人数 </p>   
	 * @param jq
	 * @return   
	 * @see com.hd.jy.oasm.services.VTjpgbgService#getVTjpgbg(java.lang.String)
	 */
	@Override
	public List<VTjpgbg> getVTjpgbg(String jq) {
		// TODO Auto-generated method stub
		List<VTjpgbg> vTjpgbg = null;
		try {
			vTjpgbg = vTjpgbgMapper.getVTjpgbg(jq);
		} catch (Exception e) {
			// TODO: handle exception
			logging.error("VTjpgbgServiceImpl.getVTjpgbg()方法出错;"+e);
		}
		return vTjpgbg;
	}
	

}
