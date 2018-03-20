package com.hd.jy.oasm.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.dao.ListLineMapper;
import com.hd.jy.oasm.dao.SjjgftAndxwgcDao;
import com.hd.jy.oasm.dao.TestMapper;
import com.hd.jy.oasm.dao.newDao.TdminAndtyzDao;
import com.hd.jy.oasm.domain.BGjcxxpg;
import com.hd.jy.oasm.domain.LBjcdafx;
import com.hd.jy.oasm.domain.PgXlcsJg;
import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.domain.newDomain.Tdmin;
import com.hd.jy.oasm.domain.newDomain.TdminfactorRelat;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.services.TdminAndtyzService;
import com.hd.jy.oasm.services.ZuoTiSerivce;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml"})
public class ZuoTiTest {
  private Logger log = Logger.getLogger(ZuoTiTest.class);
  
  @Autowired
  private ZuoTiSerivce zuotiService; //做题逻辑接口
  
  @Autowired
  private TestMapper testDao;
  
  @Autowired
  private SjjgftAndxwgcDao sjjggcDao; //结果业务接口
  
  @Autowired
  private TdminAndtyzService tdService; //维度因子问题逻辑接口
  
  @Autowired
  private TdminAndtyzDao tdminAndyzDao; //维度因子问题业务接口
  
  @Autowired
  private ListLineMapper listLineDao;
  
  
  
  //测试mybatis多个参数
  @Test
  public void test66(){
	  LBjcdafx dafxParam = sjjggcDao.selectMoreDafxParam("前科", 1);
	  log.info("前科"+JSON.toJSON(dafxParam));
  }
 
  //档案分析匹配规则后入库
  @Test
  public void test99(){
	  int i = zuotiService.autoGuize();
	  System.out.println("档案分析匹配规则后入库"+i);
	  
  }
  
  
  //测试档案分析结果显示结果
//  @Test
//  public void testFxjg(){
//	  List<Sjdafx> dafxbg = sjjgftAndxwgcService.selectDafxbg();
//	  log.info("测试档案分析结果显示结果"+JSON.toJSON(dafxbg));
//  }
  
  //测试维度
  @Test
  public void testTdmin(){
	  List<Tdmin> tdmin = tdService.listTdmin();
	  log.info(JSON.toJSON(tdmin));
  }
  
  //测试因子名字
  @Test
  public void testname(){
	 int name = tdService.selectByfactorName("3个月内无家属会见、亲情电话、书信或汇款");
	 log.info(name);
  }
  
  //维度和因子关系列表
  @Test
  public void testselectDimAndFactor(){
	  List<TdminfactorRelat> dimAndFactor = tdService.selectDimAndFactor();
	  log.info(JSON.toJSON(dimAndFactor));
  }
  
  //维度和问题关系
  @Test
  public void dim_quest(){
	  String question = tdService.allQuestion("");
	  log.info(JSON.toJSON(question));
  }
  
  //通过量表编号查询配置内容
  @Test
  public void testConf(){
	  Tscale byScaleId = tdminAndyzDao.getScaleByScaleId(6);
	  log.info(JSON.toJSON(byScaleId));
  }
  
  //测入监结构访谈
  @Test
  public void testQue(){
	  String question = zuotiService.cjxwgcQuestion("458741232_mdTk_201712071146".trim());
		  System.out.println("最终："+question);
  }
  
  //做题记录
  @Test
  public void record(){
	  TestNote note = zuotiService.getNote("148523690_inAct_201712071143");
	  log.info(JSON.toJSON(note));
  }
  
  @Test
  public void zero(){
	  int a = 00001;
	  System.out.println(a);
  }
  
  
  @Test
  public void noteTest(){
	  String wxdj = testDao.getWxdj(105,"rj");
	  System.out.println("++++++++++++++++++++++++++++"+wxdj+"+++++++++++++++++++++++++++++++++++");
  }
  
//  public static void main(String[] args) {
//	String taskId = "4413021167_dyRep_201712241420";
//	String qh = taskId.substring(0, 10);
//	System.out.println(qh);
//}
  
  //测试基础信息评估
  @Test
  public void testJcxxpg(){
	  List<BGjcxxpg> jcxxpg = testDao.getAllJcxxpg("4402067907_dyFileAnlys_20171229144");
	  for (BGjcxxpg bGjcxxpg : jcxxpg) {
		System.out.println(bGjcxxpg);
	}
  }
  
  //测试心理评估
  @Test
  public void testxlpg(){
	List<PgXlcsJg> allPgxlcsjg = listLineDao.getAllPgxlcsjg("4402067907_dyCopaMt_201712291444");
	log.info(JSON.toJSON(allPgxlcsjg));
  }
  
  public static void main(String[] args) {
	String a = "1111000_inAct_2018";
	String b = "Act_";
	System.out.println(a.contains(b));
}
  
  //测试业务层
  @Test
  public void testYzWd(){
	  int i = tdminAndyzDao.checkBytfactorName("有药物滥用史", 1);
	  System.out.println(i);
  }
  
  //测试逻辑层
  @Test
  public void testYzWdSe(){
	  int i = tdService.checkBytfactorName("无药物滥用史", 1);
	  System.out.println(i);
  }
  //验证因子名
  @Test
  public void nameFname(){
	  int a = tdminAndyzDao.chckHaveFname("无药物滥用史");
	  System.out.println("有"+a+"个");
  }
  
  
  //测试因子和维度编号关系
  @Test
  public void wdyzRa(){
	  int i = tdService.checkDimIdFId(1, 0);
	  System.out.println(i);
  }
  //测试因子维度关系
  @Test
  public void wdyzRe(){
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("da", 1);
	  map.put("fa", 1);
	  map.put("lastModif", new Date());
	  map.put("modifier", "admin");
	  map.put("db", 10);
	  map.put("fb", 10);
	  int i = tdminAndyzDao.updateWdAndYzRelat(map);
	  System.out.println("修改"+i);
  }
}
