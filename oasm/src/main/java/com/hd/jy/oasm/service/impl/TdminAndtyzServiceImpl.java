package com.hd.jy.oasm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.TzyrymdMapper;
import com.hd.jy.oasm.dao.newDao.TdminAndtyzDao;
import com.hd.jy.oasm.dao.newDao.TyskAndwdDao;
import com.hd.jy.oasm.domain.Tzyrymd;
import com.hd.jy.oasm.domain.newDomain.Question;
import com.hd.jy.oasm.domain.newDomain.SystemConfig;
import com.hd.jy.oasm.domain.newDomain.Question.Option;
import com.hd.jy.oasm.domain.newDomain.TCrimScaleRelat;
import com.hd.jy.oasm.domain.newDomain.TQuestion;
import com.hd.jy.oasm.domain.newDomain.TScaleConf;
import com.hd.jy.oasm.domain.newDomain.Tdmin;
import com.hd.jy.oasm.domain.newDomain.TdminfactorRelat;
import com.hd.jy.oasm.domain.newDomain.Tfactor;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.domain.newDomain.Twdyzgx;
import com.hd.jy.oasm.domain.newDomain.Tysk;
import com.hd.jy.oasm.services.TdminAndtyzService;
import com.hd.jy.oasm.util.date.DateUtil;
import com.hd.jy.oasm.util.lsc.GsonUtil;
/**
 * ά�Ⱥ������߼��ӿ�ʵ����
 * @author quite
 *
 */
@Service("tdminAndtyzServiceImpl")
@DataSource("userDataSource")
public class TdminAndtyzServiceImpl implements TdminAndtyzService {
     private Logger log = Logger.getLogger(TdminAndtyzServiceImpl.class);
     
     @Autowired
     private TdminAndtyzDao tdminAndzyDao; //����ά�Ⱥ�����ҵ��ӿ�
     
     @Autowired
     private TzyrymdMapper tzyrymdDao;  //������Ѻ��Ա������ҵ��ӿ�����Ĵ洢����
     
     @Autowired
     private TyskAndwdDao tyskAndwdDao; //����ά����������޸�
	
     private String logDate = DateUtil.getTime(new Date()); //������־���ʱ��
     
	@Override
	public int insertTdmin(Tdmin record) {//���ά��
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(record!=null){
				log.info("��ʼ�����ά��ʱ�䡿"+logDate);
				i = tdminAndzyDao.insertTdmin(record);
			}else{
				log.error("���ά��ʱ��ά��Ϊ"+record+"����������ȷ�Ϻ�����...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ӡ�ά���쳣�������Ժ�����..."+e.getMessage());
		}
		return i;
	}

	@Override
	public int insertTfactor(Tfactor record) { //�������
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(record!=null){
				log.info("��ʼ��������ӡ�ʱ��"+logDate);
				i = tdminAndzyDao.insertTfactor(record);
			}else{
				log.error("�������ʱʧ�ܣ�ʧ��ԭ������Ϊ"+record+"��,��ȷ�Ϻ�����...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ӡ������쳣�������Ժ�����..."+e.getMessage());
		}
		return i;
	}

	
	@Override
	public int selectBytdminName(String name) {//��֤ά������
		// TODO Auto-generated method stub
		int i = 0;
		try {
				log.info("��ʼ��֤��ά������ʱ�䡿"+logDate);
			if(name!=null&&name!=""){
				i = tdminAndzyDao.selectBytdminName(name);
				log.info("�ɹ����ݡ�ά������"+name+"����֤�Ľ��Ϊ"+i);
			}else{
				log.error("��֤��ά�����ơ�ʱʧ�ܣ�ά������Ϊ"+name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��֤��ά�����ơ��쳣�����Ժ�����..."+e.getMessage());
		}
		return i;
	}

	@Override
	public int checkBytfactorName(String name,int dimId) {//��֤��������
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(name!=null&&name!=""){
				log.info("��ʼ���С���֤�������ơ�����ʱ��"+logDate);
				i = tdminAndzyDao.checkBytfactorName(name,dimId);
				log.info("�ɹ�����֤��������"+name+"��,���ؽ��Ϊ"+i);
			}else{
				log.error("����֤�������ơ�ʱʧ�ܣ���������Ϊ"+name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����֤�������ơ��쳣�����Ժ�����..."+e.getMessage());
		}
		return i;
	}

	@Override
	public List<Tdmin> listTdmin() {  //*****************�г�����ά��*************************
		// TODO Auto-generated method stub
		List<Tdmin> tdmin = null;
		try {
			log.info("��ʼ���г�����ά�ȡ�ʱ��"+logDate);
			tdmin = tdminAndzyDao.listTdmin();
			log.info("�ɹ��г�����ά������"+tdmin.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯ����ά���쳣�����Ժ�����..."+e.getMessage());
		}
		return tdmin;
	}

	@Override
	public List<Tfactor> listFactorBydminId(int dimId) { //*********����ά�ȱ���г���������**********************
		// TODO Auto-generated method stub
		List<Tfactor> factorBydminId = null;
		try {
			log.info("��ʼ���ݡ�ά�ȱ��"+dimId+"����ѯ�������б�ʱ��"+logDate);
			factorBydminId = tdminAndzyDao.listFactorBydminId(dimId);
			log.info("�ɹ����ݡ�ά�ȱ��"+dimId+"���������"+factorBydminId.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ݡ�ά�ȱ��"+dimId+"����ѯ�����쳣,���Ժ�����..."+e.getMessage());
		}
		return factorBydminId;
	}

	@Override
	public int insertwdAndyzRelat(TdminfactorRelat record) { //************�������Ӻ�ά�ȹ�ϵ*******************
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(record!=null){
				log.info("��ʼ���ݲ������Ӻ�ά�ȹ�ϵʱ��"+logDate);
				i = tdminAndzyDao.insertwdAndyzRelat(record);
				log.info("�ɹ�������Ӻ�ά�ȹ�ϵ"+i+"��");
			}else{
				log.error("������Ӻ�ά�ȹ�ϵʧ�ܣ���ȷ�Ϻ�����...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�������Ӻ�ά�ȹ�ϵ�쳣��������..."+e.getMessage());
		}
		return i;
	}

	//***********************�������*********************************
	@Override
	public int insertQuestion(TQuestion record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ��������⡿ʱ��"+logDate);
			i = tdminAndzyDao.insertQuestion(record);
			log.info("�ɹ������������"+i+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��������쳣��������..."+e.getMessage());
		}
		return i;
	}

	//*************************�������****************************************
	@Override
	public int insertTscale(Tscale record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ���������ʱ��"+logDate);
			i = tdminAndzyDao.insertTscale(record);
			log.info("�ɹ������������"+i+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��������쳣��������..."+e.getMessage());
		}
		return i;
	}

	//*******************************�����������*************************************************
	@Override
	public int insertScaleConf(TScaleConf record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ������������á�ʱ��"+logDate);
			i = tdminAndzyDao.insertScaleConf(record);
			log.info("�ɹ�����������ø���"+i+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������������쳣��������..."+e.getMessage());
		}
		return i;
	}

	//********************************�������-��������****************************************************
	@Override
	public int insertTCrimScaleRelat(TCrimScaleRelat record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ���������-�������á�ʱ��"+logDate);
			i = tdminAndzyDao.insertTCrimScaleRelat(record);
			log.info("�ɹ��������-����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�������-�����쳣��������..."+e.getMessage());
		}
		return i;
	}

	//�����������ֲ�ѯ���ӱ��
	@Override
	public int selectByfactorName(String name) {
		// TODO Auto-generated method stub
		int fid = 0;
		try {
			log.info("��ʼ���ݡ���������"+name+"����ѯʱ��"+logDate);
			fid = tdminAndzyDao.selectByfactorName(name);
			log.info("�ɹ���ѯ�����ӱ��"+fid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fid;
	}

	//��ѯ���Ӻ�ά�ȵĹ�ϵ�б�
	@Override
	public List<TdminfactorRelat> selectDimAndFactor() {
		// TODO Auto-generated method stub
		List<TdminfactorRelat> dimAndFactor = null;
		try {
			log.info("��ʼ��ȫ��ѯά�Ⱥ����ӵĹ�ϵ�б�ʱ��"+logDate);
			dimAndFactor = tdminAndzyDao.selectDimAndFactor();
			log.info("�ɹ���ѯ��ά�Ⱥ����ӵĹ�ϵ�б�"+dimAndFactor.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯά�Ⱥ����ӹ�ϵ�쳣��������..."+e.getMessage());
		}
		return dimAndFactor;
	}

	//���ݼ����Ŷ�̬��ѯ�����б������
	@Override
	public String allQuestion(String orgId) {
		// TODO Auto-generated method stub
		List<Question> queList = new ArrayList<>();
		List<TQuestion> question = null;
		Question que = null; //�½�һ��Question��json����
		String optionJSON = null;
		try {
			log.info("��ʼ���ݡ�������"+orgId+"��ѯ�б����⡿ʱ��"+logDate);
			question = tdminAndzyDao.allQuestion(orgId);
			
			for (TQuestion tq : question) {
				que = new Question();
				que.setqId(tq.getQstId()); //������
				que.setType(String.valueOf(tq.getType())); //��ѡ��ѡ
				que.setqName(tq.getQuestion());//����
				que.setOrgId(tq.getOrgId());//������
				que.setqRemark(tq.getRemark());//�ж�����
				que.setDimId(tq.getDimId()); //ά������
				que.setDimName(tq.getTdmin().getDimName());
				
				String[] splitOptions = tq.getOptions().split("%%");
				List<Option> options = new  ArrayList<>();
				for (int i = 0; i < splitOptions.length; i++) {
					log.info("�ָ�%%֮���ѡ��ֵ����"+splitOptions[i]+"��");
					String option = splitOptions[i]; //����������
					String[] splitOption = option.split("#");
				    Option op = new Option(splitOption[0], splitOption[1], splitOption[2], splitOption[3],null);
				    options.add(op);
				   
				}
				
				que.setOptions(options);
				queList.add(que);
			}
			optionJSON = GsonUtil.toJson(queList);
			
//			log.info("��ʽ��֮�������"+optionJSON);
			log.info("�ɹ��г������б�����"+question.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ݡ�������"+orgId+"����ʾ�����б��쳣��������..."+e.getMessage());
		}
		return optionJSON;
		
	}

	//��֤�������ֺ������Ƿ����
	@Override
	public int checkScaleName(String name) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(name!=null&&name!=""){
				log.info("��ʼ���ݡ���������"+name+"��ʱ��"+logDate);
				i = tdminAndzyDao.checkScaleName(name);
				log.info("������������ƥ�����������"+i+"");
			}else{
				log.error("��������Ϊ��"+name+"��,ƥ��ʧ�ܣ�������ȷ�Ϻ�����...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ݡ���������"+name+"��ƥ�������쳣��������..."+e.getMessage());
		}
		return i;
	}

	//��֤��������
	@Override
	public int checkConfName(String name) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(name!=null&&name!=""){
				log.info("��ʼ�����������֡�"+name+"��ƥ��ʱ��"+logDate);
				i = tdminAndzyDao.checkConfName(name);
				log.info("�ɹ�ƥ���ƥ������"+i+"��");
			}else{
				log.error("��������Ϊ��"+name+"��,��ȷ��֮������...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ƥ�����������쳣��������..."+e.getMessage());
		}
		return i;
	}

	//�г���������������ţ��������֣��������ͣ����������ʱʹ��
	@Override
	public List<Tscale> scaleAllList() {
		// TODO Auto-generated method stub
		List<Tscale> scaleAllList = null;
		try {
			log.info("���������ʱ���г����е�����ʱ��"+logDate);
			scaleAllList = tdminAndzyDao.scaleAllList();
			log.info("�ɹ��г���������ʱ��Ҫ�������б�����"+scaleAllList.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�г���������ʱ��Ҫ�����������쳣��������..."+e.getMessage());
		}
		return scaleAllList;
	}

	//�г������������ù�ϵ
	@Override
	public List<TScaleConf> scaleConfList() {
		// TODO Auto-generated method stub
		List<TScaleConf> confList = null;
		try {
			log.info("��ʼ���С��������ù�ϵ��ʱ��"+logDate);
			confList = tdminAndzyDao.scaleConfList();
			log.info("�ɹ��г����������ù�ϵ����"+confList.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("�г��������ù�ϵ�쳣��������...");
		}
		return confList;
	}

	@Override
	public int useProduceForScaleConf(String creator, Date crTime, Date lastModif, String modifer, int status) {
		// TODO Auto-generated method stub
		SystemConfig config = new SystemConfig();
		TCrimScaleRelat csr = null;
		int i = 0;
		try {
			log.info("��ʼ���ô洢���̻�ȡ������Ѻ�ﷸ����ʱ��"+logDate);
			List<Tzyrymd> zyyrymdProduce = tzyrymdDao.useZyyrymdProduce();
			if(zyyrymdProduce.size()>0){
				for (Tzyrymd tzyrymd : zyyrymdProduce) {
					csr = new TCrimScaleRelat();
					csr.setCrimNo(tzyrymd.getQh()); //��ȡ����
					log.info("��ȡȫ�����ñ��:"+Integer.parseInt(config.getConf("CURR_DEF_SCALE")));
					csr.setSconfId(Integer.parseInt(config.getConf("CURR_DEF_SCALE"))); //��ȡȫ������
					csr.setCrTime(crTime);
					csr.setCreator(creator);
					csr.setModifier(modifer);
					csr.setLastModif(lastModif);
					csr.setStatus(status);
					
					i = tdminAndzyDao.insertTCrimScaleRelat(csr);
				}
			}else{
				log.error("ʹ�ô洢���̵�������ʧ�ܣ�ִ�д洢���̻�ȡ���ŵĸ���Ϊ��"+zyyrymdProduce.size()+"��");
				return i;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ﷸ������������쳣��������..."+e.getMessage());
		}
		
		return i;
	}

	//�г����������ú�δ���õ����� ��LBKController����
	@Override
	public List<Tscale> scaleAllListStatus() {
		// TODO Auto-generated method stub
		List<Tscale> allListStatus = null;
		try {
			log.info("��ʼ���г�����������δ����״̬������ʱ��"+logDate);
			allListStatus = tdminAndzyDao.scaleAllListStatus();
			log.info("�ɹ��г�����������δ���õ���������"+allListStatus.size()+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�г�������δ���õ���������ʧ�ܣ�������..."+e.getMessage());
		}
		return allListStatus;
	}

	/**
	 * ɾ������
	 * @author quite
	 */
	@Override
	public int removeQuestion(Integer qId) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼɾ������ѡ��ʱ��"+logDate);
			if(null!=qId){
				 i = tdminAndzyDao.removeQuestion(qId);
				 log.info("�ɹ�ɾ������ѡ��"+i+"������");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("ɾ������ѡ������쳣��������..."+e.getMessage(),e);
		}
		return i;
	}

	/**
	 * @ TODO �޸�ά������
	 * @authc quite
	 * @date 2018��1��5��
	 * @see com.hd.jy.oasm.services.TdminAndtyzService#updateDimName(com.hd.jy.oasm.domain.newDomain.Tdmin)
	 */
	@Override
	public int updateDimName(Tdmin record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ�޸�ά������ʱ��"+logDate);
			if(null!=record){
				i = tdminAndzyDao.updateDimName(record);
				log.info("�ɹ��޸�ά������"+i+"������");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸�ά�������쳣�����Ժ�����..."+e.getMessage(),e);
		}
		return i;
	}

	/**
	 * @ TODO �޸���������
	 * @authc quite
	 * @date 2018��1��5��
	 * @see com.hd.jy.oasm.services.TdminAndtyzService#updateFactorName(com.hd.jy.oasm.domain.newDomain.Tfactor)
	 */
	@Override
	public int updateFactorName(Tfactor record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ�޸���������ʱ��"+logDate);
			if(null!=record){
				i = tdminAndzyDao.updateFactorName(record);
				log.info("�ɹ��޸���������"+i+"������");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸����������쳣�����Ժ�����..."+e.getMessage(),e);
		}
		return i;
	}

	/**
	 * @ TODO �޸�ά�Ⱥ����ӹ�ϵ
	 * @authc quite
	 * @date 2018��1��5��
	 * @see com.hd.jy.oasm.services.TdminAndtyzService#updateWdAndYzRelat(com.hd.jy.oasm.domain.newDomain.TdminfactorRelat)
	 */
	@Override
	public int updateWdAndYzRelat(Map<String,Object> map) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ�޸�ά�Ⱥ����ӹ�ϵʱ��"+logDate);
			if(null!=map){
				i = tdminAndzyDao.updateWdAndYzRelat(map);
				log.info("�ɹ��޸�ά�Ⱥ����ӹ�ϵ"+i+"������");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸�ά�Ⱥ����ӹ�ϵ�쳣��������..."+e.getMessage(),e);
		}
		return i;
	}
   
	/*
	 * (�� Javadoc)
	* @authc quite
	* <p>Title: chckHaveFname</p>
	* <p>Description: ��֤��������</p>
	* @param name
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#chckHaveFname(java.lang.String)
	 */
	@Override
	public int chckHaveFname(String name) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ��֤��������ʱ�䡾"+logDate+"����������"+name+"��");
			if(null!=name){
				i = tdminAndzyDao.chckHaveFname(name);
				log.info("������֤�ɹ����ݣ���ʾ��������"+i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��֤�����쳣�����Ժ�����..."+e.getMessage(),e);
		}
		return i;
	}

	/* (�� Javadoc)
	* @authc quite
	* <p>Title: checkDimIdFId</p>
	* <p>Description: </p>
	* @param dimId
	* @param fId
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#checkDimIdFId(int, int)
	*/
	@Override
	public int checkDimIdFId(int dimId, int fId) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ��֤���Ӻ�ά�ȹ�ϵ�Ƿ����ʱ��"+logDate);
			i = tdminAndzyDao.checkDimIdFId(dimId, fId);
			log.info("��֤�����Ӻ�ά�ȹ�ϵ�ĸ�����"+i+"������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��֤���Ӻ�ά�ȹ�ϵ�쳣��������..."+e.getMessage(),e);
		}
		return i;
	}

	/***************************���²���Ϊ���Ӻ�ά������޸�**************************************************/
	/* 
	* @authc quite
	* <p>Title: addTysk</p>
	* <p>Description: ������ӻ���ά��</p>
	* @param tysk
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#addTysk(com.hd.jy.oasm.domain.newDomain.Tysk)
	*/
	@Override
	public int addTysk(Tysk tysk) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ������ӻ���ά��ʱ��"+logDate);
			if(null!=tysk){
				i = tyskAndwdDao.addTysk(tysk);
			}
			log.info("�ɹ�������ӻ���ά������"+i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������ӻ���ά���쳣��������..."+e.getMessage(),e);
		}
		return i;
	}

	/* (�� Javadoc)
	* @authc quite
	* <p>Title: addTwdyzgx</p>
	* <p>Description:���ά�����ӹ�ϵ </p>
	* @param record
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#addTwdyzgx(com.hd.jy.oasm.domain.newDomain.Twdyzgx)
	*/
	@Override
	public int addTwdyzgx(Twdyzgx record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ������Ӻ�ά�ȹ�ϵʱ��"+logDate);
			if(null!=record){
				i = tyskAndwdDao.addTwdyzgx(record);
			}
			log.info("�ɹ�������Ӻ�ά�ȹ�ϵ����"+i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������Ӻ�ά�ȹ�ϵ�쳣"+e.getMessage(),e);
		}
		return i;
	}

	/* (�� Javadoc)
	* @authc quite
	* <p>Title: updateTysk</p>
	* <p>Description:�޸�ά�Ȼ������ӹ�ϵ </p>
	* @param tysk
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#updateTysk(com.hd.jy.oasm.domain.newDomain.Tysk)
	*/
	@Override
	public int updateTysk(Tysk tysk) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("��ʼ�޸����ӻ���ά��ʱ��"+logDate);
			if(null!=tysk){
				i = tyskAndwdDao.updateTysk(tysk);
			}
			log.info("�ɹ��޸����ӻ���ά������"+i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸����ӻ���ά�������쳣"+e.getMessage(),e);
		}
		return i;
	}

	/* (�� Javadoc)
	* @authc quite
	* <p>Title: likeSomeWdKey</p>
	* <p>Description: ����ά��</p>
	* @param map
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#likeSomeWdKey(java.util.Map)
	*/
	@Override
	public List<Tysk> likeSomeWdKey(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<Tysk> wdKey = null;
		try {
			log.info("��ʼ��������ά��ʱ��"+logDate);
			if(null!=map){
				wdKey = tyskAndwdDao.likeSomeWdKey(map);
			}
			log.info("***�ɹ�����ά�ȷ���ǰ������***"+JSON.toJSON(wdKey));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��������ά���쳣��������..."+e.getMessage(),e);
		}
		return wdKey;
	}

	/* (�� Javadoc)
	* @authc quite
	* <p>Title: likeSomeTyskKey</p>
	* <p>Description:�������� </p>
	* @param map
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#likeSomeTyskKey(java.util.Map)
	*/
	@Override
	public List<Tysk> likeSomeTyskKey(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<Tysk> someTyskKey = null;
		try {
			log.info("��ʼ������������ʱ��"+logDate);
			if(null!=map){
				someTyskKey = tyskAndwdDao.likeSomeTyskKey(map);
			}
			log.info("**�ɹ����������ӷ���ǰ������**"+JSON.toJSON(someTyskKey));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���������쳣��������..."+e.getMessage(),e);
		}
		return someTyskKey;
	}

	/* (�� Javadoc)
	* @authc quite
	* <p>Title: likeTyskKey</p>
	* <p>Description: �������Ӻ�ά��</p>
	* @param map
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#likeTyskKey(java.util.Map)
	*/
	@Override
	public List<Tysk> likeTyskKey(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<Tysk> tyskKey = null;
		try {
			log.info("��ʼ����ȫ��������ӻ���ά��ʱ��"+logDate);
		if(null!=map){
			tyskKey = tyskAndwdDao.likeTyskKey(map);
		}
		log.info("***�ɹ�ȫ����������ӻ���ά������***"+JSON.toJSON(tyskKey));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�������ӻ���ά���쳣��������..."+e.getMessage(),e);
		}
		return tyskKey;
	}

}
