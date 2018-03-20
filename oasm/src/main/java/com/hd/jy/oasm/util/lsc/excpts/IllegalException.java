package com.hd.jy.oasm.util.lsc.excpts;

import com.hd.jy.oasm.util.lsc.DataUtil;

public class IllegalException extends IllegalArgumentException {
	private static final long serialVersionUID = -8749906207599118933L;

	public IllegalException() {
		super();
	}

	public IllegalException(String msg) {
		super(msg);
	}

	/**
	 * 
	 * @param argName
	 *            参数名
	 * @param val
	 *            参数值
	 * @param moreDetails
	 *            描述或说明信息
	 */
	public IllegalException(String argName, Object val, String moreDetails) {
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
			argName = argName + " is illegal.";
		}

		if (!DataUtil.isEmpty(moreDetails)) {
			argName = DataUtil.isEmpty(argName) ? "" : argName + " ";
			argName = argName + moreDetails;
		}

		return argName;
	}

	/**
	 * @param argName
	 * @param val
	 * @param moreDetails
	 * @param cause
	 * @since 1.5
	 * 
	 */
	public IllegalException(String argName, Object val, String moreDetails,
			Throwable cause) {
		super(buildMsg(argName, val, moreDetails), cause);
	}

	/**
	 * @param msg
	 * @param cause
	 * @since 1.5
	 */
	public IllegalException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public IllegalException(Throwable cause) {
		super(cause);
	}
}
