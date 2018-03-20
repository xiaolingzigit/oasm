package com.hd.jy.oasm.util;

import java.util.List;

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

import com.hd.jy.oasm.domain.SysAdmin;
import com.hd.jy.oasm.services.SysAdminService;
import com.hd.jy.oasm.services.ZRoleService;
//����Ա��Realm
public class AdminRealm extends AuthorizingRealm{
	
	private Logger log = Logger.getLogger(AdminRealm.class);
	
	@Autowired
	private SysAdminService sysAdminService;
	
	@Autowired
	private ZRoleService zRoleService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username =(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = null;
		try {
			info = new SimpleAuthorizationInfo();
			List<SysAdmin> selectSomeGroupMan = zRoleService.selectSomeGroupMan(username);
			for (SysAdmin sysAdmin : selectSomeGroupMan) {
				info.addRole(sysAdmin.getGroupMan().getGmname());
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("AdminRealm.doGetAuthorizationInfo����"+e);
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		SimpleAuthenticationInfo authenInfo=null;
		CustomizedToken customizedToken = (CustomizedToken) token;
		 String username = (String)customizedToken.getPrincipal();
		 try {
			 String password = sysAdminService.checkByUsername(username);
			 if(password!=null){
				 authenInfo = new SimpleAuthenticationInfo(username,password.trim(),getName());
			 }else{
				 log.debug("�쳣��Ϣ��鿴ҳ��");
			 }
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	 * ��admin��һЩ���ݴ�ŵ�session��
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
