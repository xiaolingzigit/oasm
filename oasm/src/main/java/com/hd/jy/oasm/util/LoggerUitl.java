package com.hd.jy.oasm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

public class LoggerUitl {
	/**
	 * 给指定路径下的所有java类添加LOGGER
	 *
	 * @Title: generateLogger
	 * @author Realfighter
	 * @param path
	 *            void
	 */
	public static void generateLogger(String path) {
	    File file = new File(path);
	    String [] test = file.list();
	    for (int i = 0; i < test.length; i++) {
	        if (test[i].endsWith(".java")) {
	            String filename = path + "\\" + test[i];
	            String content = "\n\t public static final Logger LOGGER = Logger.getLogger("
	                    + test[i].split(".java")[0] + ".class);\n}";
	            try {
	                RandomAccessFile randomFile = new RandomAccessFile(
	                        filename, "rw");
	                long filelength = randomFile.length();
	                int count = 0;
	                String sb = "";
	                while (randomFile.getFilePointer() < filelength) {
	                    count++;
	                    String s = randomFile.readLine();
	                    // String s = new String(randomFile.readLine().getBytes(
	                    // "ISO8859-1"), "UTF-8");
	                    if (count == 2) {
	                        sb += "import org.apache.log4j.Logger;\n";
	                    } else {
	                        sb += s + "\n";
	                    }
	                }
	                int endIndex = sb.lastIndexOf("}");
	                sb = sb.substring(0, endIndex) + content;
	                // System.out.println(sb);
	                String sbs = new String(sb.getBytes("ISO8859-1"), "UTF-8");
	                // System.out.println(sbs);
	                /**
	                 * 这里不使用randomFile写入文件，出现乱码
	                 *
	                    randomFile.seek(0);
	                    randomFile.writeBytes(sb);
	                    randomFile.write(sbs.getBytes("UTF-8"));
	                 */
	                randomFile.close();
	                /**
	                 * BufferedWriter写入
	                 */
	                File newfile = new File(filename);
	                if (newfile.exists()){
	                    newfile.delete();
	                };
	                newfile.createNewFile();
	                BufferedWriter br = new BufferedWriter(
	                        new OutputStreamWriter(
	                                new FileOutputStream(newfile)));
	                br.write(sbs);
	                br.newLine();
	                br.flush();
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
}
