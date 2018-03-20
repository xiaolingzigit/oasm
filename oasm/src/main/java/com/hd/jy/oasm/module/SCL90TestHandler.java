package com.hd.jy.oasm.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.hd.jy.oasm.domain.PgXlcsJg;
import com.hd.jy.oasm.model.FactorResult;
import com.hd.jy.oasm.model.SCL90Result;
import com.hd.jy.oasm.model.ScoreMap;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.GsonUtil;
import com.hd.jy.oasm.util.lsc.ScoreUtil;

public class SCL90TestHandler {

	public static final int SCALE = 2;// Z值和T值保留小数位数

	public static void main(String[] args) {
		// <|=|>
		// \u003c|\u003d|\u003e

		System.out
				.println(GsonUtil.toJson(handle(new ScoreMap(eumScores(90)))));
	}

	
	/**
	 * 將CopaResult中的分析結果轉化為評估報告的分析結果，便於插入數據庫
	 * 
	 * @param taskId
	 * @param crimNo
	 * @param copaRs
	 * @return never null
	 */
	public static List<PgXlcsJg> toPgXlcsJg(String taskId, String crimNo,
			SCL90Result scl90Rs) {
		List<PgXlcsJg> list = new ArrayList<PgXlcsJg>();
		if (scl90Rs == null || taskId == null || crimNo == null) {
			return list;
		}

		FactorResult rs;
		for (Entry<String, FactorResult> e : scl90Rs.getFactorResultMap().entrySet()) {
			rs = e.getValue();

			list.add(new PgXlcsJg(taskId, crimNo, rs.getFactor(), rs
					.getFactor(), rs.getTotal(), rs.getFactorGpa(), rs.getPgDim(),
					rs.getPgDim(), rs.getPgVal(), ""));
		}

		return list;
	}

	
	/**
	 * SCL90 報告分析縂入口
	 * @param scoreMap
	 * @return
	 */
	public static SCL90Result handle(ScoreMap scoreMap) {

		SCL90IdxHandler idxHd = new SCL90IdxHandler();
		LinkedHashMap<String, FactorResult> frsMap = new LinkedHashMap<String, FactorResult>();

		int qstTotal = 0;// 问题总分
		double totalScore = 0;// 阳性问题总分
		int totalPostive = 0;
		for (Map.Entry<String, String> factorQstGroup : idxHd
				.getFactorQstGroups().entrySet()) {

			FactorResult frs = new FactorResult(factorQstGroup.getKey());

			String[] factorQsts = DataUtil.trimBlank(factorQstGroup.getValue())
					.split(",");// 因子分组题号
			for (String qstOrder : factorQsts) {

				frs.setScore(qstOrder,
						ScoreUtil.getScore(scoreMap.getScoreMap(), qstOrder));

			}

			frsMap.put(factorQstGroup.getKey(), frs.build(idxHd));

			qstTotal += frs.getQstSize();
			totalScore += frs.getTotal();
			totalPostive += frs.getPostiveSize();
		}

		return new SCL90Result(qstTotal, totalPostive, totalScore,
				DataUtil.exact(totalScore / qstTotal, SCALE), DataUtil.exact(
						totalScore / totalPostive, SCALE),
				idxHd.getTotalScoreLevel(totalScore),
				idxHd.getTotalPostiveLevel(totalPostive), frsMap).makePg(1);

	}

	/**
	 * 模拟产生答题分数
	 * 
	 * @param len
	 *            题目总数
	 * @return
	 */
	public static HashMap<String, Double> eumScores(int len) {
		if (len < 0) {
			len = 0;
		}

		HashMap<String, Double> scoreMap = new HashMap<String, Double>();

		Random rd = new Random();
		int i = 0;
		while ((len--) > 0) {
			i++;
			scoreMap.put(i + "", 3.0);//(double) rd.nextInt(4)
			System.out.println("成绩：" + i + "=" + scoreMap.get(i + ""));
		}

		return scoreMap;
	}

}
