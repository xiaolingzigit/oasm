package com.hd.jy.oasm.dao;

import java.util.Date;
import java.util.List;

import com.hd.jy.oasm.domain.TWpqk;

public interface TWpqkMapper {
    
    public List<TWpqk> getDate(Date sj);	//��ȡĳ��ʱ�������
    
    Date getTopDate();//�����ʼ��ʱ�� 
}