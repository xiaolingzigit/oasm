package com.hd.jy.oasm.model;

import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.priv.C;

/**
 * �ȼ�����ϵ����:�ȼ�,����,����,����
 * 
 * @author admin
 *
 */
public class LevelExpr {
	private String level;
	private String explain;// �ȼ�����
	private String eval;// ����evaluate
	private String suggest;// ����

	public LevelExpr(String level, String explain, String eval, String suggest) {
		this.level = level;
		this.explain = explain;
		this.eval = eval;
		this.suggest = suggest;
	}

	public String getLevel() {
		return level;
	}

	public String getExplain() {
		return explain;
	}

	public String getEval() {
		return eval;
	}

	public String getSuggest() {
		return suggest;
	}

	@Override
	public String toString() {
		StringBuilder sbd = new StringBuilder(getClass().getSimpleName() + "{");
		sbd.append("���ȼ���" + level).append(C.COMMOA_BANK);
		sbd.append("�����͡�" + explain).append(" ");
		sbd.append("�����ۡ�" + (DataUtil.isEmpty(eval) ? "�ޡ�" : eval)).append(" ");
		sbd.append("�����顿" + (DataUtil.isEmpty(suggest) ? "�ޡ�" : suggest))
				.append("}");
		return sbd.toString();
	}
}
