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
 *导出excel工具类
 */
public class ExeclUtil {
	public static void ExpExs(String path,String title,String sheets,Object[] headers,List<List<Object>> datas){
        try { 
            if(sheets== null || "".equals(sheets)){ sheets = "sheet"; }

            //判断文件夹是否存在，不存在则创建一个
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
                    System.out.println("文件：["+fpath+"] ["+sheets+"] 已经存在...");
                    System.out.println("");
                    return;
                }
            }
            HSSFRow row;
            HSSFCell cell;

            // 设置这些样式
            HSSFFont font = workbook.createFont();
            font.setFontName(HSSFFont.FONT_ARIAL);//字体
            font.setFontHeightInPoints((short) 16);//字号 
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗
            //font.setColor(HSSFColor.BLUE.index);//颜色

            HSSFCellStyle cellStyle= workbook.createCellStyle(); //设置单元格样式
            cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER );
            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyle.setFont(font);

            //产生表格标题行       
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
            cellStyle.setDataFormat((short)0x31);//设置显示格式，避免点击后变成科学计数法了
            //cellStyle.setWrapText(true);//设置自动换行
            List<Object> map;
            //遍历集合数据，产生数据行  
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

            System.out.println("文件：["+fpath+"] ["+sheets+"] 创建成功...");
            System.out.println("如果【.xlsx】格式打不开请转为【.xls】格式文件");
        } catch (Exception e) {  
            System.out.println("#Error ["+e.getMessage()+"] ");
        } 
        System.out.println("");
    }
	public static void main(String[] args) throws Throwable {
		System.out.println("开始创建excel表格时间"+DateUtil.getTime(new Date()));
        Object[] head = { "第一表格", "第二表格", "第三表格","第四表格"};
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> rowList = null;
        for (int i = 0; i < 4; i++) {
            rowList = new ArrayList<Object>();
            for(int j=0;j<4;j++){
                rowList.add("第"+i+"行第"+j+"列数据");
            }
            dataList.add(rowList);
         }
         String fileName = DateUtil.getDate(new Date())+".xls";//获取当天日期为文件名称
//         String fileName1 = DateUtil.getDate(new Date())+".xls";
         String filePath = "E:/error/"; //保存文件的路径
  
         ExeclUtil.ExpExs(filePath,"",fileName,head,dataList);
//         ExeclUtil.ExpExs(filePath,"",fileName1,head,dataList);
    }
}
