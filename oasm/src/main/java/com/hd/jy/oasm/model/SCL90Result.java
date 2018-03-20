package com.hd.jy.oasm.model;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;
import com.hd.jy.oasm.util.lsc.datahandle.ComparUtil;
import com.hd.jy.oasm.util.priv.PgXl;
import com.hd.jy.oasm.util.priv.PgXl.PgRang;

public class SCL90Result extends BasicModel {
	private int qstSize;// 问题总数
	private int postiveSize = 0;// 阳性问题数
	private double total;// 总分
	private double gpa;// 总均分
	private double postiveGpa;// 阳性问题均分
	private String totalYinYang;// 总分阴阳性
	private String totalPostiveResult;// 阳性问题总分析结果
	/** 因子分析结果明细集合 */
	private LinkedHashMap<String, FactorResult> factorResultMap;

	private double pgTotalScore = 0;

	/**
	 * 判断评估分数
	 * 
	 * @param pgStage
	 *            评估阶段 入监1-日常2-中期3-出监4
	 * @return
	 */
	public SCL90Result makePg(int pgStage) {
		if (factorResultMap == null) {
			return this;
		}

		switch (pgStage) {
		case 1:
			for (Entry<String, FactorResult> fc : factorResultMap.entrySet()) {
				PgRang range = PgXl.getPgRang(fc.getKey());
				FactorResult rs = fc.getValue();
				if (range != null) {
					if (ComparUtil.isFit(range.range, rs.getFactorGpa())) {
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
	 * @param qstSize
	 * @param postiveSize
	 * @param total
	 * @param totalYinYang
	 * @param totalPostiveResult
	 * @param factorResultMap
	 */
	public SCL90Result(int qstSize, int postiveSize, double total, double gpa,
			double postiveGpa, String totalYinYang, String totalPostiveResult,
			LinkedHashMap<String, FactorResult> factorResultMap) {
		this.qstSize = qstSize;
		this.postiveSize = postiveSize;
		this.total = total;
		this.gpa = gpa;
		this.postiveGpa = postiveGpa;
		this.totalYinYang = totalYinYang;
		this.totalPostiveResult = totalPostiveResult;
		this.factorResultMap = factorResultMap;
	}

	public int getQstSize() {
		return qstSize;
	}

	public void setQstSize(int qstSize) {
		this.qstSize = qstSize;
	}

	public int getPostiveSize() {
		return postiveSize;
	}

	public void setPostiveSize(int postiveSize) {
		this.postiveSize = postiveSize;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getTotalYinYang() {
		return totalYinYang;
	}

	public void setTotalYinYang(String totalYinYang) {
		this.totalYinYang = totalYinYang;
	}

	public String getTotalPostiveResult() {
		return totalPostiveResult;
	}

	public void setTotalPostiveResult(String totalPostiveResult) {
		this.totalPostiveResult = totalPostiveResult;
	}

	public LinkedHashMap<String, FactorResult> getFactorResultMap() {
		return factorResultMap;
	}

	public void setFactorResultMap(
			LinkedHashMap<String, FactorResult> factorResultMap) {
		this.factorResultMap = factorResultMap;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getPostiveGpa() {
		return postiveGpa;
	}

	public void setPostiveGpa(double postiveGpa) {
		this.postiveGpa = postiveGpa;
	}

	public double getPgTotalScore() {
		return pgTotalScore;
	}

	public void setPgTotalScore(double pgTotalScore) {
		this.pgTotalScore = pgTotalScore;
	}

}
