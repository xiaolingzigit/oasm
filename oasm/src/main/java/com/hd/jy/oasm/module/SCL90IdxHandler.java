package com.hd.jy.oasm.module;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import com.hd.jy.oasm.model.FactorNorm;
import com.hd.jy.oasm.model.ItemStd;
import com.hd.jy.oasm.model.LevelExpr;
import com.hd.jy.oasm.model.SCL90ItStd;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.FileUtil;
import com.hd.jy.oasm.util.lsc.datahandle.ComparUtil;
import com.hd.jy.oasm.util.priv.C;

/**
 * 
 * ��֢״��������
 * SCL-90��������������������������������֮һ���ǵ�ǰʹ����Ϊ�㷺�ľ����ϰ���������������������Э�������˴�ʮ���������˽��Լ����������̶ȡ�
 * ���������ö���Ϊ16�����ϵ��û�����Ҫ�������һ�����ڵ�״�����ش�������⡣ ������ר��ҽʦ��ָ����ʹ�ô�����
 * 
 * @author admin
 */
public class SCL90IdxHandler {
	
	public static final String F_QTH = "���廯";
	public static final String F_QPZ = "ǿ��֢״";
	public static final String F_RJGXMG = "�˼ʹ�ϵ����";
	public static final String F_YY = "����";
	public static final String F_JL = "����";
	public static final String F_DD = "�ж�";
	public static final String F_KB = "�ֲ�";
	public static final String F_PZ = "ƫִ";
	public static final String F_JSBX = "������";
	public static final String F_TEN = "��ʮ����";
	
	
	// ���ӣ������飨1,3,5��
	private final LinkedHashMap<String, String> factorQstGroupMap = new LinkedHashMap<String, String>();
	private final HashMap<String, FactorNorm> factorNormMap = new HashMap<String, FactorNorm>();
	// ����ʹ��ˮƽ�ȼ�
	// 0���᣺�Ծ��и����⣬�������ò���Ƶ�������أ�
	// 1�еȣ��Ծ��и���֢״�������س̶�Ϊ�ᵽ�жȣ�
	// 2ƫ�أ��Ծ����и���֢״����̶�Ϊ�е����أ�
	// 3���أ��Ծ���֢״��Ƶ�Ⱥ�ǿ�ȶ�ʮ�����ء�
	// String level, String expr
	private final HashMap<String, String> qstLevelMap = new HashMap<String, String>();
	// 1���ֳܷ���160�ģ�1-5��5�����֣�����ʾ����֢״��
	private final HashMap<String, String> totalScoreLevelMap = new HashMap<String, String>();
	// 2��������Ŀ������43�ģ�43��2�����ϣ�����ʾ�����⡣
	private final HashMap<String, String> totalPostiveLevelMap = new HashMap<String, String>();
	private final HashMap<String, ItemStd> itemStdMap = new HashMap<String, ItemStd>();

	// // 3�����ӷ֡�2�ġ�2-2.9Ϊ��� 3-3.8Ϊ�ж� 3.9������Ϊ�ضȡ�
	// // String expr,String level
	// private final HashMap<String, String> factorLevelMap = new
	// HashMap<String, String>();

	public SCL90IdxHandler() {
		init();
	}

	public void init() {
		initFactorQstMap();
		initFactorNormMap();
		initQstLevelMap();
		initItemStdMap();
		initMap();
	}

	/**
	 * ��ʼ�������������
	 */
	private void initFactorQstMap() {
		setFactorQstGroup(F_QTH, "1,4,12,27,40,42,48,49,52,53,56,58");
		setFactorQstGroup(F_QPZ, "3,9,10,28,38,45,46,51,55,65");
		setFactorQstGroup(F_RJGXMG, "6,21,34,36,37,41,61,69,73");
		setFactorQstGroup(F_YY, "5,14,15,20,22,26,29,30,31,32,54,71,79");
		setFactorQstGroup(F_JL, "2,17,23,33,39,57,72,78,80,86");
		setFactorQstGroup(F_DD, "11,24,63,67,74,81");
		setFactorQstGroup(F_KB, "13,25,47,50,70,75,82");
		setFactorQstGroup(F_PZ, "8,18,43,68,76,83");
		setFactorQstGroup(F_JSBX, "7,16,35,62,77,84,85,87,88,90");
		setFactorQstGroup(F_TEN, "19,44,59,60,64,66,89");
	}

	/**
	 * ��ʼ����ȫ�����ӷֳ�ģ
	 */
	private void initFactorNormMap() {

		setFactorNorm(F_QTH, new FactorNorm(F_QTH, 1.37, 0.48));
		setFactorNorm(F_DD, new FactorNorm(F_DD, 1.46, 0.55));
		setFactorNorm(F_QPZ, new FactorNorm(F_QPZ, 1.62, 0.58));
		setFactorNorm(F_KB, new FactorNorm(F_KB, 1.23, 0.41));
		setFactorNorm(F_RJGXMG, new FactorNorm(F_RJGXMG, 1.65, 0.61));
		setFactorNorm(F_PZ, new FactorNorm(F_PZ, 1.43, 0.57));
		setFactorNorm(F_YY, new FactorNorm(F_YY, 1.5, 0.59));
		setFactorNorm(F_JSBX, new FactorNorm(F_JSBX, 1.29, 0.42));
		setFactorNorm(F_JL, new FactorNorm(F_JL, 1.39, 0.43));
		// setFactorNorm(F_TEN, new FactorNorm(F_TEN, 0, 0));
	}

	/**
	 * ��ʼ��������ʹ��ˮƽ�ȼ�
	 */
	private void initQstLevelMap() {
		// 0û�У��Ծ����޸������⣨֢״����
		// 1���᣺�Ծ��и����⣬�������ò���Ƶ�������أ�
		// 2�еȣ��Ծ��и���֢״�������س̶�Ϊ�ᵽ�жȣ�
		// 3ƫ�أ��Ծ����и���֢״����̶�Ϊ�е����أ�
		// 4���أ��Ծ���֢״��Ƶ�Ⱥ�ǿ�ȶ�ʮ�����ء�
		setQstLevel("t<0.5", "û�У����Ҹо�û�����������е�֢״");
		setQstLevel("0.5<t<=1.5", "���ᣬ�����ò���Ƶ��");
		setQstLevel("1.5<t<=2.5", "�еȣ����س̶�Ϊ�ᵽ�ж�");
		setQstLevel("2.5<t<=3.5", "ƫ�أ��̶�Ϊ�е�����");
		setQstLevel("t>3.5", "���أ�֢״��Ƶ�Ⱥ�ǿ�ȶ�ʮ������");// 4
	}

	/**
	 * ��ʼ�������ӷ֣�ƽ���֣��ȼ�
	 */
	private void initMap() {
		// �ֳܷ���160�ģ�1-5��5�����֣�����ʾ����֢״��
		setTotalScoreLevel("t<=160", "����");
		setTotalScoreLevel("t>160", "����");
		// ������Ŀ������43�ģ�43��2�����ϣ�����ʾ�����⡣
		setTotalPostiveLevel("t<=43", "û����");
		setTotalPostiveLevel("t>43", "������");
	}

	/**
	 * ��ʼ��������ά�ȱ�׼
	 */
	private void initItemStdMap() {
		// ����ά�ȱ�׼��
		SCL90ItStd factor1 = new SCL90ItStd(F_QTH, F_QTH);
		SCL90ItStd factor2 = new SCL90ItStd(F_QPZ, F_QPZ);
		SCL90ItStd factor3 = new SCL90ItStd(F_RJGXMG, F_RJGXMG);
		SCL90ItStd factor4 = new SCL90ItStd(F_YY, F_YY);
		SCL90ItStd factor5 = new SCL90ItStd(F_JL, F_JL);
		SCL90ItStd factor6 = new SCL90ItStd(F_DD, F_DD);
		SCL90ItStd factor7 = new SCL90ItStd(F_KB, F_KB);
		SCL90ItStd factor8 = new SCL90ItStd(F_PZ, F_PZ);
		SCL90ItStd factor9 = new SCL90ItStd(F_JSBX, F_JSBX);
		// SCL90ItStd factor10 = new SCL90ItStd(F_TEN, F_TEN);

		setItemStd(factor1);
		setItemStd(factor2);
		setItemStd(factor3);
		setItemStd(factor4);
		setItemStd(factor5);
		setItemStd(factor6);
		setItemStd(factor7);
		setItemStd(factor8);
		setItemStd(factor9);

		ArrayList<String> list = null;
		try {
			//ClassLoader.getSystemResourceAsStream("scl90.txt")
			list = FileUtil.readToLines(
					 new ClassPathResource("scl90.txt").getInputStream(),
					Charset.forName("gbk"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String s : list) {
			String[] t = s.split("\\|");
			
			if (t.length != 4) {
				try {
					throw new Exception("���ݸ�ʽ����ȷ��" + s);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			ItemStd is = itemStdMap.get(DataUtil.trim(t[0]));
			if (is != null) {
				is.setLevel(t[1], t[1]);
				is.setLvExpr(t[1], t[2], "", t[3]);
			} else {
				throw new IllegalArgumentException("δ֪��ά������");
			}
		}
	}

	public LinkedHashMap<String, String> getFactorQstGroups() {
		return factorQstGroupMap;
	}

	private SCL90IdxHandler setFactorQstGroup(String factor, String qstGroup) {
		factorQstGroupMap.put(factor, DataUtil.trimBlank(qstGroup));
		return this;
	}

	public String getFactorQstGroup(String factor) {
		return factorQstGroupMap.get(factor);
	}

	private SCL90IdxHandler setFactorNorm(String factor, FactorNorm norm) {
		factorNormMap.put(factor, norm);
		return this;
	}

	public FactorNorm getFactorNorm(String factor) {
		return factorNormMap.get(factor);
	}

	public HashMap<String, String> getQstLevelMap() {
		return qstLevelMap;
	}

	private SCL90IdxHandler setQstLevel(String expr, String level) {
		qstLevelMap.put(expr, level);
		return this;
	}
	/**
	 * 	����֢״ʹ��ˮƽ
	 * @param val ����֢״����
	 * @return
	 */
	public String getQstLevel(double val) {
		for (Map.Entry<String, String> s : qstLevelMap.entrySet()) {
			if (ComparUtil.isFit(s.getKey(), val)) {
				return s.getValue();
			}
		}
		return C.UNKNOWN;
	}

	public SCL90IdxHandler setItemStd(ItemStd ItemStd) {
		itemStdMap.put(ItemStd.getId(), ItemStd);
		return this;
	}

	public ItemStd getItemStd(String factor) {
		return itemStdMap.get(factor);
	}

	public String getFactorName(String factor) {
		ItemStd tmp = itemStdMap.get(factor);
		return tmp == null ? null : tmp.getName();
	}

	public HashMap<String, String> getLevelMap(String factor) {
		ItemStd tmp = itemStdMap.get(factor);
		return tmp == null ? null : tmp.getLevelMap();
	}

	public String getFactorGpaRange(String factor, double factorGpa) {
		ItemStd itStd = itemStdMap.get(factor);

		if (itStd != null) {
			return itStd.getRange(factorGpa);
		} else {
			throw new IllegalArgumentException("factor[" + factor
					+ "] not found");
		}
	}

	public LevelExpr getLevelExpr(String factor, String level) {
		ItemStd tmp = itemStdMap.get(factor);
		return tmp == null ? null : tmp.getLvExpr(level);
	}
	
	/**
	 * 
	 * @param factor
	 * @param val ���ӷ�
	 * @return
	 */
	public LevelExpr getLevelExpr(String factor, double val) {
		ItemStd tmp = itemStdMap.get(factor);
		return tmp == null ? null : tmp.getLvExpr(val);
	}

	private SCL90IdxHandler setTotalScoreLevel(String expr, String level) {
		totalScoreLevelMap.put(expr, level);
		return this;
	}

	public String getTotalScoreLevel(double val) {
		for (Map.Entry<String, String> s : totalScoreLevelMap.entrySet()) {
			if (ComparUtil.isFit(s.getKey(), val)) {
				return s.getValue();
			}
		}
		return C.UNKNOWN;
	}

	private SCL90IdxHandler setTotalPostiveLevel(String expr, String level) {
		totalPostiveLevelMap.put(expr, level);
		return this;
	}

	public String getTotalPostiveLevel(double val) {
		for (Map.Entry<String, String> s : totalPostiveLevelMap.entrySet()) {
			if (ComparUtil.isFit(s.getKey(), val)) {
				return s.getValue();
			}
		}
		return C.UNKNOWN;
	}
}
