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
	private ViewftjgAndxwgcService viewftAndgcService; // ��������̸�͹۲�������ͼ���ز����ӿڣ����Ե������µ�
	
	@Autowired
	private SjjgftAndxwgcService sjjgftAndxwgcService; //���µ��������߼��ӿڣ�ҳ����ʾ�����������Լ����Ӻͷ���ʹ��
	
	@Autowired
	private TzyrymdService tzyreService; // ��Ѻ��Ա�����߼��ӿ�
	
	@Autowired
	private VPgbgListService vpgbgListService; //�����������������ﷸ�Ļ�����Ϣ����
	
	//��װ��ȡ��ǰ��¼����
    public static String getJhforView(){ //����Ҫ����ͼ��ȡ����
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
//*************************����¼����ͼ����*******************************************
//*********************************************************************************
	/***
	 * ��ȡ�����̸��ҳ���ݵ���ͼ
	 * @auto quite
	 * @param num
	 * @param size
	 * @returna
	 * ����6:57:33
	 * Map<Object,Object>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/cjftView_json",method={RequestMethod.GET,RequestMethod.POST})
	public Map<Object,Object> cjftView_json(int num,int size,String gyjq,String qh,String xm,String jhxm,String ftzt){
		log.info("����Ѻ����"+gyjq+"����������"+qh+"����������"+xm+"��������������"+jhxm+"������״̬"+ftzt+"��");
		String jh = getJhforView();//��ȡ����
		Map<Object, Object> cjftMap = new HashMap<>();
		Map<String,Object> map = new HashMap<>();
		List<Viewpggl> cjftvp = null;
		try {
			PageHelper.startPage(num, size);
			map.put("jh", jh);
//			map.put("gyjq", gyjq); //����׶���ʱ��ʹ��
			map.put("crim_no", qh);
			map.put("xm", xm);
			map.put("jhxm", jhxm);
			map.put("status", ftzt);
			cjftvp = viewftAndgcService.cjjgftViewpggl(map);
			Page page = PageHelper.endPage();
			cjftMap.put("cjftvp", cjftvp); //�����̸�ķ�ҳ��ͼ
			cjftMap.put("page", page); //
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�����̸��ҳ���ݻ�ȡ�쳣��������...");
		}
		return cjftMap;
	}
	
	// ���൵������
	@RequestMapping("/cj_dafx")
	public String cj_dafx() {
		return "/pcras/pggl/cj_dafx";
	}

	// ���൵���������
	@RequestMapping("/cj_dafxrs")
	public String cj_dafxrs() {
		return "/pcras/pggl/cj_dafxrs";
	}

	// ���൵����������
	@RequestMapping("/cj_dafxlb")
	public String cj_dafxlb() {
		return "/pcras/pggl/cj_dafxlb";
	}

	// ����ṹ�Է�̸
	@RequestMapping("/cj_jgft")
	public String cj_jgft(Model model) {
		String jh = getJhforView();
		List<Viewcjjgft> viewcjjgft = null;
		try {
			viewcjjgft = viewftAndgcService.showViewcjjgft(jh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ݾ��Ŷ�̬��ȡ����ṹ��̸����ʧ�ܣ�������...");
		}
		model.addAttribute("viewcjjgftList", viewcjjgft);
		return "/pcras/pggl/cj_jgft";
	}

	// ����ṹ�Է�̸�����
	@RequestMapping("/cj_jgftrs")
	public String cj_jgftrs(@RequestParam("qh") String qh,int ftfs,String ftsj, HttpServletRequest request) {
		log.info("���ࡾ�ṹ��̸����"+qh+"��������̸����"+ftfs+"��������̸ʱ��"+ftsj+"��");
		try {
			long cjftqh = Long.parseLong(qh.trim());
			Tzyrymd cjftzyry = tzyreService.selectBDJCbyqh(cjftqh); //���ݳ���ṹ��̸�����Ż�ȡ�ﷸ����
			Date datesj = new Date(Long.parseLong(ftsj.trim()));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String cjftsj = sdf.format(datesj); //��ʽ����ʱ��
			String cjftfs = String.valueOf(ftfs); //��ʽ���ķ���
			request.setAttribute("ftsj", cjftsj); //��̸ʱ��
			request.setAttribute("ftfs", cjftfs); //��̸����
			request.setAttribute("cjftjyxx", cjftzyry.getTjczjdx()); //��Ա��Ϣ
			request.setAttribute("cjftzyry", cjftzyry); //������Ϣ
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ʾ����ṹ��̸������������Ϣʧ�ܣ�������...");
		}
		return "/pcras/pggl/cj_jgftrs";
	}

	// ����ṹ�Է�̸����
	@RequestMapping("/cj_jgftlb")
	public String cj_jgftlb(@RequestParam("qh") String qh, HttpServletRequest request) {
		long cjftqh = Long.parseLong(qh.trim()); //��ȡ�����̸����
		Tzyrymd cjzyftlb = tzyreService.selectBDJCbyqh(cjftqh);
		request.setAttribute("cjzyft", cjzyftlb); //���ͳ�������
		request.setAttribute("cjftlbjyxx", cjzyftlb.getTjczjdx()); //��������Ա��ҳ��
		return "/pcras/pggl/cj_jgftlb";
	}

	
	/***
	 * ����۲��ҳ������ͼ��ʾ
	 * @auto quite
	 * @param num
	 * @param size
	 * @returna
	 * ����7:02:19
	 * Map<Object,Object>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/cjgcView_json",method={RequestMethod.GET,RequestMethod.POST})
	public Map<Object,Object> cjgcView_json(int num,int size,String gyjq,String qh,String xm,String jhxm,String gczt){
		log.info("����Ѻ����"+gyjq+"����������"+qh+"����������"+xm+"��������������"+jhxm+"������״̬"+gczt+"��");
		String jh = getJhforView();//��ȡ����
		Map<Object, Object> cjgcMap = new HashMap<>();
		Map<String,Object> map = new HashMap<>();
		List<Viewpggl> cjgcvp = null;
		try {
			PageHelper.startPage(num, size);
			map.put("jh", jh);
//			map.put("gyjq", gyjq); //����׶���ʱȡ��ʹ��
			map.put("crim_no", qh);
			map.put("xm", xm);
			map.put("jhxm", jhxm);
			map.put("status", gczt);
			cjgcvp = viewftAndgcService.cjxwgcViewpggl(map);
			Page page = PageHelper.endPage();
			cjgcMap.put("cjgcvp", cjgcvp); //����۲��ҳ����ʹ��map����
			cjgcMap.put("page", page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("����۲��ҳ���ݻ�ȡʧ�ܣ�������...");
		}
		return cjgcMap;
	}
	// ������Ϊ�۲�
	@RequestMapping("/cj_rcgc")
	public String cj_rcgc(Model model) {
		String jh = getJhforView();
		List<Viewcjxwgc> viewcjxwgc = null;
		try {
			viewcjxwgc = viewftAndgcService.findViewcjxwgc(jh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ݾ��Ŷ�̬��ȡ������Ϊ�۲�����ʧ�ܣ�������...");
		}
		model.addAttribute("viewcjxwgcList", viewcjxwgc);
		return "/pcras/pggl/cj_rcgc";
	}

	// ������Ϊ�۲�����
	@RequestMapping("/cj_rcgcrs")
	public String cj_rcgcrs(@RequestParam("qh") String qh,int gcfs,String gcsj, HttpServletRequest request) {
		log.info("���ࡾ��Ϊ�۲�����"+qh+"������ ����"+gcfs+"���� ��ʱ��"+gcsj+"��");
		try {
			long cjgcqh = Long.parseLong(qh.trim());
			Tzyrymd cjgczyry = tzyreService.selectBDJCbyqh(cjgcqh);
			Date datesj = new Date(Long.parseLong(gcsj.trim()));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String cjgcsj = sdf.format(datesj); //��ʽ��ʱ��
			String cjgcfs = String.valueOf(gcfs);//��ʽ������
			request.setAttribute("gcsj", cjgcsj); // ����۲�ʱ��
			request.setAttribute("gcfs", cjgcfs); //����۲����
			request.setAttribute("cjgcjyxx", cjgczyry.getTjczjdx()); //����۲쾯Ա��Ϣ
			request.setAttribute("cjgczyry", cjgczyry); //����۲��ﷸ��Ϣ
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������Ϊ�۲����ﷸ����������ʾʧ�ܣ�������...");
		}
		return "/pcras/pggl/cj_rcgcrs";
	}

	// ������Ϊ�۲�����
	@RequestMapping("/cj_rcgclb")
	public String cj_rcgclb(@RequestParam("qh") String qh, HttpServletRequest request) {
		long cjgcqh = Long.parseLong(qh); //��ȡ����۲�����
		Tzyrymd cjzylbgc = tzyreService.selectBDJCbyqh(cjgcqh);
		request.setAttribute("cjzylbgc", cjzylbgc);
		request.setAttribute("cjlbjyxx", cjzylbgc.getTjczjdx());
		return "/pcras/pggl/cj_rcgclb";
	}

	// ���������Ӧ��
	@RequestMapping("/cj_shsy")
	public String cj_shsy() {
		return "/pcras/pggl/cj_shsy";
	}

	// ���������Ӧ�Խ����
	@RequestMapping("/cj_shsyrs")
	public String cj_shsyrs() {
		return "/pcras/pggl/cj_shsyrs";
	}

	// ���������Ӧ������
	@RequestMapping("/cj_shsylb")
	public String cj_shsylb() {
		return "/pcras/pggl/cj_shsylb";
	}

	// ����scl90
	@RequestMapping("/cj_scl90")
	public String cj_scl90() {
		return "/pcras/pggl/cj_scl90";
	}

	// ����scl90�����
	@RequestMapping("/cj_scl90rs")
	public String cj_scl90rs() {
		return "/pcras/pggl/cj_scl90rs";
	}

	// ����scl90����
	@RequestMapping("/cj_scl90lb")
	public String cj_scl90lb() {
		return "/pcras/pggl/cj_scl90lb";
	}

	// ����copa-pi
	@RequestMapping("/cj_copa")
	public String cj_copa() {
		return "/pcras/pggl/cj_copa";
	}

	// ����copa-pi�����
	@RequestMapping("/cj_copars")
	public String cj_copars() {
		return "/pcras/pggl/cj_copars";
	}

	// ����copa-pi����
	@RequestMapping("/cj_copalb")
	public String cj_copalb() {
		return "/pcras/pggl/cj_copalb";
	}

	// �����������
	@RequestMapping("/cj_xlcs")
	public String cj_xlcs() {
		return "/pcras/pggl/cj_xlcs";
	}

	// ����������Խ��
	@RequestMapping("/cj_xlcsrs")
	public String cj_xlcsrs() {
		return "/pcras/pggl/cj_xlcsrs";
	}

	// �ﷸ������Ϣ
	@RequestMapping("/criminalinfo")
	public String criminalinfo(String qh,Model model) {
		log.info("���ﷸ����"+qh+"��");
		try {
			BGjbxx crimInfo = vpgbgListService.crimInfoBycrimNo(qh.trim()); //�����ﷸ�Ļ�����Ϣ
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
		return "/pcras/pggl/criminalinfo";
	}


	// ��������¼��
	@RequestMapping("/lr_cj")
	public String lr_cj() {
		return "/pcras/pggl/lr_cj";
	}
	//*********************************************************************************
	//*********************************************************************************
}
