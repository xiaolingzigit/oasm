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
 * 压缩文件
 * @author quite
 *
 */
public class ZIPcompression {

	 private int k = 1; // 定义递归次数变量  
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
	            	System.out.println("文件输入路径"+zip);
	            	zip.delete();
	            }
	        } catch (Exception e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	  
	    }  
	  
	    public File zip(String filePath,File inputFile) throws Exception {  
	        System.out.println("压缩中...");  
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(  
	        		filePath+sdf.format(new Date())+"Test_pg.zip"));  //压缩的路径
	        BufferedOutputStream bo = new BufferedOutputStream(out);  
	        zip(out, inputFile, inputFile.getName(), bo);  
	        bo.close();  
	        out.close(); // 输出流关闭  
	        System.out.println("压缩完成"); 
	        return inputFile;
	    }  
	  
	    public void zip(ZipOutputStream out, File f, String base,  
	            BufferedOutputStream bo) throws Exception { // 方法重载  
	        if (f.isDirectory()) {  
	            File[] fl = f.listFiles();  
	            if (fl.length == 0) {  
	                out.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base  
	                System.out.println(base + "/");  
	            }  
	            for (int i = 0; i < fl.length; i++) {  
	                zip(out, fl[i], base + "/" + fl[i].getName(), bo); // 递归遍历子文件夹  
	            }  
	            System.out.println("第" + k + "次递归");  
	            k++;  
	        } else {  
	            out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base  
	            System.out.println(base);  
	            FileInputStream in = new FileInputStream(f);  
	            BufferedInputStream bi = new BufferedInputStream(in);  
	            int b;  
	            while ((b = bi.read()) != -1) {  
	                bo.write(b); // 将字节流写入当前zip目录  
	            }  
	            bi.close();  
	            in.close(); // 输入流关闭  
	        }  
	    }  
}  
