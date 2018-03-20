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
public enum Quarter {
	QUARTER_1(1, "��һ����", "Quarter 1", "Q1", "First Quarter", "1st Qtr."), 
	QUARTER_2(2, "�ڶ�����", "Quarter 2", "Q2", "Second Quarter", "2nd Qtr."), 
	QUARTER_3(3, "��������", "Quarter 3", "Q3", "Third  Quarter", "3rd Qtr."),
	QUARTER_4(4, "���ļ���", "Quarter4", "Q4", "Fourth Quarter", "4th Qtr.");
	
	/** ��һ������ֵ */
	public final static int IDX_Q1 = 1;
	/** �ڶ�������ֵ */
	public final static int IDX_Q2 = 2;
	/** ����������ֵ */
	public final static int IDX_Q3 = 3;
	/** ���ļ�����ֵ */
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
	 *            �·ݶ�Ӧ��ֵ��1-12�¼�1-12
	 * @param northHemisphere
	 *            �Ƿ��Ǳ��������й�
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
