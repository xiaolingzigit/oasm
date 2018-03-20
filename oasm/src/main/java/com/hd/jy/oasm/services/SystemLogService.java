package com.hd.jy.oasm.services;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.util.domain.SystemLog;

public interface SystemLogService {
	   public int insertLog(SystemLog record);  //添加日志的方法
	   
	   public List<SystemLog> systemLogInfo(Map<String,String> map);
	   
	   public String backupDB(String fileName); //备份数据库
}
