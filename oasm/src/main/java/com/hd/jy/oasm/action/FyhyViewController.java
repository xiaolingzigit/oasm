package com.hd.jy.oasm.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fyhyView")
public class FyhyViewController {
	
	private static Logger logger = Logger.getLogger(FyhyViewController.class);
	// ���౨������б�
	@RequestMapping("/cj_bghy")
	public String cj_bghy() {
		return "/pcras/fyhy/cj_bghy";
	}

	// ���౨���������
	@RequestMapping("/cj_bghyrs")
	public String cj_bghyrs(String task_id) {
		return "/pcras/fyhy/cj_bghyrs";
	}

	// ���౨�����¼��
	@RequestMapping("/cj_bghylr")
	public String cj_bghylr(String task_id) {
		return "/pcras/fyhy/cj_bghylr";
	}

	// ���౨�渴���б�
	@RequestMapping("/cj_bgfy")
	public String cj_bgfy() {
		return "/pcras/fyhy/cj_bgfy";
	}

	// ���౨�渴������
	@RequestMapping("/cj_bgfyrs")
	public String cj_bgfyrs(String task_id) {
		return "/pcras/fyhy/cj_bgfyrs";
	}

	// ���౨�渴��¼��
	@RequestMapping("/cj_bgfylr")
	public String cj_bgfylr(String task_id) {
		return "/pcras/fyhy/cj_bgfylr";
	}
}
