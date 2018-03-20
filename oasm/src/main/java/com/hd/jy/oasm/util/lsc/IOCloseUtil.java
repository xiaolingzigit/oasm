package com.hd.jy.oasm.util.lsc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.apache.log4j.Logger;

public class IOCloseUtil {
	private static Logger logger = Logger.getLogger(IOCloseUtil.class);

	/**
	 * �ر�IO Writer
	 * 
	 * @param writer
	 * @return
	 */
	public static boolean close(Writer writer) {
		try {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
			return true;
		} catch (IOException e) {
			logger.warn("close Writer failed,details :" + e.getMessage(), e);
			return false;
		}
	}

	/**
	 * �ر�IO Reader
	 * 
	 * @param reader
	 * @return
	 */
	public static boolean close(Reader reader) {
		try {
			if (reader != null){
				reader.close();
			}
			return true;
		} catch (IOException e) {
			logger.warn("close Reader failed,details :" + e.getMessage(), e);
			return false;
		}
	}

	/**
	 * �ر�IO OutputStream
	 * 
	 * @param os
	 * @return
	 */
	public static boolean close(OutputStream os) {
		try {
			if (os != null) {
				os.flush();
				os.close();
			}
			return true;
		} catch (IOException e) {
			logger.warn("close OutputStream failed,details :" + e.getMessage(),
					e);
			return false;
		}
	}

	/**
	 * �ر�IO InputStream
	 * 
	 * @param is
	 * @return
	 */
	public static boolean close(InputStream is) {
		try {
			if (is != null){
				is.close();
			};
			return true;
		} catch (IOException e) {
			logger.warn("close InputStream failed,details :" + e.getMessage(),
					e);
			return false;
		}
	}
}

// Jdk�ṩ�����̳����Ĵ��ࣺ
// InputStream(�ֽ�������)��
// OutputStream���ֽ����������
// Reader���ַ�����������
// Writer���ַ����������

// ����IO��(�ַ���/�ֽ���)��
// OutputStream��FileOutputStream��ByteArrayOutputStream��ObjectOutputStream
// DataInputStream��PushbackInputStream
// ����reader: