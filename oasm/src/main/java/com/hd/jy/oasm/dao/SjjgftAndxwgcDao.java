package com.hd.jy.oasm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hd.jy.oasm.domain.LBjcdafx;
import com.hd.jy.oasm.domain.Sjrjjgft;
import com.hd.jy.oasm.domain.ViewDafxjg;

/***
 * 
 * @author quite
 *结构访谈和行为观察答题记录业务接口
 *
 *交由SjjgftAndxwgcService逻辑接口处理
 */
public interface SjjgftAndxwgcDao{ 
	//***************************************结构访谈部分*****************************************
	int rjjgftInsertSelective(Sjrjjgft record); //插入入监结构访谈
	
	//************************start****根据事件编号找到相对应的因子匹配到分数*****同时根据量表库Dao的selectyzAndfsByyzbm方法匹配因子分数*****************************************
	//-------------------------入监部分--------------------------------------
	Sjrjjgft selectByRjjgftidFindYz(String rjjgftid); //根据入监结构访谈事件编号匹配到因子和单个分数 在ZuoTiService.java层调用
	
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//***************************档案分析操作业务接口********************************************************
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	List<ViewDafxjg> selectDafxjgbg(Map<String,Object> map); //全查询档案分析结果列表视图，页面列表显示
	
	LBjcdafx selectMoreDafxParam(@Param("wd")String wd,@Param("fz")int fz); //传入多个参数调用档案分析【量表】 找Sjjgft.xml
	
	/**
	 * 根据囚号显示个人档案分析结果——矫正项目——罪犯信息查询 显示
	 * @auto quite
	 * @param qh
	 * @returna
	 * 下午3:02:49
	 * List<ViewDafxjg>
	 */
	List<ViewDafxjg> crimInfoDafxjg(String qh); 
}
