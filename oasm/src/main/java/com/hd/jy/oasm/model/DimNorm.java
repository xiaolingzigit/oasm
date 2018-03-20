package com.hd.jy.oasm.model;

import com.hd.jy.oasm.util.priv.C;

/**
 * COPA-PI常模的维度常量
 * 
 * @author admin
 *
 */
public class DimNorm {
	private String dim;// 维度名称
	private double gpa;// 总体平均分
	private double std;// 标准差 standard deviation，std

	public DimNorm(String dim) {
		this.dim = dim;
	}

	public DimNorm(String dim, double gpa, double std) {
		this.dim = dim;
		this.gpa = gpa;
		this.std = std;
	}

	public String getDim() {
		return dim;
	}

	public DimNorm setDim(String dim) {
		this.dim = dim;
		return this;
	}

	public double getGpa() {
		return gpa;
	}

	public DimNorm setGpa(double gpa) {
		this.gpa = gpa;
		return this;
	}

	public double getStd() {
		return std;
	}

	public DimNorm setStd(double std) {
		this.std = std;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sbd = new StringBuilder(getClass().getSimpleName()+"{");
		sbd.append("维度=").append(dim).append(C.COMMOA_BANK);
		sbd.append("总体平均分=").append(gpa).append(C.COMMOA_BANK);
		sbd.append("标准差=").append(std).append("}");
		return sbd.toString();
	}
}