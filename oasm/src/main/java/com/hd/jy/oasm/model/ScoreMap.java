package com.hd.jy.oasm.model;

import java.util.HashMap;

/**
 * 测试各题得分集合
 * 
 * @author admin
 *
 */
public class ScoreMap {
	private HashMap<String, Double> scoreMap = new HashMap<String, Double>();

	public ScoreMap() {

	}

	public ScoreMap(HashMap<String, Double> scoreMap) {
		if (scoreMap != null) {
			this.scoreMap.putAll(scoreMap);
		}
	}

	public ScoreMap(String qstNum, double score) {

	}

	public ScoreMap addScore(HashMap<String, Double> scoreMap) {
		if (scoreMap != null) {
			this.scoreMap.putAll(scoreMap);
		}
		return this;
	}

	public ScoreMap addScore(String qstNum, double score) {
		scoreMap.put(qstNum, score);
		return this;
	}

	public double getScore(String qstNum) {
		return scoreMap.get(qstNum);
	}

	public HashMap<String, Double> getScoreMap() {
		return scoreMap;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + scoreMap;
	}

}
