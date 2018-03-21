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
 * @author quite ��̨controller
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
	
	//��־�����ӿ�
	@Autowired
//	private SystemLogService logService; 
	
	

	// ��̨��½ҳ��
	@RequestMapping("/adminLogin")
	public String adminLogin() {
		return "/systemBlank/adminLogin";
	}

	// ϵͳ��̨
	@RequestMapping("/adminBlank")
	public String adminBlank() {
		return "/systemBlank/adminBlank";
	}
	
//	//�ﷸ��ʶ��
//	@RequestMapping(value="/zfIDcard")
//	public String zfIDcard(){
//		return "/systemBlank/zfIDcard";
//	}

	// ��Ա��Ϣҳ��
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
	
	//����ʹ�ùؼ��ֲ�ѯ���й���Ա
	@ResponseBody
	@RequestMapping(value="/adminListByKey")
	public List<SysAdmin> adminListByKey(String key){
		System.out.println("key��ֵ"+key);
		List<SysAdmin> likeKey = null;
		try {
			likeKey = sysAdminService.selectByAdminLikeKey(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return likeKey;
	}
	
	//����Ա��Ϣҳ�� �г����й���Ա
	@RequestMapping(value="/adminManager")
	public String adminManager(String key,Model model){
		List<SysAdmin> likeKey = null;
		try {
//			listAdmin = sysAdminService.selectAdminByStatus();
			likeKey = sysAdminService.selectByAdminLikeKey(key);
		} catch (Exception e) {
			log.error("�г�������ͨ����Ա�쳣");
		}
		model.addAttribute("listAdmin", likeKey);
		return "/systemBlank/adminManager";
	}

	// ���ݵ���ҳ��
//	@RequestMapping(value = "dataInput")
//	public String dataInput() {
//		return "/systemBlank/dataInput";
//	}

	@SuppressWarnings("static-access")
	@ResponseBody
	@RequestMapping(value = "/adminCheck", method = { RequestMethod.GET, RequestMethod.POST })
	public int adminCheck(String username, String password) {
		System.out.println("�û���" + username);
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
			System.out.println("session��ֵ" + session.getAttribute("username"));
			
			if (currentUser.isAuthenticated()) {
				token.setRememberMe(true);
			} else {
				token.setRememberMe(false);
			}
			currentUser.login(token);

			// Session session = currentUser.getSession();
			// session.setTimeout(1500000);
		} catch (Exception e) {
			log.debug("��¼�쳣");
		}
		return i;
	}

	// ��ӹ���Ա֮ǰ��֤�˺ſɲ�����
	@ResponseBody
	@RequestMapping(value = "/check_username_add", method = { RequestMethod.GET, RequestMethod.POST })
	public int check_username_add(String username) {
		int i = 0;
		try {
			i = sysAdminService.check_username_add(username);
		} catch (Exception e) {
			log.error("��֤�˺�ʧ�ܣ�������...");
		}
		return i;
	}

	// ���ù���Ա���뷽��inserttive
	@SuppressWarnings("static-access")
	@ResponseBody
	@RequestMapping(value = "add_admin_count", method = { RequestMethod.GET, RequestMethod.POST })
	@Log(operationType="��ӹ���Ա",operationName="�����ͨ����Ա")
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
				// ����Ĭ��ְ�����λ�ǹ���Ա��ʵ��ʹ�õڶ�λ�ǹ���Ա
//				add.setGmid(19); 
				add.setGmid(5); 
				//״̬Ϊ1��ʾΪ��ͨ����Ա��״̬2��ʾΪ��������Ա
				add.setStatus(1); 
				i = sysAdminService.insertSelective(add);
				log.info("�ɹ���ӹ���Ա�˺�" + i + "��");
			}else{
				log.info("���ʧ����ȷ������ԱΪ��¼״̬");
			}
		} catch (Exception e) {
			log.error("��ӹ���Ա�˺��쳣" + e.getMessage());
		}
		return i;
	}
	
	//��̨�����û����޸��������
	@SuppressWarnings("static-access")
	@ResponseBody
	@RequestMapping(value="/username_update_password", method = { RequestMethod.GET, RequestMethod.POST })
	@Log(operationType="�޸�����",operationName="����Ա�޸ľ�������")
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
				log.error("��ȷ������ԱΪ��¼״̬");
			}
		} catch (Exception e) {
			log.error("��sysAdminController���޸������쳣"+e.getMessage());
		}
		return i;
	}
	
	
	
	//����Ա�˳���¼�ķ���
	//�˳���¼
	 @RequestMapping(value = "/logout", method = RequestMethod.GET) 
	 public String logout(HttpServletRequest request,HttpSession session){
		 Enumeration<String> names = request.getSession().getAttributeNames();
		 while (names.hasMoreElements()) {
			 //�Ƴ���¼��
			request.getSession().removeAttribute( names.nextElement().toString());
		}
		 //�Ƴ���¼����
		 request.getSession().removeAttribute(ADMIN_LOGIN_TYPE);
		 //��ʼ��
		// ƴ����תҳ��·��
//		String path = request.getContextPath();
//		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
		 return "forward:/systemAdmin/adminLogin";
	 }
	
	 //����ԭ������֤����
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
			log.info("����ԭ����ƥ�䵽�˺�"+i+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return i;
	 }
	
	 //��������Ա���޸��˺�����
	 @SuppressWarnings("static-access")
	@ResponseBody
	 @RequestMapping(value="/superAdmin_update_password", method = { RequestMethod.GET, RequestMethod.POST })
	 @Log(operationType="�޸�����",operationName="�޸���ͨ����Ա����")
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
				 log.info("�ɹ������޸���ͨ����Ա����"+i+"��"); 
			 }else{
				 log.error("�޸�ʧ�ܣ���ȷ������ԱΪ��¼״̬!");
			 }
		} catch (Exception e) {
			log.info("��������Ա�޸�����ʧ�ܣ�������...");
		}
		 return i;
	 }
	 
	 //ɾ����ͨ����Ա
	 @ResponseBody
	 @RequestMapping(value="/superAdmin_delete_password", method = { RequestMethod.GET, RequestMethod.POST })
	 @Log(operationType="ɾ������Ա",operationName="ɾ����ͨ����Ա")
	 public int superAdmin_delete_password(int id,HttpSession session){
		 String jh = (String)session.getAttribute("username"); //��̨����
		 int i = 0;
		 SysAdmin su = null;
		 try {
			 if(null!=jh&&""!=jh){
				 su = new SysAdmin();
				 su.setId(id);
				 su.setStatus(0);
				 i = sysAdminService.updateBySuperAdminStatus(su);
				 log.info("sysAdminController�ɹ�ɾ������Ա"+i+"��"); 
			 }else{
				 log.error("ɾ��ʧ�ܣ���ȷ������ԱΪ��¼״̬!");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ɾ������Ա�쳣��������...");
		}
		 return i;
	 }
	 
	 /***
	  * ��ʾʹ��aop����������־
	  * @auto quite
	  * @param pageNum
	  * @param pageSize
	  * @param createBy
	  * @param description
	  * @param createDate
	  * @returna
	  * ����11:02:04
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
			log.error("��ʾ������־ʧ�ܣ����Ժ�����...");
		}
		 return mapPage;
	 }*/
	 /**
	  * ���ݿⱸ��
	  * @todo TODO
	  * @return
	  * @auth quite
	  * @time 2018��1��11�� ����3:51:55
	  *
	  */
	/* @RequestMapping(value="/backupDB",method={RequestMethod.GET,RequestMethod.POST})
	 public String backupDB(){
		 return "/systemBlank/backupDB";
	 }*/
	 /**
	  * ���汸�����ݵ�ָ��·����
	  * @todo TODO
	  * @param savePath
	  * @param session
	  * @return
	  * @auth quite
	  * @time 2018��1��11�� ����6:27:12
	  *
	  */
	/* @ResponseBody
	 @RequestMapping(value="/backupPackge",method={RequestMethod.GET,RequestMethod.POST})
	 @Log(operationType="��������",operationName="�������ݿ�����")
	 public String backupPackge(String savePath,HttpSession session){
		 String username = (String)session.getAttribute("username");
		 log.info("��������ѡ��ġ�·��"+savePath+"�������û���"+username+"��");
		 String dbPath = null;
		try {
			if(null!=username){
				dbPath = logService.backupDB(savePath.trim()); //����ɹ����ļ�
				if(!dbPath.contains("�ļ�·���Ҳ���")){
					File deFile = new ZIPcompression().zip(savePath,new File(dbPath)); //����ѹ������
					deFile.delete(); //ɾ�������Խ�ʡ�ռ�
				}
			}else{
				dbPath = "��ȷ������ԱΪ��¼״̬!";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ѹ���ļ��쳣");
		}
		 return dbPath;
	 }*/
	 
    //����session
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
