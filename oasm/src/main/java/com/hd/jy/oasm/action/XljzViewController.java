package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("xljzView")
public class XljzViewController {
	
	//�������ѡ�
  @RequestMapping("/xlcs")
  public String xlcs(){
	  return "/pcras/xljz/xlcs";
  }
  
  
//�������-����Ѻ�ﷸ
@RequestMapping("/xlcs_xszf")
public String xlcs_xszf(){
	 return "/pcras/xljz/xlcs_xszf";
}
//�������-����Ѻ�ﷸ�����
@RequestMapping("/xlcs_xszfrs")
public String xlcs_xszfrs(){
	 return "/pcras/xljz/xlcs_xszfrs";
}
//�������-����Ѻ�ﷸ����
@RequestMapping("/xlcs_xszfbg")
public String xlcs_xszfbg(){
	 return "/pcras/xljz/xlcs_xszfbg";
}
//�������-����Ѻ�ﷸ����
@RequestMapping("/xlcs_xszflb")
public String xlcs_xszflb(){
	 return "/pcras/xljz/xlcs_xszflb";
}
//�������-scl90
@RequestMapping("/xlcs_scl90")
public String xlcs_scl90(){
	 return "/pcras/xljz/xlcs_scl90";
}
//�������-scl90�����
@RequestMapping("/xlcs_scl90rs")
public String xlcs_scl90rs(){
	 return "/pcras/xljz/xlcs_scl90rs";
}
//�������-scl90����
@RequestMapping("/xlcs_scl90bg")
public String xlcs_scl90bg(){
	 return "/pcras/xljz/xlcs_scl90bg";
}
//�������-scl90����
@RequestMapping("/xlcs_scl90lb")
public String xlcs_scl90lb(){
	 return "/pcras/xljz/xlcs_scl90lb";
}
//�������-copa-pi
@RequestMapping("/xlcs_copa")
public String xlcs_copa(){
	 return "/pcras/xljz/xlcs_copa";
}
//�������-copa-pi�����
@RequestMapping("/xlcs_copars")
public String xlcs_copars(){
	 return "/pcras/xljz/xlcs_copars";
}
//�������-copa-pi����
@RequestMapping("/xlcs_copabg")
public String xlcs_copabg(){
	 return "/pcras/xljz/xlcs_copabg";
}
//�������-copa-pi����
@RequestMapping("/xlcs_copalb")
public String xlcs_copalb(){
	 return "/pcras/xljz/xlcs_copalb";
}
//�������-�����Ӧ���б�
@RequestMapping("/xlcs_shsy")
public String xlcs_shsy(){
	  return "/pcras/xljz/xlcs_shsy";
}
//�������-�����Ӧ������
@RequestMapping("/xlcs_shsylb")
public String xlcs_shsylb(){
	  return "/pcras/xljz/xlcs_shsylb";
}
//�������-�����Ӧ�Խ����
@RequestMapping("/xlcs_shsyrs")
public String xlcs_shsyrs(){
	  return "/pcras/xljz/xlcs_shsyrs";
}
}
