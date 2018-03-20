package com.hd.jy.oasm.model;

import com.hd.jy.oasm.util.priv.C;

/**
 * 维度T值Z值
 * 
 * @author admin
 *
 */
public class DimZT {
	private double ZVal;// Z值
	private double TVal;// T值

	public DimZT() {

	}

	public DimZT(double zVal, double tVal) {
		ZVal = zVal;
		TVal = tVal;
	}

	public double getZVal() {
		return ZVal;
	}

	public void setZVal(double zVal) {
		ZVal = zVal;
	}

	public double getTVal() {
		return TVal;
	}

	public void setTVal(double tVal) {
		TVal = tVal;
	}

	@Override
	public String toString() {
		StringBuilder sbd = new StringBuilder(getClass().getSimpleName() + "{");
		sbd.append("Z值=").append(ZVal).append(C.COMMOA_BANK);
		sbd.append("T值=").append(TVal).append("}");
		return sbd.toString();
	}
}
