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
 * 维度和因子控制层。页面的添加因子，添加维度，修改因子，修改维度等操作控制
 * @author quite
 *
 */
@Controller
@RequestMapping("tdminAndtyz")
public class TdminAndtyzController {
	private Logger log = Logger.getLogger(TdminAndtyzController.class);
	
	@Autowired
	private TdminAndtyzService tdminAndyzService; //维度和因子逻辑接口
	
	@Autowired
	private ZuoTiSerivce zuotiService; //调用做题逻辑接口，在启动囚犯配置的时候进行档案分析
  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  //********************************维度操作部分******************************************************
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/***
	 * 验证维度
	 * @auto quite
	 * @param dimName
	 * @returna
	 * 下午2:30:01
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/checkDminName",method={RequestMethod.GET,RequestMethod.POST})
	public int checkDminName(String dimName){//验证维度名
		log.info("验证【维度名"+dimName+"】");
		int i = 0;
		try {
			if(dimName!=null&&dimName!=""){
				i = tdminAndyzService.selectBytdminName(dimName.trim());
			}else{
				return (i=1); //如果为null则返回1表示已存在不可重复插入
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("验证维度名异常，请稍后重试...");
		}
		return i;
	}
	
	/***
	 * //添加维度
	 * @auto quite
	 * @param dimName
	 * @param session
	 * @returna
	 * 下午2:17:48
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/insertTdmin",method={RequestMethod.GET,RequestMethod.POST})
	public int insertTdmin(String dimName,String remark,HttpSession session){ //页面传入维度名称和用户名
		int i = 0;
		String username = (String)session.getAttribute("username"); //获取登录的用户名
		log.info("添加【维度名"+dimName+"】，【用户名"+username+"】");
		Tdmin dmin = null ;
	   try {
		    if(username!=null&&username!=""){
		    	dmin =  new Tdmin();
				dmin.setDimName(dimName.trim());  //维度名称
				dmin.setRemark(remark.trim());
				dmin.setCreator(username); //使用管理员作为创建者
				dmin.setCrTime(new Date()); //创建时间
				dmin.setLastModif(new Date()); //最后修改时间，首次为维度创建时间
				dmin.setModifier(username); //使用管理员作为首次修改时间
				dmin.setStatus(2); //1表示未启用 ， 2表示启用
			    i = tdminAndyzService.insertTdmin(dmin);
		    }else{
		    	log.error("添加维度失败，请管理员登录后重试...");
		    }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("添加维度异常，请重试...");
	}
		return i;
	}
	
	/**
	 *  修改维度名称
	 * @auto quite
	 * @param dimName
	 * @param dimId
	 * @param session
	 * @returna
	 * 下午12:14:24
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/updateDimName",method={RequestMethod.GET,RequestMethod.POST})
	public int updateDimName(String dimName,int dimId,HttpSession session){
		int i = 0;
		Tdmin tm = null;
		try {
			String username = (String)session.getAttribute("username");
			log.info("修改【维度名"+dimName+"】，【维度编号"+dimId+"】，【用户名"+username+"】");
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
			log.error("修改维度名失败，请稍后重试...");
		}
		return i;
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 //********************************因子操作部分******************************************************
	 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/***
	 * 验证因子和维度关系
	 * @auto quite
	 * @param name
	 * @returna
	 * 下午3:01:20
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/checkFactorName",method={RequestMethod.GET,RequestMethod.POST})
	public int checkFactorName(String name,int dimId){//验证因子名
		int i = 0;
		try {
			if(name!=null&&name!=""){
				i = tdminAndyzService.checkBytfactorName(name.trim(),dimId);
			}else{
				return i=1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("验证因子名称失败，请稍后重试...");
		}
		return i;
	}
	
	/**
	 * 
	 * @todo TODO
	 * @param name
	 * @return
	 * @auth quite
	 * @time 2018年1月9日 下午12:03:07
	 *
	 */
	@ResponseBody
	@RequestMapping(value="checkHaveFname",method={RequestMethod.GET,RequestMethod.POST})
	public int checkHaveFname(String name){
		int i = 0;
		log.info("验证的【因子名称"+name+"】");
		try {
			i = tdminAndyzService.chckHaveFname(name.trim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("存入验证的因子名称失败，请稍后重试...");
		}
		return i;
	}
	
	/***
	 * 修改因子名称
	 * @auto quite
	 * @param fName
	 * @param fId
	 * @param session
	 * @returna
	 * 下午2:19:55
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/updateFaName",method={RequestMethod.GET,RequestMethod.POST})
	public int updateFaName(String fName,int fId,HttpSession session){
		int i = 0;
		Tfactor tf = null;
		try {
			String username = (String)session.getAttribute("username");
			log.info("修改因子【用户名"+username+"】，【因子名称"+fName+"】，【因子编号"+fId+"】");
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
			log.error("修改因子名称失败，请稍后重试...");
		}
		return i;
	}

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 //********************************因子和维度关系操作部分******************************************************
	 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /***
     * 列出所有维度
     * @auto quite
     * @returna
     * 下午5:06:39
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
			log.error("列出所有维度失败，请稍后重试...");
		}
    	return listTdmin;
    }
	
	/***
	 * 根据维度编号列出所有因子供选择，最后提供多选框的形式
	 * @auto quite
	 * @param dimId
	 * @returna
	 * 下午5:11:45
	 * List<Tfactor>
	 */
	@ResponseBody
	@RequestMapping(value="/listFactor",method={RequestMethod.GET,RequestMethod.POST})
	public List<Tfactor> listFactor(int dimId){//维度编号
		log.info("dimID==>"+dimId);
		List<Tfactor> listFactorBydminId = null;
		try {
			listFactorBydminId = tdminAndyzService.listFactorBydminId(dimId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据维度列出因子失败，请重试...");
		}
		return listFactorBydminId;
		
	}
	
	/***
	 * 添加因子和维度的关系
	 * @auto quite
	 * @param dimId 维度编号
	 * @param fId 因子编号
	 * @param session 获取session中username的数据
	 * @returna
	 * 下午5:23:44
	 * int
	 */
	@ResponseBody
	@RequestMapping(value="/addWdYzRelat",method={RequestMethod.GET,RequestMethod.POST})
	public  int addWdYzRelat(int dimId,int fScore,String name,String remark,HttpSession session){ //fid为查询之后的id
		int i = 0;
		TdminfactorRelat relat = null; //创建因子维度关系对象
		Tfactor tf = null;//创建因子对象
		String username = (String)session.getAttribute("username");
		log.info("【用户名"+username+"】，维度编号【"+dimId+"】，因子名称【"+name+"】，描述【"+remark+"】");
		try {
			if(username!=null&&username!=""){ //先判断管理员账号不能为null
				try {
					//因子部分
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
					if (e.getMessage().contains("重复") || e.getMessage().toLowerCase().contains("duplic")) {
						//
					} else {
						throw e;
					}
				}
				    int fId = tdminAndyzService.selectByfactorName(name.trim()); //得到因子编号
				    log.info("添加因子和维度关系需要的【因子编号"+fId+"】");
					relat = new TdminfactorRelat();
					relat.setDimId(dimId);
					relat.setfId(fId);
					relat.setCrTime(new Date());
					relat.setCreator(username.trim());
					relat.setLastModif(new Date());
					relat.setModifier(username.trim());
					relat.setStatus(2);
					i = tdminAndyzService.insertwdAndyzRelat(relat); //最终添加到因子和维度关系表中
			}else{
				log.error("请先登录管理员账号...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
				log.error("添加因子和维度失败，请确认问题后重试...");
		}
		return i;
	}
	
	@ResponseBody
	@RequestMapping(value="checkDIdFId",method={RequestMethod.GET,RequestMethod.POST})
	public int checkDIdFId(int dimId,int fId){
		log.info("验证因子和维度关系的【维度编号"+dimId+"】，【因子编号"+fId+"】");
		int i = 0;
		try {
			i = tdminAndyzService.checkDimIdFId(dimId, fId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("验证因子和维度关系失败，请稍后重试");
		}
		return i;
	}
	
	/***
	 * 修改维度和因子关系
	 * @auto quite
	 * @param session
	 * @returna
	 * 下午2:50:15
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
				map.put("da", da); //修改维度编号为
				map.put("fa", fa); //修改因子编号为
				map.put("lastModif", new Date());
				map.put("modifier", username);
				map.put("db", db); //需要修改的维度编号
				map.put("fb", fb); //需要修改的因子编号
				i = tdminAndyzService.updateWdAndYzRelat(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改维度和因子关系失败，请稍后重试...");
		}
		return i;
	}
	
	
  //***************************问题选项部分*********************************************************
	@ResponseBody
	@RequestMapping(value="/addQuestion",method={RequestMethod.GET,RequestMethod.POST})
	@Log(operationType="添加问题",operationName="添加问题")
	public int addQuesttion(int dimId,String orgId,String question,int type,String remark,String options
		,HttpSession session){
		int i = 0;
		TQuestion tq = null;
	   try {
		String username = (String)session.getAttribute("username");
		log.info("【维度编号"+dimId+"】，【监狱编号"+orgId+"】，【选项类型"+type+"】");
		log.info("添加问题的【用户名"+username+"】，【问题"+question+"】，【描述"+remark+"】，【选项"+options+"】");
		if(username!=null&&username!=""){
			String optionsName = options.replaceAll("%%,", "%%").trim(); //把%%,替换成%%存储
			log.info("替换选项【选项内容"+optionsName+"】");
			tq = new TQuestion();
			tq.setDimId(dimId); //维度编号
			tq.setOrgId(orgId);//组织编号  匹配各个监狱的组织代码
			tq.setQuestion(question.trim());//问题
			tq.setType(type);//类型 1为单选 ，2为多选
			tq.setRemark(remark.trim());//描述 因子的判断依据
			tq.setOptions(optionsName);//选项  使用 选项编号#选项内容#因子编号#因子名称直接存储
//			tq.setAnswer(answer);//暂时不是这里存储答案
			tq.setCrTime(new Date());//创建时间
			tq.setCreator(username);//创建人
			tq.setLastModif(new Date());//最后修改时间
			tq.setModifier(username);//最后修改人
			tq.setStatus(2);//状态，默认添加2启用状态
			i = tdminAndyzService.insertQuestion(tq);
		}else{
		  log.error("添加问题失败，请确定登录状态后重试...");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加问题失败，请重试...");
		}
		return i;
	}
	
	/***
	 * 根据监狱号动态获取问题列表
	 * @auto quite
	 * @param orgId
	 * @returna
	 * 上午11:59:59
	 * String 返回String类型的JSON数据
	 */
	@ResponseBody
	@RequestMapping(value="/orgAllQuestion",method={RequestMethod.GET,RequestMethod.POST})
	public String orgAllQuestion(String orgId){
		log.info("匹配本监狱问题【监狱编号"+orgId+"】");
		String question = null;
		try {
			question = tdminAndyzService.allQuestion(orgId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("根据监狱编号动态列出问题列表异常，请重试...");
		}
		return question;
		
	}
	
	/**
	 * 删除问题选项
	 * @author quite
	 * @param qId
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="removeQuestion",method={RequestMethod.GET,RequestMethod.POST})
	@Log(operationType="删除问题",operationName="删除问题")
	public int removeQuestion(int qId,HttpSession session){
		int i = 0;
		String username = (String)session.getAttribute("username");
		log.info("删除问题的【编号"+qId+"】，【用户名"+username+"】");
		try {
			if(null!=username&&username.length()>0){
				i = tdminAndyzService.removeQuestion(qId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("删除问题失败，请确认问题后再重试...");
		}
		return i;
	}
	
 //*********************************量表操作部分********************************************************
	/***
	 * 根据量表名字匹配量表是否存在
	 * @auto quite
	 * @param name
	 * @returna
	 * 上午10:38:32
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
			log.error("根据量表名字匹配量表是否存在失败，请重试...");
		}
		return i;
	}
	/***
	 * 量表添加模块
	 * @auto quite
	 * @param name 量表名称
	 * @param type 量表类型
	 * @param remark 描述，说明
	 * @param researher 研制者
	 * @param scale 量表内容
	 * @param session 获取session对象
	 * @returna
	 * 下午4:51:52
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
		log.info("量表添加【用户名"+username+"】，【量表类型"+type+"】，【描述"+remark+"】，【研制者"+researher+" 】，【量表内容"+scale+"】");
		if(username!=null&&username!=""){
			sc = new Tscale();
			sc.setName(name.trim());  //量表名称
			sc.setType(type);  //类型 如B:结构访谈,C:行为观察
			sc.setRemark(remark.trim()); //量表说明
			sc.setResearher(researher.trim()); //研制者
			
			List<Question> queList = new ArrayList<Question>();
			String scaleJson = "";
			
			String[] splitScale = scale.trim().split("QQQ");
			for (int j = 0; j < splitScale.length; j++) {
//				3#从入狱到现在，你提过哪些诉求，解决情况如何？#诉求@@1# 提出无理诉求，经解释后，态度能接受的#提出无理诉求，经解释后，态度能接受的#1%%2# 提出合理诉求，但长时间没有解决的#提出合理诉求，但长时间没有解决的#1%%3# 提出无理诉求，经解释后，但仍旧纠缠的#提出无理诉求，经解释后，但仍旧纠缠的#1%%
				String[] splitQuestion = splitScale[j].split("@@");
				   log.info("量表内容分割为【"+splitQuestion.length+"】部分");
				   String strQues = ""; 
				   String strOpts = "";
				   if(splitQuestion.length==2){
					   strQues = splitQuestion[0]; //第一部分为问题
					   strOpts = splitQuestion[1]; //第二部分为选项
						log.info("【问题内容:"+strQues+"】");
						log.info("【选项内容:"+strOpts+"】");
				    }else{
				    	log.error("量表内容分割异常，内容【2】<【"+splitQuestion.length+"】部分");
				    	return i;
				    }
					//先切割问题部分
					String[] splitQue = strQues.split("#");
					   log.info("问题入库的数据：问题编号【"+splitQue[0]+"】，问题内容【"+splitQue[1]+"】，判断依据【"+splitQue[2]+"】维度编号【"+splitQue[3]+"】维度内容【"+splitQue[4]+"】");
						que = new Question();
						que.setqId(Integer.parseInt(splitQue[0])); //问题编号
						que.setqName(splitQue[1]); //问题名称
						que.setqRemark(splitQue[2]); //判断依据
						que.setDimId(Integer.parseInt(splitQue[3])); //维度编号
						que.setDimName(splitQue[4]); //维度名称
						que.setType(splitQue[5]); //问题类型
					
					String[] splitOpt = strOpts.split("%%");
					List<Option> optList = new ArrayList<>();
					for (int k = 0; k < splitOpt.length; k++) {
						String[] soc = splitOpt[k].split("#"); //循环k的值
						log.info("量表问题选项分割为【"+soc.length+"】部分");
						if(soc.length==5){
							log.info("选项入库的数据：选项号【 "+soc[0]+"】，选项内容【 "+soc[1]+" 】，因子编号【 "+soc[4]+"】，因子内容【 "+soc[2]+" 】，权重【 "+soc[3]+"】");
							Option opn = new Question.Option(soc[0], soc[1], soc[4], soc[2], "1", soc[3]);
							optList.add(opn);
						}else{
							log.error("选项分割异常，选项分割【5】<【"+soc.length+"】部分");
							return i;
						}
					}
					que.setOptions(optList);
					
					queList.add(que);
				
					scaleJson = GsonUtil.toJson(queList); //量表、问题、选项合并完成
			}
			sc.setScale(scaleJson);
			sc.setCreator(username);
			sc.setCrTime(new Date());
			sc.setLastModif(new Date());
			sc.setModifier(username);
			sc.setStatus(2);
			i = tdminAndyzService.insertTscale(sc);
		}else{
			log.error("执行当前操作请管理员先登录...");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加量表失败，请重试...");
		}
		return i;
	}
	
  //*********************************量表配置操作部分******************************************************
   /***
    * 配置名字进行匹配操作
    * @auto quite
    * @param name
    * @returna
    * 下午5:25:56
    * int
    */
	@ResponseBody
   @RequestMapping(value="/checkConfName",method={RequestMethod.GET,RequestMethod.POST})
   public int checkConfName(String name){ //配置的名字
		log.info("验证【配置名"+name+"】");
	   int i = 0;
	   try {
		i = tdminAndyzService.checkConfName(name.trim());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.info("根据配置名字进行匹配异常，请重试...");
	}
	   return i;
   }
	
	/**
	 * 列出所有量表，根据不同类型区分
	 * @auto quite
	 * @returna
	 * 上午10:37:17
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
			log.error("列出量表失败，请稍后重试...");
		}
		return scaleAllList;
	}
	
	/***
   * 量表添加量表配置操作模块
   * @auto quite
   * @param name 配置名称
   * @param conf 配置，应该为JSON字符串
   * @param remark 描述
   * @param session 获取session对象
   * @returna
   * 下午4:58:12
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
	  log.info("添加量表配置的【用户名"+username+"】，【配置名称"+name+" 】【配置"+conf+"】，【描述"+remark+"】");
	 if(username!=null&&username!=""){
		 sac = new TScaleConf();
		  sac.setName(name.trim());
		  String[] splitConf = conf.split("#");
		  List<Scale> scaList = new ArrayList<Scale>();
		  log.info("配置的量表：入监量表【编号:"+splitConf[0]+"名字:"+splitConf[1]+"编号:"+splitConf[2]+"名字:"+splitConf[3]+"】日常量表:【编号:"+splitConf[4]+"名字:"+splitConf[5]+"】中期量表:【编号:"+splitConf[6]+"名字:"+
				  splitConf[7]+"编号:"+splitConf[8]+"名字:"+splitConf[9]+"】出监量表【编号:"+splitConf[10]+"名字:"+splitConf[11]+"编号:"+splitConf[12]+"名字:"+splitConf[13]+"】");
		  if(splitConf.length==14){
			  Scale scale = new Scale(splitConf[0], splitConf[1], splitConf[2], splitConf[3], splitConf[4], splitConf[5], splitConf[6],
					  splitConf[7], splitConf[8], splitConf[9], splitConf[10], splitConf[11], splitConf[12], splitConf[13]);
			  scaList.add(scale);
			  scaJSON = GsonUtil.toJson(scaList);
		  }else{
			  return i;
		  }
		  sac.setConf(scaJSON); //形成JSON之后的scale内容
		  sac.setRemark(remark.trim());
		  sac.setCrTime(new Date());
		  sac.setCreator(username);
		  sac.setLastModif(new Date());
		  sac.setModifier(username);
		  sac.setStatus(status);
		  i = tdminAndyzService.insertScaleConf(sac);
	 }else{
		 log.error("请管理员先登录再进行操作...");
	 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("添加量表配置失败，请重试...");
	}
	  return i;
  }
  
  /***
   * 列出所有量表配置
   * @auto quite
   * @returna
   * 下午1:43:50
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
		log.info("列出所有量表配置异常，请重试...");
	}
	  return scaleConfList;
  }
  
  /***
   * 保存罪犯要使用的量表配置
   * @auto quite
   * @param confId
   * @param session
   * @returna
   * 上午10:44:25
   * int
   */
  @ResponseBody
  @RequestMapping(value="/save_crruent_toConf",method={RequestMethod.GET,RequestMethod.POST})
  public int save_crruent_toConf(String confId,String globalId,HttpSession session){
	  String username = (String)session.getAttribute("username");
	  log.info("罪犯量表【配置编号"+confId+"】，【全局配置编号"+globalId+"】，【用户名"+username+"】");
	  int i = 0 ;
	  try {
		if(username!=null&&username!=""){
			  SystemConfig saveConf = new SystemConfig().setConf("CURR_DEF_SCALE", confId);
			  saveConf.setConf("SCALE_GLOBAL_EFFECD",globalId);
			  log.info("保存【量表配置"+saveConf.getConf("CURR_DEF_SCALE")+"】，【全局配置"+saveConf.getConf("SCALE_GLOBAL_EFFECD")+"】");
			  if(saveConf!=null){
				  return  i=1;
			  }
		  }else{
			  log.error("保存罪犯使用配置失败，管理员请先登录");
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("保存罪犯使用全局配置异常，请重试..."+e.getMessage());
	}
	  return i;
  }
  
  //********************************囚犯-量表配置关系操作***************************************************
   /**
    * 启动罪犯量表配置全局关系
    * @auto quite
    * @param session
    * @returna
    * 上午9:19:06
    * int
    */
   @ResponseBody
   @RequestMapping(value="/addCrimScaleProduce",method={RequestMethod.GET,RequestMethod.POST})
   public int addCrimScaleProduce(HttpSession session){
	   String username = (String)session.getAttribute("username");
	   int i = 0;
	   try {
		if(username!=null&&username!=""){
			//启动囚犯量表配置操作
			i = tdminAndyzService.useProduceForScaleConf(username, new Date(), new Date(), username, 2);
			if(i==1){
				int a = zuotiService.autoGuize(); //导入数据之后直接进行档案分析
				if(a==1){
					return i=1;
				}else{
					return i=0;
				}
			}
		}else{
			log.error("配置囚犯量表关系失败，请管理员先登录...");
			return i = 0;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("配置囚犯量表关系异常，请稍后重试...");
	}
	   
	   return i;
   }
  
  /***
   * 量表添加囚犯-量表配置关系操作模块
   * @auto quite
   * @param crimNo
   * @param sconfId
   * @param session
   * @returna
   * 下午5:11:51
   * int
   */
  @ResponseBody
  @RequestMapping(value="/addTCrimScaleRelat",method={RequestMethod.GET,RequestMethod.POST})
  public int addTCrimScaleRelat(String crimNo,int sconfId,HttpSession session){
	  int i = 0;
	  TCrimScaleRelat csr = null;
	  try {
	  String username = (String)session.getAttribute("username");//获取session里面的用户名
	  log.info("囚犯量表配置【用户名"+username+"】，【囚号"+crimNo+"】，【配置编号"+sconfId+"】");
	  csr = new TCrimScaleRelat();
	  csr.setCrimNo(crimNo); //囚号
	  csr.setSconfId(sconfId); //配置编号  --选择
	  csr.setCrTime(new Date()); //创建时间 
	  csr.setCreator(username); //创建人
	  csr.setLastModif(new Date()); //修改时间 首次为登录admin
	  csr.setModifier(username); //最后修改人 首次为登录admin
	  csr.setStatus(2);
	 
	  i = tdminAndyzService.insertTCrimScaleRelat(csr);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("添加囚号-量表配置关系失败，请重试...");
	}
	  return i;
  }
}
