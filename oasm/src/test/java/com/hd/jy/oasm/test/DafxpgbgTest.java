package com.hd.jy.oasm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.dao.TaskMapper;
import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.domain.TaskRelat;
import com.hd.jy.oasm.domain.Viewgrpgbgxx;
import com.hd.jy.oasm.services.VPgbgListService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml" })
public class DafxpgbgTest {
	private static Logger log = Logger.getLogger(DafxpgbgTest.class);
	
	@Autowired
	private VPgbgListService vpgbgService; //评估报告逻辑接口
	
	@Autowired
	private TaskMapper taskDao;
	
	@Test
	public void vpgTest(){
		BGjbxx no = vpgbgService.crimInfoBycrimNo("4413031302");
		log.info(JSON.toJSON(no));
	}
	
//	@Test
//	public void stringJOSN(){
//		String note = vpgbgService.getPgbgTestNote(4,"4413027061_inRep_201712211948".trim());
//		System.out.println(note);
//	}

	
	//父类任务编号
	@Test
	public void parentId(){
		List<TaskRelat> parent = taskDao.getChildTaskIdByParent("4413027061_inRep_201712211948".trim());
		log.info(JSON.toJSON(parent));
	}
}
