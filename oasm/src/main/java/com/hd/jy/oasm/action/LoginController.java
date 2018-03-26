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
 * *********前台登录控制层 *******
 * @author quite
 * @data 2018年03月22日
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
	 * 登陆控制器 访问规则，直接访问页面index.jsp页面也可以项目名称直接回车 样式文件访问详情：
	 * 监狱危评中心css文件地址：/resource/css/jycss/ 监狱危评中心js文件地址：/resource/aJS/
	 * 监狱领导css文件地址：/resource/css/jycss 监狱领导js文件地址：/resource/bJS/
	 */
	// ********************登录页面访问控制*********************************
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	// 登录管理
	@ResponseBody
	@RequestMapping("/loginCheck")
	public int loginCheck(String jh, String ma, HttpServletRequest rqst) {
		JYXX jy = new JYXX();
		jy.setJh(jh);
//		jy.setMa(CryptographyUtil.MD5(ma).trim());
		jy.setMa(ma);
		int i = 0;

		System.out.println("查出的人数为" + i);

		try {
			i = jyxxService.selectCheckUser(jy);
			// 表示为客户端登录
//			String password = CryptographyUtil.MD5(ma).trim();
			String password = ma;

			Subject currentUser = SecurityUtils.getSubject();

			// 使用多用户登录应该使用CustomizedToken而不应该使用UserPasswordToken
			CustomizedToken token = new CustomizedToken(jh, password,
					CUSTOMERS_LOGIN_TYPE);
			// 验证是否已经登录，如果登录过就会进行RememberMe放行
			if (!currentUser.isAuthenticated()) {
				token.setRememberMe(true);
			} else {
				token.setRememberMe(false);
			}
			
			currentUser.login(token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.debug("登录异常，请根据页面提示操作");
		}
		return i;
	}

	// 退出登录
	@RequestMapping(value = "/logout", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String logout(HttpServletResponse response) {
		Subject exit = SecurityUtils.getSubject();
		try {
			// 退出清除缓存
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
