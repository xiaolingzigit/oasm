package com.hd.jy.oasm.test;

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
import com.hd.jy.oasm.dao.newDao.TyskAndwdDao;
import com.hd.jy.oasm.domain.LBKM;
import com.hd.jy.oasm.domain.LbBz;
import com.hd.jy.oasm.domain.WD;
import com.hd.jy.oasm.domain.Yzk;
import com.hd.jy.oasm.domain.ZCYCYQPC;
import com.hd.jy.oasm.domain.newDomain.Tysk;
import com.hd.jy.oasm.services.LBKMService;
import com.hd.jy.oasm.services.LbBzService;
import com.hd.jy.oasm.services.YzkService;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;


/**
 * 
* @ClassName: YzkTest 
* @Description: 因子库相关测试 
* @author liangjiaying
* @date 2017年11月15日 下午10:49:02 
*
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybaits.xml"})
public class YzkTest {
	private Logger logger = Logger.getLogger(YzkTest.class);
	
	@Autowired
	private YzkService yzkService;
	
	@Autowired
	private LBKMService lBKMService;
	
	@Autowired
	private LbBzService lbBzService;
	
	@Autowired
	private TyskAndwdDao tyskDap;
	
	@Test
	public void getAlYzk(){
		PageHelper.startPage(13, 10);
		List<Yzk> allYzk = yzkService.getAllYzk();
		Page page = PageHelper.endPage();
		
		System.out.println(page.toString());
//		logger.info(JSON.toJSON(allYzk));
	}
	
//	@Test
	public void getblkm(){
		List<LBKM> selectRDLB = lBKMService.selectRDLB("2");
		System.out.println(selectRDLB.size());
		
	}
	
//	@Test
	public void getLbbz(){
		List<LbBz> allLbBz = lbBzService.getAllLbBz();
		System.out.println(allLbBz.size());
	}
	
	@Test
	public void getWD(){
		PageHelper.startPage(7, 5);
		lBKMService.selectAllWd();
		Page page = PageHelper.endPage();
		List<WD> list = page.getResult();
		System.out.println(page.toString());
		int[] navigatepageNums = page.getNavigatepageNums();
		for (int i : navigatepageNums) {
			System.out.println(i);
		}
		
//		System.out.println(JSON.toJSON(list));
	}
//	Page{pageNum=1, pageSize=10, startRow=0, endRow=10, total=49, pages=5}
//	Page{pageNum=2, pageSize=10, startRow=10, endRow=20, total=49, pages=5}
	

	//测试异常狱情
	@Test
	public void ycyq(){
		List<ZCYCYQPC> ycyq = lBKMService.selectYCYQ("4413021933");
		logger.info(JSON.toJSON(ycyq));
	}
	
	
	/**********************************以下为修改设计因子维度部分*****************************************/
	@Test //检索维度
	public void likeWd(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("ysbh", "1");
		map.put("ysmc", "现");
		List<Tysk> wdKey = tyskDap.likeSomeWdKey(map);
		logger.info(JSON.toJSON(wdKey));
	}
	
	@Test //检索因子
	public void likeYZ(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("ysbh", "3");
		map.put("ysmc", "无");
		List<Tysk> someTyskKey = tyskDap.likeSomeTyskKey(map);
		logger.info(JSON.toJSON(someTyskKey));
	}
	
	@Test //总检索
	public void likeTysk(){
		Map<String,String> map = new HashMap<String,String>();
//		map.put("ysbh", "wd");
//		map.put("ysmc", "现");
		map.put("yssx", "");
		map.put("ytxz", "2");
//		map.put("yzzpc", "0");
//		map.put("zsxgpc", "0");
//		map.put("xxxgpc", "0");
//		map.put("ttxgpc", "0");
//		map.put("zfzxgpc", "0");
//		map.put("cjsj1", "2018-01-13");
//		map.put("cjsj2", "2018-01-14");
//		map.put("xgsj1", "2018-01-13");
//		map.put("xgsj2", "2018-01-14");
		List<Tysk> tyskKey = tyskDap.likeTyskKey(map);
		logger.info(JSON.toJSON(tyskKey));
	}
}













