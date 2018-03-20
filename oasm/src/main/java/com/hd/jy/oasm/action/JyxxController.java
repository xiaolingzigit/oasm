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
  
  //封装获取当前登录警号
  public static String getJhinfo(){
	  Subject currentUser = SecurityUtils.getSubject();
	  String jh = (String) currentUser.getPrincipal(); // 得到警号
	  return jh;
  }
  
  @RequestMapping("/testAop")
  @Log(operationType="add操作:",operationName="添加警员信息")  //表示需要记录到数据库的日志
  public String addJyxx(String jh,String jcxm){
	  System.out.println(jh);
	  System.out.println("jcxm");
	JYXX jy = new JYXX();
	jy.setJh(jh);
	jy.setZw(6);
	int i = jyxxService.insertSelective(jy);
	System.out.println("********************插入了"+i+"条信息********************");
	return "/jcxx";
  }
  //************************************后台警察信息管理****************************************
  //添加警察操作查询总角色信息
  @ResponseBody
  @RequestMapping(value="selectAllZRole",method={RequestMethod.GET,RequestMethod.POST})
  public List<ZRole> selectAllZRole(){
	  List<ZRole> list = null;
	try {
		list = jyxxService.selectAllZroll();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("查询异常信息:"+e.getMessage());
	}
	  return list;
  }

  //添加警察操作查询职务信息
  @ResponseBody
  @RequestMapping(value="selectAllGroupMan",method={RequestMethod.GET,RequestMethod.POST})
  public List<ZRole> selectAllGroupMan(int id){
	  List<ZRole> groupMan = null;
	try {
		groupMan = jyxxService.selectAllGroupMan(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("级联查询错误信息"+e.getMessage());
	}
	  return groupMan;
  }
  
  //添加职务
  @ResponseBody
  @RequestMapping(value="/addGroupMan",method={RequestMethod.GET,RequestMethod.POST})
  @Log(operationType="添加职务",operationName="添加职务")
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
		log.error("【JYXXCONTROLLER】插入【GropMan】异常"+e.getMessage());
	}
	return i;
	  
  }
  
  //添加警员操作
  @SuppressWarnings("static-access")
  @ResponseBody
  @RequestMapping(value="addJyxx",method={RequestMethod.GET,RequestMethod.POST})
  @Log(operationType="添加警察",operationName="添加警察")
  public int addJyxx(int zw,String jq,String xjq,String jh,String xm,String ma,HttpSession session){
	  String username = (String)session.getAttribute("username"); //后台警号
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
			  System.out.println("创建时间有没有异常"+cjsj);
			  jy.setCjsj(cjsj);
			  i = jyxxService.insertSelective(jy);
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("开始打印添加警员异常信息"+e.getMessage());
	}
	  return i;
  }
  
  //后台修改警员信息操作
  @ResponseBody
  @RequestMapping(value="adminUpdateJyxx",method={RequestMethod.GET,RequestMethod.POST})
  @Log(operationType="修改信息",operationName="后台修改警察信息")
  public int adminUpdateJyxx(String jh,String xm,String jq,String xjq,int zw,HttpSession session){
	  String username = (String)session.getAttribute("username");
	  log.info("修改警员需要的【警号"+jh+"】，【姓名"+xm+"】，【监区"+jq+"】，【新监区"+xjq+"】，【职务"+zw+"】，【用户名"+username+"】");
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
		log.error("插入【JYXX】失败"+e.getMessage());
	}
	  return i;
  }
  
  //后台删除警员信息
  @ResponseBody
  @RequestMapping(value="adminDeleteJyxx",method={RequestMethod.GET,RequestMethod.POST})
  @Log(operationType="删除信息",operationName="后台删除警察信息")
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
			  jy.setScdlsj(scdlsj); //插入逻辑删除的时间
			  jy.setStatus(0); //逻辑删除把标志status改为0
			  i = jyxxService.updateByPrimaryKeySelective(jy);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("删除数据失败信息"+e.getMessage());
	}
	  return i;
  }
  
  //******************************************前台警察个人操作***************************************************
  //个人原密码匹配
  @ResponseBody
  @RequestMapping(value="/beforePasswordCheck",method={RequestMethod.GET,RequestMethod.POST})
  public int beforePasswordCheck(String ma){
	  int i = 0;
	  JYXX jy = null;
	  try {
	  String jh = getJhinfo(); //获取封装的String类型的警号，根据需要强转
	  System.out.println("获取到的警号"+jh);
	  if((ma!=null&&ma!="")||(jh!=null&&jh!="")){
		  jy = new JYXX();
		  jy.setJh(jh);
		  jy.setMa(CryptographyUtil.MD5(ma.trim()));
		  i = jyxxService.selectCheckUser(jy);
		  log.info("根据原密码匹配出"+i+"个正确的用户");
	  }else{
		  log.error("警号为"+jh+" ,密码为"+ma+"请重试...");
	  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
	  log.error("根据原密码匹配用户失败，请重试...");
	}
	  return i;
  }

  //警员根据登录警号用户修改密码
  @ResponseBody
  @RequestMapping(value="/updateCerrurMa",method={RequestMethod.GET,RequestMethod.POST})
  public int updateCerrurMa(String ma){
	  System.out.println("获取当前"+ma);
	  JYXX jy = null;
	  int i = 0;
	  String jh = getJhinfo();  //获取当前警号
	  try {
	  if((ma!=null&&ma!="")||(jh!=null&&jh!="")){
		  jy = new JYXX();
		  jy.setJh(jh);
		  jy.setMa(CryptographyUtil.MD5(ma.trim()));
		  i = jyxxService.updateCerrurJh(jy);
	  }else{
		  log.error("根据当前"+jh+"修改失败，请重新登录...");
	  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("修改失败，请稍后重试...");
	}
	  return i;
  }
  
}
