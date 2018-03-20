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
  private ZuoTiSerivce zuotiService; //�����߼��ӿ�
  
  @Autowired
  private TestMapper testDao;
  
  @Autowired
  private SjjgftAndxwgcDao sjjggcDao; //���ҵ��ӿ�
  
  @Autowired
  private TdminAndtyzService tdService; //ά�����������߼��ӿ�
  
  @Autowired
  private TdminAndtyzDao tdminAndyzDao; //ά����������ҵ��ӿ�
  
  @Autowired
  private ListLineMapper listLineDao;
  
  
  
  //����mybatis�������
  @Test
  public void test66(){
	  LBjcdafx dafxParam = sjjggcDao.selectMoreDafxParam("ǰ��", 1);
	  log.info("ǰ��"+JSON.toJSON(dafxParam));
  }
 
  //��������ƥ���������
  @Test
  public void test99(){
	  int i = zuotiService.autoGuize();
	  System.out.println("��������ƥ���������"+i);
	  
  }
  
  
  //���Ե������������ʾ���
//  @Test
//  public void testFxjg(){
//	  List<Sjdafx> dafxbg = sjjgftAndxwgcService.selectDafxbg();
//	  log.info("���Ե������������ʾ���"+JSON.toJSON(dafxbg));
//  }
  
  //����ά��
  @Test
  public void testTdmin(){
	  List<Tdmin> tdmin = tdService.listTdmin();
	  log.info(JSON.toJSON(tdmin));
  }
  
  //������������
  @Test
  public void testname(){
	 int name = tdService.selectByfactorName("3�������޼������������绰�����Ż���");
	 log.info(name);
  }
  
  //ά�Ⱥ����ӹ�ϵ�б�
  @Test
  public void testselectDimAndFactor(){
	  List<TdminfactorRelat> dimAndFactor = tdService.selectDimAndFactor();
	  log.info(JSON.toJSON(dimAndFactor));
  }
  
  //ά�Ⱥ������ϵ
  @Test
  public void dim_quest(){
	  String question = tdService.allQuestion("");
	  log.info(JSON.toJSON(question));
  }
  
  //ͨ�������Ų�ѯ��������
  @Test
  public void testConf(){
	  Tscale byScaleId = tdminAndyzDao.getScaleByScaleId(6);
	  log.info(JSON.toJSON(byScaleId));
  }
  
  //�����ṹ��̸
  @Test
  public void testQue(){
	  String question = zuotiService.cjxwgcQuestion("458741232_mdTk_201712071146".trim());
		  System.out.println("���գ�"+question);
  }
  
  //�����¼
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
  
  //���Ի�����Ϣ����
  @Test
  public void testJcxxpg(){
	  List<BGjcxxpg> jcxxpg = testDao.getAllJcxxpg("4402067907_dyFileAnlys_20171229144");
	  for (BGjcxxpg bGjcxxpg : jcxxpg) {
		System.out.println(bGjcxxpg);
	}
  }
  
  //������������
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
  
  //����ҵ���
  @Test
  public void testYzWd(){
	  int i = tdminAndyzDao.checkBytfactorName("��ҩ������ʷ", 1);
	  System.out.println(i);
  }
  
  //�����߼���
  @Test
  public void testYzWdSe(){
	  int i = tdService.checkBytfactorName("��ҩ������ʷ", 1);
	  System.out.println(i);
  }
  //��֤������
  @Test
  public void nameFname(){
	  int a = tdminAndyzDao.chckHaveFname("��ҩ������ʷ");
	  System.out.println("��"+a+"��");
  }
  
  
  //�������Ӻ�ά�ȱ�Ź�ϵ
  @Test
  public void wdyzRa(){
	  int i = tdService.checkDimIdFId(1, 0);
	  System.out.println(i);
  }
  //��������ά�ȹ�ϵ
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
	  System.out.println("�޸�"+i);
  }
}
