package com.hd.jy.oasm.test.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hd.jy.oasm.domain.Daftdc;
import com.hd.jy.oasm.services.DaftdcService;
import com.hd.jy.oasm.util.file.ReadExcelUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybaits.xml"})
public class ExcelTest {
	
	@Autowired
	  private DaftdcService daftdcService;

	public static void main(String[] args) {
//		readExcelUtil.setExcelPath("C:/Users/ljy13/Desktop/sql/pad/结构访谈.xls");
//		ReadExcelUtil readExcelUtil = new ReadExcelUtil();
		String file = null;
		new ExcelTest().upfileRead(file);
	  
	}
	
	public int upfileRead(String file){
		  ReadExcelUtil eu = new ReadExcelUtil();    
	      //0表示从第一行开始读取    
	      eu.setStartReadPos(0);   
		  System.out.println("文件名"+file);
		  String[] splitfile = file.split("\\\\");
		  //获取文件名斜杠\后的字符
		  String fileName = splitfile[splitfile.length-1];
		  
		  String fileValue = "E:\\projectExcel\\pad\\"+fileName;
		  
		  System.out.println("拼接的字符串"+fileValue);
		  List<Row> rowList = null;    
		  Daftdc da = null;
		  BigDecimal ftdcid = null;
		  int i = 0;
	      try {    	  
	          rowList = eu.readExcel(fileValue); 
	          for (Row row : rowList) {
	        	  da = new Daftdc();
	        	  //根据excel表格的数据一个一个插到数据库中
	        	  Cell cell0 = row.getCell(0);
	        	  String value = cell0.getStringCellValue(); //入库时间
	        	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	        	  Date tbdate = null;
					try {
						tbdate = sdf.parse(value);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	        	  Cell cell1 = row.getCell(1);
	        	  long booker = Long.parseLong(cell1.getStringCellValue());
	        	  Cell cell2 = row.getCell(2);
	        	  String zsxm = cell2.getStringCellValue();
	        	  Cell cell3 = row.getCell(3);
	        	  long qh = Long.parseLong(cell3.getStringCellValue());
	        	  
	        	  String insertid = cell3.getStringCellValue()+value; //事件编号
	        	  ftdcid = new BigDecimal(insertid);
	        	  
	        	  
	        	  //题目答案
	        	  Cell cell4 = row.getCell(4);
	        	  String b1 = cell4.getStringCellValue();
	        	  Cell cell5 = row.getCell(5);
	        	  String b2 = cell5.getStringCellValue();
	        	  Cell cell6 = row.getCell(6);
	        	  String b3 = cell6.getStringCellValue();
	        	  Cell cell7 = row.getCell(7);
	        	  String b4 = cell7.getStringCellValue();
	        	  Cell cell8 = row.getCell(8);
	        	  String b5 = cell8.getStringCellValue();
	        	  Cell cell9 = row.getCell(9);
	        	  String b6 = cell9.getStringCellValue();
	        	  Cell cell10 = row.getCell(10);
	        	  String b7 = cell10.getStringCellValue();
	        	  Cell cell11 = row.getCell(11);
	        	  String b8 = cell11.getStringCellValue();
	        	  Cell cell12 = row.getCell(12);
	        	  String b9 = cell12.getStringCellValue();
	        	  Cell cell13 = row.getCell(13);
	        	  String b10 = cell13.getStringCellValue();
	        	  Cell cell14 = row.getCell(14);
	        	  String b11 = cell14.getStringCellValue();
	        	  Cell cell15 = row.getCell(15);
	        	  String b12 = cell15.getStringCellValue();
	        	  Cell cell16 = row.getCell(16);
	        	  String b13 = cell16.getStringCellValue();
	        	  Cell cell17 = row.getCell(17);
	        	  String b14 = cell17.getStringCellValue();
	        	  Cell cell18 = row.getCell(18);
	        	  String b15 = cell18.getStringCellValue();
	        	  
	        	  
	        	  da.setFtdcId(ftdcid);//事件编号
	        	  da.setTbdate(tbdate);
	        	  da.setBooker(booker);
	        	  da.setZsxm(zsxm);
	        	  da.setQh(qh);
	        	  da.setB1(b1);
	        	  da.setB2(b2);
	        	  da.setB3(b3);
	        	  da.setB4(b4);
	        	  da.setB5(b5);
	        	  da.setB6(b6);
	        	  da.setB7(b7);
	        	  da.setB8(b8);
	        	  da.setB9(b9);
	        	  da.setB10(b10);
	        	  da.setB11(b11);
	        	  da.setB12(b12);
	        	  da.setB13(b13);
	        	  da.setB14(b14);
	        	  da.setB15(b15);
	        	  
	        	  i = daftdcService.ftSaveOrUpdate(da);
	        	  System.out.println("总共入库"+i+"条数据");
			}
	      } catch (IOException e) {    
	          e.printStackTrace();    
	      }    
		  
		  return i;
	  }
}
