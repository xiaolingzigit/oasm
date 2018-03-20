package com.hd.jy.oasm.util.lsc;

import java.util.HashMap;

/**
 * 测试成绩处理公共工具
 * 
 * @author admin
 *
 */
public class ScoreUtil {

	/**
	 * 获取某题的分数
	 * 
	 * @param scoreMap
	 *            分数集合
	 * @param key
	 *            题号
	 * @return
	 * @throws NullPointerException
	 *             分数集合为null或没有该题分数均抛NullPointerException
	 */
	public static double getScore(HashMap<String, Double> scoreMap, String key) {

		if (scoreMap == null) {
			throw new NullPointerException("答题成绩表scoreMap为 NULL");
		}

		Double scoreTmp = scoreMap.get(key);
		if (scoreTmp == null) {
			throw new NullPointerException("没有该题的成绩，题号：" + key);
		}

		return scoreTmp;
	}
}
