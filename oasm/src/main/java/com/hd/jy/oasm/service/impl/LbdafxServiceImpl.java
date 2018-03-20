package com.hd.jy.oasm.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.LbdafxMapper;
import com.hd.jy.oasm.domain.Lbdafx;
import com.hd.jy.oasm.services.LbdafxService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("lbdafxServiceImpl")
@DataSource("userDataSource")
public class LbdafxServiceImpl implements LbdafxService {
   private Logger log  = Logger.getLogger(LbdafxServiceImpl.class);
	@Autowired
	private LbdafxMapper lbdafxDao;
	@Override
	public Lbdafx selectYz(String sjxbm) {
		// TODO Auto-generated method stub
		Lbdafx yz=null;
		try {
			yz = lbdafxDao.selectYz(sjxbm);
			log.info("时间"+DateUtil.getTime(new Date())+" 数据报文: "+JSON.toJSON(yz));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yz;
	}

}
