package com.hd.jy.oasm.services;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.domain.BGwxlx;
import com.hd.jy.oasm.domain.TevalReport;
import com.hd.jy.oasm.domain.VPgbgList;
import com.hd.jy.oasm.domain.Viewgrpgbgxx;
/***
 * ���������߼��ӿڣ�PGBGViewController����
 * @author quite
 *
 */
public interface VPgbgListService {
	
	/**
	 * <p>Title: getViewPgbg</p>   
	 * <p>Description: ��ѯ���������б�</p>   
	 * @param type	Map<String,Object>
	 * @return   
	 */
	public List<VPgbgList> getViewPgbg(Map<String,Object> map);
	
	/**
	 * <p>Title: crimInfoBycrimNo</p>   
	 * <p>Description: ͨ�����Ų�ѯ�������������Ϣ</p>   
	 * @param 	qh ����
	 * @return   
	 */
	public BGjbxx crimInfoBycrimNo(String qh); //�������������ﷸ��Ϣ��ʾ
	
	/**
	 * <p>Title: evalReportCount</p>   
	 * <p>Description: ���ñ�����������Ż�ȡΣ�յȼ�</p>   
	 * @param 	taskId ������
	 * @return   
	 */
	TevalReport evalReportCount(String taskId); 

	/**
	 * <p>Title: getGrdjbh</p>   
	 * <p>Description: ����Σ�յȼ��仯</p>   
	 * @param qh ����
	 * @return   List
	 */
	public List<VPgbgList> getGrdjbh(String qh);
	
	/**
	 * <p>Title: getLsPgbg</p>   
	 * <p>Description: �ﷸ��ʷ��������</p>  
	 * @param qh ���� 
	 * @return   List
	 */
	public List<VPgbgList> getLsPgbg(String qh);
	
	
	public String getPgbgTestNote(int bgstu,String taskId); //ͨ���������Ż�ȡ�������ŵĴ����¼
	
	public List<BGwxlx> getWxlxReport(String rwId); //��ʾΣ����������
	
	public String getCrimInfoRecord(String crimNo); //ͨ�����Ų�ѯ�����ﷸ��Ϣ--������Ŀ��ʾ
	
	List<VPgbgList> listViewPgbgAndTCzsh(Map<String,Object> map);//��ʾ���洦����١���ˡ����
	
}
