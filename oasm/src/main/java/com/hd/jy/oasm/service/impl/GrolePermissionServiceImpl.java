package com.hd.jy.oasm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.GrolePermissMapper;
import com.hd.jy.oasm.domain.GrolePermiss;
import com.hd.jy.oasm.services.GrolePermissionService;
@Service("grolePermissionServiceImpl")
@DataSource("userDataSource") 
public class GrolePermissionServiceImpl implements GrolePermissionService {

	@Autowired
	private GrolePermissMapper grolePermissDao;
	@Override
	public GrolePermiss selectRole(String jh) {
		// TODO Auto-generated method stub
		GrolePermiss role = null;
		try {
			role = grolePermissDao.selectRole(jh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}

}
