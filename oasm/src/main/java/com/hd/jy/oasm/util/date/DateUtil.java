package com.hd.jy.oasm.util.date;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.util.logging.resources.logging;

public class DateUtil {
	private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();  
    
    private static final Object object = new Object(); 
    
    private static SimpleDateFormat ussdf = new SimpleDateFormat("yyMMdd");
    
    private static SimpleDateFormat cnsdf = new SimpleDateFormat("yy��MM��dd��");
      
    /** 
     * ��ȡSimpleDateFormat 
     * @param pattern ���ڸ�ʽ 
     * @return SimpleDateFormat���� 
     * @throws RuntimeException �쳣���Ƿ����ڸ�ʽ 
     */  
    private static SimpleDateFormat getDateFormat(String pattern) throws RuntimeException {  
        SimpleDateFormat dateFormat = threadLocal.get();  
        if (dateFormat == null) {  
            synchronized (object) {  
                if (dateFormat == null) {  
                    dateFormat = new SimpleDateFormat(pattern);  
                    dateFormat.setLenient(false);  
                    threadLocal.set(dateFormat);  
                }  
            }  
        }  
        dateFormat.applyPattern(pattern);  
        return dateFormat;  
    }  
  
    /** 
     * ��ȡ�����е�ĳ��ֵ�����ȡ�·� 
     * @param date ���� 
     * @param dateType ���ڸ�ʽ 
     * @return ��ֵ 
     */  
    private static int getInteger(Date date, int dateType) {  
        int num = 0;  
        Calendar calendar = Calendar.getInstance();  
        if (date != null) {  
            calendar.setTime(date);  
            num = calendar.get(dateType);  
        }  
        return num;  
    }  
  
    /** 
     * ����������ĳ���͵�ĳ��ֵ������������ 
     * @param date �����ַ��� 
     * @param dateType ���� 
     * @param amount ��ֵ 
     * @return ����������ַ��� 
     */  
    private static String addInteger(String date, int dateType, int amount) {  
        String dateString = null;  
        DateStyle dateStyle = getDateStyle(date);  
        if (dateStyle != null) {  
            Date myDate = StringToDate(date, dateStyle);  
            myDate = addInteger(myDate, dateType, amount);  
            dateString = DateToString(myDate, dateStyle);  
        }  
        return dateString;  
    }  
  
    /** 
     * ����������ĳ���͵�ĳ��ֵ������������ 
     * @param date ���� 
     * @param dateType ���� 
     * @param amount ��ֵ 
     * @return ��������� 
     */  
    private static Date addInteger(Date date, int dateType, int amount) {  
        Date myDate = null;  
        if (date != null) {  
            Calendar calendar = Calendar.getInstance();  
            calendar.setTime(date);  
            calendar.add(dateType, amount);  
            myDate = calendar.getTime();  
        }  
        return myDate;  
    }  
  
    /** 
     * ��ȡ��ȷ������ 
     * @param timestamps ʱ��long���� 
     * @return ���� 
     */  
    private static Date getAccurateDate(List<Long> timestamps) {  
        Date date = null;  
        long timestamp = 0;  
        Map<Long, long[]> map = new HashMap<Long, long[]>();  
        List<Long> absoluteValues = new ArrayList<Long>();  
  
        if (timestamps != null && timestamps.size() > 0) {  
            if (timestamps.size() > 1) {  
                for (int i = 0; i < timestamps.size(); i++) {  
                    for (int j = i + 1; j < timestamps.size(); j++) {  
                        long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));  
                        absoluteValues.add(absoluteValue);  
                        long[] timestampTmp = { timestamps.get(i), timestamps.get(j) };  
                        map.put(absoluteValue, timestampTmp);  
                    }  
                }  
  
                // �п�������ȵ��������2012-11��2012-11-01��ʱ�������ȵġ���ʱminAbsoluteValueΪ0  
                // ��˲��ܽ�minAbsoluteValueȡĬ��ֵ0  
                long minAbsoluteValue = -1;  
                if (!absoluteValues.isEmpty()) {  
                    minAbsoluteValue = absoluteValues.get(0);  
                    for (int i = 1; i < absoluteValues.size(); i++) {  
                        if (minAbsoluteValue > absoluteValues.get(i)) {  
                            minAbsoluteValue = absoluteValues.get(i);  
                        }  
                    }  
                }  
  
                if (minAbsoluteValue != -1) {  
                    long[] timestampsLastTmp = map.get(minAbsoluteValue);  
  
                    long dateOne = timestampsLastTmp[0];  
                    long dateTwo = timestampsLastTmp[1];  
                    if (absoluteValues.size() > 1) {  
                        timestamp = Math.abs(dateOne) > Math.abs(dateTwo) ? dateOne : dateTwo;  
                    }  
                }  
            } else {  
                timestamp = timestamps.get(0);  
            }  
        }  
  
        if (timestamp != 0) {  
            date = new Date(timestamp);  
        }  
        return date;  
    }  
  
    /** 
     * �ж��ַ����Ƿ�Ϊ�����ַ��� 
     * @param date �����ַ��� 
     * @return true or false 
     */  
    public static boolean isDate(String date) {  
        boolean isDate = false;  
        if (date != null) {  
            if (getDateStyle(date) != null) {  
                isDate = true;  
            }  
        }  
        return isDate;  
    }  
  
    /** 
     * ��ȡ�����ַ��������ڷ��ʧ������null�� 
     * @param date �����ַ��� 
     * @return ���ڷ�� 
     */  
    public static DateStyle getDateStyle(String date) {  
        DateStyle dateStyle = null;  
        Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();  
        List<Long> timestamps = new ArrayList<Long>();  
        for (DateStyle style : DateStyle.values()) {  
            if (style.isShowOnly()) {  
                continue;  
            }  
            Date dateTmp = null;  
            if (date != null) {  
                try {  
                    ParsePosition pos = new ParsePosition(0);  
                    dateTmp = getDateFormat(style.getValue()).parse(date, pos);  
                    if (pos.getIndex() != date.length()) {  
                        dateTmp = null;  
                    }  
                } catch (Exception e) {  
                }  
            }  
            if (dateTmp != null) {  
                timestamps.add(dateTmp.getTime());  
                map.put(dateTmp.getTime(), style);  
            }  
        }  
        Date accurateDate = getAccurateDate(timestamps);  
        if (accurateDate != null) {  
            dateStyle = map.get(accurateDate.getTime());  
        }  
        return dateStyle;  
    }  
  
    /** 
     * �������ַ���ת��Ϊ���ڡ�ʧ�ܷ���null�� 
     * @param date �����ַ��� 
     * @return ���� 
     */  
    public static Date StringToDate(String date) {  
        DateStyle dateStyle = getDateStyle(date);  
        return StringToDate(date, dateStyle);  
    }  
  
    /** 
     * �������ַ���ת��Ϊ���ڡ�ʧ�ܷ���null�� 
     * @param date �����ַ��� 
     * @param pattern ���ڸ�ʽ 
     * @return ���� 
     */  
    public static Date StringToDate(String date, String pattern) {  
        Date myDate = null;  
        if (date != null) {  
            try {  
                myDate = getDateFormat(pattern).parse(date);  
            } catch (Exception e) {  
            }  
        }  
        return myDate;  
    }  
  
    /** 
     * �������ַ���ת��Ϊ���ڡ�ʧ�ܷ���null�� 
     * @param date �����ַ��� 
     * @param dateStyle ���ڷ�� 
     * @return ���� 
     */  
    public static Date StringToDate(String date, DateStyle dateStyle) {  
        Date myDate = null;  
        if (dateStyle != null) {  
            myDate = StringToDate(date, dateStyle.getValue());  
        }  
        return myDate;  
    }  
  
    /** 
     * ������ת��Ϊ�����ַ�����ʧ�ܷ���null�� 
     * @param date ���� 
     * @param pattern ���ڸ�ʽ 
     * @return �����ַ��� 
     */  
    public static String DateToString(Date date, String pattern) {  
        String dateString = null;  
        if (date != null) {  
            try {  
                dateString = getDateFormat(pattern).format(date);  
            } catch (Exception e) {  
            }  
        }  
        return dateString;  
    }  
  
    /** 
     * ������ת��Ϊ�����ַ�����ʧ�ܷ���null�� 
     * @param date ���� 
     * @param dateStyle ���ڷ�� 
     * @return �����ַ��� 
     */  
    public static String DateToString(Date date, DateStyle dateStyle) {  
        String dateString = null;  
        if (dateStyle != null) {  
            dateString = DateToString(date, dateStyle.getValue());  
        }  
        return dateString;  
    }  
  
    /** 
     * �������ַ���ת��Ϊ��һ�����ַ�����ʧ�ܷ���null�� 
     * @param date �������ַ��� 
     * @param newPattern �����ڸ�ʽ 
     * @return �������ַ��� 
     */  
    public static String StringToString(String date, String newPattern) {  
        DateStyle oldDateStyle = getDateStyle(date);  
        return StringToString(date, oldDateStyle, newPattern);  
    }  
  
    /** 
     * �������ַ���ת��Ϊ��һ�����ַ�����ʧ�ܷ���null�� 
     * @param date �������ַ��� 
     * @param newDateStyle �����ڷ�� 
     * @return �������ַ��� 
     */  
    public static String StringToString(String date, DateStyle newDateStyle) {  
        DateStyle oldDateStyle = getDateStyle(date);  
        return StringToString(date, oldDateStyle, newDateStyle);  
    }  
  
    /** 
     * �������ַ���ת��Ϊ��һ�����ַ�����ʧ�ܷ���null�� 
     * @param date �������ַ��� 
     * @param olddPattern �����ڸ�ʽ 
     * @param newPattern �����ڸ�ʽ 
     * @return �������ַ��� 
     */  
    public static String StringToString(String date, String olddPattern, String newPattern) {  
        return DateToString(StringToDate(date, olddPattern), newPattern);  
    }  
  
    /** 
     * �������ַ���ת��Ϊ��һ�����ַ�����ʧ�ܷ���null�� 
     * @param date �������ַ��� 
     * @param olddDteStyle �����ڷ�� 
     * @param newParttern �����ڸ�ʽ 
     * @return �������ַ��� 
     */  
    public static String StringToString(String date, DateStyle olddDteStyle, String newParttern) {  
        String dateString = null;  
        if (olddDteStyle != null) {  
            dateString = StringToString(date, olddDteStyle.getValue(), newParttern);  
        }  
        return dateString;  
    }  
  
    /** 
     * �������ַ���ת��Ϊ��һ�����ַ�����ʧ�ܷ���null�� 
     * @param date �������ַ��� 
     * @param olddPattern �����ڸ�ʽ 
     * @param newDateStyle �����ڷ�� 
     * @return �������ַ��� 
     */  
    public static String StringToString(String date, String olddPattern, DateStyle newDateStyle) {  
        String dateString = null;  
        if (newDateStyle != null) {  
            dateString = StringToString(date, olddPattern, newDateStyle.getValue());  
        }  
        return dateString;  
    }  
  
    /** 
     * �������ַ���ת��Ϊ��һ�����ַ�����ʧ�ܷ���null�� 
     * @param date �������ַ��� 
     * @param olddDteStyle �����ڷ�� 
     * @param newDateStyle �����ڷ�� 
     * @return �������ַ��� 
     */  
    public static String StringToString(String date, DateStyle olddDteStyle, DateStyle newDateStyle) {  
        String dateString = null;  
        if (olddDteStyle != null && newDateStyle != null) {  
            dateString = StringToString(date, olddDteStyle.getValue(), newDateStyle.getValue());  
        }  
        return dateString;  
    }  
  
    /** 
     * �������ڵ���ݡ�ʧ�ܷ���null�� 
     * @param date ���� 
     * @param yearAmount ������������Ϊ���� 
     * @return ������ݺ�������ַ��� 
     */  
    public static String addYear(String date, int yearAmount) {  
        return addInteger(date, Calendar.YEAR, yearAmount);  
    }  
  
    /** 
     * �������ڵ���ݡ�ʧ�ܷ���null�� 
     * @param date ���� 
     * @param yearAmount ������������Ϊ���� 
     * @return ������ݺ������ 
     */  
    public static Date addYear(Date date, int yearAmount) {  
        return addInteger(date, Calendar.YEAR, yearAmount);  
    }  
  
    /** 
     * �������ڵ��·ݡ�ʧ�ܷ���null�� 
     * @param date ���� 
     * @param monthAmount ������������Ϊ���� 
     * @return �����·ݺ�������ַ��� 
     */  
    public static String addMonth(String date, int monthAmount) {  
        return addInteger(date, Calendar.MONTH, monthAmount);  
    }  
  
    /** 
     * �������ڵ��·ݡ�ʧ�ܷ���null�� 
     * @param date ���� 
     * @param monthAmount ������������Ϊ���� 
     * @return �����·ݺ������ 
     */  
    public static Date addMonth(Date date, int monthAmount) {  
        return addInteger(date, Calendar.MONTH, monthAmount);  
    }  
  
    /** 
     * �������ڵ�������ʧ�ܷ���null�� 
     * @param date �����ַ��� 
     * @param dayAmount ������������Ϊ���� 
     * @return ����������������ַ��� 
     */  
    public static String addDay(String date, int dayAmount) {  
        return addInteger(date, Calendar.DATE, dayAmount);  
    }  
  
    /** 
     * �������ڵ�������ʧ�ܷ���null�� 
     * @param date ���� 
     * @param dayAmount ������������Ϊ���� 
     * @return ��������������� 
     */  
    public static Date addDay(Date date, int dayAmount) {  
        return addInteger(date, Calendar.DATE, dayAmount);  
    }  
  
    /** 
     * �������ڵ�Сʱ��ʧ�ܷ���null�� 
     * @param date �����ַ��� 
     * @param hourAmount ������������Ϊ���� 
     * @return ����Сʱ��������ַ��� 
     */  
    public static String addHour(String date, int hourAmount) {  
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);  
    }  
  
    /** 
     * �������ڵ�Сʱ��ʧ�ܷ���null�� 
     * @param date ���� 
     * @param hourAmount ������������Ϊ���� 
     * @return ����Сʱ������� 
     */  
    public static Date addHour(Date date, int hourAmount) {  
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);  
    }  
  
    /** 
     * �������ڵķ��ӡ�ʧ�ܷ���null�� 
     * @param date �����ַ��� 
     * @param minuteAmount ������������Ϊ���� 
     * @return ���ӷ��Ӻ�������ַ��� 
     */  
    public static String addMinute(String date, int minuteAmount) {  
        return addInteger(date, Calendar.MINUTE, minuteAmount);  
    }  
  
    /** 
     * �������ڵķ��ӡ�ʧ�ܷ���null�� 
     * @param date ���� 
     * @param dayAmount ������������Ϊ���� 
     * @return ���ӷ��Ӻ������ 
     */  
    public static Date addMinute(Date date, int minuteAmount) {  
        return addInteger(date, Calendar.MINUTE, minuteAmount);  
    }  
  
    /** 
     * �������ڵ����ӡ�ʧ�ܷ���null�� 
     * @param date �����ַ��� 
     * @param dayAmount ������������Ϊ���� 
     * @return �������Ӻ�������ַ��� 
     */  
    public static String addSecond(String date, int secondAmount) {  
        return addInteger(date, Calendar.SECOND, secondAmount);  
    }  
  
    /** 
     * �������ڵ����ӡ�ʧ�ܷ���null�� 
     * @param date ���� 
     * @param dayAmount ������������Ϊ���� 
     * @return �������Ӻ������ 
     */  
    public static Date addSecond(Date date, int secondAmount) {  
        return addInteger(date, Calendar.SECOND, secondAmount);  
    }  
  
    /** 
     * ��ȡ���ڵ���ݡ�ʧ�ܷ���0�� 
     * @param date �����ַ��� 
     * @return ��� 
     */  
    public static int getYear(String date) {  
        return getYear(StringToDate(date));  
    }  
  
    /** 
     * ��ȡ���ڵ���ݡ�ʧ�ܷ���0�� 
     * @param date ���� 
     * @return ��� 
     */  
    public static int getYear(Date date) {  
        return getInteger(date, Calendar.YEAR);  
    }  
  
    /** 
     * ��ȡ���ڵ��·ݡ�ʧ�ܷ���0�� 
     * @param date �����ַ��� 
     * @return �·� 
     */  
    public static int getMonth(String date) {  
        return getMonth(StringToDate(date));  
    }  
  
    /** 
     * ��ȡ���ڵ��·ݡ�ʧ�ܷ���0�� 
     * @param date ���� 
     * @return �·� 
     */  
    public static int getMonth(Date date) {  
        return getInteger(date, Calendar.MONTH) + 1;  
    }  
  
    /** 
     * ��ȡ���ڵ�������ʧ�ܷ���0�� 
     * @param date �����ַ��� 
     * @return �� 
     */  
    public static int getDay(String date) {  
        return getDay(StringToDate(date));  
    }  
  
    /** 
     * ��ȡ���ڵ�������ʧ�ܷ���0�� 
     * @param date ���� 
     * @return �� 
     */  
    public static int getDay(Date date) {  
        return getInteger(date, Calendar.DATE);  
    }  
  
    /** 
     * ��ȡ���ڵ�Сʱ��ʧ�ܷ���0�� 
     * @param date �����ַ��� 
     * @return Сʱ 
     */  
    public static int getHour(String date) {  
        return getHour(StringToDate(date));  
    }  
  
    /** 
     * ��ȡ���ڵ�Сʱ��ʧ�ܷ���0�� 
     * @param date ���� 
     * @return Сʱ 
     */  
    public static int getHour(Date date) {  
        return getInteger(date, Calendar.HOUR_OF_DAY);  
    }  
  
    /** 
     * ��ȡ���ڵķ��ӡ�ʧ�ܷ���0�� 
     * @param date �����ַ��� 
     * @return ���� 
     */  
    public static int getMinute(String date) {  
        return getMinute(StringToDate(date));  
    }  
  
    /** 
     * ��ȡ���ڵķ��ӡ�ʧ�ܷ���0�� 
     * @param date ���� 
     * @return ���� 
     */  
    public static int getMinute(Date date) {  
        return getInteger(date, Calendar.MINUTE);  
    }  
  
    /** 
     * ��ȡ���ڵ����ӡ�ʧ�ܷ���0�� 
     * @param date �����ַ��� 
     * @return ���� 
     */  
    public static int getSecond(String date) {  
        return getSecond(StringToDate(date));  
    }  
  
    /** 
     * ��ȡ���ڵ����ӡ�ʧ�ܷ���0�� 
     * @param date ���� 
     * @return ���� 
     */  
    public static int getSecond(Date date) {  
        return getInteger(date, Calendar.SECOND);  
    }  
  
    /** 
     * ��ȡ���� ��Ĭ��yyyy-MM-dd��ʽ��ʧ�ܷ���null�� 
     * @param date �����ַ��� 
     * @return ���� 
     */  
    public static String getDate(String date) {  
        return StringToString(date, DateStyle.YYYY_MM_DD_HH_MM_SS);  
    }  
  
    /** 
     * ��ȡ���ڡ�Ĭ��yyyy-MM-dd��ʽ��ʧ�ܷ���null�� 
     * @param date ���� 
     * @return ���� 
     */  
    public static String getDate(Date date) {  
        return DateToString(date, DateStyle.YYYY_MM_DD);  
    }  
  
    /** 
     * ��ȡ���ڵ�ʱ�䡣Ĭ��HH:mm:ss��ʽ��ʧ�ܷ���null�� 
     * @param date �����ַ��� 
     * @return ʱ�� 
     */  
    public static String getTime(String date) {  
        return StringToString(date, DateStyle.HH_MM_SS);  
    }  
  
    /** 
     * ��ȡ���ڵ�ʱ�䡣Ĭ��HH:mm:ss��ʽ��ʧ�ܷ���null�� 
     * @param date ���� 
     * @return ʱ�� 
     */  
    public static String getTime(Date date) {  
        return DateToString(date, DateStyle.HH_MM_SS);  
    }  
  
    /** 
     * ��ȡ���ڵ����ڡ�ʧ�ܷ���null�� 
     * @param date �����ַ��� 
     * @return ���� 
     */  
    public static Week getWeek(String date) {  
        Week week = null;  
        DateStyle dateStyle = getDateStyle(date);  
        if (dateStyle != null) {  
            Date myDate = StringToDate(date, dateStyle);  
            week = getWeek(myDate);  
        }  
        return week;  
    }  
  
    /** 
     * ��ȡ���ڵ����ڡ�ʧ�ܷ���null�� 
     * @param date ���� 
     * @return ���� 
     */  
    public static Week getWeek(Date date) {  
        Week week = null;  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;  
        switch (weekNumber) {  
        case 0:  
            week = Week.SUNDAY;  
            break;  
        case 1:  
            week = Week.MONDAY;  
            break;  
        case 2:  
            week = Week.TUESDAY;  
            break;  
        case 3:  
            week = Week.WEDNESDAY;  
            break;  
        case 4:  
            week = Week.THURSDAY;  
            break;  
        case 5:  
            week = Week.FRIDAY;  
            break;  
        case 6:  
            week = Week.SATURDAY;  
            break;  
        }  
        return week;  
    }  
  
    /** 
     * ��ȡ���������������� 
     * @param date �����ַ��� 
     * @param otherDate ��һ�������ַ��� 
     * @return ������������ʧ���򷵻�-1 
     */  
    public static int getIntervalDays(String date, String otherDate) {  
        return getIntervalDays(StringToDate(date), StringToDate(otherDate));  
    }  
  
    /** 
     * @param date ���� 
     * @param otherDate ��һ������ 
     * @return ������������ʧ���򷵻�-1 
     */  
    public static int getIntervalDays(Date date, Date otherDate) {  
        int num = -1;  
        Date dateTmp = DateUtil.StringToDate(DateUtil.getDate(date), DateStyle.YYYY_MM_DD);  
        Date otherDateTmp = DateUtil.StringToDate(DateUtil.getDate(otherDate), DateStyle.YYYY_MM_DD);  
        if (dateTmp != null && otherDateTmp != null) {  
            long time = Math.abs(dateTmp.getTime() - otherDateTmp.getTime());  
            num = (int) (time / (24 * 60 * 60 * 1000));  
        }  
        return num;  
    } 
    //��yyMMdd��ʽ������תΪyy��mm��dd��
    public static String fmtDate(String dateName) throws Exception{
    	String fmtDate = null;
    	try {
			if(null!=dateName&&""!=dateName){
				if(!"000000".equals(dateName)){
					Date parseDate = ussdf.parse(dateName); //��תΪӢ�ĵ�ʱ��
					fmtDate = cnsdf.format(parseDate); //תΪ���ĵ�ʱ��	
				}else{
					fmtDate = "00��00��00��";
				}
				
			}else{
				return "δ֪ʱ���ʽ";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new Exception("����6λ����ʱ���ʽ");
		}
    	return fmtDate;
    }
    public static void main(String[] args) {
		System.out.println(DateUtil.getDate("20171022151630"));
	}
}
