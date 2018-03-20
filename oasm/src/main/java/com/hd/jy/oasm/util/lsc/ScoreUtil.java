package com.hd.jy.oasm.util.lsc;

import java.util.HashMap;

/**
 * ���Գɼ�����������
 * 
 * @author admin
 *
 */
public class ScoreUtil {

	/**
	 * ��ȡĳ��ķ���
	 * 
	 * @param scoreMap
	 *            ��������
	 * @param key
	 *            ���
	 * @return
	 * @throws NullPointerException
	 *             ��������Ϊnull��û�и����������NullPointerException
	 */
	public static double getScore(HashMap<String, Double> scoreMap, String key) {

		if (scoreMap == null) {
			throw new NullPointerException("����ɼ���scoreMapΪ NULL");
		}

		Double scoreTmp = scoreMap.get(key);
		if (scoreTmp == null) {
			throw new NullPointerException("û�и���ĳɼ�����ţ�" + key);
		}

		return scoreTmp;
	}
}
