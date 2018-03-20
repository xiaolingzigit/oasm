package com.hd.jy.oasm.util.lsc;

import java.util.regex.Pattern;

public class RegexUtil {
	/** ʱ��������ʽ */
	public static final String REG_TIME = "^([01]?[0-9]|2[0-3])[:|ʱ][0-5]?[0-9][:|��][0-5]?[0-9](��|([��|\\.][0-9]{1,3}(����)?))?$";
	/** ������������ʽ */
	public static final String REG_DATE_ONLY = "^(?:(?!0000)[0-9]{4}(-|/|��|\\.)(?:(?:0?[1-9]|1[0-2])(-|/|��|\\.)(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])(-|/|��|\\.)(?:29|30)|(?:0?[13578]|1[02])(-|/|��|\\.)31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)(-|/|��|\\.)0?2(-|/|��|\\.)29)��?$";
	/** ���ڣ��ɺ�ʱ�䣩������ʽ */
	public static final String REG_DATE = "^(?:(?!0000)[0-9]{4}(-|/|��|\\.)(?:(?:0?[1-9]|1[0-2])(-|/|��|\\.)(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])(-|/|��|\\.)(?:29|30)|(?:0?[13578]|1[02])(-|/|��|\\.)31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)(-|/|��|\\.)0?2(-|/|��|\\.)29)(��(\\s)?|\\s)?(([01]?[0-9]|2[0-3])[:|ʱ][0-5]?[0-9][:|��][0-5]?[0-9](��|([��|\\.][0-9]{1,3}(����)?))?)?$";
	/** ����ʱ��������ʽ */
	public static final String REG_DATE_TIME = "^(?:(?!0000)[0-9]{4}(-|/|��|\\.)(?:(?:0?[1-9]|1[0-2])(-|/|��|\\.)(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])(-|/|��|\\.)(?:29|30)|(?:0?[13578]|1[02])(-|/|��|\\.)31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)(-|/|��|\\.)0?2(-|/|��|\\.)29)[��(\\s)?|\\s]+([01]?[0-9]|2[0-3])[:|ʱ][0-5]?[0-9][:|��][0-5]?[0-9](��|([��|\\.][0-9]{1,3}(����)?))?$";

	/** ������������ʽ */
	public static final String REG_DIGIT = "^\\d+$";// "[0-9]+";
	/** ��ֵ����������0��С����������������ʽ */
	public static final String REG_NUM = "^(-?\\d+)(\\.\\d+)?$";// "-?[0-9]+(.[0-9]+)?";
	/** ��������������ʽ */
	public static final String REG_INTEGER = "^-?\\d+$";// "-?[0-9]+?";
	/** ����С��������ʽ */
	public static final String REG_DECIMALS = "^-?\\d+.\\d+$"; // decimals

	/** ��Сд��ĸ������ʽ */
	public static final String REG_CHAR = "[a-zA-Z]+";
	/** ��ĸ����������ʽ */
	public static final String REG_NUM_CHAR = "[a-zA-Z\\d]+";

	/** ���ֽ��ַ����������ַ���������ʽ */
	public static final String REG_ASC = "[\\x00-\\xff]+";
	/** ˫�ֽ��ַ��������ַ���������ʽ */
	public static final String REG_DBCS = "[^\\x00-\\xff]+";

	/** ����������ʽ */
	public static final String REG_CN_CHAR = "[\u4e00-\u9fa5]+";
	/** ���֡���ĸ������������ʽ */
	public static final String REG_NUM_CN_EN_CHAR = "[a-zA-Z\\d\u4e00-\u9fa5]+";

	/** ����������ʽ */
	public static final String REG_EMAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

	/** �й����֤���� */
	public static final String REG_ID_NO_CN = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)";

	// public static final String REG_PHONE =
	// "1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}";

	/**
	 * ��֤�ֻ����루֧�ֹ��ʸ�ʽ��+86135xxxx...���й��ڵأ���+00852137xxxx...���й���ۣ���
	 * 
	 * @param mobile
	 *            �ƶ�����ͨ��������Ӫ�̵ĺ����
	 * 
	 *            �ƶ��ĺŶΣ�134(0-8)��135��136��137��138��139��147��Ԥ������TD��������
	 *            ��150��151��152��157��TDר�ã���158��159��187��δ���ã���188��TDר�ã�
	 * 
	 *            ��ͨ�ĺŶΣ�130��131��132��155��156�������ר�ã���185��δ���ã���186��3g��
	 * 
	 *            ���ŵĺŶΣ�133��153��180��δ���ã���189
	 * 
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean isMobile(String mobile) {
		String regex = "(\\+\\d+)?1[3458]\\d{9}$";
		return isMatches(regex, mobile);
	}

	/**
	 * ����+��������+�ֻ�����
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
	 * �ж��Ƿ�����ʱ���ַ�����ʽ��2016(- / ��)01(- / ��)01[��] 00:00:00[.000]
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDateTime(String str) {
		return isMatches(REG_DATE_TIME, str);
	}

	/**
	 * �ж��Ƿ�����ʱ���ַ�����ʽ��2016(- / ��)01(- / ��)01[��][ ][00:00:00][.000]
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDate(String str) {
		return isMatches(REG_DATE, str);
	}

	/**
	 * �ж��Ƿ�����ʱ���ַ�����ʽ��00:00:00[.000]
	 * 
	 * @param timeStr
	 * @return
	 */
	public static boolean isTime(String timeStr) {
		return isMatches(REG_TIME, timeStr);
	}

	/**
	 * �ж��Ƿ����֣����԰������ź�С����
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNum(String numStr) {
		return isMatches(REG_NUM, numStr);
	}

	/**
	 * �ж��Ƿ���/������
	 * 
	 * @param numStr
	 * @return
	 */
	public static boolean isInteger(String numStr) {
		return isMatches(REG_INTEGER, numStr);
	}

	/**
	 * �ж��Ƿ�����0-9
	 * 
	 * @param numStr
	 * @return
	 */
	public static boolean isDigit(String numStr) {
		return isMatches(REG_DIGIT, numStr);
	}

	/**
	 * �ж��Ƿ���ĸ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChar(String str) {
		return isMatches(REG_CHAR, str);
	}

	/**
	 * �ж��Ƿ�������ĸ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumChar(String str) {
		return isMatches(REG_NUM_CHAR, str);
	}

	/**
	 * �ж��Ƿ���
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		return isMatches(REG_CN_CHAR, str);
	}

	/**
	 * �ж��Ƿ���ĸ�����֡�����
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumCharAll(String str) {
		return isMatches(REG_NUM_CN_EN_CHAR, str);
	}

	/**
	 * �ж��Ƿ�����
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEMail(String str) {

		return isMatches(REG_EMAIL, str);
	}

	/**
	 * �ж��ַ����Ƿ��з���������ʽ���������
	 * 
	 * @param regex
	 *            ������ʽ
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
	 * �ж��ַ����Ƿ���������ʽƥ��
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
