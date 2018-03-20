package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.dao.TWpqkMapper;
import com.hd.jy.oasm.domain.TWpqk;
import com.hd.jy.oasm.services.TWpqkServices;
/**
 * 
* @ClassName: TWpqkServicesImpl 
* @Description: ͳ��Σ�����
* @author liangjiaying
* @date 2017��12��2��
*
 */
@Service("tWpqkServicesImpl")
public class TWpqkServicesImpl implements TWpqkServices{
	
	private static Logger log = Logger.getLogger(TWpqkServicesImpl.class);
	
	@Autowired
	private TWpqkMapper tWpqkMapper;

	@Override
	public List<TWpqk> getDate(Date sj) {
		List<TWpqk> date2 = null;
		try {
			date2 = tWpqkMapper.getDate(sj);
		} catch (Exception e) {
			log.error("TWpqkServicesImpl.getDate()������"+e);
		}
		return date2;
	}


	@Override
	public Date getTopDate() {
		// TODO Auto-generated method stub
		Date topDate = null;
		try {
			topDate = tWpqkMapper.getTopDate();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("TWpqkServicesImpl.getTopDate();��������"+e);
		}
		return topDate;
	}
	
	

}
