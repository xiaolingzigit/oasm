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
	
	//��װ��ȡ��ǰ��¼����
	  public static String getJhinfo(){
		  Subject currentUser = SecurityUtils.getSubject();
		  String jh = (String) currentUser.getPrincipal(); // �õ�����
		  return jh;
	  }
	
	
	//����ѡ�
	  @RequestMapping("/setting")
	  public String setting(){
		  return "/pcras/setting/setting";
	  }
	//�û�������Ϣ
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
					request.setAttribute("zw", "��");
				}else{
					request.setAttribute("zw", jyxx.getZwName());
				}
			}else{
				log.info("�þ���û�е�¼���޷���ȡ����ĸ�����Ϣ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ȡ����ĸ�����Ϣʧ�ܣ�������...");
		}
	  
	  return "/pcras/setting/set_userInfo";
  }
  
   //�����޸�
@RequestMapping("/set_userPwd")
public String set_userPwd(){
	 return "/pcras/setting/set_userPwd";
}

}
