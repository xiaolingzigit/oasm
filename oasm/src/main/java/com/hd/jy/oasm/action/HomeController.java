package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * *********主页控制层 *******
 * @author quite
 * @data 2018年03月22日
 * @see  
 *
 */
@Controller
@RequestMapping("home")
public class HomeController {
  
	@RequestMapping("/main")
	public String main(){
		return "/pcras/main";
	}
	
//	@RequestMapping("/home")
//	public String home(){
//		return "/pcras/home/home";
//	}
}
