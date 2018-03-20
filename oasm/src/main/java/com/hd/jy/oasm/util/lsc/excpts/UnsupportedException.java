package com.hd.jy.oasm.util.lsc.excpts;

import com.hd.jy.oasm.util.lsc.DataUtil;

public class UnsupportedException extends IllegalArgumentException {
	private static final long serialVersionUID = 5010349087991318806L;

	public UnsupportedException() {
		super();
	}

	public UnsupportedException(String msg) {
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
	public UnsupportedException(String argName, Object val, String moreDetails) {
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
			argName = argName + " is unsupported.";
		}

		if (!DataUtil.isEmpty(moreDetails)) {
			argName = DataUtil.isEmpty(argName) ? "" : argName + " ";
			argName = argName + moreDetails;
		}

		return argName;
	}

	/**
	 * @param message
	 * @param cause
	 * @since 1.5
	 */
	public UnsupportedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @since 1.5
	 */
	public UnsupportedException(String argName, Object val, String moreDetails,
			Throwable cause) {
		super(buildMsg(argName, val, moreDetails), cause);
	}

	public UnsupportedException(Throwable cause) {
		super(cause);
	}

}
