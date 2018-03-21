package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.ViewDasjfx;

/***
 * 
 * @author quite
 *访谈调查和行为观察业务接口
 */
public interface ViewftjgAndxwgcDao{ 
	
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
