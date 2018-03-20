package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.VZqpgMapper;
import com.hd.jy.oasm.domain.VZqpg;
import com.hd.jy.oasm.services.VZqpgService;
@Service("vZqpgServiceImpl")
@DataSource("userDataSource")
public class VZqpgServiceImpl implements VZqpgService {

	private Logger log = Logger.getLogger(VZqpgServiceImpl.class);
	
	@Autowired
	private VZqpgMapper vzqpgDao;
	@Override
	public List<VZqpg> selectAllVzqpg() {
		// TODO Auto-generated method stub
		List<VZqpg> selectAllVzqpg = null;
		try {
			 selectAllVzqpg = vzqpgDao.selectAllVzqpg();
		} catch (Exception e) {
			// TODO: handle exception
			log.info(new Date()+";"+e.getClass()+"model:selectAllVzqpg;"+e.getMessage());
		}
		return selectAllVzqpg;
	}

}
