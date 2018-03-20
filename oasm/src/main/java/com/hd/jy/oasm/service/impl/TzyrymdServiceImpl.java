package com.hd.jy.oasm.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.TzyrymdMapper;
import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.Tzyrymd;
import com.hd.jy.oasm.services.TzyrymdService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("tzyrymdServiceImpl")
@DataSource("userDataSource")
public class TzyrymdServiceImpl implements TzyrymdService {
	private Logger log = Logger.getLogger(TzyrymdServiceImpl.class);

	@Autowired
	private TzyrymdMapper tzyrymdDao;  //��Ѻ�ﷸҵ��ӿ�
	
	@Override
	public Tzyrymd selectBDJCbyqh(long qh) {
		// TODO Auto-generated method stub
		Tzyrymd bdjCbyqh = null;
		try {
			log.info("��ʼ�������Ų�ѯ���󶨵ľ���Tzyrymd��ʱ��"+DateUtil.getTime(new Date()));
			bdjCbyqh = tzyrymdDao.selectBDJCbyqh(qh);
			log.info("�ɹ�����"+qh+"��ѯ���󶨵ľ���Tzyrymd��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����"+qh+"��ѯ���󶨵ľ���Tzyrymd��ʧ��"+e.getMessage());
		}
		return bdjCbyqh;
	}

	//����rj��̸����״̬
	@Override
	public int updateRjftzt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateRjftzt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//����rj��Ϊ�۲�״̬
	@Override
	public int updateGczt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateGczt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//�����ճ��۲�״̬
	@Override
	public int updateRcgczt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateRcgczt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//�������ڽṹ��̸״̬
	@Override
	public int updateZqftzt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateZqftzt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//����������Ϊ�۲�״̬
	@Override
	public int updateZqGczt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateZqGczt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//���ĳ���ṹ��̸״̬
	@Override
	public int updateCjftzt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateCjftzt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//���ĳ�����Ϊ�۲�״̬
	@Override
	public int updateCjgczt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateCjgczt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	 //ʹ��excel������ﷸ�뾯��Ĺ�����Ϣ ����ֻ���򵥵��߼�����ʵ��Ӧ��Ӧ���ǰ�����ʾ�������������
	@Override
	public int crimPlaceSaveOrUpdate(Tjczjdx record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ�����������뾯��Ĺ�ϵ��ʱ��"+DateUtil.getTime(new Date()));
			i = tzyrymdDao.crimPlaceSaveOrUpdate(record);
			log.info("�ɹ����������뾯���ϵ"+i+"������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���������뾯���ϵ�쳣��������...");
		}
		return i;
	}

}
