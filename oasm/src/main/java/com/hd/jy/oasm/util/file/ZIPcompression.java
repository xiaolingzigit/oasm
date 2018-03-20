/**
 * 
 */
package com.hd.jy.oasm.util.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * ѹ���ļ�
 * @author quite
 *
 */
public class ZIPcompression {

	 private int k = 1; // ����ݹ��������  
	 private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	  
	    public ZIPcompression() {  
	        // TODO Auto-generated constructor stub  
	    }  
	  
	    /** 
	     * @param args 
	     */  
	    public static void main(String[] args) {  
	        // TODO Auto-generated method stub  
	    	ZIPcompression book = new ZIPcompression();  
	        try {  
	            File zip = book.zip("D:\\online\\",new File("D:\\online\\jgxt.bak"));
	            if(null!=zip){
	            	System.out.println("�ļ�����·��"+zip);
	            	zip.delete();
	            }
	        } catch (Exception e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	  
	    }  
	  
	    public File zip(String filePath,File inputFile) throws Exception {  
	        System.out.println("ѹ����...");  
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(  
	        		filePath+sdf.format(new Date())+"Test_pg.zip"));  //ѹ����·��
	        BufferedOutputStream bo = new BufferedOutputStream(out);  
	        zip(out, inputFile, inputFile.getName(), bo);  
	        bo.close();  
	        out.close(); // ������ر�  
	        System.out.println("ѹ�����"); 
	        return inputFile;
	    }  
	  
	    public void zip(ZipOutputStream out, File f, String base,  
	            BufferedOutputStream bo) throws Exception { // ��������  
	        if (f.isDirectory()) {  
	            File[] fl = f.listFiles();  
	            if (fl.length == 0) {  
	                out.putNextEntry(new ZipEntry(base + "/")); // ����zipѹ�������base  
	                System.out.println(base + "/");  
	            }  
	            for (int i = 0; i < fl.length; i++) {  
	                zip(out, fl[i], base + "/" + fl[i].getName(), bo); // �ݹ�������ļ���  
	            }  
	            System.out.println("��" + k + "�εݹ�");  
	            k++;  
	        } else {  
	            out.putNextEntry(new ZipEntry(base)); // ����zipѹ�������base  
	            System.out.println(base);  
	            FileInputStream in = new FileInputStream(f);  
	            BufferedInputStream bi = new BufferedInputStream(in);  
	            int b;  
	            while ((b = bi.read()) != -1) {  
	                bo.write(b); // ���ֽ���д�뵱ǰzipĿ¼  
	            }  
	            bi.close();  
	            in.close(); // �������ر�  
	        }  
	    }  
}  
