package com.hd.jy.oasm.util.priv;

import java.util.HashMap;

import com.hd.jy.oasm.module.CopaIdxHandler;
import com.hd.jy.oasm.module.SCL90IdxHandler;

public class PgXl {
	
	public static final String PG_FZXL = "��������";
	public static final String PG_ZSZSZC = "��ɱ�����Բ�";
	public static final String PG_BLXW = "������Ϊ";
	public static final String PG_BL_DKGL = "�������Կ�����";

	private static HashMap<String, PgRang> map = new HashMap<String, PgXl.PgRang>();
	static {
		// copa
		map.put(CopaIdxHandler.D_P12, new PgRang(PG_FZXL, "����˼ά", "T>=55", 3));
		map.put(CopaIdxHandler.D_P11, new PgRang(PG_FZXL, "��̬����", "T>=55", 3));
		map.put(CopaIdxHandler.D_P5, new PgRang(PG_ZSZSZC, "����", "T>=55", 3));
		map.put(CopaIdxHandler.D_P8, new PgRang(PG_ZSZSZC, "�Ա�", "T>=55", 3));
		map.put(CopaIdxHandler.D_P9, new PgRang(PG_ZSZSZC, "����", "T>=55", 3));
		map.put(CopaIdxHandler.D_P6, new PgRang(PG_BLXW, "�嶯", "T>=55", 3));
		map.put(CopaIdxHandler.D_P10, new PgRang(PG_BLXW, "��������", "T>=55", 3));
		// scl90
		map.put(SCL90IdxHandler.F_QTH, new PgRang(PG_ZSZSZC, "���廯", "T>=2", 4));
		map.put(SCL90IdxHandler.F_QPZ, new PgRang(PG_ZSZSZC, "ǿ��֢״", "T>=2", 4));
		map.put(SCL90IdxHandler.F_YY, new PgRang(PG_ZSZSZC, "����", "T>=2", 4));
		map.put(SCL90IdxHandler.F_JL, new PgRang(PG_ZSZSZC, "����", "T>=2", 4));
		map.put(SCL90IdxHandler.F_RJGXMG, new PgRang(PG_BL_DKGL, "�˼ʹ�ϵ����",
				"T>=2", 3));
		map.put(SCL90IdxHandler.F_DD, new PgRang(PG_BL_DKGL, "�ж�", "T>=2", 3));
		map.put(SCL90IdxHandler.F_PZ, new PgRang(PG_BL_DKGL, "ƫִ", "T>=2", 3));
		map.put(SCL90IdxHandler.F_JSBX, new PgRang(PG_BL_DKGL, "������", "T>=2",
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
