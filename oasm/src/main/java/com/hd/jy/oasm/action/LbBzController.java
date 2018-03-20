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
	
	// 量表启动管理——量表配置管理
	@RequestMapping(value = "/lbUse")
	public String lbUse(Model model){
		List<LbBz> allLbBz = null;
		try {
			allLbBz = lbBzService.getAllLbBz();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("量表配置列表获取失败"+e);
		}
		model.addAttribute("lbbzlist", allLbBz);
		System.out.println(allLbBz.size());
		return "/systemBlank/lbUse";
	}
	
	//量表审批管理
	@RequestMapping(value="/lbsp")
	public String lbsp(){
		return "/systemBlank/lbsp";
	}
}
