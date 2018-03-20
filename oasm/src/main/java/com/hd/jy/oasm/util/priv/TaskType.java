package com.hd.jy.oasm.util.priv;

import java.util.HashMap;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

public class TaskType {
	/** 档案分析 */
	public static final String FILE_ANLYSIS = "fileAnlys";
	/** COPA-PI心理测试 */
	public static final String MT_COPA_PI = "copaMt";
	/** SCL-90心理测试 */
	public static final String MT_SCL90 = "scl90Mt";
	/** 入监评估 */
	public static final String IN_REPORT = "inRep";
	/** 入监结构性访谈 */
	public static final String IN_TALK = "inTk";
	/** 入监集体访谈 */
	public static final String IN_TALK2 = "inTk2";
	/** 入监行为观察 */
	public static final String IN_ACTION = "inAct";
	/** 入监心理测试 */
	public static final String IN_MENTAL_TEST = "inMt";
	/** 日常评估 */
	public static final String DAILY_REPORT = "dyRep";
	/** 日常行为观察 */
	public static final String DAILY_ACTION = "dyAct";
	/** 中期评估 */
	public static final String MID_REPORT = "mdRep";
	/** 中期结构性访谈 */
	public static final String MID_TALK = "mdTk";
	/** 中期行为观察 */
	public static final String MID_ACTION = "mdAct";
	/** 出监评估 */
	public static final String OUT_REPORT = "otRep";
	/** 出监结构性访谈 */
	public static final String OUT_TALK = "otTk";
	/** 出监行为观察 */
	public static final String OUT_ACTION = "otAct";
	/** 社会适应性心理测试 */
	public static final String OUT_MENTAL_TEST = "otMt";

	private static final HashMap<String, Type> map = new HashMap<>();

	static {
		map.put(FILE_ANLYSIS, new Type("fileAnlys", "档案分析", null));
		map.put(MT_COPA_PI, new Type("copaMt", "COPA-PI心理测试", null));
		map.put(MT_SCL90, new Type("scl90Mt", "SCL-90心理测试", null));
		map.put(IN_REPORT, new Type("inRep", "入监评估", null));
		map.put(IN_TALK, new Type("inTk", "入监结构性访谈", null));
		map.put(IN_TALK2, new Type("inTk2", "入监集体访谈", null));
		map.put(IN_ACTION, new Type("inAct", "入监行为观察", null));
		map.put(IN_MENTAL_TEST, new Type("inMt", "入监心理测试", null));
		map.put(DAILY_REPORT, new Type("dyRep", "日常评估", null));
		map.put(DAILY_ACTION, new Type("dyAct", "日常行为观察", null));
		map.put(MID_REPORT, new Type("mdRep", "中期评估", null));
		map.put(MID_TALK, new Type("mdTk", "中期结构性访谈", null));
		map.put(MID_ACTION, new Type("mdAct", "中期行为观察", null));
		map.put(OUT_REPORT, new Type("otRep", "出监评估", null));
		map.put(OUT_TALK, new Type("otTk", "出监结构性访谈", null));
		map.put(OUT_ACTION, new Type("otAct", "出监行为观察", null));
		map.put(OUT_MENTAL_TEST, new Type("otMt", "社会适应性心理测试", null));
	}
	
	// private static boolean isInitedFromDB = false;
	// private static void initFromDb(){
	// isInitedFromDB = true;
	// }

	public static final class Type extends BasicModel {
		public final String code;
		public final String name;
		public final String note;

		public Type(String code, String name, String note) {
			this.code = code;
			this.name = name;
			this.note = note;
		}
	}

	public static Type getType(String typeCode) {
		return map.get(typeCode);
	}

	public static String getName(String typeCode) {
		Type tmp = map.get(typeCode);
		return tmp == null ? null : tmp.name;
	}

}
