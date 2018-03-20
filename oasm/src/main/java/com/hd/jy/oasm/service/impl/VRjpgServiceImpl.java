package com.hd.jy.oasm.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.VRjpgMapper;
import com.hd.jy.oasm.domain.VRjpg;
import com.hd.jy.oasm.services.VRjpgService;

@Service("vRjpgServiceImpl")
@DataSource("userDataSource")
public class VRjpgServiceImpl implements VRjpgService{
	
	private Logger log = Logger.getLogger(VRjpgServiceImpl.class);

	@Autowired
	private VRjpgMapper vRjpgMapper;
	
	@Override
	public List<VRjpg> selectAllVrjpg() {
		// TODO Auto-generated method stub
		List<VRjpg> selectAllVrjpg = null; 
		try {
			selectAllVrjpg = vRjpgMapper.selectAllVrjpg();
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getClass()+e.getMessage());
		}
		return selectAllVrjpg;
	}

}
