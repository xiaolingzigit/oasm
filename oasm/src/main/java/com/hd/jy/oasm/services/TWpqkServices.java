package com.hd.jy.oasm.services;

import java.util.Date;
import java.util.List;

import com.hd.jy.oasm.domain.TWpqk;

public interface TWpqkServices {
	
	List<TWpqk> getDate(Date date);	//��ȡĳ��ʱ�������
	
	Date getTopDate();//�����ʼ��ʱ�� 
	
}
