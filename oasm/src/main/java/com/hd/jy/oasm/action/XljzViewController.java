package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/***
 * *********心理测试控制层 *******
 * @author quite
 * @data 2018年03月26日
 * @see  
 *
 */
@Controller
@RequestMapping("xljzView")
public class XljzViewController {
	
	//心理测试选项卡
  @RequestMapping("/xlcs")
  public String xlcs(){
	  return "/pcras/xljz/xlcs";
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
