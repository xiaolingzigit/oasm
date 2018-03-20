package com.hd.jy.oasm.module;

import java.util.ArrayList;
import java.util.Map.Entry;

import com.hd.jy.oasm.domain.BGwxlx;
import com.hd.jy.oasm.model.CopaResult;
import com.hd.jy.oasm.model.DimResult;
import com.hd.jy.oasm.model.FactorResult;
import com.hd.jy.oasm.model.SCL90Result;
import com.hd.jy.oasm.util.lsc.GsonUtil;
import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;
import com.hd.jy.oasm.util.lsc.datahandle.ComparUtil;
import com.hd.jy.oasm.util.priv.PgXl;

public class PgXlHandler {

	/**
	 * 根据心理测试评估危险倾向
	 * 
	 * @param pgBgId
	 *            评估报告ID
	 * @param copaJson
	 *            copa报告Json
	 * @param scl90Json
	 *            scl90报告Json
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<BGwxlx> handle(String pgBgId, String copaJson,
			String scl90Json) throws Exception {
		ArrayList<BGwxlx> list = new ArrayList<BGwxlx>();

		if (copaJson == null || scl90Json == null) {
			// throw new Exception(DataUtil.getNullName(copaJson, "copaJson",
			// scl90Json, "scl90Json") + "is null");
			return list;
		}

		// String copaJson = GsonUtil.toJson(CopaTestHandler.handle(new
		// ScoreMap(
		// CopaTestHandler.eumScores(122))));
		// String scl90Json = GsonUtil.toJson(SCL90TestHandler
		// .handle(new ScoreMap(SCL90TestHandler.eumScores(90))));
		//
		// System.out.println("copaJson=" + copaJson);
		// System.out.println("scl90Json=" + scl90Json);

		CopaResult copaRs = GsonUtil.toInstance(copaJson, CopaResult.class);
		SCL90Result scl90Rs = GsonUtil.toInstance(scl90Json, SCL90Result.class);

		// 自杀倾向
		// COPA（自杀自伤自残），新收押罪犯管教量表（自杀自伤自残），
		// SCL-90（自杀自伤自残）等项目中，
		// 合计得分≥55为高自杀倾向，
		// 35≤得分＜55为中自杀倾向，
		// 得分＜35为低自杀倾向

		// 脱逃
		// SCL-90量表对抗管理等项目中，
		// 合计得分≥55为高脱逃倾向，
		// 35≤得分＜55为中脱逃倾向，
		// 得分＜35为低脱逃倾向

		// COPA暴力行为，新收押罪犯管教量表暴力对抗行凶，
		// SCL-90量表暴力、对抗管理等项目中，
		// 合计得分≥55为高行凶倾向，35≤得分＜55为中行凶倾向，得分＜35为低行凶倾向

		double zsScore = 0;// 自杀倾向分数
		double ttScore = 0;// 脱逃倾向分数
		double xxScore = 0;// 行凶倾向分数

		String zsqx = "";
		String ttqx = "";
		String xxqx = "";
		for (Entry<String, DimResult> dim : copaRs.getDimResultMap().entrySet()) {
			DimResult dimRs = dim.getValue();
			System.out.println(dimRs.getPgDim());
			System.out.println(dimRs.getPgVal());

			if (PgXl.PG_ZSZSZC.equals(dimRs.getPgDim())) {
				zsScore += dimRs.getPgVal();
			}

			if (PgXl.PG_BL_DKGL.equals(dimRs.getPgDim())) {
				ttScore += dimRs.getPgVal();
			}

			if (PgXl.PG_BLXW.equals(dimRs.getPgDim())
					|| PgXl.PG_BL_DKGL.endsWith(dimRs.getPgDim())) {
				xxScore += dimRs.getPgVal();
			}
		}

		for (Entry<String, FactorResult> dim : scl90Rs.getFactorResultMap()
				.entrySet()) {
			FactorResult dimRs = dim.getValue();

			System.out.println(dimRs.getPgDim());
			System.out.println(dimRs.getPgVal());

			if (PgXl.PG_ZSZSZC.equals(dimRs.getPgDim())) {
				zsScore += dimRs.getPgVal();
			}

			if (PgXl.PG_BL_DKGL.equals(dimRs.getPgDim())) {
				ttScore += dimRs.getPgVal();
			}

			if (PgXl.PG_BLXW.equals(dimRs.getPgDim())
					|| PgXl.PG_BL_DKGL.endsWith(dimRs.getPgDim())) {
				xxScore += dimRs.getPgVal();
			}
		}

		// +15
		if (ComparUtil.isFit("T>=40", zsScore)) {
			zsqx = "高自杀倾向";
		} else if (ComparUtil.isFit("20<=T<40", zsScore)) {
			zsqx = "中自杀倾向";
		} else {// if(ComparUtil.isFit("T<20", zxScore)){
			zsqx = "低自杀倾向";
		}

		if (ComparUtil.isFit("T>=40", ttScore)) {
			ttqx = "高脱逃倾向";
		} else if (ComparUtil.isFit("20<=T<40", ttScore)) {
			ttqx = "中脱逃倾向";
		} else {// if(ComparUtil.isFit("T<20", ttScore)){
			ttqx = "低脱逃倾向";
		}

		if (ComparUtil.isFit("T>=40", xxScore)) {
			xxqx = "高行凶倾向";
		} else if (ComparUtil.isFit("20<=T<40", xxScore)) {
			xxqx = "中行凶倾向";
		} else {// if(ComparUtil.isFit("T<20", xxScore)){
			xxqx = "低行凶倾向";
		}

		// System.out.println(zsScore);
		// System.out.println(ttScore);
		// System.out.println(xxScore);
		//
		// System.out.println(zsqx);
		// System.out.println(ttqx);
		// System.out.println(xxqx);

		list.add(new BGwxlx(pgBgId, "自杀倾向", zsScore, zsqx, null));
		list.add(new BGwxlx(pgBgId, "脱逃倾向", ttScore, ttqx, null));
		list.add(new BGwxlx(pgBgId, "行凶倾向", xxScore, xxqx, null));

		return list;
	}

	public static class RiskResult extends BasicModel {
		private String dim;
		private double score;
		private String propensity;// 倾向

		public RiskResult() {

		}

		public RiskResult(String dim, double score, String propensity) {
			this.dim = dim;
			this.score = score;
			this.propensity = propensity;
		}

		public String getDim() {
			return dim;
		}

		public void setDim(String dim) {
			this.dim = dim;
		}

		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}

		public String getPropensity() {
			return propensity;
		}

		public void setPropensity(String propensity) {
			this.propensity = propensity;
		}
	}
}
