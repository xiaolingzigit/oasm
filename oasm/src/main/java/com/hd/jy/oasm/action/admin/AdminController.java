package com.hd.jy.oasm.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
	static int count=0;
	
	@RequestMapping("/adminBlank")
	public String adminBlank(){
	    System.out.println("—≠ª∑¡À"+(count++)+"¥Œ");
		return "/systemBlank/adminBlank";
	}

@RequestMapping("/pageSetting")
public String pageSetting(){
	return "/systemBlank/pageSetting";
}
}
