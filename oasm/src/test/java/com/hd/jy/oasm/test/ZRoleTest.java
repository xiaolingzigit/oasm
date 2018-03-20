package com.hd.jy.oasm.test;

import java.util.List;

import javax.json.Json;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.domain.SysAdmin;
import com.hd.jy.oasm.services.ZRoleService;

/**
 * 
* @ClassName: ZRoleTest 
* @Description: 测试类
* @author liangjiaying
* @date 2017年12月20日 上午11:47:52 
*
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybaits.xml"})
public class ZRoleTest {
	
	private Logger logger = Logger.getLogger(ZRoleTest.class);
	
	@Autowired
	private ZRoleService zRoleService;
	
	/**
	 * @Date: 2017年12月20日
	 * @Title: selectSomeGroupMan   
	 * @Description: 查询职务
	 */
	@Test
	public void selectSomeGroupMan(){
		
		List<SysAdmin> selectSomeGroupMan = zRoleService.selectSomeGroupMan("admin");
		logger.info(JSON.toJSONString(selectSomeGroupMan));
		for (SysAdmin sysAdmin : selectSomeGroupMan) {
			System.out.println("**********gm********* "+sysAdmin.getGroupMan().getGmname());
		}
	}

}
