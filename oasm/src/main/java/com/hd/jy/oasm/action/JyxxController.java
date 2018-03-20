package com.hd.jy.oasm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.annotation.Log;
import com.hd.jy.oasm.domain.GroupMan;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.domain.ZRole;
import com.hd.jy.oasm.services.JyxxService;
import com.hd.jy.oasm.util.CryptographyUtil;

@Controller
@RequestMapping("jyxx")
public class JyxxController {
	private Logger log = Logger.getLogger(JyxxController.class);
  @Autowired
  private JyxxService jyxxService;
  
  @RequestMapping("/jcxxPage")
  public String jcxxPage(){
	  return "/jcxx";
  }
  
  //��װ��ȡ��ǰ��¼����
  public static String getJhinfo(){
	  Subject currentUser = SecurityUtils.getSubject();
	  String jh = (String) currentUser.getPrincipal(); // �õ�����
	  return jh;
  }
  
  @RequestMapping("/testAop")
  @Log(operationType="add����:",operationName="��Ӿ�Ա��Ϣ")  //��ʾ��Ҫ��¼�����ݿ����־
  public String addJyxx(String jh,String jcxm){
	  System.out.println(jh);
	  System.out.println("jcxm");
	JYXX jy = new JYXX();
	jy.setJh(jh);
	jy.setZw(6);
	int i = jyxxService.insertSelective(jy);
	System.out.println("********************������"+i+"����Ϣ********************");
	return "/jcxx";
  }
  //************************************��̨������Ϣ����****************************************
  //��Ӿ��������ѯ�ܽ�ɫ��Ϣ
  @ResponseBody
  @RequestMapping(value="selectAllZRole",method={RequestMethod.GET,RequestMethod.POST})
  public List<ZRole> selectAllZRole(){
	  List<ZRole> list = null;
	try {
		list = jyxxService.selectAllZroll();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("��ѯ�쳣��Ϣ:"+e.getMessage());
	}
	  return list;
  }

  //��Ӿ��������ѯְ����Ϣ
  @ResponseBody
  @RequestMapping(value="selectAllGroupMan",method={RequestMethod.GET,RequestMethod.POST})
  public List<ZRole> selectAllGroupMan(int id){
	  List<ZRole> groupMan = null;
	try {
		groupMan = jyxxService.selectAllGroupMan(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("������ѯ������Ϣ"+e.getMessage());
	}
	  return groupMan;
  }
  
  //���ְ��
  @ResponseBody
  @RequestMapping(value="/addGroupMan",method={RequestMethod.GET,RequestMethod.POST})
  @Log(operationType="���ְ��",operationName="���ְ��")
  public int addGroupMan(String gmname,int zrid,HttpSession session){
	  String username = (String)session.getAttribute("username");
	  GroupMan gm=null;
	  int i = 0;
	try {
		if(null!=username&&username.length()>0){
			  gm = new GroupMan();
			  gm.setGmname(gmname);
			  gm.setZrid(zrid);
			  gm.setStates(1);
			  i = jyxxService.insertGroupMan(gm);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("��JYXXCONTROLLER�����롾GropMan���쳣"+e.getMessage());
	}
	return i;
	  
  }
  
  //��Ӿ�Ա����
  @SuppressWarnings("static-access")
  @ResponseBody
  @RequestMapping(value="addJyxx",method={RequestMethod.GET,RequestMethod.POST})
  @Log(operationType="��Ӿ���",operationName="��Ӿ���")
  public int addJyxx(int zw,String jq,String xjq,String jh,String xm,String ma,HttpSession session){
	  String username = (String)session.getAttribute("username"); //��̨����
	  int i = 0;
	  JYXX jy = null;
	  SimpleDateFormat sdf = null;
	try {
		  if(null!=username&&username.length()>0){
			  jy = new JYXX();
			  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  jy.setJh(jh);
			  jy.setXm(xm);
			  jy.setMa(CryptographyUtil.MD5(ma).trim());
			  jy.setZw(zw);
			  jy.setJq(jq);
			  jy.setXjq(xjq);
			  jy.setStatus(1);
			  Date cjsj = sdf.parse(sdf.format(new Date()));
			  System.out.println("����ʱ����û���쳣"+cjsj);
			  jy.setCjsj(cjsj);
			  i = jyxxService.insertSelective(jy);
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("��ʼ��ӡ��Ӿ�Ա�쳣��Ϣ"+e.getMessage());
	}
	  return i;
  }
  
  //��̨�޸ľ�Ա��Ϣ����
  @ResponseBody
  @RequestMapping(value="adminUpdateJyxx",method={RequestMethod.GET,RequestMethod.POST})
  @Log(operationType="�޸���Ϣ",operationName="��̨�޸ľ�����Ϣ")
  public int adminUpdateJyxx(String jh,String xm,String jq,String xjq,int zw,HttpSession session){
	  String username = (String)session.getAttribute("username");
	  log.info("�޸ľ�Ա��Ҫ�ġ�����"+jh+"����������"+xm+"����������"+jq+"�������¼���"+xjq+"������ְ��"+zw+"�������û���"+username+"��");
	  int i = 0;
	  JYXX jy = null;
	try {
		if(null!=username&&username.length()>0){
			  jy = new JYXX();
			  jy.setJh(jh);
			  jy.setXm(xm);
			  jy.setZw(zw);
			  jy.setJq(jq);
			  jy.setXjq(xjq);
			  jy.setStatus(1);
			  i = jyxxService.updateByPrimaryKeySelective(jy);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("���롾JYXX��ʧ��"+e.getMessage());
	}
	  return i;
  }
  
  //��̨ɾ����Ա��Ϣ
  @ResponseBody
  @RequestMapping(value="adminDeleteJyxx",method={RequestMethod.GET,RequestMethod.POST})
  @Log(operationType="ɾ����Ϣ",operationName="��̨ɾ��������Ϣ")
  public int adminDeleteJyxx(String jh,HttpSession session){
	  String username = (String)session.getAttribute("username");
	  int i =0;
	  JYXX jy = null;
	  SimpleDateFormat sdf = null;
	try {
		if(null!=username&&username.length()>0){
			  jy = new JYXX();
			  jy.setJh(jh);
			  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  Date scdlsj = sdf.parse(sdf.format(new Date()));
			  jy.setScdlsj(scdlsj); //�����߼�ɾ����ʱ��
			  jy.setStatus(0); //�߼�ɾ���ѱ�־status��Ϊ0
			  i = jyxxService.updateByPrimaryKeySelective(jy);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("ɾ������ʧ����Ϣ"+e.getMessage());
	}
	  return i;
  }
  
  //******************************************ǰ̨������˲���***************************************************
  //����ԭ����ƥ��
  @ResponseBody
  @RequestMapping(value="/beforePasswordCheck",method={RequestMethod.GET,RequestMethod.POST})
  public int beforePasswordCheck(String ma){
	  int i = 0;
	  JYXX jy = null;
	  try {
	  String jh = getJhinfo(); //��ȡ��װ��String���͵ľ��ţ�������Ҫǿת
	  System.out.println("��ȡ���ľ���"+jh);
	  if((ma!=null&&ma!="")||(jh!=null&&jh!="")){
		  jy = new JYXX();
		  jy.setJh(jh);
		  jy.setMa(CryptographyUtil.MD5(ma.trim()));
		  i = jyxxService.selectCheckUser(jy);
		  log.info("����ԭ����ƥ���"+i+"����ȷ���û�");
	  }else{
		  log.error("����Ϊ"+jh+" ,����Ϊ"+ma+"������...");
	  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
	  log.error("����ԭ����ƥ���û�ʧ�ܣ�������...");
	}
	  return i;
  }

  //��Ա���ݵ�¼�����û��޸�����
  @ResponseBody
  @RequestMapping(value="/updateCerrurMa",method={RequestMethod.GET,RequestMethod.POST})
  public int updateCerrurMa(String ma){
	  System.out.println("��ȡ��ǰ"+ma);
	  JYXX jy = null;
	  int i = 0;
	  String jh = getJhinfo();  //��ȡ��ǰ����
	  try {
	  if((ma!=null&&ma!="")||(jh!=null&&jh!="")){
		  jy = new JYXX();
		  jy.setJh(jh);
		  jy.setMa(CryptographyUtil.MD5(ma.trim()));
		  i = jyxxService.updateCerrurJh(jy);
	  }else{
		  log.error("���ݵ�ǰ"+jh+"�޸�ʧ�ܣ������µ�¼...");
	  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("�޸�ʧ�ܣ����Ժ�����...");
	}
	  return i;
  }
  
}
