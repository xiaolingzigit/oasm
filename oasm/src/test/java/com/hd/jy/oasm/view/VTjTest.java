package com.hd.jy.oasm.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.domain.TWpqk;
import com.hd.jy.oasm.domain.VPgbgWxlx;
import com.hd.jy.oasm.domain.VTjpgbg;
import com.hd.jy.oasm.domain.VTjwxcd;
import com.hd.jy.oasm.domain.VTjwxlx;
import com.hd.jy.oasm.domain.Vtjzfz;
import com.hd.jy.oasm.domain.Vwxlx;
import com.hd.jy.oasm.services.TWpqkServices;
import com.hd.jy.oasm.services.VTjpgbgService;
import com.hd.jy.oasm.services.VTjwxcdService;
import com.hd.jy.oasm.services.VtjbhService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml"})
public class VTjTest {
	
	private static Logger logging = Logger.getLogger(VTjTest.class);
	
	@Autowired
	private VTjpgbgService vTjpgbgService;
	
	@Autowired
	private TWpqkServices tWpqkServices;
	
	@Autowired
	private VTjwxcdService vTjwxcdService;
	
	@Autowired
	private VtjbhService VtjbhService;
	
	
	@Test
	public void getVTlist(){
		List<VTjpgbg> allVT = vTjpgbgService.getAllVT(null);
		System.out.println("-------------------"+allVT.size());
		VTjpgbg vTjpgbg = new VTjpgbg();
		vTjpgbg.setLevl("中度危险");
		List<VTjpgbg> allVT2 = vTjpgbgService.getAllVT(vTjpgbg);
		System.out.println("-------------------"+allVT2.size());
		
		vTjpgbg.setGyjqmc("九监区");
		List<VTjpgbg> allVT3 = vTjpgbgService.getAllVT(vTjpgbg);
		System.out.println("-------------------"+allVT3.size());
		
	}
	
	@Test
	public void getTJ(){
		List<VTjpgbg> vTjpgbg = vTjpgbgService.getVTjpgbg(null);
		System.out.println("******************"+vTjpgbg.size());
		List<VTjpgbg> vTjpgbg2 = vTjpgbgService.getVTjpgbg("九监区");
		System.out.println("******************"+vTjpgbg2.size());
	}
	
	
	@Test
	public void getDate(){
		try {
			DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = dFormat.parse("2017-11-30");
//			Date date = new GregorianCalendar(2017,11,30).getTime();
			List<TWpqk> list = tWpqkServices.getDate(date2);
			System.out.println(JSON.toJSON(list));
			
			System.out.println(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//测试危评最开始的时间
	@Test
	public void getTopDate(){
		Date topDate = tWpqkServices.getTopDate();
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("getTopDate(): "+dFormat.format(topDate));
	}
	
	
	
	
	
	
	
	//v_tjwxcd视图------------------------------------------------------------
	
	
	@Test
	public void getVjy(){
		
		List<VTjwxcd> vjy = vTjwxcdService.getVjy();
		System.out.println("-----------------------------------------"+JSON.toJSONString(vjy));
	}
	
	
	@Test
	public void getVTjwxcd2(){
		List<VTjwxcd> vjy = vTjwxcdService.listVTjwxcd();
		logging.info(JSON.toJSONString(vjy));
	}
	
	// 极高度危险类型列表
	@Test
	public void getVPgbgWxlx(){
		List<VPgbgWxlx> vPgbgWxlx = vTjwxcdService.getVPgbgWxlx();
		logging.info(JSON.toJSONString(vPgbgWxlx));
	}
	
	//统计各个监区高危险倾向数量 
	@Test
	public void getVTjwxlx(){
		List<VTjwxlx> vTjwxlx = vTjwxcdService.getVTjwxlx();
		logging.info(JSON.toJSONString(vTjwxlx));
	}
	
	
	
	
	//统计各个监区危险类别数量 
	@Test
	public void listTjWxlx(){
		List<Vwxlx> Vwxlx = vTjwxcdService.listTjWxlx();
		logging.info(JSON.toJSONString(Vwxlx));
	}

	//统计再犯罪倾向
	@Test
	public void listTjZfz(){
		List<Vtjzfz> listTjZfz = vTjwxcdService.listTjZfz();
		logging.info(JSON.toJSONString(listTjZfz));
	}
	
	//自动保存
	@Test
	public void autoSave(){
		 VtjbhService.autoSave();
	}

	
	
}



