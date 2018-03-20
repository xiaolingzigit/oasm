package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pggjglView")
public class PggjglViewController {
	
	//量表分析
   @RequestMapping("/lbfx")
   public String lbfx(){
	   return "/pcras/pggjgl/lbfx";
   }
   //因子分析
   @RequestMapping("/yzfx")
   public String yzfx(){
	   return "/pcras/pggjgl/yzfx";
   }
   //评估报告分析
   @RequestMapping("/pgbgfx")
   public String pgbgfx(){
	   return "/pcras/pggjgl/pgbgfx";
   }
   //分析面板
   @RequestMapping("/fxmb")
   public String fxmb(){
	   return "/pcras/pggjgl/fxmb";
   }
   //阳性因子
   @RequestMapping("/yxyz")
   public String yxyz(){
	   return "/pcras/pggjgl/yxyz";
   }
   //异常因子
   @RequestMapping("/ycyz")
   public String ycyz(){
	   return "/pcras/pggjgl/ycyz";
   }
}
