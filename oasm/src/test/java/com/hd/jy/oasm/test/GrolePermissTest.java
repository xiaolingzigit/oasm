package com.hd.jy.oasm.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.domain.GrolePermiss;
import com.hd.jy.oasm.services.GrolePermissionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml"})
public class GrolePermissTest {
  private static Logger logger = Logger.getLogger(GrolePermissTest.class);
  
  @Autowired
  private GrolePermissionService grolePermissionService;
  @Test
  public void test1(){
	  GrolePermiss permiss = grolePermissionService.selectRole("1101106");
	  logger.info(JSON.toJSON(permiss));
  }
  
}
