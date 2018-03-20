package com.hd.jy.oasm.services;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.ViewDasjfx;
import com.hd.jy.oasm.domain.Viewcjjgft;
import com.hd.jy.oasm.domain.Viewcjxwgc;
import com.hd.jy.oasm.domain.Viewrcxwgc;
import com.hd.jy.oasm.domain.Viewrjjgft;
import com.hd.jy.oasm.domain.Viewrjxwgc;
import com.hd.jy.oasm.domain.Viewzqjgft;
import com.hd.jy.oasm.domain.Viewzqxwgc;
import com.hd.jy.oasm.domain.newDomain.Viewpggl;

public interface ViewftjgAndxwgcService {
	//*************************页面根据警号查询结构访谈****************************************************
		public List<Viewrjjgft> showViewrjjgft(String jh);  //根据警号显示入监访谈调查视图
		
		public List<Viewzqjgft> showViewzqjgft(String jh);   //根据警号显示中期访谈调查视图
		
		public List<Viewcjjgft> showViewcjjgft(String jh);    //根据警号显示出监访谈调查视图
		
		//*************************页面根据警号查询行为观察*****************************************************
		public List<Viewrjxwgc> findViewrjxwgc(String jh);   //根据警号显示入监访谈结构视图
		
		public List<Viewrcxwgc> findViewrcxwgc(String jh);   //根据警号显示入监访谈结构视图
		
		public List<Viewzqxwgc> findViewzqxwgc(String jh);   //根据警号显示入监访谈结构视图
		
		public List<Viewcjxwgc> findViewcjxwgc(String jh);   //根据警号显示入监访谈结构视图
		
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//*****************************以上代码废弃************************************************************
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//***************调用v_pggl视图	，可对入监，日常，中期，出监视图数据进行展示*******************
		public List<Viewpggl> rjjgftViewpggl(Map<String,Object> map); //根据入监结构访谈登录的关联警号动态查询视图
		
		public List<Viewpggl> rjxwgcViewpggl(Map<String,Object> map); //根据入监行为观察警号动态查询视图
		
		public List<Viewpggl> rcxwgcViewpggl(Map<String,Object> map); //日常行为观察动态视图
		    
		public List<Viewpggl> zqjgftViewpggl(Map<String,Object> map);//中期访谈动态数据视图
		    
		public List<Viewpggl> zqxwgcViewpggl(Map<String,Object> map); //中期观察动态数据视图
		    
		public List<Viewpggl> cjjgftViewpggl(Map<String,Object> map);//出监访谈动态数据视图
		    
		public List<Viewpggl> cjxwgcViewpggl(Map<String,Object> map);//出监观察动态数据视图
		
}
