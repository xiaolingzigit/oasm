package com.hd.jy.oasm.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.newDomain.TCrimScaleRelat;
import com.hd.jy.oasm.domain.newDomain.TQuestion;
import com.hd.jy.oasm.domain.newDomain.TScaleConf;
import com.hd.jy.oasm.domain.newDomain.Tdmin;
import com.hd.jy.oasm.domain.newDomain.TdminfactorRelat;
import com.hd.jy.oasm.domain.newDomain.Tfactor;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.domain.newDomain.Twdyzgx;
import com.hd.jy.oasm.domain.newDomain.Tysk;
/**
 * 维度和因子逻辑接口，TdminAndtyzServiceImpl实现类
 * @author quite
 *
 */
public interface TdminAndtyzService {
	public int insertTdmin(Tdmin record); // 添加维度
	
    public List<Tdmin> listTdmin(); //全查询维度，级联查询使用
	
	public int selectBytdminName(String name); //根据维度名称查询已有的维度，不可重复添加
	
	public int updateDimName(Tdmin record); //修改维度名字
	
	
	
	public int insertTfactor(Tfactor record); //添加因子
	
	public int chckHaveFname(String name); //验证因子名
	
	public int checkBytfactorName(String name,int dimId); //根据因子的名称查询是否已有因子，不可重复添加
	
	public int selectByfactorName(String name); //根据因子名称查询因子编号
	
	public int updateFactorName(Tfactor record); //根据因子编号修改名字
	
	
	public int checkDimIdFId(int dimId,int fId); //根据因子和维度编号验证关系
	
	public List<Tfactor> listFactorBydminId(int dimId); //根据维度编号列出所有的因子
	
	public int insertwdAndyzRelat(TdminfactorRelat record); // 插入维度和因子关系
	
	public List<TdminfactorRelat> selectDimAndFactor();//显示因子和维度的关系,不需要分页
	
	public int updateWdAndYzRelat(Map<String,Object> map); //根据编号修改因子和维度关系
	
	
	public int insertQuestion(TQuestion record); //添加问题，把维度也关联添加进去
	
	public int removeQuestion(Integer qId); //删除问题
	
	public String allQuestion(String orgId); //根据监狱编号动态查询所有的问题
	
	
	public int checkScaleName(String name); //验证量表名字是否存在
	
	public int insertTscale(Tscale record); //添加到量表
	
	public List<Tscale> scaleAllList();  //列出所有的列表，在配置量表时使用
	
	public List<Tscale> scaleAllListStatus(); //列出所有的列表，包括以启用和未启用的
	
	
	public int checkConfName(String name); //验证匹配名字是否存在
	
	public int insertScaleConf(TScaleConf record); //添加量表配置
	
	public int insertTCrimScaleRelat(TCrimScaleRelat record);//添加囚犯量表配置
	
	public List<TScaleConf> scaleConfList(); //列出所有量表配置项
	
	//***调用存储过程，返回一个囚号得到，绑定量表配置和罪犯的关系***/
	public int useProduceForScaleConf(String creator,Date crTime,Date lastModif,String modifer,int status);
	
	/******************************以下为修改的因子和维度部分************************************************/
	public int addTysk(Tysk tysk); //添加因子或者维度
	
	public int addTwdyzgx(Twdyzgx record); //添加因子维度关系
	
	public int updateTysk(Tysk tysk); //修改因子或者维度
	
	public List<Tysk> likeSomeWdKey(Map<String,String> map); //检索一些维度
	
	public List<Tysk> likeSomeTyskKey(Map<String,String> map); //检索一些因子
	
	public List<Tysk> likeTyskKey(Map<String,String> map); //检索维度或者因子
}
