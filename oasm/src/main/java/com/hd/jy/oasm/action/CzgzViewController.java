package com.hd.jy.oasm.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/***
 * *********出监评估报告处置控制层 *******
 * @author quite
 * @data 2018年03月22日
 * @see  
 *
 */
@Controller
@RequestMapping("czgzView")
public class CzgzViewController {
	
	private static Logger logger  = Logger.getLogger(CzgzViewController.class);

	// 出监评估报告处置跟踪列表
	@RequestMapping("/cj_bgcz")
	public String cj_bgcz() {
		return "/pcras/czgz/cj_bgcz";
	}

	// 出监评估报告处置跟踪情况
	@RequestMapping("/cj_bgczrs")
	public String cj_bgczrs(String task_id) {
		return "/pcras/czgz/cj_bgczrs";
	}

	// 出监评估报告处置跟踪录入
	@RequestMapping("/cj_bgczlr")
	public String cj_bgczlr(String task_id) {
		return "/pcras/czgz/cj_bgczlr";
	}
}
