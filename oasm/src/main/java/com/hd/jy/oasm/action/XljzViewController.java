package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("xljzView")
public class XljzViewController {
	
	//心理测试选项卡
  @RequestMapping("/xlcs")
  public String xlcs(){
	  return "/pcras/xljz/xlcs";
  }
  
  
//心理测试-新收押罪犯
@RequestMapping("/xlcs_xszf")
public String xlcs_xszf(){
	 return "/pcras/xljz/xlcs_xszf";
}
//心理测试-新收押罪犯结果表
@RequestMapping("/xlcs_xszfrs")
public String xlcs_xszfrs(){
	 return "/pcras/xljz/xlcs_xszfrs";
}
//心理测试-新收押罪犯报告
@RequestMapping("/xlcs_xszfbg")
public String xlcs_xszfbg(){
	 return "/pcras/xljz/xlcs_xszfbg";
}
//心理测试-新收押罪犯量表
@RequestMapping("/xlcs_xszflb")
public String xlcs_xszflb(){
	 return "/pcras/xljz/xlcs_xszflb";
}
//心理测试-scl90
@RequestMapping("/xlcs_scl90")
public String xlcs_scl90(){
	 return "/pcras/xljz/xlcs_scl90";
}
//心理测试-scl90结果表
@RequestMapping("/xlcs_scl90rs")
public String xlcs_scl90rs(){
	 return "/pcras/xljz/xlcs_scl90rs";
}
//心理测试-scl90报告
@RequestMapping("/xlcs_scl90bg")
public String xlcs_scl90bg(){
	 return "/pcras/xljz/xlcs_scl90bg";
}
//心理测试-scl90量表
@RequestMapping("/xlcs_scl90lb")
public String xlcs_scl90lb(){
	 return "/pcras/xljz/xlcs_scl90lb";
}
//心理测试-copa-pi
@RequestMapping("/xlcs_copa")
public String xlcs_copa(){
	 return "/pcras/xljz/xlcs_copa";
}
//心理测试-copa-pi结果表
@RequestMapping("/xlcs_copars")
public String xlcs_copars(){
	 return "/pcras/xljz/xlcs_copars";
}
//心理测试-copa-pi报告
@RequestMapping("/xlcs_copabg")
public String xlcs_copabg(){
	 return "/pcras/xljz/xlcs_copabg";
}
//心理测试-copa-pi量表
@RequestMapping("/xlcs_copalb")
public String xlcs_copalb(){
	 return "/pcras/xljz/xlcs_copalb";
}
//心理测试-社会适应性列表
@RequestMapping("/xlcs_shsy")
public String xlcs_shsy(){
	  return "/pcras/xljz/xlcs_shsy";
}
//心理测试-社会适应性量表
@RequestMapping("/xlcs_shsylb")
public String xlcs_shsylb(){
	  return "/pcras/xljz/xlcs_shsylb";
}
//心理测试-社会适应性结果表
@RequestMapping("/xlcs_shsyrs")
public String xlcs_shsyrs(){
	  return "/pcras/xljz/xlcs_shsyrs";
}
}
