package com.hd.jy.oasm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.domain.TWpqk;
import com.hd.jy.oasm.domain.VPgbgWxlx;
import com.hd.jy.oasm.domain.VTjwxcd;
import com.hd.jy.oasm.domain.VTjwxlx;
import com.hd.jy.oasm.domain.Vtjzfz;
import com.hd.jy.oasm.domain.Vwxlx;
import com.hd.jy.oasm.services.TWpqkServices;
import com.hd.jy.oasm.services.VTjwxcdService;

@Controller
@RequestMapping("tjfxView")
public class TjfxViewController {

	private static Logger logging = Logger.getLogger(TjfxViewController.class);

	@Autowired
	private VTjwxcdService vTjwxcdService;

	@Autowired
	private TWpqkServices tWpqkServices;
	
	// 危评情况变化
	@RequestMapping("/wpqkbh")
	public String wpqkbh() {
		return "/pcras/tjfx/wpqkbh";
	}

	// 危险程度统计
	@RequestMapping("/wpcdtj")
	public String wpcdtj() {
		return "/pcras/tjfx/wpcdtj";
	}

	// 危险类别统计
	@RequestMapping("/wxlbtj")
	public String wxlbtj() {
		return "/pcras/tjfx/wxlbtj";
	}
	//罪犯自杀行凶脱逃倾向统计
	@RequestMapping("/zxttj")
	public String zxttj(){
		return "/pcras/tjfx/zxttj";
	}
	// 罪犯出监再犯罪倾向统计
	@RequestMapping("/cjzftj")
	public String cjzftj(){
		return "/pcras/tjfx/cjzftj";
	}
	// 处置情况统计
	@RequestMapping("/czqktj")
	public String czqktj(){
		return "/pcras/tjfx/czqktj";
	} 
	// 评估情况统计
	@RequestMapping("/pgqktj")
	public String pgqktj() {
		return "/pcras/tjfx/pgqktj";
	}

	// 预警统计
	@RequestMapping("/yjtj")
	public String yjtj() {
		return "/pcras/tjfx/yjtj";
	}

	// 各类罪犯统计选项卡
	@RequestMapping("/glzftj")
	public String glzftj() {
		return "/pcras/tjfx/glzftj";
	}

	// 各类罪犯统计
	@RequestMapping("/tj_glzf")
	public String tj_glzf() {
		return "/pcras/tjfx/tj_glzf";
	}

	// 顽危犯统计
	@RequestMapping("/tj_wwf")
	public String tj_wwf() {
		return "/pcras/tjfx/tj_wwf";
	}

	// 顽危犯统计
	@RequestMapping("/tj_waf")
	public String tj_waf() {
		return "/pcras/tjfx/tj_waf";
	}

	// 顽危犯统计
	@RequestMapping("/tj_jsbf")
	public String tj_jsbf() {
		return "/pcras/tjfx/tj_jsbf";
	}

	@RequestMapping("/tj_zdf")
	public String tj_zdf() {
		return "/pcras/tjfx/tj_zdf";
	}

	@RequestMapping("/tj_wjf")
	public String tj_wjf() {
		return "/pcras/tjfx/tj_wjf";
	}

	// 危险因子分析
	@RequestMapping("/wxyzfx")
	public String wxyzfx() {
		return "/pcras/tjfx/wxyzfx";
	}

	// 危险程度统计数据echarts
	// 每个监区的危险程度数据
	@ResponseBody
	@RequestMapping(value = "/listVTjwxcd", method = { RequestMethod.GET, RequestMethod.POST })
	public List<VTjwxcd> listVTjwxcd() {
		List<VTjwxcd> vTjwxcd = null;
		try {
			vTjwxcd = vTjwxcdService.listVTjwxcd();
		} catch (Exception e) {
			// TODO: handle exception
			logging.error("TjfxViewController.getListWxcd():方法出错" + e);
		}
		return vTjwxcd;
	}

	//可以考虑用图表显示
	// 危评情况变化
	@ResponseBody
	@RequestMapping(value = "/getWpqkbh", method = { RequestMethod.GET, RequestMethod.POST })
	public HashMap<String, List<TWpqk>> getWpqkbh(String sj1, String sj2) {
		HashMap<String, List<TWpqk>> hashMap = new HashMap<>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startTime = sdf.parse(sj1);
			Date endTime = sdf.parse(sj2);
			if (sj2.equals(sj1)) {
				List<TWpqk> list1 = tWpqkServices.getDate(startTime);
				hashMap.put("list1", list1);
				hashMap.put("list2", list1);
			} else {
				List<TWpqk> list1 = tWpqkServices.getDate(startTime);
				List<TWpqk> list2 = tWpqkServices.getDate(endTime);
				hashMap.put("list1", list1);
				hashMap.put("list2", list2);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logging.error("TjfxViewController.getWpqkbh();方法出错" + e);
		}
		return hashMap;
	}

	@ResponseBody
	@RequestMapping(value = "/getTopDate", method = { RequestMethod.GET, RequestMethod.POST })
	public String getTopDate() {
		String date = "";
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").format(tWpqkServices.getTopDate());
		} catch (Exception e) {
			// TODO: handle exception
			logging.error("TjfxViewController.getTopDate();出错" + e);
		}
		return date;
	}

	/**
	 * @Date: 2017年12月28日 上午10:32:00
	 * @author liangjiaying
	 * @Title: getVPgbgWxlx
	 * @Description: 极高危险类型列表
	 */
	@ResponseBody
	@RequestMapping(value = "/getVPgbgWxlx", method = { RequestMethod.GET, RequestMethod.POST })
	public List<VPgbgWxlx> getVPgbgWxlx() {
		List<VPgbgWxlx> vPgbgWxlx = null;
		try {
			vPgbgWxlx = vTjwxcdService.getVPgbgWxlx();
		} catch (Exception e) {
			logging.error("TjfxViewController#getVPgbgWxlx " + e);
		}
		return vPgbgWxlx;
	}

	/**
	 * @Date: 2018年1月5日 上午10:00:06 
	 * @author liangjiaying 
	 * @Title: getVTjwxlx 
	 * @Description: 统计各个监区高危险倾向数量 
	 * List<VTjwxlx> @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getVTjwxlx", method = { RequestMethod.GET, RequestMethod.POST })
	public List<VTjwxlx> getVTjwxlx() {
		List<VTjwxlx> vTjwxlx = null;
		try {
			vTjwxlx = vTjwxcdService.getVTjwxlx();
		} catch (Exception e) {
			logging.error("TjfxViewController#getVTjwxlx;" + e);
		}
		return vTjwxlx;
	}

	/**
	 * @Date: 2018年1月13日 下午5:51:21
	 * @author liangjiaying
	 * @Title: listTjZfz  
	 * @Description: 统计出监再犯罪倾向
	 * @param: @return      
	 * @return: List<Vtjzfz>      
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/listTjZfz",method = {RequestMethod.GET,RequestMethod.POST})
	public List<Vtjzfz> listTjZfz(){
		List<Vtjzfz> listTjZfz = null;
		try {
			listTjZfz = vTjwxcdService.listTjZfz();
		} catch (Exception e) {
			logging.error("TjfxViewController#listTjZfz:出错"+e);
		}
		return listTjZfz;
	}
	
	
	/**
	 * @Date: 2018年1月13日 下午6:02:50
	 * @author liangjiaying
	 * @Title: listTjWxlx  
	 * @Description: 统计各个监区危险类别数量
	 * @param: @return      
	 * @return: List<Vwxlx>      
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/listTjWxlx", method = {RequestMethod.GET,RequestMethod.POST})
	public List<Vwxlx> listTjWxlx() {
		List<Vwxlx> listTjWxlx = null;
		try {
			listTjWxlx = vTjwxcdService.listTjWxlx();
		} catch (Exception e) {
			logging.error("TjfxViewController#listTjWxlx:出错"+e);
		}
		return listTjWxlx;
	}
	
}
