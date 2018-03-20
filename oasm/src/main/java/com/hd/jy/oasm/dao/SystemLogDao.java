package com.hd.jy.oasm.dao;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.util.domain.SystemLog;

public interface SystemLogDao {
   public int insertLog(SystemLog record);  //添加日志的方法
   public List<SystemLog> systemLogInfo(Map<String,String> map);
   //backup database Test_pg to disk = 'D:\20180111.bak'
   public String backupDB(String fileName); //备份数据库
   
}
