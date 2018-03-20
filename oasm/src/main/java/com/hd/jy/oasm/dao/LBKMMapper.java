package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.LBCJ;
import com.hd.jy.oasm.domain.LBKM;
import com.hd.jy.oasm.domain.LBRC;
import com.hd.jy.oasm.domain.LBRJ;
import com.hd.jy.oasm.domain.LBZQ;
import com.hd.jy.oasm.domain.WD;
/**
 * 
 * @author quite
 *量表库业务接口 继承BaseDao全查询方法
 *
 *其中lbrj、lbrc、lbzq、lbcj的业务层集成在lbkm中
 */
public interface LBKMMapper extends BaseDao<LBKM>{
    int deleteByPrimaryKey(String lbbh);

    int insert(LBKM record);

    int insertSelective(LBKM record);

    LBKM selectByPrimaryKey(String lbbh);

    int updateByPrimaryKeySelective(LBKM record);

    int updateByPrimaryKey(LBKM record);
    
    List<LBKM> rjlbtmyz(String fl);  //入监量表根据fl选出要答题的题目因子
    
    List<LBKM> rclbtmyz(String fl);  //日常量表根据分类选出要答题的题目因子
    
    List<LBKM> zqlbtmyz(String fl); //中期量表分类选中要答题的题目因子
    
    List<LBKM> cjlbtmyz(String fl);  //出监量表根据分类要答题的题目因子
    
    int closeOrstartLBKMisLive(String lbbh);  //关闭已启用的量表
    
    List<WD> selectAllWd(); 		//查询维度

    List<LBKM> selectRDLB(String str); //查询显示某个阶段的量表名
    
    //*************************计算录入因子的分数和显示因子的部分*************************************************************
    LBRJ selectRjyzAndfsByyzbm(int yzbm);  //根据入监录入的因子计算分数  在ZuoTiService层调用
    
    LBRC selectRcyzAndfsByyzbm(int yzbm);  //日常因子编码计算单个因子和分数
    
    LBZQ selectZqyzAndfsByyzbm(int yzbm); //中期因子编码计算单个因子和分数
    
    LBCJ selectCjyzAndfsByyzbm(int yzbm); //出监因子编码计算单个因子和分数
    
    
    
    
  
}