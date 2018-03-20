package com.hd.jy.oasm.model;

import com.hd.jy.oasm.util.priv.C;

/**
 * COPA-PI��ģ��ά�ȳ���
 * 
 * @author admin
 *
 */
public class DimNorm {
	private String dim;// ά������
	private double gpa;// ����ƽ����
	private double std;// ��׼�� standard deviation��std

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
		sbd.append("ά��=").append(dim).append(C.COMMOA_BANK);
		sbd.append("����ƽ����=").append(gpa).append(C.COMMOA_BANK);
		sbd.append("��׼��=").append(std).append("}");
		return sbd.toString();
	}
}