package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.SystemLogDao;
import com.hd.jy.oasm.services.SystemLogService;
import com.hd.jy.oasm.util.date.DateUtil;
import com.hd.jy.oasm.util.domain.SystemLog;
@Service("systemLogServiceImpl")
@DataSource("userDataSource")
public class SystemLogServiceImpl implements SystemLogService {
	private Logger log = Logger.getLogger(SystemLogServiceImpl.class);
	
    @Autowired
    private SystemLogDao systemLogDao;
    
	@Override
	public int insertLog(SystemLog record) {
		// TODO Auto-generated method stub
		return systemLogDao.insertLog(record);
	}
	/**
	 * @ TODO
	 * @authc quite
	 * @date 2017��12��28��
	 * @see com.hd.jy.oasm.services.SystemLogService#systemLogInfo(java.util.Map)
	 */
	@Override
	public List<SystemLog> systemLogInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<SystemLog> info = null;
		try {
			log.info("��ʼ��ѯ��̨ϵͳ������־ʱ��"+DateUtil.getTime(new Date()));
			info = systemLogDao.systemLogInfo(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������־��ʾ�쳣��������..."+e.getMessage(),e);
		}
		return info;
	}
	/* 
	* @authc quite
	* <p>Title: backupDB</p>
	* <p>Description: </p>
	* @param fileName
	* @return
	* @see com.hd.jy.oasm.services.SystemLogService#backupDB(java.lang.String)
	*/
	@Override
	public String backupDB(String fileName) {
		// TODO Auto-generated method stub
		String filePath = "";
		try {
			log.info("��ʼ�������ݿⱸ��ʱ��"+DateUtil.getTime(new Date()));
			if(null!=fileName&&""!=fileName){
				filePath = systemLogDao.backupDB(fileName);
				log.info("�ɹ�������ݿ���������ʱ��"+DateUtil.getTime(new Date()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			filePath = "�ļ�·���Ҳ���";
		}
		return filePath;
	}

}
