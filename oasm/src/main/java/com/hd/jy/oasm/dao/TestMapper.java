package com.hd.jy.oasm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hd.jy.oasm.domain.BGgtft;
import com.hd.jy.oasm.domain.BGjcxxpg;
import com.hd.jy.oasm.domain.BGwxlx;
import com.hd.jy.oasm.domain.BGxwgc;
import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.domain.TevalReport;
import com.hd.jy.oasm.domain.Viewrwxq;

/***
 * 答题记录业务接口
 * @author quite
 *调用：通用的业务接口在各个需要的service自己调用
 */
public interface TestMapper {

	int saveNote(TestNote testNote); //保存答题记录
	
	int saveGtfts(BGgtft record); //保存结构访谈答题记录
	
	int saveXwgcs(BGxwgc record); //保存行为观察答题记录
	
	int saveJcdafxs(BGjcxxpg record); //保存基础档案分析结果记录

	TestNote getNote(String taskId); //根据任务编号查询答题记录
	
	List<BGjcxxpg> getAllJcxxpg(String taskId); //根据子任务编号获取子任务内容
	
	List<BGgtft> getAllGtft(String taskId); //根据子任务编号获取子任务内容
	
	List<BGxwgc> getAllXwgc(String taskId); //根据子任务编号获取行为观察的因子和id
	
	List<Viewrwxq> getChildrenStatus(String taskId); //根据父任务获取所有子任务状态
	
	String getWxdj(@Param("fs") int fs,@Param("lx") String lx);//在总任务状态为4的时候调用统计危险等级
	
	int addEvalReport(TevalReport record); //添加评估报告，用于统计和分析
	
	TevalReport evalReportCount(String taskId); //根据任务编号获取危险等级
	
	/***
	 * 添加到危险类型表
	 * @auto quite
	 * @param record
	 * @return
	 * 下午6:33:05
	 * int
	 */
	int addWxlxReport(BGwxlx record); 
	
	/***
	 * 根据任务编号获取自杀，逃脱，行凶，再犯罪危险类型
	 * @auto quite
	 * @param rwId
	 * @return
	 * 下午6:37:23
	 * List<BGwxlx>
	 */
	List<BGwxlx> getWxlxReport(String rwId);
	
	/**
	 * 保存根据CopaPi测试结果而来的危险类型分析结果
	 * @param pgrwid 评估任务ID
	 * @param wxlxfs 危险性评估分析文字
	 * @return
	 */
	int saveWxxpgFs(String pgrwid,String wxlxfs); 
	
	/**
	 * 根据囚号显示罪犯已有分数的评估报告--在矫正项目--罪犯信息查询
	 * @auto quite
	 * @param qh
	 * @returna
	 * 下午2:50:24
	 * List<TevalReport>
	 */
	List<TevalReport> crimInfoReport(String qh); 
}
