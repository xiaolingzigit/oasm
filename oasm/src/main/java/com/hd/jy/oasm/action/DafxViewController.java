package com.hd.jy.oasm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.domain.Tzyrymd;
import com.hd.jy.oasm.domain.ViewDafxjg;
import com.hd.jy.oasm.domain.Viewcjjgft;
import com.hd.jy.oasm.domain.Viewcjxwgc;
import com.hd.jy.oasm.domain.Viewrcxwgc;
import com.hd.jy.oasm.domain.Viewrjxwgc;
import com.hd.jy.oasm.domain.Viewzqjgft;
import com.hd.jy.oasm.domain.Viewzqxwgc;
import com.hd.jy.oasm.domain.newDomain.Viewpggl;
import com.hd.jy.oasm.services.SjjgftAndxwgcService;
import com.hd.jy.oasm.services.TzyrymdService;
import com.hd.jy.oasm.services.VPgbgListService;
import com.hd.jy.oasm.services.ViewftjgAndxwgcService;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;
import com.hd.jy.oasm.util.date.DateUtil;

@Controller
@RequestMapping("dafxView")
public class DafxViewController {
	private Logger log = Logger.getLogger(DafxViewController.class);


	@Autowired
	private ViewftjgAndxwgcService viewftAndgcService; // 档案、访谈和观察数据视图返回操作接口，可以调用最新的
	
	@Autowired
	private SjjgftAndxwgcService sjjgftAndxwgcService; //最新档案分析逻辑接口，页面显示档案分析，以及因子和分数使用
	
	@Autowired
	private TzyrymdService tzyreService; // 在押人员操作逻辑接口
	
	@Autowired
	private VPgbgListService vpgbgListService; //调用评估量表里面罪犯的基础信息内容
	
	//封装获取当前登录警号
    public static String getJhforView(){ //在需要的视图获取警号
		  String jh = null;
		try {
			Subject currentUser = SecurityUtils.getSubject();
			jh = (String) currentUser.getPrincipal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return jh;
	  }

//*********************************************************************************
//*************************出监录入视图部分*******************************************
//*********************************************************************************
	/***
	 * 获取出监访谈分页数据的视图
	 * @auto quite
	 * @param num
	 * @param size
	 * @returna
	 * 下午6:57:33
	 * Map<Object,Object>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/cjftView_json",method={RequestMethod.GET,RequestMethod.POST})
	public Map<Object,Object> cjftView_json(int num,int size,String gyjq,String qh,String xm,String jhxm,String ftzt){
		log.info("【关押监区"+gyjq+"】，【囚号"+qh+"】，【姓名"+xm+"】，【警察姓名"+jhxm+"】，【状态"+ftzt+"】");
		String jh = getJhforView();//获取警号
		Map<Object, Object> cjftMap = new HashMap<>();
		Map<String,Object> map = new HashMap<>();
		List<Viewpggl> cjftvp = null;
		try {
			PageHelper.startPage(num, size);
			map.put("jh", jh);
//			map.put("gyjq", gyjq); //出监阶段暂时不使用
			map.put("crim_no", qh);
			map.put("xm", xm);
			map.put("jhxm", jhxm);
			map.put("status", ftzt);
			cjftvp = viewftAndgcService.cjjgftViewpggl(map);
			Page page = PageHelper.endPage();
			cjftMap.put("cjftvp", cjftvp); //出监访谈的分页视图
			cjftMap.put("page", page); //
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("出监访谈分页数据获取异常，请重试...");
		}
		return cjftMap;
	}
	
	// 出监档案分析
	@RequestMapping("/cj_dafx")
	public String cj_dafx() {
		return "/pcras/pggl/cj_dafx";
	}

	// 出监档案分析结果
	@RequestMapping("/cj_dafxrs")
	public String cj_dafxrs() {
		return "/pcras/pggl/cj_dafxrs";
	}

	// 出监档案分析量表
	@RequestMapping("/cj_dafxlb")
	public String cj_dafxlb() {
		return "/pcras/pggl/cj_dafxlb";
	}

	// 出监结构性访谈
	@RequestMapping("/cj_jgft")
	public String cj_jgft(Model model) {
		String jh = getJhforView();
		List<Viewcjjgft> viewcjjgft = null;
		try {
			viewcjjgft = viewftAndgcService.showViewcjjgft(jh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据警号动态获取出监结构访谈数据失败，请重试...");
		}
		model.addAttribute("viewcjjgftList", viewcjjgft);
		return "/pcras/pggl/cj_jgft";
	}

	// 出监结构性访谈结果表
	@RequestMapping("/cj_jgftrs")
	public String cj_jgftrs(@RequestParam("qh") String qh,int ftfs,String ftsj, HttpServletRequest request) {
		log.info("出监【结构访谈囚号"+qh+"】，【访谈分数"+ftfs+"】，【访谈时间"+ftsj+"】");
		try {
			long cjftqh = Long.parseLong(qh.trim());
			Tzyrymd cjftzyry = tzyreService.selectBDJCbyqh(cjftqh); //根据出监结构访谈的囚号获取罪犯数据
			Date datesj = new Date(Long.parseLong(ftsj.trim()));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String cjftsj = sdf.format(datesj); //格式化的时间
			String cjftfs = String.valueOf(ftfs); //格式化的分数
			request.setAttribute("ftsj", cjftsj); //访谈时间
			request.setAttribute("ftfs", cjftfs); //访谈分数
			request.setAttribute("cjftjyxx", cjftzyry.getTjczjdx()); //警员信息
			request.setAttribute("cjftzyry", cjftzyry); //囚犯信息
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("显示出监结构访谈答题结果基础信息失败，请重试...");
		}
		return "/pcras/pggl/cj_jgftrs";
	}

	// 出监结构性访谈量表
	@RequestMapping("/cj_jgftlb")
	public String cj_jgftlb(@RequestParam("qh") String qh, HttpServletRequest request) {
		long cjftqh = Long.parseLong(qh.trim()); //获取出监访谈囚号
		Tzyrymd cjzyftlb = tzyreService.selectBDJCbyqh(cjftqh);
		request.setAttribute("cjzyft", cjzyftlb); //传送出监囚号
		request.setAttribute("cjftlbjyxx", cjzyftlb.getTjczjdx()); //传送量表警员到页面
		return "/pcras/pggl/cj_jgftlb";
	}

	
	/***
	 * 出监观察分页数据视图显示
	 * @auto quite
	 * @param num
	 * @param size
	 * @returna
	 * 下午7:02:19
	 * Map<Object,Object>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/cjgcView_json",method={RequestMethod.GET,RequestMethod.POST})
	public Map<Object,Object> cjgcView_json(int num,int size,String gyjq,String qh,String xm,String jhxm,String gczt){
		log.info("【关押监区"+gyjq+"】，【囚号"+qh+"】，【姓名"+xm+"】，【警察姓名"+jhxm+"】，【状态"+gczt+"】");
		String jh = getJhforView();//获取警号
		Map<Object, Object> cjgcMap = new HashMap<>();
		Map<String,Object> map = new HashMap<>();
		List<Viewpggl> cjgcvp = null;
		try {
			PageHelper.startPage(num, size);
			map.put("jh", jh);
//			map.put("gyjq", gyjq); //出监阶段暂时取消使用
			map.put("crim_no", qh);
			map.put("xm", xm);
			map.put("jhxm", jhxm);
			map.put("status", gczt);
			cjgcvp = viewftAndgcService.cjxwgcViewpggl(map);
			Page page = PageHelper.endPage();
			cjgcMap.put("cjgcvp", cjgcvp); //出监观察分页数据使用map返回
			cjgcMap.put("page", page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("出监观察分页数据获取失败，请重试...");
		}
		return cjgcMap;
	}
	// 出监行为观察
	@RequestMapping("/cj_rcgc")
	public String cj_rcgc(Model model) {
		String jh = getJhforView();
		List<Viewcjxwgc> viewcjxwgc = null;
		try {
			viewcjxwgc = viewftAndgcService.findViewcjxwgc(jh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据警号动态获取出监行为观察数据失败，请重试...");
		}
		model.addAttribute("viewcjxwgcList", viewcjxwgc);
		return "/pcras/pggl/cj_rcgc";
	}

	// 出监行为观察结果表
	@RequestMapping("/cj_rcgcrs")
	public String cj_rcgcrs(@RequestParam("qh") String qh,int gcfs,String gcsj, HttpServletRequest request) {
		log.info("出监【行为观察囚号"+qh+"】，【 分数"+gcfs+"】， 【时间"+gcsj+"】");
		try {
			long cjgcqh = Long.parseLong(qh.trim());
			Tzyrymd cjgczyry = tzyreService.selectBDJCbyqh(cjgcqh);
			Date datesj = new Date(Long.parseLong(gcsj.trim()));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String cjgcsj = sdf.format(datesj); //格式化时间
			String cjgcfs = String.valueOf(gcfs);//格式化分数
			request.setAttribute("gcsj", cjgcsj); // 出监观察时间
			request.setAttribute("gcfs", cjgcfs); //出监观察分数
			request.setAttribute("cjgcjyxx", cjgczyry.getTjczjdx()); //出监观察警员信息
			request.setAttribute("cjgczyry", cjgczyry); //出监观察罪犯信息
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("出监行为观察结果罪犯基础数据显示失败，请重试...");
		}
		return "/pcras/pggl/cj_rcgcrs";
	}

	// 出监行为观察量表
	@RequestMapping("/cj_rcgclb")
	public String cj_rcgclb(@RequestParam("qh") String qh, HttpServletRequest request) {
		long cjgcqh = Long.parseLong(qh); //获取出监观察囚号
		Tzyrymd cjzylbgc = tzyreService.selectBDJCbyqh(cjgcqh);
		request.setAttribute("cjzylbgc", cjzylbgc);
		request.setAttribute("cjlbjyxx", cjzylbgc.getTjczjdx());
		return "/pcras/pggl/cj_rcgclb";
	}

	// 出监社会适应性
	@RequestMapping("/cj_shsy")
	public String cj_shsy() {
		return "/pcras/pggl/cj_shsy";
	}

	// 出监社会适应性结果表
	@RequestMapping("/cj_shsyrs")
	public String cj_shsyrs() {
		return "/pcras/pggl/cj_shsyrs";
	}

	// 出监社会适应性量表
	@RequestMapping("/cj_shsylb")
	public String cj_shsylb() {
		return "/pcras/pggl/cj_shsylb";
	}

	// 出监scl90
	@RequestMapping("/cj_scl90")
	public String cj_scl90() {
		return "/pcras/pggl/cj_scl90";
	}

	// 出监scl90结果表
	@RequestMapping("/cj_scl90rs")
	public String cj_scl90rs() {
		return "/pcras/pggl/cj_scl90rs";
	}

	// 出监scl90量表
	@RequestMapping("/cj_scl90lb")
	public String cj_scl90lb() {
		return "/pcras/pggl/cj_scl90lb";
	}

	// 出监copa-pi
	@RequestMapping("/cj_copa")
	public String cj_copa() {
		return "/pcras/pggl/cj_copa";
	}

	// 出监copa-pi结果表
	@RequestMapping("/cj_copars")
	public String cj_copars() {
		return "/pcras/pggl/cj_copars";
	}

	// 出监copa-pi量表
	@RequestMapping("/cj_copalb")
	public String cj_copalb() {
		return "/pcras/pggl/cj_copalb";
	}

	// 出监心理测试
	@RequestMapping("/cj_xlcs")
	public String cj_xlcs() {
		return "/pcras/pggl/cj_xlcs";
	}

	// 出监心理测试结果
	@RequestMapping("/cj_xlcsrs")
	public String cj_xlcsrs() {
		return "/pcras/pggl/cj_xlcsrs";
	}

	// 罪犯基本信息
	@RequestMapping("/criminalinfo")
	public String criminalinfo(String qh,Model model) {
		log.info("【罪犯囚号"+qh+"】");
		try {
			BGjbxx crimInfo = vpgbgListService.crimInfoBycrimNo(qh.trim()); //查找罪犯的基础信息
			if(null!=crimInfo){
				model.addAttribute("jbxx", crimInfo); //罪犯基础的几项数据
				model.addAttribute("xxxx", crimInfo.getBgxxxx()); //罪犯重要的数据
				if(crimInfo.getBgxxxx().getXq().length()>4){
					String xq = DateUtil.fmtDate(crimInfo.getBgxxxx().getXq());
					model.addAttribute("xq", xq);
				}else{
					model.addAttribute("xq", crimInfo.getBgxxxx().getXq());
				}
				//格式化剥夺政治权利年限
				if(crimInfo.getBgxxxx().getBznx().length()>4){
					String bznx = DateUtil.fmtDate(crimInfo.getBgxxxx().getBznx());
					model.addAttribute("bznx", bznx);
				}else{
					model.addAttribute("bznx", crimInfo.getBgxxxx().getBznx());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("罪犯信息显示失败，请稍后重试...");
		}
		return "/pcras/pggl/criminalinfo";
	}


	// 出监评估录入
	@RequestMapping("/lr_cj")
	public String lr_cj() {
		return "/pcras/pggl/lr_cj";
	}
	//*********************************************************************************
	//*********************************************************************************
}
