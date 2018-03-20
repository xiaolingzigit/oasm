package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.VRcpgMapper;
import com.hd.jy.oasm.domain.VRcpg;
import com.hd.jy.oasm.services.VRcpgService;

@Service("vRcpgServiceImpl")
@DataSource("userDataSource")
public class VRcpgServiceImpl implements VRcpgService{

	private Logger log = Logger.getLogger(VRcpgServiceImpl.class);
	@Autowired
	private VRcpgMapper vRcpgMapper;
	
	@Override
	public List<VRcpg> selectAllVrcpg() {
		// TODO Auto-generated method stub
		List<VRcpg> selectAllVrcpg = null;
		try {
			selectAllVrcpg = vRcpgMapper.selectAllVrcpg();
		} catch (Exception e) {
			// TODO: handle exception
			log.info(new Date()+"VRcpgServiceImpl.selectAllVrcpg();"+e.getMessage());
		}
		return selectAllVrcpg;
	}

}
