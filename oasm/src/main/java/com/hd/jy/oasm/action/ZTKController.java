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
 * 做题库Controller
 *出现做完题目之后的所有已选择的因子和分数，包括出监访谈，出监观察
 */
@Controller
@RequestMapping("ztk")
public class ZTKController {
    private Logger log = Logger.getLogger(ZTKController.class);
    
	@Autowired
	private ZuoTiSerivce zuotiSerivce; //做题库的操作接口
	
	@Autowired
	private TaskService taskService; //修改任务状态逻辑接口
	
	@Autowired
	private SjjgftAndxwgcService sjjgftAndxwgcService; //最新档案分析逻辑接口，页面显示档案分析，以及因子和分数使用
	
	//当前类获取警号公用方法
	 public static String getJhinfo(){
		  Subject currentUser = SecurityUtils.getSubject();
		  String jh = (String) currentUser.getPrincipal(); // 得到警号
		  return jh;
	  }
	
//++++++++++++++++++++++++++++++++++开始++++++++++++++++++++++++++++++++++++++++++++
//*****************************入监做题情况完成部分*********************************************
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//*****************************日常做题情况完成部分*********************************************
//*****************************中期做题情况完成部分*********************************************
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

 
    /***
     * 通过出监行为观察任务编号获取试题库
     * @auto quite
     * @param taskId
     * @returna
     * 下午3:18:15
     * String
     */
    @ResponseBody
    @RequestMapping(value="/cjxwgc_start_question",method={RequestMethod.GET,RequestMethod.POST})
    public String cjxwgc_start_question(String taskId){
    	log.info("出监行为观察任务编号==》"+taskId);
    	String cjxwgcQuestion = null;
		try {
			cjxwgcQuestion = zuotiSerivce.cjxwgcQuestion(taskId.trim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("通过出监行为观察任务编号进行操作试题库失败，请重试...");
		}
    	return cjxwgcQuestion;
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //*************************答题部分*************************
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /**
     * 添加答题记录的答案,可以共用，包括结构访谈，行为观察
     * @auto quite
     * @param taskId
     * @param answer
     * @param score
     * @param level
     * @param result
     * @returna
     * 上午9:30:39
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
			if(null!=jh&&jh.equals(raletjh.trim())){ //先判断jh是否登录，是否是登记人的警号
				Answer an = null;
				String jsonAnw = null;
				BGgtft gtft = null;
				BGxwgc xwgc = null;
				String cTaskId = taskId.trim();
				String qh = taskId.substring(0, 10); //囚号
				String[] spAnws = answer.trim().split("@@"); //根据双@切割答案
				
				List<Answer> anwList = new ArrayList<Answer>();
					for (int j = 0; j < spAnws.length; j++) {
						String[] spAnw = spAnws[j].split("#"); //根据#切割答题因子
						if(spAnw.length==5){
						log.info("入库的json数据:因子编号【"+spAnw[0]+"】，因子名【"+spAnw[1]+"】，维度号【"+spAnw[2]+"】,维度名【"+spAnw[3]+"】，因子分【"+spAnw[4]+"】，因子总分【"+score+"】");
						an = new Answer();
						gtft = new BGgtft();
						xwgc = new BGxwgc();
						if(cTaskId.contains("Act_")){
							//行为观察
							xwgc.setRwid(cTaskId);//任务编号
							xwgc.setQh(qh); //囚号
							xwgc.setWd(spAnw[3]); //维度名称
							xwgc.setYz(spAnw[1]); //因子名称
							xwgc.setFs(Integer.parseInt(spAnw[4]));  //单个因子分
							i = zuotiSerivce.saveXwgcs(xwgc);
						}else if(cTaskId.contains("Tk_")){
							//结构访谈
							gtft.setRwid(cTaskId);
							gtft.setQh(qh);
							gtft.setWd(spAnw[3]);
							gtft.setYz(spAnw[1]);
							gtft.setFs(Integer.parseInt(spAnw[4]));
							i = zuotiSerivce.saveGtfts(gtft);
						}else{
							log.error("没有对应的任务类型，请请确认后重试...");
						}
						
						
						//执行保存因子到另外的表中
						
						an.setfId(spAnw[0].trim());
						an.setfName(spAnw[1].trim());
						an.setDimId(spAnw[2].trim());
						an.setDimName(spAnw[3].trim());
						an.setScore(spAnw[4].trim());
						an.setScores(String.valueOf(score));
						anwList.add(an);
						}else{
							log.error("有问题的答案数据，正确数据长度<"+spAnws.length);
							return i=0;
						}
					}
				jsonAnw = GsonUtil.toJson(anwList); //转为json数据入库
				log.info("格式化之后的入库数据"+jsonAnw);
				note = new TestNote();
				note.setTaskId(taskId.trim()); //任务编号
				note.setAnswer(jsonAnw.trim()); //答案
				note.setScore(score); //成绩
				i = zuotiSerivce.saveNote(note);
				
				if(i==1){ //当答题记录入库之后马上执行修改任务状态
					Map<String, String> map = new HashMap<>(); //使用map传值
					map.put(CT.P_TASK_ID, taskId); //任务编号
					map.put(CT.SER_USR_NAME, jh); //修改警号
					map.put(CT.P_STATUS, "4"); //修改的状态为
					String msg = taskService.updateStatus(map);
					 if(msg!=null&&msg!=""){
					 return i=1;
					 }else{
					 return i=0;
					 }
				}else{
					log.error("请先确定先录入答题记录..."); //-----这里控制一定不能出错
				}
			}else{
				log.error("请先确认录入的警号与登录的警号一致...");
				return i=0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加答案异常，请重试...");
		}
    	return i;
    }
    
    /***
     * 通过任务编号获取答题记录
     * @auto quite
     * @param taskId
     * @returna
     * 下午2:27:41
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
			log.error("查询做题记录失败，请稍后重试...");
		}
    	return note;
    }
    
    /***
     * 通过事件编号获取档案分析匹配记录
     * @auto quite
     * @param jcdaId
     * @returna
     * 下午4:00:00
     * Sjdafx
     */
    @ResponseBody
    @RequestMapping(value="/getDafxRecord",method={RequestMethod.GET,RequestMethod.POST})
    public TestNote getDafxRecord(String jcdaId){
    	log.info("档案事件编号==>"+jcdaId);
    	TestNote note = null;
    	try {
			note = sjjgftAndxwgcService.searchDafxjg(jcdaId.trim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("获取档案视图数据答题记录失败，请稍后重试...");
		}
    	return note;
    }
}
