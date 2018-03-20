package com.hd.jy.oasm.util.lsc.basicmodel;

import com.hd.jy.oasm.util.lsc.ReflectUtil;

public class BasicModel {

	public String fieldVals(boolean includeSuper) {
		return fieldVals(includeSuper, "=", "; ");
	}

	public String fieldVals(boolean includeSuper, String fieldValLinker,
			String fieldSeparator) {
		return ReflectUtil.fieldValString(this, includeSuper, fieldValLinker,
				fieldSeparator);
	}

	@Override
	public String toString() {
		return new StringBuilder(getClass().getSimpleName() + "{")
				.append(fieldVals(true)).append("}").toString();
	}
}
