package com.hd.jy.oasm.model;

import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.priv.C;

/**
 * 等级表达关系对象:等级,解释,建议,评估
 * 
 * @author admin
 *
 */
public class LevelExpr {
	private String level;
	private String explain;// 等级解释
	private String eval;// 评价evaluate
	private String suggest;// 建议

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
		sbd.append("【等级】" + level).append(C.COMMOA_BANK);
		sbd.append("【解释】" + explain).append(" ");
		sbd.append("【评价】" + (DataUtil.isEmpty(eval) ? "无。" : eval)).append(" ");
		sbd.append("【建议】" + (DataUtil.isEmpty(suggest) ? "无。" : suggest))
				.append("}");
		return sbd.toString();
	}
}
