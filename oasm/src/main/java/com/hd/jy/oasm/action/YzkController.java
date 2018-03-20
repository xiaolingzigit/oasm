package com.hd.jy.oasm.action;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.domain.WD;
import com.hd.jy.oasm.domain.newDomain.TdminfactorRelat;
import com.hd.jy.oasm.domain.newDomain.Twdyzgx;
import com.hd.jy.oasm.domain.newDomain.Tysk;
import com.hd.jy.oasm.services.LBKMService;
import com.hd.jy.oasm.services.TdminAndtyzService;
import com.hd.jy.oasm.util.Page;
import com.hd.jy.oasm.util.PageHelper;

/**
 * 
* @ClassName: YzkController 
* @Description: ���ӿ����
* @author liangjiaying
* @date 2017��11��15�� ����10:08:14 
*
 */
@Controller
@RequestMapping("yzk")
public class YzkController {
	
	static final Logger log = Logger.getLogger(YzkController.class);
	
	@Autowired
	private LBKMService lbkService;
	
	@Autowired
	private TdminAndtyzService tdminAndtyzService; //���Ӻ�ά�Ȳ����ӿ�
	
	// ���ӿ������ά��
	@RequestMapping(value = "/yzManager")
	public String getAllYzk(Model model){
		List<TdminfactorRelat> dimAndFactor = null;
		try {
			dimAndFactor = tdminAndtyzService.selectDimAndFactor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��ѯ���Ӻ�ά�ȹ�ϵ�б�ʧ�ܣ�������...");
		}
		model.addAttribute("dafList", dimAndFactor);
		return "/systemBlank/yzManager";
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectAllWd", method = {RequestMethod.GET,RequestMethod.POST})
	public List<WD> selectAllWd(){
		List<WD> selectAllWd = null;
		try {
			selectAllWd = lbkService.selectAllWd();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("��ȡά���б����"+e);
		}
		return selectAllWd;
	}
	
	/*****************************���²���Ϊ������Ƶ����Ӻ�ά��***********************************************/
	/**
	 * 
	 * @todo TODO ������ӻ���ά��
	 * @param ysbh  @param ysmc @param yssx @param sm  @param ytxz @param session
	 * @return
	 * @auth quite
	 * @time 2018��1��12�� ����7:03:40
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/addTysk",method={RequestMethod.GET,RequestMethod.POST})
	public int addTysk(String ysbh,String ysmc,String yssx,String sm,String ytxz,HttpSession session){
		int i = 0;
		Tysk tk = null;
		try {
			String username = (String)session.getAttribute("username");
			log.info("������ӻ�ά�ȵġ��û���"+username+"���������"+ysbh+"����������"+ysmc+"����������"+yssx+"������˵��"+sm+"��������;"+ytxz+"");
			tk = new Tysk();
			if(null!=username){
				tk.setYsbh(ysbh.trim());
				tk.setYsmc(ysmc.trim());
				tk.setYssx(yssx.trim());
				tk.setSm(sm.trim());
				tk.setYtxz(ytxz.trim());
				tk.setYzfz(1.0);
				tk.setCjsj(new Date());
				tk.setCjrbh(username);
				tk.setXgsj(new Date());
				tk.setXgrbh(username);
				i = tdminAndtyzService.addTysk(tk);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("������ӻ���ά��ʧ�ܣ����ȵ�¼�û�");
		}
		return i;
	}
	
	/**
	 * 
	 * @todo TODO ������Ӻ�ά�ȹ�ϵ
	 * @param wdId  @param yzId @param sm @param session
	 * @return
	 * @auth quite
	 * @time 2018��1��13�� ����4:56:45
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/addaddTwdyzgx",method={RequestMethod.GET,RequestMethod.POST})
	public int addaddTwdyzgx(int wdId,int yzId,String sm,HttpSession session){
		int i = 0;
		try {
			Twdyzgx tw = null;
			String username = (String)session.getAttribute("username");
			log.info("������Ӻ�ά�ȹ�ϵ�ġ�ά�ȱ��"+wdId+"���������ӱ��"+yzId+"������˵��"+sm+"�������û���"+username+"��");
			if(null!=username){
				tw = new Twdyzgx();
				tw.setWdid(wdId);
				tw.setYzid(yzId);
				tw.setSm(sm);
				tw.setQyzt(1); //����״̬
				tw.setCjsj(new Date());
				tw.setCjrbh(username);
				tw.setXgsj(new Date());
				tw.setXgrbh(username);
				i = tdminAndtyzService.addTwdyzgx(tw);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("���ά�Ⱥ����ӹ�ϵʧ�ܣ��������Ա��¼״̬!");
		}
		return i;
	}
	
	/**
	 * 
	 * @todo TODO ��ҳ�Ӽ���ά����Ϊ��ӹ�ϵ��Ҫ
	 * @param pageSize  @param pageNum @param ysbh @param ysmc
	 * @return
	 * @auth quite
	 * @time 2018��1��13�� ����5:09:39
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/likeTWLine",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> likeTWLine(int pageSize,int pageNum,String ysbh,String ysmc){
		log.info("��������ά�ȴ�ֵ:��ÿҳ����"+pageSize+"����ҳ��"+pageNum+"�������"+ysbh+"��������"+ysmc+"��");
		Map<String,Object> pmap = new HashMap<String,Object>(); //����ǰ��ʹ��
		try {
			Map<String,String> map = new HashMap<String,String>(); //��ֵʹ��
			map.put("ysbh", ysbh);
			map.put("ysmc", ysmc);
			PageHelper.startPage(pageNum, pageSize);
			tdminAndtyzService.likeSomeWdKey(map);
			@SuppressWarnings("rawtypes")
			Page page = PageHelper.endPage();
			pmap.put("page", page); //�����Ѿ�����page������
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("����ά��ʧ�ܣ�������...");
		}
		return pmap;
	}
	
	/**
	 * 
	 * @todo TODO ��ҳ����һ����������Ϊ��ӹ�ϵ��Ҫ
	 * @param pageSize @param pageNum @param ysbh @param ysmc
	 * @return
	 * @auth quite
	 * @time 2018��1��13�� ����5:16:42
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/likeSomeYsk",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> likeSomeYsk(int pageSize,int pageNum,String ysbh,String ysmc){
		log.info("�����������Ӵ�ֵ:��ÿҳ����"+pageSize+"����ҳ��"+pageNum+"�������"+ysbh+"��������"+ysmc+"��");
		Map<String,Object> pmap = new HashMap<String,Object>();
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("ysbh", ysbh);
			map.put("ysmc", ysmc);
			PageHelper.startPage(pageNum, pageSize);
			tdminAndtyzService.likeSomeTyskKey(map);
			@SuppressWarnings("rawtypes")
			Page page = PageHelper.endPage();
			pmap.put("page", page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("��������ʧ�ܣ�������...");
		}
		return pmap;
	}
	
	/**
	 * @todo TODO �������Ӻ�ά��
	 * @param pageSize @param pageNum @param ysbh @param ysmc @param yssx @param ytxz @param yzzpc
	 * @param zsxgpc @param xxxgpc @param ttxgpc @param zfzxgpc @param cjsj1 @param cjsj2 @param xgsj1 @param xgsj2
	 * @return
	 * @auth quite
	 * @time 2018��1��13�� ����6:09:59
	 */
	@ResponseBody
	@RequestMapping(value="/likeTyskLine",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> likeTyskLine(int pageSize,int pageNum,String ysbh,String ysmc,String yssx,String ytxz,String yzzpc,String zsxgpc,String xxxgpc,String ttxgpc,String zfzxgpc,String cjsj1,String cjsj2,String xgsj1,String xgsj2){
		log.info("�������Ӻ�ά��:������"+pageSize+"������ҳ��"+pageNum+"�������"+ysbh+"��������"+ysmc+"��������"+yssx+"������;"+ytxz+"��");
		log.info("��������Ƶ�Ρ���Ƶ��"+yzzpc+"������ɱƵ��"+zsxgpc+"��������Ƶ��"+xxxgpc+"��������Ƶ��"+ttxgpc+"�����ٷ���Ƶ��"+zfzxgpc+"��");
		log.info("�������Ӻ�ά��ʱ�䡾����ʱ��"+cjsj1+"������"+cjsj2+"�����޸�ʱ��"+xgsj1+"������"+xgsj2+"��");
		Map<String,Object> pmap = new HashMap<String,Object>();
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("ysbh", ysbh.trim());
			map.put("ysmc", ysmc.trim());
			map.put("yssx", yssx.trim());
			map.put("ytxz", ytxz.trim());
			map.put("yzzpc", yzzpc.trim());
			map.put("zsxgpc", zsxgpc.trim());
			map.put("xxxgpc", xxxgpc.trim());
			map.put("ttxgpc", ttxgpc.trim());
			map.put("zfzxgpc", zfzxgpc.trim());
			map.put("cjsj1", cjsj1.trim()); //��ʽ2018-01-13
			map.put("cjsj2", cjsj2.trim());
			map.put("xgsj1", xgsj1.trim()); //��ʽ 2018-01-13
			map.put("xgsj2", xgsj2.trim());
			PageHelper.startPage(pageNum, pageSize);
			tdminAndtyzService.likeTyskKey(map);
			@SuppressWarnings("rawtypes")
			Page page = PageHelper.endPage();
			pmap.put("page", page); //���ؽ������page��
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�������ӻ���ά��ʧ�ܣ�������...");
		}
		return pmap;
	}
	
	/**
	 * @todo TODO �޸����ӻ���ά��
	 * @param ysbh @param ysmc @param yssx @param ytxz
	 * @param session
	 * @return
	 * @auth quite
	 * @time 2018��1��13�� ����6:18:57
	 */
	@ResponseBody
	@RequestMapping(value="/updateYsk",method={RequestMethod.GET,RequestMethod.POST})
	public int updateYsk(int ysid,String ysbh,String ysmc,String yssx,String ytxz,HttpSession session){
		int i =0;
		Tysk ty = null;
		try {
			String username = (String)session.getAttribute("username");
			log.info("�޸����ӻ���ά�ȵġ�ID"+ysid+"�������"+ysbh+"��������"+ysmc+"��������"+yssx+"������;"+ytxz+"����"+username+"��");
			if(null!=username){
				ty = new Tysk();
				ty.setYsid(ysid);
				ty.setYsbh(ysbh);
				ty.setYsmc(ysmc);
				ty.setYssx(yssx);
				ty.setYtxz(ytxz);
				ty.setXgsj(new Date());
				ty.setXgrbh(username);
				i = tdminAndtyzService.updateTysk(ty);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("�޸�ά�Ȼ�������ʧ�ܣ�������...");
		}
		return i;
	}
	
}


















