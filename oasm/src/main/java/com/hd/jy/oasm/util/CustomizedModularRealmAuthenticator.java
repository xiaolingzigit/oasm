package com.hd.jy.oasm.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

/**
 * @author Alan_Xiang 
 * 自定义Authenticator
 * 注意，当需要分别定义处理普通用户和管理员验证的Realm时，对应Realm的全类名应该包含字符串“User”，或者“Admin”。
 * 并且，他们不能相互包含，例如，处理普通用户验证的Realm的全类名中不应该包含字符串"Admin"。
 */
public class CustomizedModularRealmAuthenticator extends ModularRealmAuthenticator{
	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		 // 判断getRealms()是否返回为空
        assertRealmsConfigured();
        // 强制转换回自定义的CustomizedToken
        CustomizedToken customizedToken = (CustomizedToken) authenticationToken;
        // 登录类型
        String loginType = customizedToken.getLoginType();
        System.out.println(loginType+"查出登录类型"+getRealms());
        // 所有Realm
        Collection<Realm> realms = getRealms();
        // 登录类型对应的所有Realm
        Collection<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            if (realm.getName().contains(loginType)){
                typeRealms.add(realm);
            }
        }
        // 判断是单Realm还是多Realm
//        if (typeRealms.size() == 1)
        if (typeRealms.size() == 1){
        	System.out.println("单Realm");
        	return doSingleRealmAuthentication(typeRealms.iterator().next(), customizedToken);
        }
        else{
        	System.out.println("都Realm");
        	return doMultiRealmAuthentication(typeRealms, customizedToken);
        }
	}
	
	public static void main(String[] args) {
		String s="com.hd.jy.oasm.util.CustomersRealm@14b2a098";
		String a = "Customers";
		System.out.println(s.contains(a));
	}
}
