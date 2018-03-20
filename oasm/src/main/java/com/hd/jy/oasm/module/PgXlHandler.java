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
	 * ���������������Σ������
	 * 
	 * @param pgBgId
	 *            ��������ID
	 * @param copaJson
	 *            copa����Json
	 * @param scl90Json
	 *            scl90����Json
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

		// ��ɱ����
		// COPA����ɱ�����ԲУ�������Ѻ�ﷸ�ܽ�������ɱ�����ԲУ���
		// SCL-90����ɱ�����ԲУ�����Ŀ�У�
		// �ϼƵ÷֡�55Ϊ����ɱ����
		// 35�ܵ÷֣�55Ϊ����ɱ����
		// �÷֣�35Ϊ����ɱ����

		// ����
		// SCL-90����Կ��������Ŀ�У�
		// �ϼƵ÷֡�55Ϊ����������
		// 35�ܵ÷֣�55Ϊ����������
		// �÷֣�35Ϊ����������

		// COPA������Ϊ������Ѻ�ﷸ�ܽ��������Կ����ף�
		// SCL-90���������Կ��������Ŀ�У�
		// �ϼƵ÷֡�55Ϊ����������35�ܵ÷֣�55Ϊ���������򣬵÷֣�35Ϊ����������

		double zsScore = 0;// ��ɱ�������
		double ttScore = 0;// �����������
		double xxScore = 0;// �����������

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
			zsqx = "����ɱ����";
		} else if (ComparUtil.isFit("20<=T<40", zsScore)) {
			zsqx = "����ɱ����";
		} else {// if(ComparUtil.isFit("T<20", zxScore)){
			zsqx = "����ɱ����";
		}

		if (ComparUtil.isFit("T>=40", ttScore)) {
			ttqx = "����������";
		} else if (ComparUtil.isFit("20<=T<40", ttScore)) {
			ttqx = "����������";
		} else {// if(ComparUtil.isFit("T<20", ttScore)){
			ttqx = "����������";
		}

		if (ComparUtil.isFit("T>=40", xxScore)) {
			xxqx = "����������";
		} else if (ComparUtil.isFit("20<=T<40", xxScore)) {
			xxqx = "����������";
		} else {// if(ComparUtil.isFit("T<20", xxScore)){
			xxqx = "����������";
		}

		// System.out.println(zsScore);
		// System.out.println(ttScore);
		// System.out.println(xxScore);
		//
		// System.out.println(zsqx);
		// System.out.println(ttqx);
		// System.out.println(xxqx);

		list.add(new BGwxlx(pgBgId, "��ɱ����", zsScore, zsqx, null));
		list.add(new BGwxlx(pgBgId, "��������", ttScore, ttqx, null));
		list.add(new BGwxlx(pgBgId, "��������", xxScore, xxqx, null));

		return list;
	}

	public static class RiskResult extends BasicModel {
		private String dim;
		private double score;
		private String propensity;// ����

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
