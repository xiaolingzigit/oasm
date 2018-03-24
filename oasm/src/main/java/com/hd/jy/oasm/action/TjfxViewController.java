package com.hd.jy.oasm.action;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.domain.Vtjzfz;
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
	
	// 罪犯出监再犯罪倾向统计
	@RequestMapping("/cjzftj")
	public String cjzftj(Model model){
		List<Vtjzfz> listTjZfz = null;
		try {
			listTjZfz = vTjwxcdService.listTjZfz();
		} catch (Exception e) {
			logging.error("TjfxViewController#listTjZfz:出错"+e);
		}
		model.addAttribute("tjzfz",listTjZfz);
		
		return "/pcras/tjfx/cjzftj";
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
	
	
	
	
}
