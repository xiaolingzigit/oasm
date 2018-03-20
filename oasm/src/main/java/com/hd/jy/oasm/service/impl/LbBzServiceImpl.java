package com.hd.jy.oasm.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.LbBzMapper;
import com.hd.jy.oasm.domain.LbBz;
import com.hd.jy.oasm.services.LbBzService;

@Service("lbBzServiceImpl")
@DataSource("userDataSource")
public class LbBzServiceImpl implements LbBzService{
	
	static final Logger log = Logger.getLogger(LbBzServiceImpl.class);
	
	@Autowired
	private LbBzMapper lbBzMapper;
	
	//获取量表配置列表
	@Override
	public List<LbBz> getAllLbBz() {
		// TODO Auto-generated method stub
		List<LbBz> allLbBz = null;
		try {
			allLbBz = lbBzMapper.getAllLbBz();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("获取量表配置列表出错"+e);
		}
		return allLbBz;
	}
	
}
