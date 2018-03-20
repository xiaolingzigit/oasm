package com.hd.jy.oasm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.dao.ViewftjgAndxwgcDao;
import com.hd.jy.oasm.domain.ViewDasjfx;
import com.hd.jy.oasm.domain.Viewrjjgft;
import com.hd.jy.oasm.services.ViewftjgAndxwgcService;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;

/***
 * @author quite
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybaits.xml" })
public class DafxViewTest {
	private static Logger logger = Logger.getLogger(DafxViewTest.class);

	@Autowired
	private ViewftjgAndxwgcDao viewftAndgcDao; // 访谈和观察数据业务接口

	@Autowired
	private ViewftjgAndxwgcService viewftAndgcService; // 访谈和观察数据视图返回操作接口



	//
	// @Test
	// public void findAll(){
	// Map<Object, Integer> map = dafxViewService.findAndToall();
	// Set<Object> s = map.keySet();
	// for (Object obj : s) {
	// DafxView v = (DafxView)obj;
	// System.out.println(v.getHyzk());
	// // System.out.println(obj+"aaa");
	// logger.info("sss"+JSON.toJSON(obj));
	// System.out.println("总分:"+map.get(obj));
	// }
	//
	// }
	//


	@Test
	public void show() {

		String jh = null;
		// String jh="9874561";
		List<Viewrjjgft> showViewrjjgft = viewftAndgcService.showViewrjjgft(jh);
		System.out.println("/////////////////***********"
				+ showViewrjjgft.size());
	}

	//
	//
	// @Test
	// public void findOneQh(){
	// Map<String, Integer> map = dafxViewService.SelectScoreQh("123");
	// logger.info(JSON.toJSON(map));
	//
	// }
	//
	// @Test
	// public void test1(){
	// List<Map> lis = new ArrayList<Map>();
	// Map<Integer, String> map = new HashMap<Integer, String>();
	// Map<Integer, Integer> ma = new HashMap<Integer, Integer>();
	//
	// map.put(1, "aaa");
	// map.put(2, "bbb");
	// map.put(3, "ccc");
	//
	// ma.put(1, 1);
	// ma.put(2, 2);
	// ma.put(3, 3);
	//
	// lis.add(map);
	// lis.add(ma);
	//
	// for (Map m : lis) {
	// Iterator<Map.Entry<Object, Object>> it = m.entrySet().iterator();
	// while (it.hasNext()) {
	// Map.Entry<Object, Object> entry = it.next();
	// System.out.println(entry.getKey() + " " + entry.getValue());
	// }
	// }
	// }

	@Test
	public void ftTest() {
		PageHelper.startPage(1, 2);
		// List<Viewpggl> rjjgftViewpggl =
		// viewftAndgcService.rjjgftViewpggl("9874561");
		Page page = PageHelper.endPage();
		logger.info(JSON.toJSON(page));
		// logger.info(JSON.toJSON(rjjgftViewpggl));
	}

	// 测试出监档案
	@Test
	public void cjdaTest() {
		List<ViewDasjfx> dasjfxByRelat = viewftAndgcDao.cjDasjfxByRelat();
		logger.info(JSON.toJSON(dasjfxByRelat));
	}

	// 测试档案
	@Test
	public void daTest() {
		List<ViewDasjfx> dasjfxByBh = viewftAndgcDao.seachDasjfxByBh();
		logger.info(JSON.toJSON(dasjfxByBh));
	}
}
