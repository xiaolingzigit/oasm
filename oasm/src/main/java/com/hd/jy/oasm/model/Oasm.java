package com.hd.jy.oasm.model;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

public abstract class Oasm extends BasicModel{
		
	/**
	 * �ֶ�����ȱʡ���飬return nullʱΪ�Ϸ�(��ʹ��������)
	 * @param s
	 * @return
	 */
	public abstract String getNullField(String s);
}
