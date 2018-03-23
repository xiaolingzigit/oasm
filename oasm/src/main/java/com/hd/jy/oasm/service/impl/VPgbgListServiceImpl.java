package com.hd.jy.oasm.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.ListLineMapper;
import com.hd.jy.oasm.dao.SjjgftAndxwgcDao;
import com.hd.jy.oasm.dao.TaskMapper;
import com.hd.jy.oasm.dao.TestMapper;
import com.hd.jy.oasm.dao.VPgbgListMapper;
//import com.hd.jy.oasm.dao.ZCYCYQPCMapper;
import com.hd.jy.oasm.dao.newDao.ViewpgglMapper;
import com.hd.jy.oasm.domain.BGgtft;
import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.domain.BGjcxxpg;
import com.hd.jy.oasm.domain.BGwxlx;
import com.hd.jy.oasm.domain.BGxwgc;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.domain.PgXlcsJg;
import com.hd.jy.oasm.domain.SearchElement;
import com.hd.jy.oasm.domain.Task;
import com.hd.jy.oasm.domain.TaskRelat;
import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.domain.TevalReport;
import com.hd.jy.oasm.domain.VPgbgList;
import com.hd.jy.oasm.domain.ViewDafxjg;
import com.hd.jy.oasm.domain.Viewrwxq;
//import com.hd.jy.oasm.domain.ZCYCYQPC;
import com.hd.jy.oasm.domain.newDomain.CrimInfoView;
import com.hd.jy.oasm.domain.newDomain.Pgbg;
import com.hd.jy.oasm.domain.newDomain.Viewpggl;
import com.hd.jy.oasm.services.VPgbgListService;
import com.hd.jy.oasm.util.date.DateUtil;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.GsonUtil;
import com.hd.jy.oasm.util.priv.CT;
import com.hd.jy.oasm.util.priv.PGPart;
/**
 * 
* @ClassName: VPgbgListServiceImpl 
* @Description: 显示评估报告列表
* @author liangjiaying
* @date 2018年3月23日 下午6:52:29 
*
 */
@Service("vPgbgListServiceImpl")
@DataSource("userDataSource")
public class VPgbgListServiceImpl implements VPgbgListService{

	private static Logger log = Logger.getLogger(VPgbgListServiceImpl.class);
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private String logDate = DateUtil.getTime(new Date());
	
	@Autowired
	private VPgbgListMapper vPgbgListMapper; //评估列表业务接口
	
	@Autowired
	private TestMapper testNoteDao; //评估报告答题情况业务接口
	
	@Autowired
	private ListLineMapper listLineDao; //评估报告心理部分答题情况业务接口--显示心理测试
	
	@Autowired
	private TaskMapper taskRelatDao; //总任务与子任务业务接口
	
//	@Autowired
//	private ZCYCYQPCMapper ycyqDao; //异常狱情业务接口--显示异常狱情
	
	@Autowired
	private ViewpgglMapper pgglDao; //评估管理业务接口 --显示结构访谈和行为观察
	
	@Autowired
	private SjjgftAndxwgcDao sjxwgcDao; //结构访谈和行为观察业务接口--显示档案分析
	
	/**
	 * <p>Title: getViewPgbg</p>   
	 * <p>Description: 查询评估报告列表</p>   
	 * @param type
	 * @return   
	 * @see com.hd.jy.oasm.services.VPgbgListService#getViewPgbg(java.lang.String)
	 */
	@Override
	public List<VPgbgList> getViewPgbg(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<VPgbgList> viewPgbg = null;
		try {
			log.info("开始获取入监评估报告开始时间"+logDate);
			viewPgbg = vPgbgListMapper.getViewPgbg(map);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("VPgbgListServiceImpl.getViewPgbg();方法出错 "+e);
		}
		return viewPgbg;
	}
	/**
	 * 
	 * @ TODO 通过囚号查询评估报告基本信息
	 * @authc quite
	 * @date 2017年12月20日
	 * @see com.hd.jy.oasm.services.VPgbgListService#crimInfoBycrimNo(java.lang.String)
	 */
	@Override
	public BGjbxx crimInfoBycrimNo(String qh) {
		// TODO Auto-generated method stub
		BGjbxx bGjbxx = null;
		try {
			log.info("开始根据【囚犯囚号"+qh+"】,显示罪犯的基础信息时间"+logDate);
			if(null!=qh&&""!=qh){
				bGjbxx = vPgbgListMapper.crimInfoBycrimNo(qh);
			}else{
				log.error("囚犯的【囚号为"+qh+"】,显示罪犯的基础信息失败，请稍后重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("在评估报告显示囚犯的基础信息异常，请重试..."+e.getMessage(),e);
		}
		return bGjbxx;
	}

	/**
	 * 
	 * <p>Title: getGrdjbh</p>   
	 * <p>Description: 个人危险等级变化</p>   
	 * @return   
	 * @see com.hd.jy.oasm.services.VPgbgListService#getGrdjbh()
	 */
	@Override
	public List<VPgbgList> getGrdjbh(String qh) {
		List<VPgbgList> viewPgbg = null;
		try {
			viewPgbg = vPgbgListMapper.getGrdjbh(qh.trim());
		} catch (Exception e) {
			log.error("VPgbgListServiceImpl.getGrdjbh出错"+e);
		}
		return viewPgbg;
	}

	/**
	 * 
	 * <p>Title: getLsPgbg</p>   
	 * <p>Description: 罪犯历史评估报告</p>   
	 * @return   
	 * @see com.hd.jy.oasm.services.VPgbgListService#getLsPgbg()
	 */
	@Override
	public List<VPgbgList> getLsPgbg(String qh) {
		// TODO Auto-generated method stub
		List<VPgbgList> lists = null;
		try {
			lists = vPgbgListMapper.getLsPgbg(qh.trim());
		} catch (Exception e) {
			log.error("VPgbgListServiceImpl.getLsPgbg出错"+e);
		}
		return lists;
	}
	
	/**
	 * @ TODO 先获取关联总任务的子任务的编号，再通过子任务获取答题情况
	 * @authc quite
	 * @date 2017年12月22日
	 * @see com.hd.jy.oasm.services.VPgbgListService#getPgbgTestNote(java.lang.String)
	 */
	@Override
	public String getPgbgTestNote(int bgstu,String taskId) {
		// TODO Auto-generated method stub
		List<Pgbg> list = new ArrayList<>(); //封装json使用
		Map<String,String> map =new HashMap<String,String>(); //传值使用,在满足了status=4之后，获取各个子任务的值
		
		Pgbg pgbg = null;
		String json = null;
		int pgScores = 0; //各个评估的总分
		String childTaskId = null; //各个评估的子任务编号 
		try {
			log.info("开始根据任务编号"+taskId+"显示评估报告数据时间"+logDate);
			if(null!=taskId&&""!=taskId){
				List<TaskRelat> parent = taskRelatDao.getChildTaskIdByParent(taskId); //获取任务关系对象
				String copaJSON = null;
				String sclJSON = null;
 				List<PgXlcsJg> allPgxlcsjg = null;
 				
				loop:for (TaskRelat tr : parent) { //循环多个关系对象
					pgScores = 0;
					log.info("所有的任务类型【"+tr.getChildType()+"】");
					switch (tr.getChildType()) {
					case CT.PG_DAFX: //档案分析答题结果--重构
						List<BGjcxxpg> allJcxxpg = testNoteDao.getAllJcxxpg(tr.getChildId());
						if(null==allJcxxpg){ //不为空传值
							continue loop;
						}
						for (BGjcxxpg jcpg : allJcxxpg) {
								pgScores+=jcpg.getFs(); //档案分析赋值总分
								childTaskId = jcpg.getRwid(); //档案分析子任务编号
							}
						pgbg = new Pgbg();
						map.put(CT.PG_DAFX, ""+pgScores); // 档案分析的值
						pgbg.setCtaskId(childTaskId);
					    pgbg.setJcxxpg(allJcxxpg);
						pgbg.setTaskType(tr.getChildType());
						pgbg.setTaskfs(""+pgScores); //转为String类型的分数
						
						list.add(pgbg);
						break;
//					case CT.PG_JTFT:  //集体访谈答题结果
//						note = testNoteDao.getNote(tr.getChildId());
//						if(null!=note){
//							pgbg = new Pgbg(note.getTaskId(),tr.getChildType(),note.getAnswer(),note.getResult(),""+note.getScore());
////							map.put(CT.PG_JTFT, ""+note.getScore()); // 集体分析的值
//						}else{
//							pgbg = new Pgbg(null,tr.getChildType(),null,null,null);
//						}
//						list.add(pgbg);
//						break;
			        case CT.PG_GTFT: //个人访谈答题结果--重构
			        	List<BGgtft> allGtft = testNoteDao.getAllGtft(tr.getChildId());
			        	if(allGtft==null){
			        		continue loop;
			        	}
			        	for (BGgtft gtpg : allGtft) {
							pgScores+=gtpg.getFs(); //个体访谈总分数
							childTaskId = gtpg.getRwid(); //个体访谈任务编号
						}
			        	pgbg = new Pgbg();
			        	map.put(CT.PG_GTFT, ""+pgScores); //个人访谈的值
			        	pgbg.setCtaskId(childTaskId);
			        	pgbg.setGtftpg(allGtft); //把个体访谈的list直接存进去
			        	pgbg.setTaskType(tr.getChildType());
			        	pgbg.setTaskfs(""+pgScores);
			        	
						list.add(pgbg);
						break;
					    
					case CT.PG_XWGC:  //行为观察答题结果--重构
						List<BGxwgc> allXwgc = testNoteDao.getAllXwgc(tr.getChildId());
						if(allXwgc==null){
							continue loop;
						}
						for (BGxwgc gcpg : allXwgc) {
							pgScores+=gcpg.getFs(); //行为观察结果分数
							childTaskId=gcpg.getRwid(); //任务编号
						}
						pgbg = new Pgbg();
						map.put(CT.PG_XWGC, ""+pgScores);
						pgbg.setCtaskId(childTaskId);
						pgbg.setXwgcpg(allXwgc);
						pgbg.setTaskType(tr.getChildType());
						pgbg.setTaskfs(""+pgScores);
						
						list.add(pgbg);
						break;
//					case CT.PG_XLSCL90: //心理scl90答题结果--重构
//						allPgxlcsjg = listLineDao.getAllPgxlcsjg(tr.getChildId());
//						if(allPgxlcsjg==null){
//							continue loop;
//						}
//						for (PgXlcsJg xlpg : allPgxlcsjg) {
//							pgScores+=xlpg.getPGFS();
//							childTaskId=xlpg.getRWID();
//						}
//						
//						pgbg = new Pgbg();
//						map.put(CT.PG_XLSCL90, ""+pgScores); //心理copapi的值
//						pgbg.setCtaskId(childTaskId);
//						pgbg.setXlcepg(allPgxlcsjg);
//						pgbg.setTaskType(tr.getChildType());
//						pgbg.setTaskfs(""+pgScores);
//						
//						list.add(pgbg);
//						break;
//					case CT.PG_XLCOPAPI: //心理copapi答题结果
//						allPgxlcsjg = listLineDao.getAllPgxlcsjg(tr.getChildId());
//						if(allPgxlcsjg==null){
//							continue loop;
//						}
//						for (PgXlcsJg xlpg : allPgxlcsjg) {
//							pgScores+=xlpg.getPGFS();
//							childTaskId=xlpg.getRWID();
//							
//						}
//						log.info("copapi的分数【"+pgScores+"】");
//						pgbg = new Pgbg();
//						map.put(CT.PG_XLCOPAPI, ""+pgScores); //心理copapi的值
//						pgbg.setCtaskId(childTaskId);
//						pgbg.setXlcepg(allPgxlcsjg);
//						pgbg.setTaskType(tr.getChildType());
//						pgbg.setTaskfs(""+pgScores);
//						
//						list.add(pgbg);
//						break;
					default:
						break;
					}
					
				}
				json = GsonUtil.toJson(list);
				
				
				//**********************************************************
				int i = reUpdate(bgstu,taskId); //执行修改了总任务状态操作，需要使用设计定时器
				if(i==1){
					double dafs = Double.parseDouble(map.get(CT.PG_DAFX));
//					String jtfs = map.get(CT.PG_JTFT); 
//					String rjfs = map.get(CT.PG_XLRJ);
//					String cjfs = map.get(CT.PG_XLCJ);
					
					double gtfs = Double.parseDouble(map.get(CT.PG_GTFT));
					double xwfs = Double.parseDouble(map.get(CT.PG_XWGC));
					
//					double copafs = DataUtil.isNothing(copaJSON)? 0: GsonUtil.toInstance(copaJSON, CopaResult.class).getPgTotalScore();
//					double sclfs = DataUtil.isNothing(sclJSON)? 0: GsonUtil.toInstance(sclJSON, SCL90Result.class).getPgTotalScore();
					
//					int zfs = (int)(dafs+gtfs+xwfs+copafs+sclfs); //总分数
//					addEval(zfs,taskId); //抽出来一个方法，用于添加危险等级
//					log.info("已执行修改后把【任务编号"+taskId+"】，【分数"+zfs+"】添加到任务报告表中，请注意查收..."); //实际放这
				}else{
					 //测试使用，如果有method请提示程序员修改
					log.info("暂不执行修改"+taskId);
				}
				//**************************************************************
			}else{
				log.error("失败原因，任务编号为"+taskId+",请确认后处理");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("评估报告异常信息"+e.getMessage(),e);
		}
		return json;
	}
	/***
	 * 抽出的方法，为执行插入判定评估报告结果
	 * @auto quite
	 * @param taskId,bgstu 为评估报告的状态
	 * @returna
	 * 上午8:56:30
	 * int
	 */
	public int reUpdate(int bgstu,String taskId) {
		
		int i = 0;
		boolean zt = true;
		boolean stat = true;
		Task task = null;
		try {
			log.info("【总任务状态"+bgstu+"】");
			if(bgstu!=4){ //当评估报告的状态为4的时候，已经不需要修改了，否则，则要判断各个子任务的状态是否都为4,是否要执行修改操作
				List<Viewrwxq> viewrwxq = testNoteDao.getChildrenStatus(taskId);
				for (Viewrwxq vr : viewrwxq) {
						switch (vr.getType()) {
						case CT.PG_DAFX:
							if(vr.getStatus()==4&&null!=vr.getStatus()){
								stat = true;
							}else{
								stat = false;
							}
							break;
//						case CT.PG_JTFT:
//						if(vr.getStatus()==4&&null!=vr.getStatus()){ //注释表示暂不判定
//							stat = true;
//						}else{
//							stat = false;
//						}
//							break;
						case CT.PG_GTFT:
							if(vr.getStatus()==4&&null!=vr.getStatus()){
								stat = true;
							}else{
								stat = false;
							}
							break;
						case CT.PG_XWGC:
							if(vr.getStatus()==4&&null!=vr.getStatus()){
								stat = true;
							}else{
								stat = false;
							}
							break;
						case CT.PG_XLSCL90:
							if(vr.getStatus()==4&&null!=vr.getStatus()){
								stat = true;
							}else{
								stat = false;
							}
							break;
						case CT.PG_XLCOPAPI: 
							if(vr.getStatus()==4&&null!=vr.getStatus()){
								stat = true;
							}else{
								stat = false;
							}
							break;
//						case CT.PG_XLRJ:
//						if(vr.getStatus()==4&&null!=vr.getStatus()){
//							stat = true;
//						}else{
//							stat = false;
//						}  
//							break;
//						case CT.PG_XLCJ: 
//						if(vr.getStatus()==4&&null!=vr.getStatus()){
//							stat = true;
//						}else{
//							stat = false;
//						}
//							break;
						default:
							break;
						}
				}//for循环结束
				boolean stResult = zt&&stat;
				log.info(stResult+" or "+stResult);
				if(stResult){
					task = new Task();
					task.setTaskId(taskId); //条件
					task.setModifier("系统");
					task.setLastModif(sdf.format(new Date()));
					task.setStatus(4);
				    i = taskRelatDao.updateStatus(task);
				    log.info("是否成功添加t_eval_report【数据"+i+"条】");
				}else{
					i = 0;
				}
			}else{
				i=0; //表示已经为4的状态了，不需要再次修改状态
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("执行判定任务结果异常，请重试。。。"+e.getMessage(),e);
		}
		
		return i;
	}
	
	public int addEval(int fs,String taskId){
		int i = 0;
		String wxdj = null; //危险等级
		TevalReport tr = null;
		try {
			String lx = taskId.substring(11, taskId.length()-13); //所属阶段
			String qh = taskId.substring(0, 10); //囚号
			String crtime = sdf.format(new Date());
			switch (lx) {
			case "inRep": //入监阶段
				wxdj = testNoteDao.getWxdj(fs, "rj");
				break;
			case "dyRep": //日常阶段
				wxdj = testNoteDao.getWxdj(fs, "rc");
				break;
			case "mdRep": //中期阶段
				wxdj = testNoteDao.getWxdj(fs, "zq");
				break;
			case "otRep": //出监阶段
				wxdj = testNoteDao.getWxdj(fs, "cj");
			   break;
			default:
				break;
			}
			
			String copapiId=null;
			String report = "";
			List<TaskRelat> taskIdByParent = taskRelatDao.getChildTaskIdByParent(taskId);
			for (TaskRelat tt : taskIdByParent) {
				if(PGPart.XLCOPAPI.equals(tt.getChildType())){
					copapiId = tt.getChildId();
					break;
				}
			}
			TestNote note = testNoteDao.getNote(copapiId);
			if(null!=note){
//				report = CopaTestHandler.makeWxxpgFs(taskId, GsonUtil.toInstance(note.getResult(), CopaResult.class));
			}
			
			tr = new TevalReport();
			tr.setTaskId(taskId);
			tr.setCrimNo(qh);
			tr.setCrTime(new Date());
			tr.setScore((double)fs);
			tr.setLevl(wxdj);
			tr.setReport(report);
			log.info("【任务编号:"+taskId+"】，【囚号:"+qh+"】，【时间:"+crtime+"】，【分数:"+fs+"】，【危险等级:"+wxdj+"】"+"【危险性评估分析:"+report+"】");
			i = testNoteDao.addEvalReport(tr); //添加评估报告
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加任务的危险等级异常，请重试..."+e.getMessage(),e);
		}
		return i;
	}
	/**
	 * @ TODO
	 * @authc quite
	 * @date 2017年12月26日
	 * @see com.hd.jy.oasm.services.VPgbgListService#evalReportCount(java.lang.String)
	 */
	@Override
	public TevalReport evalReportCount(String taskId) {
		// TODO Auto-generated method stub
		TevalReport count = null;
		try {
			if(null!=taskId&&""!=taskId){
				log.info("开始执行显示罪犯的等级显示时间"+logDate);
				count = testNoteDao.evalReportCount(taskId);
				if(null!=count){
					log.info("返回前端的数据为"+JSON.toJSON(count));
				}else{
					log.error("该任务编号没有数据，请确认后重试...");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("异常，该评估报告任务没有数据");
		}
		return count;
	}
	/**
	 * @ TODO 显示危险类型倾向
	 * @authc quite
	 * @date 2018年1月4日
	 * @see com.hd.jy.oasm.services.VPgbgListService#getWxlxReport(java.lang.String)
	 */
	@Override
	public List<BGwxlx> getWxlxReport(String rwId) {
		// TODO Auto-generated method stub
		List<BGwxlx> wxreport = null;
		try {
			log.info("开始显示危险类型倾向时间"+logDate);
			if(null!=rwId){
				wxreport = testNoteDao.getWxlxReport(rwId);
				log.info("显示危险倾向数据【"+wxreport.size()+"】条");
			}else{
				log.error("显示危险倾向失败，任务编号为Null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("显示危险类型倾向异常，请重试..."+e.getMessage(),e);
		}
		return wxreport;
	}
	/**
	 * @ TODO
	 * @authc quite
	 * @date 2018年1月6日
	 * @see com.hd.jy.oasm.services.VPgbgListService#getCrimInfoRecord(java.lang.String)
	 */
	@Override
	public String getCrimInfoRecord(String crimNo) {
		// TODO Auto-generated method stub
		String crimInfo = null;
		try {
			log.info("开始根据【囚号"+crimNo+"】解析个人信息显示数据时间"+logDate);
			CrimInfoView cv = new CrimInfoView();
			
			List<TevalReport> report = testNoteDao.crimInfoReport(crimNo); //个人评估报告
			
//			List<ZCYCYQPC> ycyq = ycyqDao.selectYCYQ(crimNo); //个人异常狱情
			
			List<ViewDafxjg> dafxjg = sjxwgcDao.crimInfoDafxjg(crimNo); //个人档案分析
			
			List<Viewpggl> grft = pgglDao.crimInfoGrft(crimNo); //个人结构访谈
			
			List<Viewpggl> grgc = pgglDao.crimInfoGrgc(crimNo); //个人行为观察
			
			List<SearchElement> xl = listLineDao.crimInfoXL(crimNo); //个人心理测试
			
			String taskId = taskRelatDao.getNewReport(crimNo); //获取最新的评估报告的编号
			
			log.info("任务编号【"+taskId+"】");
			List<BGwxlx> wxlxReport = testNoteDao.getWxlxReport(taskId); //通过父任务编号获取危险类型倾向包括自杀、逃脱、行凶、再犯罪
			
			List<TaskRelat> childTask = taskRelatDao.getChildTaskIdByParent(taskId); //通过父任务编号获取子任务编号
			
			Pgbg pgbg = new Pgbg();
			loop:for (TaskRelat tr : childTask) {
				switch (tr.getChildType()) {
				case CT.PG_DAFX:
					List<BGjcxxpg> dayz = testNoteDao.getAllJcxxpg(tr.getChildId());
					if(null==dayz){
						continue loop;
					}
					
					pgbg.setJcxxpg(dayz);
					break;
			    case CT.PG_GTFT:
					List<BGgtft> gtftyz = testNoteDao.getAllGtft(tr.getChildId());
					if(null==gtftyz){
						continue loop;
					}
					pgbg.setGtftpg(gtftyz);
					break;
			    case CT.PG_XWGC:
					List<BGxwgc> xwgcyz = testNoteDao.getAllXwgc(tr.getChildId());
					if(null==xwgcyz){
						continue loop;
					}
					pgbg.setXwgcpg(xwgcyz);
					break;
			    case CT.PG_XLSCL90:
			        List<PgXlcsJg> sclyz = listLineDao.getAllPgxlcsjg(tr.getChildId());
			        if(null==sclyz){
			        	continue loop;
			        }
			        pgbg.setSclpg(sclyz);
			        break;
			    case CT.PG_XLCOPAPI:
			        List<PgXlcsJg> papiyz = listLineDao.getAllPgxlcsjg(tr.getChildId());
			        if(null==papiyz){
			        	continue loop;
			        }
			        pgbg.setXlcepg(papiyz);
			        break;
				default:
					break;
				}
			}//for循环结束开始json赋值
			
			cv.setReport(report);
//			cv.setYcyqpc(ycyq);
			cv.setDafxjg(dafxjg);
			cv.setGrft(grft);
			cv.setGrgc(grgc);
			cv.setElement(xl);
			cv.setWxlxReport(wxlxReport);
			cv.setPgbg(pgbg);
			
			crimInfo = GsonUtil.toJson(cv);
			log.info("矫治项目返回前端数据【"+crimInfo+"】");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("矫治项目显示罪犯信息异常，请确认后重试..."+e.getMessage(),e);
		}
		
		return crimInfo;
	}
	
	/**
	 * <p>Title: listViewPgbgAndTCzsh</p>   
	 * <p>Description: 显示报告处理跟踪、审核、意见</p>   
	 * @param map
	 * @return   
	 * @see com.hd.jy.oasm.services.VPgbgListService#listViewPgbgAndTCzsh(java.util.Map)
	 */
	@Override
	public List<VPgbgList> listViewPgbgAndTCzsh(Map<String, Object> map) {
		List<VPgbgList> listViewPgbgAndTCzsh = null;
		try {
			listViewPgbgAndTCzsh = vPgbgListMapper.listViewPgbgAndTCzsh(map);
		} catch (Exception e) {
			log.error("VPgbgListService#listViewPgbgAndTCzsh(java.util.Map);出错"+e);
		}
		return listViewPgbgAndTCzsh;
	}
	/**
	 * <p>Title: selectJbxx</p>   
	 * <p>Description: 查询罪犯基本信息</p>  
	 */
	@Override
	public List<BGjbxx> selectJbxx() {
		// TODO Auto-generated method stub
		List<BGjbxx> list = null;
		try {
			log.info("开始查询【BGjbxx】时间"+DateUtil.getTime(new Date()));
			list = vPgbgListMapper.selectJbxx();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询【BGjbxx】错误"+e.getMessage());
		}
		return list;
	}

}
