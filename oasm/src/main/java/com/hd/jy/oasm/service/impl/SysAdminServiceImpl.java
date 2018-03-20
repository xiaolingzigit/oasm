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
			log.info("��ʼ��ѯƥ�䡾SysAdmin������ʱ��"+DateUtil.getTime(new Date()));
			i = sysAdminDao.selectByUser(record);
			log.info("�����û�������ƥ�䵽��"+i+"��");
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
			log.info("��ʼƥ������ʱ��"+DateUtil.getTime(new Date()));
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
			log.info("��ʼ���롾SysAdmin��ʱ��"+DateUtil.getTime(new Date()));
			i = sysAdminDao.insertSelective(record);
			log.info("���롾SysAdmin��"+i+"��");
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
			log.info("��ʼ����"+username+"��ѯʱ��"+DateUtil.getTime(new Date()));
			i = sysAdminDao.check_username_add(username);
			log.info("����Ѵ����û�"+i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ͨ���û���"+username+"��ѯ�쳣");
		}
		return i;
	}

	//���ݱ���޸����룬����Ա���޸�������Ч
	@Override
	public int updateByPrimaryKeySelective(SysAdmin record) {
		// TODO Auto-generated method stub\
		int i = 0;
		try {
			log.info("��ʼ�޸ġ�admin������ʱ��"+DateUtil.getTime(new Date()));
			i = sysAdminDao.updateByPrimaryKeySelective(record);
			log.info("�ɹ��޸�����"+i+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸������쳣���쳣��Ϣ"+e.getMessage());
		}
		return i;
	}

	//�����û����޸�����
	@Override
	public int updateByCurrentUsername(SysAdmin record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ�޸ġ�sysAdmin��ʱ��"+DateUtil.getTime(new Date()));
			i = sysAdminDao.updateByCurrentUsername(record);
			log.info("�ɹ��޸�����"+i+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸������쳣"+e.getMessage());
		}
		return i;
	}

	//�г�������ͨ����Ա
	@Override
	public List<SysAdmin> selectAdminByStatus() {
		// TODO Auto-generated method stub
		List<SysAdmin> byStatus = null;
		try {
			log.info("��ʼ�г�����ͨ����Ա��ʱ��"+DateUtil.getTime(new Date()));
			byStatus = sysAdminDao.selectAdminByStatus();
			log.info("�г����й���Ա"+byStatus.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����Ա�б����������...");
		}
		return byStatus;
	}

	//�߼�ɾ����ͨ����Ա
	@Override
	public int updateBySuperAdminStatus(SysAdmin record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼɾ����ͨ����Աʱ��"+DateUtil.getTime(new Date()));
			i = sysAdminDao.updateBySuperAdminStatus(record);
			log.info("�ɹ�ɾ����ͨ����Ա"+i+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("ɾ������Ա�쳣"+e.getMessage());
		}
		return i;
	}
 
	
	//��ͨ����Ա�ؼ��ֲ�ѯ
	@Override
	public List<SysAdmin> selectByAdminLikeKey(String key) {
		// TODO Auto-generated method stub
		List<SysAdmin> likeKey = null;
		try {
			log.info("��ʼʹ�ùؼ��ֲ�ѯ��SysAdmin��ʱ��"+DateUtil.getTime(new Date()));
			likeKey = sysAdminDao.selectByAdminLikeKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("�ؼ��ֲ�ѯʧ��"+e.getMessage());
		}
		return likeKey;
	}
	
	

}
