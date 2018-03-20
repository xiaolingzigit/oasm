package com.hd.jy.oasm.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.newDomain.TCrimScaleRelat;
import com.hd.jy.oasm.domain.newDomain.TQuestion;
import com.hd.jy.oasm.domain.newDomain.TScaleConf;
import com.hd.jy.oasm.domain.newDomain.Tdmin;
import com.hd.jy.oasm.domain.newDomain.TdminfactorRelat;
import com.hd.jy.oasm.domain.newDomain.Tfactor;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.domain.newDomain.Twdyzgx;
import com.hd.jy.oasm.domain.newDomain.Tysk;
/**
 * ά�Ⱥ������߼��ӿڣ�TdminAndtyzServiceImplʵ����
 * @author quite
 *
 */
public interface TdminAndtyzService {
	public int insertTdmin(Tdmin record); // ���ά��
	
    public List<Tdmin> listTdmin(); //ȫ��ѯά�ȣ�������ѯʹ��
	
	public int selectBytdminName(String name); //����ά�����Ʋ�ѯ���е�ά�ȣ������ظ����
	
	public int updateDimName(Tdmin record); //�޸�ά������
	
	
	
	public int insertTfactor(Tfactor record); //�������
	
	public int chckHaveFname(String name); //��֤������
	
	public int checkBytfactorName(String name,int dimId); //�������ӵ����Ʋ�ѯ�Ƿ��������ӣ������ظ����
	
	public int selectByfactorName(String name); //�����������Ʋ�ѯ���ӱ��
	
	public int updateFactorName(Tfactor record); //�������ӱ���޸�����
	
	
	public int checkDimIdFId(int dimId,int fId); //�������Ӻ�ά�ȱ����֤��ϵ
	
	public List<Tfactor> listFactorBydminId(int dimId); //����ά�ȱ���г����е�����
	
	public int insertwdAndyzRelat(TdminfactorRelat record); // ����ά�Ⱥ����ӹ�ϵ
	
	public List<TdminfactorRelat> selectDimAndFactor();//��ʾ���Ӻ�ά�ȵĹ�ϵ,����Ҫ��ҳ
	
	public int updateWdAndYzRelat(Map<String,Object> map); //���ݱ���޸����Ӻ�ά�ȹ�ϵ
	
	
	public int insertQuestion(TQuestion record); //������⣬��ά��Ҳ������ӽ�ȥ
	
	public int removeQuestion(Integer qId); //ɾ������
	
	public String allQuestion(String orgId); //���ݼ�����Ŷ�̬��ѯ���е�����
	
	
	public int checkScaleName(String name); //��֤���������Ƿ����
	
	public int insertTscale(Tscale record); //��ӵ�����
	
	public List<Tscale> scaleAllList();  //�г����е��б�����������ʱʹ��
	
	public List<Tscale> scaleAllListStatus(); //�г����е��б����������ú�δ���õ�
	
	
	public int checkConfName(String name); //��֤ƥ�������Ƿ����
	
	public int insertScaleConf(TScaleConf record); //�����������
	
	public int insertTCrimScaleRelat(TCrimScaleRelat record);//���������������
	
	public List<TScaleConf> scaleConfList(); //�г���������������
	
	//***���ô洢���̣�����һ�����ŵõ������������ú��ﷸ�Ĺ�ϵ***/
	public int useProduceForScaleConf(String creator,Date crTime,Date lastModif,String modifer,int status);
	
	/******************************����Ϊ�޸ĵ����Ӻ�ά�Ȳ���************************************************/
	public int addTysk(Tysk tysk); //������ӻ���ά��
	
	public int addTwdyzgx(Twdyzgx record); //�������ά�ȹ�ϵ
	
	public int updateTysk(Tysk tysk); //�޸����ӻ���ά��
	
	public List<Tysk> likeSomeWdKey(Map<String,String> map); //����һЩά��
	
	public List<Tysk> likeSomeTyskKey(Map<String,String> map); //����һЩ����
	
	public List<Tysk> likeTyskKey(Map<String,String> map); //����ά�Ȼ�������
}
