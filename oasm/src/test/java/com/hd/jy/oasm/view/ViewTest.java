package com.hd.jy.oasm.view;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hd.jy.oasm.dao.VCjpgMapper;
import com.hd.jy.oasm.dao.VRcpgMapper;
import com.hd.jy.oasm.dao.VRjpgMapper;
import com.hd.jy.oasm.dao.VZqpgMapper;
import com.hd.jy.oasm.domain.VRcpg;
import com.hd.jy.oasm.domain.VRjpg;
import com.hd.jy.oasm.domain.VZqpg;
import com.hd.jy.oasm.domain.Vjtft;
import com.hd.jy.oasm.services.VCjpgService;
import com.hd.jy.oasm.services.VRcpgService;
import com.hd.jy.oasm.services.VRjpgService;
import com.hd.jy.oasm.services.VZqpgService;
import com.hd.jy.oasm.services.VjtftService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml"})
public class ViewTest {
	
	private static Logger log = Logger.getLogger(ViewTest.class);
	
	@Autowired
	private VZqpgMapper vZqpgMapper;
	
	@Autowired
	private VZqpgService vZqpgService;
	
	@Autowired
	private VRjpgMapper vRjpgMapper;
	
	@Autowired
	private VRjpgService vRjpgService;
	
	
	@Autowired
	private VCjpgMapper vCjpgMapper;
	
	@Autowired
	private VCjpgService vCjpgService;

	@Autowired
	private VRcpgMapper vRcpgMapper;
	
	@Autowired
	private VRcpgService vRcpgService;
	
	
	@Autowired
	private VjtftService vjtftService;
	
	
	@Test
	public void selectVZqpg(){
		
		List<VZqpg> selectAllVzqpg = vZqpgMapper.selectAllVzqpg();
		System.out.println(selectAllVzqpg.size());
	}
	
	@Test
	public void selectVrjpg(){
		
		List<VRjpg> selectAllVrjpg = vRjpgMapper.selectAllVrjpg();
		System.out.println(selectAllVrjpg.size());
	}
	
	@Test 
	public void VRcpgService(){
		List<VRcpg> selectAllVrcpg = vRcpgService.selectAllVrcpg();
		System.out.println(selectAllVrcpg.size());
	}
	
	
	
	
	@Test
	public void getJtft(){
		//4405005201_fileAnlys_201712201735	4405005201	����չ				1	ʮ����	���ּ���	���ݼ���	4429187	Ԭ־ƽ	4429000	��
//		String jh = "4429187";
//		String gyjq = "ʮ����";
//		String qh = "4405005201";
//		String xm = "����չ";
//		String jhxm = "Ԭ־ƽ";
//		int zt = 1;
		String jh = "";
		String gyjq = "";
		String qh = "";
		String xm = "";
		String jhxm = "";
		String zt = "";
		Vjtft vjtft = new Vjtft();
		vjtft.setJh(jh);
		vjtft.setGyjq(gyjq.trim());
		vjtft.setQh(qh.trim());
		vjtft.setXm(xm.trim());
		vjtft.setJhxm(jhxm.trim());
		if(zt.length()!=0){
			vjtft.setZt(Integer.parseInt(zt));
		}
		List<Vjtft> jtft = vjtftService.getJtft(vjtft);
		Vjtft vjtft2 = jtft.get(1);
		log.info("ViewTest.getJtft---------------------"+jtft.size());
		log.info("ViewTest.getJtft---------------------"+vjtft2.getJtftid());
	}
	
	@Test
	public void addJtft(){
		int addJtft = vjtftService.addJtft();
		log.info("ViewTest.getJtft---------------------"+addJtft);
	}

}
