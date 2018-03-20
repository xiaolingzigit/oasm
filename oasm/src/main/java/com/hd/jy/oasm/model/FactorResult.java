package com.hd.jy.oasm.model;

import java.util.HashMap;
import java.util.Map;

import com.hd.jy.oasm.module.SCL90IdxHandler;
import com.hd.jy.oasm.module.SCL90TestHandler;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.priv.C;

public class FactorResult {
	private String factor;// ��������
	// �������
	private HashMap<String, Double> scoreMap = new HashMap<String, Double>();
	private int qstSize = 0;// ��������
	private int postiveSize = 0;// ����������
	private double total = 0;// �ܷ�
	private double factorGpa = 0;// ƽ����,���ӷ�
	private String factorGpaRange = "";// ���ӷ�ֵ��Χ
	private double postiveGpa = 0;// ,total/postiveSize����֢״ʹ��ˮƽPositive symptom
									// distress level
	private String psdLevel = "";// ����֢״ʹ��֢״�ȼ�
	private double zVal = 0;// ��׼��

	private LevelExpr levelExpr = null;// �ȼ�,����,����(��),����
	private FactorNorm factorNorm;//���ӳ�ģ
	
	private String pgDim = "--";// ����ά������
	private String pgRange = "--";// ��������
	private double pgVal = 0; // ��������

	public void setPgInfo(String pgDim, String pgRange, double pgVal) {
		this.pgDim = pgDim;
		this.pgRange = pgRange;
		this.pgVal = pgVal;
	}
	
	public FactorResult(String factor) {
		if (factor == null) {
			throw new IllegalArgumentException("factor cannot be null");
		}

		this.factor = factor;
	}

	public String getFactor() {
		return factor;
	}

	public HashMap<String, Double> getScoreMap() {
		return scoreMap;
	}

	public double getScore(String qstOrder) {
		return scoreMap.get(qstOrder);
	}

	/**
	 * ��ӳɼ�
	 * 
	 * @param qstOrder
	 * @param score
	 */
	public void setScore(String qstOrder, double score) {
		this.scoreMap.put(qstOrder, score);
	}

	/**
	 * 
	 * �����ڲ�����
	 * 
	 * �������������������������ܷ֣�ƽ���֣����ӷ֣�������֢״ʹ��ˮƽ��
	 * 
	 * ����Zֵ: Z=���ܷ�-��ģƽ���֣�/��׼��
	 * 
	 * 
	 * @return
	 */
	public FactorResult build(SCL90IdxHandler idxHandler) {

		if (idxHandler == null) {
			throw new IllegalArgumentException("SCL90IdxHandler cannot be null");
		}

		if (!SCL90IdxHandler.F_TEN.equals(factor)
				&& idxHandler.getFactorName(factor) == null) {
			throw new IllegalArgumentException("factor[" + factor
					+ "] is not found in SCL90IdxHandler");
		}

		qstSize = scoreMap.size();

		total = 0;
		postiveSize = 0;

		for (Map.Entry<String, Double> qst : scoreMap.entrySet()) {
			total += qst.getValue();
			if (qst.getValue() > 0) {
				postiveSize++;
			}
		}

		factorGpa = DataUtil.exact(total / qstSize, SCL90TestHandler.SCALE);

		postiveGpa = DataUtil.exact(postiveSize == 0 ? 0 : total / postiveSize,
				SCL90TestHandler.SCALE);

		if (!SCL90IdxHandler.F_TEN.equals(factor)) {
			factorNorm = idxHandler.getFactorNorm(factor);

			if (factorNorm == null) {
				throw new IllegalArgumentException("FactorNorm of " + factor
						+ " is null");
			}

			zVal = DataUtil.exact(total - factorNorm.getGpa() / factorNorm.getStd(),
					SCL90TestHandler.SCALE);

			// ���ӷ�ֵ��Χ
			factorGpaRange = idxHandler.getFactorGpaRange(factor, factorGpa);
			// ����֢״ʹ��ˮƽ
			psdLevel = idxHandler.getQstLevel(postiveGpa);

			levelExpr = idxHandler.getLevelExpr(factor, total);
		}

		return this;
	}

	public int getQstSize() {
		return qstSize;
	}

	public int getPostiveSize() {
		return postiveSize;
	}

	public double getTotal() {
		return total;
	}

	public double getFactorGpa() {
		return factorGpa;
	}

	public String getFactorGpaRange() {
		return factorGpaRange;
	}

	public double getzVal() {
		return zVal;
	}

	public double getPostiveGpa() {
		return postiveGpa;
	}

	public String getPsdLevel() {
		return psdLevel;
	}

	public LevelExpr getLevelExpr() {
		return levelExpr;
	}
	
	public FactorNorm getFactorNorm() {
		return factorNorm;
	}

	public void setFactorNorm(FactorNorm factorNorm) {
		this.factorNorm = factorNorm;
	}
	
	public String getPgDim() {
		return pgDim;
	}

	public void setPgDim(String pgDim) {
		this.pgDim = pgDim;
	}

	public String getPgRange() {
		return pgRange;
	}

	public void setPgRange(String pgRange) {
		this.pgRange = pgRange;
	}

	public double getPgVal() {
		return pgVal;
	}

	public void setPgVal(double pgVal) {
		this.pgVal = pgVal;
	}

	@Override
	public String toString() {
		StringBuilder sbd = new StringBuilder(getClass().getSimpleName() + "{");
		sbd.append("����=").append(factor).append(C.COMMOA_BANK);
		sbd.append("����÷�=").append(scoreMap).append(C.COMMOA_BANK);
		sbd.append("��������=").append(qstSize).append(C.COMMOA_BANK);
		sbd.append("�ܵ÷�=").append(total).append(C.COMMOA_BANK);
		sbd.append("���ӷ�(ƽ����)=").append(factorGpa).append(C.COMMOA_BANK);
		sbd.append("���ӷַ�Χ=").append(factorGpaRange).append(C.COMMOA_BANK);
		sbd.append("����������=").append(postiveSize).append(C.COMMOA_BANK);
		sbd.append("����֢״ʹ��ˮƽ=").append(postiveGpa).append(C.COMMOA_BANK);
		sbd.append("����֢״ʹ��֢״�ȼ�=").append(psdLevel);

		if (!SCL90IdxHandler.F_TEN.equals(factor)) {
			sbd.append(C.COMMOA_BANK).append("��׼��=").append(zVal)
					.append(C.COMMOA_BANK);
			sbd.append("�����ӵȼ���Ϣ��").append(levelExpr);
		}
		sbd.append("}");

		return sbd.toString();
	}

}
