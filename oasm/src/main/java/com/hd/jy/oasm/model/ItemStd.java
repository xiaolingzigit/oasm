package com.hd.jy.oasm.model;

import java.util.HashMap;

import com.hd.jy.oasm.util.priv.C;

/**
 * 条目标准
 * 
 * @author admin
 *
 */
public abstract class ItemStd {
	private String id;
	private String name;

	private HashMap<String, String> levelMap = new HashMap<String, String>();// 判断范围表达式,等级
	private HashMap<String, LevelExpr> lvExprMap = new HashMap<String, LevelExpr>();// 等级，等级表达关系对象

	public ItemStd(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ItemStd setLevel(String expr, String level) {
		levelMap.put(expr, level);
		return this;
	}

	public HashMap<String, String> getLevelMap() {
		return levelMap;
	}
	
	/**
	 * 根据分数获取等级
	 * @param val
	 * @return
	 */
	public abstract String getLevel(double val);
	
	/**
	 * 根据分数获取分数范围
	 * @param val
	 * @return
	 */
	public abstract String getRange(double val);

	public ItemStd setLvExpr(String level, String explain, String eval,
			String suggest) {
		this.lvExprMap.put(level, new LevelExpr(level, explain, eval, suggest));
		return this;
	}

	public ItemStd setLvExpr(LevelExpr lvExpr) {
		this.lvExprMap.put(lvExpr.getLevel(), lvExpr);
		return this;
	}

	public LevelExpr getLvExpr(String level) {
		return lvExprMap.get(level);
	}

	public LevelExpr getLvExpr(double val) {
		return lvExprMap.get(getLevel(val));
	}

	public String getLvExplain(String level) {
		LevelExpr tmp = lvExprMap.get(level);
		return tmp == null ? null : tmp.getExplain();
	}

	public String getSuggest(String level) {
		LevelExpr tmp = lvExprMap.get(level);
		return tmp == null ? null : tmp.getSuggest();
	}

	public String getEval(String level) {
		LevelExpr tmp = lvExprMap.get(level);
		return tmp == null ? null : tmp.getEval();
	}

	public String getLvExplain(double val) {
		LevelExpr tmp = lvExprMap.get(getLevel(val));
		return tmp == null ? null : tmp.getExplain();
	}

	public String getSuggest(double val) {
		LevelExpr tmp = lvExprMap.get(getLevel(val));
		return tmp == null ? null : tmp.getSuggest();
	}

	public String getEval(double val) {
		LevelExpr tmp = lvExprMap.get(getLevel(val));
		return tmp == null ? null : tmp.getEval();
	}

	@Override
	public String toString() {
		StringBuilder sbd = new StringBuilder(getClass().getSimpleName() + "{");
		sbd.append("ID=" + id).append(C.COMMOA_BANK);
		sbd.append("名称=" + name).append(C.COMMOA_BANK);
		sbd.append("等级关系=" + levelMap).append(C.COMMOA_BANK);
		sbd.append("等级内容=").append(lvExprMap).append("}");
		return sbd.toString();
	}

}
