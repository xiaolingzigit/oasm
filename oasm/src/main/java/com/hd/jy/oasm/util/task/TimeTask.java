package com.hd.jy.oasm.util.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hd.jy.oasm.services.VtjbhService;
/**
 * 
* @ClassName: TimeTask 
* @Description: 定时任务
* @author liangjiaying
* @date 2018年1月12日 上午10:38:04
 */
@Component("timeTask")
public class TimeTask {
	
	private static Logger log = Logger.getLogger(TimeTask.class);
	
	@Autowired
	private VtjbhService vtjbhService;
	
	@Scheduled(cron = "0 * 1 * * *")
	public void test1(){
		System.out.println("测试定时任务");
	}
	
	/**
	 * @Date: 2018年1月13日 16:07:01
	 * @author autoSave
	 * @Title: saveZfzBh  
	 * @Description: 	每天32:50:00执行一次
	 *  <p>1.保存危险类型统计数据;<p>
	 * 	<p>2.保存再犯罪统计数据;<p>
	 * 	<p>3.保存危险程度统计数据<p>
	 * @throws
	 */
	@Scheduled(cron = "0 50 23 * * *")
	public void autoSave(){
		try {
			vtjbhService.autoSave();
		} catch (Exception e) {
			log.error(""+e);
		}
	}
	
	

}
