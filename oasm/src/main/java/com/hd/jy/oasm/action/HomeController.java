package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * *********��ҳ���Ʋ� *******
 * TODO
 * @author quite
 * @data 2017��12��29��
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
	
	@RequestMapping("/home")
	public String home(){
		return "/pcras/home/home";
	}
}
