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
* @Description: ��ʾ���������б�
* @author liangjiaying
* @date 2018��3��23�� ����6:52:29 
*
 */
@Service("vPgbgListServiceImpl")
@DataSource("userDataSource")
public class VPgbgListServiceImpl implements VPgbgListService{

	private static Logger log = Logger.getLogger(VPgbgListServiceImpl.class);
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private String logDate = DateUtil.getTime(new Date());
	
	@Autowired
	private VPgbgListMapper vPgbgListMapper; //�����б�ҵ��ӿ�
	
	@Autowired
	private TestMapper testNoteDao; //��������������ҵ��ӿ�
	
	@Autowired
	private ListLineMapper listLineDao; //�������������ִ������ҵ��ӿ�--��ʾ�������
	
	@Autowired
	private TaskMapper taskRelatDao; //��������������ҵ��ӿ�
	
//	@Autowired
//	private ZCYCYQPCMapper ycyqDao; //�쳣����ҵ��ӿ�--��ʾ�쳣����
	
	@Autowired
	private ViewpgglMapper pgglDao; //��������ҵ��ӿ� --��ʾ�ṹ��̸����Ϊ�۲�
	
	@Autowired
	private SjjgftAndxwgcDao sjxwgcDao; //�ṹ��̸����Ϊ�۲�ҵ��ӿ�--��ʾ��������
	
	/**
	 * <p>Title: getViewPgbg</p>   
	 * <p>Description: ��ѯ���������б�</p>   
	 * @param type
	 * @return   
	 * @see com.hd.jy.oasm.services.VPgbgListService#getViewPgbg(java.lang.String)
	 */
	@Override
	public List<VPgbgList> getViewPgbg(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<VPgbgList> viewPgbg = null;
		try {
			log.info("��ʼ��ȡ����������濪ʼʱ��"+logDate);
			viewPgbg = vPgbgListMapper.getViewPgbg(map);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("VPgbgListServiceImpl.getViewPgbg();�������� "+e);
		}
		return viewPgbg;
	}
	/**
	 * 
	 * @ TODO ͨ�����Ų�ѯ�������������Ϣ
	 * @authc quite
	 * @date 2017��12��20��
	 * @see com.hd.jy.oasm.services.VPgbgListService#crimInfoBycrimNo(java.lang.String)
	 */
	@Override
	public BGjbxx crimInfoBycrimNo(String qh) {
		// TODO Auto-generated method stub
		BGjbxx bGjbxx = null;
		try {
			log.info("��ʼ���ݡ���������"+qh+"��,��ʾ�ﷸ�Ļ�����Ϣʱ��"+logDate);
			if(null!=qh&&""!=qh){
				bGjbxx = vPgbgListMapper.crimInfoBycrimNo(qh);
			}else{
				log.error("�����ġ�����Ϊ"+qh+"��,��ʾ�ﷸ�Ļ�����Ϣʧ�ܣ����Ժ�����...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������������ʾ�����Ļ�����Ϣ�쳣��������..."+e.getMessage(),e);
		}
		return bGjbxx;
	}

	/**
	 * 
	 * <p>Title: getGrdjbh</p>   
	 * <p>Description: ����Σ�յȼ��仯</p>   
	 * @return   
	 * @see com.hd.jy.oasm.services.VPgbgListService#getGrdjbh()
	 */
	@Override
	public List<VPgbgList> getGrdjbh(String qh) {
		List<VPgbgList> viewPgbg = null;
		try {
			viewPgbg = vPgbgListMapper.getGrdjbh(qh.trim());
		} catch (Exception e) {
			log.error("VPgbgListServiceImpl.getGrdjbh����"+e);
		}
		return viewPgbg;
	}

	/**
	 * 
	 * <p>Title: getLsPgbg</p>   
	 * <p>Description: �ﷸ��ʷ��������</p>   
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
			log.error("VPgbgListServiceImpl.getLsPgbg����"+e);
		}
		return lists;
	}
	
	/**
	 * @ TODO �Ȼ�ȡ�����������������ı�ţ���ͨ���������ȡ�������
	 * @authc quite
	 * @date 2017��12��22��
	 * @see com.hd.jy.oasm.services.VPgbgListService#getPgbgTestNote(java.lang.String)
	 */
	@Override
	public String getPgbgTestNote(int bgstu,String taskId) {
		// TODO Auto-generated method stub
		List<Pgbg> list = new ArrayList<>(); //��װjsonʹ��
		Map<String,String> map =new HashMap<String,String>(); //��ֵʹ��,��������status=4֮�󣬻�ȡ�����������ֵ
		
		Pgbg pgbg = null;
		String json = null;
		int pgScores = 0; //�����������ܷ�
		String childTaskId = null; //������������������ 
		try {
			log.info("��ʼ����������"+taskId+"��ʾ������������ʱ��"+logDate);
			if(null!=taskId&&""!=taskId){
				List<TaskRelat> parent = taskRelatDao.getChildTaskIdByParent(taskId); //��ȡ�����ϵ����
				String copaJSON = null;
				String sclJSON = null;
 				List<PgXlcsJg> allPgxlcsjg = null;
 				
				loop:for (TaskRelat tr : parent) { //ѭ�������ϵ����
					pgScores = 0;
					log.info("���е��������͡�"+tr.getChildType()+"��");
					switch (tr.getChildType()) {
					case CT.PG_DAFX: //��������������--�ع�
						List<BGjcxxpg> allJcxxpg = testNoteDao.getAllJcxxpg(tr.getChildId());
						if(null==allJcxxpg){ //��Ϊ�մ�ֵ
							continue loop;
						}
						for (BGjcxxpg jcpg : allJcxxpg) {
								pgScores+=jcpg.getFs(); //����������ֵ�ܷ�
								childTaskId = jcpg.getRwid(); //����������������
							}
						pgbg = new Pgbg();
						map.put(CT.PG_DAFX, ""+pgScores); // ����������ֵ
						pgbg.setCtaskId(childTaskId);
					    pgbg.setJcxxpg(allJcxxpg);
						pgbg.setTaskType(tr.getChildType());
						pgbg.setTaskfs(""+pgScores); //תΪString���͵ķ���
						
						list.add(pgbg);
						break;
//					case CT.PG_JTFT:  //�����̸������
//						note = testNoteDao.getNote(tr.getChildId());
//						if(null!=note){
//							pgbg = new Pgbg(note.getTaskId(),tr.getChildType(),note.getAnswer(),note.getResult(),""+note.getScore());
////							map.put(CT.PG_JTFT, ""+note.getScore()); // ���������ֵ
//						}else{
//							pgbg = new Pgbg(null,tr.getChildType(),null,null,null);
//						}
//						list.add(pgbg);
//						break;
			        case CT.PG_GTFT: //���˷�̸������--�ع�
			        	List<BGgtft> allGtft = testNoteDao.getAllGtft(tr.getChildId());
			        	if(allGtft==null){
			        		continue loop;
			        	}
			        	for (BGgtft gtpg : allGtft) {
							pgScores+=gtpg.getFs(); //�����̸�ܷ���
							childTaskId = gtpg.getRwid(); //�����̸������
						}
			        	pgbg = new Pgbg();
			        	map.put(CT.PG_GTFT, ""+pgScores); //���˷�̸��ֵ
			        	pgbg.setCtaskId(childTaskId);
			        	pgbg.setGtftpg(allGtft); //�Ѹ����̸��listֱ�Ӵ��ȥ
			        	pgbg.setTaskType(tr.getChildType());
			        	pgbg.setTaskfs(""+pgScores);
			        	
						list.add(pgbg);
						break;
					    
					case CT.PG_XWGC:  //��Ϊ�۲������--�ع�
						List<BGxwgc> allXwgc = testNoteDao.getAllXwgc(tr.getChildId());
						if(allXwgc==null){
							continue loop;
						}
						for (BGxwgc gcpg : allXwgc) {
							pgScores+=gcpg.getFs(); //��Ϊ�۲�������
							childTaskId=gcpg.getRwid(); //������
						}
						pgbg = new Pgbg();
						map.put(CT.PG_XWGC, ""+pgScores);
						pgbg.setCtaskId(childTaskId);
						pgbg.setXwgcpg(allXwgc);
						pgbg.setTaskType(tr.getChildType());
						pgbg.setTaskfs(""+pgScores);
						
						list.add(pgbg);
						break;
//					case CT.PG_XLSCL90: //����scl90������--�ع�
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
//						map.put(CT.PG_XLSCL90, ""+pgScores); //����copapi��ֵ
//						pgbg.setCtaskId(childTaskId);
//						pgbg.setXlcepg(allPgxlcsjg);
//						pgbg.setTaskType(tr.getChildType());
//						pgbg.setTaskfs(""+pgScores);
//						
//						list.add(pgbg);
//						break;
//					case CT.PG_XLCOPAPI: //����copapi������
//						allPgxlcsjg = listLineDao.getAllPgxlcsjg(tr.getChildId());
//						if(allPgxlcsjg==null){
//							continue loop;
//						}
//						for (PgXlcsJg xlpg : allPgxlcsjg) {
//							pgScores+=xlpg.getPGFS();
//							childTaskId=xlpg.getRWID();
//							
//						}
//						log.info("copapi�ķ�����"+pgScores+"��");
//						pgbg = new Pgbg();
//						map.put(CT.PG_XLCOPAPI, ""+pgScores); //����copapi��ֵ
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
				int i = reUpdate(bgstu,taskId); //ִ���޸���������״̬��������Ҫʹ����ƶ�ʱ��
				if(i==1){
					double dafs = Double.parseDouble(map.get(CT.PG_DAFX));
//					String jtfs = map.get(CT.PG_JTFT); 
//					String rjfs = map.get(CT.PG_XLRJ);
//					String cjfs = map.get(CT.PG_XLCJ);
					
					double gtfs = Double.parseDouble(map.get(CT.PG_GTFT));
					double xwfs = Double.parseDouble(map.get(CT.PG_XWGC));
					
//					double copafs = DataUtil.isNothing(copaJSON)? 0: GsonUtil.toInstance(copaJSON, CopaResult.class).getPgTotalScore();
//					double sclfs = DataUtil.isNothing(sclJSON)? 0: GsonUtil.toInstance(sclJSON, SCL90Result.class).getPgTotalScore();
					
//					int zfs = (int)(dafs+gtfs+xwfs+copafs+sclfs); //�ܷ���
//					addEval(zfs,taskId); //�����һ���������������Σ�յȼ�
//					log.info("��ִ���޸ĺ�ѡ�������"+taskId+"����������"+zfs+"����ӵ����񱨸���У���ע�����..."); //ʵ�ʷ���
				}else{
					 //����ʹ�ã������method����ʾ����Ա�޸�
					log.info("�ݲ�ִ���޸�"+taskId);
				}
				//**************************************************************
			}else{
				log.error("ʧ��ԭ��������Ϊ"+taskId+",��ȷ�Ϻ���");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���������쳣��Ϣ"+e.getMessage(),e);
		}
		return json;
	}
	/***
	 * ����ķ�����Ϊִ�в����ж�����������
	 * @auto quite
	 * @param taskId,bgstu Ϊ���������״̬
	 * @returna
	 * ����8:56:30
	 * int
	 */
	public int reUpdate(int bgstu,String taskId) {
		
		int i = 0;
		boolean zt = true;
		boolean stat = true;
		Task task = null;
		try {
			log.info("��������״̬"+bgstu+"��");
			if(bgstu!=4){ //�����������״̬Ϊ4��ʱ���Ѿ�����Ҫ�޸��ˣ�������Ҫ�жϸ����������״̬�Ƿ�Ϊ4,�Ƿ�Ҫִ���޸Ĳ���
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
//						if(vr.getStatus()==4&&null!=vr.getStatus()){ //ע�ͱ�ʾ�ݲ��ж�
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
				}//forѭ������
				boolean stResult = zt&&stat;
				log.info(stResult+" or "+stResult);
				if(stResult){
					task = new Task();
					task.setTaskId(taskId); //����
					task.setModifier("ϵͳ");
					task.setLastModif(sdf.format(new Date()));
					task.setStatus(4);
				    i = taskRelatDao.updateStatus(task);
				    log.info("�Ƿ�ɹ����t_eval_report������"+i+"����");
				}else{
					i = 0;
				}
			}else{
				i=0; //��ʾ�Ѿ�Ϊ4��״̬�ˣ�����Ҫ�ٴ��޸�״̬
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ִ���ж��������쳣�������ԡ�����"+e.getMessage(),e);
		}
		
		return i;
	}
	
	public int addEval(int fs,String taskId){
		int i = 0;
		String wxdj = null; //Σ�յȼ�
		TevalReport tr = null;
		try {
			String lx = taskId.substring(11, taskId.length()-13); //�����׶�
			String qh = taskId.substring(0, 10); //����
			String crtime = sdf.format(new Date());
			switch (lx) {
			case "inRep": //���׶�
				wxdj = testNoteDao.getWxdj(fs, "rj");
				break;
			case "dyRep": //�ճ��׶�
				wxdj = testNoteDao.getWxdj(fs, "rc");
				break;
			case "mdRep": //���ڽ׶�
				wxdj = testNoteDao.getWxdj(fs, "zq");
				break;
			case "otRep": //����׶�
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
			log.info("��������:"+taskId+"����������:"+qh+"������ʱ��:"+crtime+"����������:"+fs+"������Σ�յȼ�:"+wxdj+"��"+"��Σ������������:"+report+"��");
			i = testNoteDao.addEvalReport(tr); //�����������
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��������Σ�յȼ��쳣��������..."+e.getMessage(),e);
		}
		return i;
	}
	/**
	 * @ TODO
	 * @authc quite
	 * @date 2017��12��26��
	 * @see com.hd.jy.oasm.services.VPgbgListService#evalReportCount(java.lang.String)
	 */
	@Override
	public TevalReport evalReportCount(String taskId) {
		// TODO Auto-generated method stub
		TevalReport count = null;
		try {
			if(null!=taskId&&""!=taskId){
				log.info("��ʼִ����ʾ�ﷸ�ĵȼ���ʾʱ��"+logDate);
				count = testNoteDao.evalReportCount(taskId);
				if(null!=count){
					log.info("����ǰ�˵�����Ϊ"+JSON.toJSON(count));
				}else{
					log.error("��������û�����ݣ���ȷ�Ϻ�����...");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�쳣����������������û������");
		}
		return count;
	}
	/**
	 * @ TODO ��ʾΣ����������
	 * @authc quite
	 * @date 2018��1��4��
	 * @see com.hd.jy.oasm.services.VPgbgListService#getWxlxReport(java.lang.String)
	 */
	@Override
	public List<BGwxlx> getWxlxReport(String rwId) {
		// TODO Auto-generated method stub
		List<BGwxlx> wxreport = null;
		try {
			log.info("��ʼ��ʾΣ����������ʱ��"+logDate);
			if(null!=rwId){
				wxreport = testNoteDao.getWxlxReport(rwId);
				log.info("��ʾΣ���������ݡ�"+wxreport.size()+"����");
			}else{
				log.error("��ʾΣ������ʧ�ܣ�������ΪNull");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ʾΣ�����������쳣��������..."+e.getMessage(),e);
		}
		return wxreport;
	}
	/**
	 * @ TODO
	 * @authc quite
	 * @date 2018��1��6��
	 * @see com.hd.jy.oasm.services.VPgbgListService#getCrimInfoRecord(java.lang.String)
	 */
	@Override
	public String getCrimInfoRecord(String crimNo) {
		// TODO Auto-generated method stub
		String crimInfo = null;
		try {
			log.info("��ʼ���ݡ�����"+crimNo+"������������Ϣ��ʾ����ʱ��"+logDate);
			CrimInfoView cv = new CrimInfoView();
			
			List<TevalReport> report = testNoteDao.crimInfoReport(crimNo); //������������
			
//			List<ZCYCYQPC> ycyq = ycyqDao.selectYCYQ(crimNo); //�����쳣����
			
			List<ViewDafxjg> dafxjg = sjxwgcDao.crimInfoDafxjg(crimNo); //���˵�������
			
			List<Viewpggl> grft = pgglDao.crimInfoGrft(crimNo); //���˽ṹ��̸
			
			List<Viewpggl> grgc = pgglDao.crimInfoGrgc(crimNo); //������Ϊ�۲�
			
			List<SearchElement> xl = listLineDao.crimInfoXL(crimNo); //�����������
			
			String taskId = taskRelatDao.getNewReport(crimNo); //��ȡ���µ���������ı��
			
			log.info("�����š�"+taskId+"��");
			List<BGwxlx> wxlxReport = testNoteDao.getWxlxReport(taskId); //ͨ���������Ż�ȡΣ���������������ɱ�����ѡ����ס��ٷ���
			
			List<TaskRelat> childTask = taskRelatDao.getChildTaskIdByParent(taskId); //ͨ���������Ż�ȡ��������
			
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
			}//forѭ��������ʼjson��ֵ
			
			cv.setReport(report);
//			cv.setYcyqpc(ycyq);
			cv.setDafxjg(dafxjg);
			cv.setGrft(grft);
			cv.setGrgc(grgc);
			cv.setElement(xl);
			cv.setWxlxReport(wxlxReport);
			cv.setPgbg(pgbg);
			
			crimInfo = GsonUtil.toJson(cv);
			log.info("������Ŀ����ǰ�����ݡ�"+crimInfo+"��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������Ŀ��ʾ�ﷸ��Ϣ�쳣����ȷ�Ϻ�����..."+e.getMessage(),e);
		}
		
		return crimInfo;
	}
	
	/**
	 * <p>Title: listViewPgbgAndTCzsh</p>   
	 * <p>Description: ��ʾ���洦����١���ˡ����</p>   
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
			log.error("VPgbgListService#listViewPgbgAndTCzsh(java.util.Map);����"+e);
		}
		return listViewPgbgAndTCzsh;
	}
	/**
	 * <p>Title: selectJbxx</p>   
	 * <p>Description: ��ѯ�ﷸ������Ϣ</p>  
	 */
	@Override
	public List<BGjbxx> selectJbxx() {
		// TODO Auto-generated method stub
		List<BGjbxx> list = null;
		try {
			log.info("��ʼ��ѯ��BGjbxx��ʱ��"+DateUtil.getTime(new Date()));
			list = vPgbgListMapper.selectJbxx();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯ��BGjbxx������"+e.getMessage());
		}
		return list;
	}

}
