package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.newDao.ViewpgglMapper;
import com.hd.jy.oasm.domain.newDomain.Viewpggl;
import com.hd.jy.oasm.services.ViewftjgAndxwgcService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("viewftjgAndxwgcServiceImpl")
@DataSource("userDataSource")
public class ViewftjgAndxwgcServiceImpl implements ViewftjgAndxwgcService{
    private Logger log = Logger.getLogger(ViewftjgAndxwgcServiceImpl.class);
    
//    @Autowired
//    private ViewftjgAndxwgcDao viewftAndgcDao; //��̸����Ϊ�۲���ͼҵ��ӿ�
    
    @Autowired
    private ViewpgglMapper viewpgglDao; //����v_pggl��ͼҵ��ӿ�

	//�³���ṹ��̸��ͼ������ʾ
	@Override
	public List<Viewpggl> cjjgftViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> cjjgftViewpggl = null;
		try {
			log.info("��ʼ��ѯ���³���ṹ��̸����ͼ����ʱ��"+DateUtil.getTime(new Date()));
			cjjgftViewpggl = viewpgglDao.cjjgftViewpggl(map);
			log.info("�ɹ����ݾ��š�"+map.get("jh")+"����ѯ���³���ṹ��̸��ͼ���ݡ�"+cjjgftViewpggl.size()+"����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯ�³���ṹ��̸��ͼ�����쳣"+e.getMessage(),e);
		}
		return cjjgftViewpggl;
	}

	//�ȳ�����Ϊ�۲���ͼ������ʾ
	@Override
	public List<Viewpggl> cjxwgcViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> cjxwgcViewpggl = null;
		try {
			log.info("��ʼ���в�ѯ���³�����Ϊ�۲졿��ͼ����ʱ��"+DateUtil.getTime(new Date()));
			cjxwgcViewpggl = viewpgglDao.cjxwgcViewpggl(map);
			log.info("�ɹ����ݾ��š�"+map.get("jh")+"����ѯ���³�����Ϊ�۲���ͼ���ݡ�"+cjxwgcViewpggl+"����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯ�³�����Ϊ�۲���ͼ�����쳣"+e.getMessage(),e);
		}
		return cjxwgcViewpggl;
	}

}
