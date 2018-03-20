package com.hd.jy.oasm.dao.newDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hd.jy.oasm.domain.newDomain.TCrimScaleRelat;
import com.hd.jy.oasm.domain.newDomain.TQuestion;
import com.hd.jy.oasm.domain.newDomain.TScaleConf;
import com.hd.jy.oasm.domain.newDomain.Tdmin;
import com.hd.jy.oasm.domain.newDomain.TdminfactorRelat;
import com.hd.jy.oasm.domain.newDomain.Tfactor;
import com.hd.jy.oasm.domain.newDomain.Tscale;

/**
 * ά�Ⱥ�����ҵ��ӿ� ��TdminAndtyzService�е���
 * @author quite
 *
 */
public interface TdminAndtyzDao {
	//*************************ά�Ȳ���**************************************************
   List<Tdmin> listTdmin(); //ȫ��ѯά�ȣ�������ѯʹ��
	
   int insertTdmin(Tdmin record); // ���ά��
   
   int selectBytdminName(String name); //����ά�����Ʋ�ѯ���е�ά�ȣ������ظ����
   
   int updateDimName(Tdmin record); //�޸�ά������
   
   //**************************���Ӳ���**************************************************
   int insertTfactor(Tfactor record); //�������
   
   int chckHaveFname(String name); //��֤������
   
   int checkBytfactorName(@Param("name") String name,@Param("dimId") int dimId); //�������ӵ����Ʋ�ѯ�Ƿ��������ӣ������ظ����
   
   int selectByfactorName(String name); //�����������Ʋ�ѯ���ӱ��
   
   int updateFactorName(Tfactor record); //�������ӱ���޸�����
   
   //***********************ά�����ӹ�ͬ����******************************************************************
   int checkDimIdFId(@Param("dimId") int dimId,@Param("fId") int fId); //��֤���Ӻ�ά�ȹ�ϵ
   
   List<Tfactor> listFactorBydminId(int dimId); //����ά�ȱ���г����е�����
   
   int insertwdAndyzRelat(TdminfactorRelat record); // ����ά�Ⱥ����ӹ�ϵ
   
   List<TdminfactorRelat> selectDimAndFactor();//��ʾ���Ӻ�ά�ȵĹ�ϵ,����Ҫ��ҳ
   
   int updateWdAndYzRelat(Map<String,Object> map); //���ݱ���޸����Ӻ�ά�ȹ�ϵ
   
   //***********************���ⲿ��************************************************************
   int insertQuestion(TQuestion record); //������⣬��ά��Ҳ������ӽ�ȥ
   
   int removeQuestion(Integer qId);
   
   //*********************ʹ������ά�Ⱥ���������������******************************************************************
   List<TQuestion> allQuestion(String orgId); //���ݼ�����Ŷ�̬��ѯ���е�����
   
   int checkScaleName(String name); //��֤���������Ƿ����

   int insertTscale(Tscale record); //��ӵ�����
   
   List<Tscale> scaleAllList();  //�г����е��б�����������ʱʹ�ã���ʾ�����õ�
   
   List<Tscale> scaleAllListStatus(); //�г����е��б����������ú�δ���õ�
   
   //*********************�������ò���***************************************************************
   int checkConfName(String name); //��֤ƥ�����������Ƿ����
   
   int insertScaleConf(TScaleConf record); //�����������
   
   List<TScaleConf> scaleConfList(); //�г���������������
   
   int insertTCrimScaleRelat(TCrimScaleRelat record);//���������������
   
   
   //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   //***************************��ʽ������ʼ*******************************************************
   //++++++++++++++++++++++++++++��ZuoTiServce�����++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   
   TCrimScaleRelat crimScaleRelatByTaskId(String taskId); //ͨ����ʾ�����Ż�ȡ�������õĹ�ϵ������������
   
   Tscale getScaleByScaleId(int id); //ͨ������id��ȡ�������е����⣬ѡ�ά�ȣ����ӣ�Ȩ��*����
   
}
