package com.hd.jy.oasm.mina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NewCommand {
	public static void main(String[] args) {
		  String batName = "‪ipconfig"; //如果文件不在项目目录下则需要直接写出文件路径
		  NewCommand rBat = new NewCommand();
	      rBat.run_bat(batName);
	}
	
	 public void run_bat(String batName) {
		 ArrayList<String> processList = new ArrayList<String>();
         Process ps;
         try {
             ps = Runtime.getRuntime().exec("cmd.exe /C "+batName);
             ps.waitFor();
             BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
     	    String line="";
     	    while((line=reader.readLine())!=null){
     	    	processList.add(line);
     	    }
     	    reader.close();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
     System.out.println("finish");       
 }

}
