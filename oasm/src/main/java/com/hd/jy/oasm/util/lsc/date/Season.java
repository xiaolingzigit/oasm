package com.hd.jy.oasm.util.lsc.date;

import com.hd.jy.oasm.util.lsc.excpts.MismatchException;

/**
 * ���ڼ��ȵĻ��֣���ͬ�Ĺ�����������λ�ò�ͬ����Ҳ��ͬ�� �ҹ��󲿷ֵ���������12-2��Ϊ������3-5��Ϊ������6-8��Ϊ�ļ���9-11��Ϊ�＾��
 * �ϰ��򣬰����������ȹ����ҹ������෴�������෴���еĹ��һ���������Գ����籱ŷ���ҡ� ���ȴ���ԭ�������һ���Ϊ�������򼾽ڣ������꼾��
 * ���������򾭼�ͳ�Ʒ���1-3��Ϊ��һ���ȣ�4-6��Ϊ�ڶ����ȣ��Դ����ơ�
 * 
 * @author admin
 *
 */
public enum Season {
	SPRING(1, "����", "Spring", "Spr."), SUNNER(2, "�ļ�", "Summer", "Sum."), AUTUMN(
			3, "�＾", "Autumn", "Aut."), WINTER(4, "����", "Winter", "Win.");

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
	 * ��ȡ�·ݶ�Ӧ�ļ��ڡ����ڼ��ȵĻ��֣���ͬ�Ĺ�����������λ�ò�ͬ����Ҳ��ͬ�� �ҹ��󲿷ֵ���������12-2��Ϊ������3-5��Ϊ������6-8��Ϊ�ļ���9-11��Ϊ�＾��
	 * �ϰ��򣬰����������ȹ����ҹ������෴�������෴��
	 * @param month �·ݶ�Ӧ��ֵ
	 * @param northHemisphere
	 *            �Ƿ��Ǳ��������й�
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
	 * @param seasonIdx ��-��1-4
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
