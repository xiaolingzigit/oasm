package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.ViewDasjfx;
import com.hd.jy.oasm.domain.Viewcjjgft;
import com.hd.jy.oasm.domain.Viewcjxwgc;
import com.hd.jy.oasm.domain.Viewrcxwgc;
import com.hd.jy.oasm.domain.Viewrjjgft;
import com.hd.jy.oasm.domain.Viewrjxwgc;
import com.hd.jy.oasm.domain.Viewzqjgft;
import com.hd.jy.oasm.domain.Viewzqxwgc;

/***
 * 
 * @author quite
 *访谈调查和行为观察业务接口
 */
public interface ViewftjgAndxwgcDao{ 
	//*************************页面根据警号查询结构访谈****************************************************
	List<Viewrjjgft> showViewrjjgft(String jh);  //根据警号显示入监访谈调查视图
	
	List<Viewzqjgft> showViewzqjgft(String jh);   //根据警号显示中期访谈调查视图
	
	List<Viewcjjgft> showViewcjjgft(String jh);    //根据警号显示出监访谈调查视图
	
	//*************************页面根据警号查询行为观察*****************************************************
	List<Viewrjxwgc> findViewrjxwgc(String jh);   //根据警号显示入监访谈结构视图
	
	List<Viewrcxwgc> findViewrcxwgc(String jh);   //根据警号显示入监访谈结构视图
	
	List<Viewzqxwgc> findViewzqxwgc(String jh);   //根据警号显示入监访谈结构视图
	
	List<Viewcjxwgc> findViewcjxwgc(String jh);   //根据警号显示入监访谈结构视图
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//*********************处理档案分析数据部分**********************************************************
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * 通过查询档案数据的信息 在ZuoTiSvervice接口逻辑接口中调用 找Viewftjg.xml
	 * 
	 * @auto quite
	 * @returna
	 * 下午2:24:31
	 * List<ViewDasjfx>
	 */
	List<ViewDasjfx> seachDasjfxByBh();  //入监，日常，出监档案分析
	
	List<ViewDasjfx> tbgzDasjfxByBh(String bh); //通过囚号获取多个特别关注代码
	
	List<ViewDasjfx> cjDasjfxByRelat(); //出监档案分析
	
	
}
