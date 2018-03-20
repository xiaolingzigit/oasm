package com.hd.jy.oasm.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.hd.jy.oasm.util.date.DateUtil;

/**
 * 
 * @author quite
 *����excel������
 */
public class ExeclUtil {
	public static void ExpExs(String path,String title,String sheets,Object[] headers,List<List<Object>> datas){
        try { 
            if(sheets== null || "".equals(sheets)){ sheets = "sheet"; }

            //�ж��ļ����Ƿ���ڣ��������򴴽�һ��
            boolean isExit0=new File(path).exists();
            if(!isExit0){
                File folder=new File(path);
                folder.setExecutable(true);
                folder.setReadable(true);
                folder.setWritable(true);
                folder.mkdirs();
            }
            String fpath=path+sheets;
            boolean isExist = new File(fpath).exists();
            if(!isExist){
                HSSFWorkbook workbook = new HSSFWorkbook();
                workbook.createSheet(sheets);

                FileOutputStream out = new FileOutputStream(new File(fpath));
                workbook.write(out);
                out.flush();
                out.close();
            }
            FileInputStream file = new FileInputStream(new File(fpath));
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            HSSFSheet sheet = null;
            sheet = workbook.getSheetAt(0);
            if(workbook.getSheet(sheets) == null){
              sheet = workbook.createSheet(sheets); //+workbook.getNumberOfSheets()
            }
            if(!isExist){
                sheet = workbook.getSheetAt(0);
            }else{
                if(workbook.getSheet(sheets) == null){
                    sheet = workbook.createSheet(sheets); //+workbook.getNumberOfSheets()
                }
                else{
                    System.out.println("�ļ���["+fpath+"] ["+sheets+"] �Ѿ�����...");
                    System.out.println("");
                    return;
                }
            }
            HSSFRow row;
            HSSFCell cell;

            // ������Щ��ʽ
            HSSFFont font = workbook.createFont();
            font.setFontName(HSSFFont.FONT_ARIAL);//����
            font.setFontHeightInPoints((short) 16);//�ֺ� 
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//�Ӵ�
            //font.setColor(HSSFColor.BLUE.index);//��ɫ

            HSSFCellStyle cellStyle= workbook.createCellStyle(); //���õ�Ԫ����ʽ
            cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER );
            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyle.setFont(font);

            //������������       
            row = sheet.createRow(0);
            row.setHeightInPoints(20);
            for (int i = 0; i < headers.length; i++) { 
                HSSFRichTextString text = new HSSFRichTextString(headers[i].toString());  
                cell = row.createCell(i);
                cell.setCellValue(text); 
                cell.setCellStyle(cellStyle);
            }  


            cellStyle= workbook.createCellStyle(); 
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyle.setDataFormat((short)0x31);//������ʾ��ʽ�����������ɿ�ѧ��������
            //cellStyle.setWrapText(true);//�����Զ�����
            List<Object> map;
            //�����������ݣ�����������  
            for (int i=0; i <datas.size(); i++) { 
                row=sheet.createRow((i+1));
                row.setHeightInPoints(20);
                map = datas.get(i);

                for(int j=0;j<map.size();j++) {
                     cell = row.createCell(j);
                     cell.setCellStyle(cellStyle);

                     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                     if(map.get(j) != null) {
                         cell.setCellValue(new HSSFRichTextString(map.get(j).toString())); 
                     }else{
                         cell.setCellValue(new HSSFRichTextString(""));     
                    }
                }
            }   

            for (int i = 0; i < headers.length; i++) { 
                sheet.autoSizeColumn((short)i);
            }

            FileOutputStream out = new FileOutputStream(new File(fpath));
            workbook.write(out);
            out.flush();
            out.close();

            System.out.println("�ļ���["+fpath+"] ["+sheets+"] �����ɹ�...");
            System.out.println("�����.xlsx����ʽ�򲻿���תΪ��.xls����ʽ�ļ�");
        } catch (Exception e) {  
            System.out.println("#Error ["+e.getMessage()+"] ");
        } 
        System.out.println("");
    }
	public static void main(String[] args) throws Throwable {
		System.out.println("��ʼ����excel���ʱ��"+DateUtil.getTime(new Date()));
        Object[] head = { "��һ���", "�ڶ����", "�������","���ı��"};
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> rowList = null;
        for (int i = 0; i < 4; i++) {
            rowList = new ArrayList<Object>();
            for(int j=0;j<4;j++){
                rowList.add("��"+i+"�е�"+j+"������");
            }
            dataList.add(rowList);
         }
         String fileName = DateUtil.getDate(new Date())+".xls";//��ȡ��������Ϊ�ļ�����
//         String fileName1 = DateUtil.getDate(new Date())+".xls";
         String filePath = "E:/error/"; //�����ļ���·��
  
         ExeclUtil.ExpExs(filePath,"",fileName,head,dataList);
//         ExeclUtil.ExpExs(filePath,"",fileName1,head,dataList);
    }
}
