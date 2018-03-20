package com.hd.jy.oasm.services;


import com.hd.jy.oasm.domain.BGgtft;
import com.hd.jy.oasm.domain.BGxwgc;
import com.hd.jy.oasm.domain.TestNote;

/***
 * 
 * @author quite
 *做题service接口，包括做题的因子分数计算，统计做题所选的因子，匹配因子分数，题目
 */
public interface ZuoTiSerivce {

    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //**********通过页面上的囚号获取到使用的配置的量表，量表里面的内容问题，维度，因子和权重分数*********************************************************
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   public int autoGuize(); //选择需要进行匹配的档案项，通过规则进行匹配,入监档案分析
   
   public String rjjgftQuestion(String taskId); //通过页面上的任务编号返回入监结构访谈问题列表的字段
   
   public String rjxwgcQuestion(String taskId); //通过任务编号返回入监行为观察访谈问题列表
   
   public String rcxwgcQuestion(String taskId); //通过任务编号得到日常答题需要的因子和维度
   
   public String zqjgftQuestion(String taskId); //通过任务编号获取中期结构访谈需要的因子和问题
   
   public String zqxwgcQuestion(String taskId); //通过任务编号获取中期行为观察需要的因子和维度
   
   public String cjjgftQuestion(String taskId); //通过任务编号获取出监结构访谈需要的因子和问题
   
   public String cjxwgcQuestion(String taskId); //通过任务编号获取出监行为观察需要的因子和维度
   
   public int saveNote(TestNote testNote); //调用TestMapper的添加方法把答题答案记录在里面
   
   public TestNote getNote(String taskId); //根据任务编号查询答题记录
   
   public int saveGtfts(BGgtft record); //保存结构访谈答题记录
	
   public int saveXwgcs(BGxwgc record); //保存行为观察答题记录
   
}
