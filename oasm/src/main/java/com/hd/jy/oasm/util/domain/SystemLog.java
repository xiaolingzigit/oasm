package com.hd.jy.oasm.util.domain;

/**
 * ����ʵ����
 * @author quite
 * class ϵͳ��־��
 */
public class SystemLog {
     private String id;  //���
     private String description;  //���к�
     private String method;   //����
     private int logType;   //��������
     private String requireIP;  //����ip
     private String exceptionCode;  //�쳣����
     private String exceptionDetail; //�쳣����
     private String params;   //����
     private String createBy; //������
     private String createDate; //ʱ��
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}

	public int getLogType() {
		return logType;
	}
	public void setLogType(int logType) {
		this.logType = logType;
	}
	public String getRequireIP() {
		return requireIP;
	}
	public void setRequireIP(String requireIP) {
		this.requireIP = requireIP;
	}
	public String getExceptionCode() {
		return exceptionCode;
	}
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	public String getExceptionDetail() {
		return exceptionDetail;
	}
	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "SystemLog [���=" + id + ", description=" + description + ", method=" + method + ", logType=" + logType
				+ ", requireIP=" + requireIP + ", exceptionCode=" + exceptionCode + ", exceptionDetail="
				+ exceptionDetail + ", params=" + params + ", createBy=" + createBy + ", createDate=" + createDate
				+ "]";
	}
     
     
}
