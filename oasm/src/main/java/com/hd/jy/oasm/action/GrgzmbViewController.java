package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("grgzmbView")
public class GrgzmbViewController {
	
	
	//个人工作面板
   @RequestMapping("/grgzmb")
   public String grgzmb(){
	   return "/pcras/grgzmb/grgzmb";
   }
   
}
