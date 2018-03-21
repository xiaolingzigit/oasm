package com.hd.jy.oasm.services;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.newDomain.Viewpggl;

public interface ViewftjgAndxwgcService {
	
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//***************调用v_pggl视图	，可对入监，日常，中期，出监视图数据进行展示*******************
		    
		public List<Viewpggl> cjjgftViewpggl(Map<String,Object> map);//出监访谈动态数据视图
		    
		public List<Viewpggl> cjxwgcViewpggl(Map<String,Object> map);//出监观察动态数据视图
		
}
