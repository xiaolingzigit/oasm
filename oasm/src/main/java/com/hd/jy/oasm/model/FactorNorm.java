package com.hd.jy.oasm.model;

import com.hd.jy.oasm.util.priv.C;

/**
 * SCL-90ȫ�����ӷֳ�ģ��
 * 
 * @author admin
 *
 */
public class FactorNorm {
	private String factor;// ��������
	private double gpa;// ����ƽ����
	private double std;// ��׼�� standard deviation��std

	public FactorNorm(String factor) {
		this.factor = factor;
	}

	public FactorNorm(String factor, double gpa, double std) {
		this.factor = factor;
		this.gpa = gpa;
		this.std = std;
	}

	public String getFactor() {
		return factor;
	}

	public FactorNorm setFactor(String factor) {
		this.factor = factor;
		return this;
	}

	public double getGpa() {
		return gpa;
	}

	public FactorNorm setGpa(double gpa) {
		this.gpa = gpa;
		return this;
	}

	public double getStd() {
		return std;
	}

	public FactorNorm setStd(double std) {
		this.std = std;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sbd = new StringBuilder(getClass().getSimpleName()+"{");
		sbd.append("����=").append(factor).append(C.COMMOA_BANK);
		sbd.append("����ƽ����=").append(gpa).append(C.COMMOA_BANK);
		sbd.append("��׼��=").append(std).append("}");
		return sbd.toString();
	}

}
