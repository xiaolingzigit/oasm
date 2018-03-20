package com.hd.jy.oasm.domain;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * 父子任务关系ID
 * 
 * @author admin
 */
public class TaskRelat extends BasicModel {
	
	private String parentId;
	private String childType;//子任务类型TaskType.*
	private String childId;

	
	public TaskRelat() {
		super();
	}

	public TaskRelat(String parentId, String childType, String childId) {
		this.parentId = parentId;
		this.childType = childType;
		this.childId = childId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getChildType() {
		return childType;
	}

	public void setChildType(String childType) {
		this.childType = childType;
	}

	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}
}
