package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pggjglView")
public class PggjglViewController {
	
	//�������
   @RequestMapping("/lbfx")
   public String lbfx(){
	   return "/pcras/pggjgl/lbfx";
   }
   //���ӷ���
   @RequestMapping("/yzfx")
   public String yzfx(){
	   return "/pcras/pggjgl/yzfx";
   }
   //�����������
   @RequestMapping("/pgbgfx")
   public String pgbgfx(){
	   return "/pcras/pggjgl/pgbgfx";
   }
   //�������
   @RequestMapping("/fxmb")
   public String fxmb(){
	   return "/pcras/pggjgl/fxmb";
   }
   //��������
   @RequestMapping("/yxyz")
   public String yxyz(){
	   return "/pcras/pggjgl/yxyz";
   }
   //�쳣����
   @RequestMapping("/ycyz")
   public String ycyz(){
	   return "/pcras/pggjgl/ycyz";
   }
}
