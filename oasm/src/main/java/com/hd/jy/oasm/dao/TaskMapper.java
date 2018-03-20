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
	 * �������
	 * 
	 * @param task
	 * @return
	 */
	public int addTask(Task task);

	/**
	 * �����������
	 * 
	 * @param task
	 * @return
	 */
	public int batchAddTask(List<Task> taskList);
	
	/**
	 * ��ȡ����������������IDΪ�յĸ��������ϵ
	 * @return
	 */
	public ArrayList<TaskRelat> getChildNullTaskRelat();
	
	/**
	 * ��ȡ����������������IDΪ�յ�������Id
	 * @param parentId
	 * @param crimNo
	 * @param pgType
	 * @return
	 */
	public int findChildTaskId(@Param("parentId") String parentId, @Param("crimNo") String crimNo, @Param("pgType") String pgType);
	
	
	/**
	 * ������Ӹ��������ϵ
	 * 
	 * @param taskRelatList
	 * @return
	 */
	public int batchAddTaskRelat(ArrayList<TaskRelat> taskRelatList);
	
	/**
	 * �޸�����״̬�����񷢲���ֻ���޸�״̬����ȡ����,�����޸����ݺ̈́h��. ״̬�޸�ֻ��1-->2-->3-->4�����������޸�
	 * 
	 * @param task
	 * @return
	 */
	public int updateStatus(Task task);

	/**
	 * ��ѯ����״̬
	 * 
	 * @param taskId
	 * @return
	 */
	public String currStatus(String taskId);
	
	
	
	/**
	 * ��ȡ���������õ�����������Ϣ�б�
	 * @param searchElement
	 * @return
	 */
	public ArrayList<CrimCopInfo> getCrimCopInfo(SearchElement searchElement);
	
	/**
	 * ͨ�������������id��ȡ��������
	 * @auto quite
	 * @param taskId
	 * @returna
	 * ����4:44:05
	 * List<TaskRelat>
	 */
	public List<TaskRelat> getChildTaskIdByParent(String taskId); 
	
	/**
	 * ����������ID��ȡ������ID�����ܶ����
	 * @param childTaskId
	 * @return
	 */
	public List<String> getParentTaskIds(String childTaskId);
	
	/**
	 * �������Ż�ȡ���µ����������������
	 * @auto quite
	 * @param crimNo
	 * @returna
	 * ����6:11:43
	 * String
	 */
	public String getNewReport(String crimNo);
	
}
