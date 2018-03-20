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
 * �Զ���Authenticator
 * ע�⣬����Ҫ�ֱ��崦����ͨ�û��͹���Ա��֤��Realmʱ����ӦRealm��ȫ����Ӧ�ð����ַ�����User�������ߡ�Admin����
 * ���ң����ǲ����໥���������磬������ͨ�û���֤��Realm��ȫ�����в�Ӧ�ð����ַ���"Admin"��
 */
public class CustomizedModularRealmAuthenticator extends ModularRealmAuthenticator{
	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		 // �ж�getRealms()�Ƿ񷵻�Ϊ��
        assertRealmsConfigured();
        // ǿ��ת�����Զ����CustomizedToken
        CustomizedToken customizedToken = (CustomizedToken) authenticationToken;
        // ��¼����
        String loginType = customizedToken.getLoginType();
        System.out.println(loginType+"�����¼����"+getRealms());
        // ����Realm
        Collection<Realm> realms = getRealms();
        // ��¼���Ͷ�Ӧ������Realm
        Collection<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            if (realm.getName().contains(loginType)){
                typeRealms.add(realm);
            }
        }
        // �ж��ǵ�Realm���Ƕ�Realm
//        if (typeRealms.size() == 1)
        if (typeRealms.size() == 1){
        	System.out.println("��Realm");
        	return doSingleRealmAuthentication(typeRealms.iterator().next(), customizedToken);
        }
        else{
        	System.out.println("��Realm");
        	return doMultiRealmAuthentication(typeRealms, customizedToken);
        }
	}
	
	public static void main(String[] args) {
		String s="com.hd.jy.oasm.util.CustomersRealm@14b2a098";
		String a = "Customers";
		System.out.println(s.contains(a));
	}
}
