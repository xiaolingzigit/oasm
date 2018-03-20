package com.hd.jy.oasm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.hd.jy.oasm.domain.Daftdc;
import com.hd.jy.oasm.services.DaftdcService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml"})
public class FtdcTest {
   private Logger log = Logger.getLogger(FtdcTest.class);
   
   
   @Autowired
   private DaftdcService daftdcService;
	
	@Test
	public void test2(){
		List<Daftdc> list = daftdcService.selectFtdc();
		PageHelper.startPage(1, 2);
		log.info(JSON.toJSON(list));
	}
}
