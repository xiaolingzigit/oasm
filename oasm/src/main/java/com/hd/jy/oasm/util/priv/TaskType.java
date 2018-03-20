package com.hd.jy.oasm.util.priv;

import java.util.HashMap;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

public class TaskType {
	/** �������� */
	public static final String FILE_ANLYSIS = "fileAnlys";
	/** COPA-PI������� */
	public static final String MT_COPA_PI = "copaMt";
	/** SCL-90������� */
	public static final String MT_SCL90 = "scl90Mt";
	/** ������� */
	public static final String IN_REPORT = "inRep";
	/** ���ṹ�Է�̸ */
	public static final String IN_TALK = "inTk";
	/** ��༯���̸ */
	public static final String IN_TALK2 = "inTk2";
	/** �����Ϊ�۲� */
	public static final String IN_ACTION = "inAct";
	/** ���������� */
	public static final String IN_MENTAL_TEST = "inMt";
	/** �ճ����� */
	public static final String DAILY_REPORT = "dyRep";
	/** �ճ���Ϊ�۲� */
	public static final String DAILY_ACTION = "dyAct";
	/** �������� */
	public static final String MID_REPORT = "mdRep";
	/** ���ڽṹ�Է�̸ */
	public static final String MID_TALK = "mdTk";
	/** ������Ϊ�۲� */
	public static final String MID_ACTION = "mdAct";
	/** �������� */
	public static final String OUT_REPORT = "otRep";
	/** ����ṹ�Է�̸ */
	public static final String OUT_TALK = "otTk";
	/** ������Ϊ�۲� */
	public static final String OUT_ACTION = "otAct";
	/** �����Ӧ��������� */
	public static final String OUT_MENTAL_TEST = "otMt";

	private static final HashMap<String, Type> map = new HashMap<>();

	static {
		map.put(FILE_ANLYSIS, new Type("fileAnlys", "��������", null));
		map.put(MT_COPA_PI, new Type("copaMt", "COPA-PI�������", null));
		map.put(MT_SCL90, new Type("scl90Mt", "SCL-90�������", null));
		map.put(IN_REPORT, new Type("inRep", "�������", null));
		map.put(IN_TALK, new Type("inTk", "���ṹ�Է�̸", null));
		map.put(IN_TALK2, new Type("inTk2", "��༯���̸", null));
		map.put(IN_ACTION, new Type("inAct", "�����Ϊ�۲�", null));
		map.put(IN_MENTAL_TEST, new Type("inMt", "����������", null));
		map.put(DAILY_REPORT, new Type("dyRep", "�ճ�����", null));
		map.put(DAILY_ACTION, new Type("dyAct", "�ճ���Ϊ�۲�", null));
		map.put(MID_REPORT, new Type("mdRep", "��������", null));
		map.put(MID_TALK, new Type("mdTk", "���ڽṹ�Է�̸", null));
		map.put(MID_ACTION, new Type("mdAct", "������Ϊ�۲�", null));
		map.put(OUT_REPORT, new Type("otRep", "��������", null));
		map.put(OUT_TALK, new Type("otTk", "����ṹ�Է�̸", null));
		map.put(OUT_ACTION, new Type("otAct", "������Ϊ�۲�", null));
		map.put(OUT_MENTAL_TEST, new Type("otMt", "�����Ӧ���������", null));
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
