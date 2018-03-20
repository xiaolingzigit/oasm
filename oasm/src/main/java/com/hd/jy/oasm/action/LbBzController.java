package com.hd.jy.oasm.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hd.jy.oasm.domain.LbBz;
import com.hd.jy.oasm.services.LbBzService;

@Controller
@RequestMapping("lbbz")
public class LbBzController {

	static final Logger LOGGER = Logger.getLogger(LbBzController.class);
	
	@Autowired
	private LbBzService lbBzService;
	
	// ���������������������ù���
	@RequestMapping(value = "/lbUse")
	public String lbUse(Model model){
		List<LbBz> allLbBz = null;
		try {
			allLbBz = lbBzService.getAllLbBz();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("���������б��ȡʧ��"+e);
		}
		model.addAttribute("lbbzlist", allLbBz);
		System.out.println(allLbBz.size());
		return "/systemBlank/lbUse";
	}
	
	//������������
	@RequestMapping(value="/lbsp")
	public String lbsp(){
		return "/systemBlank/lbsp";
	}
}
