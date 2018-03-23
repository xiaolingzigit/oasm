package com.hd.jy.oasm.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hd.jy.oasm.domain.LBKM;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.services.LBKMService;
import com.hd.jy.oasm.services.TdminAndtyzService;

/***
 * 
 * @author quite ����������
 */
@Controller
@RequestMapping("lbk")
public class LBKController {
	private Logger log = Logger.getLogger(LBKController.class);

	@Autowired
	private LBKMService lbkmService;

	@Autowired
	private TdminAndtyzService tdminAndyzService;
	

	// ����������ά��
	@RequestMapping(value = "/lbkManager")
	public String lbkManager(Model model) {
		List<Tscale> list = null;
		try {
			list = tdminAndyzService.scaleAllListStatus(); //ʹ��TScale���������
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("������ѯ�쳣��������...");
		}
		model.addAttribute("lbkList", list);
		return "/systemBlank/lbkManager";
	}

//	// �������fl���ʹ�õ�����
//	@ResponseBody
//	@RequestMapping(value = "/waitRjlbtmda", method = { RequestMethod.GET, RequestMethod.POST })
//	public List<LBKM> waitRjlbtmda(String lbbh) {
//		List<LBKM> rjlbtmyz = null;
//		if (lbbh != null && lbbh != "") {
//			try {
//				rjlbtmyz = lbkmService.rjlbtmyz(lbbh);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				log.error("ʹ�á�lbbh�����ʹ�õ������쳣��������...");
//			}
//			return rjlbtmyz; // ���������ݵı���
//		} else {
//			return rjlbtmyz; // ���������ݵı���
//		}
//
//	}

//	// �����ճ�����fl���ʹ�õ�����
//	@ResponseBody
//	@RequestMapping(value = "/waitRclbtmda", method = { RequestMethod.GET, RequestMethod.POST })
//	public List<LBKM> waitRclbtmda(String fl) {
//		List<LBKM> rclbtmyz = null;
//		if (fl != null & fl != "") {
//			try {
//				rclbtmyz = lbkmService.rclbtmyz(fl);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				log.error("���ݡ��ճ�����" + fl + "����ѯ�쳣��������...");
//			}
//			return rclbtmyz;
//		} else {
//			return rclbtmyz;
//		}
//	}

//	// ������������fl���ʹ�õ�����
//	@ResponseBody
//	@RequestMapping(value = "/waitZqlbtmda", method = { RequestMethod.GET, RequestMethod.POST })
//	public List<LBKM> waitZqlbtmda(String fl) {
//		List<LBKM> zqlbtmyz = null;
//		if (fl != null & fl != "") {
//			try {
//				zqlbtmyz = lbkmService.zqlbtmyz(fl);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				log.error("ʹ�����ڡ�lb����ѯʹ�õ������쳣��������...");
//			}
//			return zqlbtmyz;
//		} else {
//			return zqlbtmyz;
//		}
//	}

	// ���ݳ�������fl���ʹ�õ�����
	@ResponseBody
	@RequestMapping(value = "/waitCjlbtmda", method = { RequestMethod.GET, RequestMethod.POST })
	public List<LBKM> waitCjlbtmda(String fl) {
		List<LBKM> cjlbtmyz = null;
		if (fl != null & fl != "") {
			try {
				cjlbtmyz = lbkmService.cjlbtmyz(fl);
				log.info(JSON.toJSON(cjlbtmyz));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("���ݡ���������" + fl + "����ѯʹ�õ������쳣��������...");
			}
			return cjlbtmyz;
		} else {
			return cjlbtmyz;
		}
	}

	// ���ô洢���̹رջ�������
	@ResponseBody
	@RequestMapping(value = "/closeOrstartLBKM", method = { RequestMethod.GET, RequestMethod.POST })
	public int closeOrstartLBKM(String lbbh) {
		int i = 0;
		try {
			if (lbbh != null && lbbh != "") {
				i = lbkmService.closeOrstartLBKMisLive(lbbh);
				log.info("�ɹ��رջ�������" + i + "��");
			} else {
				log.info("lbbhΪ==>" + lbbh);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("������ر������쳣��������...");
		}
		return i;
	}

	// ���ӿ������ά��
	@RequestMapping(value = "/yzManager")
	public String yzManager() {
		return "/systemBlank/yzManager";
	}

	// ���ظ����׶�����
	@ResponseBody
	@RequestMapping(value = "/jdlb", method = { RequestMethod.GET, RequestMethod.POST })
	public List<LBKM> getRJLB(String jd) {// jd�׶α�ţ�1��࣬2�ճ���3���ڣ�4���ࣩ
		List<LBKM> selectAllkm = null;
		try {
			selectAllkm = lbkmService.selectRDLB(jd);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("����lb_km�е����׶ε���������" + e);
		}
		return selectAllkm;
	}

	// ******************************ǰ̨����¼�벿��*****��ಿ��*************************************************************
	
	// **************************���ಿ�ֽ���������¼�벿�ֽ���******************************************************************
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// *******************************�쳣���鲿��*************************************************************
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	@ResponseBody
//	@RequestMapping(value = "/ycyqpc", method = { RequestMethod.GET, RequestMethod.POST })
//	public List<ZCYCYQPC> ycyqpc(String qh) {
//	    List<ZCYCYQPC> ycyq = null;
//		try {
//			ycyq = lbkmService.selectYCYQ(qh);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("�������Ż�ȡ�쳣����ʧ�ܣ�������...");
//		}
//		return ycyq;
//
//	}
	
	@ResponseBody
	@RequestMapping(value="/lookupScale",method={RequestMethod.GET,RequestMethod.POST})
	public String lookupScale(int scaleId){
		String scale = null;
		try {
			scale = lbkmService.scaleRelatById(scaleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�����Ԥ��ʧ�ܣ����Ժ�����...");
		}
		return scale;
	}
}
