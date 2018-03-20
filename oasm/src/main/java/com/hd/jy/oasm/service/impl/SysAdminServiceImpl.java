package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.SysAdminMapper;
import com.hd.jy.oasm.domain.SysAdmin;
import com.hd.jy.oasm.services.SysAdminService;
import com.hd.jy.oasm.util.date.DateUtil;
@DataSource("userDataSource")
@Service("sysAdminServiceImpl")
public class SysAdminServiceImpl implements SysAdminService {
    private Logger log = Logger.getLogger(SysAdminServiceImpl.class);
    
    @Autowired
    private SysAdminMapper sysAdminDao;
	
	@Override
	public int selectByUser(SysAdmin record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始查询匹配【SysAdmin】人数时间"+DateUtil.getTime(new Date()));
			i = sysAdminDao.selectByUser(record);
			log.info("根据用户名密码匹配到的"+i+"人");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public String checkByUsername(String username) {
		// TODO Auto-generated method stub
		String ma = null;
		try {
			log.info("开始匹配密码时间"+DateUtil.getTime(new Date()));
			ma = sysAdminDao.checkByUsername(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}

	@Override
	public int insertSelective(SysAdmin record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始插入【SysAdmin】时间"+DateUtil.getTime(new Date()));
			i = sysAdminDao.insertSelective(record);
			log.info("插入【SysAdmin】"+i+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int check_username_add(String username) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始根据"+username+"查询时间"+DateUtil.getTime(new Date()));
			i = sysAdminDao.check_username_add(username);
			log.info("查出已存在用户"+i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("通过用户名"+username+"查询异常");
		}
		return i;
	}

	//根据编号修改密码，管理员帮修改密码有效
	@Override
	public int updateByPrimaryKeySelective(SysAdmin record) {
		// TODO Auto-generated method stub\
		int i = 0;
		try {
			log.info("开始修改【admin】密码时间"+DateUtil.getTime(new Date()));
			i = sysAdminDao.updateByPrimaryKeySelective(record);
			log.info("成功修改密码"+i+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改密码异常，异常信息"+e.getMessage());
		}
		return i;
	}

	//根据用户名修改密码
	@Override
	public int updateByCurrentUsername(SysAdmin record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始修改【sysAdmin】时间"+DateUtil.getTime(new Date()));
			i = sysAdminDao.updateByCurrentUsername(record);
			log.info("成功修改密码"+i+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改密码异常"+e.getMessage());
		}
		return i;
	}

	//列出所有普通管理员
	@Override
	public List<SysAdmin> selectAdminByStatus() {
		// TODO Auto-generated method stub
		List<SysAdmin> byStatus = null;
		try {
			log.info("开始列出【普通管理员】时间"+DateUtil.getTime(new Date()));
			byStatus = sysAdminDao.selectAdminByStatus();
			log.info("列出所有管理员"+byStatus.size()+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("管理员列表错误，请重试...");
		}
		return byStatus;
	}

	//逻辑删除普通管理员
	@Override
	public int updateBySuperAdminStatus(SysAdmin record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始删除普通管理员时间"+DateUtil.getTime(new Date()));
			i = sysAdminDao.updateBySuperAdminStatus(record);
			log.info("成功删除普通管理员"+i+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("删除管理员异常"+e.getMessage());
		}
		return i;
	}
 
	
	//普通管理员关键字查询
	@Override
	public List<SysAdmin> selectByAdminLikeKey(String key) {
		// TODO Auto-generated method stub
		List<SysAdmin> likeKey = null;
		try {
			log.info("开始使用关键字查询【SysAdmin】时间"+DateUtil.getTime(new Date()));
			likeKey = sysAdminDao.selectByAdminLikeKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("关键字查询失败"+e.getMessage());
		}
		return likeKey;
	}
	
	

}
