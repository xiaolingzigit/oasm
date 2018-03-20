package com.hd.jy.oasm.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.ZRoleMapper;
import com.hd.jy.oasm.domain.SysAdmin;
import com.hd.jy.oasm.services.ZRoleService;

/**
 * 
* @ClassName: ZRoleServiceImpl 
* @Description: ��ȡ��ɫ
* @author liangjiaying
* @date 2017��12��20�� ����3:58:34 
*
 */
@Service("zRoleServiceImpl")
@DataSource("userDataSource")
public class ZRoleServiceImpl implements ZRoleService{

	private static Logger log = Logger.getLogger(ZRoleServiceImpl.class);
	
	@Autowired
	private ZRoleMapper zRoleMapper;
	
	@Override
	public List<SysAdmin> selectSomeGroupMan(String name) {
		List<SysAdmin> selectSomeGroupMan = null;
		try {
			selectSomeGroupMan = zRoleMapper.selectSomeGroupMan(name.trim());
		} catch (Exception e) {
			log.error("ZRoleServiceImpl.selectSomeGroupMan����"+e);
		}
		return selectSomeGroupMan;
	}

}
