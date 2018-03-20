package com.hd.jy.oasm.action.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.annotation.Log;
import com.hd.jy.oasm.domain.newDomain.Question;
import com.hd.jy.oasm.domain.newDomain.Question.Option;
import com.hd.jy.oasm.domain.newDomain.Scale;
import com.hd.jy.oasm.domain.newDomain.SystemConfig;
import com.hd.jy.oasm.domain.newDomain.TCrimScaleRelat;
import com.hd.jy.oasm.domain.newDomain.TQuestion;
import com.hd.jy.oasm.domain.newDomain.TScaleConf;
import com.hd.jy.oasm.domain.newDomain.Tdmin;
import com.hd.jy.oasm.domain.newDomain.TdminfactorRelat;
import com.hd.jy.oasm.domain.newDomain.Tfactor;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.services.TdminAndtyzService;
import com.hd.jy.oasm.services.ZuoTiSerivce;
import com.hd.jy.oasm.util.lsc.GsonUtil;

/**
 * ά�Ⱥ����ӿ��Ʋ㡣ҳ���������ӣ����ά�ȣ��޸����ӣ��޸�ά�ȵȲ�������
 * @author quite
 *
 */
@Controller
@RequestMapping("tdminAndtyz")
public class TdminAndtyzController {
	private Logger log = Logger.getLogger(TdminAndtyzController.class);
	
	@Autowired
	private TdminAndtyzService tdminAndyzService; //ά�Ⱥ������߼��ӿ�
	
	@Autowired
	private ZuoTiSerivce zuotiService; //���������߼��ӿڣ��������������õ�ʱ����е�������
  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  //********************************ά�Ȳ�������******************************************************
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/***
	 * ��֤ά��
	 * @auto quite
	 * @param dimName
	 * @returna
	 * ����2:30:01
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/checkDminName",method={RequestMethod.GET,RequestMethod.POST})
	public int checkDminName(String dimName){//��֤ά����
		log.info("��֤��ά����"+dimName+"��");
		int i = 0;
		try {
			if(dimName!=null&&dimName!=""){
				i = tdminAndyzService.selectBytdminName(dimName.trim());
			}else{
				return (i=1); //���Ϊnull�򷵻�1��ʾ�Ѵ��ڲ����ظ�����
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��֤ά�����쳣�����Ժ�����...");
		}
		return i;
	}
	
	/***
	 * //���ά��
	 * @auto quite
	 * @param dimName
	 * @param session
	 * @returna
	 * ����2:17:48
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/insertTdmin",method={RequestMethod.GET,RequestMethod.POST})
	public int insertTdmin(String dimName,String remark,HttpSession session){ //ҳ�洫��ά�����ƺ��û���
		int i = 0;
		String username = (String)session.getAttribute("username"); //��ȡ��¼���û���
		log.info("��ӡ�ά����"+dimName+"�������û���"+username+"��");
		Tdmin dmin = null ;
	   try {
		    if(username!=null&&username!=""){
		    	dmin =  new Tdmin();
				dmin.setDimName(dimName.trim());  //ά������
				dmin.setRemark(remark.trim());
				dmin.setCreator(username); //ʹ�ù���Ա��Ϊ������
				dmin.setCrTime(new Date()); //����ʱ��
				dmin.setLastModif(new Date()); //����޸�ʱ�䣬�״�Ϊά�ȴ���ʱ��
				dmin.setModifier(username); //ʹ�ù���Ա��Ϊ�״��޸�ʱ��
				dmin.setStatus(2); //1��ʾδ���� �� 2��ʾ����
			    i = tdminAndyzService.insertTdmin(dmin);
		    }else{
		    	log.error("���ά��ʧ�ܣ������Ա��¼������...");
		    }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("���ά���쳣��������...");
	}
		return i;
	}
	
	/**
	 *  �޸�ά������
	 * @auto quite
	 * @param dimName
	 * @param dimId
	 * @param session
	 * @returna
	 * ����12:14:24
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/updateDimName",method={RequestMethod.GET,RequestMethod.POST})
	public int updateDimName(String dimName,int dimId,HttpSession session){
		int i = 0;
		Tdmin tm = null;
		try {
			String username = (String)session.getAttribute("username");
			log.info("�޸ġ�ά����"+dimName+"������ά�ȱ��"+dimId+"�������û���"+username+"��");
			if(null!=username&&username.length()>0){
				tm = new Tdmin();
				tm.setDimId(dimId);
				tm.setDimName(dimName.trim());
				tm.setLastModif(new Date());
				tm.setModifier(username);
				i = tdminAndyzService.updateDimName(tm);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸�ά����ʧ�ܣ����Ժ�����...");
		}
		return i;
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 //********************************���Ӳ�������******************************************************
	 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/***
	 * ��֤���Ӻ�ά�ȹ�ϵ
	 * @auto quite
	 * @param name
	 * @returna
	 * ����3:01:20
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/checkFactorName",method={RequestMethod.GET,RequestMethod.POST})
	public int checkFactorName(String name,int dimId){//��֤������
		int i = 0;
		try {
			if(name!=null&&name!=""){
				i = tdminAndyzService.checkBytfactorName(name.trim(),dimId);
			}else{
				return i=1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��֤��������ʧ�ܣ����Ժ�����...");
		}
		return i;
	}
	
	/**
	 * 
	 * @todo TODO
	 * @param name
	 * @return
	 * @auth quite
	 * @time 2018��1��9�� ����12:03:07
	 *
	 */
	@ResponseBody
	@RequestMapping(value="checkHaveFname",method={RequestMethod.GET,RequestMethod.POST})
	public int checkHaveFname(String name){
		int i = 0;
		log.info("��֤�ġ���������"+name+"��");
		try {
			i = tdminAndyzService.chckHaveFname(name.trim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������֤����������ʧ�ܣ����Ժ�����...");
		}
		return i;
	}
	
	/***
	 * �޸���������
	 * @auto quite
	 * @param fName
	 * @param fId
	 * @param session
	 * @returna
	 * ����2:19:55
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/updateFaName",method={RequestMethod.GET,RequestMethod.POST})
	public int updateFaName(String fName,int fId,HttpSession session){
		int i = 0;
		Tfactor tf = null;
		try {
			String username = (String)session.getAttribute("username");
			log.info("�޸����ӡ��û���"+username+"��������������"+fName+"���������ӱ��"+fId+"��");
			if(null!=username&&username.length()>0){
			  tf = new Tfactor();
			  tf.setfId(fId);
			  tf.setName(fName.trim());
			  tf.setLastModif(new Date());
			  tf.setModifier(username);
			  i = tdminAndyzService.updateFactorName(tf);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸���������ʧ�ܣ����Ժ�����...");
		}
		return i;
	}

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 //********************************���Ӻ�ά�ȹ�ϵ��������******************************************************
	 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /***
     * �г�����ά��
     * @auto quite
     * @returna
     * ����5:06:39
     * List<Tdmin>
     */
	@ResponseBody
    @RequestMapping(value="/listTdmin",method={RequestMethod.GET,RequestMethod.POST})
    public List<Tdmin> listTdmin(){
    	List<Tdmin> listTdmin = null;
		try {
			listTdmin = tdminAndyzService.listTdmin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�г�����ά��ʧ�ܣ����Ժ�����...");
		}
    	return listTdmin;
    }
	
	/***
	 * ����ά�ȱ���г��������ӹ�ѡ������ṩ��ѡ�����ʽ
	 * @auto quite
	 * @param dimId
	 * @returna
	 * ����5:11:45
	 * List<Tfactor>
	 */
	@ResponseBody
	@RequestMapping(value="/listFactor",method={RequestMethod.GET,RequestMethod.POST})
	public List<Tfactor> listFactor(int dimId){//ά�ȱ��
		log.info("dimID==>"+dimId);
		List<Tfactor> listFactorBydminId = null;
		try {
			listFactorBydminId = tdminAndyzService.listFactorBydminId(dimId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����ά���г�����ʧ�ܣ�������...");
		}
		return listFactorBydminId;
		
	}
	
	/***
	 * ������Ӻ�ά�ȵĹ�ϵ
	 * @auto quite
	 * @param dimId ά�ȱ��
	 * @param fId ���ӱ��
	 * @param session ��ȡsession��username������
	 * @returna
	 * ����5:23:44
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/addWdYzRelat",method={RequestMethod.GET,RequestMethod.POST})
	public  int addWdYzRelat(int dimId,int fScore,String name,String remark,HttpSession session){ //fidΪ��ѯ֮���id
		int i = 0;
		TdminfactorRelat relat = null; //��������ά�ȹ�ϵ����
		Tfactor tf = null;//�������Ӷ���
		String username = (String)session.getAttribute("username");
		log.info("���û���"+username+"����ά�ȱ�š�"+dimId+"�����������ơ�"+name+"����������"+remark+"��");
		try {
			if(username!=null&&username!=""){ //���жϹ���Ա�˺Ų���Ϊnull
				try {
					//���Ӳ���
					tf = new Tfactor();
					tf.setName(name.trim());
					tf.setfScore(fScore);
					tf.setRemark(remark.trim());
					tf.setCreator(username);
					tf.setCrTime(new Date());
					tf.setLastModif(new Date());
					tf.setModifier(username);
					tf.setStatus(2);
                    tdminAndyzService.insertTfactor(tf);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					if (e.getMessage().contains("�ظ�") || e.getMessage().toLowerCase().contains("duplic")) {
						//
					} else {
						throw e;
					}
				}
				    int fId = tdminAndyzService.selectByfactorName(name.trim()); //�õ����ӱ��
				    log.info("������Ӻ�ά�ȹ�ϵ��Ҫ�ġ����ӱ��"+fId+"��");
					relat = new TdminfactorRelat();
					relat.setDimId(dimId);
					relat.setfId(fId);
					relat.setCrTime(new Date());
					relat.setCreator(username.trim());
					relat.setLastModif(new Date());
					relat.setModifier(username.trim());
					relat.setStatus(2);
					i = tdminAndyzService.insertwdAndyzRelat(relat); //������ӵ����Ӻ�ά�ȹ�ϵ����
			}else{
				log.error("���ȵ�¼����Ա�˺�...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
				log.error("������Ӻ�ά��ʧ�ܣ���ȷ�����������...");
		}
		return i;
	}
	
	@ResponseBody
	@RequestMapping(value="checkDIdFId",method={RequestMethod.GET,RequestMethod.POST})
	public int checkDIdFId(int dimId,int fId){
		log.info("��֤���Ӻ�ά�ȹ�ϵ�ġ�ά�ȱ��"+dimId+"���������ӱ��"+fId+"��");
		int i = 0;
		try {
			i = tdminAndyzService.checkDimIdFId(dimId, fId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��֤���Ӻ�ά�ȹ�ϵʧ�ܣ����Ժ�����");
		}
		return i;
	}
	
	/***
	 * �޸�ά�Ⱥ����ӹ�ϵ
	 * @auto quite
	 * @param session
	 * @returna
	 * ����2:50:15
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/updateWYRelat",method={RequestMethod.GET,RequestMethod.POST})
	public int updateWYRelat(int da,int fa,int db,int fb,HttpSession session){
		int i = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			String username = (String)session.getAttribute("username");
			if(null!=username&&username.length()>0){
				map.put("da", da); //�޸�ά�ȱ��Ϊ
				map.put("fa", fa); //�޸����ӱ��Ϊ
				map.put("lastModif", new Date());
				map.put("modifier", username);
				map.put("db", db); //��Ҫ�޸ĵ�ά�ȱ��
				map.put("fb", fb); //��Ҫ�޸ĵ����ӱ��
				i = tdminAndyzService.updateWdAndYzRelat(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸�ά�Ⱥ����ӹ�ϵʧ�ܣ����Ժ�����...");
		}
		return i;
	}
	
	
  //***************************����ѡ���*********************************************************
	@ResponseBody
	@RequestMapping(value="/addQuestion",method={RequestMethod.GET,RequestMethod.POST})
	@Log(operationType="�������",operationName="�������")
	public int addQuesttion(int dimId,String orgId,String question,int type,String remark,String options
		,HttpSession session){
		int i = 0;
		TQuestion tq = null;
	   try {
		String username = (String)session.getAttribute("username");
		log.info("��ά�ȱ��"+dimId+"�������������"+orgId+"������ѡ������"+type+"��");
		log.info("�������ġ��û���"+username+"����������"+question+"����������"+remark+"������ѡ��"+options+"��");
		if(username!=null&&username!=""){
			String optionsName = options.replaceAll("%%,", "%%").trim(); //��%%,�滻��%%�洢
			log.info("�滻ѡ�ѡ������"+optionsName+"��");
			tq = new TQuestion();
			tq.setDimId(dimId); //ά�ȱ��
			tq.setOrgId(orgId);//��֯���  ƥ�������������֯����
			tq.setQuestion(question.trim());//����
			tq.setType(type);//���� 1Ϊ��ѡ ��2Ϊ��ѡ
			tq.setRemark(remark.trim());//���� ���ӵ��ж�����
			tq.setOptions(optionsName);//ѡ��  ʹ�� ѡ����#ѡ������#���ӱ��#��������ֱ�Ӵ洢
//			tq.setAnswer(answer);//��ʱ��������洢��
			tq.setCrTime(new Date());//����ʱ��
			tq.setCreator(username);//������
			tq.setLastModif(new Date());//����޸�ʱ��
			tq.setModifier(username);//����޸���
			tq.setStatus(2);//״̬��Ĭ�����2����״̬
			i = tdminAndyzService.insertQuestion(tq);
		}else{
		  log.error("�������ʧ�ܣ���ȷ����¼״̬������...");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�������ʧ�ܣ�������...");
		}
		return i;
	}
	
	/***
	 * ���ݼ����Ŷ�̬��ȡ�����б�
	 * @auto quite
	 * @param orgId
	 * @returna
	 * ����11:59:59
	 * String ����String���͵�JSON����
	 */
	@ResponseBody
	@RequestMapping(value="/orgAllQuestion",method={RequestMethod.GET,RequestMethod.POST})
	public String orgAllQuestion(String orgId){
		log.info("ƥ�䱾�������⡾�������"+orgId+"��");
		String question = null;
		try {
			question = tdminAndyzService.allQuestion(orgId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("���ݼ�����Ŷ�̬�г������б��쳣��������...");
		}
		return question;
		
	}
	
	/**
	 * ɾ������ѡ��
	 * @author quite
	 * @param qId
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="removeQuestion",method={RequestMethod.GET,RequestMethod.POST})
	@Log(operationType="ɾ������",operationName="ɾ������")
	public int removeQuestion(int qId,HttpSession session){
		int i = 0;
		String username = (String)session.getAttribute("username");
		log.info("ɾ������ġ����"+qId+"�������û���"+username+"��");
		try {
			if(null!=username&&username.length()>0){
				i = tdminAndyzService.removeQuestion(qId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ɾ������ʧ�ܣ���ȷ�������������...");
		}
		return i;
	}
	
 //*********************************�����������********************************************************
	/***
	 * ������������ƥ�������Ƿ����
	 * @auto quite
	 * @param name
	 * @returna
	 * ����10:38:32
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/checkScaleName",method={RequestMethod.GET,RequestMethod.POST})
	public int checkScaleName(String name){
		int i = 0;
		try {
			i = tdminAndyzService.checkScaleName(name.trim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������������ƥ�������Ƿ����ʧ�ܣ�������...");
		}
		return i;
	}
	/***
	 * �������ģ��
	 * @auto quite
	 * @param name ��������
	 * @param type ��������
	 * @param remark ������˵��
	 * @param researher ������
	 * @param scale ��������
	 * @param session ��ȡsession����
	 * @returna
	 * ����4:51:52
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/addTscale",method={RequestMethod.GET,RequestMethod.POST})
	public int addTscale(String name,String type,String remark,
			String researher,String scale,HttpSession session){
		int i = 0;
		Tscale sc = null;
		Question que = null;
		
		try {
		String username = (String)session.getAttribute("username");
		log.info("������ӡ��û���"+username+"��������������"+type+"����������"+remark+"������������"+researher+" ��������������"+scale+"��");
		if(username!=null&&username!=""){
			sc = new Tscale();
			sc.setName(name.trim());  //��������
			sc.setType(type);  //���� ��B:�ṹ��̸,C:��Ϊ�۲�
			sc.setRemark(remark.trim()); //����˵��
			sc.setResearher(researher.trim()); //������
			
			List<Question> queList = new ArrayList<Question>();
			String scaleJson = "";
			
			String[] splitScale = scale.trim().split("QQQ");
			for (int j = 0; j < splitScale.length; j++) {
//				3#�����������ڣ��������Щ���󣬽�������Σ�#����@@1# ����������󣬾����ͺ�̬���ܽ��ܵ�#����������󣬾����ͺ�̬���ܽ��ܵ�#1%%2# ����������󣬵���ʱ��û�н����#����������󣬵���ʱ��û�н����#1%%3# ����������󣬾����ͺ󣬵��Ծɾ�����#����������󣬾����ͺ󣬵��Ծɾ�����#1%%
				String[] splitQuestion = splitScale[j].split("@@");
				   log.info("�������ݷָ�Ϊ��"+splitQuestion.length+"������");
				   String strQues = ""; 
				   String strOpts = "";
				   if(splitQuestion.length==2){
					   strQues = splitQuestion[0]; //��һ����Ϊ����
					   strOpts = splitQuestion[1]; //�ڶ�����Ϊѡ��
						log.info("����������:"+strQues+"��");
						log.info("��ѡ������:"+strOpts+"��");
				    }else{
				    	log.error("�������ݷָ��쳣�����ݡ�2��<��"+splitQuestion.length+"������");
				    	return i;
				    }
					//���и����ⲿ��
					String[] splitQue = strQues.split("#");
					   log.info("�����������ݣ������š�"+splitQue[0]+"�����������ݡ�"+splitQue[1]+"�����ж����ݡ�"+splitQue[2]+"��ά�ȱ�š�"+splitQue[3]+"��ά�����ݡ�"+splitQue[4]+"��");
						que = new Question();
						que.setqId(Integer.parseInt(splitQue[0])); //������
						que.setqName(splitQue[1]); //��������
						que.setqRemark(splitQue[2]); //�ж�����
						que.setDimId(Integer.parseInt(splitQue[3])); //ά�ȱ��
						que.setDimName(splitQue[4]); //ά������
						que.setType(splitQue[5]); //��������
					
					String[] splitOpt = strOpts.split("%%");
					List<Option> optList = new ArrayList<>();
					for (int k = 0; k < splitOpt.length; k++) {
						String[] soc = splitOpt[k].split("#"); //ѭ��k��ֵ
						log.info("��������ѡ��ָ�Ϊ��"+soc.length+"������");
						if(soc.length==5){
							log.info("ѡ���������ݣ�ѡ��š� "+soc[0]+"����ѡ�����ݡ� "+soc[1]+" �������ӱ�š� "+soc[4]+"�����������ݡ� "+soc[2]+" ����Ȩ�ء� "+soc[3]+"��");
							Option opn = new Question.Option(soc[0], soc[1], soc[4], soc[2], "1", soc[3]);
							optList.add(opn);
						}else{
							log.error("ѡ��ָ��쳣��ѡ��ָ5��<��"+soc.length+"������");
							return i;
						}
					}
					que.setOptions(optList);
					
					queList.add(que);
				
					scaleJson = GsonUtil.toJson(queList); //�������⡢ѡ��ϲ����
			}
			sc.setScale(scaleJson);
			sc.setCreator(username);
			sc.setCrTime(new Date());
			sc.setLastModif(new Date());
			sc.setModifier(username);
			sc.setStatus(2);
			i = tdminAndyzService.insertTscale(sc);
		}else{
			log.error("ִ�е�ǰ���������Ա�ȵ�¼...");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�������ʧ�ܣ�������...");
		}
		return i;
	}
	
  //*********************************�������ò�������******************************************************
   /***
    * �������ֽ���ƥ�����
    * @auto quite
    * @param name
    * @returna
    * ����5:25:56
    * int
    */
	@ResponseBody
   @RequestMapping(value="/checkConfName",method={RequestMethod.GET,RequestMethod.POST})
   public int checkConfName(String name){ //���õ�����
		log.info("��֤��������"+name+"��");
	   int i = 0;
	   try {
		i = tdminAndyzService.checkConfName(name.trim());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.info("�����������ֽ���ƥ���쳣��������...");
	}
	   return i;
   }
	
	/**
	 * �г������������ݲ�ͬ��������
	 * @auto quite
	 * @returna
	 * ����10:37:17
	 * List<Tscale>
	 */
	@ResponseBody
	@RequestMapping(value="/scaleAllList",method={RequestMethod.GET,RequestMethod.POST})
	public List<Tscale> scaleAllList(){
		List<Tscale> scaleAllList = null;
		try {
			scaleAllList = tdminAndyzService.scaleAllList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�г�����ʧ�ܣ����Ժ�����...");
		}
		return scaleAllList;
	}
	
	/***
   * ��������������ò���ģ��
   * @auto quite
   * @param name ��������
   * @param conf ���ã�Ӧ��ΪJSON�ַ���
   * @param remark ����
   * @param session ��ȡsession����
   * @returna
   * ����4:58:12
   * int
   */
  @ResponseBody
  @RequestMapping(value="/addScaleConf")
  public int addScaleConf(String name,String conf,String remark,int status,HttpSession session){
	  int i = 0;
	  TScaleConf sac = null;
	  String scaJSON = "";
	  try {
	  String username = (String)session.getAttribute("username");
	  log.info("����������õġ��û���"+username+"��������������"+name+" ��������"+conf+"����������"+remark+"��");
	 if(username!=null&&username!=""){
		 sac = new TScaleConf();
		  sac.setName(name.trim());
		  String[] splitConf = conf.split("#");
		  List<Scale> scaList = new ArrayList<Scale>();
		  log.info("���õ���������������:"+splitConf[0]+"����:"+splitConf[1]+"���:"+splitConf[2]+"����:"+splitConf[3]+"���ճ�����:�����:"+splitConf[4]+"����:"+splitConf[5]+"����������:�����:"+splitConf[6]+"����:"+
				  splitConf[7]+"���:"+splitConf[8]+"����:"+splitConf[9]+"�������������:"+splitConf[10]+"����:"+splitConf[11]+"���:"+splitConf[12]+"����:"+splitConf[13]+"��");
		  if(splitConf.length==14){
			  Scale scale = new Scale(splitConf[0], splitConf[1], splitConf[2], splitConf[3], splitConf[4], splitConf[5], splitConf[6],
					  splitConf[7], splitConf[8], splitConf[9], splitConf[10], splitConf[11], splitConf[12], splitConf[13]);
			  scaList.add(scale);
			  scaJSON = GsonUtil.toJson(scaList);
		  }else{
			  return i;
		  }
		  sac.setConf(scaJSON); //�γ�JSON֮���scale����
		  sac.setRemark(remark.trim());
		  sac.setCrTime(new Date());
		  sac.setCreator(username);
		  sac.setLastModif(new Date());
		  sac.setModifier(username);
		  sac.setStatus(status);
		  i = tdminAndyzService.insertScaleConf(sac);
	 }else{
		 log.error("�����Ա�ȵ�¼�ٽ��в���...");
	 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("�����������ʧ�ܣ�������...");
	}
	  return i;
  }
  
  /***
   * �г�������������
   * @auto quite
   * @returna
   * ����1:43:50
   * List<TScaleConf>
   */
  @ResponseBody
  @RequestMapping(value="/scaleConfList",method={RequestMethod.GET,RequestMethod.POST})
  public List<TScaleConf> scaleConfList(){
	  List<TScaleConf> scaleConfList = null;
	try {
		scaleConfList = tdminAndyzService.scaleConfList();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.info("�г��������������쳣��������...");
	}
	  return scaleConfList;
  }
  
  /***
   * �����ﷸҪʹ�õ���������
   * @auto quite
   * @param confId
   * @param session
   * @returna
   * ����10:44:25
   * int
   */
  @ResponseBody
  @RequestMapping(value="/save_crruent_toConf",method={RequestMethod.GET,RequestMethod.POST})
  public int save_crruent_toConf(String confId,String globalId,HttpSession session){
	  String username = (String)session.getAttribute("username");
	  log.info("�ﷸ�������ñ��"+confId+"������ȫ�����ñ��"+globalId+"�������û���"+username+"��");
	  int i = 0 ;
	  try {
		if(username!=null&&username!=""){
			  SystemConfig saveConf = new SystemConfig().setConf("CURR_DEF_SCALE", confId);
			  saveConf.setConf("SCALE_GLOBAL_EFFECD",globalId);
			  log.info("���桾��������"+saveConf.getConf("CURR_DEF_SCALE")+"������ȫ������"+saveConf.getConf("SCALE_GLOBAL_EFFECD")+"��");
			  if(saveConf!=null){
				  return  i=1;
			  }
		  }else{
			  log.error("�����ﷸʹ������ʧ�ܣ�����Ա���ȵ�¼");
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("�����ﷸʹ��ȫ�������쳣��������..."+e.getMessage());
	}
	  return i;
  }
  
  //********************************����-�������ù�ϵ����***************************************************
   /**
    * �����ﷸ��������ȫ�ֹ�ϵ
    * @auto quite
    * @param session
    * @returna
    * ����9:19:06
    * int
    */
   @ResponseBody
   @RequestMapping(value="/addCrimScaleProduce",method={RequestMethod.GET,RequestMethod.POST})
   public int addCrimScaleProduce(HttpSession session){
	   String username = (String)session.getAttribute("username");
	   int i = 0;
	   try {
		if(username!=null&&username!=""){
			//���������������ò���
			i = tdminAndyzService.useProduceForScaleConf(username, new Date(), new Date(), username, 2);
			if(i==1){
				int a = zuotiService.autoGuize(); //��������֮��ֱ�ӽ��е�������
				if(a==1){
					return i=1;
				}else{
					return i=0;
				}
			}
		}else{
			log.error("�������������ϵʧ�ܣ������Ա�ȵ�¼...");
			return i = 0;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("�������������ϵ�쳣�����Ժ�����...");
	}
	   
	   return i;
   }
  
  /***
   * �����������-�������ù�ϵ����ģ��
   * @auto quite
   * @param crimNo
   * @param sconfId
   * @param session
   * @returna
   * ����5:11:51
   * int
   */
  @ResponseBody
  @RequestMapping(value="/addTCrimScaleRelat",method={RequestMethod.GET,RequestMethod.POST})
  public int addTCrimScaleRelat(String crimNo,int sconfId,HttpSession session){
	  int i = 0;
	  TCrimScaleRelat csr = null;
	  try {
	  String username = (String)session.getAttribute("username");//��ȡsession������û���
	  log.info("�����������á��û���"+username+"����������"+crimNo+"���������ñ��"+sconfId+"��");
	  csr = new TCrimScaleRelat();
	  csr.setCrimNo(crimNo); //����
	  csr.setSconfId(sconfId); //���ñ��  --ѡ��
	  csr.setCrTime(new Date()); //����ʱ�� 
	  csr.setCreator(username); //������
	  csr.setLastModif(new Date()); //�޸�ʱ�� �״�Ϊ��¼admin
	  csr.setModifier(username); //����޸��� �״�Ϊ��¼admin
	  csr.setStatus(2);
	 
	  i = tdminAndyzService.insertTCrimScaleRelat(csr);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("�������-�������ù�ϵʧ�ܣ�������...");
	}
	  return i;
  }
}
