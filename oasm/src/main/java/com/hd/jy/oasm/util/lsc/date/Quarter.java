package com.hd.jy.oasm.util.lsc.date;

import com.hd.jy.oasm.util.lsc.excpts.MismatchException;

/**
 * 对于季度的划分，不同的国家所处地理位置不同划分也不同。 我国大部分地区气候上12-2月为冬季，3-5月为春季，6-8月为夏季，9-11月为秋季。
 * 南半球，巴西新西兰等国与我国冬夏相反，春秋相反，有的国家或地区冬季略长，如北欧国家。 而热带草原气候地区一年分为两个气候季节，旱季雨季。
 * 但在行政或经济统计方面1-3月为第一季度，4-6月为第二季度，以此类推。
 * 
 * @author admin
 *
 */
public enum Quarter {
	QUARTER_1(1, "第一季度", "Quarter 1", "Q1", "First Quarter", "1st Qtr."), 
	QUARTER_2(2, "第二季度", "Quarter 2", "Q2", "Second Quarter", "2nd Qtr."), 
	QUARTER_3(3, "第三季度", "Quarter 3", "Q3", "Third  Quarter", "3rd Qtr."),
	QUARTER_4(4, "第四季度", "Quarter4", "Q4", "Fourth Quarter", "4th Qtr.");
	
	/** 第一季度数值 */
	public final static int IDX_Q1 = 1;
	/** 第二季度数值 */
	public final static int IDX_Q2 = 2;
	/** 第三季度数值 */
	public final static int IDX_Q3 = 3;
	/** 第四季度数值 */
	public final static int IDX_Q4 = 4;

	public final int idx;
	public final String cn;
	public final String en;
	public final String enShort;
	public final String enOrdered;
	public final String enOrderedShort;

	/**
	 * @param idx
	 * @param cn
	 * @param en
	 * @param enShort
	 * @param enOrdered
	 * @param enOrderedShort
	 */
	private Quarter(int idx, String cn, String en, String enShort,
			String enOrdered, String enOrderedShort) {
		this.idx = idx;
		this.cn = cn;
		this.en = en;
		this.enShort = enShort;
		this.enOrdered = enOrdered;
		this.enOrderedShort = enOrderedShort;
	}

	/**
	 * 
	 * @param month
	 *            月份对应数值，1-12月即1-12
	 * @param northHemisphere
	 *            是否是北半球，如中国
	 * @return
	 */
	public static Quarter getByMonth(int month) {

		if (month < 1 || month > 12) {
			throw new MismatchException("month", month,
					"value of month must be 1<=month<=12");
		}

		if (month / 4 == 0) {
			return QUARTER_1;
		} else if (month / 4 == 1) {
			return QUARTER_2;
		} else if (month / 4 == 2) {
			return QUARTER_3;
		} else {// if (month / 4 == 3)
			return QUARTER_4;
		}
	}

	public static Quarter getByIdx(int quarterIdx) {
		switch (quarterIdx) {
		case IDX_Q1:
			return QUARTER_1;

		case IDX_Q2:
			return QUARTER_2;

		case IDX_Q3:
			return QUARTER_3;

		case IDX_Q4:
			return QUARTER_4;

		default:
			throw new MismatchException("quarterIdx", quarterIdx,
					"only value of Quarter.IDX_* is available.");
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{idxNum:" + idx + ", " + cn + ", "
				+ en + ", " + enShort + enOrdered + ", " + enOrderedShort + "}";
	}
}
