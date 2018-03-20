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
//��ͨ����ԱRealm
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
			System.out.println("��ɫ����"+role.getGrouMan().getGmname());
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
			  log.debug("�쳣��Ϣ��鿴��¼ҳ��");
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		log.debug("��¼�쳣");
	}
	  return authenInfo;
	}
	
	  /**
     * �����û���Ȩ��Ϣ����.
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * ��������û���Ȩ��Ϣ����.
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
	 * ��customers��һЩ���ݴ�ŵ�session��
	 * ����Controller,ʹ��ʱֱ����HttpSession.getAttribute(key)�Ϳ���ȡ��
	 */
	
	public void setSession(Object key,Object value){
		Subject subject = SecurityUtils.getSubject(); //��ȡ����subject��ֵ
		if(subject!=null){
			Session session = subject.getSession();
			log.debug("SessionĬ�ϳ�ʱʱ��["+session.getTimeout()+"]����");
			if(session!=null){
				session.setAttribute(key, value);
			}
		}
		
	}

}
