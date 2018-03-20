package com.hd.jy.oasm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.domain.LxRj;
import com.hd.jy.oasm.domain.Rjpgsj;
import com.hd.jy.oasm.services.PgLxService;
import com.hd.jy.oasm.services.RjpgsjService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml"})
public class RjpgsjTest {

	private Logger log = Logger.getLogger(RjpgsjTest.class);
	
	@Autowired
	private RjpgsjService rjpgsjService;
	
	
	@Autowired
	private PgLxService pglxService;
	
	
	@Test
	public void lx(){
		 LxRj lxByQh = pglxService.selectLxByQh(4413035402L);
		log.info(JSON.toJSON(lxByQh));
	}
	
	@Test
	public void test1(){
		List<Rjpgsj> list = rjpgsjService.selectDistinct();
		log.info(JSON.toJSON(list));
	}
	
	@Test
	public void test2(){
		List<Rjpgsj> list = rjpgsjService.selectByRjpgsjQh(4413033315L);
		log.info(JSON.toJSON(list));
	}
}


