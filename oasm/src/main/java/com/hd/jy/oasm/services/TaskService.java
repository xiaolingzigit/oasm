package com.hd.jy.oasm.services;

import java.util.Map;

/**
 * 公用业务逻辑处理
 * 
 * @author admin
 *
 */
public interface TaskService {


	/**
	 * 添加任务
	 * 
	 * @param paramMap
	 * @return
	 */
	public String addTask(Map<String, String> paramMap);

	/**
	 * 修改任务状态
	 * 
	 * @param paramMap
	 * @return
	 */
	public String updateStatus(Map<String, String> paramMap);

	/**
	 * 注销任务
	 * 
	 * @param paramMap
	 * @return
	 */
	public String cancelTask(Map<String, String> paramMap);
	
	/**
	 * 任务查询,List<Task>
	 * @param paramMap
	 * @return
	 */
	public String getTaskList(Map<String, String> paramMap);
	
	/**
	 * 查询要做的任务,List<Task>
	 * @param paramMap
	 * @return
	 */
	public String getTaskToDo(Map<String, String> paramMap);
	

	/**
	 * 魔火类型匹配，任务查询,List<Task>
	 * @param paramMap
	 * @return
	 */
	public String getTaskListWithTypeLike(Map<String, String> paramMap);

	/**
	 * 保存测试记录
	 * @param paramMap
	 * @return
	 */
	public String saveTestNote(Map<String, String> paramMap);

	/**
	 * 获取测试记录（含分析报告，如果有）
	 * 
	 * @param taskId
	 * @return
	 */
	public String getTestNote(Map<String, String> paramMap);
	
	
	/**
	 * 获取发布任务用的囚犯警察信息列表
	 * @param paramMap
	 * @return
	 */
	public String getCrimCopInfo(Map<String, String> paramMap);


	

}
