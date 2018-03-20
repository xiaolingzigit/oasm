package com.hd.jy.oasm.services;

import java.util.Map;

/**
 * ����ҵ���߼�����
 * 
 * @author admin
 *
 */
public interface TaskService {


	/**
	 * �������
	 * 
	 * @param paramMap
	 * @return
	 */
	public String addTask(Map<String, String> paramMap);

	/**
	 * �޸�����״̬
	 * 
	 * @param paramMap
	 * @return
	 */
	public String updateStatus(Map<String, String> paramMap);

	/**
	 * ע������
	 * 
	 * @param paramMap
	 * @return
	 */
	public String cancelTask(Map<String, String> paramMap);
	
	/**
	 * �����ѯ,List<Task>
	 * @param paramMap
	 * @return
	 */
	public String getTaskList(Map<String, String> paramMap);
	
	/**
	 * ��ѯҪ��������,List<Task>
	 * @param paramMap
	 * @return
	 */
	public String getTaskToDo(Map<String, String> paramMap);
	

	/**
	 * ħ������ƥ�䣬�����ѯ,List<Task>
	 * @param paramMap
	 * @return
	 */
	public String getTaskListWithTypeLike(Map<String, String> paramMap);

	/**
	 * ������Լ�¼
	 * @param paramMap
	 * @return
	 */
	public String saveTestNote(Map<String, String> paramMap);

	/**
	 * ��ȡ���Լ�¼�����������棬����У�
	 * 
	 * @param taskId
	 * @return
	 */
	public String getTestNote(Map<String, String> paramMap);
	
	
	/**
	 * ��ȡ���������õ�����������Ϣ�б�
	 * @param paramMap
	 * @return
	 */
	public String getCrimCopInfo(Map<String, String> paramMap);


	

}
