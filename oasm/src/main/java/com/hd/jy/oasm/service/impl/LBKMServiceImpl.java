package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.LBKMMapper;
import com.hd.jy.oasm.dao.ZCYCYQPCMapper;
import com.hd.jy.oasm.dao.newDao.TdminAndtyzDao;
import com.hd.jy.oasm.domain.LBKM;
import com.hd.jy.oasm.domain.WD;
import com.hd.jy.oasm.domain.ZCYCYQPC;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.services.LBKMService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("lBKMServiceImpl")
@DataSource("userDataSource")
public class LBKMServiceImpl implements LBKMService {
	private Logger log = Logger.getLogger(LBKMServiceImpl.class);
	
	@Autowired
	private LBKMMapper lbkmDao; //�����ҵ��ӿڣ�������ࡢ�ճ������ڡ������ҵ��ӿ�

	@Autowired
	private ZCYCYQPCMapper zcycyqpcDao; //�쳣�����Ų�ҵ��ӿ�
	
	@Autowired
	private TdminAndtyzDao tdminAndtyzDao; //�����ҵ��ӿ�
	
	@Override
	public List<LBKM> selectAllkm() {
		// TODO Auto-generated method stub
		List<LBKM> list = null;
		try {
			log.info("��ʼȫ��ѯ��LBKM��ʱ��"+DateUtil.getTime(new Date()));
			list = lbkmDao.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯ��LBKM���쳣��������..."+e.getMessage());
		}
		return list;
	}
	
	//�ر������õ�����
		@Override
		public int closeOrstartLBKMisLive(String lbbh) {
			// TODO Auto-generated method stub
			int i = 0;
			try {
				log.info("�رջ���������ʱ��"+DateUtil.getTime(new Date()));
				i = lbkmDao.closeOrstartLBKMisLive(lbbh);
				log.info("�ɹ��رջ���������"+i+"��");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("�رջ����������쳣��������..."+e.getMessage());
			}
			return i;
		}

	//ѡ�������������flѡ��Ҫ�������Ŀ
	@Override
	public List<LBKM> cjlbtmyz(String fl) {
		// TODO Auto-generated method stub
		List<LBKM> cjlbtmyz = null;
		try {
			log.info("��ʼ����"+fl+"��ѯ�������������ӡ�ʱ��"+DateUtil.getTime(new Date()));
			cjlbtmyz = lbkmDao.cjlbtmyz(fl);
			log.info("�ɹ���ѯ�������������ӡ�"+cjlbtmyz.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����"+fl+"��ѯ���������������쳣��"+e.getMessage());
		}
		return cjlbtmyz;
	}

	//��ȡά���б�
	@Override
	public List<WD> selectAllWd() {
		// TODO Auto-generated method stub
		List<WD> selectAllWd = null;
		try {
			selectAllWd = lbkmDao.selectAllWd();
			log.info("���"+selectAllWd.size()+"������");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("��ȡά���б�"+e);
		}
		return selectAllWd;
	}

	//��ȡĳ���׶ε�������
	@Override
	public List<LBKM> selectRDLB(String str) {
		// TODO Auto-generated method stub
		List<LBKM> selectRDLB = null;
		try {
			 selectRDLB = lbkmDao.selectRDLB(str);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(""+e);
		}
		return selectRDLB;
	}

	//�����쳣����ҵ��ӿڸ������Ų�ѯ�쳣����
	@Override
	public List<ZCYCYQPC> selectYCYQ(String yqztbh) {
		// TODO Auto-generated method stub
		List<ZCYCYQPC> ycyqList = null;
		try {
			if(yqztbh!=null&&yqztbh!=""){
				log.info("��ʼ��������"+yqztbh+"��ѯ�����쳣����ʱ��"+DateUtil.getTime(new Date()));
				ycyqList = zcycyqpcDao.selectYCYQ(yqztbh);
			}else{
				log.error("��������"+yqztbh+"��ѯ�����쳣����ʧ�ܣ���ȷ�Ϻ�����...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�������Ų�ѯ�����쳣�����쳣��������..."+e.getMessage());
		}
		return ycyqList;
	}

	//���������Ų�ѯ���Ӻ�ά�ȣ��ں�̨��������ʹ��
	@Override
	public String scaleRelatById(int scaleId) {
		// TODO Auto-generated method stub
		String scale = null;
		Tscale te;
		try {
			log.info("��ʼ���������Ų�ѯʹ�õġ����⣬ά�ȣ�����Ԥ����ʱ��"+DateUtil.getTime(new Date()));
			te = tdminAndtyzDao.getScaleByScaleId(scaleId);
			scale = te.getScale();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����ʹ�õ����⣬ά�ȣ�����Ԥ���쳣��������..."+e.getMessage(),e);
		}
		return scale;
	}


}
