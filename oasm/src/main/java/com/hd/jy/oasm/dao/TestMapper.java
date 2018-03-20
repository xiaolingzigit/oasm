package com.hd.jy.oasm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hd.jy.oasm.domain.BGgtft;
import com.hd.jy.oasm.domain.BGjcxxpg;
import com.hd.jy.oasm.domain.BGwxlx;
import com.hd.jy.oasm.domain.BGxwgc;
import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.domain.TevalReport;
import com.hd.jy.oasm.domain.Viewrwxq;

/***
 * �����¼ҵ��ӿ�
 * @author quite
 *���ã�ͨ�õ�ҵ��ӿ��ڸ�����Ҫ��service�Լ�����
 */
public interface TestMapper {

	int saveNote(TestNote testNote); //��������¼
	
	int saveGtfts(BGgtft record); //����ṹ��̸�����¼
	
	int saveXwgcs(BGxwgc record); //������Ϊ�۲�����¼
	
	int saveJcdafxs(BGjcxxpg record); //��������������������¼

	TestNote getNote(String taskId); //���������Ų�ѯ�����¼
	
	List<BGjcxxpg> getAllJcxxpg(String taskId); //�����������Ż�ȡ����������
	
	List<BGgtft> getAllGtft(String taskId); //�����������Ż�ȡ����������
	
	List<BGxwgc> getAllXwgc(String taskId); //�����������Ż�ȡ��Ϊ�۲�����Ӻ�id
	
	List<Viewrwxq> getChildrenStatus(String taskId); //���ݸ������ȡ����������״̬
	
	String getWxdj(@Param("fs") int fs,@Param("lx") String lx);//��������״̬Ϊ4��ʱ�����ͳ��Σ�յȼ�
	
	int addEvalReport(TevalReport record); //����������棬����ͳ�ƺͷ���
	
	TevalReport evalReportCount(String taskId); //���������Ż�ȡΣ�յȼ�
	
	/***
	 * ��ӵ�Σ�����ͱ�
	 * @auto quite
	 * @param record
	 * @return
	 * ����6:33:05
	 * int
	 */
	int addWxlxReport(BGwxlx record); 
	
	/***
	 * ���������Ż�ȡ��ɱ�����ѣ����ף��ٷ���Σ������
	 * @auto quite
	 * @param rwId
	 * @return
	 * ����6:37:23
	 * List<BGwxlx>
	 */
	List<BGwxlx> getWxlxReport(String rwId);
	
	/**
	 * �������CopaPi���Խ��������Σ�����ͷ������
	 * @param pgrwid ��������ID
	 * @param wxlxfs Σ����������������
	 * @return
	 */
	int saveWxxpgFs(String pgrwid,String wxlxfs); 
	
	/**
	 * ����������ʾ�ﷸ���з�������������--�ڽ�����Ŀ--�ﷸ��Ϣ��ѯ
	 * @auto quite
	 * @param qh
	 * @returna
	 * ����2:50:24
	 * List<TevalReport>
	 */
	List<TevalReport> crimInfoReport(String qh); 
}
