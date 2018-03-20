package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.ViewftjgAndxwgcDao;
import com.hd.jy.oasm.dao.newDao.ViewpgglMapper;
import com.hd.jy.oasm.domain.ViewDasjfx;
import com.hd.jy.oasm.domain.Viewcjjgft;
import com.hd.jy.oasm.domain.Viewcjxwgc;
import com.hd.jy.oasm.domain.Viewrcxwgc;
import com.hd.jy.oasm.domain.Viewrjjgft;
import com.hd.jy.oasm.domain.Viewrjxwgc;
import com.hd.jy.oasm.domain.Viewzqjgft;
import com.hd.jy.oasm.domain.Viewzqxwgc;
import com.hd.jy.oasm.domain.newDomain.Viewpggl;
import com.hd.jy.oasm.services.ViewftjgAndxwgcService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("viewftjgAndxwgcServiceImpl")
@DataSource("userDataSource")
public class ViewftjgAndxwgcServiceImpl implements ViewftjgAndxwgcService{
    private Logger log = Logger.getLogger(ViewftjgAndxwgcServiceImpl.class);
    
    @Autowired
    private ViewftjgAndxwgcDao viewftAndgcDao; //��̸����Ϊ�۲���ͼҵ��ӿ�
    
    @Autowired
    private ViewpgglMapper viewpgglDao; //����v_pggl��ͼҵ��ӿ�
	
    //����̸��ͼ
	@Override
	public List<Viewrjjgft> showViewrjjgft(String jh) {
		// TODO Auto-generated method stub
		List<Viewrjjgft> viewrjjgft = null;
		try {
			log.info("��ʼ��ѯ�����ṹ��̸��ͼViewrjjgft��ʱ��"+DateUtil.getTime(new Date()));
			viewrjjgft = viewftAndgcDao.showViewrjjgft(jh);
			log.info("�ɹ�����"+jh+"��������ṹ��̸��ͼViewrjjgft��"+viewrjjgft.size()+"������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����"+jh+"��ѯ�����ṹ��̸��ͼViewrjjgft��ʧ�ܣ�������..."+e.getMessage());
		}
		return viewrjjgft;
	}

	//���ڷ�̸��ͼ
	@Override
	public List<Viewzqjgft> showViewzqjgft(String jh) {
		// TODO Auto-generated method stub
		List<Viewzqjgft> viewzqjgft = null;
		try {
			log.info("��ʼ��ѯ�����ڷ�̸��ͼViewzqjgft��ʱ��"+DateUtil.getTime(new Date()));
			viewzqjgft = viewftAndgcDao.showViewzqjgft(jh);
			log.info("�ɹ�����"+jh+"��������ڷ�̸��ͼViewzqjgft��"+viewzqjgft.size()+"������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����"+jh+"��ѯ�����ڷ�̸��ͼViewzqjgft��ʧ�ܣ�������..."+e.getMessage());
		}
		return viewzqjgft;
	}

	//�����̸��ͼ
	@Override
	public List<Viewcjjgft> showViewcjjgft(String jh) {
		// TODO Auto-generated method stub
		List<Viewcjjgft> viewcjjgft = null;
		try {
			log.info("��ʼ��ѯ�������̸��ͼViewcjjgft��ʱ��"+DateUtil.getTime(new Date()));
			viewcjjgft = viewftAndgcDao.showViewcjjgft(jh);
			log.info("�ɹ�����"+jh+"����������̸��ͼViewcjjgftviewcjjgft������"+viewcjjgft.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����"+jh+"��ѯ�������̸��ͼViewcjjgftviewcjjgft��ʧ�ܣ�������"+e.getMessage());
		}
		return viewcjjgft;
	}

	//�����Ϊ�۲���ͼ
	@Override
	public List<Viewrjxwgc> findViewrjxwgc(String jh) {
		// TODO Auto-generated method stub/
		List<Viewrjxwgc> viewrjxwgc = null;
		try {
			log.info("��ʼ��ѯ�������Ϊ�۲���ͼViewrjxwgc��ʱ��"+DateUtil.getTime(new Date()));
			viewrjxwgc = viewftAndgcDao.findViewrjxwgc(jh);
			log.info("�ɹ�����"+jh+"��ѯ�������Ϊ�۲���ͼViewrjxwgc������"+viewrjxwgc.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����"+jh+"��ѯ�������Ϊ�۲���ͼViewrjxwgc��ʧ�ܣ�������..."+e.getMessage());
		}
		return viewrjxwgc;
	}

	//�ճ��۲���ͼ
	@Override
	public List<Viewrcxwgc> findViewrcxwgc(String jh) {
		// TODO Auto-generated method stub
		List<Viewrcxwgc> viewrcxwgc = null;
		try {
			log.info("��ʼ��ѯ���ճ��۲�viewrcxwgc��ʱ��"+DateUtil.getTime(new Date()));
			viewrcxwgc = viewftAndgcDao.findViewrcxwgc(jh);
			log.info("�ɹ�����"+jh+"���ճ��۲�viewrcxwgc��"+viewrcxwgc.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����"+jh+"��ѯ���ճ��۲�viewrcxwgc��ʧ�ܣ�������..."+e.getMessage());
		}
		return viewrcxwgc;
	}

	//���ڹ۲���ͼ
	@Override
	public List<Viewzqxwgc> findViewzqxwgc(String jh) {
		// TODO Auto-generated method stub
		List<Viewzqxwgc> viewzqxwgc = null;
		try {
			log.info("��ʼ��ѯ�����ڹ۲���ͼViewzqxwgc��ʱ��"+DateUtil.getTime(new Date()));
			viewzqxwgc = viewftAndgcDao.findViewzqxwgc(jh);
			log.info("�ɹ�����"+jh+"��ѯ�����ڹ۲���ͼViewzqxwgc������"+viewzqxwgc.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����"+jh+"��ѯ�����ڹ۲���ͼViewzqxwgc��ʧ�ܣ�������..."+e.getMessage());
		}
		return viewzqxwgc;
	}

	//����۲���ͼ
	@Override
	public List<Viewcjxwgc> findViewcjxwgc(String jh) {
		// TODO Auto-generated method stub
		List<Viewcjxwgc> viewcjxwgc = null;
		try {
			log.info("��ʼ��ѯ������۲���ͼViewcjxwgc��ʱ��"+DateUtil.getTime(new Date()));
			viewcjxwgc = viewftAndgcDao.findViewcjxwgc(jh);
			log.info("�ɹ�����"+jh+"��ѯ��������۲���ͼViewcjxwgc��"+viewcjxwgc.size()+"������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����"+jh+"��ѯ������۲���ͼViewcjxwgc��ʧ�ܣ�������..."+e.getMessage());
		}
		return viewcjxwgc;
	}

	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//********************************���ϴ������***************************************************
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	//�����ṹ��̸��ͼ����
	@Override
	public List<Viewpggl> rjjgftViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> rjjgftViewpggl = null;
		try {
			log.info("��ʼʹ�á����š���̬��ѯ���ṹ��̸����ʱ��"+DateUtil.getTime(new Date()));
			//�����жϾ���Ϊnullʱ��Ӧ�õ��ý�ɫ�ж�����
			
			rjjgftViewpggl = viewpgglDao.rjjgftViewpggl(map);
			log.info("�ɹ�ʹ�þ��Ŷ�̬��ѯ�����ṹ��̸����"+rjjgftViewpggl.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ʹ�þ��Ų�ѯ���ṹ��̸����ʱ���쳣��������..."+e.getMessage());
		}
		return rjjgftViewpggl;
	}

	//�������Ϊ�۲���ͼ����
	@Override
	public List<Viewpggl> rjxwgcViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> rjxwgcViewpggl = null;
		try {
			log.info("��ʼ���ݾ��š�����"+map.get("jh")+"��ѯ�����Ϊ�۲�����ʱ��"+DateUtil.getTime(new Date()));
			rjxwgcViewpggl = viewpgglDao.rjxwgcViewpggl(map);
			log.info("�ɹ�ʹ�þ��š�"+map.get("jh")+"����̬��ѯ�������Ϊ�۲�����"+rjxwgcViewpggl.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ʹ�þ��Ŷ�̬��ѯ�����Ϊ�۲�����ʧ�ܣ�������..."+e.getMessage());
		}
		return rjxwgcViewpggl;
	}

	//���ճ���Ϊ�۲���ͼ������ʾ
	@Override
	public List<Viewpggl> rcxwgcViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> rcxwgcViewpggl = null;
		try {
			log.info("��ʼ���ݵ�¼���Ŷ�̬��ѯ��ʾ�����ճ���Ϊ�۲졿����ʱ��"+DateUtil.getTime(new Date()));
			rcxwgcViewpggl = viewpgglDao.rcxwgcViewpggl(map);
			log.info("�ɹ����ݾ��š�"+map.get("jh")+"����̬��ѯ�����ճ���Ϊ�۲���ͼ���ݡ�"+rcxwgcViewpggl.size()+"����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ݵ�¼���Ų�ѯ���ճ����Ź۲���ͼ�����쳣"+e.getMessage(),e);
		}
		return rcxwgcViewpggl;
	}

	//�����ڽṹ��̸��ͼ������ʾ
	@Override
	public List<Viewpggl> zqjgftViewpggl(Map<String,Object> map) {
		List<Viewpggl> zqjgftViewpggl = null;
		try {
			log.info("��ʼ���ݵ�¼���Ŷ�̬��ѯ�������ڽṹ��̸��ͼ������ʱ��"+DateUtil.getTime(new Date()));
			zqjgftViewpggl = viewpgglDao.zqjgftViewpggl(map);
			log.info("�ɹ����ݵ�¼���š�"+map.get("jh")+"����ѯ�������ڽṹ��̸��ͼ���ݡ�"+zqjgftViewpggl.size()+"����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯ�����ڽṹ��̸��ͼ�����쳣"+e.getMessage(),e);
		}
		// TODO Auto-generated method stub
		return zqjgftViewpggl;
	}

	//��������Ϊ�۲���ͼ������ʾ
	@Override
	public List<Viewpggl> zqxwgcViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> zqxwgcViewpggl = null;
		try {
			log.info("��ʼ��ѯ����������Ϊ�۲졿��ͼ����ʱ��"+DateUtil.getTime(new Date()));
			zqxwgcViewpggl = viewpgglDao.zqxwgcViewpggl(map);
			log.info("�ɹ����ݾ��š�"+map.get("jh")+"����ѯ����������Ϊ�۲���ͼ���ݡ�"+zqxwgcViewpggl.size()+"����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ݾ��Ŷ�̬��ѯ��������Ϊ�۲���ͼ�����쳣"+e.getMessage(),e);
		}
		return zqxwgcViewpggl;
	}

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
