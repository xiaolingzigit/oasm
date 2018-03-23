package com.hd.jy.oasm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.domain.JYXX;
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
		System.out.println("1111==========");
		BGjbxx bgjbxx =  viewPgbgAService.crimInfoBycrimNo(qh);
		System.out.println(bgjbxx);
		model.addAttribute("bgjbxx",bgjbxx);
		return "/pcras/jygz/zfinfo";
	}
	
    

//    //改造方案跟踪
//    @RequestMapping("/gzfagz")
//    public String gzfagz(){
//    	return "/pcras/jygz/gzfagz";
//    }
//    //改造方案实施情况跟踪
//    @RequestMapping("/gzssqk")
//    public String gzssqk(){
//    	return "/pcras/jygz/gzssqk";
//    }    
    
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
