package com.hd.jy.oasm.util.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hd.jy.oasm.services.VtjbhService;
/**
 * 
* @ClassName: TimeTask 
* @Description: ��ʱ����
* @author liangjiaying
* @date 2018��1��12�� ����10:38:04
 */
@Component("timeTask")
public class TimeTask {
	
	private static Logger log = Logger.getLogger(TimeTask.class);
	
	@Autowired
	private VtjbhService vtjbhService;
	
	@Scheduled(cron = "0 * 1 * * *")
	public void test1(){
		System.out.println("���Զ�ʱ����");
	}
	
	/**
	 * @Date: 2018��1��13�� 16:07:01
	 * @author autoSave
	 * @Title: saveZfzBh  
	 * @Description: 	ÿ��32:50:00ִ��һ��
	 *  <p>1.����Σ������ͳ������;<p>
	 * 	<p>2.�����ٷ���ͳ������;<p>
	 * 	<p>3.����Σ�ճ̶�ͳ������<p>
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
