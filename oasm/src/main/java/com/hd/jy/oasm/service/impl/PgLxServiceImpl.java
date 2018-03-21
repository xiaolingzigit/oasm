package com.hd.jy.oasm.service.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.LxCjMapper;
import com.hd.jy.oasm.domain.LxCj;
import com.hd.jy.oasm.services.PgLxService;
@Service("pgLxServiceImpl")
@DataSource("userDataSource")
public class PgLxServiceImpl implements PgLxService{
   private Logger log = Logger.getLogger(PgLxServiceImpl.class);
   
   @Autowired
   private LxCjMapper lxcjDao;



@Override
public LxCj selectLxcj(long qh) {
	// TODO Auto-generated method stub
	return lxcjDao.selectLxcj(qh);
}

}
