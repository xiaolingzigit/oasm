package com.hd.jy.oasm.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.jy.oasm.annotation.Log;
import com.hd.jy.oasm.domain.GroupMan;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.newDomain.Tip;
import com.hd.jy.oasm.services.JyxxService;
import com.hd.jy.oasm.services.TzyrymdService;
import com.hd.jy.oasm.util.file.FileDataCheck;
import com.hd.jy.oasm.util.file.ReadExcelUtil;
import com.hd.jy.oasm.util.lsc.GsonUtil;

/***
 * 
 * @author quite
 * ����excel�ļ�����ͼ���������������
 *
 */
@Controller
@RequestMapping("excelView")
public class ExcelViewController {
	private Logger log = Logger.getLogger(ExcelViewController.class);
	
  
  @Autowired
  private TzyrymdService tzrymdService; //���������Ա���������ӿ�  �����ﷸ
  
  @Autowired
  private JyxxService jyxxService; //������Ϣ�����ӿ�
 
  //ͳһ�ĵ����ļ�����·�����
  public static String getFileName(String file){
	  String[] splitfile = file.split("\\\\");
	  //��ȡ�ļ���б��\����ַ�
	  String fileName = splitfile[splitfile.length-1];
	  
	  //Ϊ�˷�����ģ����巽��ͳһʹ�ø�·��
	  String fileValue = "E:\\projectExcel\\pad\\"+fileName;
	  return fileValue;
  }
  
  /***
   * //ʹ��excel���뾯�����ﷸ��ϵ
   * @auto quite
   * @param file
   * @param session
   * @returna �����ص�json�ַ�����ʾһ��list�ļ���
   * ����10:26:42
   * int
   */
  
  @ResponseBody
  @RequestMapping(value="/inputCPforExcel",method={RequestMethod.GET,RequestMethod.POST})
  public String inputCPforExcel(String file,HttpSession session){
	  String username = (String)session.getAttribute("username");
	  log.info("username==>"+username+"file==>"+file);
	  int i = 0;
	  List<Tjczjdx> tcdxList = new ArrayList<>();
	  ReadExcelUtil eu = new ReadExcelUtil();    
      //0��ʾ�ӵ�һ�п�ʼ��ȡ    
      eu.setStartReadPos(1);   
	  
      //���÷�����ȡ�ļ���·��
	  String fileValue = getFileName(file);
	  List<Row> rowList = null;
	  Tjczjdx tzjdx = null; //����ר�̶���
	  String jsTCDX = "";
	  try {
		  if(username!=null&&username!=""){
			 rowList = eu.readExcel(fileValue);
			  for (Row row : rowList) {
				Cell cellqh = row.getCell(0);
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING); //������ֵ����ΪString����
				String qh = cellqh.getStringCellValue().trim(); //����
				Cell cellxm = row.getCell(1);
				String xm = cellxm.getStringCellValue().trim(); //����
				Cell celljh = row.getCell(2);
				 row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				String jh = celljh.getStringCellValue().trim(); //����
				Cell celljhxm = row.getCell(3);
				String jhxm = celljhxm.getStringCellValue().trim(); //ר������
				Cell cellxjbh = row.getCell(4);
				 row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				String xjbh = cellxjbh.getStringCellValue().trim(); //Э������
				Cell cellxjxm = row.getCell(5);
				String xjxm = cellxjxm.getStringCellValue().trim(); //Э������
				
				
				tzjdx = new Tjczjdx();
				tzjdx.setQh(Long.parseLong(qh)); //����
				tzjdx.setXm(xm); //��������
				tzjdx.setJh(jh); //����
				tzjdx.setJhxm(jhxm); //��������
				tzjdx.setXjbh(xjbh); //Э�����
				tzjdx.setXjxm(xjxm); //Э������
				
				tcdxList.add(tzjdx);
				
				
				i = tzrymdService.crimPlaceSaveOrUpdate(tzjdx);
				if(i==1){
					jsTCDX = GsonUtil.toJson(tcdxList); //�������ɹ����򷵻�һ��json���ַ�������
				}else{
					log.error("��������뾯���ϵ�쳣��������...");
				}
			}
		 }else{
			 log.error("�����ﷸ�뾯���ϵ�쳣������Ա״̬��ʾΪ"+username);
		    }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("�����ﷸ�뾯���ϵʧ�ܣ����Ժ�����...");
	}    
	  return jsTCDX;
  }
  /**
   * 
   * @todo TODO ʹ��excel���뾯����Ϣ
   * @param filename
   * @param session
   * @return
   * @auth quite
   * @time 2018��1��10�� ����5:10:19
   *
   */
  @SuppressWarnings("static-access")
  @ResponseBody
  @RequestMapping(value="addPlice",method={RequestMethod.GET,RequestMethod.POST})
  @Log(operationType="��������",operationName="ʹ��EXCEL���������")
  public String addPlice(String filename,HttpSession session){
	  List<Tip> strList = new ArrayList<Tip>(); //��String�ַ���������ҳ��
	  Tip tip = new Tip();
	  try {
		  List<String> msgList = new ArrayList<String>();
		  List<JYXX> jyList = new ArrayList<JYXX>();
		  String username = (String)session.getAttribute("username");
		  String fileValue = getFileName(filename);
		  int zw = 0;
		  log.info("ʹ��excel���뾯����Ϣ�ġ��ļ���"+fileValue+"��,��������Ա"+username+"��");
			  ReadExcelUtil eu = new ReadExcelUtil();
			  eu.setStartReadPos(1); //�ӵڶ��п�ʼ��
			 if(null!=username&&null!=fileValue){
			  JYXX jy = null;
			  List<Row> rowLine = eu.readExcel(fileValue);
			  for (Row row : rowLine) {
				 if(null!=row){
					    Cell cjh = row.getCell(0);
						row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
						String jh = cjh.getStringCellValue().trim(); //����
						Cell cma = row.getCell(1);
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						String ma = cma.getStringCellValue().trim(); //����
						Cell cxm = row.getCell(2);
						String xm = cxm.getStringCellValue().trim();//����
						Cell czw = row.getCell(3);
						String zwname = czw.getStringCellValue().trim();//ְ��
						Cell cjq = row.getCell(4);
						String jqname = cjq.getStringCellValue().trim(); //���ڼ���
						Cell cfjq = row.getCell(5);
						String fjqname = cfjq.getStringCellValue().trim();//�ּ���
						Cell cbm = row.getCell(6);
						String bmname = cbm.getStringCellValue().trim(); //����
						//�Ƚ�����֤
						if(checkZW(zwname)==0){
							String zwmsg = "������"+jh+"������Ϣ����������ӡ�ְ��:"+zwname+"��";
							msgList.add(zwmsg);
						}else if(!FileDataCheck.checkName(jh)){
							String jhmsg = "������"+jh+"������Ϣ���󣬡������˺�:"+jh+"�����󣬾�����7λ�������";
							msgList.add(jhmsg);
						}else if(!FileDataCheck.checkPassword(ma)){
							String mamsg = "������"+jh+"������Ϣ���󣬡���������:"+ma+"������������3-16λӢ����ĸ���»������";
							msgList.add(mamsg);
						}else{
							zw = checkZW(zwname); //���ҵ�ְ��ı��
							jy = new JYXX();
							jy.setJh(jh);
//							jy.setMa(new CryptographyUtil().MD5(ma));
							jy.setMa(ma);
							jy.setXm(xm);
							jy.setZw(zw);
							jy.setZwName(zwname); //������ְ��������ʹ��������⣬ʹ�ñ�ţ�Ϊ�˷���ǰ��
							jy.setCjsj(new Date());
							jy.setScdlsj(new Date());
							jy.setStatus(1);
							jy.setJq(jqname);
							jy.setXjq(fjqname);
							jy.setBmh(bmname);
							int i = jyxxService.insertSelective(jy);
							if(i==1){
								jyList.add(jy);
							}
						}
						tip.setStrMsg(msgList); //��װ�����˵��������Ϣ
						tip.setJyxx(jyList);
						
				 }
			}
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		tip.setNullFont("�ļ��п��ֶΣ�������ȷ�������");
	}
	  strList.add(tip);
	  String json = GsonUtil.toJson(strList);
	  return json;
  }
  
//��ְ֤���Ƿ����
public int checkZW(String zwName){
	int id = 0;
	try {
		GroupMan zw = jyxxService.checkZW(zwName);
		if(null!=zw){
			id = zw.getId();
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return id;
}

}
