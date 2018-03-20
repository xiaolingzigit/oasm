package com.hd.jy.oasm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.domain.VPgbgList;
import com.hd.jy.oasm.services.VPgbgListService;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;
/**
 * 显示评估报告列表，操作评估报告控制层
 * @author ljy
 *
 */
@Controller
@RequestMapping("pgbgView")
public class PGBGViewController {
	private static Logger logger = Logger.getLogger(PGBGViewController.class);
	
	@Autowired
	private VPgbgListService vPgbgListService;
	
	//当前类获取警号公用方法
		 public static String getJhinfo(){
			  Subject currentUser = SecurityUtils.getSubject();
			  String jh = (String) currentUser.getPrincipal(); // 得到警号
			  return jh;
	  }
		
	
	/***
	 * 显示评估报告
	 * @auto ljy
	 * @param pageNum
	 * @param pageSize
	 * @param type  各个阶段的报告
	 * @returna
	 * 下午4:54:46
	 * HashMap<Object,Object>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "/getViewPgbg" , method = {RequestMethod.GET,RequestMethod.POST})
	public Map<Object,Object> getViewPgbg(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,@Param("type") String type,
			@Param("gyjq") String gyjq,@Param("qh") String qh,@Param("xm") String xm,@Param("jhxm") String jhxm,@Param("eval") String eval,@Param("stat") String stat){
		String jh = getJhinfo();
		logger.info("【关押监区"+gyjq+"】，【入监评估囚号"+qh+"】，【报告类型"+type+"】，【囚号"+qh+"】，【姓名"+xm+"】，【警号姓名"+jhxm+"】，【危险等级"+eval+"】，【状态"+stat+"】");
		List<VPgbgList> viewPgbg = null;
		Map<Object,Object> pgMap =new  HashMap<>();
		Map<String,Object> map = new HashMap<>();
		
		try {
			PageHelper.startPage(pageNum, pageSize);
			map.put("jh", jh);
			map.put("type", type.trim());
			map.put("gyjqmc", gyjq.trim());
			map.put("crim_no", qh.trim());
			map.put("xm", xm.trim());
			map.put("jhxm", jhxm.trim());
			map.put("levl", eval.trim());
			map.put("stat", stat);
			viewPgbg = vPgbgListService.getViewPgbg(map);
			Page page = PageHelper.endPage();
			pgMap.put("viewPgbg", viewPgbg);
			pgMap.put("page", page);
		} catch (Exception e) {
			logger.error("PGBGViewController.getViewPgbg方法出错"+e);
		}
		return pgMap;
	}
	
	/***
	 * 显示评估报告里面的内容
	 * @auto quite
	 * @param taskId
	 * @returna
	 * 上午10:29:08
	 * String
	 */
	@ResponseBody
	@RequestMapping(value="/pgbgDataView",method={RequestMethod.GET,RequestMethod.POST})
	public String pgbgDataView(int bgstu,String taskId){
		String note = null;
		try {
			note = vPgbgListService.getPgbgTestNote(bgstu,taskId.trim()); //传到页面的json数据
			logger.info("返回前端数据"+note);
		} catch (Exception e) {
			logger.error("通用的评估报告内容显示失败，请稍后重试...");
		}
		return note;
	}
	
	/**
	 * @Date: 2017年12月25日 上午11:50:27
	 * @author liangjiaying
	 * @Title: getLsPgbg   
	 * @Description: 显示个人历史评估报告   
	 * @param: @param qh
	 * @param: @return      
	 * @return: List<VPgbgList>      
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value="/getLsPgbg",method={RequestMethod.GET,RequestMethod.POST})
	public List<VPgbgList> getLsPgbg(String qh){
		
		List<VPgbgList> lsPgbg = null;
		try {
//			if(qh.trim()!=null){
				lsPgbg = vPgbgListService.getLsPgbg(qh.trim());
//			}
//			return lsPgbg;
		} catch (Exception e) {
			logger.error("PGBGViewController#getLsPgbg出错："+e);
		}
		return lsPgbg;
	}
	
	
	
	/**
	 * 
	 * @Date: 2018年1月8日 下午5:23:21
	 * @author liangjiaying
	 * @Title: listViewPgbgAndTCzsh   
	 * @Description: TODO   
	 * @param: @param pageNum
	 * @param: @param pageSize
	 * @param: @param type
	 * @param: @param gyjq
	 * @param: @param qh
	 * @param: @param xm
	 * @param: @param jhxm
	 * @param: @param eval
	 * @param: @param stat
	 * @param: @param czgz
	 * @param: @param hy
	 * @param: @param wpyj
	 * @param: @return      
	 * @return: Page      
	 * @throws
	 */
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "/listViewPgbgAndTCzsh" , method = {RequestMethod.GET,RequestMethod.POST})
	public Page listViewPgbgAndTCzsh(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,
			@Param("type") String type,@Param("gyjq") String gyjq,@Param("qh") String qh,
			@Param("xm") String xm,@Param("jhxm") String jhxm,@Param("eval") String eval,
			@Param("stat") String stat,@Param("czgz") String czgz,@Param("hy") String hy,
			@Param("wpyj") String wpyj){
		String jh = getJhinfo();
		logger.info("【关押监区"+gyjq+"】，【入监评估囚号"+qh+"】，【报告类型"+type+"】，【囚号"+qh+"】，【姓名"+xm+"】，【警号姓名"+jhxm+"】，【危险等级"+eval+"】，【状态"+stat+"】，【处置状态"+czgz+"】，【合议状态"+hy+"】，【危评状态"+wpyj+"】");
		Map<String,Object> map = new HashMap<>();
		Page page = null;
		try {
			PageHelper.startPage(pageNum, pageSize);
			map.put("jh", jh);
			map.put("type", type.trim());
			map.put("gyjqmc", gyjq.trim());
			map.put("crim_no", qh.trim());
			map.put("xm", xm.trim());
			map.put("jhxm", jhxm.trim());
			map.put("levl", eval.trim());
			map.put("stat", stat);
			if("1".equals(czgz)){
				map.put("czlrsj", czgz.trim());
			}else{
				map.put("czlrsj", "");
			}
			if("1".equals(hy)){
				map.put("jqshsj", hy.trim());
			}else{
				map.put("jqshsj", "");
			}
			if("1".equals(wpyj)){
				map.put("wpclsj", wpyj.trim());
			}else{
				map.put("wpclsj", "");
			}
			vPgbgListService.listViewPgbgAndTCzsh(map);
			page = PageHelper.endPage();
		} catch (Exception e) {
			logger.error("PGBGViewController.getViewPgbg方法出错"+e);
		}
		return page;
	}

}






