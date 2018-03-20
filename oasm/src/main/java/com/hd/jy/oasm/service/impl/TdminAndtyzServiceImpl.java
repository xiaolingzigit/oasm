package com.hd.jy.oasm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.TzyrymdMapper;
import com.hd.jy.oasm.dao.newDao.TdminAndtyzDao;
import com.hd.jy.oasm.dao.newDao.TyskAndwdDao;
import com.hd.jy.oasm.domain.Tzyrymd;
import com.hd.jy.oasm.domain.newDomain.Question;
import com.hd.jy.oasm.domain.newDomain.SystemConfig;
import com.hd.jy.oasm.domain.newDomain.Question.Option;
import com.hd.jy.oasm.domain.newDomain.TCrimScaleRelat;
import com.hd.jy.oasm.domain.newDomain.TQuestion;
import com.hd.jy.oasm.domain.newDomain.TScaleConf;
import com.hd.jy.oasm.domain.newDomain.Tdmin;
import com.hd.jy.oasm.domain.newDomain.TdminfactorRelat;
import com.hd.jy.oasm.domain.newDomain.Tfactor;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.domain.newDomain.Twdyzgx;
import com.hd.jy.oasm.domain.newDomain.Tysk;
import com.hd.jy.oasm.services.TdminAndtyzService;
import com.hd.jy.oasm.util.date.DateUtil;
import com.hd.jy.oasm.util.lsc.GsonUtil;
/**
 * 维度和因子逻辑接口实现类
 * @author quite
 *
 */
@Service("tdminAndtyzServiceImpl")
@DataSource("userDataSource")
public class TdminAndtyzServiceImpl implements TdminAndtyzService {
     private Logger log = Logger.getLogger(TdminAndtyzServiceImpl.class);
     
     @Autowired
     private TdminAndtyzDao tdminAndzyDao; //调用维度和因子业务接口
     
     @Autowired
     private TzyrymdMapper tzyrymdDao;  //调用在押人员名单的业务接口里面的存储过程
     
     @Autowired
     private TyskAndwdDao tyskAndwdDao; //因子维度设计重新修改
	
     private String logDate = DateUtil.getTime(new Date()); //定义日志输出时间
     
	@Override
	public int insertTdmin(Tdmin record) {//添加维度
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(record!=null){
				log.info("开始【添加维度时间】"+logDate);
				i = tdminAndzyDao.insertTdmin(record);
			}else{
				log.error("添加维度时【维度为"+record+"】，请重新确认后重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加【维度异常】，请稍后重试..."+e.getMessage());
		}
		return i;
	}

	@Override
	public int insertTfactor(Tfactor record) { //添加因子
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(record!=null){
				log.info("开始【添加因子】时间"+logDate);
				i = tdminAndzyDao.insertTfactor(record);
			}else{
				log.error("添加因子时失败，失败原因【因子为"+record+"】,请确认后重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加【因子异常】，请稍后重试..."+e.getMessage());
		}
		return i;
	}

	
	@Override
	public int selectBytdminName(String name) {//验证维度名称
		// TODO Auto-generated method stub
		int i = 0;
		try {
				log.info("开始验证【维度名称时间】"+logDate);
			if(name!=null&&name!=""){
				i = tdminAndzyDao.selectBytdminName(name);
				log.info("成功根据【维度名称"+name+"】验证的结果为"+i);
			}else{
				log.error("验证【维度名称】时失败，维度名称为"+name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("验证【维度名称】异常，请稍后重试..."+e.getMessage());
		}
		return i;
	}

	@Override
	public int checkBytfactorName(String name,int dimId) {//验证因子名称
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(name!=null&&name!=""){
				log.info("开始进行【验证因子名称】操作时间"+logDate);
				i = tdminAndzyDao.checkBytfactorName(name,dimId);
				log.info("成功【验证因子名称"+name+"】,返回结果为"+i);
			}else{
				log.error("【验证因子名称】时失败，因子名称为"+name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("【验证因子名称】异常，请稍后重试..."+e.getMessage());
		}
		return i;
	}

	@Override
	public List<Tdmin> listTdmin() {  //*****************列出所有维度*************************
		// TODO Auto-generated method stub
		List<Tdmin> tdmin = null;
		try {
			log.info("开始【列出所有维度】时间"+logDate);
			tdmin = tdminAndzyDao.listTdmin();
			log.info("成功列出所有维度数据"+tdmin.size()+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询所有维度异常，请稍后再试..."+e.getMessage());
		}
		return tdmin;
	}

	@Override
	public List<Tfactor> listFactorBydminId(int dimId) { //*********根据维度编号列出所有因子**********************
		// TODO Auto-generated method stub
		List<Tfactor> factorBydminId = null;
		try {
			log.info("开始根据【维度编号"+dimId+"】查询【因子列表】时间"+logDate);
			factorBydminId = tdminAndzyDao.listFactorBydminId(dimId);
			log.info("成功根据【维度编号"+dimId+"】查出因子"+factorBydminId.size()+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据【维度编号"+dimId+"】查询因子异常,请稍后重试..."+e.getMessage());
		}
		return factorBydminId;
	}

	@Override
	public int insertwdAndyzRelat(TdminfactorRelat record) { //************插入因子和维度关系*******************
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(record!=null){
				log.info("开始根据插入因子和维度关系时间"+logDate);
				i = tdminAndzyDao.insertwdAndyzRelat(record);
				log.info("成功添加因子和维度关系"+i+"个");
			}else{
				log.error("添加因子和维度关系失败，请确认后重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("插入因子和维度关系异常，请重试..."+e.getMessage());
		}
		return i;
	}

	//***********************添加问题*********************************
	@Override
	public int insertQuestion(TQuestion record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始【添加问题】时间"+logDate);
			i = tdminAndzyDao.insertQuestion(record);
			log.info("成功添加问题数量"+i+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加问题异常，请重试..."+e.getMessage());
		}
		return i;
	}

	//*************************添加量表****************************************
	@Override
	public int insertTscale(Tscale record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始【添加量表】时间"+logDate);
			i = tdminAndzyDao.insertTscale(record);
			log.info("成功添加量表数量"+i+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加量表异常，请重试..."+e.getMessage());
		}
		return i;
	}

	//*******************************添加量表配置*************************************************
	@Override
	public int insertScaleConf(TScaleConf record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始【添加量表配置】时间"+logDate);
			i = tdminAndzyDao.insertScaleConf(record);
			log.info("成功添加量表配置个数"+i+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加量表配置异常，请重试..."+e.getMessage());
		}
		return i;
	}

	//********************************添加量表-囚犯配置****************************************************
	@Override
	public int insertTCrimScaleRelat(TCrimScaleRelat record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始【添加量表-囚号配置】时间"+logDate);
			i = tdminAndzyDao.insertTCrimScaleRelat(record);
			log.info("成功添加量表-囚号");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加量表-囚号异常，请重试..."+e.getMessage());
		}
		return i;
	}

	//根据因子名字查询因子编号
	@Override
	public int selectByfactorName(String name) {
		// TODO Auto-generated method stub
		int fid = 0;
		try {
			log.info("开始根据【因子姓名"+name+"】查询时间"+logDate);
			fid = tdminAndzyDao.selectByfactorName(name);
			log.info("成功查询出因子编号"+fid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fid;
	}

	//查询因子和维度的关系列表
	@Override
	public List<TdminfactorRelat> selectDimAndFactor() {
		// TODO Auto-generated method stub
		List<TdminfactorRelat> dimAndFactor = null;
		try {
			log.info("开始【全查询维度和因子的关系列表】时间"+logDate);
			dimAndFactor = tdminAndzyDao.selectDimAndFactor();
			log.info("成功查询出维度和因子的关系列表"+dimAndFactor.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询维度和因子关系异常，请重试..."+e.getMessage());
		}
		return dimAndFactor;
	}

	//根据监狱号动态查询问题列表的数据
	@Override
	public String allQuestion(String orgId) {
		// TODO Auto-generated method stub
		List<Question> queList = new ArrayList<>();
		List<TQuestion> question = null;
		Question que = null; //新建一个Question的json对象
		String optionJSON = null;
		try {
			log.info("开始根据【监狱号"+orgId+"查询列表问题】时间"+logDate);
			question = tdminAndzyDao.allQuestion(orgId);
			
			for (TQuestion tq : question) {
				que = new Question();
				que.setqId(tq.getQstId()); //问题编号
				que.setType(String.valueOf(tq.getType())); //单选多选
				que.setqName(tq.getQuestion());//问题
				que.setOrgId(tq.getOrgId());//监狱号
				que.setqRemark(tq.getRemark());//判断依据
				que.setDimId(tq.getDimId()); //维度名称
				que.setDimName(tq.getTdmin().getDimName());
				
				String[] splitOptions = tq.getOptions().split("%%");
				List<Option> options = new  ArrayList<>();
				for (int i = 0; i < splitOptions.length; i++) {
					log.info("分割%%之后的选项值：【"+splitOptions[i]+"】");
					String option = splitOptions[i]; //单个的数组
					String[] splitOption = option.split("#");
				    Option op = new Option(splitOption[0], splitOption[1], splitOption[2], splitOption[3],null);
				    options.add(op);
				   
				}
				
				que.setOptions(options);
				queList.add(que);
			}
			optionJSON = GsonUtil.toJson(queList);
			
//			log.info("格式化之后的数据"+optionJSON);
			log.info("成功列出问题列表数据"+question.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据【监狱号"+orgId+"】显示问题列表异常，请重试..."+e.getMessage());
		}
		return optionJSON;
		
	}

	//验证量表名字和量表是否存在
	@Override
	public int checkScaleName(String name) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(name!=null&&name!=""){
				log.info("开始根据【量表名字"+name+"】时间"+logDate);
				i = tdminAndzyDao.checkScaleName(name);
				log.info("根据量表名字匹配出量表名字"+i+"");
			}else{
				log.error("量表名字为【"+name+"】,匹配失败，请重新确认后重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据【量表名字"+name+"】匹配名字异常，请重试..."+e.getMessage());
		}
		return i;
	}

	//验证配置名字
	@Override
	public int checkConfName(String name) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			if(name!=null&&name!=""){
				log.info("开始根据配置名字【"+name+"】匹配时间"+logDate);
				i = tdminAndzyDao.checkConfName(name);
				log.info("成功匹配出匹配名字"+i+"个");
			}else{
				log.error("配置名字为【"+name+"】,请确认之后重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("匹配配置名字异常，请重试..."+e.getMessage());
		}
		return i;
	}

	//列出所有量表的量表编号，量表名字，量表类型，在添加配置时使用
	@Override
	public List<Tscale> scaleAllList() {
		// TODO Auto-generated method stub
		List<Tscale> scaleAllList = null;
		try {
			log.info("在添加配置时【列出所有的量表】时间"+logDate);
			scaleAllList = tdminAndzyDao.scaleAllList();
			log.info("成功列出所有配置时需要的量表列表数据"+scaleAllList.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("列出所有配置时需要的量表数据异常，请重试..."+e.getMessage());
		}
		return scaleAllList;
	}

	//列出所有量表配置关系
	@Override
	public List<TScaleConf> scaleConfList() {
		// TODO Auto-generated method stub
		List<TScaleConf> confList = null;
		try {
			log.info("开始所有【量表配置关系】时间"+logDate);
			confList = tdminAndzyDao.scaleConfList();
			log.info("成功列出的量表配置关系数据"+confList.size()+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("列出量表配置关系异常，请重试...");
		}
		return confList;
	}

	@Override
	public int useProduceForScaleConf(String creator, Date crTime, Date lastModif, String modifer, int status) {
		// TODO Auto-generated method stub
		SystemConfig config = new SystemConfig();
		TCrimScaleRelat csr = null;
		int i = 0;
		try {
			log.info("开始调用存储过程获取导入在押罪犯囚号时间"+logDate);
			List<Tzyrymd> zyyrymdProduce = tzyrymdDao.useZyyrymdProduce();
			if(zyyrymdProduce.size()>0){
				for (Tzyrymd tzyrymd : zyyrymdProduce) {
					csr = new TCrimScaleRelat();
					csr.setCrimNo(tzyrymd.getQh()); //获取囚号
					log.info("获取全局配置编号:"+Integer.parseInt(config.getConf("CURR_DEF_SCALE")));
					csr.setSconfId(Integer.parseInt(config.getConf("CURR_DEF_SCALE"))); //获取全局配置
					csr.setCrTime(crTime);
					csr.setCreator(creator);
					csr.setModifier(modifer);
					csr.setLastModif(lastModif);
					csr.setStatus(status);
					
					i = tdminAndzyDao.insertTCrimScaleRelat(csr);
				}
			}else{
				log.error("使用存储过程调用囚号失败，执行存储过程获取囚号的个数为【"+zyyrymdProduce.size()+"】");
				return i;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("给罪犯添加量表配置异常，请重试..."+e.getMessage());
		}
		
		return i;
	}

	//列出所有已启用和未启用的量表 在LBKController操作
	@Override
	public List<Tscale> scaleAllListStatus() {
		// TODO Auto-generated method stub
		List<Tscale> allListStatus = null;
		try {
			log.info("开始【列出所有已启用未启用状态的量表】时间"+logDate);
			allListStatus = tdminAndzyDao.scaleAllListStatus();
			log.info("成功列出所有已启用未启用的量表数据"+allListStatus.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("列出已启用未启用的量表数据失败，请重试..."+e.getMessage());
		}
		return allListStatus;
	}

	/**
	 * 删除问题
	 * @author quite
	 */
	@Override
	public int removeQuestion(Integer qId) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始删除问题选项时间"+logDate);
			if(null!=qId){
				 i = tdminAndzyDao.removeQuestion(qId);
				 log.info("成功删除问题选项"+i+"条数据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("删除问题选项出现异常，请重试..."+e.getMessage(),e);
		}
		return i;
	}

	/**
	 * @ TODO 修改维度名称
	 * @authc quite
	 * @date 2018年1月5日
	 * @see com.hd.jy.oasm.services.TdminAndtyzService#updateDimName(com.hd.jy.oasm.domain.newDomain.Tdmin)
	 */
	@Override
	public int updateDimName(Tdmin record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始修改维度名称时间"+logDate);
			if(null!=record){
				i = tdminAndzyDao.updateDimName(record);
				log.info("成功修改维度名称"+i+"条数据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改维度名称异常，请稍后重试..."+e.getMessage(),e);
		}
		return i;
	}

	/**
	 * @ TODO 修改因子名称
	 * @authc quite
	 * @date 2018年1月5日
	 * @see com.hd.jy.oasm.services.TdminAndtyzService#updateFactorName(com.hd.jy.oasm.domain.newDomain.Tfactor)
	 */
	@Override
	public int updateFactorName(Tfactor record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始修改因子名称时间"+logDate);
			if(null!=record){
				i = tdminAndzyDao.updateFactorName(record);
				log.info("成功修改因子名称"+i+"个数据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改因子名称异常，请稍后重试..."+e.getMessage(),e);
		}
		return i;
	}

	/**
	 * @ TODO 修改维度和因子关系
	 * @authc quite
	 * @date 2018年1月5日
	 * @see com.hd.jy.oasm.services.TdminAndtyzService#updateWdAndYzRelat(com.hd.jy.oasm.domain.newDomain.TdminfactorRelat)
	 */
	@Override
	public int updateWdAndYzRelat(Map<String,Object> map) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始修改维度和因子关系时间"+logDate);
			if(null!=map){
				i = tdminAndzyDao.updateWdAndYzRelat(map);
				log.info("成功修改维度和因子关系"+i+"条数据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改维度和因子关系异常，请重试..."+e.getMessage(),e);
		}
		return i;
	}
   
	/*
	 * (非 Javadoc)
	* @authc quite
	* <p>Title: chckHaveFname</p>
	* <p>Description: 验证因子名称</p>
	* @param name
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#chckHaveFname(java.lang.String)
	 */
	@Override
	public int chckHaveFname(String name) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始验证因子名称时间【"+logDate+"】，【参数"+name+"】");
			if(null!=name){
				i = tdminAndzyDao.chckHaveFname(name);
				log.info("返回验证成功数据，显示已有因子"+i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("验证因子异常，请稍后重试..."+e.getMessage(),e);
		}
		return i;
	}

	/* (非 Javadoc)
	* @authc quite
	* <p>Title: checkDimIdFId</p>
	* <p>Description: </p>
	* @param dimId
	* @param fId
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#checkDimIdFId(int, int)
	*/
	@Override
	public int checkDimIdFId(int dimId, int fId) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始验证因子和维度关系是否存在时间"+logDate);
			i = tdminAndzyDao.checkDimIdFId(dimId, fId);
			log.info("验证到因子和维度关系的个数有"+i+"个数据");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("验证因子和维度关系异常，请重试..."+e.getMessage(),e);
		}
		return i;
	}

	/***************************以下部分为因子和维度设计修改**************************************************/
	/* 
	* @authc quite
	* <p>Title: addTysk</p>
	* <p>Description: 添加因子或者维度</p>
	* @param tysk
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#addTysk(com.hd.jy.oasm.domain.newDomain.Tysk)
	*/
	@Override
	public int addTysk(Tysk tysk) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始添加因子或者维度时间"+logDate);
			if(null!=tysk){
				i = tyskAndwdDao.addTysk(tysk);
			}
			log.info("成功添加因子或者维度数据"+i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加因子或者维度异常，请重试..."+e.getMessage(),e);
		}
		return i;
	}

	/* (非 Javadoc)
	* @authc quite
	* <p>Title: addTwdyzgx</p>
	* <p>Description:添加维度因子关系 </p>
	* @param record
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#addTwdyzgx(com.hd.jy.oasm.domain.newDomain.Twdyzgx)
	*/
	@Override
	public int addTwdyzgx(Twdyzgx record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始添加因子和维度关系时间"+logDate);
			if(null!=record){
				i = tyskAndwdDao.addTwdyzgx(record);
			}
			log.info("成功添加因子和维度关系数据"+i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加因子和维度关系异常"+e.getMessage(),e);
		}
		return i;
	}

	/* (非 Javadoc)
	* @authc quite
	* <p>Title: updateTysk</p>
	* <p>Description:修改维度或者因子关系 </p>
	* @param tysk
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#updateTysk(com.hd.jy.oasm.domain.newDomain.Tysk)
	*/
	@Override
	public int updateTysk(Tysk tysk) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始修改因子或者维度时间"+logDate);
			if(null!=tysk){
				i = tyskAndwdDao.updateTysk(tysk);
			}
			log.info("成功修改因子或者维度数据"+i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改因子或者维度数据异常"+e.getMessage(),e);
		}
		return i;
	}

	/* (非 Javadoc)
	* @authc quite
	* <p>Title: likeSomeWdKey</p>
	* <p>Description: 检索维度</p>
	* @param map
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#likeSomeWdKey(java.util.Map)
	*/
	@Override
	public List<Tysk> likeSomeWdKey(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<Tysk> wdKey = null;
		try {
			log.info("开始单独检索维度时间"+logDate);
			if(null!=map){
				wdKey = tyskAndwdDao.likeSomeWdKey(map);
			}
			log.info("***成功检索维度返回前端数据***"+JSON.toJSON(wdKey));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("单独检索维度异常，请重试..."+e.getMessage(),e);
		}
		return wdKey;
	}

	/* (非 Javadoc)
	* @authc quite
	* <p>Title: likeSomeTyskKey</p>
	* <p>Description:检索因子 </p>
	* @param map
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#likeSomeTyskKey(java.util.Map)
	*/
	@Override
	public List<Tysk> likeSomeTyskKey(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<Tysk> someTyskKey = null;
		try {
			log.info("开始单独检索因子时间"+logDate);
			if(null!=map){
				someTyskKey = tyskAndwdDao.likeSomeTyskKey(map);
			}
			log.info("**成功检索出因子返回前端数据**"+JSON.toJSON(someTyskKey));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("检索因子异常，请重试..."+e.getMessage(),e);
		}
		return someTyskKey;
	}

	/* (非 Javadoc)
	* @authc quite
	* <p>Title: likeTyskKey</p>
	* <p>Description: 检索因子和维度</p>
	* @param map
	* @return
	* @see com.hd.jy.oasm.services.TdminAndtyzService#likeTyskKey(java.util.Map)
	*/
	@Override
	public List<Tysk> likeTyskKey(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<Tysk> tyskKey = null;
		try {
			log.info("开始进行全面检索因子或者维度时间"+logDate);
		if(null!=map){
			tyskKey = tyskAndwdDao.likeTyskKey(map);
		}
		log.info("***成功全面检索出因子或者维度数据***"+JSON.toJSON(tyskKey));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("检索因子或者维度异常，请重试..."+e.getMessage(),e);
		}
		return tyskKey;
	}

}
