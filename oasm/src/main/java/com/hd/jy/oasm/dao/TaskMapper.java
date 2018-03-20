package com.hd.jy.oasm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hd.jy.oasm.domain.CrimCopInfo;
import com.hd.jy.oasm.domain.SearchElement;
import com.hd.jy.oasm.domain.Task;
import com.hd.jy.oasm.domain.TaskRelat;

public interface TaskMapper {

	/**
	 * 添加任务
	 * 
	 * @param task
	 * @return
	 */
	public int addTask(Task task);

	/**
	 * 批量添加任务
	 * 
	 * @param task
	 * @return
	 */
	public int batchAddTask(List<Task> taskList);
	
	/**
	 * 获取评估任务中子任务ID为空的父子任务关系
	 * @return
	 */
	public ArrayList<TaskRelat> getChildNullTaskRelat();
	
	/**
	 * 获取评估任务中子任务ID为空的子任务Id
	 * @param parentId
	 * @param crimNo
	 * @param pgType
	 * @return
	 */
	public int findChildTaskId(@Param("parentId") String parentId, @Param("crimNo") String crimNo, @Param("pgType") String pgType);
	
	
	/**
	 * 批量添加父子任务关系
	 * 
	 * @param taskRelatList
	 * @return
	 */
	public int batchAddTaskRelat(ArrayList<TaskRelat> taskRelatList);
	
	/**
	 * 修改任务状态。任务发布后只能修改状态（含取消）,不能修改内容和刪除. 状态修改只能1-->2-->3-->4，不可逆向修改
	 * 
	 * @param task
	 * @return
	 */
	public int updateStatus(Task task);

	/**
	 * 查询任务状态
	 * 
	 * @param taskId
	 * @return
	 */
	public String currStatus(String taskId);
	
	
	
	/**
	 * 获取发布任务用的囚犯警察信息列表
	 * @param searchElement
	 * @return
	 */
	public ArrayList<CrimCopInfo> getCrimCopInfo(SearchElement searchElement);
	
	/**
	 * 通过发布总任务的id获取子任务编号
	 * @auto quite
	 * @param taskId
	 * @returna
	 * 下午4:44:05
	 * List<TaskRelat>
	 */
	public List<TaskRelat> getChildTaskIdByParent(String taskId); 
	
	/**
	 * 根据子任务ID获取父任务ID（可能多个）
	 * @param childTaskId
	 * @return
	 */
	public List<String> getParentTaskIds(String childTaskId);
	
	/**
	 * 根据囚号获取最新的评估报告的任务编号
	 * @auto quite
	 * @param crimNo
	 * @returna
	 * 下午6:11:43
	 * String
	 */
	public String getNewReport(String crimNo);
	
}
