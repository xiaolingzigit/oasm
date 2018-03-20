package com.hd.jy.oasm.domain;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;
/**
 * 搜索元素
 * @author admin
 *
 */
public class SearchElement extends BasicModel {
	
	private String taskType;
	private String taskId;
	private String prison;
	private String crimNo;
	private String crimName;
	private String copRange;//所有all/专管zg/协管xg/任务执行人zxr
	private String copNo;
	private String copName;
	private String creator;
	private String crTimeStart;
	private String crTimeEnd;
	private String deadlineStart;
	private String deadlineEnd;
	private String lastModifStart;
	private String lastModifEnd;
	private String status;
	private String taskBasis;
	private String taskDescrib;
	
	public SearchElement() {
		
	}

	public SearchElement(String taskType, String taskId, String prison,
			String crimNo, String crimName, String copRange, String copNo,
			String copName, String creator, String crTimeStart,
			String crTimeEnd, String deadlineStart, String deadlineEnd,
			String lastModifStart, String lastModifEnd, String status,
			String taskBasis, String taskDescrib) {
		
		this.taskType = taskType;
		this.taskId = taskId;
		this.prison = prison;
		this.crimNo = crimNo;
		this.crimName = crimName;
		this.copRange = copRange;
		this.copNo = copNo;
		this.copName = copName;
		this.creator = creator;
		this.crTimeStart = crTimeStart;
		this.crTimeEnd = crTimeEnd;
		this.deadlineStart = deadlineStart;
		this.deadlineEnd = deadlineEnd;
		this.lastModifStart = lastModifStart;
		this.lastModifEnd = lastModifEnd;
		this.status = status;
		this.taskBasis = taskBasis;
		this.taskDescrib = taskDescrib;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getPrison() {
		return prison;
	}

	public void setPrison(String prison) {
		this.prison = prison;
	}

	public String getCrimNo() {
		return crimNo;
	}

	public void setCrimNo(String crimNo) {
		this.crimNo = crimNo;
	}

	public String getCrimName() {
		return crimName;
	}

	public void setCrimName(String crimName) {
		this.crimName = crimName;
	}

	public String getCopRange() {
		return copRange;
	}

	public void setCopRange(String copRange) {
		this.copRange = copRange;
	}

	public String getCopNo() {
		return copNo;
	}

	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	public String getCopName() {
		return copName;
	}

	public void setCopName(String copName) {
		this.copName = copName;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCrTimeStart() {
		return crTimeStart;
	}

	public void setCrTimeStart(String crTimeStart) {
		this.crTimeStart = crTimeStart;
	}

	public String getCrTimeEnd() {
		return crTimeEnd;
	}

	public void setCrTimeEnd(String crTimeEnd) {
		this.crTimeEnd = crTimeEnd;
	}

	public String getDeadlineStart() {
		return deadlineStart;
	}

	public void setDeadlineStart(String deadlineStart) {
		this.deadlineStart = deadlineStart;
	}

	public String getDeadlineEnd() {
		return deadlineEnd;
	}

	public void setDeadlineEnd(String deadlineEnd) {
		this.deadlineEnd = deadlineEnd;
	}

	public String getLastModifStart() {
		return lastModifStart;
	}

	public void setLastModifStart(String lastModifStart) {
		this.lastModifStart = lastModifStart;
	}

	public String getLastModifEnd() {
		return lastModifEnd;
	}

	public void setLastModifEnd(String lastModifEnd) {
		this.lastModifEnd = lastModifEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTaskBasis() {
		return taskBasis;
	}

	public void setTaskBasis(String taskBasis) {
		this.taskBasis = taskBasis;
	}

	public String getTaskDescrib() {
		return taskDescrib;
	}

	public void setTaskDescrib(String taskDescrib) {
		this.taskDescrib = taskDescrib;
	}
}
