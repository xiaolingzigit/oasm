package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注释****个人任务控制层
 * TODO
 * @author quite
 * @data 2017年12月29日
 * @see  
 *
 */
@Controller
@RequestMapping("gzrwglView")
public class GzrwglViewController {
	@RequestMapping("/gzrwgl")
    public String gzrwgl(){
    	return "/pcras/pggl/gzrwgl";   
    }
	//个人任务选项卡
	@RequestMapping("/grgzmb")
    public String grgzmb(){
    	return "/pcras/grgzmb/grgzmb";   
    }
	//个人待办任务列表
	@RequestMapping("/gr_dbrw")
    public String gr_dbrw(){
    	return "/pcras/grgzmb/gr_dbrw";   
    }
	//个人手动发布任务，任务列
	@RequestMapping("/gr_sdfb")
    public String gr_sdfb(){
    	return "/pcras/grgzmb/gr_sdfb";   
    }
	//个人文件审批列表
	@RequestMapping("/gr_wjsp")
    public String gr_wjsp(){
    	return "/pcras/grgzmb/gr_wjsp";   
    }
	//个人文件报批列表
	@RequestMapping("/gr_wjbp")
    public String gr_wjbp(){
    	return "/pcras/grgzmb/gr_wjbp";   
    }
	//档案分析工作
	@RequestMapping("/dafxgz")
    public String dafxgz(){
    	return "/pcras/grgzmb/dafxgz";   
    }
	
}
