package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.RjpgsjMapper;
import com.hd.jy.oasm.domain.Rjpgsj;
import com.hd.jy.oasm.services.RjpgsjService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("rjpgsjServiceImpl")
@DataSource("userDataSource")
public class RjpgsjServiceImpl implements RjpgsjService {
	private Logger log = Logger.getLogger(RjpgsjServiceImpl.class);
	
	@Autowired
	private RjpgsjMapper rjpgsjDao;

	@Override
	public List<Rjpgsj> selectDistinct() {
		// TODO Auto-generated method stub
		List<Rjpgsj> list = null;
		try {
			log.info("开始查询囚号去重时间"+DateUtil.getTime(new Date()));
			list = rjpgsjDao.selectDistinct();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Rjpgsj> selectByRjpgsjQh(Long qh) {
		// TODO Auto-generated method stub
		List<Rjpgsj> rjqh = null;
		try {
			log.info("开始查询qh答题情况"+DateUtil.getTime(new Date()));
			rjqh = rjpgsjDao.selectByRjpgsjQh(qh);
			for (Rjpgsj pgsj : rjqh) {
				System.out.println(pgsj.getFx());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rjqh;
	}

}
