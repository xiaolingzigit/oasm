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
 * 配置文件读写工具
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
	 * 根据配置文件获取Properties
	 * 
	 * @param propFilePath
	 * @param charset
	 *            null则不指定编码，如果properties文件含中文，则必须指定编码
	 * @param inSrc
	 *            是否在src目录内
	 * @return 异常或文件不存在返回null
	 * @throws IOException
	 */
	public static Properties properties(String propFilePath, String charset,
			boolean inSrc) throws IOException {

		InputStream is = null;
		InputStreamReader isr = null;

		try {
			// 判断是否应该获取src文件字节流
			if (inSrc) {
				is = PropUtil.class.getClassLoader().getResourceAsStream(
						propFilePath);
			} else {
				is = new FileInputStream(propFilePath);
			}

			// 判断是否采用指定编码，进行流转化
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
	 * 读取属性配置文件
	 * 
	 * @param propFilePath
	 * @param charset
	 *            null则不指定编码，如果properties文件含中文，则必须指定编码
	 * @param inSrc
	 *            是否在src目录内
	 * @param flagOfKey
	 *            key中含有的字符，用于筛选配置属性
	 * @param keySplitRegex
	 *            key分割标志，null则不作处理， "\\."
	 * @param startIdx
	 *            分割值起始标志位(含)，从0算起，小于0或大于endIdx则设为endIdx-1
	 * @param endIdx
	 *            分割值结束标志位(不含)，大于分割数组长度则修正为数组长度
	 * @return 异常或文件不存在返回null
	 * @throws IOException
	 */
	public static Map<String, String> getProperties(String propFilePath,
			String charset, boolean inSrc, String flagOfKey,
			String keySplitRegex, int startIdx, int endIdx) throws IOException {
		Properties prop = properties(propFilePath, charset, inSrc);

		return screenProps(prop, flagOfKey, keySplitRegex, startIdx, endIdx);
	}

	/**
	 * * 筛选配置信息
	 * 
	 * @param prop
	 *            Properties
	 * @param flagOfKey
	 *            key中含有的字符，用于筛选配置属性
	 * @param keySplitRegex
	 *            key分割标志，取末节为key，null则不作处理， "\\."
	 * @param startIdx
	 *            分割值起始标志位(含)，从0算起，小于0或大于endIdx则设为endIdx-1
	 * @param endIdx
	 *            分割值结束标志位(不含)，大于分割数组长度则修正为数组长度
	 * @return 异常或文件不存在返回null
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
	 * 键名获取
	 * 
	 * @param s
	 *            长键名
	 * @param splitRegex
	 *            分割标志，null则不分割
	 * @param startIdx
	 *            分割值起始标志位(含)，从0算起，小于0或大于endIdx则设为endIdx-1
	 * @param endIdx
	 *            分割值结束标志位(不含)，大于分割数组长度或小于1则修正为数组长度
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
	 * 截取键名最后一段字符作为键名
	 * 
	 * @param s
	 * @param splitRegex
	 *            键名分隔符
	 * @return
	 */
	public static String getShortKey(String s, String splitRegex) {
		return getShortKey(s, splitRegex, -1, -1);
	}

	/**
	 * 
	 * 读取属性配置文件
	 * 
	 * @param propFilePath
	 * @param charset
	 *            null则不指定编码，如果properties文件含中文，则必须指定编码
	 * @param inSrc
	 *            是否在src目录内
	 * @return 异常或文件不存在返回null
	 * @throws IOException
	 */
	public static Map<String, String> getProperties(String propFilePath,
			String charset, boolean inSrc) throws IOException {
		return getProperties(propFilePath, charset, inSrc, null, null, -1, -1);
	}

	/**
	 * 读取属性配置文件
	 * 
	 * @param propFilePath
	 * @param key
	 * @param charset
	 *            null则不指定编码，如果properties文件含中文，则必须指定编码
	 * @param inSrc
	 *            是否在src目录内
	 * @return 异常或文件不存在返回null
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
	 * 读取属性配置文件
	 * 
	 * @param propFilePath
	 * @param charset
	 *            null则不指定编码，如果properties文件含中文，则必须指定编码
	 * @param inSrc
	 *            是否在src目录内
	 * @param propertyNames
	 *            要获取的配置键名数组
	 * @return 返回与键名顺序一一对应的配置值数组，propertyValues of propertyNames，异常或文件不存在返回null
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
	 * 获取并显示配置
	 * 
	 * @param props
	 *            Properties
	 * @param propName
	 *            配置项名称
	 * @param propKey
	 *            配置项键名
	 * @param logger
	 *            如果null则使用System.*.println输出
	 * @param throwPropNotFound
	 *            如果配置中无propKey对应的配置时，是否抛异常
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
	 * 保存修改后的配置文件，注意避免保存到src目录，因为打包后，文件不能保存到jar包内
	 * 
	 * @param propFilePath
	 * @param key
	 *            不可为null
	 * @param value
	 *            需要null值则使用字符串"null"
	 * @param comment
	 * @param charset
	 *            null则不指定编码，如果properties文件含中文，则必须指定编码
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

			// 如果文件不存在，则创建
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
					// 如果是注释则把注释设为key
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

			boolean setDone = false; // 是否已经把值设置完毕
			loop: for (int i = 0; i < list.size(); i++) {
				KeyValue kv = list.get(i);

				if (kv.getKey().equals(key)) {

					kv.setValue(value);

					// 添加注释
					if (comment != null) {

						KeyValue kv1 = list.get(i - 1);

						if (kv1.getValue() == null
								&& (kv1.getKey().indexOf("=") < 0 || kv1
										.getKey().indexOf(":") < 0)) {
							// 替换注释
							kv1.setKey("#" + comment);
						} else {
							// 插入注释
							list.add(i, new KeyValue("#" + comment, null));
						}
					}

					setDone = true;
					break loop;
				}
			}

			// 如果对应的属性未曾配置过，则添加
			if (!setDone) {
				if (comment != null) {
					list.add(new KeyValue("#" + comment, null));
				}

				list.add(new KeyValue(key, value));
			}

			osw = new OutputStreamWriter(new FileOutputStream(propFilePath),
					charset);// 添加参数true表示追加打开

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
			// 是注释
			if (value == null) {
				return key;
			}
			return key + "=" + value;
		}
	}
}

//
// 使用J2SE API读取Properties文件的六种方法
//
// 1。使用java.util.Properties类的load()方法 示例：
// InputStream in = new BufferedInputStream(new FileInputStream(name));
// Properties p = new Properties();
// p.load(in);
//
// 2。使用java.util.ResourceBundle类的getBundle()方法 示例：
// ResourceBundle rb = ResourceBundle.getBundle(name, Locale.getDefault());
//
// 3。使用java.util.PropertyResourceBundle类的构造函数 示例：
// InputStream in = new BufferedInputStream(new FileInputStream(name));
// ResourceBundle rb = new
// PropertyResourceBundle(in);
//
// 4。使用class变量的getResourceAsStream()方法 示例：
// InputStream in = JProperties.class.getResourceAsStream(name);
// Properties p = new Properties();
// p.load(in);
//
// 5。使用class.getClassLoader()所得到的java.lang.ClassLoader的getResourceAsStream()方法
// 示例：
// InputStream in =
// JProperties.class.getClassLoader().getResourceAsStream(name);
// Properties p = new Properties();
// p.load(in);
//
// 6。使用java.lang.ClassLoader类的getSystemResourceAsStream()静态方法 示例：
// InputStream in = ClassLoader.getSystemResourceAsStream(name);
// Properties p = new Properties();
// p.load(in);
//
// 补充
//
// Servlet中可以使用javax.servlet.ServletContext的getResourceAsStream()方法
// 示例：
// InputStream in = context.getResourceAsStream(path);
// Properties p = new Properties();
// p.load(in);
