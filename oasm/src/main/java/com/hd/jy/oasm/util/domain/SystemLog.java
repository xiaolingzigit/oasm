package com.hd.jy.oasm.util.domain;

/**
 * 工具实例类
 * @author quite
 * class 系统日志类
 */
public class SystemLog {
     private String id;  //编号
     private String description;  //序列号
     private String method;   //方法
     private int logType;   //操作类型
     private String requireIP;  //请求ip
     private String exceptionCode;  //异常代码
     private String exceptionDetail; //异常处理
     private String params;   //内容
     private String createBy; //操作人
     private String createDate; //时间
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
		return "SystemLog [编号=" + id + ", description=" + description + ", method=" + method + ", logType=" + logType
				+ ", requireIP=" + requireIP + ", exceptionCode=" + exceptionCode + ", exceptionDetail="
				+ exceptionDetail + ", params=" + params + ", createBy=" + createBy + ", createDate=" + createDate
				+ "]";
	}
     
     
}
