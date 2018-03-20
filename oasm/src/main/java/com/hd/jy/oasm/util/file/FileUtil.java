package com.hd.jy.oasm.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

public class FileUtil {
	/** 
     * ���ֽ�Ϊ��λ��ȡ�ļ��������ڶ��������ļ�����ͼƬ��������Ӱ����ļ��� 
     *  
     * @param fileName 
     *            �ļ����� 
     */  
    public static void readFileByBytes(String fileName) {  
        File file = new File(fileName);  
        InputStream in = null;  
        try {  
            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");  
            // һ�ζ�һ���ֽ�  
            in = new FileInputStream(file);  
            int tempbyte;  
            while ((tempbyte = in.read()) != -1) {  
                System.out.write(tempbyte);  
            }  
            in.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
            return;  
        }  
    }  
  
    /** 
     * ���ֽ�Ϊ��λ��ȡ�ļ��������ڶ��������ļ�����ͼƬ��������Ӱ����ļ��� 
     *  
     * @param fileName 
     *            �ļ����� 
     */  
    public static void readFileByByte(String fileName) {  
        File file = new File(fileName);  
        InputStream in = null;  
        try {  
            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");  
            // һ�ζ�����ֽ�  
            byte[] tempbytes = new byte[100];  
            int byteread = 0;  
            in = new FileInputStream(file);  
            showAvailableBytes(in);  
            // �������ֽڵ��ֽ������У�bytereadΪһ�ζ�����ֽ���  
            while ((byteread = in.read(tempbytes)) != -1) {  
                System.out.write(tempbytes, 0, byteread);  
            }  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        } finally {  
            if (in != null) {  
                try {  
                    in.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * ���ַ�Ϊ��λ��ȡ�ļ��������ڶ��ı������ֵ����͵��ļ� 
     *  
     * @param fileName 
     *            �ļ��� 
     */  
    public static void readFileByChar(String fileName) {  
        File file = new File(fileName);  
        Reader reader = null;  
  
        try {  
            System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");  
            // һ�ζ�����ַ�  
            char[] tempchars = new char[30];  
            int charread = 0;  
            reader = new InputStreamReader(new FileInputStream(file));  
            // �������ַ����ַ������У�charreadΪһ�ζ�ȡ�ַ���  
            while ((charread = reader.read(tempchars)) != -1) {  
                // ͬ�����ε�r����ʾ  
                if ((charread == tempchars.length)  
                        && (tempchars[tempchars.length - 1] != 'r')) {  
                    System.out.print(tempchars);  
                } else {  
                    for (int i = 0; i < charread; i++) {  
                        if (tempchars[i] == 'r') {  
                            continue;  
                        } else {  
                            System.out.print(tempchars[i]);  
                        }  
                    }  
                }  
            }  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * ���ַ�Ϊ��λ��ȡ�ļ��������ڶ��ı������ֵ����͵��ļ� 
     *  
     * @param fileName 
     *            �ļ��� 
     */  
    public static void readFileByChars(String fileName) {  
        File file = new File(fileName);  
        Reader reader = null;  
        try {  
            System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");  
            // һ�ζ�����ַ�  
            char[] tempchars = new char[30];  
            int charread = 0;  
            reader = new InputStreamReader(new FileInputStream(file));  
            // �������ַ����ַ������У�charreadΪһ�ζ�ȡ�ַ���  
            while ((charread = reader.read(tempchars)) != -1) {  
                // ͬ�����ε�r����ʾ  
                if ((charread == tempchars.length)  
                        && (tempchars[tempchars.length - 1] != 'r')) {  
                    System.out.print(tempchars);  
                } else {  
                    for (int i = 0; i < charread; i++) {  
                        if (tempchars[i] == 'r') {  
                            continue;  
                        } else {  
                            System.out.print(tempchars[i]);  
                        }  
                    }  
                }  
            }  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ� 
     *  
     * @param fileName 
     *            �ļ��� 
     */  
    public static void readFileByLines(String fileName) {  
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {  
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
            while ((tempString = reader.readLine()) != null) {  
                // ��ʾ�к�  
                System.out.println("line " + line + ": " + tempString);  
                line++;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * �����ȡ�ļ����� 
     *  
     * @param fileName 
     *            �ļ��� 
     */  
    public static void readFileByRandomAccess(String fileName) {  
        RandomAccessFile randomFile = null;  
        try {  
            System.out.println("�����ȡһ���ļ����ݣ�");  
            // ��һ����������ļ�������ֻ����ʽ  
            randomFile = new RandomAccessFile(fileName, "r");  
            // �ļ����ȣ��ֽ���  
            long fileLength = randomFile.length();  
            // ���ļ�����ʼλ��  
            int beginIndex = (fileLength > 4) ? 4 : 0;  
            // �����ļ��Ŀ�ʼλ���Ƶ�beginIndexλ�á�  
            randomFile.seek(beginIndex);  
            byte[] bytes = new byte[10];  
            int byteread = 0;  
            // һ�ζ�10���ֽڣ�����ļ����ݲ���10���ֽڣ����ʣ�µ��ֽڡ�  
            // ��һ�ζ�ȡ���ֽ�������byteread  
            while ((byteread = randomFile.read(bytes)) != -1) {  
                System.out.write(bytes, 0, byteread);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (randomFile != null) {  
                try {  
                    randomFile.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * ��ʾ�������л�ʣ���ֽ��� 
     *  
     * @param in 
     */  
    private static void showAvailableBytes(InputStream in) {  
        try {  
            System.out.println("��ǰ�ֽ��������е��ֽ���Ϊ:" + in.available());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * RandomAccessFile׷���ļ� 
     *  
     * @param fileName 
     *            �ļ��� 
     * @param content 
     *            ׷�ӵ����� 
     */  
    public static void appendMethodByRandomAccessFile(String fileName,  
            String content) {  
        System.out.println("RandomAccessFile׷���ļ�");  
        try {  
            // ��һ����������ļ���������д��ʽ  
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");  
            // �ļ����ȣ��ֽ���  
            long fileLength = randomFile.length();  
            // ��д�ļ�ָ���Ƶ��ļ�β��  
            randomFile.seek(fileLength);  
            randomFile.writeBytes(content);  
            randomFile.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * FileWriter׷���ļ� 
     *  
     * @param fileName 
     * @param content 
     */  
    public static void appendMethodByFileWriter(String fileName, String content) {  
        System.out.println("appendMethodByFileWriter");  
        try {  
            // ��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�  
            FileWriter writer = new FileWriter(fileName, true);  
            writer.write(content);  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    /**
     * 
     * @auto quite
     * @param argsa
     * ����2:53:14
     * void
     */
    public static void main(String[] args) {  
//        String path = FileUtil.class.getResource("").getFile();  
        String fileName = "E:"+ "/20170829����������.psydocs";  
        FileUtil.readFileByByte(fileName);  
        System.out.println("");  
        FileUtil.readFileByBytes(fileName);  
        System.out.println("");  
        FileUtil.readFileByChar(fileName);  
        System.out.println("");  
        FileUtil.readFileByChars(fileName);  
        System.out.println("");  
        FileUtil.readFileByLines(fileName);  
        System.out.println("");  
        FileUtil.readFileByRandomAccess(fileName);  
        System.out.println("");  
//        String content = "\nnew append RandomAccessFile!";  
//        FileUtil.appendMethodByRandomAccessFile(fileName, content);  
//        FileUtil.appendMethodByRandomAccessFile(fileName,  
//                "\nappend end RandomAccessFile");  
//        FileUtil.readFileByLines(fileName);  
//        System.out.println("");  
//        FileUtil.appendMethodByFileWriter(fileName, content);  
//        FileUtil.appendMethodByFileWriter(fileName,  
//                "\nappend end appendMethodByFileWriter");  
//        FileUtil.readFileByLines(fileName);  
    }  
}
