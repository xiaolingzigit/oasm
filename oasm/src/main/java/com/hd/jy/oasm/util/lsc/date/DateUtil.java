package com.hd.jy.oasm.util.lsc.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.RegexUtil;
import com.hd.jy.oasm.util.lsc.excpts.IllegalException;
import com.hd.jy.oasm.util.lsc.excpts.ParseException;

/*
 * ��ȡ�������������������ȡ���ڶ�Ӧ�����ڡ����ȡ�������
 * 
 * ���ڴ���SimpleDateFormat����Ĳ�����
 * EEEE�������ڣ��硰�����ġ�;
 * MMMM���������·ݣ��硰ʮһ�¡�;
 * MM�����·ݣ��硰11��;
 * yyyy������ݣ��硰2010��;
 * h����ʱ,1am,1pm 
 * H����ʱ,1,13
 */
public class DateUtil {

	// �������������ٳ˷�����Ŀ���
	/** ����ת���������� */
	public static final int UNIT_MILLIONSECOND = 1;
	/** ����ת�������� */
	public static final int UNIT_SECOND = 1000;// UNIT_MILLIONSECOND * 1000;
	/** ����ת���������� */
	public static final int UNIT_MINUTE = 60000;// UNIT_SECOND * 60;
	/** ����תСʱ������ */
	public static final int UNIT_HOUR = 360000;// UNIT_MINUTE * 60;
	/** ����ת�������� */
	public static final int UNIT_DAY = 86400000;// UNIT_HOUR * 24;
	/** ����ת�������� */
	public static final int UNIT_WEEK = 60480000;// UNIT_DAY * 7;

//	private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
//	private static final Object lock = new Object();
//
//	/**
//	 * ��ȡSimpleDateFormat
//	 * 
//	 * @param pattern
//	 *            ���ڸ�ʽ
//	 * @return SimpleDateFormat����
//	 * @throws RuntimeException
//	 *             �쳣���Ƿ����ڸ�ʽ
//	 */
//	private static SimpleDateFormat getDateFormat(String pattern)
//			throws RuntimeException {
//		SimpleDateFormat dateFormat = threadLocal.get();
//		if (dateFormat == null) {
//			synchronized (lock) {
//				if (dateFormat == null) {
//					dateFormat = new SimpleDateFormat(pattern);
//					dateFormat.setLenient(false);
//					threadLocal.set(dateFormat);
//				}
//			}
//		} else {
//			dateFormat.applyPattern(pattern);
//		}
//		return dateFormat;
//	}
	
	/**
	 * ���������������ֵ
	 * 
	 * @param dateBefore
	 * @param dateAfter
	 * @param ignoreTime
	 *            �Ƿ����ʱ�䲿�ֵĲ�ֵ
	 * @param unitType
	 *            ��λ��DateUtil.UNIT_*
	 * @return
	 */
	public static double getInterval(Date dateBefore, Date dateAfter,
			boolean ignoreTime, int unitType) {

		if (ignoreTime) {
			dateBefore = setTimeMin(dateBefore);
			dateAfter = setTimeMin(dateAfter);
		}

		double intervalMilli = dateAfter.getTime() - dateBefore.getTime();
		return intervalMilli / unitType;
	}

	/**
	 * ��ȡָ��ʱ�������ʱ��
	 * 
	 * @param specifiedDate
	 *            �ο�����
	 * @param calendarField
	 *            ���������Ԫ��Calendar.*
	 * @param jumpNum
	 *            ���ֵ��������ǰ�����������ط�
	 * @return specifiedDay=nullʱ����null
	 */
	public static Date jump(Date specifiedDate, int calendarField, int jumpNum) {
		if (specifiedDate == null) {
			return null;
		}

		Calendar c = Calendar.getInstance();
		c.setTime(specifiedDate);
		c.add(calendarField, jumpNum);

		return c.getTime();
	}

	/**
	 * ��ȡ��ǰʱ�������ʱ��
	 * 
	 * @param calendarField
	 *            ���������Ԫ��Calendar.*
	 * @param jumpNum
	 *            ���ֵ��������ǰ�����������ط�
	 * @return
	 */
	public static Date jumpDate(int calendarField, int jumpNum) {

		Calendar c = Calendar.getInstance();
		c.add(calendarField, jumpNum);
		return c.getTime();
	}

	/**
	 * ��ȡ���ڶ�Ӧ�ġ����롱����
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return �����롱���ֶ�Ӧ����ֵ
	 */
	public static int getMillisecond(Date date) {
		return getPart(date, Calendar.MILLISECOND);
	}

	/**
	 * ��ȡ���ڶ�Ӧ�ġ��롱����
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ���롱���ֶ�Ӧ����ֵ
	 */
	public static int getSecond(Date date) {
		return getPart(date, Calendar.SECOND);
	}

	/**
	 * ��ȡ���ڶ�Ӧ�ġ��֡�����
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ���֡����ֶ�Ӧ����ֵ
	 */
	public static int getMinute(Date date) {
		return getPart(date, Calendar.MINUTE);
	}

	/**
	 * ��ȡ���ڶ�Ӧ�ġ�ʱ������
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ��ʱ�����ֶ�Ӧ����ֵ
	 */
	public static int getHour(Date date) {
		return getPart(date, Calendar.HOUR_OF_DAY);
	}

	/**
	 * ��ȡ���ڶ�Ӧ�ġ��ա����֣�DAY_OF_MONTH
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ���ա����ֶ�Ӧ����ֵ
	 */
	public static int getDay(Date date) {
		return getPart(date, Calendar.DAY_OF_MONTH);
	}

	/**
	 * ��ȡ���ڶ�Ӧ�ġ��¡�����
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ���¡����ֶ�Ӧ����ֵ��JANUARY=1
	 */
	public static int getMonth(Date date) {
		return getPart(date, Calendar.MONTH);
	}

	/**
	 * ��ȡ���ڶ�Ӧ�ġ��ꡱ����
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ���ꡱ���ֶ�Ӧ����ֵ
	 */
	public static int getYear(Date date) {
		return getPart(date, Calendar.YEAR);
	}

	/**
	 * ��ȡ���ڶ�Ӧ��"����"
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ������0������һ1-��������6
	 */
	public static int dayOfWeek(Date date) {
		return getPart(date, Calendar.DAY_OF_WEEK);
	}

	/**
	 * ��ȡ���ڶ�Ӧ����ĵڼ���
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ���ڶ�Ӧ����ĵڼ���
	 */
	public static int dayOfYear(Date date) {
		return getPart(date, Calendar.DAY_OF_YEAR);
	}

	/**
	 * ��ȡ���ڶ�Ӧ���µĵڼ���
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ���ڶ�Ӧ���µĵڼ���
	 */
	public static int weekOfMonth(Date date) {
		return getPart(date, Calendar.WEEK_OF_MONTH);
	}

	/**
	 * ��ȡ���ڶ�Ӧ����ĵڼ���
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ���ڶ�Ӧ����ĵڼ���
	 */
	public static int weekOfYear(Date date) {
		return getPart(date, Calendar.WEEK_OF_YEAR);
	}

	/**
	 * ��ȡ���������·ݵ�����
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ���������·ݵ�����
	 */
	public static int daysOfMonth(Date date) {
		return actualMax(date, Calendar.DAY_OF_MONTH);
	}

	/**
	 * ��ȡ���������·ݵ�����
	 * 
	 * @param cal
	 *            ����������Ϊnull
	 * @return
	 */
	public static int daysOfMonth(Calendar cal) {
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ��ȡ����������ݵ�����
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ����������ݵ�����
	 */
	public static int daysOfYear(Date date) {
		return actualMax(date, Calendar.DAY_OF_YEAR);
	}

	/**
	 * ��ȡ����������ݵ�����
	 * 
	 * @param cal
	 *            ����������Ϊnull
	 * @return ����������ݵ�����
	 */
	public static int daysOfYear(Calendar cal) {
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
	}

	/**
	 * ��ȡ���������·ݵ�����
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ���������·ݵ�����
	 */
	public static int weeksOfMonth(Date date) {
		return actualMax(date, Calendar.WEEK_OF_MONTH);
	}

	/**
	 * ��ȡ���������·ݵ�����
	 * 
	 * @param cal
	 *            ����������Ϊnull
	 * @return ���������·ݵ�����
	 */
	public static int weeksOfMonth(Calendar cal) {
		return cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * ��ȡ����������ݵ�����
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return ����������ݵ�����
	 */
	public static int weeksOfYear(Date date) {
		return actualMax(date, Calendar.WEEK_OF_YEAR);
	}

	/**
	 * ��ȡ����������ݵ�����
	 * 
	 * @param cal
	 *            ����������Ϊnull
	 * @return ����������ݵ�����
	 */
	public static int weeksOfYear(Calendar cal) {
		return cal.getActualMaximum(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * ��ȡ���ڶ�Ӧ������
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return 
	 */
	public static Week getWeek(Date date) {
		return Week.getWeek(dayOfWeek(date));
	}

	/**
	 * ��ȡ���ڶ�Ӧ�ļ���
	 * 
	 * @param date
	 *            ���ڣ�����Ϊnull
	 * @return 
	 */
	public static Quarter getQuarter(Date date) {
		return Quarter.getByMonth(getMonth(date));
	}

	/**
	 * ��ȡ���ڶ�Ӧ�ļ��ڡ����ڼ��ȵĻ��֣���ͬ�Ĺ�����������λ�ò�ͬ����Ҳ��ͬ��
	 * �ҹ��󲿷ֵ���������12-2��Ϊ������3-5��Ϊ������6-8��Ϊ�ļ���9-11��Ϊ�＾�� �ϰ��򣬰����������ȹ����ҹ������෴�������෴��
	 * 
	 * @param date
	 * @param northHemisphere
	 *            �Ƿ񱱰���
	 * @return
	 */
	public static Season getSeason(Date date, boolean northHemisphere) {
		return Season.getByMonth(getMonth(date), northHemisphere);

	}
	
	//TODO ��ʽ����ת��
	
	/**
	 * ϵͳ��ǰʱ��ת�ַ���
	 * 
	 * @return ����ϵͳ��ǰʱ���Ӧ�ĸ�ʽ���ַ���
	 */
	public static String currDate(String pattern) {
		return toString(new Date(), pattern);
	}
	
	/**
	 * ����ת�ַ���
	 * 
	 * @param date
	 * 
	 * @return date=null�򷵻�null�����򷵻�date��Ӧ�ĸ�ʽ���ַ���
	 */
	public static String toString(Date date, String pattern) {
		if (date == null) {
			return null;
		}

		if (DataUtil.isEmpty(pattern)) {
			throw new IllegalException("pattern", pattern, null);
		}

		return new SimpleDateFormat(pattern).format(date);
	}
	
//	public static String formate(String dateString, String pattern) {
//		if (date == null) {
//			return null;
//		}
//
//		if (DataUtil.isEmpty(pattern)) {
//			throw new IllegalException("pattern", pattern, null);
//		}
//
//		return new SimpleDateFormat(pattern).format(date);
//	}
	
	

	/**
	 * ��������"����"���ֵ�ֵ
	 * 
	 * @param cal
	 *            Date
	 * @param milliSecond
	 *            ����ֵ
	 * @return
	 */
	public static Calendar setMilliSecond(Calendar cal, int milliSecond) {
		cal.set(Calendar.MILLISECOND, milliSecond);
		return cal;
	}

	/**
	 * �����������롱���ֵ�ֵ
	 * 
	 * @param cal
	 *            Date
	 * @param second
	 *            ��ֵ
	 * @return
	 */
	public static Calendar setSecond(Calendar cal, int second) {
		cal.set(Calendar.SECOND, second);
		return cal;
	}

	/**
	 * �����������֡����ֵ�ֵ
	 * 
	 * @param cal
	 *            Date
	 * @param minute
	 *            ����ֵ
	 * @return
	 */
	public static Calendar setMinute(Calendar cal, int minute) {
		cal.set(Calendar.MINUTE, minute);
		return cal;
	}

	/**
	 * ����������ʱ�����ֵ�ֵ
	 * 
	 * @param cal
	 *            Date
	 * @param hour
	 *            Сʱֵ
	 * @return
	 */
	public static Calendar setHour(Calendar cal, int hour) {
		cal.set(Calendar.HOUR_OF_DAY, hour);
		return cal;
	}

	/**
	 * ��������"��"���ֵ�ֵ
	 * 
	 * @param cal
	 *            Date
	 * @param day
	 *            ����ֵ
	 * @return
	 */
	public static Calendar setDay(Calendar cal, int day) {
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal;
	}

	/**
	 * ��������"����"���ֵ�ֵ
	 * 
	 * @param cal
	 *            Date
	 * @param week
	 *            ����ֵ, Calendar.*,Calendar.SUNDAY = 1(������+1)
	 * @return
	 */
	public static Calendar setWeek(Calendar cal, int week) {
		cal.set(Calendar.DAY_OF_WEEK, week);
		return cal;
	}

	/**
	 * ��������ʱ���Ǹ����еĵڼ���
	 * 
	 * @param cal
	 *            Date
	 * @param dayOfYear
	 *            �����еĵڼ���
	 * @return
	 */
	public static Calendar setDayOfYear(Calendar cal, int dayOfYear) {
		cal.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return cal;
	}

	/**
	 * �����������·�ֵ
	 * 
	 * @param cal
	 *            Calendar
	 * @param month
	 *            �·�ֵ,Calendar.JANUARY = 0 (�·�-1)
	 * @return
	 */
	public static Calendar setMonth(Calendar cal, int month) {
		cal.set(Calendar.MONTH, month);
		return cal;
	}

	/**
	 * ���������� ���ֵ
	 * 
	 * @param cal
	 *            Calendar
	 * @param year
	 *            ���ֵ
	 * @return
	 */
	public static Calendar setYear(Calendar cal, int year) {
		cal.set(Calendar.YEAR, year);
		return cal;
	}

	/**
	 * ��������"����"���ֵ�ֵ
	 * 
	 * @param date
	 *            Date
	 * @param milliSecond
	 *            ����ֵ
	 * @return
	 */
	public static Date setMilliSecond(Date date, int milliSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setMilliSecond(cal, milliSecond).getTime();
	}

	/**
	 * �������ڡ��롱���ֵ�ֵ
	 * 
	 * @param date
	 *            Date
	 * @param second
	 *            ��ֵ
	 * @return
	 */
	public static Date setSecond(Date date, int second) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setSecond(cal, second).getTime();
	}

	/**
	 * �������ڡ��֡����ֵ�ֵ
	 * 
	 * @param date
	 *            Date
	 * @param minute
	 *            ����ֵ
	 * @return
	 */
	public static Date setMinute(Date date, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setMinute(cal, minute).getTime();
	}

	/**
	 * �������ڡ�ʱ�����ֵ�ֵ
	 * 
	 * @param date
	 *            Date
	 * @param hour
	 *            Сʱֵ
	 * @return
	 */
	public static Date setHour(Date date, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setHour(cal, hour).getTime();
	}

	/**
	 * ��������"��"���ֵ�ֵ
	 * 
	 * @param date
	 *            Date
	 * @param day
	 *            ����ֵ
	 * @return
	 */
	public static Date setDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setDay(cal, day).getTime();
	}

	/**
	 * ��������"����"���ֵ�ֵ
	 * 
	 * @param date
	 *            Date
	 * @param week
	 *            ����ֵ, Calendar.*,Calendar.SUNDAY = 1(������+1)
	 * @return
	 */
	public static Date setWeek(Date date, int week) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setWeek(cal, week).getTime();
	}

	/**
	 * ��������ʱ���Ǹ����еĵڼ���
	 * 
	 * @param date
	 *            Date
	 * @param dayOfYear
	 *            �����еĵڼ���
	 * @return
	 */
	public static Date setDayOfYear(Date date, int dayOfYear) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setDayOfYear(cal, dayOfYear).getTime();
	}

	/**
	 * �������ڵ��·�ֵ
	 * 
	 * @param date
	 *            Date
	 * @param month
	 *            �·�ֵ,Calendar.JANUARY = 0 (�·�-1)
	 * @return
	 */
	public static Date setMonth(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setMonth(cal, month).getTime();
	}

	/**
	 * �������ڵ� ���ֵ
	 * 
	 * @param date
	 *            Date
	 * @param year
	 *            ���ֵ
	 * @return
	 */
	public static Date setYear(Date date, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setYear(cal, year).getTime();
	}

	/**
	 * ��ȡϵͳ��ǰʱ������ĳ����Ԫ��ֵ
	 * 
	 * @param calendarUnit
	 *            ������Ԫ,Calendar.*
	 * @return ����-����0-6,һ��-ʮ����1-12
	 */
	public static int getPartOfCurr(int calendarUnit) {
		return getPart(new Date(), calendarUnit);
	}

	/**
	 * ��ȡʱ������ĳ����Ԫ��ֵ
	 * 
	 * @param date
	 *            ����,����Ϊnull
	 * @param calendarUnit
	 *            ������Ԫ,Calendar.*
	 * @return ����-����0-6,һ��-ʮ����1-12
	 */
	public static int getPart(Date date, int calendarUnit) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (calendarUnit == Calendar.DAY_OF_WEEK) {
			return cal.get(calendarUnit) - 1;
		} else if (calendarUnit == Calendar.MONTH) {
			return cal.get(calendarUnit) + 1;
		} else {
			return cal.get(calendarUnit);
		}
	}

	/**
	 * ��ȡ����ĳ���ֵ�ʵ����Сֵ
	 * 
	 * @param date
	 *            ����,����Ϊnull
	 * @param calendarUnit
	 *            ������Ԫ,Calendar.*
	 * @return
	 */
	public static int actualMin(Date date, int calendarUnit) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMinimum(calendarUnit);
	}

	/**
	 * ��ȡ����ĳ���ֵ�ʵ����Сֵ
	 * 
	 * @param date
	 *            ����,����Ϊnull
	 * @param calendarUnit
	 *            ������Ԫ,Calendar.*
	 * @return
	 */
	public static int actualMin(Calendar cal, int calendarUnit) {
		return cal.getActualMinimum(calendarUnit);
	}

	/**
	 * ��ȡ����ĳ���ֵ�ʵ�����ֵ
	 * 
	 * @param cal
	 *            ����,����Ϊnull
	 * @param calendarUnit
	 *            ������Ԫ,Calendar.*
	 * @return
	 */
	public static int actualMax(Date date, int calendarUnit) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(calendarUnit);
	}

	/**
	 * ��ȡ����ĳ���ֵ�ʵ�����ֵ
	 * 
	 * @param cal
	 *            ����,����Ϊnull
	 * @param calendarUnit
	 *            ������Ԫ,Calendar.*
	 * @return
	 */
	public static int actualMax(Calendar cal, int calendarUnit) {
		return cal.getActualMaximum(calendarUnit);
	}

	/**
	 * ����ʱ�䲿����Сֵ0:0:0.0
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar setTimeMin(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	/**
	 * ����ʱ�䲿�����ֵ23:59:59.999
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar setTimeMax(Calendar cal) {

		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);

		return cal;
	}

	/**
	 * �������ں�ʱ�䲿����Сֵ�� 1 0:0:0.0
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar setDayTimeMin(Calendar cal) {
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return setTimeMin(cal);
	}

	/**
	 * ��������ʱ�䲿�����ֵ�� date�����������23:59:59.999
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar setDayTimeMax(Calendar cal) {
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return setTimeMax(cal);
	}

	/**
	 * �����¡����ں�ʱ�䲿����Сֵ��xxxx-1-1 0:0:0.0
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar setMonthDayTimeMin(Calendar cal) {
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return setTimeMin(cal);
	}

	/**
	 * �����¡����ں�ʱ�䲿�����ֵ��xxxx-12-maxDay 23:59:59.999
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar setMonthDayTimeMax(Calendar cal) {
		cal.set(Calendar.MONTH, 12);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return setTimeMax(cal);
	}


	/**
	 * ����ʱ�䲿����Сֵ0:0:0.0
	 * 
	 * @param cal
	 * @return
	 */
	public static Date setTimeMin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * ����ʱ�䲿�����ֵ23:59:59.999
	 * 
	 * @param cal
	 * @return
	 */
	public static Date setTimeMax(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	/**
	 * �������ں�ʱ�䲿����Сֵ�� xxxx-x-1-1 0:0:0.0
	 * 
	 * @param date
	 * @return
	 */
	public static Date setDayTimeMin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setDayTimeMin(cal).getTime();
	}

	/**
	 * �������ں�ʱ�䲿�����ֵ�� date����������� xxxx-x-maxDay 23:59:59.999
	 * 
	 * @param date
	 * @return
	 */
	public static Date setDayTimeMax(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setDayTimeMax(cal).getTime();
	}

	/**
	 * �����¡����ں�ʱ�䲿����Сֵ��xxxx-1-1 0:0:0.0
	 * 
	 * @param date
	 * @return
	 */
	public static Date setMonthDayTimeMin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setMonthDayTimeMin(cal).getTime();
	}

	/**
	 * �����¡����ں�ʱ�䲿�����ֵ��xxxx-12-maxDay 23:59:59.999
	 * 
	 * @param date
	 * @return
	 */
	public static Date setMonthDayTimeMax(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setMonthDayTimeMax(cal).getTime();
	}

	public static final int F_IGNORE_FIX = -1;
	public static final int F_FIX = -2;
	public static final int F_THROWN_EXCEPTION = -3;
	public static final int IGNORE = -1;

	
	
	/**
	 * �޸�����
	 * 
	 * @param date
	 *            ���ڶ���
	 * @param year
	 *            ��ݷǸ�������-1���Ը����ڵ�Ԫ���ã��������쳣
	 * @param month
	 *            �·�1-12��-1���Ը����ڵ�Ԫ���ã��������쳣
	 * @param day
	 *            ���ڣ�1-31��40������Сֵ ��50�������ֵ��-1���Ը����ڵ�Ԫ���ã��������쳣
	 * @param hour
	 *            Сʱ��0-23��-1���Ը����ڵ�Ԫ���ã��������쳣
	 * @param min
	 *            ����0-59��-1���Ը����ڵ�Ԫ���ã��������쳣
	 * @param sec
	 *            ��0-59��-1���Ը����ڵ�Ԫ���ã��������쳣
	 * @param millsec
	 *            ����0-999��-1���Ը����ڵ�Ԫ���ã��������쳣
	 * @param fitDayMax
	 *            ������õġ��ա���ֵ�����������ֵ���Ƿ�����Ϊ�������ֵ�������������ǰ�ƽ��������쳣��-1����������-2������-3
	 *            ������Χ���쳣���磺ĳ��2�������ֵΪ28������ֵΪ30�����
	 *            F_IGNORE_FIX(-1)���������ڱ�Ϊ3��2��;F_FIX
	 *            (-2)�����30����Ϊ28;F_THROWN_EXCEPTION
	 *            (-3)����IllegalArgumentException
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Date fixDate(Date date, int year, int month, int day,
			int hour, int min, int sec, int millsec, int fitDayMax)
			throws IllegalArgumentException {

		if (date == null) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		if (year == IGNORE) {
			// do nothing
		} else if (year >= 0) {
			setYear(cal, year);
		} else {
			throw new IllegalException("year", year,
					"the value of year must be: year>=0");
		}

		if (month == F_IGNORE_FIX) {
			// do nothing
		} else if (month >= 1 && month <= 12) {
			setMonth(cal, month - 1);
		} else {
			throw new IllegalException("month", month,
					"the value of month must be: 0<=month<=11.");
		}

		if (hour == F_IGNORE_FIX) {
			// do nothing
		} else if (hour >= 0 && hour < 24) {
			setHour(cal, hour);
		} else {
			throw new IllegalException("hour", hour,
					"the value of hour be: 0<=hour<24.");
		}

		if (min == F_IGNORE_FIX) {
			// do nothing
		} else if (min >= 0 && min < 60) {
			setMinute(cal, min);
		} else {
			throw new IllegalException("minute", min,
					"the value of minute must be: 0<=min<=59.");
		}

		if (sec == F_IGNORE_FIX) {
			// do nothing
		} else if (sec >= 0 && sec < 60) {
			setSecond(cal, sec);
		} else {
			throw new IllegalException("second", sec,
					"the value of second must be: 0<=min<=59.");
		}

		if (millsec == F_IGNORE_FIX) {
			// do nothing
		} else if (month >= 0 && month < 1000) {
			setMilliSecond(cal, millsec);
		} else {
			throw new IllegalException("millsecond", millsec,
					"the value of millsecond must be: 0<=millsec<=999.");
		}

		if (day == F_IGNORE_FIX) {
			// do nothing
		} else if (day > 0 && day <= 31) {
			// ��������
			if (fitDayMax == F_IGNORE_FIX) {
				// do nothing
			} else {
				int dayMax = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				if (fitDayMax == F_FIX) {
					day = dayMax;
				} else if (fitDayMax == F_THROWN_EXCEPTION) {
					throw new IllegalException("day", day,
							"the value of day should be: 0<=day<=" + dayMax
									+ " of " + cal.get(Calendar.YEAR) + "-"
									+ cal.get(Calendar.MONTH));
				} else {
					throw new IllegalArgumentException(
							"the value of fitDayMax must be: F_IGNORE_FIX(-1),F_FIX(-2),F_THROWN_EXCEPTION(-3), input value: "
									+ fitDayMax);
				}
			}

			setDay(cal, day);
		} else {
			throw new IllegalArgumentException(
					"the value of day must be: 0<day<=31, input value: " + day);
		}

		return cal.getTime();
	}

	/**
	 * * ��ȡ�������ڵ�ʱ����
	 * 
	 * @param startDate
	 * @param endDate
	 * @return *day(s)*hour(s)*minute(s)*second(s)��ʽ�ַ���
	 * @param startDate
	 * @param endDate
	 * @param chinese
	 *            true�������������ַ�����false���������ַ���
	 * @return
	 */
	public static String intervalString(Date startDate, Date endDate,
			boolean chinese) {
		long milliseconds = endDate.getTime() - startDate.getTime();
		long nd = 1000 * 24 * 60 * 60;// һ��ĺ�����
		long nh = 1000 * 60 * 60;// һСʱ�ĺ�����
		long nm = 1000 * 60;// һ���ӵĺ�����
		long ns = 1000;// һ���ӵĺ�����

		long day = milliseconds / nd;// ����������
		long hour = milliseconds % nd / nh;// ��������Сʱ
		long min = milliseconds % nd % nh / nm;// �������ٷ���
		long sec = milliseconds % nd % nh % nm / ns;// ����������//������

		if (chinese) {
			return joinChs(day, hour, min, sec);
		}

		return joinEng(day, hour, min, sec);
	}

	/**
	 * ʱ�似�������ַ�������
	 * 
	 * @param day
	 * @param hour
	 * @param min
	 * @param sec
	 * @return
	 */
	private static String joinChs(long day, long hour, long min, long sec) {

		String unitDay = "";
		String unitHour = "";
		String unitMin = "";
		String unitSec = "0��";

		// ��ʱ�����м䲹0
		if (day > 0) {
			unitHour = "0Сʱ ";
			unitMin = "0�� ";
		} else if (hour > 0) {
			unitMin = "0�� ";
		}

		// ����������
		if (day >= 1){
			unitDay = day + "�� ";
		};
		if (hour >= 1){
			unitHour = hour + "Сʱ ";
		};
		if (min >= 1){
			unitMin = min + "�� ";
		};
		if (sec >= 1){
			unitSec = sec + "��";
		};
		return new StringBuilder().append(unitDay).append(unitHour)
				.append(unitMin).append(unitSec).toString();

	}

	/**
	 * ʱ�����Ӣ���ַ�������
	 * 
	 * @param day
	 * @param hour
	 * @param min
	 * @param sec
	 * @return
	 */
	private static String joinEng(long day, long hour, long min, long sec) {

		String unitDay = "";
		String unitHour = "";
		String unitMin = "";
		String unitSec = "0 second ";

		// ��ʱ�����м䲹0
		if (day > 0) {
			unitHour = "0 hour ";
			unitMin = "0 minute ";
		} else if (hour > 0) {
			unitMin = "0 minute ";
		}

		// ����������
		if (day == 1) {
			unitDay = "1 day ";
		} else if (day > 1) {
			unitDay = day + " days ";
		}

		if (hour == 1) {
			unitHour = "1 hour ";
		} else if (hour > 1) {
			unitHour = hour + " hours ";
		}

		if (min == 1) {
			unitMin = "1 minute ";
		} else if (min > 1) {
			unitMin = min + " minutes ";
		}

		if (sec == 1) {
			unitSec = "1 second";
		} else if (sec > 1) {
			unitSec = sec + " seconds";
		}

		return new StringBuilder().append(unitDay).append(unitHour)
				.append(unitMin).append(unitSec).toString();

	}

	/**
	 * ��ʽ������һ����ʽ�������ַ���ΪDate
	 * 
	 * @param dateStr
	 *            ****(.-/��)*(.-/��)*(.-/��)[ ]*(:ʱ)*(:��)*(.��)*(����)]��ʽ�����ַ���
	 * @param pattern
	 *            null������Զ��ж�
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String dateStr, String pattern) {

		if (DataUtil.isEmpty(dateStr, true)) {
			return null;
		}

		if (!RegexUtil.isDate(dateStr)) {
			throw new IllegalException("input string[" + dateStr
					+ "] may not a data-formate string");
		}

		// �����ʽ�����ʽ��Ч���Զ��ж�
		if (DataUtil.isEmpty(pattern, true)) {

			String[] sArr = dateStr.trim().split("|");

			int f1 = 0;// "/"
			int f2 = 0;// "-"
			int f3 = 0;// "yyyy.MM.dd *ss.SSS" f3>=2
			int f4 = 0;// ������
			int f5 = 0;// :
			int f6 = 0;// ʱ����
			int f7 = 0;// ����
			for (String s : sArr) {
				if ("/".equals(s)) {
					f1++;
				} else if ("-".equals(s)) {
					f2++;
				} else if (".".equals(s)) {
					f3++;
				} else if ("��".equals(s) || "��".equals(s) || "��".equals(s)) {
					f4++;
				} else if (":".equals(s)) {
					f5++;
				} else if ("ʱ".equals(s) || "��".equals(s) || "��".equals(s)) {
					f6++;
				} else if ("����".equals(s)) {
					f7++;
				}
			}

			// ����
			if (f1 == 2) {
				pattern = "yyyy/MM/dd";
			} else if (f2 == 2) {
				pattern = "yyyy-MM-dd";
			} else if (f3 >= 2) {
				pattern = "yyyy.MM.dd";
			} else if (f4 == 3) {
				pattern = "yyyy��MM��dd��";
			}

			// ʱ��
			if (f5 > 0) {// :
				if (!pattern.isEmpty() && dateStr.trim().contains(" ")) {
					pattern += " ";
				}

				pattern += "HH:mm:ss";
			} else if (f6 > 0) {

				if (!pattern.isEmpty() && dateStr.trim().contains(" ")) {
					pattern += " ";
				}

				pattern += "HHʱmm��ss��";
			}

			// ����
			if (f3 == 1 || f3 == 3) {// .
				pattern += ".SSS";
			} else if (f7 > 0) {
				pattern += "SSS����";
			}
		}

		try {
			return new SimpleDateFormat(pattern).parse(dateStr);
		} catch (Exception e) {
			throw new ParseException("parse String[" + dateStr
					+ "] to date by pattern[" + pattern + "] failed", e);
		}
	}

	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("e").format(new Date()));
	}

}
