package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.VCjpgMapper;
import com.hd.jy.oasm.domain.VCjpg;
import com.hd.jy.oasm.services.VCjpgService;

@Service("vCjpgServiceImpl")
@DataSource("userDataSource")
public class VCjpgServiceImpl implements VCjpgService{
	
	private Logger log = Logger.getLogger(VCjpgServiceImpl.class);
	
	@Autowired
	private VCjpgMapper vCjpgMapper;

	@Override
	public List<VCjpg> selectAllVcjpg() {
		// TODO Auto-generated method stub
		List<VCjpg> selectAllVcjpg = null;
		try {
			selectAllVcjpg = vCjpgMapper.selectAllVcjpg();
		} catch (Exception e) {
			// TODO: handle exception
			log.info(new Date()+";VCjpgServiceImpl.VCjpgServiceImpl"+e.getMessage());
		}
		return selectAllVcjpg;
	}

}
