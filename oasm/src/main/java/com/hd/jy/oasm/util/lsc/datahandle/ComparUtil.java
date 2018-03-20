package com.hd.jy.oasm.util.lsc.datahandle;

import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.RegexUtil;
import com.hd.jy.oasm.util.lsc.excpts.IllegalException;

/**
 * ��ѧ��ϵ������
 * 
 * @author admin
 *
 */
public class ComparUtil {

	public static final String CS_G = ">";
	public static final String CS_L = "<";
	public static final String CS_E = "=";
	public static final String CS_GE = ">=";
	public static final String CS_LE = "<=";

	private static final String CS_SHOW = ">, <, =, >=, <=";
	public static final String REGEX_COMPARE_SYMB = "(>=|<=|>|<|=)";
	public static final String REGEX_COMPARE_SYMB_G = "(>|>=|=)";
	public static final String REGEX_COMPARE_SYMB_L = "(<|<=|=)";

	public static final String REGEX_PLACE_HOLDER = "([a-zA-Z]+([a-zA-Z0-9]+)?)";
	public static final String REGEX_PLACE_NUM = "(-?[0-9]+(.[0-9]+)?)";

	/** ֻ��һ���ȽϷ��ŵı��ʽ��ռλ������ */
	public static final String REGEX_SINGLE_PH_LEFT = REGEX_PLACE_HOLDER
			+ REGEX_COMPARE_SYMB + REGEX_PLACE_NUM;
	/** ֻ��һ���ȽϷ��ŵı��ʽ��ռλ������ */
	public static final String REGEX_SINGLE_PH_RIGHT = REGEX_PLACE_NUM
			+ REGEX_COMPARE_SYMB + REGEX_PLACE_HOLDER;
	/** ֻ��һ���ȽϷ��ŵı��ʽ��ֻ��һ�������� */
	public static final String REGEX_SINGLE_PH_ONE_SIDE = "("
			+ REGEX_SINGLE_PH_LEFT + ")|(" + REGEX_SINGLE_PH_RIGHT + ")";

	/** ����4>B>=3�Ľ����Ƚϱ��ʽ */
	public static final String REGEX_LINK_G = REGEX_PLACE_NUM
			+ REGEX_COMPARE_SYMB_G + REGEX_PLACE_HOLDER + REGEX_COMPARE_SYMB_G
			+ REGEX_PLACE_NUM;
	/** ����4<B<3�Ľ����Ƚϱ��ʽ */
	public static final String REGEX_LINK_L = REGEX_PLACE_NUM
			+ REGEX_COMPARE_SYMB_L + REGEX_PLACE_HOLDER + REGEX_COMPARE_SYMB_L
			+ REGEX_PLACE_NUM;

	/**
	 * �ж���ֵ�Ƿ�������ѧ�Ƚϱ��ʽ������
	 *
	 * ֧�ֵıȽϷ��ţ�>,<,=,>=,<=
	 *
	 * ֧�ֵı��ʽ��ʽ�� (1)t<100; (2) t<=10 | t>100; (3)t>1 & t<3; (4) 1<t<3 | t>5
	 *
	 * @param comparExpr
	 * @param val
	 * @return
	 */
	public static boolean isFit(String comparExpr, double val)
			throws IllegalException {

		comparExpr = DataUtil.trimBlank(comparExpr);
		comparExpr = DataUtil.replaceAll(comparExpr, "&+", "&");
		comparExpr = DataUtil.replaceAll(comparExpr, "\\|+", "|");

		boolean or = false;
		String[] subOrExprs = comparExpr.split("\\|");

		for (String subOrExpr : subOrExprs) {

			String[] subAndExprs = subOrExpr.split("&");
			boolean and = subAndExprs.length == 0 ? false : true;

			for (String subAndExpr : subAndExprs) {
				int exprType = getExprType(subAndExpr);

				if (exprType == TYPE_SINGLE_PH_LEFT
						|| exprType == TYPE_SINGLE_PH_RIGHT) {
					// ֱ�Ӵ���
					and = and && isSingleComparFit(subAndExpr, val);

				} else if (exprType == TYPE_LINK_PH_CENTER_G
						|| exprType == TYPE_LINK_PH_CENTER_L) {
					// ��Ϊ���δ���
					String ph = getPlaceHolder(subAndExpr);
					String[] tmpStrings = subAndExpr.split(ph);

					for (int i = 0; i < tmpStrings.length; i++) {
						and = and
								&& isSingleComparFit(
										(i % 2 == 0 ? tmpStrings[i] + ph : ph
												+ tmpStrings[i]), val);
					}

				} else {
					throw new IllegalException("comparExpr", comparExpr, "");
				}
			}

			or = or || and;
		}

		return or;
	}

	/**
	 * �ж�һ�����Ƿ����㵥�ȽϷ��Ƚϱ��ʽ������(ռλ��ֻ����ĸ��ͷ�����Ժ�������)
	 * 
	 * @param singleComparExpr
	 *            �Ƚϱ��ʽ��ֻ�ܰ�����Сд��ĸ��>, <, =, >=, <= �͸���
	 * @param val
	 *            �Ƚ�ֵ
	 * @return
	 */
	public static boolean isSingleComparFit(String singleComparExpr, double val) {
		ExprEle ele = getExprEle(singleComparExpr);
		return isFit(ele.comparSymb, val, ele.val);
	}

	/**
	 * ���ݱȽϷ���,�Ƚ�������ֵ�Ĵ�С
	 * 
	 * @param comparSymbol
	 *            ComparUtil.CS_* �ȽϷ���>=,<=,>,<,=
	 * @param valLeft
	 *            �ȽϷ�����ߵ�ֵ
	 * @param valRight
	 *            �ȽϷ����ұߵ�ֵ
	 * @return
	 */
	public static boolean isFit(String comparSymbol, double valLeft,
			double valRight) {

		switch (DataUtil.trimBlank(comparSymbol)) {
		case CS_GE:

			if (valLeft >= valRight) {
				return true;
			} else {
				return false;
			}
		case CS_LE:

			if (valLeft <= valRight) {
				return true;
			} else {
				return false;
			}
		case CS_E:

			if (valLeft == valRight) {
				return true;
			} else {
				return false;
			}
		case CS_G:

			if (valLeft > valRight) {
				return true;
			} else {
				return false;
			}
		case CS_L:

			if (valLeft < valRight) {
				return true;
			} else {
				return false;
			}

		default:
			throw new IllegalArgumentException("only " + CS_SHOW
					+ " is available for compare Symbol. input: "
					+ comparSymbol);
		}
	}

	/**
	 * ��ȡ���ȽϷ��ű��ʽ��ת����x>30����ռλ���������ʽ�󣬵ıȽϷ��ţ��ο�ֵ�ͷ��ŵĿ��ڳ���
	 * 
	 * @param singleComparExpr
	 * @return 
	 *         ExprEle��ExprEle.comparFlag��-1,LOWER(<=,<);0,EQUAL(=);1,UPPER(>=,>)
	 * @throws IllegalArgumentException
	 *             ռλ��ֻ������ĸ��ͷ���������ֽ�β,������Ҫ��ı��ʽ�����쳣
	 */
	public static ExprEle getExprEle(String singleComparExpr)
			throws IllegalArgumentException {

		String comparSymb;
		double val;
		switch (getExprType(singleComparExpr)) {
		case TYPE_SINGLE_PH_LEFT:

			comparSymb = singleComparExpr.replaceAll("[a-zA-Z0-9.-]+", "")
					.trim();
			val = DataUtil.toDouble(getNum(singleComparExpr));
			break;

		case TYPE_SINGLE_PH_RIGHT:
			comparSymb = turnComparSymb(singleComparExpr.replaceAll(
					"[a-zA-Z0-9.-]+", "").trim());
			val = DataUtil.toDouble(getNum(singleComparExpr));
			break;

		default:
			throw new IllegalArgumentException("input String["
					+ singleComparExpr + "] is not a single compare expression");
		}

		return new ExprEle(comparSymb, val);
	}

	/** ֻ��һ���ȽϷ��ŵı��ʽ��ռλ������ */
	private static final int TYPE_SINGLE_PH_LEFT = 11;
	/** ֻ��һ���ȽϷ��ŵı��ʽ��ռλ������ */
	private static final int TYPE_SINGLE_PH_RIGHT = 12;

	/** ����4>=B>3�Ľ����Ƚϱ��ʽ,ռλ�����м� */
	private static final int TYPE_LINK_PH_CENTER_G = 21;
	/** ����4<B<3�Ľ����Ƚϱ��ʽ,ռλ�����м� */
	private static final int TYPE_LINK_PH_CENTER_L = 22;

	/**
	 * �жϱȽϱ��ʽ��ʽ
	 * 
	 * @param comparExpr
	 *            ֻ����һ��ռλ������ѧ�Ƚϱ��ʽ�����£�x>3;1<=x<5; x>2,x<1���Ƚϱ��ʽ��ֻ�ܰ�����Сд��ĸ��>, <,
	 *            =, >=, <= �͸���
	 * @return ������TYPE_*.
	 * @throws IllegalArgumentException
	 *             ռλ��ֻ������ĸ��ͷ���������ֽ�β,������Ҫ��ı��ʽ�����쳣
	 */
	private static int getExprType(String comparExpr)
			throws IllegalArgumentException {
		if (RegexUtil.isMatches(REGEX_SINGLE_PH_LEFT, comparExpr)) {
			return TYPE_SINGLE_PH_LEFT;

		} else if (RegexUtil.isMatches(REGEX_SINGLE_PH_RIGHT, comparExpr)) {
			return TYPE_SINGLE_PH_RIGHT;

		} else if (RegexUtil.isMatches(REGEX_LINK_G, comparExpr)) {
			return TYPE_LINK_PH_CENTER_G;

		} else if (RegexUtil.isMatches(REGEX_LINK_L, comparExpr)) {
			return TYPE_LINK_PH_CENTER_L;

		} else {
			throw new IllegalArgumentException("expression input[" + comparExpr
					+ ")] is illegal.");
		}
	}

	/**
	 * ��ȡ�Ƚϱ��ʽ�е����ֺ�ռλ������
	 * 
	 * @param comparExpr
	 *            ֻ����һ��ռλ������ѧ�Ƚϱ��ʽ�����£�x>3;1<=x<5; x>2,x<1���Ƚϱ��ʽ��ֻ�ܰ�����Сд��ĸ��>, <,
	 *            =, >=, <= �͸���
	 * @return
	 * @throws IllegalArgumentException
	 *             ռλ��ֻ������ĸ��ͷ���������ֽ�β,������Ҫ��ı��ʽ�����쳣
	 */
	private static String[] getNumPlaceHolderArr(String comparExpr) {
		return comparExpr.replaceAll("[>=|<=|><=]+", BLANK).trim().split(BLANK);
	}

	/** �����հ��ַ��� */
	private static final String BLANK = " ";

	/**
	 * ��ȡ�Ƚϱ��ʽ�е�ռλ������
	 * 
	 * @param singleComparExpr
	 *            ��ѧ�Ƚϱ��ʽ�����£�x>3;1<=x<5;
	 * @return
	 * @throws IllegalArgumentException
	 *             ռλ��ֻ������ĸ��ͷ���������ֽ�β,������Ҫ��ı��ʽ�����쳣
	 */
	private static String getPlaceHolder(String singleComparExpr)
			throws IllegalException {
		for (String s : getNumPlaceHolderArr(singleComparExpr)) {
			if (RegexUtil.isMatches(REGEX_PLACE_HOLDER, s)) {
				return s;
			}
		}
		throw new IllegalException("singleComparExpr", singleComparExpr,
				"number not found");
	}

	/**
	 * ��ȡ���ȽϷ��Ƚϱ��ʽ�еĲο���ֵ(ռλ��ֻ����ĸ��ͷ�����Ժ�������)
	 * 
	 * @param singleComparExpr
	 *            �Ƚϱ��ʽ��ֻ�ܰ�����Сд��ĸ��>, <, =, >=, <= �͸���
	 * @return
	 */
	private static String getNum(String singleComparExpr) {
		for (String s : getNumPlaceHolderArr(singleComparExpr)) {
			if (RegexUtil.isNum(s)) {
				return s;
			}
		}

		throw new IllegalException("singleComparExpr", singleComparExpr,
				"number not found");
	}

	/**
	 * ��ѧ�ȽϹ�ϵ����(>, <, =, >=, <=)��ת,turn comparSymb over
	 * 
	 * @param s
	 * @return
	 * @throws IllegalArgumentException
	 *             �����ַ�ֻ����>, <, =, >=��<=���������쳣
	 */
	private static String turnComparSymb(String comparSymbol) {

		switch (comparSymbol) {
		case CS_G:
			return CS_L;

		case CS_L:
			return CS_G;

		case CS_E:
			return CS_E;

		case CS_GE:
			return CS_LE;

		case CS_LE:
			return CS_GE;

		default:
			throw new IllegalArgumentException("only " + CS_SHOW
					+ " is available. input: " + comparSymbol);
		}
	}

	/**
	 * ���ȽϷ��ű��ʽ��ת����ռλ�������ʽ����x>30�����Ԫ�أ��ȽϷ��ţ��ο���ֵ���ȽϷ�������
	 * 
	 * @author admin
	 *
	 */
	public static class ExprEle {
		private String comparSymb;
		private double val;

		public ExprEle(String comparSymb, double val) {
			this.comparSymb = comparSymb;
			this.val = val;
		}

		public String comparSymb() {
			return comparSymb;
		}

		public double val() {
			return val;
		}

		@Override
		public String toString() {
			return "comparSymb=" + comparSymb + ", val=" + val;
		}
	}
}
