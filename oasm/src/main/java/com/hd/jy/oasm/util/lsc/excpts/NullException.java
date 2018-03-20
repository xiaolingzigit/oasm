package com.hd.jy.oasm.util.lsc.excpts;

import com.hd.jy.oasm.util.lsc.DataUtil;

//NullPointerException extends RuntimeException 
public class NullException extends IllegalArgumentException {
	private static final long serialVersionUID = 1130002143654425560L;

	public NullException() {
		super();
	}

	public NullException(String msg) {
		super(msg);
	}
	
	/**
	 * 
	 * @param argName
	 * @param moreDetails cannot be null but ""
	 */
	public NullException(String argName, String moreDetails) {
		super(buildMsg(argName, moreDetails));
	}

	private static String buildMsg(String argName, String moreDetails) {

		if (DataUtil.isEmpty(argName)) {
			argName = "";
		}

		if (!DataUtil.isEmpty(argName)) {
			argName = argName + " is null.";
		}

		if (!DataUtil.isEmpty(moreDetails)) {
			argName = DataUtil.isEmpty(argName) ? "" : argName + " ";
			argName = argName + moreDetails;
		}

		return argName;
	}

	/**
	 * @param message
	 * @param cause cannot be null
	 * @since 1.5
	 */
	public NullException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NullException(Throwable cause) {
		super(cause);
	}
}
