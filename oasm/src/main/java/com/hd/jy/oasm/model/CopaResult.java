package com.hd.jy.oasm.model;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.hd.jy.oasm.util.lsc.datahandle.ComparUtil;
import com.hd.jy.oasm.util.priv.C;
import com.hd.jy.oasm.util.priv.PgXl;
import com.hd.jy.oasm.util.priv.PgXl.PgRang;

/**
 * Copa-PI测试分析结果
 * 
 * @author admin
 *
 */
public class CopaResult {
	/** 临床指标和 */
	private double lczbh;
	/** 评估报告总分 */
	private double pgTotalScore = 0;
	/** 分析结果集合 */
	private LinkedHashMap<String, DimResult> dimResultMap;

	/**
	 * 判断评估分数
	 * 
	 * @param pgStage
	 *            评估阶段 入监1-日常2-中期3-出监4
	 * @return
	 */
	public CopaResult makePg(int pgStage) {
		if (dimResultMap == null) {
			return this;
		}

		switch (pgStage) {
		case 1:
			for (Entry<String, DimResult> dim : dimResultMap.entrySet()) {
				PgRang range = PgXl.getPgRang(dim.getKey());
				DimResult rs = dim.getValue();
				if (range != null) {
					if (ComparUtil.isFit(range.range, rs.getTVal())) {
						rs.setPgInfo(range.dim, range.range, range.score);
						pgTotalScore += range.score;
					} else {
						rs.setPgInfo(range.dim, range.range, 0);
					}
				} else {
					rs.setPgInfo("--", "--", 0);
				}
			}

			break;
		case 2:

			break;
		case 3:

			break;

		case 4:

			break;
		default:
			throw new IllegalArgumentException("pgStage(" + pgStage
					+ ") 不合法。值域:入监1-日常2-中期3-出监4");
		}
		return this;
	}

	/**
	 * @param lczbh
	 *            临床指标和
	 * @param dimResultMap
	 *            分析结果集合
	 */
	public CopaResult(double lczbh,
			LinkedHashMap<String, DimResult> dimResultMap) {
		this.lczbh = lczbh;
		this.dimResultMap = dimResultMap;
	}

	public double getLczbh() {
		return lczbh;
	}

	public void setLczbh(double lczbh) {
		this.lczbh = lczbh;
	}

	public LinkedHashMap<String, DimResult> getDimResultMap() {
		return dimResultMap;
	}

	public void setDimResultMap(LinkedHashMap<String, DimResult> dimResultMap) {
		this.dimResultMap = dimResultMap;
	}

	public double getPgTotalScore() {
		return pgTotalScore;
	}

	public void setPgTotalScore(double pgTotalScore) {
		this.pgTotalScore = pgTotalScore;
	}

	@Override
	public String toString() {
		StringBuilder sbd = new StringBuilder(getClass().getSimpleName() + "{");
		sbd.append("临床指标和:" + lczbh).append(C.COMMOA_BANK);
		sbd.append("维度分析结果明细:").append(dimResultMap).append("}");
		return sbd.toString();
	}
}