package com.hd.jy.oasm.util.file;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Date;  
import java.util.HashMap;  
import java.util.Map;  
  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.DateUtil;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory; 

public class ImportExcelUtil {
	private Logger logger = LoggerFactory.getLogger(ImportExcelUtil.class);
	private Workbook wb;  
    private Sheet sheet;  
    private Row row;  
  
    public ImportExcelUtil(String filepath) {  
        if(filepath==null){  
            return;  
        }  
        String ext = filepath.substring(filepath.lastIndexOf("."));  
        try {  
            InputStream is = new FileInputStream(filepath);  
            if(".xls".equals(ext)){  
                wb = new HSSFWorkbook(is);  
            }else if(".xlsx".equals(ext)){  
                wb = new XSSFWorkbook(is);  
            }else{  
                wb=null;  
            }  
        } catch (FileNotFoundException e) {  
            logger.error("FileNotFoundException", e);  
        } catch (IOException e) {  
            logger.error("IOException", e);  
        }  
    }  
      
    /** 
     * ��ȡExcel����ͷ������ 
     *  
     * @param InputStream 
     * @return String ��ͷ���ݵ����� 
     * @author zengwendong 
     */  
    
    public String[] readExcelTitle() throws Exception{  
        if(wb==null){  
            throw new Exception("Workbook����Ϊ�գ�");  
        }  
        sheet = wb.getSheetAt(0);  
        row = sheet.getRow(0);  
        // ����������  
        int colNum = row.getPhysicalNumberOfCells();  
        System.out.println("colNum:" + colNum);  
        String[] title = new String[colNum];  
        for (int i = 0; i < colNum; i++) {  
            // title[i] = getStringCellValue(row.getCell((short) i));  
            title[i] = row.getCell(i).getCellFormula();  
        }  
        return title;  
    }  
  
    /** 
     * ��ȡExcel�������� 
     *  
     * @param InputStream 
     * @return Map ������Ԫ���������ݵ�Map���� 
     * @author zengwendong 
     */  
    public Map<Integer, Map<Integer,Object>> readExcelContent() throws Exception{ 
        if(wb==null){  
            throw new Exception("Workbook����Ϊ�գ�");  
        }  
        Map<Integer, Map<Integer,Object>> content = new HashMap<Integer, Map<Integer,Object>>();  
        sheet = wb.getSheetAt(0);  
        // �õ�������  
        int rowNum = sheet.getLastRowNum();  
        row = sheet.getRow(0);  
        int colNum = row.getPhysicalNumberOfCells();  
        // ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���  
        //ʵ����Ҫ�ӵ�һ�п�ʼ������
        for (int i = 0; i <= rowNum; i++) {  
            row = sheet.getRow(i);  
            int j = 0;  
            Map<Integer,Object> cellValue = new HashMap<Integer, Object>();  
            while (j < colNum) {  
                Object obj = getCellFormatValue(row.getCell(j));  
                cellValue.put(j, obj);  
                j++;  
            }  
            content.put(i, cellValue);  
        }  
        return content;  
    }  
  
    /** 
     *  
     * ����Cell������������ 
     *  
     * @param cell 
     * @return 
     * @author zengwendong 
     */  
    private Object getCellFormatValue(Cell cell) {  
        Object cellvalue = "";  
        if (cell != null) {  
            // �жϵ�ǰCell��Type  
            switch (cell.getCellType()) {  
            case Cell.CELL_TYPE_NUMERIC:// �����ǰCell��TypeΪNUMERIC  
            case Cell.CELL_TYPE_FORMULA: {  
                // �жϵ�ǰ��cell�Ƿ�ΪDate  
                if (DateUtil.isCellDateFormatted(cell)) {  
                    // �����Date������ת��ΪData��ʽ  
                    // data��ʽ�Ǵ�ʱ����ģ�2013-7-10 0:00:00  
                    // cellvalue = cell.getDateCellValue().toLocaleString();  
                    // data��ʽ�ǲ�����ʱ����ģ�2013-7-10  
                    Date date = cell.getDateCellValue();  
                    cellvalue = date;  
                } else {// ����Ǵ�����  
  
                    // ȡ�õ�ǰCell����ֵ  
                    cellvalue = String.valueOf(cell.getNumericCellValue());  
                }  
                break;  
            }  
            case Cell.CELL_TYPE_STRING:// �����ǰCell��TypeΪSTRING  
                // ȡ�õ�ǰ��Cell�ַ���  
                cellvalue = cell.getRichStringCellValue().getString();  
                break;  
            default:// Ĭ�ϵ�Cellֵ  
                cellvalue = "";  
            }  
        } else {  
            cellvalue = "";  
        }  
        return cellvalue;  
    }  
  
    public static void main(String[] args) {  
        try {  
            String filepath = "E:\\projectExcel\\pad\\�ճ��۲�.xls";  
            ImportExcelUtil excelReader = new ImportExcelUtil(filepath);  
            // �Զ�ȡExcel���������  
//          String[] title = excelReader.readExcelTitle();  
//          System.out.println("���Excel���ı���:");  
//          for (String s : title) {  
//              System.out.print(s + " ");  
//          }  
              
            // �Զ�ȡExcel������ݲ���  
            Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();  
            System.out.println("���Excel��������:");  
            for (int i =0; i <= map.size()-1; i++) {  
                System.out.println(map.get(i));  
            }  
        } catch (FileNotFoundException e) {  
            System.out.println("δ�ҵ�ָ��·�����ļ�!");  
            e.printStackTrace();  
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
