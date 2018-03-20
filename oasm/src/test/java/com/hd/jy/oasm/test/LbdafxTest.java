package com.hd.jy.oasm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.domain.LBKM;
import com.hd.jy.oasm.domain.Lbdafx;
import com.hd.jy.oasm.services.LBKMService;
import com.hd.jy.oasm.services.LbdafxService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml"})
public class LbdafxTest {
  private Logger logger = Logger.getLogger(LbdafxTest.class);
  
  @Autowired
  private LbdafxService lbdafxService;
  
  @Autowired
  private LBKMService lbkmService;  //���������ӿ�
  
  @Test
  public void test1(){
	  Lbdafx yz = lbdafxService.selectYz("hyzk");
	  logger.info(JSON.toJSON(yz));
  }
  //ѡ������
  @Test
  public void rjlbk(){
	  List<LBKM> rjlbtmyz = lbkmService.cjlbtmyz("C");
	  logger.info(JSON.toJSON(rjlbtmyz));
  }
  
  //�رջ���������
  @Test
  public void closelb(){
	  int i = lbkmService.closeOrstartLBKMisLive("A");
	  System.out.println(i);
  }
  
  
  @Test
  public void all(){
	  List<LBKM> list = lbkmService.selectAllkm();
	  logger.info(JSON.toJSON(list));
  }
  //��������
//  @Test
//  public void startLb(){
//	  int i = lbkmService.startLBKMisClose("ԭ�����������");
//	  System.out.println(i);
//  }
  
  @Test
  public void splitdh(){
	  String a = "1,2,3,4,5";
	  String[] splitdh = a.split(",");
	  for (int i = 0; i < splitdh.length; i++) {
		System.out.println(splitdh[i]);
	}
  }
}
