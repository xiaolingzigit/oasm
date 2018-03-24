package com.hd.jy.oasm.action;

import java.util.List;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.services.VPgbgListService;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;
import com.hd.jy.oasm.util.date.DateUtil;

/**
 * 罪犯信息控制层
 * TODO
 * @author quite
 * @data 2018年3月23日
 * @see  
 *
 */
@Controller
@RequestMapping("jygzView")
public class JygzViewController {
	private Logger log = Logger.getLogger(JygzViewController.class);
	
	@Autowired
	private VPgbgListService viewPgbgAService; //最新的评估报告个人信息操作接口
	
	
	//罪犯信息列表   
	@SuppressWarnings("rawtypes")
    @RequestMapping("/zfjbxx")
    public String zfjbxx(@RequestParam(required=true,defaultValue="1")int number,Model model){
		PageHelper.startPage(number, 30);
		List<BGjbxx> jbxxList = viewPgbgAService.selectJbxx();
		Page page= PageHelper.endPage();
		System.out.println("page===>"+page);
		model.addAttribute("page",page);
		model.addAttribute("nums", page.getNavigatepageNums());
		model.addAttribute("jbxxList",jbxxList);
//		System.out.println("jbxxList"+model);
//		System.out.println("jbxxList"+jbxxList);
    	return "/pcras/jygz/zfxx";
    }
    
	//罪犯详细信息
	@RequestMapping("/zfinfo")
	public String zfinfo(@RequestParam String qh,Model model){
		log.info("【罪犯囚号"+qh+"】");
		try {
			BGjbxx crimInfo = viewPgbgAService.crimInfoBycrimNo(qh.trim()); //查找罪犯的基础信息
			if(null!=crimInfo){
				model.addAttribute("jbxx", crimInfo); //罪犯基础的几项数据
				model.addAttribute("xxxx", crimInfo.getBgxxxx()); //罪犯重要的数据
				if(crimInfo.getBgxxxx().getXq().length()>4){
					String xq = DateUtil.fmtDate(crimInfo.getBgxxxx().getXq());
					model.addAttribute("xq", xq);
				}else{
					model.addAttribute("xq", crimInfo.getBgxxxx().getXq());
				}
				//格式化剥夺政治权利年限
				if(crimInfo.getBgxxxx().getBznx().length()>4){
					String bznx = DateUtil.fmtDate(crimInfo.getBgxxxx().getBznx());
					model.addAttribute("bznx", bznx);
				}else{
					model.addAttribute("bznx", crimInfo.getBgxxxx().getBznx());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("罪犯信息显示失败，请稍后重试...");
		}
		return "/pcras/jygz/zfinfo";
	}
	   
    
    //罪犯个人详细信息
//    @RequestMapping(value="/zfinfo",method={RequestMethod.GET,RequestMethod.POST})
//    public String zfinfo(String qh,String jcxm,HttpServletRequest request){
//    	try {
//			jcxm=new String(jcxm.getBytes("iso8859-1"),"UTF-8"); //中文乱码问题
//			log.info("查看个人详细信息【囚号"+qh+"】，【警察姓名"+jcxm+"】");
//			BGjbxx xx = viewPgbgAService.crimInfoBycrimNo(qh); //根据囚号查询基础信息
//			if(null!=xx){
//				request.setAttribute("jcxm", jcxm);
//				request.setAttribute("grxx", xx);
//				request.setAttribute("xxxx", xx.getBgxxxx());
//				if(xx.getBgxxxx().getXq().length()>4){
//					String xq = DateUtil.fmtDate(xx.getBgxxxx().getXq());
//					request.setAttribute("xq", xq);
//				}else{
//					request.setAttribute("xq", xx.getBgxxxx().getXq());
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	return "/pcras/jygz/zfinfo";
//    }

//    @ResponseBody
//    @RequestMapping(value="/jz_crimInfo",method={RequestMethod.GET,RequestMethod.POST})
//    public String jz_crimInfo(String crimNo){
//    	 log.info("矫治项目的【囚号"+crimNo+"】");
//    	 String record = null;
//		try {
//			record = viewPgbgAService.getCrimInfoRecord(crimNo);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	 return record;
//    	}
}
