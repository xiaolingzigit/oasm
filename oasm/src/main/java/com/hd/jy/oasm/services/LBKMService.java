package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.LBKM;

import com.hd.jy.oasm.domain.WD;
import com.hd.jy.oasm.domain.ZCYCYQPC;
/**
 * 
 * @author quite
 *量表库操作逻辑接口，包括全查询方法
 */
public interface LBKMService {
	public List<LBKM> selectAllkm(); //查询显示所有的量表库名
	
	public List<LBKM> selectRDLB(String str); //查询显示某个阶段的量表名
	
	
    
    
    public List<LBKM> cjlbtmyz(String fl);  //出监量表根据分类要答题的题目因子
	
	public int closeOrstartLBKMisLive(String lbbh);  //关闭或启用量表
	    
	public List<WD> selectAllWd();	//查询所有维度
	
	public List<ZCYCYQPC> selectYCYQ(String yqztbh); //根据String类型的囚号查询异常狱情
	
	//********************************************************
	public String scaleRelatById(int scaleId); //根据量表编号查询因子和维度，在后台量表详情使用
}
