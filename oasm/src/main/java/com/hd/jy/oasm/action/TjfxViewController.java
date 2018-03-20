package com.hd.jy.oasm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.domain.TWpqk;
import com.hd.jy.oasm.domain.VPgbgWxlx;
import com.hd.jy.oasm.domain.VTjwxcd;
import com.hd.jy.oasm.domain.VTjwxlx;
import com.hd.jy.oasm.domain.Vtjzfz;
import com.hd.jy.oasm.domain.Vwxlx;
import com.hd.jy.oasm.services.TWpqkServices;
import com.hd.jy.oasm.services.VTjwxcdService;

@Controller
@RequestMapping("tjfxView")
public class TjfxViewController {

	private static Logger logging = Logger.getLogger(TjfxViewController.class);

	@Autowired
	private VTjwxcdService vTjwxcdService;

	@Autowired
	private TWpqkServices tWpqkServices;
	
	// Σ������仯
	@RequestMapping("/wpqkbh")
	public String wpqkbh() {
		return "/pcras/tjfx/wpqkbh";
	}

	// Σ�ճ̶�ͳ��
	@RequestMapping("/wpcdtj")
	public String wpcdtj() {
		return "/pcras/tjfx/wpcdtj";
	}

	// Σ�����ͳ��
	@RequestMapping("/wxlbtj")
	public String wxlbtj() {
		return "/pcras/tjfx/wxlbtj";
	}
	//�ﷸ��ɱ������������ͳ��
	@RequestMapping("/zxttj")
	public String zxttj(){
		return "/pcras/tjfx/zxttj";
	}
	// �ﷸ�����ٷ�������ͳ��
	@RequestMapping("/cjzftj")
	public String cjzftj(){
		return "/pcras/tjfx/cjzftj";
	}
	// �������ͳ��
	@RequestMapping("/czqktj")
	public String czqktj(){
		return "/pcras/tjfx/czqktj";
	} 
	// �������ͳ��
	@RequestMapping("/pgqktj")
	public String pgqktj() {
		return "/pcras/tjfx/pgqktj";
	}

	// Ԥ��ͳ��
	@RequestMapping("/yjtj")
	public String yjtj() {
		return "/pcras/tjfx/yjtj";
	}

	// �����ﷸͳ��ѡ�
	@RequestMapping("/glzftj")
	public String glzftj() {
		return "/pcras/tjfx/glzftj";
	}

	// �����ﷸͳ��
	@RequestMapping("/tj_glzf")
	public String tj_glzf() {
		return "/pcras/tjfx/tj_glzf";
	}

	// ��Σ��ͳ��
	@RequestMapping("/tj_wwf")
	public String tj_wwf() {
		return "/pcras/tjfx/tj_wwf";
	}

	// ��Σ��ͳ��
	@RequestMapping("/tj_waf")
	public String tj_waf() {
		return "/pcras/tjfx/tj_waf";
	}

	// ��Σ��ͳ��
	@RequestMapping("/tj_jsbf")
	public String tj_jsbf() {
		return "/pcras/tjfx/tj_jsbf";
	}

	@RequestMapping("/tj_zdf")
	public String tj_zdf() {
		return "/pcras/tjfx/tj_zdf";
	}

	@RequestMapping("/tj_wjf")
	public String tj_wjf() {
		return "/pcras/tjfx/tj_wjf";
	}

	// Σ�����ӷ���
	@RequestMapping("/wxyzfx")
	public String wxyzfx() {
		return "/pcras/tjfx/wxyzfx";
	}

	// Σ�ճ̶�ͳ������echarts
	// ÿ��������Σ�ճ̶�����
	@ResponseBody
	@RequestMapping(value = "/listVTjwxcd", method = { RequestMethod.GET, RequestMethod.POST })
	public List<VTjwxcd> listVTjwxcd() {
		List<VTjwxcd> vTjwxcd = null;
		try {
			vTjwxcd = vTjwxcdService.listVTjwxcd();
		} catch (Exception e) {
			// TODO: handle exception
			logging.error("TjfxViewController.getListWxcd():��������" + e);
		}
		return vTjwxcd;
	}

	//���Կ�����ͼ����ʾ
	// Σ������仯
	@ResponseBody
	@RequestMapping(value = "/getWpqkbh", method = { RequestMethod.GET, RequestMethod.POST })
	public HashMap<String, List<TWpqk>> getWpqkbh(String sj1, String sj2) {
		HashMap<String, List<TWpqk>> hashMap = new HashMap<>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startTime = sdf.parse(sj1);
			Date endTime = sdf.parse(sj2);
			if (sj2.equals(sj1)) {
				List<TWpqk> list1 = tWpqkServices.getDate(startTime);
				hashMap.put("list1", list1);
				hashMap.put("list2", list1);
			} else {
				List<TWpqk> list1 = tWpqkServices.getDate(startTime);
				List<TWpqk> list2 = tWpqkServices.getDate(endTime);
				hashMap.put("list1", list1);
				hashMap.put("list2", list2);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logging.error("TjfxViewController.getWpqkbh();��������" + e);
		}
		return hashMap;
	}

	@ResponseBody
	@RequestMapping(value = "/getTopDate", method = { RequestMethod.GET, RequestMethod.POST })
	public String getTopDate() {
		String date = "";
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").format(tWpqkServices.getTopDate());
		} catch (Exception e) {
			// TODO: handle exception
			logging.error("TjfxViewController.getTopDate();����" + e);
		}
		return date;
	}

	/**
	 * @Date: 2017��12��28�� ����10:32:00
	 * @author liangjiaying
	 * @Title: getVPgbgWxlx
	 * @Description: ����Σ�������б�
	 */
	@ResponseBody
	@RequestMapping(value = "/getVPgbgWxlx", method = { RequestMethod.GET, RequestMethod.POST })
	public List<VPgbgWxlx> getVPgbgWxlx() {
		List<VPgbgWxlx> vPgbgWxlx = null;
		try {
			vPgbgWxlx = vTjwxcdService.getVPgbgWxlx();
		} catch (Exception e) {
			logging.error("TjfxViewController#getVPgbgWxlx " + e);
		}
		return vPgbgWxlx;
	}

	/**
	 * @Date: 2018��1��5�� ����10:00:06 
	 * @author liangjiaying 
	 * @Title: getVTjwxlx 
	 * @Description: ͳ�Ƹ���������Σ���������� 
	 * List<VTjwxlx> @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/getVTjwxlx", method = { RequestMethod.GET, RequestMethod.POST })
	public List<VTjwxlx> getVTjwxlx() {
		List<VTjwxlx> vTjwxlx = null;
		try {
			vTjwxlx = vTjwxcdService.getVTjwxlx();
		} catch (Exception e) {
			logging.error("TjfxViewController#getVTjwxlx;" + e);
		}
		return vTjwxlx;
	}

	/**
	 * @Date: 2018��1��13�� ����5:51:21
	 * @author liangjiaying
	 * @Title: listTjZfz  
	 * @Description: ͳ�Ƴ����ٷ�������
	 * @param: @return      
	 * @return: List<Vtjzfz>      
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/listTjZfz",method = {RequestMethod.GET,RequestMethod.POST})
	public List<Vtjzfz> listTjZfz(){
		List<Vtjzfz> listTjZfz = null;
		try {
			listTjZfz = vTjwxcdService.listTjZfz();
		} catch (Exception e) {
			logging.error("TjfxViewController#listTjZfz:����"+e);
		}
		return listTjZfz;
	}
	
	
	/**
	 * @Date: 2018��1��13�� ����6:02:50
	 * @author liangjiaying
	 * @Title: listTjWxlx  
	 * @Description: ͳ�Ƹ�������Σ���������
	 * @param: @return      
	 * @return: List<Vwxlx>      
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/listTjWxlx", method = {RequestMethod.GET,RequestMethod.POST})
	public List<Vwxlx> listTjWxlx() {
		List<Vwxlx> listTjWxlx = null;
		try {
			listTjWxlx = vTjwxcdService.listTjWxlx();
		} catch (Exception e) {
			logging.error("TjfxViewController#listTjWxlx:����"+e);
		}
		return listTjWxlx;
	}
	
}
