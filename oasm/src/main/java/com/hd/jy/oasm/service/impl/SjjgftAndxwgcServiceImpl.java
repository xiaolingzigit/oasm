package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.SjjgftAndxwgcDao;
import com.hd.jy.oasm.dao.TestMapper;
import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.domain.ViewDafxjg;
import com.hd.jy.oasm.services.SjjgftAndxwgcService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("sjjgftAndxwgcServiceImpl")
@DataSource("userDataSource")
public class SjjgftAndxwgcServiceImpl implements SjjgftAndxwgcService {
    private Logger log = Logger.getLogger(SjjgftAndxwgcServiceImpl.class);
	
    @Autowired
    private SjjgftAndxwgcDao sjjgftAndxwgcDao;  //�ṹ��̸����Ϊ�۲�ҵ���߼��ӿڵ���
    
    @Autowired
    private TestMapper testNoteDao; //��������ʾ
    
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//*********************************����ҳ���ϵ�������������ͼ����******************************************************
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//�������������--�����еĵ����������������ʾ��ҳ�����--ά��--����--����
	@Override
	public TestNote searchDafxjg(String jcdaid) {
		// TODO Auto-generated method stub
		TestNote note = null;
		try {
			if(jcdaid!=null){
				log.info("��ʼ���ݡ����������¼����"+jcdaid+"��ʱ��"+DateUtil.getTime(new Date()));
				note = testNoteDao.getNote(jcdaid);
				log.debug("��ѯ���еġ��������������"+note.getAnswer());
			}else{
				log.error("��������������¼���š�Ϊ"+jcdaid+"��������ȷ�Ϻ�����...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ݡ�������������¼����"+jcdaid+"����ѯ�쳣��������..."+e.getMessage());
		}
		return note;
	}

	/**
	 * @ TODO
	 * @authc quite
	 * @date 2017��12��23��
	 * @see com.hd.jy.oasm.services.SjjgftAndxwgcService#selectDafxjgbg(java.util.Map)
	 */
	@Override
	public List<ViewDafxjg> selectDafxjgbg(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<ViewDafxjg> dafxjgbg = null;
		try {
			log.info("��ʼȫ��ѯ�������������������ʱ��"+DateUtil.getTime(new Date()));
			dafxjgbg = sjjgftAndxwgcDao.selectDafxjgbg(map);
			log.info("�ɹ�����������������������"+dafxjgbg.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ȫ��ѯ�������������������ʧ�ܣ����Ժ�����..."+e.getMessage(),e);
		}
		return dafxjgbg;
	}

}
