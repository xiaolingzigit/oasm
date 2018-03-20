package com.hd.jy.oasm.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.services.JyxxService;

@Controller
@RequestMapping("settingView")
public class SettingViewController {
	private Logger log = Logger.getLogger(SettingViewController.class);
	
	
	@Autowired
	private JyxxService jyxxService;
	
	//封装获取当前登录警号
	  public static String getJhinfo(){
		  Subject currentUser = SecurityUtils.getSubject();
		  String jh = (String) currentUser.getPrincipal(); // 得到警号
		  return jh;
	  }
	
	
	//设置选项卡
	  @RequestMapping("/setting")
	  public String setting(){
		  return "/pcras/setting/setting";
	  }
	//用户个人信息
  @RequestMapping("/set_userInfo")
  public String set_userInfo(HttpServletRequest request){
	  JYXX jyxx = null;
		try {
			String jh = getJhinfo();
			if(null!=jh&&""!=jh){
				jyxx = jyxxService.infoSetting(jh);
				request.setAttribute("jh", jh);
				request.setAttribute("xm", jyxx.getXm());
				request.setAttribute("jq", jyxx.getJq());
				if(jyxx.getCnum()==0){
					request.setAttribute("cnum",0);
				}else{
					request.setAttribute("cnum",jyxx.getCnum());
				}
				if(null==jyxx.getZwName()){
					request.setAttribute("zw", "无");
				}else{
					request.setAttribute("zw", jyxx.getZwName());
				}
			}else{
				log.info("该警察没有登录，无法获取警察的个人信息");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("获取警察的个人信息失败，请重试...");
		}
	  
	  return "/pcras/setting/set_userInfo";
  }
  
   //密码修改
@RequestMapping("/set_userPwd")
public String set_userPwd(){
	 return "/pcras/setting/set_userPwd";
}

}
