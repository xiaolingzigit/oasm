package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/***
 * *********������Կ��Ʋ� *******
 * @author quite
 * @data 2018��03��26��
 * @see  
 *
 */
@Controller
@RequestMapping("xljzView")
public class XljzViewController {
	
	//�������ѡ�
  @RequestMapping("/xlcs")
  public String xlcs(){
	  return "/pcras/xljz/xlcs";
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
