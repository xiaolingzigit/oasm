package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.GroupMan;
import com.hd.jy.oasm.domain.JYXX;

public interface JYXXMapper {

    int insert(JYXX record);

    int insertSelective(JYXX record);

    JYXX selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JYXX record); //�޸ľ�Ա��Ϣ
    
    JYXX selectCheck(String jh);
	
	int selectCheckUser(JYXX record);

    int updateByPrimaryKey(JYXX record);
    
    List<JYXX> selectJyxx(); //ȫ��ѯ��Ա��Ϣ
    
    int updateCerrurJh(JYXX record); //���ݵ�ǰ��¼�����޸�����
    
    JYXX infoSetting(String jh); //���ݾ��Ų�ѯ�����˵��������Լ�������Ϣ��ʾ
    
    GroupMan checkZW(String zwName); //����ְ�����Ʋ�ѯ�Ƿ��и�ְ��
}