package com.hd.jy.oasm.model;

import java.util.HashMap;
import java.util.Map;

import com.hd.jy.oasm.module.SCL90IdxHandler;
import com.hd.jy.oasm.module.SCL90TestHandler;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.priv.C;

public class FactorResult {
	private String factor;// 因子名称
	// 试题分数
	private HashMap<String, Double> scoreMap = new HashMap<String, Double>();
	private int qstSize = 0;// 问题总数
	private int postiveSize = 0;// 阳性问题数
	private double total = 0;// 总分
	private double factorGpa = 0;// 平均分,因子分
	private String factorGpaRange = "";// 因子分值范围
	private double postiveGpa = 0;// ,total/postiveSize阳性症状痛苦水平Positive symptom
									// distress level
	private String psdLevel = "";// 阳性症状痛苦症状等级
	private double zVal = 0;// 标准分

	private LevelExpr levelExpr = null;// 等级,解释,评估(无),建议
	private FactorNorm factorNorm;//因子常模
	
	private String pgDim = "--";// 评估维度名称
	private String pgRange = "--";// 评估依据
	private double pgVal = 0; // 评估分数

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
	 * 添加成绩
	 * 
	 * @param qstOrder
	 * @param score
	 */
	public void setScore(String qstOrder, double score) {
		this.scoreMap.put(qstOrder, score);
	}

	/**
	 * 
	 * 计算内部数据
	 * 
	 * 计算问题数，阳性问题数，总分，平均分（因子分），阳性症状痛苦水平，
	 * 
	 * 计算Z值: Z=（总分-常模平均分）/标准差
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

			// 因子分值范围
			factorGpaRange = idxHandler.getFactorGpaRange(factor, factorGpa);
			// 阳性症状痛苦水平
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
		sbd.append("因子=").append(factor).append(C.COMMOA_BANK);
		sbd.append("试题得分=").append(scoreMap).append(C.COMMOA_BANK);
		sbd.append("问题总数=").append(qstSize).append(C.COMMOA_BANK);
		sbd.append("总得分=").append(total).append(C.COMMOA_BANK);
		sbd.append("因子分(平均分)=").append(factorGpa).append(C.COMMOA_BANK);
		sbd.append("因子分范围=").append(factorGpaRange).append(C.COMMOA_BANK);
		sbd.append("阳性问题数=").append(postiveSize).append(C.COMMOA_BANK);
		sbd.append("阳性症状痛苦水平=").append(postiveGpa).append(C.COMMOA_BANK);
		sbd.append("阳性症状痛苦症状等级=").append(psdLevel);

		if (!SCL90IdxHandler.F_TEN.equals(factor)) {
			sbd.append(C.COMMOA_BANK).append("标准分=").append(zVal)
					.append(C.COMMOA_BANK);
			sbd.append("【因子等级信息】").append(levelExpr);
		}
		sbd.append("}");

		return sbd.toString();
	}

}
