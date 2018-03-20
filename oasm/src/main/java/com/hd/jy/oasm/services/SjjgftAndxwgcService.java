package com.hd.jy.oasm.services;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.domain.ViewDafxjg;

/***
 * 
 * @author quite
 *结构访谈和行为观察逻辑接口
 *
 *交由SjjgftAndxwgcServiceImpl逻辑实现类处理
 */
public interface SjjgftAndxwgcService {
  //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 //***************************档案分析数据部分****************************************
		/***
		 * 1.全查询已经有的档案分析数据,可用于代替原来的档案分析数据
		 * 2.根据事件编号获取档案分析结果里面的json数据
		 * 在dafxViewController中调用
		 * @auto quite
		 * @param jcdaid
		 * @returna
		 * 下午2:43:37
		 * Sjdafx
		 */
		public TestNote searchDafxjg(String jcdaid); //1
		
		public List<ViewDafxjg> selectDafxjgbg(Map<String,Object> map); //全查询档案分析结果列表视图，页面列表显示
		
}
