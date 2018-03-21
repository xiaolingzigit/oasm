package com.hd.jy.oasm.action;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hd.jy.oasm.annotation.Log;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.domain.SysAdmin;
import com.hd.jy.oasm.services.JyxxService;
import com.hd.jy.oasm.services.SysAdminService;
import com.hd.jy.oasm.util.CustomizedToken;
import com.hd.jy.oasm.util.LoginType;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;

/***
 * 
 * @author quite 后台controller
 */
@Controller
@RequestMapping("systemAdmin")
public class SysAdminController {
	private Logger log = Logger.getLogger(SysAdminController.class);
	private static final String ADMIN_LOGIN_TYPE = LoginType.ADMIN.toString();
	@Autowired
	private SysAdminService sysAdminService;

	@Autowired
	private JyxxService jyxxService;
	
	//日志操作接口
	@Autowired
//	private SystemLogService logService; 
	
	

	// 后台登陆页面
	@RequestMapping("/adminLogin")
	public String adminLogin() {
		return "/systemBlank/adminLogin";
	}

	// 系统后台
	@RequestMapping("/adminBlank")
	public String adminBlank() {
		return "/systemBlank/adminBlank";
	}
	
//	//罪犯标识卡
//	@RequestMapping(value="/zfIDcard")
//	public String zfIDcard(){
//		return "/systemBlank/zfIDcard";
//	}

	// 警员信息页面
	@SuppressWarnings("rawtypes")
	@RequestMapping("/jyxxSetting")
	public String pageSetting(@RequestParam(required=true,defaultValue="1")int number,Model model) {
		PageHelper.startPage(number, 30);
		List<JYXX> jyxxList = jyxxService.selectJyxx();
		Page page= PageHelper.endPage();
		System.out.println("page===>"+page);
		model.addAttribute("page",page);
		model.addAttribute("nums", page.getNavigatepageNums());
		model.addAttribute("jyxxList",jyxxList);
		return "/systemBlank/pageSetting";
	}
	
	//可以使用关键字查询所有管理员
	@ResponseBody
	@RequestMapping(value="/adminListByKey")
	public List<SysAdmin> adminListByKey(String key){
		System.out.println("key的值"+key);
		List<SysAdmin> likeKey = null;
		try {
			likeKey = sysAdminService.selectByAdminLikeKey(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return likeKey;
	}
	
	//管理员信息页面 列出所有管理员
	@RequestMapping(value="/adminManager")
	public String adminManager(String key,Model model){
		List<SysAdmin> likeKey = null;
		try {
//			listAdmin = sysAdminService.selectAdminByStatus();
			likeKey = sysAdminService.selectByAdminLikeKey(key);
		} catch (Exception e) {
			log.error("列出所有普通管理员异常");
		}
		model.addAttribute("listAdmin", likeKey);
		return "/systemBlank/adminManager";
	}

	// 数据导入页面
//	@RequestMapping(value = "dataInput")
//	public String dataInput() {
//		return "/systemBlank/dataInput";
//	}

	@SuppressWarnings("static-access")
	@ResponseBody
	@RequestMapping(value = "/adminCheck", method = { RequestMethod.GET, RequestMethod.POST })
	public int adminCheck(String username, String password) {
		System.out.println("用户名" + username);
		SysAdmin ad = new SysAdmin();
		ad.setUsername(username);
//		ad.setPassword(CryptographyUtil.MD5(password));
		ad.setPassword(password);
		int i = 0;
		try {
			i = sysAdminService.selectByUser(ad);
			Subject currentUser = SecurityUtils.getSubject();
//			CustomizedToken token = new CustomizedToken(username, CryptographyUtil.MD5(username).trim(),
//					ADMIN_LOGIN_TYPE);
			CustomizedToken token = new CustomizedToken(username, password,
					ADMIN_LOGIN_TYPE);
			HttpSession session = getSession();
			session.setAttribute("username", username);
			System.out.println("session的值" + session.getAttribute("username"));
			
			if (currentUser.isAuthenticated()) {
				token.setRememberMe(true);
			} else {
				token.setRememberMe(false);
			}
			currentUser.login(token);

			// Session session = currentUser.getSession();
			// session.setTimeout(1500000);
		} catch (Exception e) {
			log.debug("登录异常");
		}
		return i;
	}

	// 添加管理员之前验证账号可不可用
	@ResponseBody
	@RequestMapping(value = "/check_username_add", method = { RequestMethod.GET, RequestMethod.POST })
	public int check_username_add(String username) {
		int i = 0;
		try {
			i = sysAdminService.check_username_add(username);
		} catch (Exception e) {
			log.error("验证账号失败，请重试...");
		}
		return i;
	}

	// 调用管理员插入方法inserttive
	@SuppressWarnings("static-access")
	@ResponseBody
	@RequestMapping(value = "add_admin_count", method = { RequestMethod.GET, RequestMethod.POST })
	@Log(operationType="添加管理员",operationName="添加普通管理员")
	public int add_admin_count(String username, String password,HttpSession session) {
		String jh = (String)session.getAttribute("username");
		int i = 0;
		SysAdmin add = null;
		try {
			if(null!=jh&&""!=jh){
				add = new SysAdmin();
				add.setUsername(username);
//				add.setPassword(CryptographyUtil.MD5(password.trim()));
				add.setPassword(password);
				// 现在默认职务第七位是管理员，实际使用第二位是管理员
//				add.setGmid(19); 
				add.setGmid(5); 
				//状态为1表示为普通管理员，状态2表示为超级管理员
				add.setStatus(1); 
				i = sysAdminService.insertSelective(add);
				log.info("成功添加管理员账号" + i + "个");
			}else{
				log.info("添加失败请确保管理员为登录状态");
			}
		} catch (Exception e) {
			log.error("添加管理员账号异常" + e.getMessage());
		}
		return i;
	}
	
	//后台根据用户名修改密码操作
	@SuppressWarnings("static-access")
	@ResponseBody
	@RequestMapping(value="/username_update_password", method = { RequestMethod.GET, RequestMethod.POST })
	@Log(operationType="修改密码",operationName="管理员修改警察密码")
	public int username_update_password(String username,String password,HttpSession session){
		String jh = (String)session.getAttribute("username");
		int i = 0;
		SysAdmin up = null;
		try {
			if(null!=jh&&""!=jh){
				up = new SysAdmin();
				up.setUsername(username);
//				up.setPassword(CryptographyUtil.MD5(password.trim()));
				up.setPassword(password.trim());
				i = sysAdminService.updateByCurrentUsername(up);
			}else{
				log.error("请确保管理员为登录状态");
			}
		} catch (Exception e) {
			log.error("【sysAdminController】修改密码异常"+e.getMessage());
		}
		return i;
	}
	
	
	
	//管理员退出登录的方法
	//退出登录
	 @RequestMapping(value = "/logout", method = RequestMethod.GET) 
	 public String logout(HttpServletRequest request,HttpSession session){
		 Enumeration<String> names = request.getSession().getAttributeNames();
		 while (names.hasMoreElements()) {
			 //移除登录名
			request.getSession().removeAttribute( names.nextElement().toString());
		}
		 //移除登录类型
		 request.getSession().removeAttribute(ADMIN_LOGIN_TYPE);
		 //初始化
		// 拼接跳转页面路径
//		String path = request.getContextPath();
//		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
		 return "forward:/systemAdmin/adminLogin";
	 }
	
	 //调用原密码验证方法
	 @SuppressWarnings("static-access")
	@ResponseBody
	 @RequestMapping(value="/check_last_pwd", method = { RequestMethod.GET, RequestMethod.POST })
	 public int check_last_pwd(String username,String password){
		 int i = 0;
		 SysAdmin admin = null;
		 try {
			 admin = new SysAdmin();
			 admin.setUsername(username.trim());
//			 admin.setPassword(CryptographyUtil.MD5(password.trim()));
			 admin.setPassword(password);
			i = sysAdminService.selectByUser(admin);
			log.info("根据原密码匹配到账号"+i+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return i;
	 }
	
	 //超级管理员帮修改账号密码
	 @SuppressWarnings("static-access")
	@ResponseBody
	 @RequestMapping(value="/superAdmin_update_password", method = { RequestMethod.GET, RequestMethod.POST })
	 @Log(operationType="修改密码",operationName="修改普通管理员密码")
	 public int superAdmin_update_password(int id,String username,String password,HttpSession session){
		 String jh = (String)session.getAttribute("username");
		 int i= 0;
		 SysAdmin su = null;
		 try {
			 if(null!=jh&&""!=jh){
				 su = new SysAdmin();
				 su.setId(id);
				 su.setUsername(username.trim());
//				 su.setPassword(CryptographyUtil.MD5(password.trim()));
				 su.setPassword(password);
				 su.setStatus(1);
				 i = sysAdminService.updateByPrimaryKeySelective(su);
				 log.info("成功帮助修改普通管理员密码"+i+"个"); 
			 }else{
				 log.error("修改失败，请确保管理员为登录状态!");
			 }
		} catch (Exception e) {
			log.info("超级管理员修改密码失败，请重试...");
		}
		 return i;
	 }
	 
	 //删除普通管理员
	 @ResponseBody
	 @RequestMapping(value="/superAdmin_delete_password", method = { RequestMethod.GET, RequestMethod.POST })
	 @Log(operationType="删除管理员",operationName="删除普通管理员")
	 public int superAdmin_delete_password(int id,HttpSession session){
		 String jh = (String)session.getAttribute("username"); //后台警号
		 int i = 0;
		 SysAdmin su = null;
		 try {
			 if(null!=jh&&""!=jh){
				 su = new SysAdmin();
				 su.setId(id);
				 su.setStatus(0);
				 i = sysAdminService.updateBySuperAdminStatus(su);
				 log.info("sysAdminController成功删除管理员"+i+"个"); 
			 }else{
				 log.error("删除失败，请确保管理员为登录状态!");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("删除管理员异常，请重试...");
		}
		 return i;
	 }
	 
	 /***
	  * 显示使用aop切面管理的日志
	  * @auto quite
	  * @param pageNum
	  * @param pageSize
	  * @param createBy
	  * @param description
	  * @param createDate
	  * @returna
	  * 上午11:02:04
	  * Map<Object,Object>
	  */
	/* @SuppressWarnings("rawtypes")
	@ResponseBody
	 @RequestMapping(value="/logInof",method={RequestMethod.POST,RequestMethod.GET})
	 public Map<Object,Object> logInof(int pageNum,int pageSize,String createBy,String description,String createDate){
		 Map<String,String> map = new HashMap<String,String>();
		 Map<Object, Object> mapPage = new HashMap<Object,Object>();
		 List<SystemLog> info = null;
		try {
			map.put("createBy", createBy);
			map.put("description", description);
			map.put("createDate", createDate);
			PageHelper.startPage(pageNum, pageSize);
			info = logService.systemLogInfo(map);
			Page page = PageHelper.endPage();
			mapPage.put("info", info);
			mapPage.put("page", page);
		} catch (Exception e) {
			log.error("显示操作日志失败，请稍后重试...");
		}
		 return mapPage;
	 }*/
	 /**
	  * 数据库备份
	  * @todo TODO
	  * @return
	  * @auth quite
	  * @time 2018年1月11日 下午3:51:55
	  *
	  */
	/* @RequestMapping(value="/backupDB",method={RequestMethod.GET,RequestMethod.POST})
	 public String backupDB(){
		 return "/systemBlank/backupDB";
	 }*/
	 /**
	  * 保存备份数据到指定路径下
	  * @todo TODO
	  * @param savePath
	  * @param session
	  * @return
	  * @auth quite
	  * @time 2018年1月11日 下午6:27:12
	  *
	  */
	/* @ResponseBody
	 @RequestMapping(value="/backupPackge",method={RequestMethod.GET,RequestMethod.POST})
	 @Log(operationType="备份数据",operationName="备份数据库数据")
	 public String backupPackge(String savePath,HttpSession session){
		 String username = (String)session.getAttribute("username");
		 log.info("备份数据选择的【路径"+savePath+"】，【用户名"+username+"】");
		 String dbPath = null;
		try {
			if(null!=username){
				dbPath = logService.backupDB(savePath.trim()); //保存成功的文件
				if(!dbPath.contains("文件路径找不到")){
					File deFile = new ZIPcompression().zip(savePath,new File(dbPath)); //调用压缩方法
					deFile.delete(); //删除父本以节省空间
				}
			}else{
				dbPath = "请确保管理员为登录状态!";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("压缩文件异常");
		}
		 return dbPath;
	 }*/
	 
    //建立session
	public static HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
		}
		return session;
	}

	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}
}
