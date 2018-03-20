package com.hd.jy.oasm.model;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

public abstract class Oasm extends BasicModel{
		
	/**
	 * 字段数据缺省检验，return null时为合法(即使满足条件)
	 * @param s
	 * @return
	 */
	public abstract String getNullField(String s);
}
