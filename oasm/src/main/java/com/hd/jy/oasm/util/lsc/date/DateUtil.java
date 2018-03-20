package com.hd.jy.oasm.util.lsc.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.RegexUtil;
import com.hd.jy.oasm.util.lsc.excpts.IllegalException;
import com.hd.jy.oasm.util.lsc.excpts.ParseException;

/*
 * 获取两个日期相差天数，获取日期对应的星期、季度、天数等
 * 
 * 对于创建SimpleDateFormat传入的参数：
 * EEEE代表星期，如“星期四”;
 * MMMM代表中文月份，如“十一月”;
 * MM代表月份，如“11”;
 * yyyy代表年份，如“2010”;
 * h代表时,1am,1pm 
 * H代表时,1,13
 */
public class DateUtil {

	// 用立即数，减少乘法计算的开销
	/** 毫秒转毫秒立即数 */
	public static final int UNIT_MILLIONSECOND = 1;
	/** 毫秒转秒立即数 */
	public static final int UNIT_SECOND = 1000;// UNIT_MILLIONSECOND * 1000;
	/** 毫秒转分钟立即数 */
	public static final int UNIT_MINUTE = 60000;// UNIT_SECOND * 60;
	/** 毫秒转小时立即数 */
	public static final int UNIT_HOUR = 360000;// UNIT_MINUTE * 60;
	/** 毫秒转天立即数 */
	public static final int UNIT_DAY = 86400000;// UNIT_HOUR * 24;
	/** 毫秒转周立即数 */
	public static final int UNIT_WEEK = 60480000;// UNIT_DAY * 7;

//	private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
//	private static final Object lock = new Object();
//
//	/**
//	 * 获取SimpleDateFormat
//	 * 
//	 * @param pattern
//	 *            日期格式
//	 * @return SimpleDateFormat对象
//	 * @throws RuntimeException
//	 *             异常：非法日期格式
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
	 * 计算两个日期相差值
	 * 
	 * @param dateBefore
	 * @param dateAfter
	 * @param ignoreTime
	 *            是否忽略时间部分的差值
	 * @param unitType
	 *            单位，DateUtil.UNIT_*
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
	 * 获取指定时间变更后的时间
	 * 
	 * @param specifiedDate
	 *            参考日期
	 * @param calendarField
	 *            变更日历单元，Calendar.*
	 * @param jumpNum
	 *            变更值，正数往前翻，负数往回翻
	 * @return specifiedDay=null时返回null
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
	 * 获取当前时间变更后的时间
	 * 
	 * @param calendarField
	 *            变更日历单元，Calendar.*
	 * @param jumpNum
	 *            变更值，正数往前翻，负数往回翻
	 * @return
	 */
	public static Date jumpDate(int calendarField, int jumpNum) {

		Calendar c = Calendar.getInstance();
		c.add(calendarField, jumpNum);
		return c.getTime();
	}

	/**
	 * 获取日期对应的“毫秒”部分
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return “毫秒”部分对应的数值
	 */
	public static int getMillisecond(Date date) {
		return getPart(date, Calendar.MILLISECOND);
	}

	/**
	 * 获取日期对应的“秒”部分
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return “秒”部分对应的数值
	 */
	public static int getSecond(Date date) {
		return getPart(date, Calendar.SECOND);
	}

	/**
	 * 获取日期对应的“分”部分
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return “分”部分对应的数值
	 */
	public static int getMinute(Date date) {
		return getPart(date, Calendar.MINUTE);
	}

	/**
	 * 获取日期对应的“时”部分
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return “时”部分对应的数值
	 */
	public static int getHour(Date date) {
		return getPart(date, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取日期对应的“日”部分，DAY_OF_MONTH
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return “日”部分对应的数值
	 */
	public static int getDay(Date date) {
		return getPart(date, Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取日期对应的“月”部分
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return “月”部分对应的数值，JANUARY=1
	 */
	public static int getMonth(Date date) {
		return getPart(date, Calendar.MONTH);
	}

	/**
	 * 获取日期对应的“年”部分
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return “年”部分对应的数值
	 */
	public static int getYear(Date date) {
		return getPart(date, Calendar.YEAR);
	}

	/**
	 * 获取日期对应的"星期"
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return 星期日0、星期一1-至星期六6
	 */
	public static int dayOfWeek(Date date) {
		return getPart(date, Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获取日期对应当年的第几天
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return 日期对应当年的第几天
	 */
	public static int dayOfYear(Date date) {
		return getPart(date, Calendar.DAY_OF_YEAR);
	}

	/**
	 * 获取日期对应当月的第几周
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return 日期对应当月的第几周
	 */
	public static int weekOfMonth(Date date) {
		return getPart(date, Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 获取日期对应当年的第几周
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return 日期对应当年的第几周
	 */
	public static int weekOfYear(Date date) {
		return getPart(date, Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取日期所在月份的天数
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return 日期所在月份的天数
	 */
	public static int daysOfMonth(Date date) {
		return actualMax(date, Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取日期所在月份的天数
	 * 
	 * @param cal
	 *            日历，不可为null
	 * @return
	 */
	public static int daysOfMonth(Calendar cal) {
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取日期所在年份的天数
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return 日期所在年份的天数
	 */
	public static int daysOfYear(Date date) {
		return actualMax(date, Calendar.DAY_OF_YEAR);
	}

	/**
	 * 获取日期所在年份的天数
	 * 
	 * @param cal
	 *            日历，不可为null
	 * @return 日期所在年份的天数
	 */
	public static int daysOfYear(Calendar cal) {
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 获取日期所在月份的周数
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return 日期所在月份的周数
	 */
	public static int weeksOfMonth(Date date) {
		return actualMax(date, Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 获取日期所在月份的周数
	 * 
	 * @param cal
	 *            日历，不可为null
	 * @return 日期所在月份的周数
	 */
	public static int weeksOfMonth(Calendar cal) {
		return cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 获取日期所在年份的周数
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return 日期所在年份的周数
	 */
	public static int weeksOfYear(Date date) {
		return actualMax(date, Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取日期所在年份的天数
	 * 
	 * @param cal
	 *            日历，不可为null
	 * @return 日期所在年份的周数
	 */
	public static int weeksOfYear(Calendar cal) {
		return cal.getActualMaximum(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * 获取日期对应的星期
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return 
	 */
	public static Week getWeek(Date date) {
		return Week.getWeek(dayOfWeek(date));
	}

	/**
	 * 获取日期对应的季度
	 * 
	 * @param date
	 *            日期，不可为null
	 * @return 
	 */
	public static Quarter getQuarter(Date date) {
		return Quarter.getByMonth(getMonth(date));
	}

	/**
	 * 获取日期对应的季节。对于季度的划分，不同的国家所处地理位置不同划分也不同。
	 * 我国大部分地区气候上12-2月为冬季，3-5月为春季，6-8月为夏季，9-11月为秋季。 南半球，巴西新西兰等国与我国冬夏相反，春秋相反。
	 * 
	 * @param date
	 * @param northHemisphere
	 *            是否北半球
	 * @return
	 */
	public static Season getSeason(Date date, boolean northHemisphere) {
		return Season.getByMonth(getMonth(date), northHemisphere);

	}
	
	//TODO 格式化和转换
	
	/**
	 * 系统当前时间转字符串
	 * 
	 * @return 返回系统当前时间对应的格式化字符串
	 */
	public static String currDate(String pattern) {
		return toString(new Date(), pattern);
	}
	
	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * 
	 * @return date=null则返回null，否则返回date对应的格式化字符串
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
	 * 设置日历"毫秒"部分的值
	 * 
	 * @param cal
	 *            Date
	 * @param milliSecond
	 *            毫秒值
	 * @return
	 */
	public static Calendar setMilliSecond(Calendar cal, int milliSecond) {
		cal.set(Calendar.MILLISECOND, milliSecond);
		return cal;
	}

	/**
	 * 设置日历“秒”部分的值
	 * 
	 * @param cal
	 *            Date
	 * @param second
	 *            秒值
	 * @return
	 */
	public static Calendar setSecond(Calendar cal, int second) {
		cal.set(Calendar.SECOND, second);
		return cal;
	}

	/**
	 * 设置日历“分”部分的值
	 * 
	 * @param cal
	 *            Date
	 * @param minute
	 *            分钟值
	 * @return
	 */
	public static Calendar setMinute(Calendar cal, int minute) {
		cal.set(Calendar.MINUTE, minute);
		return cal;
	}

	/**
	 * 设置日历“时”部分的值
	 * 
	 * @param cal
	 *            Date
	 * @param hour
	 *            小时值
	 * @return
	 */
	public static Calendar setHour(Calendar cal, int hour) {
		cal.set(Calendar.HOUR_OF_DAY, hour);
		return cal;
	}

	/**
	 * 设置日历"日"部分的值
	 * 
	 * @param cal
	 *            Date
	 * @param day
	 *            日期值
	 * @return
	 */
	public static Calendar setDay(Calendar cal, int day) {
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal;
	}

	/**
	 * 设置日历"星期"部分的值
	 * 
	 * @param cal
	 *            Date
	 * @param week
	 *            星期值, Calendar.*,Calendar.SUNDAY = 1(星期数+1)
	 * @return
	 */
	public static Calendar setWeek(Calendar cal, int week) {
		cal.set(Calendar.DAY_OF_WEEK, week);
		return cal;
	}

	/**
	 * 设置日历时间是该年中的第几天
	 * 
	 * @param cal
	 *            Date
	 * @param dayOfYear
	 *            该年中的第几天
	 * @return
	 */
	public static Calendar setDayOfYear(Calendar cal, int dayOfYear) {
		cal.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return cal;
	}

	/**
	 * 设置日历的月份值
	 * 
	 * @param cal
	 *            Calendar
	 * @param month
	 *            月份值,Calendar.JANUARY = 0 (月份-1)
	 * @return
	 */
	public static Calendar setMonth(Calendar cal, int month) {
		cal.set(Calendar.MONTH, month);
		return cal;
	}

	/**
	 * 设置日历的 年份值
	 * 
	 * @param cal
	 *            Calendar
	 * @param year
	 *            年份值
	 * @return
	 */
	public static Calendar setYear(Calendar cal, int year) {
		cal.set(Calendar.YEAR, year);
		return cal;
	}

	/**
	 * 设置日期"毫秒"部分的值
	 * 
	 * @param date
	 *            Date
	 * @param milliSecond
	 *            毫秒值
	 * @return
	 */
	public static Date setMilliSecond(Date date, int milliSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setMilliSecond(cal, milliSecond).getTime();
	}

	/**
	 * 设置日期“秒”部分的值
	 * 
	 * @param date
	 *            Date
	 * @param second
	 *            秒值
	 * @return
	 */
	public static Date setSecond(Date date, int second) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setSecond(cal, second).getTime();
	}

	/**
	 * 设置日期“分”部分的值
	 * 
	 * @param date
	 *            Date
	 * @param minute
	 *            分钟值
	 * @return
	 */
	public static Date setMinute(Date date, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setMinute(cal, minute).getTime();
	}

	/**
	 * 设置日期“时”部分的值
	 * 
	 * @param date
	 *            Date
	 * @param hour
	 *            小时值
	 * @return
	 */
	public static Date setHour(Date date, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setHour(cal, hour).getTime();
	}

	/**
	 * 设置日期"日"部分的值
	 * 
	 * @param date
	 *            Date
	 * @param day
	 *            日期值
	 * @return
	 */
	public static Date setDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setDay(cal, day).getTime();
	}

	/**
	 * 设置日期"星期"部分的值
	 * 
	 * @param date
	 *            Date
	 * @param week
	 *            星期值, Calendar.*,Calendar.SUNDAY = 1(星期数+1)
	 * @return
	 */
	public static Date setWeek(Date date, int week) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setWeek(cal, week).getTime();
	}

	/**
	 * 设置日期时间是该年中的第几天
	 * 
	 * @param date
	 *            Date
	 * @param dayOfYear
	 *            该年中的第几天
	 * @return
	 */
	public static Date setDayOfYear(Date date, int dayOfYear) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setDayOfYear(cal, dayOfYear).getTime();
	}

	/**
	 * 设置日期的月份值
	 * 
	 * @param date
	 *            Date
	 * @param month
	 *            月份值,Calendar.JANUARY = 0 (月份-1)
	 * @return
	 */
	public static Date setMonth(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setMonth(cal, month).getTime();
	}

	/**
	 * 设置日期的 年份值
	 * 
	 * @param date
	 *            Date
	 * @param year
	 *            年份值
	 * @return
	 */
	public static Date setYear(Date date, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return setYear(cal, year).getTime();
	}

	/**
	 * 获取系统当前时间日期某个单元的值
	 * 
	 * @param calendarUnit
	 *            日历单元,Calendar.*
	 * @return 周日-周六0-6,一月-十二月1-12
	 */
	public static int getPartOfCurr(int calendarUnit) {
		return getPart(new Date(), calendarUnit);
	}

	/**
	 * 获取时间日期某个单元的值
	 * 
	 * @param date
	 *            日期,不可为null
	 * @param calendarUnit
	 *            日历单元,Calendar.*
	 * @return 周日-周六0-6,一月-十二月1-12
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
	 * 获取日期某部分的实际最小值
	 * 
	 * @param date
	 *            日期,不可为null
	 * @param calendarUnit
	 *            日历单元,Calendar.*
	 * @return
	 */
	public static int actualMin(Date date, int calendarUnit) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMinimum(calendarUnit);
	}

	/**
	 * 获取日期某部分的实际最小值
	 * 
	 * @param date
	 *            日期,不可为null
	 * @param calendarUnit
	 *            日历单元,Calendar.*
	 * @return
	 */
	public static int actualMin(Calendar cal, int calendarUnit) {
		return cal.getActualMinimum(calendarUnit);
	}

	/**
	 * 获取日历某部分的实际最大值
	 * 
	 * @param cal
	 *            日历,不可为null
	 * @param calendarUnit
	 *            日历单元,Calendar.*
	 * @return
	 */
	public static int actualMax(Date date, int calendarUnit) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(calendarUnit);
	}

	/**
	 * 获取日历某部分的实际最大值
	 * 
	 * @param cal
	 *            日历,不可为null
	 * @param calendarUnit
	 *            日历单元,Calendar.*
	 * @return
	 */
	public static int actualMax(Calendar cal, int calendarUnit) {
		return cal.getActualMaximum(calendarUnit);
	}

	/**
	 * 设置时间部分最小值0:0:0.0
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
	 * 设置时间部分最大值23:59:59.999
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
	 * 设置日期和时间部分最小值， 1 0:0:0.0
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar setDayTimeMin(Calendar cal) {
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return setTimeMin(cal);
	}

	/**
	 * 设置日期时间部分最大值， date当月最大日期23:59:59.999
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
	 * 设置月、日期和时间部分最小值，xxxx-1-1 0:0:0.0
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
	 * 设置月、日期和时间部分最大值，xxxx-12-maxDay 23:59:59.999
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
	 * 设置时间部分最小值0:0:0.0
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
	 * 设置时间部分最大值23:59:59.999
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
	 * 设置日期和时间部分最小值， xxxx-x-1-1 0:0:0.0
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
	 * 设置日期和时间部分最大值， date当月最大日期 xxxx-x-maxDay 23:59:59.999
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
	 * 设置月、日期和时间部分最小值，xxxx-1-1 0:0:0.0
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
	 * 设置月、日期和时间部分最大值，xxxx-12-maxDay 23:59:59.999
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
	 * 修改日期
	 * 
	 * @param date
	 *            日期对象
	 * @param year
	 *            年份非负整数，-1忽略该日期单元设置，否则抛异常
	 * @param month
	 *            月份1-12，-1忽略该日期单元设置，否则抛异常
	 * @param day
	 *            日期，1-31，40当月最小值 ，50当月最大值，-1忽略该日期单元设置，否则抛异常
	 * @param hour
	 *            小时，0-23，-1忽略该日期单元设置，否则抛异常
	 * @param min
	 *            分钟0-59，-1忽略该日期单元设置，否则抛异常
	 * @param sec
	 *            秒0-59，-1忽略该日期单元设置，否则抛异常
	 * @param millsec
	 *            毫秒0-999，-1忽略该日期单元设置，否则抛异常
	 * @param fitDayMax
	 *            如果设置的“日”的值超过当月最大值，是否修正为当月最大值，否则把日期向前推进或者抛异常。-1忽略修正，-2修正，-3
	 *            超出范围抛异常，如：某年2月最大日值为28，设置值为30，如果
	 *            F_IGNORE_FIX(-1)则整体日期变为3月2日;F_FIX
	 *            (-2)，则把30修正为28;F_THROWN_EXCEPTION
	 *            (-3)则抛IllegalArgumentException
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
			// 修正日期
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
	 * * 获取两个日期的时间间隔
	 * 
	 * @param startDate
	 * @param endDate
	 * @return *day(s)*hour(s)*minute(s)*second(s)格式字符串
	 * @param startDate
	 * @param endDate
	 * @param chinese
	 *            true返回中文类型字符串，false返回中文字符串
	 * @return
	 */
	public static String intervalString(Date startDate, Date endDate,
			boolean chinese) {
		long milliseconds = endDate.getTime() - startDate.getTime();
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数

		long day = milliseconds / nd;// 计算差多少天
		long hour = milliseconds % nd / nh;// 计算差多少小时
		long min = milliseconds % nd % nh / nm;// 计算差多少分钟
		long sec = milliseconds % nd % nh % nm / ns;// 计算差多少秒//输出结果

		if (chinese) {
			return joinChs(day, hour, min, sec);
		}

		return joinEng(day, hour, min, sec);
	}

	/**
	 * 时间技术中文字符串生成
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
		String unitSec = "0秒";

		// 天时分秒中间补0
		if (day > 0) {
			unitHour = "0小时 ";
			unitMin = "0分 ";
		} else if (hour > 0) {
			unitMin = "0分 ";
		}

		// 单复数区分
		if (day >= 1){
			unitDay = day + "天 ";
		};
		if (hour >= 1){
			unitHour = hour + "小时 ";
		};
		if (min >= 1){
			unitMin = min + "分 ";
		};
		if (sec >= 1){
			unitSec = sec + "秒";
		};
		return new StringBuilder().append(unitDay).append(unitHour)
				.append(unitMin).append(unitSec).toString();

	}

	/**
	 * 时间计数英文字符串生成
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

		// 天时分秒中间补0
		if (day > 0) {
			unitHour = "0 hour ";
			unitMin = "0 minute ";
		} else if (hour > 0) {
			unitMin = "0 minute ";
		}

		// 单复数区分
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
	 * 格式化符合一定格式的日期字符串为Date
	 * 
	 * @param dateStr
	 *            ****(.-/年)*(.-/月)*(.-/日)[ ]*(:时)*(:分)*(.秒)*(毫秒)]格式日期字符串
	 * @param pattern
	 *            null则采用自动判断
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

		// 如果格式化表达式无效则自动判断
		if (DataUtil.isEmpty(pattern, true)) {

			String[] sArr = dateStr.trim().split("|");

			int f1 = 0;// "/"
			int f2 = 0;// "-"
			int f3 = 0;// "yyyy.MM.dd *ss.SSS" f3>=2
			int f4 = 0;// 年月日
			int f5 = 0;// :
			int f6 = 0;// 时分秒
			int f7 = 0;// 毫秒
			for (String s : sArr) {
				if ("/".equals(s)) {
					f1++;
				} else if ("-".equals(s)) {
					f2++;
				} else if (".".equals(s)) {
					f3++;
				} else if ("年".equals(s) || "月".equals(s) || "日".equals(s)) {
					f4++;
				} else if (":".equals(s)) {
					f5++;
				} else if ("时".equals(s) || "分".equals(s) || "秒".equals(s)) {
					f6++;
				} else if ("毫秒".equals(s)) {
					f7++;
				}
			}

			// 日期
			if (f1 == 2) {
				pattern = "yyyy/MM/dd";
			} else if (f2 == 2) {
				pattern = "yyyy-MM-dd";
			} else if (f3 >= 2) {
				pattern = "yyyy.MM.dd";
			} else if (f4 == 3) {
				pattern = "yyyy年MM月dd日";
			}

			// 时间
			if (f5 > 0) {// :
				if (!pattern.isEmpty() && dateStr.trim().contains(" ")) {
					pattern += " ";
				}

				pattern += "HH:mm:ss";
			} else if (f6 > 0) {

				if (!pattern.isEmpty() && dateStr.trim().contains(" ")) {
					pattern += " ";
				}

				pattern += "HH时mm分ss秒";
			}

			// 毫秒
			if (f3 == 1 || f3 == 3) {// .
				pattern += ".SSS";
			} else if (f7 > 0) {
				pattern += "SSS毫秒";
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
