package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bgspView")
public class BgspViewController {

	// 出监报告审批列表
	@RequestMapping("/cj_bgsp")
	public String cj_bgsp() {
		return "/pcras/bgsp/cj_bgsp";
	}

	// 出监报告审批结果表
	@RequestMapping("/cj_bgsprs")
	public String cj_bgsprs(String task_id) {
		return "/pcras/bgsp/cj_bgsprs";
	}

	// 出监报告审批录入
	@RequestMapping("/cj_bgsplr")
	public String cj_bgsplr(String task_id) {
		return "/pcras/bgsp/cj_bgsplr";
	}
}
