package com.hd.jy.oasm.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fyhyView")
public class FyhyViewController {
	
	private static Logger logger = Logger.getLogger(FyhyViewController.class);
	// 出监报告合议列表
	@RequestMapping("/cj_bghy")
	public String cj_bghy() {
		return "/pcras/fyhy/cj_bghy";
	}

	// 出监报告合议结果表
	@RequestMapping("/cj_bghyrs")
	public String cj_bghyrs(String task_id) {
		return "/pcras/fyhy/cj_bghyrs";
	}

	// 出监报告合议录入
	@RequestMapping("/cj_bghylr")
	public String cj_bghylr(String task_id) {
		return "/pcras/fyhy/cj_bghylr";
	}

	// 出监报告复议列表
	@RequestMapping("/cj_bgfy")
	public String cj_bgfy() {
		return "/pcras/fyhy/cj_bgfy";
	}

	// 出监报告复议结果表
	@RequestMapping("/cj_bgfyrs")
	public String cj_bgfyrs(String task_id) {
		return "/pcras/fyhy/cj_bgfyrs";
	}

	// 出监报告复议录入
	@RequestMapping("/cj_bgfylr")
	public String cj_bgfylr(String task_id) {
		return "/pcras/fyhy/cj_bgfylr";
	}
}
