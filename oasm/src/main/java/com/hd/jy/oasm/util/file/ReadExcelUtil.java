package com.hd.jy.oasm.util.file;

import java.io.File;    
import java.io.FileInputStream;    
import java.io.FileOutputStream;    
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;    
  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;    
import org.apache.poi.ss.usermodel.Cell;    
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;    
import org.apache.poi.ss.usermodel.Sheet;    
import org.apache.poi.ss.usermodel.Workbook;    
import org.apache.poi.ss.util.CellRangeAddress;    
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * 
 * @author quite
 * ��ȡexcel������
 */
public class ReadExcelUtil {
	private final static int READ_START_POS = 0;    
    
	  /**  
	   * Ĭ�Ͻ�����ȡ����λ��Ϊ���һ�У�����ֵ=0���ø�������ʾ������n�У�  
	   */    
	  private final static int READ_END_POS = 0;    
	      
	  /**  
	   * Ĭ��Excel���ݵĿ�ʼ�Ƚ���λ��Ϊ��һ�У�����ֵΪ0��  
	   */    
	  private final static int COMPARE_POS = 0;    
	      
	  /**  
	   * Ĭ�϶��ļ��ϲ���ʱ��Ҫ�����ݱȽϣ���ͬ�����ݲ��ظ����֣�  
	   */    
	  private final static boolean NEED_COMPARE = true;    
	      
	  /**  
	   * Ĭ�϶��ļ��ϲ������ļ����������ظ�ʱ�����и���  
	   */    
	  private final static boolean NEED_OVERWRITE = true;    
	      
	  /**  
	   * Ĭ��ֻ����һ��sheet  
	   */    
	  private final static boolean ONLY_ONE_SHEET = true;    
	      
	  /**  
	   * Ĭ�϶�ȡ��һ��sheet�У�ֻ�е�ONLY_ONE_SHEET = trueʱ��Ч��  
	   */    
	  private final static int SELECTED_SHEET = 0;    
	      
	  /**  
	   * Ĭ�ϴӵ�һ��sheet��ʼ��ȡ������ֵΪ0��  
	   */    
	  private final static int READ_START_SHEET= 0;    
	      
	  /**  
	   * Ĭ�������һ��sheet������ȡ������ֵ=0���ø�������ʾ������n�У�  
	   */    
	  private final static int READ_END_SHEET = 0;    
	      
	  /**  
	   * Ĭ�ϴ�ӡ������Ϣ  
	   */    
	  private final static boolean PRINT_MSG = true;    
	      
	  //%%%%%%%%-------�������� ����----------%%%%%%%%%    
	      
	  
	  //%%%%%%%%-------�ֶβ��� ��ʼ----------%%%%%%%%%    
	  /**  
	   * Excel�ļ�·��  
	   */    
	  private String excelPath = "data.xlsx";    
	  
	  /**  
	   * �趨��ʼ��ȡ��λ�ã�Ĭ��Ϊ0  
	   */    
	  private int startReadPos = READ_START_POS;    
	  
	  /**  
	   * �趨������ȡ��λ�ã�Ĭ��Ϊ0���ø�������ʾ������n��  
	   */    
	  private int endReadPos = READ_END_POS;    
	      
	  /**  
	   * �趨��ʼ�Ƚϵ���λ�ã�Ĭ��Ϊ0  
	   */    
	  private int comparePos = COMPARE_POS;    
	  
	  /**  
	   *  �趨���ܵ��ļ��Ƿ���Ҫ�滻��Ĭ��Ϊtrue  
	   */    
	  private boolean isOverWrite = NEED_OVERWRITE;    
	      
	  /**  
	   *  �趨�Ƿ���Ҫ�Ƚϣ�Ĭ��Ϊtrue(��������дĿ����������Ч����isOverWrite=falseʱ��Ч)  
	   */    
	  private boolean isNeedCompare = NEED_COMPARE;    
	      
	  /**  
	   * �趨�Ƿ�ֻ������һ��sheet  
	   */    
	  private boolean onlyReadOneSheet = ONLY_ONE_SHEET;    
	      
	  /**  
	   * �趨������sheet������ֵ  
	   */    
	  private int selectedSheetIdx =SELECTED_SHEET;    
	      
	  /**  
	   * �趨������sheet������  
	   */    
	  private String selectedSheetName = "";    
	      
	  /**  
	   * �趨��ʼ��ȡ��sheet��Ĭ��Ϊ0  
	   */    
	  private int startSheetIdx = READ_START_SHEET;    
	  
	  /**  
	   * �趨������ȡ��sheet��Ĭ��Ϊ0���ø�������ʾ������n��      
	   */    
	  private int endSheetIdx = READ_END_SHEET;    
	      
	  /**  
	   * �趨�Ƿ��ӡ��Ϣ  
	   */    
	  private boolean printMsg = PRINT_MSG;    
	      
	      
	  //%%%%%%%%-------�ֶβ��� ����----------%%%%%%%%%    
	      
	  public ReadExcelUtil(){}    
	    
	      
	  public ReadExcelUtil(String excelPath){    
	      this.excelPath = excelPath;    
	  }    
	      
	  /**  
	   * ��ԭ�趨����ʵ������newһ���µĶ��󲢷��أ�  
	   * @return  
	   */    
	  public ReadExcelUtil RestoreSettings(){    
	      ReadExcelUtil instance = new  ReadExcelUtil(this.excelPath);    
	      return instance;    
	  }    
	      
	  /**  
	   * �Զ������ļ���չ�������ö�Ӧ�Ķ�ȡ����  
	   *   
	   * @Title: writeExcel  
	   * @Date : 2017-7-27 ����01:50:38  
	   * @param xlsPath  
	   * @throws IOException  
	   */    
	  public List<Row> readExcel() throws IOException{    
	      return readExcel(this.excelPath);    
	  }    
	  
	  /**  
	   * �Զ������ļ���չ�������ö�Ӧ�Ķ�ȡ����  
	   *   
	   * @Title: writeExcel  
	   * @Date : 2017-7-27 ����01:50:38  
	   * @param xlsPath  
	   * @throws IOException  
	   */    
	  public List<Row> readExcel(String xlsPath) throws IOException{    
	          
	      //��չ��Ϊ��ʱ��    
	      if ("".equals(xlsPath)){    
	          throw new IOException("�ļ�·������Ϊ�գ�");    
	      }else{    
	          File file = new File(xlsPath);    
	          if(!file.exists()){    
	              throw new IOException("�ļ������ڣ�");    
	          }    
	      }    
	          
	      //��ȡ��չ��    
	      String ext = xlsPath.substring(xlsPath.lastIndexOf(".")+1);    
	          
	      try {    
	              
	          if("xls".equals(ext)){              //ʹ��xls��ʽ��ȡ    
	              return readExcel_xls(xlsPath);    
	          }else if("xlsx".equals(ext)){       //ʹ��xlsx��ʽ��ȡ    
	              return readExcel_xlsx(xlsPath);    
	          }else{                                  //���γ���xls��xlsx��ʽ��ȡ    
	              out("��Ҫ�������ļ�û����չ�������ڳ�����xls��ʽ��ȡ...");    
	              try{    
	                  return readExcel_xls(xlsPath);    
	              } catch (IOException e1) {    
	                  out("������xls��ʽ��ȡ�����ʧ�ܣ������ڳ�����xlsx��ʽ��ȡ...");    
	                  try{    
	                      return readExcel_xlsx(xlsPath);    
	                  } catch (IOException e2) {    
	                      out("������xls��ʽ��ȡ�����ʧ�ܣ�\n����ȷ�������ļ���Excel�ļ�����������Ȼ�����ԡ�");    
	                      throw e2;    
	                  }    
	              }    
	          }    
	      } catch (IOException e) {    
	          throw e;    
	      }    
	  }    
	      
	  /**  
	   * �Զ������ļ���չ�������ö�Ӧ��д�뷽��  
	   *   
	   * @Title: writeExcel  
	   * @Date : 2017-7-27 ����01:50:38  
	   * @param rowList  
	   * @throws IOException  
	   */    
	  public void writeExcel(List<Row> rowList) throws IOException{    
	      writeExcel(rowList,excelPath);    
	  }    
	      
	  /**  
	   * �Զ������ļ���չ�������ö�Ӧ��д�뷽��  
	   *   
	   * @Title: writeExcel  
	   * @Date : 2016-7-27 ����01:50:38  
	   * @param rowList  
	   * @param xlsPath  
	   * @throws IOException  
	   */    
	  public void writeExcel(List<Row> rowList, String xlsPath) throws IOException {    
	  
	      //��չ��Ϊ��ʱ��    
	      if ("".equals(xlsPath)){    
	          throw new IOException("�ļ�·������Ϊ�գ�");    
	      }    
	          
	      //��ȡ��չ��    
	      String ext = xlsPath.substring(xlsPath.lastIndexOf(".")+1);    
	          
	      try {    
	              
	          if("xls".equals(ext)){              //ʹ��xls��ʽд��    
	              writeExcel_xls(rowList,xlsPath);    
	          }else if("xlsx".equals(ext)){       //ʹ��xlsx��ʽд��    
	              writeExcel_xlsx(rowList,xlsPath);    
	          }else{                                  //���γ���xls��xlsx��ʽд��    
	              out("��Ҫ�������ļ�û����չ�������ڳ�����xls��ʽд��...");    
	              try{    
	                  writeExcel_xls(rowList,xlsPath);    
	              } catch (IOException e1) {    
	                  out("������xls��ʽд�룬���ʧ�ܣ������ڳ�����xlsx��ʽ��ȡ...");    
	                  try{    
	                      writeExcel_xlsx(rowList,xlsPath);    
	                  } catch (IOException e2) {    
	                      out("������xls��ʽд�룬���ʧ�ܣ�\n����ȷ�������ļ���Excel�ļ�����������Ȼ�����ԡ�");    
	                      throw e2;    
	                  }    
	              }    
	          }    
	      } catch (IOException e) {    
	          throw e;    
	      }    
	  }    
	      
	  /**  
	   * �޸�Excel��97-03�棬xls��ʽ��  
	   *   
	   * @Title: writeExcel_xls  
	   * @Date : 2016-7-27 ����01:50:38  
	   * @param rowList  
	   * @param dist_xlsPath  
	   * @throws IOException  
	   */    
	  public void writeExcel_xls(List<Row> rowList, String dist_xlsPath) throws IOException {    
	      writeExcel_xls(rowList, excelPath,dist_xlsPath);    
	  }    
	  
	  /**  
	   * �޸�Excel��97-03�棬xls��ʽ��  
	   *   
	   * @Title: writeExcel_xls  
	   * @Date : 2016-7-27 ����01:50:38  
	   * @param rowList  
	   * @param src_xlsPath  
	   * @param dist_xlsPath  
	   * @throws IOException  
	   */    
	  public void writeExcel_xls(List<Row> rowList, String src_xlsPath, String dist_xlsPath) throws IOException {    
	  
	      // �ж��ļ�·���Ƿ�Ϊ��    
	      if (dist_xlsPath == null || dist_xlsPath.equals("")) {    
	          out("�ļ�·������Ϊ��");    
	          throw new IOException("�ļ�·������Ϊ��");    
	      }    
	      // �ж��ļ�·���Ƿ�Ϊ��    
	      if (src_xlsPath == null || src_xlsPath.equals("")) {    
	          out("�ļ�·������Ϊ��");    
	          throw new IOException("�ļ�·������Ϊ��");    
	      }    
	  
	      // �ж��б��Ƿ������ݣ����û�����ݣ��򷵻�    
	      if (rowList == null || rowList.size() == 0) {    
	          out("�ĵ�Ϊ��");    
	          return;    
	      }    
	  
	      try {    
	          Workbook wb = null;    
	  
	          // �ж��ļ��Ƿ����    
	          File file = new File(dist_xlsPath);    
	          if (file.exists()) {    
	              // �����д����ɾ����    
	              if (isOverWrite) {    
	                  file.delete();    
	                  // ����ļ������ڣ��򴴽�һ���µ�Excel    
	                  // wb = new HSSFWorkbook();    
	                  // wb.createSheet("Sheet1");    
	                  wb = new HSSFWorkbook(new FileInputStream(src_xlsPath));    
	              } else {    
	                  // ����ļ����ڣ����ȡExcel    
	                  wb = new HSSFWorkbook(new FileInputStream(file));    
	              }    
	          } else {    
	              // ����ļ������ڣ��򴴽�һ���µ�Excel    
	              // wb = new HSSFWorkbook();    
	              // wb.createSheet("Sheet1");    
	              wb = new HSSFWorkbook(new FileInputStream(src_xlsPath));    
	          }    
	  
	          // ��rowlist������д��Excel��    
	          writeExcel(wb, rowList, dist_xlsPath);    
	  
	      } catch (IOException e) {    
	          e.printStackTrace();    
	      }    
	  }    
	  
	  /**  
	   * �޸�Excel��97-03�棬xls��ʽ��  
	   *   
	   * @Title: writeExcel_xls  
	   * @Date : 2016-7-27 ����01:50:38  
	   * @param rowList  
	   * @param dist_xlsPath  
	   * @throws IOException  
	   */    
	  public void writeExcel_xlsx(List<Row> rowList, String dist_xlsPath) throws IOException {    
	      writeExcel_xls(rowList, excelPath , dist_xlsPath);    
	  }    
	  
	  /**  
	   * �޸�Excel��2007�棬xlsx��ʽ��  
	   *   
	   * @Title: writeExcel_xlsx  
	   * @Date : 2016-7-27 ����01:50:38  
	   * @param rowList  
	   * @param xlsPath  
	   * @throws IOException  
	   */    
	  public void writeExcel_xlsx(List<Row> rowList, String src_xlsPath, String dist_xlsPath) throws IOException {    
	  
	      // �ж��ļ�·���Ƿ�Ϊ��    
	      if (dist_xlsPath == null || dist_xlsPath.equals("")) {    
	          out("�ļ�·������Ϊ��");    
	          throw new IOException("�ļ�·������Ϊ��");    
	      }    
	      // �ж��ļ�·���Ƿ�Ϊ��    
	      if (src_xlsPath == null || src_xlsPath.equals("")) {    
	          out("�ļ�·������Ϊ��");    
	          throw new IOException("�ļ�·������Ϊ��");    
	      }    
	  
	      // �ж��б��Ƿ������ݣ����û�����ݣ��򷵻�    
	      if (rowList == null || rowList.size() == 0) {    
	          out("�ĵ�Ϊ��");    
	          return;    
	      }    
	  
	      try {    
	          // ��ȡ�ĵ�    
	          Workbook wb = null;    
	  
	          // �ж��ļ��Ƿ����    
	          File file = new File(dist_xlsPath);    
	          if(!file.exists()){
	        	// ����ļ������ڣ��򴴽�һ���µ�Excel    
	              // wb = new XSSFWorkbook();    
	              // wb.createSheet("Sheet1");    
	              wb = new XSSFWorkbook(new FileInputStream(src_xlsPath));    
	          }else{
	        	  if (isOverWrite) {    
	                  file.delete();    
	                  // ����ļ������ڣ��򴴽�һ���µ�Excel    
	                  // wb = new XSSFWorkbook();    
	                  // wb.createSheet("Sheet1");    
	                  wb = new XSSFWorkbook(new FileInputStream(src_xlsPath));    
	              } else {    
	                  // ����ļ����ڣ����ȡExcel    
	                  wb = new XSSFWorkbook(new FileInputStream(file));    
	              } 
	          }   
	          // ��rowlist��������ӵ�Excel��    
	          writeExcel(wb, rowList, dist_xlsPath);    
	  
	      } catch (IOException e) {    
	          e.printStackTrace();    
	      }    
	  }    
	  
	  /**  
	   * //��ȡExcel 2007�棬xlsx��ʽ  
	   *   
	   * @Title: readExcel_xlsx  
	   * @Date : 2016-7-27 ����11:43:11  
	   * @return  
	   * @throws IOException  
	   */    
	  public List<Row> readExcel_xlsx() throws IOException {    
	      return readExcel_xlsx(excelPath);    
	  }    
	  
	  /**  
	   * //��ȡExcel 2007�棬xlsx��ʽ  
	   *   
	   * @Title: readExcel_xlsx  
	   * @Date : 2016-7-27 ����11:43:11  
	   * @return  
	   * @throws Exception  
	   */    
	  public List<Row> readExcel_xlsx(String xlsPath) throws IOException {    
	      // �ж��ļ��Ƿ����    
	      File file = new File(xlsPath);    
	      if (!file.exists()) {    
	          throw new IOException("�ļ���Ϊ" + file.getName() + "Excel�ļ������ڣ�");    
	      }    
	  
	      Workbook wb = null;    
	      List<Row> rowList = new ArrayList<Row>();    
	      FileInputStream fis = new FileInputStream(file);    
	      try {    
	          // ȥ��Excel    
	          wb = new XSSFWorkbook(fis);    
	          // ��ȡExcel 2007�棬xlsx��ʽ    
	          rowList = readExcel(wb);    
	      } catch (Exception e) {    
	    	  wb = new HSSFWorkbook(fis);    
	    	  
	          // ��ȡExcel 97-03�棬xlsx��ʽ    
	          rowList = readExcel(wb);    
	      }    
	      return rowList;    
	  }    
	  
	  /***  
	   * ��ȡExcel(97-03�棬xls��ʽ)  
	   *   
	   * @throws IOException  
	   *   
	   * @Title: readExcel  
	   * @Date : 2016-7-27 ����09:53:21  
	   */    
	  public List<Row> readExcel_xls() throws IOException {    
	      return readExcel_xls(excelPath);    
	  }    
	  
	  /***  
	   * ��ȡExcel(97-03�棬xls��ʽ)  
	   *   
	   * @throws Exception  
	   *   
	   * @Title: readExcel  
	   * @Date : 2016-7-27 ����09:53:21  
	   */    
	  public List<Row> readExcel_xls(String xlsPath) throws IOException {    
	  
	      // �ж��ļ��Ƿ����    
	      File file = new File(xlsPath);    
	      if (!file.exists()) {    
	          throw new IOException("�ļ���Ϊ" + file.getName() + "Excel�ļ������ڣ�");    
	      }    
	  
	      Workbook wb = null;// ����Workbook���Ĳ�����������ɾ��Excel    
	      List<Row> rowList = new ArrayList<Row>();    
	  
	      try {    
	          // ��ȡExcel    
	          wb = new HSSFWorkbook(new FileInputStream(file));    
	  
	          // ��ȡExcel 97-03�棬xls��ʽ    
	          rowList = readExcel(wb);    
	  
	      } catch (Exception e) {    
//	          e.printStackTrace();  
	    	  wb = new XSSFWorkbook(new FileInputStream(file));    
	    	  
	          // ��ȡExcel 2007�棬xls��ʽ    
	          rowList = readExcel(wb); 
	      }    
	      return rowList;    
	  }    
	  
	  /***  
	   * ��ȡ��Ԫ���ֵ  
	   *   
	   * @Title: getCellValue  
	   * @Date : 2016-7-27 ����10:52:07  
	   * @param cell  
	   * @return  
	   */    
	  public static String getCellValue(Cell cell) {    
		  String cellValue = "";
	        DataFormatter formatter = new DataFormatter();
	        if (cell != null) {
	            switch (cell.getCellType()) {
	                case Cell.CELL_TYPE_NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell)) {
	                        cellValue = formatter.formatCellValue(cell);
	                    } else {
	                        double value = cell.getNumericCellValue();
	                        int intValue = (int) value;
	                        cellValue = value - intValue == 0 ? String.valueOf(intValue) : String.valueOf(value);
	                    }
	                    break;
	                case Cell.CELL_TYPE_STRING:
	                    cellValue = cell.getStringCellValue();
	                    break;
	                case Cell.CELL_TYPE_BOOLEAN:
	                    cellValue = String.valueOf(cell.getBooleanCellValue());
	                    break;
	                case Cell.CELL_TYPE_FORMULA:
	                    cellValue = String.valueOf(cell.getCellFormula());
	                    break;
	                case Cell.CELL_TYPE_BLANK:
	                    cellValue = "";
	                    break;
	                case Cell.CELL_TYPE_ERROR:
	                    cellValue = "";
	                    break;
	                default:
	                    cellValue = cell.toString().trim();
	                    break;
	            }
	        }
	        return cellValue.trim();
	  }    
	  
	  /**  
	   * ͨ�ö�ȡExcel  
	   *   
	   * @Title: readExcel  
	   * @Date : 2016-7-27 ����11:26:53  
	   * @param wb  
	   * @return  
	   */    
	  private List<Row> readExcel(Workbook wb) {    
	      List<Row> rowList = new ArrayList<Row>();    
	          
	      int sheetCount = 1;//��Ҫ������sheet����    
	          
	      Sheet sheet = null;    
	      if(onlyReadOneSheet){   //ֻ����һ��sheet    
	          // ��ȡ�趨������sheet(����趨�����ƣ������Ʋ飬��������ֵ��)    
	          sheet ="".equals(selectedSheetName)? wb.getSheetAt(selectedSheetIdx):wb.getSheet(selectedSheetName);    
	      }else{                          //�������sheet    
	          sheetCount = wb.getNumberOfSheets();//��ȡ���Բ�����������    
	      }    
	          
	      // ��ȡsheet��Ŀ    
	      for(int t=startSheetIdx; t<sheetCount+endSheetIdx;t++){    
	          // ��ȡ�趨������sheet    
	          if(!onlyReadOneSheet) {    
	              sheet =wb.getSheetAt(t);    
	          }    
	              
	          //��ȡ����к�    
	          int lastRowNum = sheet.getLastRowNum();    
	  
	          if(lastRowNum>0){    //���>0����ʾ������    
	              out("\n��ʼ��ȡ��Ϊ��"+sheet.getSheetName()+"�������ݣ�");    
	          }    
	              
	          Row row = null;    
	          // ѭ����ȡ    
	          for (int i = startReadPos; i <= lastRowNum + endReadPos; i++) {    
	              row = sheet.getRow(i);    
	              if (row != null) {    
	            	  rowList.add(row);
	            	  System.out.println("������"+rowList);
//	                  out("��"+(i+1)+"�У�",false);  
	                  out("��"+(i+1)+"�У�",false);
	                   // ��ȡÿһ��Ԫ���ֵ    
	                  out("��ȡ���ݿ�ʼʱ��"+com.hd.jy.oasm.util.date.DateUtil.getTime(new Date()));
	                   for (int j = 0; j < row.getLastCellNum(); j++) {    
	                       String value = getCellValue(row.getCell(j)); 
	                       if (!"".equals(value)) { 
	                    	   //value��ֵ�ٵ��ò������ݿ�ķ����Ϳ��Բ��뵽���ݿ���
	                           out(value + " $ ",false);    
	                       }    
	                   }    
	                   out("");    
	              }    
	          }    
	      }    
	      return rowList;    
	  }    
	  
	  /**  
	   * �޸�Excel�������Ϊ  
	   *   
	   * @Title: WriteExcel  
	   * @Date : 2016-7-27 ����01:33:59  
	   * @param wb  
	   * @param rowList  
	   * @param xlsPath  
	   */    
	  private void writeExcel(Workbook wb, List<Row> rowList, String xlsPath) {    
	  
	      if (wb == null) {    
	          out("�����ĵ�����Ϊ�գ�");    
	          return;    
	      }    
	  
	      Sheet sheet = wb.getSheetAt(0);// �޸ĵ�һ��sheet�е�ֵ    
	  
	      // ���ÿ����д����ô��ӿ�ʼ��ȡ��λ��д���������ȡԴ�ļ����µ��С�    
	      int lastRowNum = isOverWrite ? startReadPos : sheet.getLastRowNum() + 1;    
	      int t = 0;//��¼������ӵ�����    
	      out("Ҫ��ӵ�����������Ϊ��"+rowList.size());    
	      for (Row row : rowList) {    
	          if (row == null) {continue;};    
	          // �ж��Ƿ��Ѿ����ڸ�����    
	          int pos = findInExcel(sheet, row);    
	  
	          Row r = null;// ����������Ѿ����ڣ����ȡ����д�������Զ��������С�    
	          if (pos >= 0) {    
	              sheet.removeRow(sheet.getRow(pos));    
	              r = sheet.createRow(pos);    
	          } else {    
	              r = sheet.createRow(lastRowNum + t++);    
	          }    
	              
	          //�����趨��Ԫ����ʽ    
	          CellStyle newstyle = wb.createCellStyle();    
	              
	          //ѭ��Ϊ���д�����Ԫ��    
	          for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {    
	              Cell cell = r.createCell(i);// ��ȡ��������    
	              cell.setCellValue(getCellValue(row.getCell(i)));// ���Ƶ�Ԫ���ֵ���µĵ�Ԫ��    
	              // cell.setCellStyle(row.getCell(i).getCellStyle());//����    
	              if (row.getCell(i) == null){continue;};    
	              copyCellStyle(row.getCell(i).getCellStyle(), newstyle); // ��ȡԭ���ĵ�Ԫ����ʽ    
	              cell.setCellStyle(newstyle);// ������ʽ    
	              // sheet.autoSizeColumn(i);//�Զ���ת�п��    
	          }    
	      }    
	      out("���м�⵽�ظ�����Ϊ:" + (rowList.size() - t) + " ��׷������Ϊ��"+t);    
	          
	      // ͳһ�趨�ϲ���Ԫ��    
	      setMergedRegion(sheet);    
	          
	      try {    
	          // ���½�����д��Excel��    
	          FileOutputStream outputStream = new FileOutputStream(xlsPath);    
	          wb.write(outputStream);    
	          outputStream.flush();    
	          outputStream.close();    
	      } catch (Exception e) {    
	          out("д��Excelʱ�������� ");    
	          e.printStackTrace();    
	      };   
	  }    
	  
	  /**  
	   * ����ĳ�������Ƿ���Excel���д��ڣ�����������  
	   *   
	   * @Title: findInExcel  
	   * @Date : 2016-7-27 ����02:23:12  
	   * @param sheet  
	   * @param row  
	   * @return  
	   */    
	  private int findInExcel(Sheet sheet, Row row) {    
	      int pos = -1;    
	  
	      try {    
	          // �����дĿ���ļ������߲���Ҫ�Ƚϣ���ֱ�ӷ���    
	          if (isOverWrite || !isNeedCompare) {    
	              return pos;    
	          }    
	          for (int i = startReadPos; i <= sheet.getLastRowNum() + endReadPos; i++) {    
	              Row r = sheet.getRow(i);    
	              if (r != null && row != null) {    
	                  String v1 = getCellValue(r.getCell(comparePos));    
	                  String v2 = getCellValue(row.getCell(comparePos));    
	                  if (v1.equals(v2)) {    
	                      pos = i;    
	                      break;    
	                  }    
	              }    
	          }    
	      } catch (Exception e) {    
	          e.printStackTrace();    
	      }    
	      return pos;    
	  }    
	  
	  /**  
	   * ����һ����Ԫ����ʽ��Ŀ�ĵ�Ԫ����ʽ  
	   *   
	   * @param fromStyle  
	   * @param toStyle  
	   */    
	  public static void copyCellStyle(CellStyle fromStyle, CellStyle toStyle) {    
	      toStyle.setAlignment(fromStyle.getAlignment());    
	      // �߿�ͱ߿���ɫ    
	      toStyle.setBorderBottom(fromStyle.getBorderBottom());    
	      toStyle.setBorderLeft(fromStyle.getBorderLeft());    
	      toStyle.setBorderRight(fromStyle.getBorderRight());    
	      toStyle.setBorderTop(fromStyle.getBorderTop());    
	      toStyle.setTopBorderColor(fromStyle.getTopBorderColor());    
	      toStyle.setBottomBorderColor(fromStyle.getBottomBorderColor());    
	      toStyle.setRightBorderColor(fromStyle.getRightBorderColor());    
	      toStyle.setLeftBorderColor(fromStyle.getLeftBorderColor());    
	  
	      // ������ǰ��    
	      toStyle.setFillBackgroundColor(fromStyle.getFillBackgroundColor());    
	      toStyle.setFillForegroundColor(fromStyle.getFillForegroundColor());    
	  
	      // ���ݸ�ʽ    
	      toStyle.setDataFormat(fromStyle.getDataFormat());    
	      toStyle.setFillPattern(fromStyle.getFillPattern());    
	      // toStyle.setFont(fromStyle.getFont(null));    
	      toStyle.setHidden(fromStyle.getHidden());    
	      toStyle.setIndention(fromStyle.getIndention());// ��������    
	      toStyle.setLocked(fromStyle.getLocked());    
	      toStyle.setRotation(fromStyle.getRotation());// ��ת    
	      toStyle.setVerticalAlignment(fromStyle.getVerticalAlignment());    
	      toStyle.setWrapText(fromStyle.getWrapText());    
	  
	  }    
	  
	  /**  
	   * ��ȡ�ϲ���Ԫ���ֵ  
	   *   
	   * @param sheet  
	   * @param row  
	   * @param column  
	   * @return  
	   */    
	  public void setMergedRegion(Sheet sheet) {    
	      int sheetMergeCount = sheet.getNumMergedRegions();    
	  
	      for (int i = 0; i < sheetMergeCount; i++) {    
	          // ��ȡ�ϲ���Ԫ��λ��    
	          CellRangeAddress ca = sheet.getMergedRegion(i);    
	          int firstRow = ca.getFirstRow();    
	          if (startReadPos - 1 > firstRow) {// �����һ���ϲ���Ԫ���ʽ����ʽ���ݵ����棬��������    
	              continue;    
	          }    
	          int lastRow = ca.getLastRow();    
	          int mergeRows = lastRow - firstRow;// �ϲ�������    
	          int firstColumn = ca.getFirstColumn();    
	          int lastColumn = ca.getLastColumn();    
	          // ���ݺϲ��ĵ�Ԫ��λ�úʹ�С���������е������и�ʽ��    
	          for (int j = lastRow + 1; j <= sheet.getLastRowNum(); j++) {    
	              // �趨�ϲ���Ԫ��    
	              sheet.addMergedRegion(new CellRangeAddress(j, j + mergeRows, firstColumn, lastColumn));    
	              j = j + mergeRows;// �����Ѻϲ�����    
	          }    
	  
	      }    
	  }    
	      
	  
	  /**  
	   * ��ӡ��Ϣ��  
	   * @param msg ��Ϣ����  
	   * @param tr ����  
	   */    
	  private void out(String msg){    
	      if(printMsg){    
	          out(msg,true);    
	      }    
	  }    
	  /**  
	   * ��ӡ��Ϣ��  
	   * @param msg ��Ϣ����  
	   * @param tr ����  
	   */    
	  private void out(String msg,boolean tr){    
	      if(printMsg){    
	          System.out.print(msg+(tr?"\n":""));    
	      }    
	  }    
	  
	  public String getExcelPath() {    
	      return this.excelPath;    
	  }    
	  
	  public void setExcelPath(String excelPath) {    
	      this.excelPath = excelPath;    
	  }    
	  
	  public boolean isNeedCompare() {    
	      return isNeedCompare;    
	  }    
	  
	  public void setNeedCompare(boolean isNeedCompare) {    
	      this.isNeedCompare = isNeedCompare;    
	  }    
	  
	  public int getComparePos() {    
	      return comparePos;    
	  }    
	  
	  public void setComparePos(int comparePos) {    
	      this.comparePos = comparePos;    
	  }    
	  
	  public int getStartReadPos() {    
	      return startReadPos;    
	  }    
	  
	  public void setStartReadPos(int startReadPos) {    
	      this.startReadPos = startReadPos;    
	  }    
	  
	  public int getEndReadPos() {    
	      return endReadPos;    
	  }    
	  
	  public void setEndReadPos(int endReadPos) {    
	      this.endReadPos = endReadPos;    
	  }    
	  
	  public boolean isOverWrite() {    
	      return isOverWrite;    
	  }    
	  
	  public void setOverWrite(boolean isOverWrite) {    
	      this.isOverWrite = isOverWrite;    
	  }    
	  
	  public boolean isOnlyReadOneSheet() {    
	      return onlyReadOneSheet;    
	  }    
	  
	  public void setOnlyReadOneSheet(boolean onlyReadOneSheet) {    
	      this.onlyReadOneSheet = onlyReadOneSheet;    
	  }    
	  
	  public int getSelectedSheetIdx() {    
	      return selectedSheetIdx;    
	  }    
	  
	  public void setSelectedSheetIdx(int selectedSheetIdx) {    
	      this.selectedSheetIdx = selectedSheetIdx;    
	  }    
	  
	  public String getSelectedSheetName() {    
	      return selectedSheetName;    
	  }    
	  
	  public void setSelectedSheetName(String selectedSheetName) {    
	      this.selectedSheetName = selectedSheetName;    
	  }    
	  
	  public int getStartSheetIdx() {    
	      return startSheetIdx;    
	  }    
	  
	  public void setStartSheetIdx(int startSheetIdx) {    
	      this.startSheetIdx = startSheetIdx;    
	  }    
	  
	  public int getEndSheetIdx() {    
	      return endSheetIdx;    
	  }    
	  
	  public void setEndSheetIdx(int endSheetIdx) {    
	      this.endSheetIdx = endSheetIdx;    
	  }    
	  
	  public boolean isPrintMsg() {    
	      return printMsg;    
	  }    
	  
	  public void setPrintMsg(boolean printMsg) {    
	      this.printMsg = printMsg;    
	  }    
	    
	    
	    
	  public static void main(String[] args) {    
	      ReadExcelUtil eu = new ReadExcelUtil();    
	      //�ӵ�һ�п�ʼ��ȡ    


//	      eu.setStartReadPos(0);    
//	      String src_xlspath = "C:/Users/ljy13/Desktop/sql/pad/�ճ��۲�.xls";    
//
//	      eu.setStartReadPos(1);    
//	      String src_xlspath = "E:\\projectExcel\\�ṹ��̸.xls";    

//	      eu.setStartReadPos(1);    
//	      String src_xlspath = "E:\\projectExcel\\pad\\�ṹ��̸.xls";    

	      eu.setStartReadPos(0);    
	      String src_xlspath = "E:\\projectExcel\\pad\\�ﷸ��ϵ��.xls";    


	     //String dist_xlsPath = "D:\\2.xls";    
	      List<Row> rowList = null;    
//	      BigDecimal decimal = null;
	      try {    	  
	          rowList = eu.readExcel(src_xlspath); 
	          for (Row row : rowList) {
	        	 
	        	    Cell cellqh = row.getCell(0);
	        	    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING); //���ö�ȡ����ֵ���͵�����תΪString����
					String qh = cellqh.getStringCellValue().trim(); //����
					Cell cellxm = row.getCell(1);
					row.getCell(1).setCellType(Cell.CELL_TYPE_STRING); 
					String xm = cellxm.getStringCellValue(); //����
					Cell celljh = row.getCell(2);
					
					row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
					String jh = celljh.getStringCellValue(); //����
					Cell celljhxm = row.getCell(3);
					row.getCell(3).setCellType(Cell.CELL_TYPE_STRING); 
					String jhxm = celljhxm.getStringCellValue(); //ר������
					Cell cellxjbh = row.getCell(4);
					row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
					String xjbh = cellxjbh.getStringCellValue(); //Э������
					Cell cellxjxm = row.getCell(5);
					row.getCell(5).setCellType(Cell.CELL_TYPE_STRING); 
					String xjxm = cellxjxm.getStringCellValue(); //Э������
					System.out.println("aaa"+qh+xm+jh+jhxm+xjbh+xjxm);
					
			}
	          System.out.println("finsh");
	        //eu.writeExcel_xls(rowList, src_xlspath, dist_xlsPath);
//		      for(int i=1;i<rowList.size();i++){  
//	          Row obj=rowList.get(i);  
//	          System.out.println(""+getCellValue(obj.getCell(0))+"|"+getCellValue(obj.getCell(1))+"|"+getCellValue(obj.getCell(2))+"|"+getCellValue(obj.getCell(3))+"|"+getCellValue(obj.getCell(4)));     
//	      } 
	      } catch (Exception e) {    
	          e.printStackTrace();    
	      }    

//	      for(int i=1;i<rowList.size();i++){  
//	          Row obj=rowList.get(i);  
//	          System.out.println(getCellValue(obj.getCell(0))+"\n");     
//	          System.out.println(getCellValue(obj.getCell(1))+"\n");
//	          System.out.println(getCellValue(obj.getCell(2))+"\n");
//	          System.out.println(getCellValue(obj.getCell(3))+"\n");
//	          System.out.println(getCellValue(obj.getCell(4))+"\n");
//	          System.out.println(getCellValue(obj.getCell(5))+"\n");
//	          
//	          System.out.println(getCellValue(obj.getCell(6))+"\n");     
//	          System.out.println(getCellValue(obj.getCell(7))+"\n");
//	          System.out.println(getCellValue(obj.getCell(8))+"\n");
//	          System.out.println(getCellValue(obj.getCell(9))+"\n");
//	          System.out.println(getCellValue(obj.getCell(10))+"\n");
//	          System.out.println(getCellValue(obj.getCell(11))+"\n");     
//	          System.out.println(getCellValue(obj.getCell(12))+"\n");
//	          System.out.println(getCellValue(obj.getCell(14))+"\n");
//	          System.out.println(getCellValue(obj.getCell(15))+"\n");
//	          System.out.println(getCellValue(obj.getCell(16))+"\n");
//	          System.out.println(getCellValue(obj.getCell(17))+"\n");
//	          
//	          
//	      }    

//	      for(int i=1;i<rowList.size();i++){  
//	          Row obj=rowList.get(i);  
//	          System.out.println(""+getCellValue(obj.getCell(0))+"|"+getCellValue(obj.getCell(1))+"|"+getCellValue(obj.getCell(2))+"|"+getCellValue(obj.getCell(3))+"|"+getCellValue(obj.getCell(4)));     
//	      }    

   

	        
	  }    
	      
	   
	}    