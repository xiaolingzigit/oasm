package com.hd.jy.oasm.util.lsc.datahandle;

import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.RegexUtil;
import com.hd.jy.oasm.util.lsc.excpts.IllegalException;
import com.hd.jy.oasm.util.lsc.excpts.NullException;

/**
 * ���ݴ���ģ��
 * 
 * @author admin
 *
 */
public class RelatHandler {
	
	// 3���಼����ϵ���㣨���� t0 f1 fasle0 true1 ��
	// sam(++/--) ++ --��dif(+-/-+) +-/-+
	/** �Ƿ�һ�� */
	public static final String BL_SAM = "SAM";// ++/--
	/** �Ƿ�һ���Ҵ���0 */
	public static final String BL_GG = "++";
	/** �Ƿ�һ����С�ڻ����0 */
	public static final String BL_LL = "--";
	
	/** �Ƿ�һ�� */
	public static final String BL_DIF = "DIF";// +-/-+
	/** �Ƿ�һ������ߴ����ұ� */
	public static final String BL_GL = "+-";
	/** �Ƿ�һ�������С���ұ� */
	public static final String BL_LG = "-+";

	/**
	 * 
	 * �಼����ϵ���㣬֧�����ֺ�boolean�ַ�������,t/true��1��f/fasle��0�� sam(++/--) ++ --��dif(+-/-+)
	 * +-/-+
	 * 
	 * 
	 * 
	 * @param obj1
	 * @param obj2
	 * @param relat
	 *            RelatHandler.BL_*
	 * @return
	 */
	public static boolean isFit(Object obj1, Object obj2, String relat) {
		if (relat == null) {
			throw new NullException("relat[" + relat + "]", "");
		}

		if (!RegexUtil.isMatches("SAM|\\+\\+|\\-\\-|\\+\\-|\\-\\+|DIF", relat)) {
			throw new IllegalException("relat", relat,
					"only sam, ++ --��dif(+-/-+) +-/-+");
		}

		double val1 = toNum(obj1);
		double val2 = toNum(obj2);

		switch (relat) {
		case BL_SAM:
			if (val1 == val2) {
				return true;
			} else {
				return false;
			}

		case BL_GG:
			if (val1 > 0 && val1 == val2) {
				return true;
			} else {
				return false;
			}

		case BL_LL:
			if (val1 <= 0 && val1 == val2) {
				return true;
			} else {
				return false;
			}

		case BL_DIF:
			if (val1 != val2) {
				return true;
			} else {
				return false;
			}

		case BL_GL:
			if (val1 > val2) {
				return true;
			} else {
				return false;
			}

		case BL_LG:
			if (val1 < val2) {
				return true;
			} else {
				return false;
			}

		default:
			// "SAM|\\+\\+|\\-\\-|\\+\\-|\\-\\+|DIF"
			throw new IllegalException("relat", relat,
					"only sam(++/--), ++ --��dif(+-/-+) +-/-+");
		}
	}

	private static final String N_F_0 = "f";
	private static final String N_FALSE_0 = "false";
	private static final String N_T_0 = "t";
	private static final String N_TRUE_0 = "true";
	private static final double N_NUM_0 = 0;
	private static final double N_NUM_1 = 1;

	/**
	 * ��������ַ�t~1,true~1,f~0,false~0������ת��Ϊ���֣��������쳣
	 * 
	 * @param val
	 * @return
	 */
	private static double toNum(Object val) {
		String s = String.valueOf(val).toLowerCase();

		switch (s) {
		case N_F_0:
			return N_NUM_0;

		case N_FALSE_0:
			return N_NUM_0;

		case N_T_0:
			return N_NUM_1;

		case N_TRUE_0:
			return N_NUM_1;

		default:
			if (RegexUtil.isNum(s)) {
				return DataUtil.toDouble(s);
			} else {
				throw new IllegalException("val", val,
						"only 't/true/f/false' ignore case and number is available");
			}
		}
	}
}
