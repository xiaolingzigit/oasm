package com.hd.jy.oasm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.services.JyxxService;
import com.hd.jy.oasm.util.CustomizedToken;
import com.hd.jy.oasm.util.LoginType;
/***
 * *********ǰ̨��¼���Ʋ� *******
 * @author quite
 * @data 2018��03��22��
 * @see  
 *
 */
@Controller
@RequestMapping("login")
public class LoginController {
	private Logger log = Logger.getLogger(LoginController.class);
	private static final String CUSTOMERS_LOGIN_TYPE = LoginType.CUSTOMERS
			.toString();
	@Autowired
	private JyxxService jyxxService;

	/**
	 * ��½������ ���ʹ���ֱ�ӷ���ҳ��index.jspҳ��Ҳ������Ŀ����ֱ�ӻس� ��ʽ�ļ��������飺
	 * ����Σ������css�ļ���ַ��/resource/css/jycss/ ����Σ������js�ļ���ַ��/resource/aJS/
	 * �����쵼css�ļ���ַ��/resource/css/jycss �����쵼js�ļ���ַ��/resource/bJS/
	 */
	// ********************��¼ҳ����ʿ���*********************************
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	// ��¼����
	@ResponseBody
	@RequestMapping("/loginCheck")
	public int loginCheck(String jh, String ma, HttpServletRequest rqst) {
		JYXX jy = new JYXX();
		jy.setJh(jh);
//		jy.setMa(CryptographyUtil.MD5(ma).trim());
		jy.setMa(ma);
		int i = 0;

		System.out.println("���������Ϊ" + i);

		try {
			i = jyxxService.selectCheckUser(jy);
			// ��ʾΪ�ͻ��˵�¼
//			String password = CryptographyUtil.MD5(ma).trim();
			String password = ma;

			Subject currentUser = SecurityUtils.getSubject();

			// ʹ�ö��û���¼Ӧ��ʹ��CustomizedToken����Ӧ��ʹ��UserPasswordToken
			CustomizedToken token = new CustomizedToken(jh, password,
					CUSTOMERS_LOGIN_TYPE);
			// ��֤�Ƿ��Ѿ���¼�������¼���ͻ����RememberMe����
			if (!currentUser.isAuthenticated()) {
				token.setRememberMe(true);
			} else {
				token.setRememberMe(false);
			}
			
			currentUser.login(token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.debug("��¼�쳣�������ҳ����ʾ����");
		}
		return i;
	}

	// �˳���¼
	@RequestMapping(value = "/logout", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String logout(HttpServletResponse response) {
		Subject exit = SecurityUtils.getSubject();
		try {
			// �˳��������
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			exit.logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/login/login";
	}
}
