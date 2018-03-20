package com.hd.jy.oasm.dao.newDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hd.jy.oasm.domain.newDomain.TCrimScaleRelat;
import com.hd.jy.oasm.domain.newDomain.TQuestion;
import com.hd.jy.oasm.domain.newDomain.TScaleConf;
import com.hd.jy.oasm.domain.newDomain.Tdmin;
import com.hd.jy.oasm.domain.newDomain.TdminfactorRelat;
import com.hd.jy.oasm.domain.newDomain.Tfactor;
import com.hd.jy.oasm.domain.newDomain.Tscale;

/**
 * 维度和因子业务接口 在TdminAndtyzService中调用
 * @author quite
 *
 */
public interface TdminAndtyzDao {
	//*************************维度部分**************************************************
   List<Tdmin> listTdmin(); //全查询维度，级联查询使用
	
   int insertTdmin(Tdmin record); // 添加维度
   
   int selectBytdminName(String name); //根据维度名称查询已有的维度，不可重复添加
   
   int updateDimName(Tdmin record); //修改维度名字
   
   //**************************因子部分**************************************************
   int insertTfactor(Tfactor record); //添加因子
   
   int chckHaveFname(String name); //验证因子名
   
   int checkBytfactorName(@Param("name") String name,@Param("dimId") int dimId); //根据因子的名称查询是否已有因子，不可重复添加
   
   int selectByfactorName(String name); //根据因子名称查询因子编号
   
   int updateFactorName(Tfactor record); //根据因子编号修改名字
   
   //***********************维度因子共同部分******************************************************************
   int checkDimIdFId(@Param("dimId") int dimId,@Param("fId") int fId); //验证因子和维度关系
   
   List<Tfactor> listFactorBydminId(int dimId); //根据维度编号列出所有的因子
   
   int insertwdAndyzRelat(TdminfactorRelat record); // 插入维度和因子关系
   
   List<TdminfactorRelat> selectDimAndFactor();//显示因子和维度的关系,不需要分页
   
   int updateWdAndYzRelat(Map<String,Object> map); //根据编号修改因子和维度关系
   
   //***********************问题部分************************************************************
   int insertQuestion(TQuestion record); //添加问题，把维度也关联添加进去
   
   int removeQuestion(Integer qId);
   
   //*********************使用因子维度和问题生成量表部分******************************************************************
   List<TQuestion> allQuestion(String orgId); //根据监狱编号动态查询所有的问题
   
   int checkScaleName(String name); //验证量表名字是否存在

   int insertTscale(Tscale record); //添加到量表
   
   List<Tscale> scaleAllList();  //列出所有的列表，在配置量表时使用，显示已启用的
   
   List<Tscale> scaleAllListStatus(); //列出所有的列表，包括以启用和未启用的
   
   //*********************量表配置部分***************************************************************
   int checkConfName(String name); //验证匹配配置名字是否存在
   
   int insertScaleConf(TScaleConf record); //添加量表配置
   
   List<TScaleConf> scaleConfList(); //列出所有量表配置项
   
   int insertTCrimScaleRelat(TCrimScaleRelat record);//添加囚犯量表配置
   
   
   //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   //***************************正式评估开始*******************************************************
   //++++++++++++++++++++++++++++在ZuoTiServce层调用++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   
   TCrimScaleRelat crimScaleRelatByTaskId(String taskId); //通过显示的囚号获取量表配置的关系的配置量表项
   
   Tscale getScaleByScaleId(int id); //通过量表id获取到量表中的问题，选项，维度，因子，权重*分数
   
}
