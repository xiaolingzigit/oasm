package com.hd.jy.oasm.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.hd.jy.oasm.domain.PgXlcsJg;
import com.hd.jy.oasm.model.CopaResult;
import com.hd.jy.oasm.model.DimResult;
import com.hd.jy.oasm.model.ScoreMap;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.RegexUtil;
import com.hd.jy.oasm.util.lsc.ScoreUtil;
import com.hd.jy.oasm.util.priv.C;

public class CopaTestHandler {

	/**
	 * 根据Copa-PI生成危险性评估分析文字描述
	 * 
	 * @param pgTaskId
	 * @param copaResult
	 * @return
	 */
	public static String makeWxxpgFs(String pgTaskId, CopaResult copaResult) {
		// CopaItStd dimStd5 = new CopaItStd(D_P5, "波动");
		// CopaItStd dimStd6 = new CopaItStd(D_P6, "冲动");
		// CopaItStd dimStd8 = new CopaItStd(D_P8, "自卑");
		// CopaItStd dimStd9 = new CopaItStd(D_P9, "焦虑");
		// CopaItStd dimStd10 = new CopaItStd(D_P10, "暴力倾向");
		// CopaItStd dimStd11 = new CopaItStd(D_P11, "变态心理");
		// CopaItStd dimStd12 = new CopaItStd(D_P12, "犯罪思维");
		if (copaResult == null) {
			return null;
		}

		HashMap<String, DimResult> map = copaResult.getDimResultMap();
		String msg = "";

		msg += map.get(CopaIdxHandler.D_P5).getLevelExpr().getExplain();
		msg += map.get(CopaIdxHandler.D_P6).getLevelExpr().getExplain();
		msg += map.get(CopaIdxHandler.D_P8).getLevelExpr().getExplain();
		msg += map.get(CopaIdxHandler.D_P9).getLevelExpr().getExplain();
		msg += map.get(CopaIdxHandler.D_P10).getLevelExpr().getExplain();
		msg += map.get(CopaIdxHandler.D_P11).getLevelExpr().getExplain();
		msg += map.get(CopaIdxHandler.D_P12).getLevelExpr().getExplain();
		if (!DataUtil.isNothing(msg)) {
			msg = "该服刑人员" + msg;
		}
		System.out.println("危险性分析结果：" + msg);
		// testMapper.saveWxxpgFs(pgTaskId, msg);
		return msg;
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
			CopaResult copaRs) {
		List<PgXlcsJg> list = new ArrayList<PgXlcsJg>();
		if (copaRs == null || taskId == null || crimNo == null) {
			return list;
		}

		DimResult rs;
		for (Entry<String, DimResult> e : copaRs.getDimResultMap().entrySet()) {
			rs = e.getValue();

			list.add(new PgXlcsJg(taskId, crimNo, rs.getDimName(), rs
					.getDimName(), rs.getTotal(), rs.getTVal(), rs.getPgDim(),
					rs.getPgDim(), rs.getPgVal(), ""));
		}

		return list;
	}

	/**
	 * 总入口根据测试得分生成报告
	 * 
	 * @param scoreMap
	 */
	public static CopaResult handle(ScoreMap scoreMap) {

		LinkedHashMap<String, DimResult> dimResultMap = new LinkedHashMap<String, DimResult>();
		CopaIdxHandler idxHd = new CopaIdxHandler();

		// val never be null but ""
		for (Map.Entry<String, String> dimGroup : idxHd.getDimQstGroups()
				.entrySet()) {

			DimResult dimResult = new DimResult(dimGroup.getKey());

			String[] qstOrders = DataUtil.trimBlank(dimGroup.getValue()).split(
					",");// 题号
			for (String qstOrder : qstOrders) {

				// 非有关联关系的处理
				if (!RegexUtil.isFound(C.REGEX_RELAT, qstOrder)) {
					dimResult.addScore(qstOrder, ScoreUtil.getScore(
							scoreMap.getScoreMap(), qstOrder));
					continue;
				}

				// 格式: 题1,题2,关系,关系成立得分,关系不成立得分
				String[] tmp = qstOrder.split("/");
				double score1 = ScoreUtil.getScore(scoreMap.getScoreMap(),
						tmp[0]);
				double score2 = ScoreUtil.getScore(scoreMap.getScoreMap(),
						tmp[1]);

				if (score1 == score2
						&& (qstOrder.contains(C.J_EE)
								|| (qstOrder.contains(C.J_LL) && score1 <= 0) || (qstOrder
								.contains(C.J_GG) && score1 > 0))) {
					// 同，避免过长和方便维护，分开写
					dimResult.addScore(qstOrder, DataUtil.toDouble(tmp[3]));

				} else if (score1 != score2
						&& (qstOrder.contains(C.J_NE)
								|| (qstOrder.contains(C.J_LG) && score1 < score2) || (qstOrder
								.contains(C.J_GL) && score1 > score2))) {
					// 同，避免过长和方便维护，分开写
					dimResult.addScore(qstOrder, DataUtil.toDouble(tmp[3]));
				} else {
					dimResult.addScore(qstOrder, DataUtil.toDouble(tmp[4]));// 关系不成立
				}
			}

			dimResultMap.put(dimGroup.getKey(), dimResult);
		}

		double lczbh = 0;// 临床指标和
		double p1Score = 0;
		for (Map.Entry<String, DimResult> subDimRsMap : dimResultMap.entrySet()) {
			p1Score = subDimRsMap.getValue().build(idxHd, p1Score);
			lczbh += subDimRsMap.getValue().getTotal();
		}

		return new CopaResult(lczbh, dimResultMap).makePg(1);
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
		//
		// scoreMap.put("1", (double) 0);
		// scoreMap.put("2", (double) 1);
		// scoreMap.put("3", (double) 0);
		// scoreMap.put("4", (double) 0);
		// scoreMap.put("5", (double) 0);
		// scoreMap.put("6", (double) 0);
		// scoreMap.put("7", (double) 1);
		// scoreMap.put("8", (double) 0);
		// scoreMap.put("9", (double) 0);
		// scoreMap.put("10", (double) 0);
		//
		// scoreMap.put("11", (double) 0);
		// scoreMap.put("12", (double) 0);
		// scoreMap.put("13", (double) 0);
		// scoreMap.put("14", (double) 0);
		// scoreMap.put("15", (double) 0);
		// scoreMap.put("16", (double) 0);
		// scoreMap.put("17", (double) 0);
		// scoreMap.put("18", (double) 1);
		// scoreMap.put("19", (double) 0);
		// scoreMap.put("20", (double) 0);
		//
		// scoreMap.put("21", (double) 0);
		// scoreMap.put("22", (double) 0);
		// scoreMap.put("23", (double) 1);
		// scoreMap.put("24", (double) 0);
		// scoreMap.put("25", (double) 0);
		// scoreMap.put("26", (double) 0);
		// scoreMap.put("27", (double) 0);
		// scoreMap.put("28", (double) 0);
		// scoreMap.put("29", (double) 0);
		// scoreMap.put("30", (double) 0);
		//
		// scoreMap.put("31", (double) 0);
		// scoreMap.put("32", (double) 1);
		// scoreMap.put("33", (double) 1);
		// scoreMap.put("34", (double) 1);
		// scoreMap.put("35", (double) 1);
		// scoreMap.put("36", (double) 6);
		// scoreMap.put("37", (double) 0);
		// scoreMap.put("38", (double) 0);
		// scoreMap.put("39", (double) 0);
		// scoreMap.put("40", (double) 0);
		//
		// scoreMap.put("41", (double) 0);
		// scoreMap.put("42", (double) 0);
		// scoreMap.put("43", (double) 0);
		// scoreMap.put("44", (double) 0);
		// scoreMap.put("45", (double) 0);
		// scoreMap.put("46", (double) 0);
		// scoreMap.put("47", (double) 0);
		// scoreMap.put("48", (double) 0);
		// scoreMap.put("49", (double) 0);
		// scoreMap.put("50", (double) 1);
		//
		// scoreMap.put("51", (double) 0);
		// scoreMap.put("52", (double) 1);
		// scoreMap.put("53", (double) 0);
		// scoreMap.put("54", (double) 0);
		// scoreMap.put("55", (double) 1);
		// scoreMap.put("56", (double) 0);
		// scoreMap.put("57", (double) 0);
		// scoreMap.put("58", (double) 0);
		// scoreMap.put("59", (double) 0);
		// scoreMap.put("60", (double) 0);
		//
		// scoreMap.put("61", (double) 0);
		// scoreMap.put("62", (double) 1);
		// scoreMap.put("63", (double) 0);
		// scoreMap.put("64", (double) 0);
		// scoreMap.put("65", (double) 0);
		// scoreMap.put("66", (double) 1);
		// scoreMap.put("67", (double) 0);
		// scoreMap.put("68", (double) 0);
		// scoreMap.put("69", (double) 1);
		// scoreMap.put("70", (double) 0);
		//
		// scoreMap.put("71", (double) 0);
		// scoreMap.put("72", (double) 0);
		// scoreMap.put("73", (double) 1);
		// scoreMap.put("74", (double) 0);
		// scoreMap.put("75", (double) 0);
		// scoreMap.put("76", (double) 0);
		// scoreMap.put("77", (double) 0);
		// scoreMap.put("78", (double) 0);
		// scoreMap.put("79", (double) 0);
		// scoreMap.put("80", (double) 0);
		//
		// scoreMap.put("81", (double) 1);
		// scoreMap.put("82", (double) 1);
		// scoreMap.put("83", (double) 0);
		// scoreMap.put("84", (double) 0);
		// scoreMap.put("85", (double) 0);
		// scoreMap.put("86", (double) 0);
		// scoreMap.put("87", (double) 0);
		// scoreMap.put("88", (double) 0);
		// scoreMap.put("89", (double) 0);
		// scoreMap.put("90", (double) 0);
		//
		// scoreMap.put("91", (double) 0);
		// scoreMap.put("92", (double) 0);
		// scoreMap.put("93", (double) 0);
		// scoreMap.put("94", (double) 0);
		// scoreMap.put("95", (double) 0);
		// scoreMap.put("96", (double) 0);
		// scoreMap.put("97", (double) 0);
		// scoreMap.put("98", (double) 0);
		// scoreMap.put("99", (double) 0);
		// scoreMap.put("100", (double) 0);
		//
		// scoreMap.put("101", (double) 0);
		// scoreMap.put("102", (double) 0);
		// scoreMap.put("103", (double) 0);
		// scoreMap.put("104", (double) 0);
		// scoreMap.put("105", (double) 0);
		// scoreMap.put("106", (double) 0);
		// scoreMap.put("107", (double) 0);
		// scoreMap.put("108", (double) 0);
		// scoreMap.put("109", (double) 1);
		// scoreMap.put("110", (double) 1);
		//
		// scoreMap.put("111", (double) 1);
		// scoreMap.put("112", (double) 0);
		// scoreMap.put("113", (double) 1);
		// scoreMap.put("114", (double) 0);
		// scoreMap.put("115", (double) 0);
		// scoreMap.put("116", (double) 0);
		// scoreMap.put("117", (double) 0);
		// scoreMap.put("118", (double) 0);
		// scoreMap.put("119", (double) 1);
		//
		// scoreMap.put("120", (double) 0);
		// scoreMap.put("121", (double) 0);
		// scoreMap.put("122", (double) 0);

		Random rd = new Random();
		int i = 0;
		while ((len--) > 0) {
			i++;
			scoreMap.put(i + "", 1.0);// (double) rd.nextInt(2)
			System.out.println("成绩：" + i + "=" + scoreMap.get(i + ""));
		}

		return scoreMap;
	}

}
