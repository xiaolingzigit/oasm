package com.hd.jy.oasm.domain;

import com.hd.jy.oasm.model.Oasm;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.excpts.InitException;
import com.hd.jy.oasm.util.priv.CT;

public class Task extends Oasm {
	private String taskId;// 任务id ，主键(囚号_任务类型 _发布时间yyyyMMddHHmmss)
	private String crimNo;// 囚号
	private String type;// 任务类型
	private String taskBasis;// 任务依据(为什么)
	private String taskDescrib;// 任务描述(做什么)
	private String deadline;// 任务完成期限yyyy-MM-dd HH:mm:ss
	private String copNo1;// 专教警号
	private String copNo2;// 协教警号
	private String creator;// 任务创建/发布人
	private String createTime;// 任务发布时间yyyy-MM-dd HH:mm:ss
	private String lastModif;// modification最后修改时间
	private String modifier;// 修改人/任务执行人
	private int status;// -状态：-1未发布，1未开始，2处理中，3未完成/暂存，4已完成(不能再编辑)，10已取消

	public Task() {
		
	}

	public Task(String taskId, String lastModif, String modifier, int status) {

		if (taskId == null) {
			throw new IllegalArgumentException("taskId cannot be null");
		}

		this.taskId = taskId;
		this.status = status;
	}

	public Task(String crimNo, String type, String taskBasis,
			String taskDescrib, String deadline, String copNo1, String copNo2,
			String creator, String createTime, String lastModif,
			String modifier, int status) {
		if (crimNo == null || type == null || createTime == null) {
			throw new IllegalArgumentException(" cannot be null");
		}
		this.crimNo = crimNo;
		this.type = type;
		this.taskBasis = taskBasis;
		this.taskDescrib = taskDescrib;
		this.deadline = deadline;
		this.copNo1 = copNo1;
		this.copNo2 = copNo2;
		this.creator = creator;
		this.createTime = createTime;
		this.lastModif = lastModif;
		this.modifier = modifier;
		this.status = status;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getCrimNo() {
		return crimNo;
	}

	public void setCrimNo(String crimNo) {
		this.crimNo = crimNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getCopNo1() {
		return copNo1;
	}

	public void setCopNo1(String copNo1) {
		this.copNo1 = copNo1;
	}

	public String getCopNo2() {
		return copNo2;
	}

	public void setCopNo2(String copNo2) {
		this.copNo2 = copNo2;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastModif() {
		return lastModif;
	}

	public void setLastModif(String lastModif) {
		this.lastModif = lastModif;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String statusName(int status) {
		return CT.taskStatusName(status);
	}

	/**
	 * 根据囚号和任务类型创建任务ID，如果任务ID已存在则抛InitException
	 * 
	 * @return
	 */
	public Task createTaskId() {
		if (!DataUtil.isNothing(taskId)) {
			throw new InitException("taskId exists, cannot recreate");
		}
		if (crimNo == null || type == null || createTime == null) {
			throw new IllegalArgumentException(
					"crimNo, type and cannot be null");
		}

		taskId = crimNo + "_" + type + "_" + subIdTime(createTime);
		return this;
	}

	private String subIdTime(String currTimeStr) {
		return currTimeStr.substring(0, currTimeStr.lastIndexOf(":"))
				.replaceAll("-| |:", "");
	}

	@Override
	public String getNullField(String op) {
	
		if (CT.OPV_TASK_ADD.equals(op)) {
			return DataUtil.getNullName(taskId, "任务ID", crimNo, "囚号",
					type, "任务类型", deadline, "完成期限", creator, "任务发布人",
					createTime, "任务创建时间", status, "状态");

		} else if (CT.OPV_TASK_UPDATE.equals(op)) {
			return DataUtil.getNullName(taskId, "taskId", lastModif,
					"lastModif", modifier, "modifier", status, "status");
			
		} else if (CT.OPV_TASK_CANCEL.equals(op)) {
			return DataUtil.getNullName(taskId, "taskId", lastModif,
					"lastModif", modifier, "modifier", status, "status");

		} else if (CT.OPV_TEST_SAVE.equals(op)) {
			return DataUtil.getNullName(taskId, "taskId", lastModif,
					"lastModif", modifier, "modifier", status, "status");
			
		} else if (CT.OPV_TEST_QUERY.equals(op)) {
			return DataUtil.getNullName(taskId, "taskId", lastModif,
					"lastModif", modifier, "modifier", status, "status");
		}

		return "null";
	}

}