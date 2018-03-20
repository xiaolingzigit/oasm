/**
 * 
 */
package com.hd.jy.oasm.util.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 解压文件
 * @author quite
 *
 */
public class ZIPdecompression {
	 public static void main(String[] args) {  
	        // TODO Auto-generated method stub  
		  String filePath = "D:\\online\\20180112100337Test_pg.zip";
		  String outPath = "D:\\online";
	       String decomPath = new ZIPdecompression().zipDecom(filePath, outPath);  
	       System.out.println(decomPath);
	    }

	/**
	 * @todo TODO
	 * @auth quite
	 * @time 2018年1月12日 上午9:51:46
	 * 
	 */
	public String zipDecom(String filePath,String outPath) {
		long startTime=System.currentTimeMillis();  
		String Parent = "";
		try {  
		    ZipInputStream Zin=new ZipInputStream(new FileInputStream(filePath));//输入源zip路径  
		    BufferedInputStream Bin=new BufferedInputStream(Zin);  
		    Parent =outPath; //输出路径（文件夹目录）  
		    File Fout=null;  
		    ZipEntry entry;  
		    try {  
		        while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){  
		            Fout=new File(Parent,entry.getName());  
		            if(!Fout.exists()){  
		                (new File(Fout.getParent())).mkdirs();  
		            }  
		            FileOutputStream out=new FileOutputStream(Fout);  
		            BufferedOutputStream Bout=new BufferedOutputStream(out);  
		            int b;  
		            while((b=Bin.read())!=-1){  
		                Bout.write(b);  
		            }  
		            Bout.close();  
		            out.close();  
		            System.out.println(Fout+"解压成功");    
		            return Parent;
		        }  
		        Bin.close();  
		        Zin.close();  
		    } catch (IOException e) {  
		        // TODO Auto-generated catch block  
		        e.printStackTrace();  
		    }  
		} catch (FileNotFoundException e) {  
		    // TODO Auto-generated catch block  
		    e.printStackTrace();  
		}  
		long endTime=System.currentTimeMillis();  
		System.out.println("耗费时间： "+(endTime-startTime)+" ms");
		return Parent;
	}
}
