package com.hd.jy.oasm.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.dao.ListLineMapper;
import com.hd.jy.oasm.dao.SjjgftAndxwgcDao;
import com.hd.jy.oasm.dao.TaskMapper;
import com.hd.jy.oasm.dao.TestMapper;
import com.hd.jy.oasm.dao.ZCYCYQPCMapper;
import com.hd.jy.oasm.dao.newDao.ViewpgglMapper;
import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.domain.SearchElement;
import com.hd.jy.oasm.domain.TevalReport;
import com.hd.jy.oasm.domain.VPgbgList;
import com.hd.jy.oasm.domain.ViewDafxjg;
import com.hd.jy.oasm.domain.Viewrwxq;
import com.hd.jy.oasm.domain.ZCYCYQPC;
import com.hd.jy.oasm.domain.newDomain.Viewpggl;
import com.hd.jy.oasm.services.VPgbgListService;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;

import sun.util.logging.resources.logging;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml"})
public class ViewPGBGTeset {
	
	private static Logger logging = Logger.getLogger(ViewPGBGTeset.class);
	
	@Autowired
	private VPgbgListService vPgbgListService;
	
	@Autowired
	private TestMapper testNoteDao;
	
	@Autowired
	private SjjgftAndxwgcDao sjxwgcDao;
	
	@Autowired
	private ZCYCYQPCMapper ycyqDao;
	
	@Autowired
	private ViewpgglMapper pgglDao;
	
	@Autowired
	private ListLineMapper listLineDao;
	
	@Autowired
	private TaskMapper taskDao; 
	
	//评估报告列表
	@Test
	public void getViewPgbg(){
		Map<String,Object> map = new HashMap<>();
//		map.put("jh", "9874561");
		
		map.put("type", "inRep");
//		map.put("crim_no", "4413022086");
		List<VPgbgList> viewPgbg = vPgbgListService.getViewPgbg(map);
//		List<VPgbgList> viewPgbg = vPgbgListService.getViewPgbg(null);
		System.out.println("viewPgbg.json(): "+JSON.toJSONString(viewPgbg));
		
		/*
			dyRep	日常评估报告
			inRep	入监评估报告
			mdRep	中期评估报告
			otRep	出监评估报告
		 */
	}
	
	//个人危险等级变化
	@Test
	public void getGrdjbh(){
		
		String qh="4403012710";
		List<VPgbgList> grdjbh = vPgbgListService.getGrdjbh(qh);
		logging.info(JSON.toJSONString(grdjbh));
		logging.info(grdjbh.size());
		
		List<VPgbgList> grdjbh2 = vPgbgListService.getGrdjbh("");
//		logging.info(JSON.toJSONString(grdjbh2));
		logging.info(grdjbh2.size());
	}
	
	//个人历史评估报告
	@Test
	public void getLsPgbg(){
		String qh="4403012710";
		List<VPgbgList> lsPgbg = vPgbgListService.getLsPgbg(qh);
		for (VPgbgList vPgbgList : lsPgbg) {
			System.out.println("*******************"+JSON.toJSONString(vPgbgList));
		}
//		logging.info(JSON.toJSONString(lsPgbg));
//		logging.info(lsPgbg.size());
		
//		List<VPgbgList> lsPgbg2 = vPgbgListService.getLsPgbg("");
//		logging.info(JSON.toJSONString(lsPgbg2));
//		logging.info(lsPgbg2.size());
	}
	
	@Test
	public void pglist(){
		String note = vPgbgListService.getPgbgTestNote(4,"4416043539_inRep_201712232035");
		System.out.println(note);
	}
	
	@Test
	public void testType(){
		List<Viewrwxq> list = testNoteDao.getChildrenStatus("4413026500_otRep_201712241753");
		logging.info(JSON.toJSON(list));
	}

	@Test
	public void testLeval(){
		TevalReport report = testNoteDao.evalReportCount("4403012710_dyRep_201710290100");
		logging.info(JSON.toJSON(report));
		System.out.println(report.getTaskId());
	}
	
	@Test
	public void testViJBxx(){
		BGjbxx bycrimNo = vPgbgListService.crimInfoBycrimNo("4409045841");
		logging.info(JSON.toJSON(bycrimNo));
	}
	
	@Test
	public void testGr(){
		List<VPgbgList> list = vPgbgListService.getGrdjbh("4409045841");
		logging.info(JSON.toJSON(list));
	}
	
	public static void main(String[] args) {
		String a = "170111";
		SimpleDateFormat csdf = new SimpleDateFormat("yy年MM月dd日");
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		try {
			Date date = sdf.parse(a);
			String fmtxq = csdf.format(date);
			System.out.println(fmtxq);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//根据囚号显示已有分数的评估报告
	@Test
	public void reportTest(){
		List<TevalReport> report = testNoteDao.crimInfoReport("4413031305");
		logging.info(JSON.toJSON(report));
	}
	
	//根据囚号显示已有分数的个人档案分析结果
	@Test
	public void dajgTest(){
		List<ViewDafxjg> dafxjg = sjxwgcDao.crimInfoDafxjg("4406047544");
		logging.info(JSON.toJSON(dafxjg));
	}
	
	//根据囚号测试异常狱情
	@Test
	public void yuqiTest(){
		List<ZCYCYQPC> ycyq = ycyqDao.selectYCYQ("4413021933");
		logging.info(JSON.toJSON(ycyq));
	}
	
	//根据囚号显示个人结构访谈
	@Test
	public void grft(){
		List<Viewpggl> infoGrft = pgglDao.crimInfoGrft("4403012710");
		logging.info(JSON.toJSON(infoGrft));
	}
	
	//根据囚号显示个人行为观察
	@Test
	public void grgc(){
		List<Viewpggl> infoGrgc = pgglDao.crimInfoGrgc("4403012710");
		logging.info(JSON.toJSON(infoGrgc));
	}
	
	//根据囚号显示心理测试报告
	@Test
	public void xlTest(){
		List<SearchElement> xl = listLineDao.crimInfoXL("4403012710");
		logging.info(JSON.toJSON(xl));
		
	}
	
	@Test
	public void newTest(){
		String taskId = taskDao.getNewReport("4413025402");
		System.out.println(taskId);
	}
	
	//测试封装的数据
	@Test
	public void jsonCrim(){
		String record = vPgbgListService.getCrimInfoRecord("4403012710");
		System.out.println(record);
	}
	
	//显示报告处理跟踪、审核、意见
	@Test
	public void listViewPgbgAndTCzsh(){
		PageHelper.startPage(1, 10);
		Map<String,Object> map = new HashMap<>();
		map.put("jh", "");
		map.put("type", "dyRep".trim());
		map.put("gyjqmc", "".trim());
		map.put("crim_no", "".trim());
		map.put("xm", "".trim());
		map.put("jhxm", "".trim());
		map.put("levl", "".trim());
		map.put("stat", "4");
		 
		String czgz = "1";
		String wpyj = "0";
		String hy = "0";
		if("1".equals(czgz)){
			map.put("czlrsj", czgz.trim());
		}else{
			map.put("czlrsj", "");
		}
		if("1".equals(hy)){
			map.put("jqshsj", hy.trim());
		}else{
			map.put("jqshsj", "");
		}
		if("1".equals(wpyj)){
			map.put("wpclsj", wpyj.trim());
		}else{
			map.put("wpclsj", "");
		}
		vPgbgListService.listViewPgbgAndTCzsh(map);
		Page page = PageHelper.endPage();
		
		logging.debug("***************************************************************************");
		logging.debug(JSON.toJSON(page));
		
	}
	
}







