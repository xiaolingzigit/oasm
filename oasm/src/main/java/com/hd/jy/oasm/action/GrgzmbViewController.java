package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("grgzmbView")
public class GrgzmbViewController {
	
	
	//���˹������
   @RequestMapping("/grgzmb")
   public String grgzmb(){
	   return "/pcras/grgzmb/grgzmb";
   }
   
}
