package com.hd.jy.oasm.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.domain.BGwxlx;
import com.hd.jy.oasm.domain.LxCj;
import com.hd.jy.oasm.domain.LxRc;
import com.hd.jy.oasm.domain.LxRj;
import com.hd.jy.oasm.domain.Rjpgsj;
import com.hd.jy.oasm.domain.TevalReport;
import com.hd.jy.oasm.services.PgLxService;
import com.hd.jy.oasm.services.RjpgsjService;
import com.hd.jy.oasm.services.VPgbgListService;
import com.hd.jy.oasm.util.date.DateUtil;
/**
 * 
 * TODO �ﷸ����ϸ����������ʾ
 * @author quite
 * @data 2017��12��20��
 * @see  
 *
 */
@Controller
@RequestMapping("pgbgsccxView")
public class PgbgsccxViewController {
    private Logger log = Logger.getLogger(PgbgsccxViewController.class);
	
	@Autowired
	private RjpgsjService rjpgsjService;  //ȥ�ز��ֲ����ӿ�
	
	@Autowired
	private PgLxService pglxService;  //Σ�����Ͳ����ӿ�
	
	//***************************���Ͻӿ�Ϊ�������սӿڣ��� ��ʱ����ɾ��*************************************************
	
	@Autowired
	private VPgbgListService viewPgbgAService; //���µ�������������ӿ�
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
	SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	

	
	//**********************************���ಿ��***********************************
	
	@RequestMapping(value="/bg_cj",method=RequestMethod.GET)
	public String bg_cj(Model model){
		return "/pcras/pggl/bg_cj";
	}
	
	//�����б���ת
	@RequestMapping(value="/cj_bgsc",method=RequestMethod.GET)
	public String cjbgsc(){
		return "/pcras/pggl/cj_bgsc";
	}
	
	@RequestMapping(value="cj_bgcx")
	public String cj_bgcx(){
		return "/pcras/pggl/cj_bgcx";
	}
	
	/**
	 * ��ʾ�����������������Ϣ
	 * @auto quite
	 * @param qh
	 * @param taskId
	 * @param request
	 * @returna
	 * ����8:30:45
	 * String
	 */
	@RequestMapping("/pgbg_cj")
	public String pgbg_cj(String qh,String taskId,HttpServletRequest request){
		log.info("�����������桾����"+qh+"��");
		BGjbxx gjbxx = null;
		TevalReport report = null;
		try {
			report = viewPgbgAService.evalReportCount(taskId.trim());
			gjbxx = viewPgbgAService.crimInfoBycrimNo(qh.trim());
			if(null!=report){
				request.setAttribute("pgsj", now.format(report.getCrTime())); //������������ʱ��
				request.setAttribute("cjpgfs", report.getScore()); //����
				request.setAttribute("cjwxdj", report.getLevl());
				request.setAttribute("report", report.getReport());
			}else{
				log.info("��������ʱû��������ʾ����������");
			}
			List<BGwxlx> wxlxReport = viewPgbgAService.getWxlxReport(taskId);
			if(null!=wxlxReport&&wxlxReport.size()>0){
				request.setAttribute("wxlxReport", wxlxReport);
			}
			if(gjbxx.getBgxxxx().getXq().length()>4){
				String xq = DateUtil.fmtDate(gjbxx.getBgxxxx().getXq());
				request.setAttribute("xq", xq);
			}else{
				request.setAttribute("xq", gjbxx.getBgxxxx().getXq());
			}
			if(gjbxx.getBgxxxx().getBznx().length()>4){
				String bznx = DateUtil.fmtDate(gjbxx.getBgxxxx().getBznx());
				request.setAttribute("bznx", bznx);
			}else{
				request.setAttribute("bznx", gjbxx.getBgxxxx().getBznx());
			}
			request.setAttribute("cjjbxx", gjbxx);
			request.setAttribute("cjxxxx", gjbxx.getBgxxxx());
			request.setAttribute("taskId", taskId); //��������
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�������Ż�ȡ�������������Ϣʧ�ܣ�������...");
		}
		return "/pcras/pggl/pgbg_cj";
	}

	
	//*********************************Σ�����Ͳ���************************************************
   @ResponseBody
   @RequestMapping("/rjlxSelectByQh")
   public LxRj rjlxSelectByQh(long qh){
	   LxRj lxByQh = pglxService.selectLxByQh(qh);
	   return lxByQh;
   }
   
   @ResponseBody
   @RequestMapping("/rclxSelectByQh")
   public LxRc rclxSelectByQh(long qh){
	   LxRc lxrc = pglxService.selectLxrc(qh);
	   return lxrc;
   }
   @ResponseBody
   @RequestMapping("/cjlxSelectByQh")
   public LxCj cjlxSelectByQh(long qh){
	   LxCj lxcj = pglxService.selectLxcj(qh);
	   return lxcj;
   }
}

