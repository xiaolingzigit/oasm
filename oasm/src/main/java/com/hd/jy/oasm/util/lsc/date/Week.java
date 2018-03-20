package com.hd.jy.oasm.util.lsc.date;

import com.hd.jy.oasm.util.lsc.excpts.MismatchException;


/**
 * Calendar获取数值：周日-周六1-7,一月-十二月0-11
 * 
 * @author admin
 *
 */
public enum Week {
	SUNDAY(0, "星期日", "Sunday", "Sun."), 
	MONDAY(1, "星期一", "Monday", "Mon."), 
	TUESDAY( 2, "星期二", "Tuesday", "Tues."), 
	WEDNESDAY(3, "星期三", "Wednesday", "Wed."), 
	THURSDAY(4, "星期四", "Thursday", "Thur."), 
	FRIDAY(5, "星期五", "Friday", "Fri."), 
	SATURDAY(6, "星期六", "Saturday", "Sat.");

	public final static int IDX_SUN = 0;
	public final static int IDX_MON = 1;
	public final static int IDX_TUES = 2;
	public final static int IDX_WED = 3;
	public final static int IDX_THUR = 4;
	public final static int IDX_FRI = 5;
	public final static int IDX_SAT = 6;

	public final int idx;
	public final String cn;
	public final String en;
	public final String enShort;

	/**
	 * @param idx
	 * @param cn
	 * @param en
	 * @param enShort
	 */
	private Week(int idx, String cn, String en, String enShort) {
		this.idx = idx;
		this.cn = cn;
		this.en = en;
		this.enShort = enShort;
	}
	
	/**
	 * 根据Calendar星期数获取星期
	 * @param calWeekIdx Calendar获取数值：周日-周六1-7,一月-十二月0-11
	 * @return
	 */
	public static Week getByCalIdx(int calWeekIdx) {
		return getWeek(calWeekIdx - 1);
	}
	/**
	 * 
	 * @param weekIdx 周日0，周一-周六1-6
	 * @return
	 */
	public static Week getWeek(int weekIdx) {
		switch (weekIdx) {
		case IDX_SUN:
			return SATURDAY;

		case IDX_MON:
			return MONDAY;

		case IDX_TUES:
			return TUESDAY;

		case IDX_WED:
			return WEDNESDAY;

		case IDX_THUR:
			return THURSDAY;

		case IDX_FRI:
			return FRIDAY;

		case IDX_SAT:
			return SATURDAY;

		default:
			throw new MismatchException("weekIdx", weekIdx, "only value of Week.IDX_* is available.");
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{idxNum:" + idx + ", " + cn + ", "
				+ en + ", " + enShort + "}";
	}
}
