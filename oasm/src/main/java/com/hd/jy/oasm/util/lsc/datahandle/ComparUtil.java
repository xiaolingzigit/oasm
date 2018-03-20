package com.hd.jy.oasm.util.lsc.datahandle;

import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.RegexUtil;
import com.hd.jy.oasm.util.lsc.excpts.IllegalException;

/**
 * 数学关系处理工具
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

	/** 只有一个比较符号的表达式，占位符在左 */
	public static final String REGEX_SINGLE_PH_LEFT = REGEX_PLACE_HOLDER
			+ REGEX_COMPARE_SYMB + REGEX_PLACE_NUM;
	/** 只有一个比较符号的表达式，占位符在右 */
	public static final String REGEX_SINGLE_PH_RIGHT = REGEX_PLACE_NUM
			+ REGEX_COMPARE_SYMB + REGEX_PLACE_HOLDER;
	/** 只有一个比较符号的表达式，只有一边是数字 */
	public static final String REGEX_SINGLE_PH_ONE_SIDE = "("
			+ REGEX_SINGLE_PH_LEFT + ")|(" + REGEX_SINGLE_PH_RIGHT + ")";

	/** 类似4>B>=3的接连比较表达式 */
	public static final String REGEX_LINK_G = REGEX_PLACE_NUM
			+ REGEX_COMPARE_SYMB_G + REGEX_PLACE_HOLDER + REGEX_COMPARE_SYMB_G
			+ REGEX_PLACE_NUM;
	/** 类似4<B<3的接连比较表达式 */
	public static final String REGEX_LINK_L = REGEX_PLACE_NUM
			+ REGEX_COMPARE_SYMB_L + REGEX_PLACE_HOLDER + REGEX_COMPARE_SYMB_L
			+ REGEX_PLACE_NUM;

	/**
	 * 判断数值是否满足数学比较表达式条件。
	 *
	 * 支持的比较符号：>,<,=,>=,<=
	 *
	 * 支持的表达式格式： (1)t<100; (2) t<=10 | t>100; (3)t>1 & t<3; (4) 1<t<3 | t>5
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
					// 直接处理
					and = and && isSingleComparFit(subAndExpr, val);

				} else if (exprType == TYPE_LINK_PH_CENTER_G
						|| exprType == TYPE_LINK_PH_CENTER_L) {
					// 分为两段处理
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
	 * 判断一个数是否满足单比较符比较表达式的条件(占位符只能字母开头，可以含有数字)
	 * 
	 * @param singleComparExpr
	 *            比较表达式中只能包含大小写字母，>, <, =, >=, <= 和负号
	 * @param val
	 *            比较值
	 * @return
	 */
	public static boolean isSingleComparFit(String singleComparExpr, double val) {
		ExprEle ele = getExprEle(singleComparExpr);
		return isFit(ele.comparSymb, val, ele.val);
	}

	/**
	 * 根据比较符号,比较两个数值的大小
	 * 
	 * @param comparSymbol
	 *            ComparUtil.CS_* 比较符号>=,<=,>,<,=
	 * @param valLeft
	 *            比较符号左边的值
	 * @param valRight
	 *            比较符号右边的值
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
	 * 获取单比较符号表达式，转化成x>30这种占位符在左的形式后，的比较符号，参考值和符号的开口朝向
	 * 
	 * @param singleComparExpr
	 * @return 
	 *         ExprEle。ExprEle.comparFlag：-1,LOWER(<=,<);0,EQUAL(=);1,UPPER(>=,>)
	 * @throws IllegalArgumentException
	 *             占位符只能是字母开头，可以数字结尾,不符合要求的表达式将抛异常
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

	/** 只有一个比较符号的表达式，占位符在左 */
	private static final int TYPE_SINGLE_PH_LEFT = 11;
	/** 只有一个比较符号的表达式，占位符在右 */
	private static final int TYPE_SINGLE_PH_RIGHT = 12;

	/** 类似4>=B>3的接连比较表达式,占位符在中间 */
	private static final int TYPE_LINK_PH_CENTER_G = 21;
	/** 类似4<B<3的接连比较表达式,占位符在中间 */
	private static final int TYPE_LINK_PH_CENTER_L = 22;

	/**
	 * 判断比较表达式形式
	 * 
	 * @param comparExpr
	 *            只含有一个占位符的数学比较表达式，如下：x>3;1<=x<5; x>2,x<1。比较表达式中只能包含大小写字母，>, <,
	 *            =, >=, <= 和负号
	 * @return 见本类TYPE_*.
	 * @throws IllegalArgumentException
	 *             占位符只能是字母开头，可以数字结尾,不符合要求的表达式将抛异常
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
	 * 获取比较表达式中的数字和占位符数组
	 * 
	 * @param comparExpr
	 *            只含有一个占位符的数学比较表达式，如下：x>3;1<=x<5; x>2,x<1。比较表达式中只能包含大小写字母，>, <,
	 *            =, >=, <= 和负号
	 * @return
	 * @throws IllegalArgumentException
	 *             占位符只能是字母开头，可以数字结尾,不符合要求的表达式将抛异常
	 */
	private static String[] getNumPlaceHolderArr(String comparExpr) {
		return comparExpr.replaceAll("[>=|<=|><=]+", BLANK).trim().split(BLANK);
	}

	/** 单个空白字符串 */
	private static final String BLANK = " ";

	/**
	 * 获取比较表达式中的占位符数组
	 * 
	 * @param singleComparExpr
	 *            数学比较表达式，如下：x>3;1<=x<5;
	 * @return
	 * @throws IllegalArgumentException
	 *             占位符只能是字母开头，可以数字结尾,不符合要求的表达式将抛异常
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
	 * 获取单比较符比较表达式中的参考数值(占位符只能字母开头，可以含有数字)
	 * 
	 * @param singleComparExpr
	 *            比较表达式中只能包含大小写字母，>, <, =, >=, <= 和负号
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
	 * 数学比较关系符号(>, <, =, >=, <=)翻转,turn comparSymb over
	 * 
	 * @param s
	 * @return
	 * @throws IllegalArgumentException
	 *             输入字符只能是>, <, =, >=或<=，否则抛异常
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
	 * 单比较符号表达式，转化成占位符在左格式（如x>30）后的元素：比较符号，参考数值，比较符号类型
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
