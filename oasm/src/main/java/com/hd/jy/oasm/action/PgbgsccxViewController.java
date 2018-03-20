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
 * TODO 罪犯的详细评估报告显示
 * @author quite
 * @data 2017年12月20日
 * @see  
 *
 */
@Controller
@RequestMapping("pgbgsccxView")
public class PgbgsccxViewController {
    private Logger log = Logger.getLogger(PgbgsccxViewController.class);
	
	@Autowired
	private RjpgsjService rjpgsjService;  //去重部分操作接口
	
	@Autowired
	private PgLxService pglxService;  //危险类型操作接口
	
	//***************************以上接口为惠州验收接口，已 过时，待删除*************************************************
	
	@Autowired
	private VPgbgListService viewPgbgAService; //最新的评估报告操作接口
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	

	
	//**********************************出监部分***********************************
	
	@RequestMapping(value="/bg_cj",method=RequestMethod.GET)
	public String bg_cj(Model model){
		return "/pcras/pggl/bg_cj";
	}
	
	//出监列表跳转
	@RequestMapping(value="/cj_bgsc",method=RequestMethod.GET)
	public String cjbgsc(){
		return "/pcras/pggl/cj_bgsc";
	}
	
	@RequestMapping(value="cj_bgcx")
	public String cj_bgcx(){
		return "/pcras/pggl/cj_bgcx";
	}
	
	/**
	 * 显示出监评估报告基础信息
	 * @auto quite
	 * @param qh
	 * @param taskId
	 * @param request
	 * @returna
	 * 下午8:30:45
	 * String
	 */
	@RequestMapping("/pgbg_cj")
	public String pgbg_cj(String qh,String taskId,HttpServletRequest request){
		log.info("出监评估报告【囚号"+qh+"】");
		BGjbxx gjbxx = null;
		TevalReport report = null;
		try {
			report = viewPgbgAService.evalReportCount(taskId.trim());
			gjbxx = viewPgbgAService.crimInfoBycrimNo(qh.trim());
			if(null!=report){
				request.setAttribute("pgsj", now.format(report.getCrTime())); //评估报告生成时间
				request.setAttribute("cjpgfs", report.getScore()); //分数
				request.setAttribute("cjwxdj", report.getLevl());
				request.setAttribute("report", report.getReport());
			}else{
				log.info("该任务暂时没有数据显示到评估报告");
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
			request.setAttribute("taskId", taskId); //总任务编号
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据囚号获取评估报告基础信息失败，请重试...");
		}
		return "/pcras/pggl/pgbg_cj";
	}

	
	//*********************************危险类型部分************************************************
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

