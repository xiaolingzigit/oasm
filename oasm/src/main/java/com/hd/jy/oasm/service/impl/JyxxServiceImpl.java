package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.JYXXMapper;
import com.hd.jy.oasm.dao.ZRoleMapper;
import com.hd.jy.oasm.domain.GroupMan;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.domain.ZRole;
import com.hd.jy.oasm.services.JyxxService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("jyxxServiceImpl")
//指向jdbc数据源的数据库
@DataSource("userDataSource") 
public class JyxxServiceImpl implements JyxxService {
   private Logger log = Logger.getLogger(JyxxServiceImpl.class);
	@Autowired
	private JYXXMapper jyxxDao;
	
	@Autowired
	private ZRoleMapper  zRoleDao;
	
	@Override
	public int insertSelective(JYXX record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始插入【JYXX】时间"+DateUtil.getTime(new Date()));
			i = jyxxDao.insertSelective(record);
			log.info("成功插入【JYXX】"+i+"条数据");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("插入【JYXX】异常信息"+e.getMessage());
		}
		return i;
	}
	@Override
	public int selectCheckUser(JYXX record) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			i = jyxxDao.selectCheckUser(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public JYXX selectCheck(String jh) {
		// TODO Auto-generated method stub
		JYXX jyxx = null;
		try {
			log.info("开始查询【JYXX】时间"+DateUtil.getTime(new Date()));
			jyxx = jyxxDao.selectCheck(jh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jyxx;
	}
	@Override
	public List<ZRole> selectAllZroll() {
		// TODO Auto-generated method stub
		List<ZRole> list = null;
		try {
			log.info("开始全查询【ZRole】时间"+DateUtil.getTime(new Date()));
			list = zRoleDao.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<ZRole> selectAllGroupMan(Integer id) {
		// TODO Auto-generated method stub
		List<ZRole> list = null;
		try {
			log.info("开始根据【ZRole】条件查询【GroupMan】时间"+DateUtil.getTime(new Date()));
			list = zRoleDao.selectAllGroupMan(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/***
	 * 添加职务，返回int数量
	 */
	@Override
	public int insertGroupMan(GroupMan record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始插入【GroupMan】时间"+DateUtil.getTime(new Date()));
			i = zRoleDao.insertGroupMan(record);
			log.info("成功插入【GroupMan】"+i+"条数据");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("插入【GroupMan】异常"+e.getMessage());
		}
		return i;
	}
	@Override
	public List<JYXX> selectJyxx() {
		// TODO Auto-generated method stub
		List<JYXX> list = null;
		try {
			log.info("开始查询【JYXX】时间"+DateUtil.getTime(new Date()));
			list = jyxxDao.selectJyxx();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询【JYXX】错误"+e.getMessage());
		}
		return list;
	}
	@Override
	public int updateByPrimaryKeySelective(JYXX record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("修改【JYXX】开始时间"+DateUtil.getTime(new Date()));
			i = jyxxDao.updateByPrimaryKeySelective(record);
			log.info("成功修改数据"+i+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改【JYXX】失败");
		}
		return i;
	}
	@Override
	public int updateCerrurJh(JYXX record){
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始修改密码时间"+DateUtil.getTime(new Date()));
			i = jyxxDao.updateCerrurJh(record);
			log.info("成功修改密码"+i+"次");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改密码失败，请重试..."+e.getMessage());
		}
		return i;
	}
	/**
	 * @ TODO
	 * @authc quite
	 * @date 2017年12月27日
	 * @see com.hd.jy.oasm.services.JyxxService#infoSetting(java.lang.String)
	 */
	@Override
	public JYXX infoSetting(String jh) {
		// TODO Auto-generated method stub
		JYXX jyxx = null;
//		String jyInfo = null;
		try {
			log.info("警察开始【进入个人设置时间"+DateUtil.getTime(new Date())+"】");
			if(null!=jh&&""!=jh){
				jyxx = jyxxDao.infoSetting(jh);
//				jyInfo = GsonUtil.toJson(jyxx);
//				log.info("返回前端数据【"+jyInfo+"】");
			}else{
				log.error("警号为【"+jh+"】,显示信息异常");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("警察进入个人设置异常，请重试"+e.getMessage(),e);
		}
		return jyxx;
	}
	
	@Override
	public JYXX otherInfoSetting(String jh){
		JYXX jyxx = null;
		try {
			if(null!=jh&&""!=jh){
				jyxx = jyxxDao.otherInfoSetting(jh);
			}else{
				log.error("警号为【"+jh+"】,显示信息异常");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("警察进入个人设置异常，请重试"+e.getMessage(),e);
		}
		return jyxx;
	}
	/* (非 Javadoc)
	* @authc quite 验证是否有该职务
	* <p>Title: checkZW</p>
	* <p>Description: </p>
	* @param zwName
	* @return
	* @see com.hd.jy.oasm.services.JyxxService#checkZW(java.lang.String)
	*/
	@Override
	public GroupMan checkZW(String zwName) {
		// TODO Auto-generated method stub
		GroupMan zw = null;
	try {
		log.info("导入excel文件时验证职务时间"+DateUtil.getTime(new Date()));
		zw = jyxxDao.checkZW(zwName);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	return zw;
	}
}
