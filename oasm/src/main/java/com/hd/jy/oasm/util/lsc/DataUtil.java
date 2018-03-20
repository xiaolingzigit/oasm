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
 * �ַ�������,�磺�ַ���ת������ֵ���ͣ�16����ֵ��String/Byte֮���ת����
 * 
 * @author ander
 * 
 */
public class DataUtil  {

	private static Logger logger = Logger.getLogger(DataUtil.class);

	/** ʮ�������ַ��� Сд��ĸ �������� */
	public final static char[] HEX_CHARS_L = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/** ʮ�������ַ��� ��д��ĸ �������� */
	public final static char[] HEX_CHARS_U = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/** ʮ�������ַ��� Сд��ĸ �����ַ��� */
	public final static String HEX_CHAR_STRING_L = "0123456789abcdef";

	/** ʮ�������ַ��� ��д��ĸ �����ַ��� */
	public final static String HEX_CHAR_STRING_U = "0123456789ABCDEF";
	/** �ַ����ո��byteֵ */
	public static final int BLANK_BYTE_VAL = 32;

	/**
	 * ʮ�������ַ�ת����
	 * 
	 * @param c
	 * @return
	 */
	public static int hexChartoInt(char c) {
		return HEX_CHAR_STRING_L.indexOf((c + "").toLowerCase());
	}

	/**
	 * ��ȡʮ�����Ʊ�ʾ�ַ���Ӧ��byteֵ��a��A����ʾ10
	 * 
	 * @param c
	 * @return
	 */
	public static byte hexCharToByte(char c) {
		return (byte) hexChartoInt(c);
	}

	/**
	 * ����ʾ16����ֵ���ַ���ת��Ϊbyte����
	 * 
	 * @param hexString
	 *            ��Ҫת����ʮ�������ַ���
	 * @return
	 */
	public static byte[] hexStr2Bytes(String hexString) {
		if (hexString == null) {
			return null;
		}

		if (hexString.isEmpty()) {
			return new byte[0];
		}

		// ����һ��
		// byte[] tmp = hexString.getBytes();
		// int tlen = tmp.length;
		//
		// // �����ַ���ʾһ���ֽڣ������ֽ����鳤�����ַ������ȳ���2
		// byte[] bytes = new byte[tlen / 2];
		//
		// for (int i = 0; i < tlen; i += 2) {
		// String strTmp = new String(tmp, i, 2);
		// bytes[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		// }
		// return bytes;

		// ��������
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
	 * ���ֽ�����ת����ʮ�������ַ���
	 * 
	 * @param bytes
	 *            Ҫת����byte����
	 * @return ʮ�������ַ�����bytes=null����null,bytes.length=0����""
	 */
	public static String toHexString(byte[] bytes) {

		if (bytes == null) {
			return null;
		} else if (bytes.length == 0) {
			return "";
		}

		int len = bytes.length;
		// ÿ��byte�������ַ����ܱ�ʾ�������ַ����ĳ�����byte���鳤�ȵ�����
		StringBuilder sbd = new StringBuilder(len * 2);

		for (int i = 0; i < len; i++) {
			// ����һ��
			// byte�Ĵ�СΪ8bits��int�Ĵ�СΪ32bits,java�Ķ����Ʋ��õ��ǲ�����ʽ
			// intֵ��0xff�����ʹ��24bite��0
			String hexVal = Integer.toHexString(bytes[i] & 0xff);// 0xFF

			if (hexVal.length() == 1) {
				sbd.append(0);// ��4λ��0
			}
			sbd.append(hexVal);

			// ��������

			// int intTmp = bytes[i];
			//
			// if (intTmp < 0)
			// intTmp += 256;// ��byte����ת��Ϊ����
			//
			// // С��0f����(f)��Ҫ��ǰ�油0
			// if (intTmp < 16) {
			// sbd.append(0);
			// }
			// sbd.append(Integer.toString(intTmp, 16));

		}

		return sbd.toString();
	}

	/**
	 * * �ֽ�����ת�ַ���
	 * 
	 * @param data
	 * @param charset
	 *            null��ʹ�û���Ĭ�ϱ���
	 * @param trim
	 *            �Ƿ�ȥ�����˿ո�
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
	 * String����ƴ�ӳ��ַ�������toString(strArr, ",",true)==>[ ele1,ele2]
	 * 
	 * @param strArr
	 * @param separator
	 *            Ԫ�طָ���������","��" "�������ַ���null��""��û�зָ���
	 * @param addBorder
	 *            �Ƿ���ӱ߽��־��"[]"��null�����
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
	 * ����ת�ַ�����toString(strArr)==>[ ele1,ele2]
	 * 
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("hiding")
	public static <T> String toString(T[] arr) {
		return toString(arr, ", ", true);
	}

	/**
	 * * ����תlist
	 * 
	 * @param <T>
	 * 
	 * @param list
	 *            ��Ҫת����list
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
	 * ��mapԪ��ת��Ϊkey~val��String[]����
	 * @param map
	 * @param keyValJointMark ��ֵ�����ӷ�
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
	 * * ����תlist
	 * 
	 * @param <T>
	 * 
	 * @param srcArr
	 *            ��Ҫת��������
	 * @param list
	 *            Ŀ��list��null�򷵻�ArrayList
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
	 * ���ַ���ת��ΪString[]
	 * 
	 * @param str
	 *            null�򷵻�null
	 * @param splitRegex
	 *            ����null
	 * @param invalStrRegex
	 *            ȥ�������ַ���������ʽ
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
	 * ��String[]�е�Ԫ��ȥ�����˿ո����Ԫ����null����ȻΪnull
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
	 * ȥ���ַ����еĿո�
	 * 
	 * @param s
	 * @param returnNull
	 *            ��sΪnullʱ�Ƿ񷵻�null���򷵻ؿ��ַ���
	 * @return
	 */
	public static String trimBlank(String s, boolean returnNull) {
		if (s == null) {
			return returnNull ? null : "";
		}

		return s.replaceAll(" ", "");
	}

	/**
	 * ȥ���ַ����еĿո�
	 * 
	 * @param s
	 * @return ��sΪnullʱ�Ƿ񷵻�null
	 */
	public static String trimBlank(String s) {
		return s == null ? null : s.replaceAll("( )+", "");
	}
	
	/**
	 * �ַ��滻
	 * @param s null��ֱ�ӷ���null
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public static String replaceAll(String s,String regex,String replacement) {
		return s == null ? null : s.replaceAll(regex, replacement);
	}

	/**
	 * �ַ�����ȡ
	 * 
	 * @param content
	 * @param startFlag
	 *            null�򲻺����0��ʼ
	 * @param endFlag
	 *            null�򲻺����ȡ��ĩβ
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
	 * �ַ�����ȡ
	 * 
	 * @param content
	 * @param startFlag
	 *            null�򲻺����0��ʼ
	 * @param endFlag
	 *            null�򲻺����ȡ��ĩβ
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
	 * ���ַ���ת����byte[]���ȡ
	 * 
	 * @param s
	 *            Ҫת����byte[]������ȡ������ַ���
	 * @param charset
	 *            ָ����sת��byte[]���ַ����룬null��ָ��
	 * @param byteArrIndexStart
	 *            �ֽ������ȡ��ʼλ��
	 * @param len
	 *            �ֽ�����Ľ�ȡ����
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
	 * ���ַ���ת����byte[]���ȡ
	 * 
	 * @param s
	 *            Ҫת����byte[]������ȡ������ַ���
	 * @param charset
	 *            ָ����sת��byte[]���ַ����룬null��ָ��
	 * @param byteArrIndexStart
	 *            �ֽ������ȡ��ʼλ��
	 * @param byteArrIndexStartEnd
	 *            �ֽ�����Ľ�ȡ����λ�ã�������
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
	 * * �ֽ�����ת�ַ���
	 * 
	 * @param data
	 * @param start
	 *            byte�����ȡ��ʼλ
	 * @param len
	 *            ��ȡ����
	 * @param charset
	 *            byteת�ַ����ı��룬 null��ʹ�û���Ĭ�ϱ���
	 * @param trim
	 *            �Ƿ�ȥ���ַ������˿ո�
	 * @param returnNull
	 *            ������ֵΪnullʱ�Ƿ񷵻�null�����򷵻ؿ��ַ���""
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
	 * * �ֽ�����ת�ַ���
	 * 
	 * @param data
	 * @param startIdx
	 *            byte�����ȡ��ʼλ
	 * @param endIdx
	 *            byte�����ȡ����λ��������
	 * @param charset
	 *            byteת�ַ����ı��룬 null��ʹ�û���Ĭ�ϱ���
	 * @param trim
	 *            �Ƿ�ȥ���ַ������˿ո�
	 * @param returnNull
	 *            ������ֵΪnullʱ�Ƿ񷵻�null�����򷵻ؿ��ַ���""
	 * @return
	 */
	public static String cutToStrByIdx(byte[] data, int startIdx, int endIdx,
			Charset charset, boolean trim, boolean returnNull) {

		return cutToStr(data, startIdx, endIdx - startIdx, charset, trim,
				returnNull);
	}

	/**
	 * �ַ���������ת����
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
	 * �ַ���תlong���쳣�򷵻�Ĭ��ֵ
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
	 * �ַ���תlong
	 * 
	 * @param numStr
	 * @return
	 */
	public static long toLong(String numStr) {
		return Long.parseLong(numStr.trim());
	}

	/**
	 * byte[] תlong
	 * 
	 * @param data
	 * @param charset
	 *            null��ʹ�û���Ĭ�ϱ���
	 * @return
	 */
	public static long toLong(byte[] data, Charset charset) {
		return toLong(toString(data, charset, false));
	}

	/**
	 * �ַ���תint���쳣�򷵻�Ĭ��ֵ
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
	 * �ַ���תint
	 * 
	 * @param numStr
	 * @return
	 */
	public static int toInt(String numStr) {
		return Integer.parseInt(numStr.trim());
	}

	/**
	 * byte[] תint
	 * 
	 * @param data
	 * @param charset
	 *            null��ʹ�û���Ĭ�ϱ���
	 * @return
	 */
	public static int toInt(byte[] data, Charset charset) {
		return toInt(toString(data, charset, true));
	}

	/**
	 * �ַ���תdouble���쳣�򷵻�Ĭ��ֵ
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
	 * �ַ���תdouble
	 * 
	 * @param numStr
	 * @return
	 */
	public static double toDouble(String numStr) {
		return Double.parseDouble(numStr.trim());
	}

	/**
	 * byte[] תdouble
	 * 
	 * @param data
	 * @param charset
	 *            null��ʹ�û���Ĭ�ϱ���
	 * @return
	 */
	public static double toDouble(byte[] data, Charset charset) {
		return toDouble(toString(data, charset, false));
	}

	/**
	 * �ַ���תfloat���쳣�򷵻�Ĭ��ֵ
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
	 * �ַ���תfloat
	 * 
	 * @param numStr
	 * @return
	 */
	public static float toFloat(String numStr) {
		return Float.parseFloat(numStr.trim());
	}

	/**
	 * byte[] תfloat
	 * 
	 * @param data
	 * @param charset
	 *            null��ʹ�û���Ĭ�ϱ���
	 * @return
	 */
	public static float toFloat(byte[] data, Charset charset) {
		return toFloat(toString(data, charset, false));
	}

	/**
	 * ʹ��BigDecimal�������뾫ȷС��
	 * 
	 * @param val
	 * @param scale
	 *            ����С��λ��
	 * @return
	 */
	public static double exact(double val, int scale) {
		return new BigDecimal(val).setScale(scale, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	/**
	 * �����ȡ
	 * 
	 * @param srcArr
	 *            ��Ҫ��ȡ������
	 * @param start
	 *            ��ȡ��ʼλ��
	 * @param length
	 *            ��ȡ����
	 * @return ���ؽص����µ�����
	 */
	public static T[] arrayCut(T[] srcArr, int start, int length) {
		if (srcArr == null) {
			return null;
		}

		// ��ȡ����Ԫ�����ͣ������鷵��null
		Class<?> eleClazz = srcArr.getClass().getComponentType();
		// Type type = Type.getType(eleClazz);
		// if (eleClazz == null){
		// throw ExceptionUtil.illegalException("srcArr", "must be an array");}

		T[] destArr = (T[]) Array.newInstance(eleClazz, length);

		System.arraycopy(srcArr, start, destArr, 0, length);

		return destArr;
	}

	/**
	 * ���鸴��
	 * 
	 * @param <T>
	 * 
	 * @param srcArr
	 *            Դ����
	 * @param srcPos
	 *            ������ʼλ��
	 * @param destArr
	 *            Ŀ������
	 * @param destPos
	 *            ������ʼλ��
	 * @param length
	 *            Ҫ���Ƶĳ���
	 */
	public static void arrCopy(Object srcArr, int srcPos, Object destArr,
			int destPos, int length) {
		System.arraycopy(srcArr, srcPos, destArr, destPos, length);
	}

	/**
	 * ���鸴��
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * 
	 * @param srcArr
	 *            Դ����
	 * @param srcPos
	 *            ������ʼλ��
	 * @param destArr
	 *            Ŀ������
	 * @param destPos
	 *            ������ʼλ��
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
	 * ���鸴��
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * 
	 * @param srcArr
	 *            Դ����
	 * @param srcPos
	 *            ������ʼλ��
	 * @param destArr
	 *            Ŀ������
	 * @param destPos
	 *            ������ʼλ��
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
	 * byte�����ȡ
	 * 
	 * @param data
	 *            Ҫ��ȡ������
	 * @param start
	 *            ��ȡ��ʼλ��
	 * @param length
	 *            ��ȡ����
	 * @return �صõ�byte����
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
	 * byte�����ȡ
	 * 
	 * @param data
	 *            Ҫ��ȡ������
	 * @param start
	 *            ��ȡ��ʼλ�ã�����
	 * @param end
	 *            ��ȡ����λ�ã�������
	 * @return �صõ�byte����
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
	 * byte[]����ϲ�
	 * 
	 * @param byteArr1
	 * @param byteArr2
	 * @return ������
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
	 * ����ͬ�������滻�����е�����
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
	 * unicode��Stringת����String���ַ�����
	 * ��"\\u0068\\u0065\\u006c\\u006c\\u006f"ת����"hello"
	 * 
	 * @param unicodeStr
	 *            16����ֵ�ַ��� ��һ��unicodeΪ2byte��
	 * @return String ȫ���ַ���
	 */
	public static String fromUnicode(String unicodeStr) {
		int len = unicodeStr.length() / 6;
		int tmp = 0;

		StringBuilder sbd = new StringBuilder();
		for (int i = 0; i < len; i++) {
			String s = unicodeStr.substring(i * 6, (i + 1) * 6);

			// ��16���Ƶ�stringתΪint
			tmp = (Integer.valueOf(s.substring(2, 4), 16) << 8)
					| Integer.valueOf(s.substring(4), 16);

			// ��intת��Ϊ�ַ�
			sbd.append(new String(Character.toChars(tmp)));
		}

		return sbd.toString();
	}

	/**
	 * String���ַ���ת����unicode��String
	 * 
	 * @param str
	 *            String ȫ���ַ���
	 * @return String ÿ��unicode֮���޷ָ���
	 * @throws Exception
	 */
	public static String toUnicode(String str) {
		if (str == null) {
			return null;
		}

		StringBuilder sbd = new StringBuilder();

		char c;
		int intOfChar;// char��Ӧ��intֵ
		String hexStr;

		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			intOfChar = (int) c;
			hexStr = Integer.toHexString(intOfChar);

			if (intOfChar > 128) {
				sbd.append("\\u");
			} else {
				sbd.append("\\u00");// ��λ��ǰ�油00
			}
			sbd.append(hexStr);
		}

		return sbd.toString();
	}

	/**
	 * ���ַ�����ʽ���ɷ���byte[]���ȵ��ַ���������ȥ���������(byte0)
	 * 
	 * @param obj
	 * @param charset
	 *            null��ʹ�û���Ĭ�ϱ���
	 * @param byteLen
	 * @param returnNull
	 *            ������ֵstrΪnullʱ�Ƿ񷵻�null,���򷵻ؿ��ַ���"";
	 * @param throwMismatch
	 *            ��str���ʽ�����ȹ��̶�����ȡʱ���Ƿ��׳�byteLen mismatchException
	 * @return
	 */
	/**
	 * ���ַ�����ʽ���ɷ���byte[]���ȵ��ַ���������ȥ���������(byte0)
	 * 
	 * @param str
	 * @param charset
	 *            null��ʹ�û���Ĭ�ϱ���
	 * @param byteLen
	 * @param returnNull
	 *            ������ֵstrΪnullʱ�Ƿ񷵻�null,���򷵻ؿ��ַ���"";
	 * @param throwMismatch
	 *            ��str���ʽ�����ȹ��̶�����ȡʱ���Ƿ��׳�byteLen mismatchException
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
		boolean srcHasMore;// �Ƿ�������ʣ��
		boolean destHasMore;// �Ƿ��пռ����

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
	 * �ַ�����Сд����
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
	 * �ж��ַ����Ƿ�û�ж���
	 * 
	 * @param str
	 * @return strΪnull��"null"(���Դ�Сд)��""��" "(trim=trueʱ)�ȿհ��ַ���������true
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
	 * �ж��ַ����Ƿ�û�ж���
	 * 
	 * @param str
	 * @param trim
	 *            �Ƿ�ȥ�����˿ո�
	 * @return strΪnull��"null"(���Դ�Сд)��""��" "(trim=trueʱ)�ȿհ��ַ���������true
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
	 * �ж��ַ�������trim���Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return strΪnull��""��" "�ȿհ��ַ���������true
	 */
	public static boolean isEmpty(Object str) {

		if (str == null || str.toString().trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 * @param trim
	 *            �Ƿ�ȥ�����˿ո�
	 * @return strΪnull��""��" "(trim=trueʱ)�ȿհ��ַ���������true
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
	 * �ж��Ƿ�ΪNUll���ߺ��Դ�Сд��NUll�ַ���
	 * 
	 * @param str
	 * @return strΪnull,"null"(���Դ�Сд)��" null  "������true
	 */
	public static boolean isNull(String str) {

		if (str == null || "null".equalsIgnoreCase(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �ж��Ƿ�ΪNUll���ߺ��Դ�Сд��NUll�ַ���
	 * 
	 * @param str
	 * @param trim
	 *            �Ƿ�ȥ�����˿ո�
	 * @return strΪnull,"null"(���Դ�Сд)��" null  "(���Դ�Сд��trim=trueʱ)������true
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
	 * �ж������Object[]�����Ƿ����null
	 * 
	 * @param eles
	 * @return Object[]����Ϊ�㣬�����е�Ԫ�ؾ���Ϊnull�򷵻�false�����򷵻�true
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
	 * �ж������Object[]�����Ƿ����null,"", ""
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
	 * ��ȡ��ֵ��Ӧ�Ĳ�����
	 * 
	 * @param valAndName
	 *            �����ʽ������1ֵ,����1��,����2ֵ,����2��,...
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
	 * ȥ��null��"null"�ַ���
	 * 
	 * @param str
	 * @param replaceNullVal
	 *            ���null���ַ���null���ÿ��ַ���""���
	 * @param trimNullString
	 *            �Ƿ�ȥ�����Դ�Сд�ġ�null���ַ���
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
	 * ȥ���ַ������˵Ŀո�
	 * 
	 * @param str
	 * @return ����ֵΪnull�򷵻�null
	 */
	public static String trim(String str) {
		return str == null ? null : str.trim();
	}

	/**
	 * �ж��ַ��������Ƿ����Ҫ��
	 * 
	 * @param str
	 *            null������0
	 * @param minLen
	 *            ��С���ȣ���ֵ��ʾ��������
	 * @param maxLen
	 *            ��󳤶ȣ���ֵ��ʾ��������
	 * @param nullAsZero
	 *            �Ƿ��str=null,���ȵ�0�Դ�������str=nullʱ�׳�null�쳣
	 * @return ���ȷ��Ϸ���0�����̷��ظ�ֵ������������ֵ
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
	 * ƴ�Ӳ�����ֵ�ԡ� ��,keyValConnector="=",paramDivider="&"��name=zhang&age=20
	 * 
	 * @param paramMap
	 * @param keyValConnector
	 *            ��ֵ���ӷ�
	 * @param paramDivider
	 *            �����ָ���
	 * @param charset
	 *            null�򲻱���
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

		// �Ƽ���������������ʱ
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sbd.append(urlEncode(entry.getKey(), charset));
			sbd.append(keyValConnector);
			sbd.append(urlEncode(entry.getValue(), charset));

			sbd.append(divider);
		}

		// jdk�Ͱ汾ͨ��
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
	 * ����key�к��е��ַ�ɸѡ��ֵ
	 * 
	 * @param <T>
	 * @param map
	 * @param keyFlag
	 * @return ɸѡ�õ���Map
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

		// �Ƽ���������������ʱ
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
	 * ���ַ������ݽ���URL���� Translates a string into application/x-www-form-urlencoded
	 * format using a specific encoding scheme. This method uses the supplied
	 * encoding scheme to obtain the bytes for unsafe characters.
	 * 
	 * @param content
	 * @param charset
	 *            �������Ϊ���򲻶�content�����κδ���
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
	 * ���ַ������ݽ���URL���� Decodes a application/x-www-form-urlencoded string using a
	 * specific encoding scheme.
	 * 
	 * @param content
	 * @param charset
	 *            �������Ϊ���򲻶�content�����κδ���
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
	 * �ַ�������
	 * 
	 * @param content
	 * @param srCharset
	 *            �ַ�����ǰ�ı��룬null��ʹ�û���Ĭ�ϱ���
	 * @param destCharset
	 *            �ַ���Ҫת���ı��룬null��ʹ�û���Ĭ�ϱ���
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
	 * �Ƚ�������ֵ�ַ�����doubleֵ�Ƿ����
	 * 
	 * @return ����ֵ��null����������ֵ�ַ�����doubleֵ����ȷ���false,���򷵻�true
	 */
	public static boolean isDoubleEqual(String num1, String num2) {
		if (num1 == null || num1 == null
				|| DataUtil.toDouble(num1) != DataUtil.toDouble(num2)) {
			return false;
		}

		return true;
	}

	/**
	 * ��ֵ�ַ������
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
	 * ��ֵ�ַ������
	 * 
	 * @param minuend
	 *            ������
	 * @param subtrahend
	 *            ����
	 * @return
	 */
	public static BigDecimal subtract(String minuend, String subtrahend) {
		BigDecimal b1 = new BigDecimal(minuend);
		BigDecimal b2 = new BigDecimal(subtrahend);

		return b1.subtract(b2);
	}

	/**
	 * ��ֵ�ַ������
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
	 * ��ֵ�ַ������
	 * 
	 * @param dividend
	 *            ������
	 * @param divisor
	 *            ����
	 * @param scale
	 *            ��ȷ�ȣ���ֵʹ��Ĭ��
	 * @param roundingMode
	 *            ��������ģʽRoundingMode.*��nullʹ��Ĭ��
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
	 * ��ȡUUID
	 * 
	 * @param dropConnector
	 *            �Ƿ�ȥ�����ӷ�"-"
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
	 * ���ַ����е�"\","\\","\\\","//","///"�滻Ϊ"/"��"\"
	 * 
	 * @param pathStr
	 * @param forWin
	 *            true �滻Ϊ"\"
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
 * java��String�ַ���Ϣ����UNICODE�����ŵġ�
 * ��JAVAΪ�˱�ʾ�ַ���ע���ǵ����ַ�����Ҳ��char����������ͣ���С�ǹ̶�2��8λ16�������ֳ��ȣ�Ҳ����0~65535
 * str.getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) new
 * String(...,"ISO-8859-1")�����ַ�������ǿ�а�BYTE���鸴�Ƶ�String��char[]��
 * �����������ɱ��룬��byte[]����char[]����ȫ��������ˡ�
 * 
 * //Ҫ���͵����ݱ������byte[]���͵ġ� �������ͨ��UTF-8����ת��Ϊ�м��String���;ͻ��������
 * //��Ҫ���õ��ֽڵı��루"ISO-8859-1"����ʽ����ת�� byte[] bytes = new byte[] { 50, 0, -1, 28,
 * -24 }; String sendString=new String( bytes ,"UTF-8");//����"ISO-8859-1" byte[]
 * sendBytes= sendString .getBytes("UTF8");
 * 
 * String recString=new String( sendBytes ,"UTF-8");
 * System.out.println(sendString); System.out.println(recString); for(byte bt:
 * recString.getBytes("UTF8"))//����"ISO-8859-1" System.out.println(bt);
 * 
 * ���������Ĵ������� Array.newInstance(Class<?>, len); Class<?>.newInstance()
 * 
 * Class<?> c1 =
 * class<?>.getComponentType();//���class������һ�����飬�򷵻��������Ԫ�ص�class���󣬷��򷵻�null
 * Class<?> c2 = xxx.class; Class<?> c3 = ����.getClass();
 */
