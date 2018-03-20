package com.hd.jy.oasm.util.lsc;

import java.util.regex.Pattern;

public class RegexUtil {
	/** 时间正则表达式 */
	public static final String REG_TIME = "^([01]?[0-9]|2[0-3])[:|时][0-5]?[0-9][:|分][0-5]?[0-9](秒|([秒|\\.][0-9]{1,3}(毫秒)?))?$";
	/** 纯日期正则表达式 */
	public static final String REG_DATE_ONLY = "^(?:(?!0000)[0-9]{4}(-|/|年|\\.)(?:(?:0?[1-9]|1[0-2])(-|/|月|\\.)(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])(-|/|月|\\.)(?:29|30)|(?:0?[13578]|1[02])(-|/|月|\\.)31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)(-|/|年|\\.)0?2(-|/|月|\\.)29)日?$";
	/** 日期（可含时间）正则表达式 */
	public static final String REG_DATE = "^(?:(?!0000)[0-9]{4}(-|/|年|\\.)(?:(?:0?[1-9]|1[0-2])(-|/|月|\\.)(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])(-|/|月|\\.)(?:29|30)|(?:0?[13578]|1[02])(-|/|月|\\.)31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)(-|/|年|\\.)0?2(-|/|月|\\.)29)(日(\\s)?|\\s)?(([01]?[0-9]|2[0-3])[:|时][0-5]?[0-9][:|分][0-5]?[0-9](秒|([秒|\\.][0-9]{1,3}(毫秒)?))?)?$";
	/** 日期时间正则表达式 */
	public static final String REG_DATE_TIME = "^(?:(?!0000)[0-9]{4}(-|/|年|\\.)(?:(?:0?[1-9]|1[0-2])(-|/|月|\\.)(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])(-|/|月|\\.)(?:29|30)|(?:0?[13578]|1[02])(-|/|月|\\.)31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)(-|/|年|\\.)0?2(-|/|月|\\.)29)[日(\\s)?|\\s]+([01]?[0-9]|2[0-3])[:|时][0-5]?[0-9][:|分][0-5]?[0-9](秒|([秒|\\.][0-9]{1,3}(毫秒)?))?$";

	/** 纯数字正则表达式 */
	public static final String REG_DIGIT = "^\\d+$";// "[0-9]+";
	/** 数值（正负数，0，小数，整数）正则表达式 */
	public static final String REG_NUM = "^(-?\\d+)(\\.\\d+)?$";// "-?[0-9]+(.[0-9]+)?";
	/** 正负整数正则表达式 */
	public static final String REG_INTEGER = "^-?\\d+$";// "-?[0-9]+?";
	/** 正负小数正则表达式 */
	public static final String REG_DECIMALS = "^-?\\d+.\\d+$"; // decimals

	/** 大小写字母正则表达式 */
	public static final String REG_CHAR = "[a-zA-Z]+";
	/** 字母数字正则表达式 */
	public static final String REG_NUM_CHAR = "[a-zA-Z\\d]+";

	/** 单字节字符（非中文字符）正则表达式 */
	public static final String REG_ASC = "[\\x00-\\xff]+";
	/** 双字节字符（中文字符）正则表达式 */
	public static final String REG_DBCS = "[^\\x00-\\xff]+";

	/** 汉字正则表达式 */
	public static final String REG_CN_CHAR = "[\u4e00-\u9fa5]+";
	/** 数字、字母、汉字正则表达式 */
	public static final String REG_NUM_CN_EN_CHAR = "[a-zA-Z\\d\u4e00-\u9fa5]+";

	/** 邮箱正则表达式 */
	public static final String REG_EMAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

	/** 中国身份证号码 */
	public static final String REG_ID_NO_CN = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)";

	// public static final String REG_PHONE =
	// "1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}";

	/**
	 * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
	 * 
	 * @param mobile
	 *            移动、联通、电信运营商的号码段
	 * 
	 *            移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
	 *            、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）
	 * 
	 *            联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）
	 * 
	 *            电信的号段：133、153、180（未启用）、189
	 * 
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean isMobile(String mobile) {
		String regex = "(\\+\\d+)?1[3458]\\d{9}$";
		return isMatches(regex, mobile);
	}

	/**
	 * 区号+座机号码+分机号码
	 * 
	 * @param fixedPhone
	 * @return
	 */
	public static boolean isFixedPhone(String fixedPhone) {
		String regex = "(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|"
				+ "(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";
		return isMatches(regex, fixedPhone);
	}

	/**
	 * 判断是否长日期时间字符，格式：2016(- / 年)01(- / 月)01[日] 00:00:00[.000]
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDateTime(String str) {
		return isMatches(REG_DATE_TIME, str);
	}

	/**
	 * 判断是否长日期时间字符，格式：2016(- / 年)01(- / 月)01[日][ ][00:00:00][.000]
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDate(String str) {
		return isMatches(REG_DATE, str);
	}

	/**
	 * 判断是否长日期时间字符，格式：00:00:00[.000]
	 * 
	 * @param timeStr
	 * @return
	 */
	public static boolean isTime(String timeStr) {
		return isMatches(REG_TIME, timeStr);
	}

	/**
	 * 判断是否数字，可以包含负号和小数点
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNum(String numStr) {
		return isMatches(REG_NUM, numStr);
	}

	/**
	 * 判断是否正/负整数
	 * 
	 * @param numStr
	 * @return
	 */
	public static boolean isInteger(String numStr) {
		return isMatches(REG_INTEGER, numStr);
	}

	/**
	 * 判断是否纯数字0-9
	 * 
	 * @param numStr
	 * @return
	 */
	public static boolean isDigit(String numStr) {
		return isMatches(REG_DIGIT, numStr);
	}

	/**
	 * 判断是否纯字母
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChar(String str) {
		return isMatches(REG_CHAR, str);
	}

	/**
	 * 判断是否纯数字字母
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumChar(String str) {
		return isMatches(REG_NUM_CHAR, str);
	}

	/**
	 * 判断是否汉字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		return isMatches(REG_CN_CHAR, str);
	}

	/**
	 * 判断是否纯字母、数字、汉字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumCharAll(String str) {
		return isMatches(REG_NUM_CN_EN_CHAR, str);
	}

	/**
	 * 判断是否邮箱
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEMail(String str) {

		return isMatches(REG_EMAIL, str);
	}

	/**
	 * 判断字符串是否含有符合正则表达式规则的内容
	 * 
	 * @param regex
	 *            正则表达式
	 * @param content
	 * @return
	 */
	public static boolean isFound(String regex, String content) {
		if (content == null && regex == null) {
			return true;
		} else if (content == null || regex == null) {
			return false;
		}

		return Pattern.compile(regex).matcher(content).find();
	}

	/**
	 * 判断字符串是否与正则表达式匹配
	 * 
	 * @param regex
	 * @param content
	 * @return
	 */
	public static boolean isMatches(String regex, String content) {
		if (content == null && regex == null) {
			return true;
		} else if (content == null || regex == null) {
			return false;
		}
		// Pattern.compile(regex).matcher(content).matches();
		// Pattern.matches(regex, input);
		// content.matches(regex);
		return Pattern.compile(regex).matcher(content).matches();
	}
}
