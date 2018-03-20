package com.hd.jy.oasm.model;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.hd.jy.oasm.util.lsc.datahandle.ComparUtil;
import com.hd.jy.oasm.util.priv.C;
import com.hd.jy.oasm.util.priv.PgXl;
import com.hd.jy.oasm.util.priv.PgXl.PgRang;

/**
 * Copa-PI���Է������
 * 
 * @author admin
 *
 */
public class CopaResult {
	/** �ٴ�ָ��� */
	private double lczbh;
	/** ���������ܷ� */
	private double pgTotalScore = 0;
	/** ����������� */
	private LinkedHashMap<String, DimResult> dimResultMap;

	/**
	 * �ж���������
	 * 
	 * @param pgStage
	 *            �����׶� ���1-�ճ�2-����3-����4
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
					+ ") ���Ϸ���ֵ��:���1-�ճ�2-����3-����4");
		}
		return this;
	}

	/**
	 * @param lczbh
	 *            �ٴ�ָ���
	 * @param dimResultMap
	 *            �����������
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
		sbd.append("�ٴ�ָ���:" + lczbh).append(C.COMMOA_BANK);
		sbd.append("ά�ȷ��������ϸ:").append(dimResultMap).append("}");
		return sbd.toString();
	}
}