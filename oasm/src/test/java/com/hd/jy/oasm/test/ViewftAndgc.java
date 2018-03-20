package com.hd.jy.oasm.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.dao.TzyrymdMapper;
import com.hd.jy.oasm.dao.ViewftjgAndxwgcDao;
import com.hd.jy.oasm.dao.newDao.ViewpgglMapper;
import com.hd.jy.oasm.domain.Tzyrymd;
import com.hd.jy.oasm.domain.ViewDasjfx;
import com.hd.jy.oasm.domain.Viewrjjgft;
import com.hd.jy.oasm.domain.Viewrjxwgc;
import com.hd.jy.oasm.domain.newDomain.Viewpggl;
import com.hd.jy.oasm.services.TzyrymdService;
import com.hd.jy.oasm.services.ViewftjgAndxwgcService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml" })
public class ViewftAndgc {
   private Logger log = Logger.getLogger(ViewftAndgc.class);
   
   @Autowired
   private ViewpgglMapper viewpgglDao; //最新的评估管理视图业务接口
   
   @Autowired
   private ViewftjgAndxwgcService viewftService; //访谈和观察视图逻辑接口
   
   @Autowired
   private TzyrymdService tzyreService; //在押人员逻辑接口
   
   @Autowired
   private TzyrymdMapper tyzrymdDao;
   
   @Autowired
	private ViewftjgAndxwgcDao viewftAndgcDao; //访谈和观察业务接口
   
	@Test
	public void test1(){
		List<Viewrjxwgc> viewrjjgft = viewftService.findViewrjxwgc("9874561");
		log.info(JSON.toJSON(viewrjjgft));
	}
	
	@Test
	public void test2(){ //在押人员名单
		Tzyrymd bdjCbyqh = tzyreService.selectBDJCbyqh(4409043828L);
		System.out.println(bdjCbyqh.getTjczjdx().getJhxm());
	}
	
	
	@Test
	public void test4(){ 
		List<Viewrjjgft> showViewrjjgft = viewftService.showViewrjjgft("9874561");
		System.out.println("..................."+showViewrjjgft.isEmpty());
	}
	
	//调用存储过程获取囚号
	@Test
	public void produceQh(){
		List<Tzyrymd> zyyrymdProduce = tyzrymdDao.useZyyrymdProduce();
		for (Tzyrymd tzyrymd : zyyrymdProduce) {
			System.out.println("囚号:"+tzyrymd.getQh());
//			log.info("囚号:"+tzyrymd.getQh());
		}
	}
	
	//根据囚号动态查询评估管理
	@Test
	public void testPggl(){
//		List<Viewpggl> viewpggl = viewpgglDao.cjxwgcViewpggl("9874561");
//		log.info(JSON.toJSON(viewpggl));
	}
	
	
	//档案数据全查询
	@Test
	public void test3(){
		List<ViewDasjfx> dasjfxByBh = viewftAndgcDao.seachDasjfxByBh();
		log.info(JSON.toJSON(dasjfxByBh));
	}
	
	@Test
	public void testFt(){
		Map<String,Object> map = new HashMap<>();
//		map.put("jh", "");
//		map.put("crim_no", "148523690");
//		map.put("xm", "hoho");
//		map.put("jhxm", "");
		map.put("status", "");
		List<Viewpggl> viewpggl = viewftService.rjjgftViewpggl(map);
		log.info(JSON.toJSON(viewpggl));
	}
	
	
	@Test
	public void listAll(){
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("AA");
		list.add("BB");
		list.add("BC");
		list.add("CC");
		list.add("DD");
		
	   Set<String> set = new TreeSet<String>();
	   set.addAll(list);
	   for (String str : set) {
		System.out.println(" "+str);
	}
//	   System.out.println(set);
	}
}
