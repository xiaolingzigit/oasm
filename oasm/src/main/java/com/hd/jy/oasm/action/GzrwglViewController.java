package com.hd.jy.oasm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ע��****����������Ʋ�
 * TODO
 * @author quite
 * @data 2017��12��29��
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
	//��������ѡ�
	@RequestMapping("/grgzmb")
    public String grgzmb(){
    	return "/pcras/grgzmb/grgzmb";   
    }
	//���˴��������б�
	@RequestMapping("/gr_dbrw")
    public String gr_dbrw(){
    	return "/pcras/grgzmb/gr_dbrw";   
    }
	//�����ֶ���������������
	@RequestMapping("/gr_sdfb")
    public String gr_sdfb(){
    	return "/pcras/grgzmb/gr_sdfb";   
    }
	//�����ļ������б�
	@RequestMapping("/gr_wjsp")
    public String gr_wjsp(){
    	return "/pcras/grgzmb/gr_wjsp";   
    }
	//�����ļ������б�
	@RequestMapping("/gr_wjbp")
    public String gr_wjbp(){
    	return "/pcras/grgzmb/gr_wjbp";   
    }
	//������������
	@RequestMapping("/dafxgz")
    public String dafxgz(){
    	return "/pcras/grgzmb/dafxgz";   
    }
	
}
