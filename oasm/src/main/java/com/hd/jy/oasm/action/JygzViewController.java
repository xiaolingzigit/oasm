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
 * �ﷸ��Ϣ���Ʋ�
 * TODO
 * @author quite
 * @data 2018��3��23��
 * @see  
 *
 */
@Controller
@RequestMapping("jygzView")
public class JygzViewController {
	private Logger log = Logger.getLogger(JygzViewController.class);
	
	@Autowired
	private VPgbgListService viewPgbgAService; //���µ��������������Ϣ�����ӿ�
	
	
	//�ﷸ��Ϣ�б�   
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
    
	//�ﷸ��ϸ��Ϣ
	@RequestMapping("/zfinfo")
	public String zfinfo(@RequestParam String qh,Model model){
		log.info("���ﷸ����"+qh+"��");
		try {
			BGjbxx crimInfo = viewPgbgAService.crimInfoBycrimNo(qh.trim()); //�����ﷸ�Ļ�����Ϣ
			if(null!=crimInfo){
				model.addAttribute("jbxx", crimInfo); //�ﷸ�����ļ�������
				model.addAttribute("xxxx", crimInfo.getBgxxxx()); //�ﷸ��Ҫ������
				if(crimInfo.getBgxxxx().getXq().length()>4){
					String xq = DateUtil.fmtDate(crimInfo.getBgxxxx().getXq());
					model.addAttribute("xq", xq);
				}else{
					model.addAttribute("xq", crimInfo.getBgxxxx().getXq());
				}
				//��ʽ����������Ȩ������
				if(crimInfo.getBgxxxx().getBznx().length()>4){
					String bznx = DateUtil.fmtDate(crimInfo.getBgxxxx().getBznx());
					model.addAttribute("bznx", bznx);
				}else{
					model.addAttribute("bznx", crimInfo.getBgxxxx().getBznx());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�ﷸ��Ϣ��ʾʧ�ܣ����Ժ�����...");
		}
		return "/pcras/jygz/zfinfo";
	}
	   
    
    //�ﷸ������ϸ��Ϣ
//    @RequestMapping(value="/zfinfo",method={RequestMethod.GET,RequestMethod.POST})
//    public String zfinfo(String qh,String jcxm,HttpServletRequest request){
//    	try {
//			jcxm=new String(jcxm.getBytes("iso8859-1"),"UTF-8"); //������������
//			log.info("�鿴������ϸ��Ϣ������"+qh+"��������������"+jcxm+"��");
//			BGjbxx xx = viewPgbgAService.crimInfoBycrimNo(qh); //�������Ų�ѯ������Ϣ
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
//    	 log.info("������Ŀ�ġ�����"+crimNo+"��");
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
