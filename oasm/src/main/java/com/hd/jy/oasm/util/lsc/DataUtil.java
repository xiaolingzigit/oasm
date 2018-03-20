package com.hd.jy.oasm.util.lsc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.formula.functions.T;

import com.hd.jy.oasm.util.lsc.excpts.IllegalException;
import com.hd.jy.oasm.util.lsc.excpts.MismatchException;
import com.hd.jy.oasm.util.lsc.excpts.NullException;
import com.hd.jy.oasm.util.lsc.excpts.UnsupportedException;

/**
 * 字符处理工具,如：字符串转换成数值类型，16进制值与String/Byte之间的转换等
 * 
 * @author ander
 * 
 */
public class DataUtil  {

	private static Logger logger = Logger.getLogger(DataUtil.class);

	/** 十六进制字符的 小写字母 有序数组 */
	public final static char[] HEX_CHARS_L = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/** 十六进制字符的 大写字母 有序数组 */
	public final static char[] HEX_CHARS_U = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/** 十六进制字符的 小写字母 有序字符串 */
	public final static String HEX_CHAR_STRING_L = "0123456789abcdef";

	/** 十六进制字符的 大写字母 有序字符串 */
	public final static String HEX_CHAR_STRING_U = "0123456789ABCDEF";
	/** 字符串空格的byte值 */
	public static final int BLANK_BYTE_VAL = 32;

	/**
	 * 十六进制字符转整数
	 * 
	 * @param c
	 * @return
	 */
	public static int hexChartoInt(char c) {
		return HEX_CHAR_STRING_L.indexOf((c + "").toLowerCase());
	}

	/**
	 * 获取十六进制表示字符对应的byte值如a或A均表示10
	 * 
	 * @param c
	 * @return
	 */
	public static byte hexCharToByte(char c) {
		return (byte) hexChartoInt(c);
	}

	/**
	 * 将表示16进制值的字符串转换为byte数组
	 * 
	 * @param hexString
	 *            需要转换的十六进制字符串
	 * @return
	 */
	public static byte[] hexStr2Bytes(String hexString) {
		if (hexString == null) {
			return null;
		}

		if (hexString.isEmpty()) {
			return new byte[0];
		}

		// 方法一：
		// byte[] tmp = hexString.getBytes();
		// int tlen = tmp.length;
		//
		// // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		// byte[] bytes = new byte[tlen / 2];
		//
		// for (int i = 0; i < tlen; i += 2) {
		// String strTmp = new String(tmp, i, 2);
		// bytes[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		// }
		// return bytes;

		// 方法二：
		char[] hexChars = hexString.toCharArray();

		int len = hexString.length() / 2;
		byte[] bytes = new byte[len];

		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			bytes[i] = (byte) (hexCharToByte(hexChars[pos]) << 4 | hexCharToByte(hexChars[pos + 1]));

		}

		return bytes;
	}

	/**
	 * 将字节数组转化成十六进制字符串
	 * 
	 * @param bytes
	 *            要转化的byte数组
	 * @return 十六进制字符串，bytes=null返回null,bytes.length=0返回""
	 */
	public static String toHexString(byte[] bytes) {

		if (bytes == null) {
			return null;
		} else if (bytes.length == 0) {
			return "";
		}

		int len = bytes.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是byte数组长度的两倍
		StringBuilder sbd = new StringBuilder(len * 2);

		for (int i = 0; i < len; i++) {
			// 方法一：
			// byte的大小为8bits而int的大小为32bits,java的二进制采用的是补码形式
			// int值和0xff相与后，使高24bite清0
			String hexVal = Integer.toHexString(bytes[i] & 0xff);// 0xFF

			if (hexVal.length() == 1) {
				sbd.append(0);// 高4位填0
			}
			sbd.append(hexVal);

			// 方法二：

			// int intTmp = bytes[i];
			//
			// if (intTmp < 0)
			// intTmp += 256;// 把byte负数转换为正数
			//
			// // 小于0f的数(f)需要在前面补0
			// if (intTmp < 16) {
			// sbd.append(0);
			// }
			// sbd.append(Integer.toString(intTmp, 16));

		}

		return sbd.toString();
	}

	/**
	 * * 字节数组转字符串
	 * 
	 * @param data
	 * @param charset
	 *            null则使用环境默认编码
	 * @param trim
	 *            是否去除两端空格
	 * @return
	 */
	public static String toString(byte[] data, Charset charset, boolean trim) {

		if (data == null) {
			return null;
		}

		String str;
		if (charset == null) {
			str = new String(data);
		} else {
			str = new String(data, charset);
		}

		if (trim) {
			str = str.trim();
		}

		return str;
	}

	/**
	 * String数组拼接成字符串，如toString(strArr, ",",true)==>[ ele1,ele2]
	 * 
	 * @param strArr
	 * @param separator
	 *            元素分隔符，可用","、" "等任意字符，null或""即没有分隔符
	 * @param addBorder
	 *            是否添加边界标志符"[]"，null则不添加
	 * @return
	 */
	@SuppressWarnings("hiding")
	public static <T> String toString(T[] arr, String separator,
			boolean addBorder) {
		if (arr == null) {
			return "";
		}
		if (separator == null) {
			separator = "";
		}

		StringBuilder sbd = new StringBuilder();

		if (addBorder) {
			sbd.append("[");
		}

		int length = arr.length;
		for (int i = 0; i < length; i++) {

			sbd.append(String.valueOf(arr[i]));

			if (i < length - 1) {
				sbd.append(separator);
			}
		}

		if (addBorder) {
			sbd.append("]");
		}

		return sbd.toString();
	}

	/**
	 * 数组转字符串如toString(strArr)==>[ ele1,ele2]
	 * 
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("hiding")
	public static <T> String toString(T[] arr) {
		return toString(arr, ", ", true);
	}

	/**
	 * * 数组转list
	 * 
	 * @param <T>
	 * 
	 * @param list
	 *            需要转换的list
	 * @return
	 */
	public static  T[] toArray(List<T> list) {
		if (list == null) {
			return null;
		}

		if (list.size() == 0) {
			return (T[]) new Object[0];
		}

		Class<?> eleClazz = list.get(0).getClass();

		for (T ele : list) {
			eleClazz = ReflectUtil.commonClass(eleClazz, ele.getClass());
		}

		T[] arr = (T[]) Array.newInstance(eleClazz, list.size());
		// list.toArray()
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		return arr;
	}
	
	/**
	 * 把map元素转化为key~val的String[]数组
	 * @param map
	 * @param keyValJointMark 键值对连接符
	 * @return
	 */
	@SuppressWarnings("hiding")
	public static <T> String[] toStrArr(Map<T, T> map, String keyValJointMark) {
		if (map == null) {
			return null;
		}
		if (keyValJointMark == null) {
			keyValJointMark = "=";
		}
		
		String[] arr = new String[map.size()];
		int i = 0;
		for (Map.Entry<T, T> e : map.entrySet()) {
			arr[i] = e.getKey() + keyValJointMark + e.getValue();
			i++;
		}

		return arr;

	}

	/**
	 * * 数组转list
	 * 
	 * @param <T>
	 * 
	 * @param srcArr
	 *            需要转换的数组
	 * @param list
	 *            目标list，null则返回ArrayList
	 * @return
	 */
	@SuppressWarnings("hiding")
	public static <T> List<T> toList(T[] srcArr) {
		if (srcArr == null) {
			return null;
		}

		ArrayList<T> list = new ArrayList<T>();
		for (T t : srcArr) {
			list.add(t);
		}
		return list;
	}

	/**
	 * 將字符串转化为String[]
	 * 
	 * @param str
	 *            null则返回null
	 * @param splitRegex
	 *            不可null
	 * @param invalStrRegex
	 *            去除多余字符的正则表达式
	 * @return
	 */
	public static String[] toStrArr(String str, String splitRegex,
			String borderRegex, boolean trim) {
		if (str == null) {
			return null;
		}

		String[] arr = str.split(splitRegex);
		if (borderRegex != null && arr.length > 0) {
			arr[0] = arr[0].replaceAll(borderRegex, "");
			if (arr.length > 1) {
				arr[arr.length - 1] = arr[arr.length - 1].replaceAll(
						borderRegex, "");
			}
		}

		if (trim) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = arr[i].trim();
			}
		}

		return arr;
	}

	/**
	 * 对String[]中的元素去除两端空格，如果元素是null则依然为null
	 * 
	 * @param strArr
	 * @return
	 */
	public static String[] trimElement(String[] strArr) {
		if (strArr == null) {
			return null;
		}

		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = trim(strArr[i]);
		}

		return strArr;
	}

	/**
	 * 去除字符串中的空格
	 * 
	 * @param s
	 * @param returnNull
	 *            当s为null时是否返回null否则返回空字符串
	 * @return
	 */
	public static String trimBlank(String s, boolean returnNull) {
		if (s == null) {
			return returnNull ? null : "";
		}

		return s.replaceAll(" ", "");
	}

	/**
	 * 去除字符串中的空格
	 * 
	 * @param s
	 * @return 当s为null时是否返回null
	 */
	public static String trimBlank(String s) {
		return s == null ? null : s.replaceAll("( )+", "");
	}
	
	/**
	 * 字符替换
	 * @param s null则直接返回null
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public static String replaceAll(String s,String regex,String replacement) {
		return s == null ? null : s.replaceAll(regex, replacement);
	}

	/**
	 * 字符串截取
	 * 
	 * @param content
	 * @param startFlag
	 *            null或不含则从0开始
	 * @param endFlag
	 *            null或不含则截取至末尾
	 * @return
	 */
	public static String subPart(String content, String startFlag,
			String endFlag) {
		if (content == null) {
			return null;
		}
		int idx1 = 0;
		int idx2 = 0;

		if (startFlag != null && (idx1 = content.indexOf(startFlag)) >= 0) {
			idx1 = idx1 + startFlag.length();
		}

		if (endFlag == null || (idx2 = content.indexOf(endFlag)) < 0) {
			idx2 = content.length();
		}

		String s = content.substring(idx1, idx2);

		return s;
	}

	/**
	 * 字符串截取
	 * 
	 * @param content
	 * @param startFlag
	 *            null或不含则从0开始
	 * @param endFlag
	 *            null或不含则截取至末尾
	 * @return
	 */
	public static String subPart(String content, String delimiter, int partIdx,
			boolean fixIdx) {
		if (content == null) {
			return null;
		}

		if (delimiter == null) {
			return content;
		}

		String[] subParts = content.split(delimiter);
	
		if (subParts.length < 1) {
			return content;
		}

		if (fixIdx) {
			if (partIdx >= subParts.length || partIdx <= -2) {
				partIdx = subParts.length - 1;
			} else if (partIdx < 0) {
				partIdx = 0;
			}
		}

		return subParts[partIdx];
	}

	/**
	 * 将字符串转化成byte[]后截取
	 * 
	 * @param s
	 *            要转化成byte[]后，做截取处理的字符串
	 * @param charset
	 *            指定将s转成byte[]的字符编码，null则不指定
	 * @param byteArrIndexStart
	 *            字节数组截取起始位置
	 * @param len
	 *            字节数组的截取长度
	 * 
	 * @return
	 */
	public static String byteCutStr(String s, Charset charset,
			int byteArrIndexStart, int len) {
		if (s == null) {
			return null;
		}

		byte[] tmp = null;

		if (charset != null) {
			tmp = s.getBytes(charset);
		} else {
			tmp = s.getBytes();
		}

		byte[] ret = new byte[len];

		int tmpLen = tmp.length;
		for (int i = 0; i < len && byteArrIndexStart + i < tmpLen; i++) {
			ret[i] = tmp[byteArrIndexStart + i];
		}

		return new String(ret);
	}

	/**
	 * 将字符串转化成byte[]后截取
	 * 
	 * @param s
	 *            要转化成byte[]后，做截取处理的字符串
	 * @param charset
	 *            指定将s转成byte[]的字符编码，null则不指定
	 * @param byteArrIndexStart
	 *            字节数组截取起始位置
	 * @param byteArrIndexStartEnd
	 *            字节数组的截取结束位置（不含）
	 * 
	 * @return
	 */
	public static String byteCutStrByIdx(String s, Charset charset,
			int byteArrIndexStart, int byteArrIndexStartEnd) {
		if (s == null) {
			return null;
		}

		byte[] tmp = null;

		if (charset != null) {
			tmp = s.getBytes(charset);
		} else {
			tmp = s.getBytes();
		}

		int len = byteArrIndexStartEnd - byteArrIndexStart;
		byte[] ret = new byte[len];

		int tmpLen = tmp.length;
		for (int i = 0; i < len && byteArrIndexStart + i < tmpLen; i++) {
			ret[i] = tmp[byteArrIndexStart + i];
		}

		return new String(ret);
	}

	/**
	 * * 字节数组转字符串
	 * 
	 * @param data
	 * @param start
	 *            byte数组截取起始位
	 * @param len
	 *            截取长度
	 * @param charset
	 *            byte转字符串的编码， null则使用环境默认编码
	 * @param trim
	 *            是否去除字符串两端空格
	 * @param returnNull
	 *            当输入值为null时是否返回null，否则返回空字符串""
	 * @return
	 */
	public static String cutToStr(byte[] data, int start, int len,
			Charset charset, boolean trim, boolean returnNull) {

		if (data == null && returnNull) {
			return null;
		} else if (data == null) {
			return "";
		}

		return toString(byteArrCut(data, start, len), charset, trim);
	}

	/**
	 * * 字节数组转字符串
	 * 
	 * @param data
	 * @param startIdx
	 *            byte数组截取起始位
	 * @param endIdx
	 *            byte数组截取结束位（不含）
	 * @param charset
	 *            byte转字符串的编码， null则使用环境默认编码
	 * @param trim
	 *            是否去除字符串两端空格
	 * @param returnNull
	 *            当输入值为null时是否返回null，否则返回空字符串""
	 * @return
	 */
	public static String cutToStrByIdx(byte[] data, int startIdx, int endIdx,
			Charset charset, boolean trim, boolean returnNull) {

		return cutToStr(data, startIdx, endIdx - startIdx, charset, trim,
				returnNull);
	}

	/**
	 * 字符编码名称转对象
	 * 
	 * @param charset
	 * @param defCharset
	 * @return
	 */
	public static Charset toCharset(String charsetName, String defCharsetName) {
		try {
			return Charset.forName(charsetName);
		} catch (Exception e) {
			logger.warn("String[" + charsetName
					+ "] parse to Charset failed and parse with defaultVal["
					+ defCharsetName + "]", e);

			return Charset.forName(defCharsetName);
		}
	}

	/**
	 * 字符串转long，异常则返回默认值
	 * 
	 * @param numStr
	 * @param defaultVal
	 * @return
	 */
	public static long toLong(String numStr, long defaultVal) {
		try {
			return toLong(numStr);
		} catch (Exception e) {
			logger.warn("String[" + numStr
					+ "] parse to long failed and return defaultVal["
					+ defaultVal + "]", e);

			return defaultVal;
		}
	}

	/**
	 * 字符串转long
	 * 
	 * @param numStr
	 * @return
	 */
	public static long toLong(String numStr) {
		return Long.parseLong(numStr.trim());
	}

	/**
	 * byte[] 转long
	 * 
	 * @param data
	 * @param charset
	 *            null则使用环境默认编码
	 * @return
	 */
	public static long toLong(byte[] data, Charset charset) {
		return toLong(toString(data, charset, false));
	}

	/**
	 * 字符串转int，异常则返回默认值
	 * 
	 * @param numStr
	 * @param defaultVal
	 * @return
	 */
	public static int toInt(String numStr, int defaultVal) {
		try {
			return toInt(numStr);
		} catch (Exception e) {
			logger.warn("String[" + numStr
					+ "] parse to int failed and return defaultVal["
					+ defaultVal + "]", e);
			return defaultVal;
		}
	}

	/**
	 * 字符串转int
	 * 
	 * @param numStr
	 * @return
	 */
	public static int toInt(String numStr) {
		return Integer.parseInt(numStr.trim());
	}

	/**
	 * byte[] 转int
	 * 
	 * @param data
	 * @param charset
	 *            null则使用环境默认编码
	 * @return
	 */
	public static int toInt(byte[] data, Charset charset) {
		return toInt(toString(data, charset, true));
	}

	/**
	 * 字符串转double，异常则返回默认值
	 * 
	 * @param numStr
	 * @param defaultVal
	 * @return
	 */
	public static double toDouble(String numStr, double defaultVal) {
		try {
			return toDouble(numStr);
		} catch (Exception e) {
			logger.warn("String[" + numStr
					+ "] parse to double failed and return defaultVal["
					+ defaultVal + "]", e);
			return defaultVal;
		}
	}

	/**
	 * 字符串转double
	 * 
	 * @param numStr
	 * @return
	 */
	public static double toDouble(String numStr) {
		return Double.parseDouble(numStr.trim());
	}

	/**
	 * byte[] 转double
	 * 
	 * @param data
	 * @param charset
	 *            null则使用环境默认编码
	 * @return
	 */
	public static double toDouble(byte[] data, Charset charset) {
		return toDouble(toString(data, charset, false));
	}

	/**
	 * 字符串转float，异常则返回默认值
	 * 
	 * @param numStr
	 * @param defaultVal
	 * @return
	 */
	public static float toFloat(String numStr, float defaultVal) {
		try {
			return toFloat(numStr);
		} catch (Exception e) {
			logger.warn("String[" + numStr
					+ "] parse to float failed and return defaultVal["
					+ defaultVal + "]", e);
			return defaultVal;
		}
	}

	/**
	 * 字符串转float
	 * 
	 * @param numStr
	 * @return
	 */
	public static float toFloat(String numStr) {
		return Float.parseFloat(numStr.trim());
	}

	/**
	 * byte[] 转float
	 * 
	 * @param data
	 * @param charset
	 *            null则使用环境默认编码
	 * @return
	 */
	public static float toFloat(byte[] data, Charset charset) {
		return toFloat(toString(data, charset, false));
	}

	/**
	 * 使用BigDecimal四舍五入精确小数
	 * 
	 * @param val
	 * @param scale
	 *            保留小数位数
	 * @return
	 */
	public static double exact(double val, int scale) {
		return new BigDecimal(val).setScale(scale, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	/**
	 * 数组截取
	 * 
	 * @param srcArr
	 *            需要截取的数组
	 * @param start
	 *            截取开始位置
	 * @param length
	 *            截取长度
	 * @return 返回截到的新的数组
	 */
	public static T[] arrayCut(T[] srcArr, int start, int length) {
		if (srcArr == null) {
			return null;
		}

		// 获取数组元素类型，非数组返回null
		Class<?> eleClazz = srcArr.getClass().getComponentType();
		// Type type = Type.getType(eleClazz);
		// if (eleClazz == null){
		// throw ExceptionUtil.illegalException("srcArr", "must be an array");}

		T[] destArr = (T[]) Array.newInstance(eleClazz, length);

		System.arraycopy(srcArr, start, destArr, 0, length);

		return destArr;
	}

	/**
	 * 数组复制
	 * 
	 * @param <T>
	 * 
	 * @param srcArr
	 *            源数组
	 * @param srcPos
	 *            复制起始位置
	 * @param destArr
	 *            目的数组
	 * @param destPos
	 *            放置起始位置
	 * @param length
	 *            要复制的长度
	 */
	public static void arrCopy(Object srcArr, int srcPos, Object destArr,
			int destPos, int length) {
		System.arraycopy(srcArr, srcPos, destArr, destPos, length);
	}

	/**
	 * 数组复制
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * 
	 * @param srcArr
	 *            源数组
	 * @param srcPos
	 *            复制起始位置
	 * @param destArr
	 *            目的数组
	 * @param destPos
	 *            放置起始位置
	 */
	public static void arrCopy(T[] srcArr, int srcPos, T[] destArr,
			int destPos) {
		if (srcArr == null || destArr == null) {
			return;
		}

		System.arraycopy(srcArr, srcPos, destArr, destPos, srcArr.length
				- srcPos);
	}

	/**
	 * 数组复制
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * 
	 * @param srcArr
	 *            源数组
	 * @param srcPos
	 *            复制起始位置
	 * @param destArr
	 *            目的数组
	 * @param destPos
	 *            放置起始位置
	 */
	public static void arrCopy(byte[] srcArr, int srcPos, byte[] destArr,
			int destPos) {
		if (srcArr == null || destArr == null) {
			return;
		}

		System.arraycopy(srcArr, srcPos, destArr, destPos, srcArr.length
				- srcPos);
	}

	/**
	 * byte数组截取
	 * 
	 * @param data
	 *            要截取的数组
	 * @param start
	 *            截取开始位置
	 * @param length
	 *            截取长度
	 * @return 截得的byte数组
	 */
	public static byte[] byteArrCut(byte[] data, int start, int length) {

		byte[] ret = new byte[length];
		int index = 0;
		while (index < length) {
			ret[index] = data[start + index++];
		}
		return ret;
	}

	/**
	 * byte数组截取
	 * 
	 * @param data
	 *            要截取的数组
	 * @param start
	 *            截取开始位置（含）
	 * @param end
	 *            截取结束位置（不含）
	 * @return 截得的byte数组
	 */
	public static byte[] byteArrCutByIdx(byte[] data, int start, int end) {

		byte[] ret = new byte[end - start];
		int index = 0;
		while (start < end) {
			ret[index++] = data[start++];
		}
		return ret;
	}

	/**
	 * byte[]数组合并
	 * 
	 * @param byteArr1
	 * @param byteArr2
	 * @return 新数组
	 */
	public static byte[] byteMerger(byte[] byteArr1, byte[] byteArr2) {
		if (byteArr1 == null || byteArr2 == null) {
			return byteArr1 == null ? byteArr2 : byteArr1;
		}

		byte[] byteArr3 = new byte[byteArr1.length + byteArr2.length];
		System.arraycopy(byteArr1, 0, byteArr3, 0, byteArr1.length);
		System.arraycopy(byteArr2, 0, byteArr3, byteArr1.length,
				byteArr2.length);
		return byteArr3;
	}

	/**
	 * 用相同的内容替换数组中的内容
	 * 
	 * @param <T>
	 * @param s
	 * @param start
	 * @param len
	 * @param sameContent
	 * @return
	 */
	@SuppressWarnings("hiding")
	public static <T> T[] replace(T[] s, int start, int len, T sameContent) {
		if (s == null) {
			return null;
		}

		len = start + len;

		for (; start < len; start++) {
			s[start] = sameContent;

		}

		return s;
	}

	/**
	 * unicode的String转换成String的字符串，
	 * 如"\\u0068\\u0065\\u006c\\u006c\\u006f"转换成"hello"
	 * 
	 * @param unicodeStr
	 *            16进制值字符串 （一个unicode为2byte）
	 * @return String 全角字符串
	 */
	public static String fromUnicode(String unicodeStr) {
		int len = unicodeStr.length() / 6;
		int tmp = 0;

		StringBuilder sbd = new StringBuilder();
		for (int i = 0; i < len; i++) {
			String s = unicodeStr.substring(i * 6, (i + 1) * 6);

			// 将16进制的string转为int
			tmp = (Integer.valueOf(s.substring(2, 4), 16) << 8)
					| Integer.valueOf(s.substring(4), 16);

			// 将int转换为字符
			sbd.append(new String(Character.toChars(tmp)));
		}

		return sbd.toString();
	}

	/**
	 * String的字符串转换成unicode的String
	 * 
	 * @param str
	 *            String 全角字符串
	 * @return String 每个unicode之间无分隔符
	 * @throws Exception
	 */
	public static String toUnicode(String str) {
		if (str == null) {
			return null;
		}

		StringBuilder sbd = new StringBuilder();

		char c;
		int intOfChar;// char对应的int值
		String hexStr;

		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			intOfChar = (int) c;
			hexStr = Integer.toHexString(intOfChar);

			if (intOfChar > 128) {
				sbd.append("\\u");
			} else {
				sbd.append("\\u00");// 低位在前面补00
			}
			sbd.append(hexStr);
		}

		return sbd.toString();
	}

	/**
	 * 将字符串格式化成符合byte[]长度的字符串，多则去掉，少则空(byte0)
	 * 
	 * @param obj
	 * @param charset
	 *            null则使用环境默认编码
	 * @param byteLen
	 * @param returnNull
	 *            当输入值str为null时是否返回null,否则返回空字符串"";
	 * @param throwMismatch
	 *            当str因格式化长度过短而被截取时，是否抛出byteLen mismatchException
	 * @return
	 */
	/**
	 * 将字符串格式化成符合byte[]长度的字符串，多则去掉，少则空(byte0)
	 * 
	 * @param str
	 * @param charset
	 *            null则使用环境默认编码
	 * @param byteLen
	 * @param returnNull
	 *            当输入值str为null时是否返回null,否则返回空字符串"";
	 * @param throwMismatch
	 *            当str因格式化长度过短而被截取时，是否抛出byteLen mismatchException
	 * @return
	 */
	public static String fitByteLen(Object obj, Charset charset, int byteLen,
			boolean returnNull, boolean throwMismatch) throws MismatchException {
		String str;
		if (obj == null && returnNull) {
			return null;
		} else if (obj == null) {
			str = "";
		} else {
			str = String.valueOf(obj);
		}

		byte[] src;
		byte[] dest = new byte[byteLen];

		if (charset == null) {
			src = str.getBytes();
		} else {
			src = str.getBytes(charset);
		}

		int index = 0;
		boolean srcHasMore;// 是否还有数据剩余
		boolean destHasMore;// 是否有空间多余

		while (true) {

			srcHasMore = index < src.length;
			destHasMore = index < byteLen;// dest.length

			if (srcHasMore && destHasMore) {
				dest[index] = src[index++];
			} else if (destHasMore) {
				dest[index++] = BLANK_BYTE_VAL;
			} else {
				break;
			}
		}

		String out;

		if (charset == null) {
			out = new String(dest);
		} else {
			out = new String(dest, charset);
		}

		if (throwMismatch && srcHasMore) {
			throw new MismatchException("byteLen[" + byteLen
					+ "] is too short, input string[" + str
					+ "] has been cut to[" + out + "] with charset["
					+ charset.name() + "]");
		} else {
			if (srcHasMore) {
				logger.warn("input string[" + str + "] has been cut to[" + out
						+ "] by byteLen[" + byteLen + "] and charset["
						+ charset.name() + "]");
			}
			return out;
		}
	}

	public static final int FIX_CASE_FISRT_UPPER = 1;
	public static final int FIX_CASE_FISRT_LOWER = 2;
	public static final int FIX_CASE_ALL_UPPER = 3;
	public static final int FIX_CASE_ALL_LOWER = 4;

	/**
	 * 字符串大小写修整
	 * 
	 * @param s
	 * @param fixType
	 * @return
	 */
	public static String fixCase(String s, int fixType) {
		if (s == null) {
			return null;
		}

		switch (fixType) {
		case FIX_CASE_FISRT_UPPER:
			return s.substring(0, 1).toUpperCase() + s.substring(1);

		case FIX_CASE_FISRT_LOWER:
			return s.substring(0, 1).toLowerCase() + s.substring(1);

		case FIX_CASE_ALL_UPPER:
			return s.toUpperCase();

		case FIX_CASE_ALL_LOWER:
			return s.toLowerCase();

		default:
			throw new IllegalException("fixType", fixType,
					"the value of fixType must be 1-4 (ZUtil.FIX_CASE_*)");
		}

	}

	/**
	 * 判断字符串是否没有东西
	 * 
	 * @param str
	 * @return str为null、"null"(忽略大小写)、""、" "(trim=true时)等空白字符串均返回true
	 */
	public static boolean isNothing(String str) {

		if (str == null) {
			return true;
		}

		str = str.trim();

		if (str.isEmpty() || "null".equalsIgnoreCase(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串是否没有东西
	 * 
	 * @param str
	 * @param trim
	 *            是否去除两端空格
	 * @return str为null、"null"(忽略大小写)、""、" "(trim=true时)等空白字符串均返回true
	 */
	public static boolean isNothing(String str, boolean trim) {

		if (str == null) {
			return true;
		}

		if (trim) {
			str = str.trim();
		}

		if (str.isEmpty() || "null".equalsIgnoreCase(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串（有trim）是否为空
	 * 
	 * @param str
	 * @return str为null、""、" "等空白字符串均返回true
	 */
	public static boolean isEmpty(Object str) {

		if (str == null || str.toString().trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @param trim
	 *            是否去除两端空格
	 * @return str为null、""、" "(trim=true时)等空白字符串均返回true
	 */
	public static boolean isEmpty(Object str, boolean trim) {

		if (str == null) {
			return true;
		}

		if ((trim && str.toString().trim().isEmpty())
				|| str.toString().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否为NUll或者忽略大小写的NUll字符串
	 * 
	 * @param str
	 * @return str为null,"null"(忽略大小写)、" null  "均返回true
	 */
	public static boolean isNull(String str) {

		if (str == null || "null".equalsIgnoreCase(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否为NUll或者忽略大小写的NUll字符串
	 * 
	 * @param str
	 * @param trim
	 *            是否去除两端空格
	 * @return str为null,"null"(忽略大小写)、" null  "(忽略大小写，trim=true时)均返回true
	 */
	public static boolean isNull(String str, boolean trim) {

		if (str == null) {
			return true;
		}

		if (trim) {
			str = str.trim();
		}

		if ("null".equalsIgnoreCase(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断输入的Object[]内容是否存在null
	 * 
	 * @param eles
	 * @return Object[]长度为零，或其中的元素均不为null则返回false，否则返回true
	 */
	public static boolean hasNull(Object... eles) {
		if (eles == null) {
			return true;
		}

		for (Object ele : eles) {
			if (ele == null) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 判断输入的Object[]内容是否存在null,"", ""
	 * 
	 * @param eles
	 * @return
	 */
	public static boolean hasEmpty(Object... eles) {
		if (eles == null) {
			return true;
		}

		for (Object ele : eles) {
			if (isEmpty(ele)) {
				return true;
			}
		}

		return false;
	}

	
	/**
	 * 获取空值对应的参数名
	 * 
	 * @param valAndName
	 *            输入格式：参数1值,参数1名,参数2值,参数2名,...
	 * @return
	 */
	public static String getNullName(Object... valAndName) {
		if (valAndName == null) {
			return null;
		}

		if (valAndName.length % 2 != 0) {
			throw new IllegalArgumentException(
					"input format should be like this: val1,valName1,val2,valName2,...");
		}
		String nullValName = "";
		boolean isFirst = true;
		for (int i = 0; i < valAndName.length; i += 2) {

			if (valAndName[i] == null) {
				if (!isFirst) {
					nullValName += ", ";
				}
				isFirst = false;
				nullValName += valAndName[i + 1];
			}
		}

		return nullValName;
	}
	
	/**
	 * 去除null和"null"字符串
	 * 
	 * @param str
	 * @param replaceNullVal
	 *            替代null的字符，null则用空字符串""替代
	 * @param trimNullString
	 *            是否去除忽略大小写的“null”字符串
	 * @return
	 */
	public static String trimNull(String str, String replaceNullVal,
			boolean trimNullString) {

		if (str == null || (trimNullString && isNull(str, true))) {
			return replaceNullVal == null ? "" : replaceNullVal;
		} else {
			return str;
		}
	}

	/**
	 * 去除字符串两端的空格
	 * 
	 * @param str
	 * @return 输入值为null则返回null
	 */
	public static String trim(String str) {
		return str == null ? null : str.trim();
	}

	/**
	 * 判断字符串长度是否符合要求
	 * 
	 * @param str
	 *            null长度算0
	 * @param minLen
	 *            最小长度，负值表示不设限制
	 * @param maxLen
	 *            最大长度，负值表示不设限制
	 * @param nullAsZero
	 *            是否把str=null,长度当0对待，否则当str=null时抛出null异常
	 * @return 长度符合返回0，过短返回负值，过长返回正值
	 */
	public static int isLenFit(String str, int minLen, int maxLen,
			boolean nullAsZero) {

		if (minLen < -1 || maxLen < -1
				|| ((minLen > -1 && maxLen > -1) && minLen > maxLen)) {
			throw new IllegalException(
					"minLen or maxLen",
					"minLen=" + minLen + ", maxLen=" + maxLen,
					"the value of minLen and maxLen must >= -1, and minLen < maxLen if none of them is -1");
		}

		int strLen = 0;

		if (nullAsZero) {
			strLen = str == null ? 0 : str.length();
		} else {
			throw new NullException("str", "");
		}

		if (minLen >= 0 && strLen < minLen) {
			return strLen - minLen;
		}

		if (maxLen >= 0 && strLen > maxLen) {
			return strLen - maxLen;
		}

		return 0;

	}

	/**
	 * 拼接参数名值对。 如,keyValConnector="=",paramDivider="&"则name=zhang&age=20
	 * 
	 * @param paramMap
	 * @param keyValConnector
	 *            键值连接符
	 * @param paramDivider
	 *            参数分隔符
	 * @param charset
	 *            null则不编码
	 * @return never return null
	 * @throws IOException
	 */
	public static String toString(Map<String, String> map,
			String keyValConnector, String divider, String charset) {

		if (map == null || map.size() == 0) {
			return "";
		}

		if (keyValConnector == null) {
			keyValConnector = "";
		}

		StringBuilder sbd = new StringBuilder();

		// 推荐，尤其是容量大时
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sbd.append(urlEncode(entry.getKey(), charset));
			sbd.append(keyValConnector);
			sbd.append(urlEncode(entry.getValue(), charset));

			sbd.append(divider);
		}

		// jdk低版本通用
		// Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		// while (it.hasNext()) {
		// Map.Entry<String, String> entry = it.next();
		//
		// sbd.append(urlEncode(entry.getKey(), charset));
		// sbd.append(keyValConnector);
		// sbd.append(urlEncode(entry.getValue(), charset));
		//
		// sbd.append(divider);
		// }

		sbd.deleteCharAt(sbd.length() - 1);

		return sbd.toString();
	}

	/**
	 * 根据key中含有的字符筛选键值
	 * 
	 * @param <T>
	 * @param map
	 * @param keyFlag
	 * @return 筛选得到的Map
	 */
	public static Map<String, T> screenByKey(Map<String, T> map,
			String keyFlag) {

		if (map == null) {
			return null;
		}

		if (keyFlag == null) {
			return map;
		}

		Map<String, T> scMap = new HashMap<String, T>();

		// 推荐，尤其是容量大时
		for (Entry<String, T> entry : map.entrySet()) {
			if (entry.getKey() == null) {
				scMap.put(null, entry.getValue());
			} else if (entry.getKey().contains(keyFlag)) {
				scMap.put(entry.getKey(), entry.getValue());
			}
		}

		return scMap;
	}

	/**
	 * 对字符串内容进行URL编码 Translates a string into application/x-www-form-urlencoded
	 * format using a specific encoding scheme. This method uses the supplied
	 * encoding scheme to obtain the bytes for unsafe characters.
	 * 
	 * @param content
	 * @param charset
	 *            如果编码为空则不对content进行任何处理
	 * @return
	 */
	public static String urlEncode(String content, String charset) {
		if (content == null || isEmpty(charset)){
			return content;
		};

		try {
			return URLEncoder.encode(content, charset);
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedException("charset", charset, null);
		}
	}

	/**
	 * 对字符串内容进行URL解码 Decodes a application/x-www-form-urlencoded string using a
	 * specific encoding scheme.
	 * 
	 * @param content
	 * @param charset
	 *            如果编码为空则不对content进行任何处理
	 * @return
	 */
	public static String urlDecode(String content, String charset) {
		if (content == null || isEmpty(charset)) {
			return content;
		}

		try {
			return URLDecoder.decode(content, charset);
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedException("charset", charset, null);
		}
	}

	/**
	 * 字符串编码
	 * 
	 * @param content
	 * @param srCharset
	 *            字符串当前的编码，null则使用环境默认编码
	 * @param destCharset
	 *            字符串要转换的编码，null则使用环境默认编码
	 * @return
	 */
	public static String reEncode(String content, String srCharset,
			String destCharset) {

		if (content == null) {
			return null;
		}

		byte[] tmp;

		try {
			if (srCharset == null) {
				tmp = content.getBytes();
			} else {
				tmp = content.getBytes(srCharset);
			}

			if (destCharset == null) {
				return new String(tmp);
			} else {
				return new String(tmp, destCharset);
			}
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedException("srCharset or distCharset",
					"srCharset=" + srCharset + ", distCharset=" + destCharset,
					null);
		}

	}

	/**
	 * 比较两个数值字符串的double值是否相等
	 * 
	 * @return 输入值有null或者两个数值字符串的double值不相等返回false,否则返回true
	 */
	public static boolean isDoubleEqual(String num1, String num2) {
		if (num1 == null || num1 == null
				|| DataUtil.toDouble(num1) != DataUtil.toDouble(num2)) {
			return false;
		}

		return true;
	}

	/**
	 * 数值字符串相加
	 * 
	 * @param sNum1
	 * @param sNum2
	 * @return
	 */
	public static BigDecimal add(String sNum1, String sNum2) {
		BigDecimal b1 = new BigDecimal(sNum1);
		BigDecimal b2 = new BigDecimal(sNum2);

		return b1.add(b2);
	}

	/**
	 * 数值字符串相减
	 * 
	 * @param minuend
	 *            被减数
	 * @param subtrahend
	 *            减数
	 * @return
	 */
	public static BigDecimal subtract(String minuend, String subtrahend) {
		BigDecimal b1 = new BigDecimal(minuend);
		BigDecimal b2 = new BigDecimal(subtrahend);

		return b1.subtract(b2);
	}

	/**
	 * 数值字符串相乘
	 * 
	 * @param sNum1
	 * @param sNum2
	 * @return
	 */
	public static BigDecimal multiply(String sNum1, String sNum2) {
		BigDecimal b1 = new BigDecimal(sNum1);
		BigDecimal b2 = new BigDecimal(sNum2);

		return b1.multiply(b2);
	}

	/**
	 * 数值字符串相除
	 * 
	 * @param dividend
	 *            被除数
	 * @param divisor
	 *            除数
	 * @param scale
	 *            精确度，负值使用默认
	 * @param roundingMode
	 *            四舍五入模式RoundingMode.*，null使用默认
	 * @return
	 */
	public static BigDecimal divide(String dividend, String divisor, int scale,
			RoundingMode roundingMode) {

		BigDecimal b1 = new BigDecimal(dividend);
		BigDecimal b2 = new BigDecimal(divisor);

		if (scale >= 0 && roundingMode != null) {
			return b1.divide(b2, scale, roundingMode);
		} else if (scale < 0 && roundingMode != null) {
			return b1.divide(b2, roundingMode);
		} else if (scale >= 0 && roundingMode == null) {
			return b1.divide(b2, scale);
		} else {
			return b1.divide(b2);
		}
	}


	/**
	 * 获取UUID
	 * 
	 * @param dropConnector
	 *            是否去掉连接符"-"
	 * @return
	 */
	public static String makeUUID(boolean dropConnector) {

		String uuid = UUID.randomUUID().toString();
		if (dropConnector) {
			return uuid.replaceAll("-", "");
		}

		return uuid.replaceAll("-", "");
	}

	/**
	 * 将字符串中的"\","\\","\\\","//","///"替换为"/"或"\"
	 * 
	 * @param pathStr
	 * @param forWin
	 *            true 替换为"\"
	 * @return
	 */
	public static String fixPath(String pathStr, boolean forWin) {
		if (pathStr == null) {
			return null;
		}

		if (forWin) {
			return pathStr.replaceAll("\\\\\\\\|\\\\|///|//|/", "\\\\");
		} else {
			return pathStr.replaceAll("\\\\\\\\|\\\\|///|//|/", "/");
		}
	}
}

/*
 * java的String字符信息是用UNICODE编码存放的。
 * 而JAVA为了表示字符（注意是单个字符），也有char这个数据类型，大小是固定2个8位16进制数字长度，也就是0~65535
 * str.getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) new
 * String(...,"ISO-8859-1")建立字符串，即强行把BYTE数组复制到String的char[]里
 * 如果真的想自由编码，用byte[]或者char[]就完全解决问题了。
 * 
 * //要发送的数据本身就是byte[]类型的。 如果将其通过UTF-8编码转换为中间件String类型就会出现问题
 * //需要采用单字节的编码（"ISO-8859-1"）方式进行转换 byte[] bytes = new byte[] { 50, 0, -1, 28,
 * -24 }; String sendString=new String( bytes ,"UTF-8");//改用"ISO-8859-1" byte[]
 * sendBytes= sendString .getBytes("UTF8");
 * 
 * String recString=new String( sendBytes ,"UTF-8");
 * System.out.println(sendString); System.out.println(recString); for(byte bt:
 * recString.getBytes("UTF8"))//改用"ISO-8859-1" System.out.println(bt);
 * 
 * 对象和数组的创建方法 Array.newInstance(Class<?>, len); Class<?>.newInstance()
 * 
 * Class<?> c1 =
 * class<?>.getComponentType();//如果class对象是一个数组，则返回这个数组元素的class对象，否则返回null
 * Class<?> c2 = xxx.class; Class<?> c3 = 对象.getClass();
 */
