package com.hd.jy.oasm.util;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.hd.jy.oasm.domain.GrolePermiss;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.services.GrolePermissionService;
import com.hd.jy.oasm.services.JyxxService;
//普通操作员Realm
public class CustomersRealm extends AuthorizingRealm{
   private Logger log = Logger.getLogger(CustomersRealm.class);
	@Autowired
	private GrolePermissionService grolePermissionService;
	
	@Autowired
	private JyxxService jyxxService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username =(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = null;
		try {
			info = new SimpleAuthorizationInfo();
			GrolePermiss role = grolePermissionService.selectRole(username);
			System.out.println("角色名："+role.getGrouMan().getGmname());
			info.addRole(role.getGrouMan().getGmname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
	  CustomizedToken customizedToken = (CustomizedToken) token;
	  SimpleAuthenticationInfo authenInfo=null;
	  String jh = (String)customizedToken.getPrincipal();
	  JYXX jyxx = null;
	try {
		 jyxx = jyxxService.selectCheck(jh);
		  if(jyxx!=null){
			  String ma = jyxx.getMa();
			  authenInfo = new SimpleAuthenticationInfo(jh,ma,getName());
		  }else{
			  log.debug("异常信息请查看登录页面");
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		log.debug("登录异常");
	}
	  return authenInfo;
	}
	
	  /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
    }
	
	/***
	 * @author quite
	 * 将customers的一些数据存放到session中
	 * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	
	public void setSession(Object key,Object value){
		Subject subject = SecurityUtils.getSubject(); //获取存在subject的值
		if(subject!=null){
			Session session = subject.getSession();
			log.debug("Session默认超时时间["+session.getTimeout()+"]毫秒");
			if(session!=null){
				session.setAttribute(key, value);
			}
		}
		
	}

}
