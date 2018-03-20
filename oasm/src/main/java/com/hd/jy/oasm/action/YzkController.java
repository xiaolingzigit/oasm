package com.hd.jy.oasm.action;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.domain.WD;
import com.hd.jy.oasm.domain.newDomain.TdminfactorRelat;
import com.hd.jy.oasm.domain.newDomain.Twdyzgx;
import com.hd.jy.oasm.domain.newDomain.Tysk;
import com.hd.jy.oasm.services.LBKMService;
import com.hd.jy.oasm.services.TdminAndtyzService;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;

/**
 * 
* @ClassName: YzkController 
* @Description: 因子库管理
* @author liangjiaying
* @date 2017年11月15日 下午10:08:14 
*
 */
@Controller
@RequestMapping("yzk")
public class YzkController {
	
	static final Logger log = Logger.getLogger(YzkController.class);
	
	@Autowired
	private LBKMService lbkService;
	
	@Autowired
	private TdminAndtyzService tdminAndtyzService; //因子和维度操作接口
	
	// 因子库管理与维护
	@RequestMapping(value = "/yzManager")
	public String getAllYzk(Model model){
		List<TdminfactorRelat> dimAndFactor = null;
		try {
			dimAndFactor = tdminAndtyzService.selectDimAndFactor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询因子和维度关系列表失败，请重试...");
		}
		model.addAttribute("dafList", dimAndFactor);
		return "/systemBlank/yzManager";
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectAllWd", method = {RequestMethod.GET,RequestMethod.POST})
	public List<WD> selectAllWd(){
		List<WD> selectAllWd = null;
		try {
			selectAllWd = lbkService.selectAllWd();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("获取维度列表出错"+e);
		}
		return selectAllWd;
	}
	
	/*****************************以下部分为重新设计的因子和维度***********************************************/
	/**
	 * 
	 * @todo TODO 添加因子或者维度
	 * @param ysbh  @param ysmc @param yssx @param sm  @param ytxz @param session
	 * @return
	 * @auth quite
	 * @time 2018年1月12日 下午7:03:40
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/addTysk",method={RequestMethod.GET,RequestMethod.POST})
	public int addTysk(String ysbh,String ysmc,String yssx,String sm,String ytxz,HttpSession session){
		int i = 0;
		Tysk tk = null;
		try {
			String username = (String)session.getAttribute("username");
			log.info("添加因子或维度的【用户名"+username+"】，【编号"+ysbh+"】，【名称"+ysmc+"】，【特质"+yssx+"】，【说明"+sm+"】，【用途"+ytxz+"");
			tk = new Tysk();
			if(null!=username){
				tk.setYsbh(ysbh.trim());
				tk.setYsmc(ysmc.trim());
				tk.setYssx(yssx.trim());
				tk.setSm(sm.trim());
				tk.setYtxz(ytxz.trim());
				tk.setYzfz(1.0);
				tk.setCjsj(new Date());
				tk.setCjrbh(username);
				tk.setXgsj(new Date());
				tk.setXgrbh(username);
				i = tdminAndtyzService.addTysk(tk);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加因子或者维度失败，请先登录用户");
		}
		return i;
	}
	
	/**
	 * 
	 * @todo TODO 添加因子和维度关系
	 * @param wdId  @param yzId @param sm @param session
	 * @return
	 * @auth quite
	 * @time 2018年1月13日 下午4:56:45
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/addaddTwdyzgx",method={RequestMethod.GET,RequestMethod.POST})
	public int addaddTwdyzgx(int wdId,int yzId,String sm,HttpSession session){
		int i = 0;
		try {
			Twdyzgx tw = null;
			String username = (String)session.getAttribute("username");
			log.info("添加因子和维度关系的【维度编号"+wdId+"】，【因子编号"+yzId+"】，【说明"+sm+"】，【用户名"+username+"】");
			if(null!=username){
				tw = new Twdyzgx();
				tw.setWdid(wdId);
				tw.setYzid(yzId);
				tw.setSm(sm);
				tw.setQyzt(1); //启用状态
				tw.setCjsj(new Date());
				tw.setCjrbh(username);
				tw.setXgsj(new Date());
				tw.setXgrbh(username);
				i = tdminAndtyzService.addTwdyzgx(tw);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("添加维度和因子关系失败，请检查管理员登录状态!");
		}
		return i;
	}
	
	/**
	 * 
	 * @todo TODO 分页加检索维度作为添加关系需要
	 * @param pageSize  @param pageNum @param ysbh @param ysmc
	 * @return
	 * @auth quite
	 * @time 2018年1月13日 下午5:09:39
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/likeTWLine",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> likeTWLine(int pageSize,int pageNum,String ysbh,String ysmc){
		log.info("单独检索维度传值:【每页数据"+pageSize+"】【页数"+pageNum+"】【编号"+ysbh+"】【名称"+ysmc+"】");
		Map<String,Object> pmap = new HashMap<String,Object>(); //返回前端使用
		try {
			Map<String,String> map = new HashMap<String,String>(); //传值使用
			map.put("ysbh", ysbh);
			map.put("ysmc", ysmc);
			PageHelper.startPage(pageNum, pageSize);
			tdminAndtyzService.likeSomeWdKey(map);
			@SuppressWarnings("rawtypes")
			Page page = PageHelper.endPage();
			pmap.put("page", page); //数据已经存在page对象中
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("检索维度失败，请重试...");
		}
		return pmap;
	}
	
	/**
	 * 
	 * @todo TODO 分页检索一部分因子作为添加关系需要
	 * @param pageSize @param pageNum @param ysbh @param ysmc
	 * @return
	 * @auth quite
	 * @time 2018年1月13日 下午5:16:42
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/likeSomeYsk",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> likeSomeYsk(int pageSize,int pageNum,String ysbh,String ysmc){
		log.info("单独检索因子传值:【每页数据"+pageSize+"】【页数"+pageNum+"】【编号"+ysbh+"】【名称"+ysmc+"】");
		Map<String,Object> pmap = new HashMap<String,Object>();
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("ysbh", ysbh);
			map.put("ysmc", ysmc);
			PageHelper.startPage(pageNum, pageSize);
			tdminAndtyzService.likeSomeTyskKey(map);
			@SuppressWarnings("rawtypes")
			Page page = PageHelper.endPage();
			pmap.put("page", page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("检索因子失败，请重试...");
		}
		return pmap;
	}
	
	/**
	 * @todo TODO 检索因子和维度
	 * @param pageSize @param pageNum @param ysbh @param ysmc @param yssx @param ytxz @param yzzpc
	 * @param zsxgpc @param xxxgpc @param ttxgpc @param zfzxgpc @param cjsj1 @param cjsj2 @param xgsj1 @param xgsj2
	 * @return
	 * @auth quite
	 * @time 2018年1月13日 下午6:09:59
	 */
	@ResponseBody
	@RequestMapping(value="/likeTyskLine",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> likeTyskLine(int pageSize,int pageNum,String ysbh,String ysmc,String yssx,String ytxz,String yzzpc,String zsxgpc,String xxxgpc,String ttxgpc,String zfzxgpc,String cjsj1,String cjsj2,String xgsj1,String xgsj2){
		log.info("检索因子和维度:【条数"+pageSize+"】，【页数"+pageNum+"】【编号"+ysbh+"】【名称"+ysmc+"】【性质"+yssx+"】【用途"+ytxz+"】");
		log.info("检索因子频次【总频次"+yzzpc+"】【自杀频次"+zsxgpc+"】【行凶频次"+xxxgpc+"】【逃脱频次"+ttxgpc+"】【再犯罪频次"+zfzxgpc+"】");
		log.info("检索因子和维度时间【创建时间"+cjsj1+"】【至"+cjsj2+"】【修改时间"+xgsj1+"】【至"+xgsj2+"】");
		Map<String,Object> pmap = new HashMap<String,Object>();
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("ysbh", ysbh.trim());
			map.put("ysmc", ysmc.trim());
			map.put("yssx", yssx.trim());
			map.put("ytxz", ytxz.trim());
			map.put("yzzpc", yzzpc.trim());
			map.put("zsxgpc", zsxgpc.trim());
			map.put("xxxgpc", xxxgpc.trim());
			map.put("ttxgpc", ttxgpc.trim());
			map.put("zfzxgpc", zfzxgpc.trim());
			map.put("cjsj1", cjsj1.trim()); //格式2018-01-13
			map.put("cjsj2", cjsj2.trim());
			map.put("xgsj1", xgsj1.trim()); //格式 2018-01-13
			map.put("xgsj2", xgsj2.trim());
			PageHelper.startPage(pageNum, pageSize);
			tdminAndtyzService.likeTyskKey(map);
			@SuppressWarnings("rawtypes")
			Page page = PageHelper.endPage();
			pmap.put("page", page); //返回结果已在page中
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("检索因子或者维度失败，请重试...");
		}
		return pmap;
	}
	
	/**
	 * @todo TODO 修改因子或者维度
	 * @param ysbh @param ysmc @param yssx @param ytxz
	 * @param session
	 * @return
	 * @auth quite
	 * @time 2018年1月13日 下午6:18:57
	 */
	@ResponseBody
	@RequestMapping(value="/updateYsk",method={RequestMethod.GET,RequestMethod.POST})
	public int updateYsk(int ysid,String ysbh,String ysmc,String yssx,String ytxz,HttpSession session){
		int i =0;
		Tysk ty = null;
		try {
			String username = (String)session.getAttribute("username");
			log.info("修改因子或者维度的【ID"+ysid+"】【编号"+ysbh+"】【名称"+ysmc+"】【性质"+yssx+"】【用途"+ytxz+"】【"+username+"】");
			if(null!=username){
				ty = new Tysk();
				ty.setYsid(ysid);
				ty.setYsbh(ysbh);
				ty.setYsmc(ysmc);
				ty.setYssx(yssx);
				ty.setYtxz(ytxz);
				ty.setXgsj(new Date());
				ty.setXgrbh(username);
				i = tdminAndtyzService.updateTysk(ty);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改维度或者因子失败，请重试...");
		}
		return i;
	}
	
}


















