package com.hd.jy.oasm.services;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.domain.BGwxlx;
import com.hd.jy.oasm.domain.TevalReport;
import com.hd.jy.oasm.domain.VPgbgList;
import com.hd.jy.oasm.domain.Viewgrpgbgxx;
/***
 * 评估报告逻辑接口，PGBGViewController调用
 * @author quite
 *
 */
public interface VPgbgListService {
	
	/**
	 * <p>Title: getViewPgbg</p>   
	 * <p>Description: 查询评估报告列表</p>   
	 * @param type	Map<String,Object>
	 * @return   
	 */
	public List<VPgbgList> getViewPgbg(Map<String,Object> map);
	
	/**
	 * <p>Title: crimInfoBycrimNo</p>   
	 * <p>Description: 通过囚号查询评估报告基本信息</p>   
	 * @param 	qh 囚号
	 * @return   
	 */
	public BGjbxx crimInfoBycrimNo(String qh); //调用评估报告罪犯信息显示
	
	/**
	 * <p>Title: evalReportCount</p>   
	 * <p>Description: 调用报告根据任务编号获取危险等级</p>   
	 * @param 	taskId 任务编号
	 * @return   
	 */
	TevalReport evalReportCount(String taskId); 

	/**
	 * <p>Title: getGrdjbh</p>   
	 * <p>Description: 个人危险等级变化</p>   
	 * @param qh 囚号
	 * @return   List
	 */
	public List<VPgbgList> getGrdjbh(String qh);
	
	/**
	 * <p>Title: getLsPgbg</p>   
	 * <p>Description: 罪犯历史评估报告</p>  
	 * @param qh 囚号 
	 * @return   List
	 */
	public List<VPgbgList> getLsPgbg(String qh);
	
	
	public String getPgbgTestNote(int bgstu,String taskId); //通过总任务编号获取子任务编号的答题记录
	
	public List<BGwxlx> getWxlxReport(String rwId); //显示危险类型倾向
	
	public String getCrimInfoRecord(String crimNo); //通过囚号查询个人罪犯信息--矫治项目显示
	
	List<VPgbgList> listViewPgbgAndTCzsh(Map<String,Object> map);//显示报告处理跟踪、审核、意见
	
}
