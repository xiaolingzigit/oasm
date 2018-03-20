package com.hd.jy.oasm.util.lsc.excpts;

import java.util.InputMismatchException;

import com.hd.jy.oasm.util.lsc.DataUtil;

public class MismatchException extends InputMismatchException {

	private static final long serialVersionUID = 372985761997278498L;

	public MismatchException() {
		super();
	}

	public MismatchException(String msg) {
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
	public MismatchException(String argName, Object val, String moreDetails) {
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
			argName = argName + " is mismatched.";
		}

		if (!DataUtil.isEmpty(moreDetails)) {
			argName = DataUtil.isEmpty(argName) ? "" : argName + " ";
			argName = argName + moreDetails;
		}

		return argName;
	}
}
