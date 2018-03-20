package com.hd.jy.oasm.util.lsc.date;

import com.hd.jy.oasm.util.lsc.excpts.MismatchException;

/** Calendar��ȡ��ֵ������-����1-7,һ��-ʮ����0-11 */
public enum Month {
	JANUARY(1, "һ��", "January", "Jan."), 
	FEBRUARY(2, "����", "February", "Feb."), 
	MARCH(3, "����", "March", "Mar."), 
	APRIL(4, "����", "April", "Apr."), 
	MAY(5, "����", "May", "May."), 
	JUNE(6, "����", "June", "Jun."), //june.
	JULY(7, "����", "July", "Jul."), //july.
	AUGUST(8, "����", "August", "Aug."), 
	SEPTEMBER(9, "����", "September", "Sep."), //sept.
	OCTOBER(10, "ʮ��", "October", "Oct."), 
	NOVEMBER( 11, "ʮһ��", "November", "Nov."), 
	DECEMBER(12, "ʮ����", "December", "Dec.");

	public final static int IDX_JAN = 1;
	public final static int IDX_FEB = 2;
	public final static int IDX_MAR = 3;
	public final static int IDX_APR = 4;
	public final static int IDX_MAY = 5;
	public final static int IDX_JUN = 6;
	public final static int IDX_JUL = 7;
	public final static int IDX_AUG = 8;
	public final static int IDX_SEP = 9;
	public final static int IDX_OCT = 10;
	public final static int IDX_NOV = 11;
	public final static int IDX_DEC = 12;

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
	private Month(int idx, String cn, String en, String enShort) {
		this.idx = idx;
		this.cn = cn;
		this.en = en;
		this.enShort = enShort;
	}

	/**
	 * ����Calendar�·�����ȡ�·�
	 * @param calMonIdx Calendar��ȡ��ֵ������-����1-7,һ��-ʮ����0-11
	 * @return
	 */
	public static Month getByCalIdx(int calMonIdx) {
		return getMonth(calMonIdx + 1);
	}
	
	/**
	 * 
	 * @param monthIdx 1-12�¼�1-12
	 * @return
	 */
	public static Month getMonth(int monthIdx) {
		switch (monthIdx) {
		case IDX_JAN:
			return JANUARY;

		case IDX_FEB:
			return FEBRUARY;

		case IDX_MAR:
			return MARCH;

		case IDX_APR:
			return APRIL;

		case IDX_MAY:
			return MAY;

		case IDX_JUN:
			return JUNE;

		case IDX_JUL:
			return JULY;

		case IDX_AUG:
			return AUGUST;
			
		case IDX_SEP:
			return SEPTEMBER;
			
		case IDX_OCT:
			return OCTOBER;
			
		case IDX_NOV:
			return NOVEMBER;
			
		case IDX_DEC:
			return DECEMBER;
			
		default:
			throw new MismatchException("monthIdx", monthIdx, "only value of Month.IDX_* is available.");
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{idxNum:" + idx + ", " + cn + ", "
				+ en + ", " + enShort + "}";
	}

}
