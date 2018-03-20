package com.hd.jy.oasm.domain;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * 信息列表行数据对象
 * 
 * @author admin
 *
 */
public class ListLine extends BasicModel {
	private String taskId;
	private String taskType;
	private String crimNo;
	private String crimName;
	private String prisonNo;
	private String prisonName;
	private String subPrisonNo;
	private String subPrisonName;
	private String basis;
	private String describ;
	private String cop1No;//任务执行人1
	private String cop1Name;
	private String cop2No;//任务执行人2
	private String cop2Name;
	private String crtime;
	private String creatorNo;
	private String creatorName;
	private String modifierNo;
	private String modifierName;
	private String deadline;
	private String score;
	private String lastModif;
	private String status;
	private String statusName;
	private String inTime;
	private String stage; //阶段-刚导入系统，在监，已出监
	private String copANo;//专管警察
	private String copAName;
	private String copBNo;//协管警察
	private String copBName;
		
	public ListLine() {
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
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

	public String getPrisonNo() {
		return prisonNo;
	}

	public void setPrisonNo(String prisonNo) {
		this.prisonNo = prisonNo;
	}

	public String getPrisonName() {
		return prisonName;
	}

	public void setPrisonName(String prisonName) {
		this.prisonName = prisonName;
	}

	public String getSubPrison() {
		return subPrisonNo;
	}

	public void setSubPrison(String subPrisonNo) {
		this.subPrisonNo = subPrisonNo;
	}

	public String getSubPrisonName() {
		return subPrisonName;
	}

	public void setSubPrisonName(String subPrisonName) {
		this.subPrisonName = subPrisonName;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getDescrib() {
		return describ;
	}

	public void setDescrib(String describ) {
		this.describ = describ;
	}

	public String getCop1No() {
		return cop1No;
	}

	public void setCop1No(String cop1No) {
		this.cop1No = cop1No;
	}

	public String getCop1Name() {
		return cop1Name;
	}

	public void setCop1Name(String cop1Name) {
		this.cop1Name = cop1Name;
	}

	public String getCop2No() {
		return cop2No;
	}

	public void setCop2No(String cop2No) {
		this.cop2No = cop2No;
	}

	public String getCop2Name() {
		return cop2Name;
	}

	public void setCop2Name(String cop2Name) {
		this.cop2Name = cop2Name;
	}

	public String getCrtime() {
		return crtime;
	}

	public void setCrtime(String crtime) {
		this.crtime = crtime;
	}

	public String getCreatorNo() {
		return creatorNo;
	}

	public void setCreatorNo(String creatorNo) {
		this.creatorNo = creatorNo;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getModifierNo() {
		return modifierNo;
	}

	public void setModifierNo(String modifierNo) {
		this.modifierNo = modifierNo;
	}

	public String getModifierName() {
		return modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getLastModif() {
		return lastModif;
	}

	public void setLastModif(String lastModif) {
		this.lastModif = lastModif;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getSubPrisonNo() {
		return subPrisonNo;
	}

	public void setSubPrisonNo(String subPrisonNo) {
		this.subPrisonNo = subPrisonNo;
	}

	public String getCopANo() {
		return copANo;
	}

	public void setCopANo(String copANo) {
		this.copANo = copANo;
	}

	public String getCopAName() {
		return copAName;
	}

	public void setCopAName(String copAName) {
		this.copAName = copAName;
	}

	public String getCopBNo() {
		return copBNo;
	}

	public void setCopBNo(String copBNo) {
		this.copBNo = copBNo;
	}

	public String getCopBName() {
		return copBName;
	}

	public void setCopBName(String copBName) {
		this.copBName = copBName;
	}
	
	
}
