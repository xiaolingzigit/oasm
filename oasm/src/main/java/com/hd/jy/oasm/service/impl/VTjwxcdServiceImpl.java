package com.hd.jy.oasm.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.dao.VTjwxcdMapper;
import com.hd.jy.oasm.domain.VPgbgWxlx;
import com.hd.jy.oasm.domain.VTjwxcd;
import com.hd.jy.oasm.domain.VTjwxlx;
import com.hd.jy.oasm.domain.Vtjzfz;
import com.hd.jy.oasm.domain.Vwxlx;
import com.hd.jy.oasm.services.VTjwxcdService;

@Service("vTjwxcdServiceImpl")
public class VTjwxcdServiceImpl implements VTjwxcdService{

	private static Logger logging = Logger.getLogger(VTjwxcdServiceImpl.class);
	
	@Autowired
	private VTjwxcdMapper vTjwxcdMapper;
	
	/**
	 * <p>Title: getVjy</p>   
	 * <p>Description: 监狱的危险程度统计数据</p>   
	 * @return   
	 * @see com.hd.jy.oasm.services.VTjwxcdService#getVjy()
	 */
	@Override
	public List<VTjwxcd> getVjy() {
		List<VTjwxcd> vjy = null;
		try {
			vjy = vTjwxcdMapper.getVjy();
		} catch (Exception e) {
			logging.error("VTjwxcdServiceImpl.getVjy();方法出错"+e);
		}
		return vjy;
	}
	
	/**
	 * 
	 * <p>Title: listVTjwxcd</p>   
	 * <p>Description: 危险程度统计</p>   
	 * @return   
	 * @see com.hd.jy.oasm.services.VTjwxcdService#listVTjwxcd()
	 */
	@Override
	public List<VTjwxcd> listVTjwxcd(){
		List<VTjwxcd> listVTjwxcd = null;
		try {
			listVTjwxcd = vTjwxcdMapper.listVTjwxcd();
		} catch (Exception e) {
			logging.error("VTjwxcdServiceImpl#listVTjwxcd"+e);
		}
		return listVTjwxcd;
	}
	

	/**
	 * 
	 * <p>Title: getVPgbgWxlx</p>   
	 * <p>Description: 极高度危险类型列表</p>   
	 * @return   
	 * @see com.hd.jy.oasm.services.VTjwxcdService#getVPgbgWxlx()
	 */
	@Override
	public List<VPgbgWxlx> getVPgbgWxlx() {
		List<VPgbgWxlx> vPgbgWxlx = null;
		try {
			vPgbgWxlx = vTjwxcdMapper.getVPgbgWxlx();
		} catch (Exception e) {
			logging.error("com.hd.jy.oasm.services.VTjwxcdService#getVPgbgWxlx():"+e);
		}
		return vPgbgWxlx;
	}

	/**
	 * <p>Title: getVTjwxlx</p>   
	 * <p>Description: 统计各个监区高危险倾向数量</p>   
	 * @return   
	 * @see com.hd.jy.oasm.services.VTjwxcdService#getVTjwxlx()
	 */
	@Override
	public List<VTjwxlx> getVTjwxlx() {
		List<VTjwxlx> vTjwxlx = null;
		try {
			vTjwxlx = vTjwxcdMapper.getVTjwxlx();
		} catch (Exception e) {
			logging.error("VTjwxcdService#getVTjwxlx();"+e);
		}
		return vTjwxlx;
	}

	/**
	 * <p>Title: listTjWxlx</p>   
	 * <p>Description:统计各个监区危险类别数量 </p>   
	 * @return   
	 * @see com.hd.jy.oasm.services.VTjwxcdService#listTjWxlx()
	 */
	@Override
	public List<Vwxlx> listTjWxlx() {
		List<Vwxlx> listTjWxlx = null;
		try {
			listTjWxlx = vTjwxcdMapper.listTjWxlx();
		} catch (Exception e) {
			logging.error("VTjwxcdService#listTjWxlx():出错！"+e);
		}
		return listTjWxlx;
	}

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
