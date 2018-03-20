package com.hd.jy.oasm.util.priv;

import java.util.HashMap;

import com.hd.jy.oasm.module.CopaIdxHandler;
import com.hd.jy.oasm.module.SCL90IdxHandler;

public class PgXl {
	
	public static final String PG_FZXL = "犯罪心理";
	public static final String PG_ZSZSZC = "自杀自伤自残";
	public static final String PG_BLXW = "暴力行为";
	public static final String PG_BL_DKGL = "暴力、对抗管理";

	private static HashMap<String, PgRang> map = new HashMap<String, PgXl.PgRang>();
	static {
		// copa
		map.put(CopaIdxHandler.D_P12, new PgRang(PG_FZXL, "犯罪思维", "T>=55", 3));
		map.put(CopaIdxHandler.D_P11, new PgRang(PG_FZXL, "变态心理", "T>=55", 3));
		map.put(CopaIdxHandler.D_P5, new PgRang(PG_ZSZSZC, "波动", "T>=55", 3));
		map.put(CopaIdxHandler.D_P8, new PgRang(PG_ZSZSZC, "自卑", "T>=55", 3));
		map.put(CopaIdxHandler.D_P9, new PgRang(PG_ZSZSZC, "焦虑", "T>=55", 3));
		map.put(CopaIdxHandler.D_P6, new PgRang(PG_BLXW, "冲动", "T>=55", 3));
		map.put(CopaIdxHandler.D_P10, new PgRang(PG_BLXW, "暴力倾向", "T>=55", 3));
		// scl90
		map.put(SCL90IdxHandler.F_QTH, new PgRang(PG_ZSZSZC, "躯体化", "T>=2", 4));
		map.put(SCL90IdxHandler.F_QPZ, new PgRang(PG_ZSZSZC, "强迫症状", "T>=2", 4));
		map.put(SCL90IdxHandler.F_YY, new PgRang(PG_ZSZSZC, "抑郁", "T>=2", 4));
		map.put(SCL90IdxHandler.F_JL, new PgRang(PG_ZSZSZC, "焦虑", "T>=2", 4));
		map.put(SCL90IdxHandler.F_RJGXMG, new PgRang(PG_BL_DKGL, "人际关系敏感",
				"T>=2", 3));
		map.put(SCL90IdxHandler.F_DD, new PgRang(PG_BL_DKGL, "敌对", "T>=2", 3));
		map.put(SCL90IdxHandler.F_PZ, new PgRang(PG_BL_DKGL, "偏执", "T>=2", 3));
		map.put(SCL90IdxHandler.F_JSBX, new PgRang(PG_BL_DKGL, "精神病性", "T>=2",
				3));
	}

	public static PgRang getPgRang(String xlIdx) {
		return map.get(xlIdx);
	}

	public static class PgRang {
		public String dim;
		public String factor;
		public String range;
		public double score;

		public PgRang(String dim, String factor, String range, double score) {
			this.dim = dim;
			this.range = range;
			this.score = score;
		}
	}
}
