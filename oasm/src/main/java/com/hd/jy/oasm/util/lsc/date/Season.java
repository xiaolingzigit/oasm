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
public enum Season {
	SPRING(1, "春季", "Spring", "Spr."), SUNNER(2, "夏季", "Summer", "Sum."), AUTUMN(
			3, "秋季", "Autumn", "Aut."), WINTER(4, "冬季", "Winter", "Win.");

	public final static int IDX_SPRING = 1;
	public final static int IDX_SUMMER = 2;
	public final static int IDX_AUTUMN = 3;
	public final static int IDX_WINTER = 4;

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
	private Season(int idx, String cn, String en, String enShort) {
		this.idx = idx;
		this.cn = cn;
		this.en = en;
		this.enShort = enShort;
	}

	/**
	 * 获取月份对应的季节。对于季度的划分，不同的国家所处地理位置不同划分也不同。 我国大部分地区气候上12-2月为冬季，3-5月为春季，6-8月为夏季，9-11月为秋季。
	 * 南半球，巴西新西兰等国与我国冬夏相反，春秋相反。
	 * @param month 月份对应数值
	 * @param northHemisphere
	 *            是否是北半球，如中国
	 * @return
	 */
	public static Season getByMonth(int month, boolean northHemisphere) {
		Season season = null;
		if (month >= Month.IDX_MAR && month <= Month.IDX_MAY) {
			season = northHemisphere ? SPRING : AUTUMN;
		} else if (month >= Month.IDX_JUN && month <= Month.IDX_AUG) {
			season = northHemisphere ? SUNNER : WINTER;
		} else if (month >= Month.IDX_SEP && month <= Month.IDX_NOV) {
			season = northHemisphere ? AUTUMN : SPRING;
		} else if (month == Month.IDX_SEP || month == Month.IDX_JAN
				|| month == Month.IDX_FEB) {
			season = northHemisphere ? WINTER : SUNNER;
		}else{
			throw new MismatchException("month", month, "only value of Month.IDX_* is available.");
		}

		return season;
	}
	
	/**
	 * 
	 * @param seasonIdx 春-冬1-4
	 * @return
	 */
	public static Season getByIdx(int seasonIdx) {
		switch (seasonIdx) {
		case IDX_SPRING:
			return SPRING;
			
		case IDX_SUMMER:
			return SUNNER;
			
		case IDX_AUTUMN:
			return AUTUMN;
			
		case IDX_WINTER:
			return WINTER;

		default:
			throw new MismatchException("seasonIdx", seasonIdx, "only value of Season.IDX_* is available.");
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{idxNum:" + idx + ", " + cn + ", "
				+ en + ", " + enShort + "}";
	}

}
