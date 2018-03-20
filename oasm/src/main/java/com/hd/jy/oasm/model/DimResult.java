package com.hd.jy.oasm.model;

import java.util.HashMap;
import java.util.Map;

import com.hd.jy.oasm.module.CopaIdxHandler;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * �������ά�Ȳ��Խ��
 * 
 * @author admin
 *
 */
public class DimResult extends BasicModel {

	private String dim;// ά��
	private String dimName;// ά������
	// ���Ը���÷ּ���
	private HashMap<String, Double> scoreMap = new HashMap<String, Double>();
	private double qstSize = 0;// ������
	private double total = 0;// ά���ܷ�
	private double gpa = 0;// ƽ����
	private double zVal = 0;// Zֵ
	private double tVal = 0;// tֵ
	private String tRange;// tֵ��Χ
	private LevelExpr levelExpr;// �ȼ�,����,����,����
	private String pgDim = "--";// ����ά������
	private String pgRange = "--";// ��������
	private double pgVal = 0; // ��������

	public void setPgInfo(String pgDim, String pgRange, double pgVal) {
		this.pgDim = pgDim;
		this.pgRange = pgRange;
		this.pgVal = pgVal;
	}

	public DimResult(String dim) {
		if (dim == null) {
			throw new IllegalArgumentException("dim cannot be null");
		}

		this.dim = dim;
	}

	public String getDim() {
		return dim;
	}

	public HashMap<String, Double> getScoreMap(String qstNum) {
		HashMap<String, Double> tmp = new HashMap<String, Double>();
		tmp.putAll(scoreMap);
		return tmp;
	}

	public double getScore(String qstNum) {
		return scoreMap.get(qstNum);
	}

	public DimResult addScore(String qstNum, double score) {
		scoreMap.put(qstNum, score);
		return this;
	}

	public double getQstSize() {
		return qstSize;
	}

	public double getTotal() {
		return total;
	}

	public double getGpa() {
		return gpa;
	}

	public double getZVal() {
		return zVal;
	}

	public double getTVal() {
		return tVal;
	}

	public String getTRange() {
		return tRange;
	}

	public String getDimName() {
		return dimName;
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

	public double build(CopaIdxHandler idxHandler, double p1Score) {

		if (idxHandler == null) {
			throw new IllegalArgumentException("CopaIdxHandler cannot be null");
		}

		dimName = idxHandler.getDimName(dim);

		if (dimName == null) {
			throw new IllegalArgumentException("dim[" + dim
					+ "] is not found in CopaIdxHandler");
		}

		qstSize = scoreMap.size();
		total = 0;
		for (Map.Entry<String, Double> qst : scoreMap.entrySet()) {
			total += qst.getValue();
		}

		if (CopaIdxHandler.D_P1.equals(dim)) {
			p1Score = total;
		}

		gpa = DataUtil.exact(total / qstSize, idxHandler.Z_T_SCALE);

		if (!("L".equals(dim) || "S".equals(dim))) {
			DimNorm norm = idxHandler.getDimNorm(dim);

			if (norm == null) {
				throw new IllegalArgumentException("DimNorm of " + dim
						+ " is null");
			}

			zVal = DataUtil.exact((p1Score - norm.getGpa()) / norm.getStd(),
					idxHandler.Z_T_SCALE);

			tVal = DataUtil.exact(idxHandler.T_COEFFICIENT * zVal
					+ idxHandler.T_CONSTANT, idxHandler.Z_T_SCALE);

			tRange = idxHandler.getDimTRange(dim, tVal);

		}

		levelExpr = idxHandler.getLevelExpr(dim, tVal);
		return p1Score;
	}

	public LevelExpr getLevelExpr() {
		return levelExpr;
	}
}
