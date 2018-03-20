package com.hd.jy.oasm.util.lsc.date;

import com.hd.jy.oasm.util.lsc.excpts.MismatchException;


/**
 * Calendar��ȡ��ֵ������-����1-7,һ��-ʮ����0-11
 * 
 * @author admin
 *
 */
public enum Week {
	SUNDAY(0, "������", "Sunday", "Sun."), 
	MONDAY(1, "����һ", "Monday", "Mon."), 
	TUESDAY( 2, "���ڶ�", "Tuesday", "Tues."), 
	WEDNESDAY(3, "������", "Wednesday", "Wed."), 
	THURSDAY(4, "������", "Thursday", "Thur."), 
	FRIDAY(5, "������", "Friday", "Fri."), 
	SATURDAY(6, "������", "Saturday", "Sat.");

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
	 * ����Calendar��������ȡ����
	 * @param calWeekIdx Calendar��ȡ��ֵ������-����1-7,һ��-ʮ����0-11
	 * @return
	 */
	public static Week getByCalIdx(int calWeekIdx) {
		return getWeek(calWeekIdx - 1);
	}
	/**
	 * 
	 * @param weekIdx ����0����һ-����1-6
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
