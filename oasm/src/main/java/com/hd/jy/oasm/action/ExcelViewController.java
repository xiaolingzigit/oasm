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
 * 导入excel文件的视图，都是在这里操作
 *
 */
@Controller
@RequestMapping("excelView")
public class ExcelViewController {
	private Logger log = Logger.getLogger(ExcelViewController.class);
	
  
  @Autowired
  private TzyrymdService tzrymdService; //操作入监人员名单操作接口  包括罪犯
  
  @Autowired
  private JyxxService jyxxService; //警察信息操作接口
 
  //统一的调用文件导入路径入口
  public static String getFileName(String file){
	  String[] splitfile = file.split("\\\\");
	  //获取文件名斜杠\后的字符
	  String fileName = splitfile[splitfile.length-1];
	  
	  //为了方便更改，定义方法统一使用该路径
	  String fileValue = "E:\\projectExcel\\pad\\"+fileName;
	  return fileValue;
  }
  
  /***
   * //使用excel导入警察与罪犯关系
   * @auto quite
   * @param file
   * @param session
   * @returna 本身返回的json字符串表示一个list的集合
   * 上午10:26:42
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
      //0表示从第一行开始读取    
      eu.setStartReadPos(1);   
	  
      //调用方法获取文件的路径
	  String fileValue = getFileName(file);
	  List<Row> rowList = null;
	  Tjczjdx tzjdx = null; //创建专教对象
	  String jsTCDX = "";
	  try {
		  if(username!=null&&username!=""){
			 rowList = eu.readExcel(fileValue);
			  for (Row row : rowList) {
				Cell cellqh = row.getCell(0);
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING); //设置数值都是为String类型
				String qh = cellqh.getStringCellValue().trim(); //囚号
				Cell cellxm = row.getCell(1);
				String xm = cellxm.getStringCellValue().trim(); //姓名
				Cell celljh = row.getCell(2);
				 row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				String jh = celljh.getStringCellValue().trim(); //警号
				Cell celljhxm = row.getCell(3);
				String jhxm = celljhxm.getStringCellValue().trim(); //专管姓名
				Cell cellxjbh = row.getCell(4);
				 row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				String xjbh = cellxjbh.getStringCellValue().trim(); //协警警号
				Cell cellxjxm = row.getCell(5);
				String xjxm = cellxjxm.getStringCellValue().trim(); //协警姓名
				
				
				tzjdx = new Tjczjdx();
				tzjdx.setQh(Long.parseLong(qh)); //囚号
				tzjdx.setXm(xm); //囚犯姓名
				tzjdx.setJh(jh); //警号
				tzjdx.setJhxm(jhxm); //警察姓名
				tzjdx.setXjbh(xjbh); //协警编号
				tzjdx.setXjxm(xjxm); //协警姓名
				
				tcdxList.add(tzjdx);
				
				
				i = tzrymdService.crimPlaceSaveOrUpdate(tzjdx);
				if(i==1){
					jsTCDX = GsonUtil.toJson(tcdxList); //如果导入成功，则返回一个json的字符串数组
				}else{
					log.error("添加囚犯与警察关系异常，请重试...");
				}
			}
		 }else{
			 log.error("导入罪犯与警察关系异常，管理员状态显示为"+username);
		    }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("导入罪犯与警察关系失败，请稍后重试...");
	}    
	  return jsTCDX;
  }
  /**
   * 
   * @todo TODO 使用excel导入警察信息
   * @param filename
   * @param session
   * @return
   * @auth quite
   * @time 2018年1月10日 下午5:10:19
   *
   */
  @SuppressWarnings("static-access")
  @ResponseBody
  @RequestMapping(value="addPlice",method={RequestMethod.GET,RequestMethod.POST})
  @Log(operationType="导入数据",operationName="使用EXCEL表格导入数据")
  public String addPlice(String filename,HttpSession session){
	  List<Tip> strList = new ArrayList<Tip>(); //把String字符串都传到页面
	  Tip tip = new Tip();
	  try {
		  List<String> msgList = new ArrayList<String>();
		  List<JYXX> jyList = new ArrayList<JYXX>();
		  String username = (String)session.getAttribute("username");
		  String fileValue = getFileName(filename);
		  int zw = 0;
		  log.info("使用excel导入警察信息的【文件名"+fileValue+"】,【操作人员"+username+"】");
			  ReadExcelUtil eu = new ReadExcelUtil();
			  eu.setStartReadPos(1); //从第二行开始读
			 if(null!=username&&null!=fileValue){
			  JYXX jy = null;
			  List<Row> rowLine = eu.readExcel(fileValue);
			  for (Row row : rowLine) {
				 if(null!=row){
					    Cell cjh = row.getCell(0);
						row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
						String jh = cjh.getStringCellValue().trim(); //警号
						Cell cma = row.getCell(1);
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						String ma = cma.getStringCellValue().trim(); //密码
						Cell cxm = row.getCell(2);
						String xm = cxm.getStringCellValue().trim();//姓名
						Cell czw = row.getCell(3);
						String zwname = czw.getStringCellValue().trim();//职务
						Cell cjq = row.getCell(4);
						String jqname = cjq.getStringCellValue().trim(); //所在监区
						Cell cfjq = row.getCell(5);
						String fjqname = cfjq.getStringCellValue().trim();//分监区
						Cell cbm = row.getCell(6);
						String bmname = cbm.getStringCellValue().trim(); //部门
						//先进行验证
						if(checkZW(zwname)==0){
							String zwmsg = "【警号"+jh+"】的信息错误，请先添加【职务:"+zwname+"】";
							msgList.add(zwmsg);
						}else if(!FileDataCheck.checkName(jh)){
							String jhmsg = "【警号"+jh+"】的信息错误，【导入账号:"+jh+"】有误，警号由7位数字组成";
							msgList.add(jhmsg);
						}else if(!FileDataCheck.checkPassword(ma)){
							String mamsg = "【警号"+jh+"】的信息错误，【导入密码:"+ma+"】有误，密码由3-16位英文字母和下划线组成";
							msgList.add(mamsg);
						}else{
							zw = checkZW(zwname); //查找到职务的编号
							jy = new JYXX();
							jy.setJh(jh);
//							jy.setMa(new CryptographyUtil().MD5(ma));
							jy.setMa(ma);
							jy.setXm(xm);
							jy.setZw(zw);
							jy.setZwName(zwname); //别名，职务名，不使用名称入库，使用编号，为了返回前端
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
						tip.setStrMsg(msgList); //封装所有人导入错误信息
						tip.setJyxx(jyList);
						
				 }
			}
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		tip.setNullFont("文件有空字段，请重新确认再添加");
	}
	  strList.add(tip);
	  String json = GsonUtil.toJson(strList);
	  return json;
  }
  
//验证职务是否存在
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
