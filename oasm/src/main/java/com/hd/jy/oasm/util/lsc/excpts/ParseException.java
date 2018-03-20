package com.hd.jy.oasm.util.lsc.excpts;

import com.hd.jy.oasm.util.lsc.DataUtil;

public class ParseException extends IllegalArgumentException {
	private static final long serialVersionUID = 2934894712479827298L;

	public ParseException() {
		super();
	}

	public ParseException(String msg) {
		super(msg);
	}

	/**
	 * @param argName
	 *            参数名
	 * @param val
	 *            参数值
	 * @param moreDetails
	 *            描述或说明信息
	 */
	public ParseException(String argName, Object val, String moreDetails) {
		super(buildMsg(argName, val, moreDetails));
	}

	private static String buildMsg(String argName, Object val,
			String moreDetails) {

		if (DataUtil.isEmpty(argName)) {
			argName = "";
		}

		if (!DataUtil.isEmpty(val)) {
			argName = DataUtil.isEmpty(argName) ? "" : argName + " ";
			argName = argName + "input[" + val + "]";
		}

		if (!DataUtil.isEmpty(argName)) {
			argName = argName + " parse failed.";
		}

		if (!DataUtil.isEmpty(moreDetails)) {
			argName = DataUtil.isEmpty(argName) ? "" : argName + " ";
			argName = argName + moreDetails;
		}

		return argName;
	}

	/**
	 * 
	 * @param msg
	 * @param cause
	 * @since 1.5
	 */
	public ParseException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * 
	 * @param argName
	 * @param val
	 * @param moreDetails
	 * @param cause
	 * @since 1.5
	 */
	public ParseException(String argName, Object val, String moreDetails,
			Throwable cause) {
		super(buildMsg(argName, val, moreDetails), cause);
	}

	/**
	 * 
	 * @param cause
	 * @since 1.5
	 */
	public ParseException(Throwable cause) {
		super(cause);
	}

}
