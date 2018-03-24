package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.GroupMan;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.domain.ZRole;

/***
 * 
 * @author quite
 * param��Ա��Ϣ�����ӿڣ�������¼����Ӿ�Ա�����ְ�񣬽�ɫ��ѯ
 *
 */
public interface JyxxService {
	public int insertSelective(JYXX record);
	
	public JYXX selectCheck(String jh);
	
	public int selectCheckUser(JYXX record);
	
	public List<ZRole> selectAllZroll();  //����ȫ��ѯ����
	
	public List<ZRole> selectAllGroupMan(Integer id);  //�����ܽ�ɫ��������ѯְ��
	
	public int insertGroupMan(GroupMan record);  //���ְ��
	
	public List<JYXX> selectJyxx(); //ȫ��ѯ��Ա��Ϣ
	
	public int updateByPrimaryKeySelective(JYXX record); //�޸ľ�Ա��Ϣ
	
	public int updateCerrurJh(JYXX record); //���ݵ�ǰ��¼�����޸�����
	
	public JYXX infoSetting(String jh); //���ݾ��Ų�ѯ�����˵��������Լ�������Ϣ��ʾ
	
	public JYXX otherInfoSetting(String jh);
	
	public GroupMan checkZW(String zwName); //����ְ�����Ʋ�ѯ�Ƿ��и�ְ��
}
