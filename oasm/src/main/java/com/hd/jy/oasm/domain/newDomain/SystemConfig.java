package com.hd.jy.oasm.domain.newDomain;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;


import com.hd.jy.oasm.util.lsc.FileUtil;
import com.hd.jy.oasm.util.lsc.GsonUtil;

public class SystemConfig {
	/**当前系统新囚犯默认的量表配置*/
	public static final String CURR_DEF_SCALE="CURR_DEF_SCALE"; 
	
	/**是否全局统一使用同一个量表配置*/
	public static final String SCALE_GLOBAL_EFFECD="SCALE_GLOBAL_EFFECD"; 
	
	private static final String filePath;
   private HashMap<String,String> map = new HashMap<String,String>();
   private boolean isInit = false;
   
   static{
	   File tmp = new File("sysconfig.txt");
	   filePath = tmp.getAbsolutePath();
	   System.out.println("config filePath: "+filePath);
	  
	   if(!tmp.exists()){
		   tmp = tmp.getParentFile();
		   if(tmp!=null && !tmp.exists()){
			   tmp.mkdirs();
		   }
		   new SystemConfig().save();
	   }
	   
   }
   
   public SystemConfig init(){
	   try {
			String confContext = FileUtil.readAsString(filePath, Charset.forName("utf-8"),null);
				 	   SystemConfig tmp = GsonUtil.toInstance(confContext, SystemConfig.class);
			   tmp.map.putAll(this.map);
			   this.map = tmp.map;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	   return this;
   }
   
   public SystemConfig setConf(String key,String value){
	   if(key==null){
		   throw new IllegalArgumentException("key cannot null");
	   }
	   map.put(key, value);
	   save();
	   return this;
   }
   
   public  String getConf(String key) {
	   if(!isInit){
		   init();
		   isInit = true;
	   }
	    return map.get(key);
  }
   
   public SystemConfig save(){
	   try {
		File file = new File(filePath);
		if(!file.exists()){
			file.getParentFile().mkdirs();
		}
		FileUtil.writeFile(file.getAbsolutePath(), GsonUtil.toJson(this), Charset.forName("utf-8"), false);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return this;
   }
   
  
   
   public static void main(String[] args) {
	
	   SystemConfig config = new SystemConfig();
	System.out.println(config.getConf(CURR_DEF_SCALE));
//	config.setConf("CURR_DEF_SCALE", "aaa配置");
	
	
}
}
