package com.hd.jy.oasm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hd.jy.oasm.domain.BGgtft;
import com.hd.jy.oasm.domain.BGxwgc;
import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.domain.newDomain.Answer;
import com.hd.jy.oasm.services.SjjgftAndxwgcService;
import com.hd.jy.oasm.services.TaskService;
import com.hd.jy.oasm.services.ZuoTiSerivce;
import com.hd.jy.oasm.util.lsc.GsonUtil;
import com.hd.jy.oasm.util.priv.CT;

/***
 * 
 * @author quite
 * �����Controller
 *����������Ŀ֮���������ѡ������Ӻͷ��������������̸������۲�
 */
@Controller
@RequestMapping("ztk")
public class ZTKController {
    private Logger log = Logger.getLogger(ZTKController.class);
    
	@Autowired
	private ZuoTiSerivce zuotiSerivce; //�����Ĳ����ӿ�
	
	@Autowired
	private TaskService taskService; //�޸�����״̬�߼��ӿ�
	
	@Autowired
	private SjjgftAndxwgcService sjjgftAndxwgcService; //���µ��������߼��ӿڣ�ҳ����ʾ�����������Լ����Ӻͷ���ʹ��
	
	//��ǰ���ȡ���Ź��÷���
	 public static String getJhinfo(){
		  Subject currentUser = SecurityUtils.getSubject();
		  String jh = (String) currentUser.getPrincipal(); // �õ�����
		  return jh;
	  }
	
//++++++++++++++++++++++++++++++++++��ʼ++++++++++++++++++++++++++++++++++++++++++++
//*****************************������������ɲ���*********************************************
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//*****************************�ճ����������ɲ���*********************************************
//*****************************�������������ɲ���*********************************************
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

 
    /***
     * ͨ��������Ϊ�۲������Ż�ȡ�����
     * @auto quite
     * @param taskId
     * @returna
     * ����3:18:15
     * String
     */
    @ResponseBody
    @RequestMapping(value="/cjxwgc_start_question",method={RequestMethod.GET,RequestMethod.POST})
    public String cjxwgc_start_question(String taskId){
    	log.info("������Ϊ�۲�������==��"+taskId);
    	String cjxwgcQuestion = null;
		try {
			cjxwgcQuestion = zuotiSerivce.cjxwgcQuestion(taskId.trim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ͨ��������Ϊ�۲������Ž��в��������ʧ�ܣ�������...");
		}
    	return cjxwgcQuestion;
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //*************************���ⲿ��*************************
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /**
     * ��Ӵ����¼�Ĵ�,���Թ��ã������ṹ��̸����Ϊ�۲�
     * @auto quite
     * @param taskId
     * @param answer
     * @param score
     * @param level
     * @param result
     * @returna
     * ����9:30:39
     * int
     */
    @ResponseBody
    @RequestMapping(value="/addNoteAnswer",method={RequestMethod.GET,RequestMethod.POST})
    public int addNoteAnswer(String taskId,String answer,double score,String raletjh){
    	log.info("taskId==>"+taskId+"raletjh==>"+raletjh+"score==>"+score);
    	log.info("answer==>"+answer);
    	int i = 0;
    	TestNote note = null;
    	try {
    		String jh = getJhinfo().trim();
			if(null!=jh&&jh.equals(raletjh.trim())){ //���ж�jh�Ƿ��¼���Ƿ��ǵǼ��˵ľ���
				Answer an = null;
				String jsonAnw = null;
				BGgtft gtft = null;
				BGxwgc xwgc = null;
				String cTaskId = taskId.trim();
				String qh = taskId.substring(0, 10); //����
				String[] spAnws = answer.trim().split("@@"); //����˫@�и��
				
				List<Answer> anwList = new ArrayList<Answer>();
					for (int j = 0; j < spAnws.length; j++) {
						String[] spAnw = spAnws[j].split("#"); //����#�и��������
						if(spAnw.length==5){
						log.info("����json����:���ӱ�š�"+spAnw[0]+"������������"+spAnw[1]+"����ά�Ⱥš�"+spAnw[2]+"��,ά������"+spAnw[3]+"�������ӷ֡�"+spAnw[4]+"���������ܷ֡�"+score+"��");
						an = new Answer();
						gtft = new BGgtft();
						xwgc = new BGxwgc();
						if(cTaskId.contains("Act_")){
							//��Ϊ�۲�
							xwgc.setRwid(cTaskId);//������
							xwgc.setQh(qh); //����
							xwgc.setWd(spAnw[3]); //ά������
							xwgc.setYz(spAnw[1]); //��������
							xwgc.setFs(Integer.parseInt(spAnw[4]));  //�������ӷ�
							i = zuotiSerivce.saveXwgcs(xwgc);
						}else if(cTaskId.contains("Tk_")){
							//�ṹ��̸
							gtft.setRwid(cTaskId);
							gtft.setQh(qh);
							gtft.setWd(spAnw[3]);
							gtft.setYz(spAnw[1]);
							gtft.setFs(Integer.parseInt(spAnw[4]));
							i = zuotiSerivce.saveGtfts(gtft);
						}else{
							log.error("û�ж�Ӧ���������ͣ�����ȷ�Ϻ�����...");
						}
						
						
						//ִ�б������ӵ�����ı���
						
						an.setfId(spAnw[0].trim());
						an.setfName(spAnw[1].trim());
						an.setDimId(spAnw[2].trim());
						an.setDimName(spAnw[3].trim());
						an.setScore(spAnw[4].trim());
						an.setScores(String.valueOf(score));
						anwList.add(an);
						}else{
							log.error("������Ĵ����ݣ���ȷ���ݳ���<"+spAnws.length);
							return i=0;
						}
					}
				jsonAnw = GsonUtil.toJson(anwList); //תΪjson�������
				log.info("��ʽ��֮����������"+jsonAnw);
				note = new TestNote();
				note.setTaskId(taskId.trim()); //������
				note.setAnswer(jsonAnw.trim()); //��
				note.setScore(score); //�ɼ�
				i = zuotiSerivce.saveNote(note);
				
				if(i==1){ //�������¼���֮������ִ���޸�����״̬
					Map<String, String> map = new HashMap<>(); //ʹ��map��ֵ
					map.put(CT.P_TASK_ID, taskId); //������
					map.put(CT.SER_USR_NAME, jh); //�޸ľ���
					map.put(CT.P_STATUS, "4"); //�޸ĵ�״̬Ϊ
					String msg = taskService.updateStatus(map);
					 if(msg!=null&&msg!=""){
					 return i=1;
					 }else{
					 return i=0;
					 }
				}else{
					log.error("����ȷ����¼������¼..."); //-----�������һ�����ܳ���
				}
			}else{
				log.error("����ȷ��¼��ľ������¼�ľ���һ��...");
				return i=0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��Ӵ��쳣��������...");
		}
    	return i;
    }
    
    /***
     * ͨ�������Ż�ȡ�����¼
     * @auto quite
     * @param taskId
     * @returna
     * ����2:27:41
     * TestNote
     */
    @ResponseBody
    @RequestMapping(value="/getNoteRecord",method={RequestMethod.GET,RequestMethod.POST})
    public TestNote getNoteRecord(String taskId){
    	log.info("taskId==>"+taskId);
    	TestNote note = null;
		try {
			note = zuotiSerivce.getNote(taskId.trim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯ�����¼ʧ�ܣ����Ժ�����...");
		}
    	return note;
    }
    
    /***
     * ͨ���¼���Ż�ȡ��������ƥ���¼
     * @auto quite
     * @param jcdaId
     * @returna
     * ����4:00:00
     * Sjdafx
     */
    @ResponseBody
    @RequestMapping(value="/getDafxRecord",method={RequestMethod.GET,RequestMethod.POST})
    public TestNote getDafxRecord(String jcdaId){
    	log.info("�����¼����==>"+jcdaId);
    	TestNote note = null;
    	try {
			note = sjjgftAndxwgcService.searchDafxjg(jcdaId.trim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ȡ������ͼ���ݴ����¼ʧ�ܣ����Ժ�����...");
		}
    	return note;
    }
}
