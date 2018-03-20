package com.hd.jy.oasm.util.lsc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.hd.jy.oasm.util.lsc.excpts.InitException;
import com.hd.jy.oasm.util.lsc.excpts.NullException;

/**
 * �����ļ���д����
 * 
 * @author ander
 */
public class PropUtil {
	// private static Logger logger = Logger.getLogger(PropUtil.class);

	// private static Map<String,Properties> propMap = new HashMap<String,
	// Properties>();

	public static Properties properties(InputStream is) throws IOException{
		Properties prop= new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			throw new IOException("load properties from inputStream failed",e);
		}
		return prop;
	}
	
	
	/**
	 * 
	 * ���������ļ���ȡProperties
	 * 
	 * @param propFilePath
	 * @param charset
	 *            null��ָ�����룬���properties�ļ������ģ������ָ������
	 * @param inSrc
	 *            �Ƿ���srcĿ¼��
	 * @return �쳣���ļ������ڷ���null
	 * @throws IOException
	 */
	public static Properties properties(String propFilePath, String charset,
			boolean inSrc) throws IOException {

		InputStream is = null;
		InputStreamReader isr = null;

		try {
			// �ж��Ƿ�Ӧ�û�ȡsrc�ļ��ֽ���
			if (inSrc) {
				is = PropUtil.class.getClassLoader().getResourceAsStream(
						propFilePath);
			} else {
				is = new FileInputStream(propFilePath);
			}

			// �ж��Ƿ����ָ�����룬������ת��
			if (charset == null) {
				isr = new InputStreamReader(is);
			} else {
				isr = new InputStreamReader(is, charset);
			}

			Properties prop = new Properties();
			prop.load(isr);

			return prop;
		} catch (IOException e) {
			throw new IOException("get properties from file[" + propFilePath
					+ "] with charset[" + charset + "] failed", e);
		} finally {
			IOCloseUtil.close(isr);
			IOCloseUtil.close(is);
		}
	}

	/**
	 * 
	 * ��ȡ���������ļ�
	 * 
	 * @param propFilePath
	 * @param charset
	 *            null��ָ�����룬���properties�ļ������ģ������ָ������
	 * @param inSrc
	 *            �Ƿ���srcĿ¼��
	 * @param flagOfKey
	 *            key�к��е��ַ�������ɸѡ��������
	 * @param keySplitRegex
	 *            key�ָ��־��null�������� "\\."
	 * @param startIdx
	 *            �ָ�ֵ��ʼ��־λ(��)����0����С��0�����endIdx����ΪendIdx-1
	 * @param endIdx
	 *            �ָ�ֵ������־λ(����)�����ڷָ����鳤��������Ϊ���鳤��
	 * @return �쳣���ļ������ڷ���null
	 * @throws IOException
	 */
	public static Map<String, String> getProperties(String propFilePath,
			String charset, boolean inSrc, String flagOfKey,
			String keySplitRegex, int startIdx, int endIdx) throws IOException {
		Properties prop = properties(propFilePath, charset, inSrc);

		return screenProps(prop, flagOfKey, keySplitRegex, startIdx, endIdx);
	}

	/**
	 * * ɸѡ������Ϣ
	 * 
	 * @param prop
	 *            Properties
	 * @param flagOfKey
	 *            key�к��е��ַ�������ɸѡ��������
	 * @param keySplitRegex
	 *            key�ָ��־��ȡĩ��Ϊkey��null�������� "\\."
	 * @param startIdx
	 *            �ָ�ֵ��ʼ��־λ(��)����0����С��0�����endIdx����ΪendIdx-1
	 * @param endIdx
	 *            �ָ�ֵ������־λ(����)�����ڷָ����鳤��������Ϊ���鳤��
	 * @return �쳣���ļ������ڷ���null
	 */
	public static LinkedHashMap<String, String> screenProps(Properties prop,
			String flagOfKey, String keySplitRegex, int startIdx, int endIdx) {

		if (prop == null) {
			return null;
		}

		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

		for (Entry<Object, Object> ele : prop.entrySet()) {
			String key = (String) ele.getKey();

			if (flagOfKey == null || key.contains(flagOfKey)) {
				map.put(getShortKey(key, keySplitRegex, startIdx, endIdx),
						prop.getProperty(key));
			}
		}

		return map;
	}

	/**
	 * ������ȡ
	 * 
	 * @param s
	 *            ������
	 * @param splitRegex
	 *            �ָ��־��null�򲻷ָ�
	 * @param startIdx
	 *            �ָ�ֵ��ʼ��־λ(��)����0����С��0�����endIdx����ΪendIdx-1
	 * @param endIdx
	 *            �ָ�ֵ������־λ(����)�����ڷָ����鳤�Ȼ�С��1������Ϊ���鳤��
	 * @return
	 */
	public static String getShortKey(String s, String splitRegex, int startIdx,
			int endIdx) {

		if (s == null || splitRegex == null) {
			return s;
		}

		String[] arr = s.split(splitRegex);
		splitRegex = splitRegex.replace("\\", "");

		if (endIdx > arr.length || endIdx <= 0) {
			endIdx = arr.length;
		}

		if (startIdx < 0 || startIdx > endIdx) {
			startIdx = endIdx - 1;
		}

		s = "";
		for (; startIdx < endIdx; startIdx++) {
			if (!"".equals(s)) {
				s += splitRegex;
			}
			s += arr[startIdx];
		}

		return s;
	}

	/**
	 * ��ȡ�������һ���ַ���Ϊ����
	 * 
	 * @param s
	 * @param splitRegex
	 *            �����ָ���
	 * @return
	 */
	public static String getShortKey(String s, String splitRegex) {
		return getShortKey(s, splitRegex, -1, -1);
	}

	/**
	 * 
	 * ��ȡ���������ļ�
	 * 
	 * @param propFilePath
	 * @param charset
	 *            null��ָ�����룬���properties�ļ������ģ������ָ������
	 * @param inSrc
	 *            �Ƿ���srcĿ¼��
	 * @return �쳣���ļ������ڷ���null
	 * @throws IOException
	 */
	public static Map<String, String> getProperties(String propFilePath,
			String charset, boolean inSrc) throws IOException {
		return getProperties(propFilePath, charset, inSrc, null, null, -1, -1);
	}

	/**
	 * ��ȡ���������ļ�
	 * 
	 * @param propFilePath
	 * @param key
	 * @param charset
	 *            null��ָ�����룬���properties�ļ������ģ������ָ������
	 * @param inSrc
	 *            �Ƿ���srcĿ¼��
	 * @return �쳣���ļ������ڷ���null
	 * @throws IOException
	 */
	public static String getProperty(String propFilePath, String key,
			String charset, boolean inSrc) throws IOException {

		Properties prop = properties(propFilePath, charset, inSrc);

		if (prop == null) {
			return null;
		}
		return (String) prop.get(key);
	}

	/**
	 * ��ȡ���������ļ�
	 * 
	 * @param propFilePath
	 * @param charset
	 *            null��ָ�����룬���properties�ļ������ģ������ָ������
	 * @param inSrc
	 *            �Ƿ���srcĿ¼��
	 * @param propertyNames
	 *            Ҫ��ȡ�����ü�������
	 * @return ���������˳��һһ��Ӧ������ֵ���飬propertyValues of propertyNames���쳣���ļ������ڷ���null
	 * @throws IOException
	 */
	public static String[] getPropsByKeys(String propFilePath, String charset,
			boolean inSrc, String... propertyNames) throws IOException {

		if (propertyNames == null) {
			return null;
		}

		Map<String, String> map = getProperties(propFilePath, charset, inSrc);

		if (map == null) {
			return null;
		}

		int length = propertyNames.length;
		String[] prop = new String[length];

		for (int i = 0; i < length; i++) {
			prop[i] = map.get(propertyNames[i]);
		}

		return prop;
	}

	/**
	 * 
	 * ��ȡ����ʾ����
	 * 
	 * @param props
	 *            Properties
	 * @param propName
	 *            ����������
	 * @param propKey
	 *            ���������
	 * @param logger
	 *            ���null��ʹ��System.*.println���
	 * @param throwPropNotFound
	 *            �����������propKey��Ӧ������ʱ���Ƿ����쳣
	 * @return
	 */
	public static String touchProp(Properties props, String propName,
			String propKey, Logger logger, boolean throwPropNotFound) {

		String propItem = propName + "[" + propKey + "]";
		String val = props.getProperty(propKey);
		if (val == null) {
			String errMsg = propItem + "is not found in properties";

			if (throwPropNotFound) {
				throw new InitException(errMsg);
			} else {
				if (logger == null) {
					System.err.println(errMsg);
				} else {
					logger.warn(errMsg);
				}
			}
		} else {

			if (logger == null) {
				System.out.println(propItem + "=" + val);
			} else {
				logger.info(propItem + "=" + val);
			}
		}

		return val;
	}

	/**
	 * �����޸ĺ�������ļ���ע����Ᵽ�浽srcĿ¼����Ϊ������ļ����ܱ��浽jar����
	 * 
	 * @param propFilePath
	 * @param key
	 *            ����Ϊnull
	 * @param value
	 *            ��Ҫnullֵ��ʹ���ַ���"null"
	 * @param comment
	 * @param charset
	 *            null��ָ�����룬���properties�ļ������ģ������ָ������
	 * @throws IOException
	 */
	public static void saveProperty(String propFilePath, String key,
			String value, String comment, String charset) throws IOException {

		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStreamWriter osw = null;

		try {
			if (key == null) {
				throw new NullException("key");
			} else {
				key = key.trim();
			}

			if (value == null) {
				value = "";
			} else {
				value = value.trim();
			}

			// ����ļ������ڣ��򴴽�
			File file = new File(propFilePath);
			if (!file.exists()) {
				file.createNewFile();
			}

			if (charset == null) {
				isr = new InputStreamReader(new FileInputStream(propFilePath));
			} else {
				isr = new InputStreamReader(new FileInputStream(propFilePath),
						charset);
			}

			br = new BufferedReader(isr);

			List<KeyValue> list = new ArrayList<KeyValue>();
			String line = null;
			int subIndex;
			while ((line = br.readLine()) != null) {

				subIndex = 0;
				if (line.startsWith("#")) {
					// �����ע�����ע����Ϊkey
					list.add(new KeyValue(line, null));

				} else if ((subIndex = line.indexOf("=")) >= 0) {
					list.add(new KeyValue(line.substring(0, subIndex).trim(),
							line.substring(subIndex + 1).trim()));

				} else if ((subIndex = line.indexOf(":")) >= 0) {
					list.add(new KeyValue(line.substring(0, subIndex).trim(),
							line.substring(subIndex + 1).trim()));

				} else {
					list.add(new KeyValue("#" + line, null));
				}
			}

			IOCloseUtil.close(isr);
			IOCloseUtil.close(br);

			boolean setDone = false; // �Ƿ��Ѿ���ֵ�������
			loop: for (int i = 0; i < list.size(); i++) {
				KeyValue kv = list.get(i);

				if (kv.getKey().equals(key)) {

					kv.setValue(value);

					// ���ע��
					if (comment != null) {

						KeyValue kv1 = list.get(i - 1);

						if (kv1.getValue() == null
								&& (kv1.getKey().indexOf("=") < 0 || kv1
										.getKey().indexOf(":") < 0)) {
							// �滻ע��
							kv1.setKey("#" + comment);
						} else {
							// ����ע��
							list.add(i, new KeyValue("#" + comment, null));
						}
					}

					setDone = true;
					break loop;
				}
			}

			// �����Ӧ������δ�����ù��������
			if (!setDone) {
				if (comment != null) {
					list.add(new KeyValue("#" + comment, null));
				}

				list.add(new KeyValue(key, value));
			}

			osw = new OutputStreamWriter(new FileOutputStream(propFilePath),
					charset);// ��Ӳ���true��ʾ׷�Ӵ�

			for (KeyValue kv : list) {
				osw.write(kv.toString());
				osw.write("\n");
			}

		} catch (Exception e) {
			throw new IOException("save property[key=" + key + ", value="
					+ value + ", comment=" + comment + ", charset=" + charset
					+ "] to file[" + propFilePath + "] failed:"
					+ e.getMessage(), e);
		} finally {
			IOCloseUtil.close(isr);
			IOCloseUtil.close(br);
			IOCloseUtil.close(osw);
		}
	}

	private static class KeyValue {
		private String key;
		private String value;

		public KeyValue(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			// ��ע��
			if (value == null) {
				return key;
			}
			return key + "=" + value;
		}
	}
}

//
// ʹ��J2SE API��ȡProperties�ļ������ַ���
//
// 1��ʹ��java.util.Properties���load()���� ʾ����
// InputStream in = new BufferedInputStream(new FileInputStream(name));
// Properties p = new Properties();
// p.load(in);
//
// 2��ʹ��java.util.ResourceBundle���getBundle()���� ʾ����
// ResourceBundle rb = ResourceBundle.getBundle(name, Locale.getDefault());
//
// 3��ʹ��java.util.PropertyResourceBundle��Ĺ��캯�� ʾ����
// InputStream in = new BufferedInputStream(new FileInputStream(name));
// ResourceBundle rb = new
// PropertyResourceBundle(in);
//
// 4��ʹ��class������getResourceAsStream()���� ʾ����
// InputStream in = JProperties.class.getResourceAsStream(name);
// Properties p = new Properties();
// p.load(in);
//
// 5��ʹ��class.getClassLoader()���õ���java.lang.ClassLoader��getResourceAsStream()����
// ʾ����
// InputStream in =
// JProperties.class.getClassLoader().getResourceAsStream(name);
// Properties p = new Properties();
// p.load(in);
//
// 6��ʹ��java.lang.ClassLoader���getSystemResourceAsStream()��̬���� ʾ����
// InputStream in = ClassLoader.getSystemResourceAsStream(name);
// Properties p = new Properties();
// p.load(in);
//
// ����
//
// Servlet�п���ʹ��javax.servlet.ServletContext��getResourceAsStream()����
// ʾ����
// InputStream in = context.getResourceAsStream(path);
// Properties p = new Properties();
// p.load(in);
