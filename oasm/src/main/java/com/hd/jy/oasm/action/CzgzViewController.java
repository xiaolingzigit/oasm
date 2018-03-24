package com.hd.jy.oasm.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/***
 * *********�����������洦�ÿ��Ʋ� *******
 * @author quite
 * @data 2018��03��22��
 * @see  
 *
 */
@Controller
@RequestMapping("czgzView")
public class CzgzViewController {
	
	private static Logger logger  = Logger.getLogger(CzgzViewController.class);

	// �����������洦�ø����б�
	@RequestMapping("/cj_bgcz")
	public String cj_bgcz() {
		return "/pcras/czgz/cj_bgcz";
	}

	// �����������洦�ø������
	@RequestMapping("/cj_bgczrs")
	public String cj_bgczrs(String task_id) {
		return "/pcras/czgz/cj_bgczrs";
	}

	// �����������洦�ø���¼��
	@RequestMapping("/cj_bgczlr")
	public String cj_bgczlr(String task_id) {
		return "/pcras/czgz/cj_bgczlr";
	}
}
