package com.hd.jy.oasm.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.domain.LBKM;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.services.LBKMService;
import com.hd.jy.oasm.services.TdminAndtyzService;

/***
 * 
 * @author quite 量表库操作层
 */
@Controller
@RequestMapping("lbk")
public class LBKController {
	private Logger log = Logger.getLogger(LBKController.class);

	@Autowired
	private LBKMService lbkmService;

	@Autowired
	private TdminAndtyzService tdminAndyzService;
	

	// 量表库管理与维护
	@RequestMapping(value = "/lbkManager")
	public String lbkManager(Model model) {
		List<Tscale> list = null;
		try {
			list = tdminAndyzService.scaleAllListStatus(); //使用TScale里面的数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("量表库查询异常，请重试...");
		}
		model.addAttribute("lbkList", list);
		return "/systemBlank/lbkManager";
	}

//	// 根据入监fl查出使用的量表
//	@ResponseBody
//	@RequestMapping(value = "/waitRjlbtmda", method = { RequestMethod.GET, RequestMethod.POST })
//	public List<LBKM> waitRjlbtmda(String lbbh) {
//		List<LBKM> rjlbtmyz = null;
//		if (lbbh != null && lbbh != "") {
//			try {
//				rjlbtmyz = lbkmService.rjlbtmyz(lbbh);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				log.error("使用【lbbh】查出使用的量表异常，请重试...");
//			}
//			return rjlbtmyz; // 返回有数据的报文
//		} else {
//			return rjlbtmyz; // 返回无数据的报文
//		}
//
//	}

//	// 根据日常量表fl查出使用的量表
//	@ResponseBody
//	@RequestMapping(value = "/waitRclbtmda", method = { RequestMethod.GET, RequestMethod.POST })
//	public List<LBKM> waitRclbtmda(String fl) {
//		List<LBKM> rclbtmyz = null;
//		if (fl != null & fl != "") {
//			try {
//				rclbtmyz = lbkmService.rclbtmyz(fl);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				log.error("根据【日常量表" + fl + "】查询异常，请重试...");
//			}
//			return rclbtmyz;
//		} else {
//			return rclbtmyz;
//		}
//	}

//	// 根据中期量表fl查出使用的量表
//	@ResponseBody
//	@RequestMapping(value = "/waitZqlbtmda", method = { RequestMethod.GET, RequestMethod.POST })
//	public List<LBKM> waitZqlbtmda(String fl) {
//		List<LBKM> zqlbtmyz = null;
//		if (fl != null & fl != "") {
//			try {
//				zqlbtmyz = lbkmService.zqlbtmyz(fl);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				log.error("使用中期【lb】查询使用的量表异常，请重试...");
//			}
//			return zqlbtmyz;
//		} else {
//			return zqlbtmyz;
//		}
//	}

	// 根据出监量表fl查出使用的量表
	@ResponseBody
	@RequestMapping(value = "/waitCjlbtmda", method = { RequestMethod.GET, RequestMethod.POST })
	public List<LBKM> waitCjlbtmda(String fl) {
		List<LBKM> cjlbtmyz = null;
		if (fl != null & fl != "") {
			try {
				cjlbtmyz = lbkmService.cjlbtmyz(fl);
				log.info(JSON.toJSON(cjlbtmyz));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("根据【出监量表" + fl + "】查询使用的量表异常，请重试...");
			}
			return cjlbtmyz;
		} else {
			return cjlbtmyz;
		}
	}

	// 调用存储过程关闭或开启量表
	@ResponseBody
	@RequestMapping(value = "/closeOrstartLBKM", method = { RequestMethod.GET, RequestMethod.POST })
	public int closeOrstartLBKM(String lbbh) {
		int i = 0;
		try {
			if (lbbh != null && lbbh != "") {
				i = lbkmService.closeOrstartLBKMisLive(lbbh);
				log.info("成功关闭或开启量表" + i + "个");
			} else {
				log.info("lbbh为==>" + lbbh);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("开启或关闭量表异常，请重试...");
		}
		return i;
	}

	// 因子库管理与维护
	@RequestMapping(value = "/yzManager")
	public String yzManager() {
		return "/systemBlank/yzManager";
	}

	// 加载各个阶段量表
	@ResponseBody
	@RequestMapping(value = "/jdlb", method = { RequestMethod.GET, RequestMethod.POST })
	public List<LBKM> getRJLB(String jd) {// jd阶段编号（1入监，2日常，3中期，4出监）
		List<LBKM> selectAllkm = null;
		try {
			selectAllkm = lbkmService.selectRDLB(jd);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("加载lb_km中的入监阶段的量表。出错" + e);
		}
		return selectAllkm;
	}

	// ******************************前台数据录入部分*****入监部分*************************************************************
	
	// **************************出监部分结束，整个录入部分结束******************************************************************
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// *******************************异常狱情部分*************************************************************
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	@ResponseBody
//	@RequestMapping(value = "/ycyqpc", method = { RequestMethod.GET, RequestMethod.POST })
//	public List<ZCYCYQPC> ycyqpc(String qh) {
//	    List<ZCYCYQPC> ycyq = null;
//		try {
//			ycyq = lbkmService.selectYCYQ(qh);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("根据囚号获取异常狱情失败，请重试...");
//		}
//		return ycyq;
//
//	}
	
	@ResponseBody
	@RequestMapping(value="/lookupScale",method={RequestMethod.GET,RequestMethod.POST})
	public String lookupScale(int scaleId){
		String scale = null;
		try {
			scale = lbkmService.scaleRelatById(scaleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("量表库预览失败，请稍后重试...");
		}
		return scale;
	}
}
