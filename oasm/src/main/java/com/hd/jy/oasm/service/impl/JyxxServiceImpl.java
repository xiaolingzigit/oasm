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
//ָ��jdbc����Դ�����ݿ�
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
			log.info("��ʼ���롾JYXX��ʱ��"+DateUtil.getTime(new Date()));
			i = jyxxDao.insertSelective(record);
			log.info("�ɹ����롾JYXX��"+i+"������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���롾JYXX���쳣��Ϣ"+e.getMessage());
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
			log.info("��ʼ��ѯ��JYXX��ʱ��"+DateUtil.getTime(new Date()));
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
			log.info("��ʼȫ��ѯ��ZRole��ʱ��"+DateUtil.getTime(new Date()));
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
			log.info("��ʼ���ݡ�ZRole��������ѯ��GroupMan��ʱ��"+DateUtil.getTime(new Date()));
			list = zRoleDao.selectAllGroupMan(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/***
	 * ���ְ�񣬷���int����
	 */
	@Override
	public int insertGroupMan(GroupMan record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ���롾GroupMan��ʱ��"+DateUtil.getTime(new Date()));
			i = zRoleDao.insertGroupMan(record);
			log.info("�ɹ����롾GroupMan��"+i+"������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���롾GroupMan���쳣"+e.getMessage());
		}
		return i;
	}
	@Override
	public List<JYXX> selectJyxx() {
		// TODO Auto-generated method stub
		List<JYXX> list = null;
		try {
			log.info("��ʼ��ѯ��JYXX��ʱ��"+DateUtil.getTime(new Date()));
			list = jyxxDao.selectJyxx();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯ��JYXX������"+e.getMessage());
		}
		return list;
	}
	@Override
	public int updateByPrimaryKeySelective(JYXX record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("�޸ġ�JYXX����ʼʱ��"+DateUtil.getTime(new Date()));
			i = jyxxDao.updateByPrimaryKeySelective(record);
			log.info("�ɹ��޸�����"+i+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸ġ�JYXX��ʧ��");
		}
		return i;
	}
	@Override
	public int updateCerrurJh(JYXX record){
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ�޸�����ʱ��"+DateUtil.getTime(new Date()));
			i = jyxxDao.updateCerrurJh(record);
			log.info("�ɹ��޸�����"+i+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸�����ʧ�ܣ�������..."+e.getMessage());
		}
		return i;
	}
	/**
	 * @ TODO
	 * @authc quite
	 * @date 2017��12��27��
	 * @see com.hd.jy.oasm.services.JyxxService#infoSetting(java.lang.String)
	 */
	@Override
	public JYXX infoSetting(String jh) {
		// TODO Auto-generated method stub
		JYXX jyxx = null;
//		String jyInfo = null;
		try {
			log.info("���쿪ʼ�������������ʱ��"+DateUtil.getTime(new Date())+"��");
			if(null!=jh&&""!=jh){
				jyxx = jyxxDao.infoSetting(jh);
//				jyInfo = GsonUtil.toJson(jyxx);
//				log.info("����ǰ�����ݡ�"+jyInfo+"��");
			}else{
				log.error("����Ϊ��"+jh+"��,��ʾ��Ϣ�쳣");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���������������쳣��������"+e.getMessage(),e);
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
				log.error("����Ϊ��"+jh+"��,��ʾ��Ϣ�쳣");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���������������쳣��������"+e.getMessage(),e);
		}
		return jyxx;
	}
	/* (�� Javadoc)
	* @authc quite ��֤�Ƿ��и�ְ��
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
		log.info("����excel�ļ�ʱ��ְ֤��ʱ��"+DateUtil.getTime(new Date()));
		zw = jyxxDao.checkZW(zwName);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	return zw;
	}
}
