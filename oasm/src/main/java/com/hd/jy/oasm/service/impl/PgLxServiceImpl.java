package com.hd.jy.oasm.service.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.LxCjMapper;
import com.hd.jy.oasm.dao.LxRcMapper;
import com.hd.jy.oasm.dao.LxRjMapper;
import com.hd.jy.oasm.domain.LxCj;
import com.hd.jy.oasm.domain.LxRc;
import com.hd.jy.oasm.domain.LxRj;
import com.hd.jy.oasm.services.PgLxService;
@Service("pgLxServiceImpl")
@DataSource("userDataSource")
public class PgLxServiceImpl implements PgLxService{
   private Logger log = Logger.getLogger(PgLxServiceImpl.class);
	
   @Autowired
   private LxRjMapper lxrjDao;
   
   @Autowired
   private LxRcMapper lxrcDao;
   
   @Autowired
   private LxCjMapper lxcjDao;

@Override
public LxRj selectLxByQh(long qh) {
	// TODO Auto-generated method stub
	return lxrjDao.selectLxByQh(qh);
}

@Override
public LxRc selectLxrc(long qh) {
	// TODO Auto-generated method stub
	return lxrcDao.selectLxrc(qh);
}

@Override
public LxCj selectLxcj(long qh) {
	// TODO Auto-generated method stub
	return lxcjDao.selectLxcj(qh);
}

}
