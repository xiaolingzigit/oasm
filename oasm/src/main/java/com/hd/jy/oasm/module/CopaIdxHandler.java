package com.hd.jy.oasm.module;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.springframework.core.io.ClassPathResource;

import com.hd.jy.oasm.model.CopaItStd;
import com.hd.jy.oasm.model.DimNorm;
import com.hd.jy.oasm.model.ItemStd;
import com.hd.jy.oasm.model.LevelExpr;
import com.hd.jy.oasm.util.lsc.DataUtil;
import com.hd.jy.oasm.util.lsc.FileUtil;
import com.hd.jy.oasm.util.priv.C;

/**
 * 维度（dimension）、效度指标持有，和等级判断、解释、建议工具类
 * 
 * @author admin
 */
public class CopaIdxHandler {
	// 维度 名称 等级 含义 tip 反馈 评估
	public double T_COEFFICIENT = 10;// T参考系数
	public double T_CONSTANT = 50;// T参考常量
	public int Z_T_SCALE = 2;// Z值和T值保留小数位数

	public static final String D_P1 = "P1";
	public static final String D_P2 = "P2";
	public static final String D_P3 = "P3";
	public static final String D_P4 = "P4";
	public static final String D_P5 = "P5";
	public static final String D_P6 = "P6";
	public static final String D_P7 = "P7";
	public static final String D_P8 = "P8";
	public static final String D_P9 = "P9";
	public static final String D_P10 = "P10";
	public static final String D_P11 = "P11";
	public static final String D_P12 = "P12";
	public static final String D_L = "L";
	public static final String D_S = "S";

	public static final String L_T_1 = "低分";
	public static final String L_T_2 = "较低分";
	public static final String L_T_3 = "中等分";
	public static final String L_T_4 = "较高分";
	public static final String L_T_5 = "高分";

	public static final String E_T_1 = "T<=35";
	public static final String E_T_2 = "35<T<=45";
	public static final String E_T_3 = "45<T<55";
	public static final String E_T_4 = "55<=T<65";
	public static final String E_T_5 = "T>=65";

	public static final String L_LS_1 = "接受";
	public static final String L_LS_2 = "有条件接受";
	public static final String L_LS_3 = "拒绝";

	public static final String E_L_1 = "L<=3";
	public static final String E_L_2 = "3<L<5";
	public static final String E_L_3 = "L>=5";// 5~8

	public static final String E_S_1 = "S<=2";
	public static final String E_S_2 = "2<S<4";
	public static final String E_S_3 = "S>=4";// 4～6

	private final LinkedHashMap<String, String> dimQstGroupMap = new LinkedHashMap<String, String>();
	private final HashMap<String, DimNorm> dimNormMap = new LinkedHashMap<String, DimNorm>();
	// dim,is
	private final HashMap<String, ItemStd> itemStdMap = new LinkedHashMap<String, ItemStd>();

	public CopaIdxHandler() {// 参数定位量表
		init();
	}

	private void init() {

		initDimQstGroup();
		initDimNormMap();

		initItemStdMap();
	}

	private void initDimQstGroup() {

		setDimQstGroup(D_P1, "1,17,33,49,65,81,97,110");
		setDimQstGroup(D_P2, "2,18,34,50,66,82,98,111");
		setDimQstGroup(D_P3, "4,20,36,52,68,84,100,113");
		setDimQstGroup(D_P4, "6,22,38,54,70,86,101,114");
		setDimQstGroup(D_P5, "8,24,40,56,72,88,103,116");
		setDimQstGroup(D_P6, "10,26,42,58,74,90,105,118");
		setDimQstGroup(D_P7, "12,28,44,60,76,92,106,119");
		setDimQstGroup(D_P8, "14,30,46,62,78,94,108,121");
		setDimQstGroup(D_P9, "16,32,48,64,80,96,109,122");
		setDimQstGroup(D_P10, "3,19,35,51,67,83,11,27,43,59,75,91");
		setDimQstGroup(D_P11, "5,21,37,53,69,85,13,29,45,61,77,93");
		setDimQstGroup(D_P12, "7,23,39,55,71,87,9,15,31,47,63,79,95");

		setDimQstGroup(D_L, "9,25,41,57,73,89,104,117");

		setDimQstGroup(D_S, "99/30/" + C.J_EE + "/0/1,102/33/" + C.J_EE
				+ "/0/1,107/38/" + C.J_EE + "/0/1,112/42/" + C.J_EE
				+ "/0/1,115/50/" + C.J_EE + "/0/1,120/56/" + C.J_EE + "/0/1");

	}

	/**
	 * 初始化，Dim参考变量
	 */
	private void initDimNormMap() {

		// 维度 平均数 标准差
		// P1 4.7391 2.2534
		// P2 4.7577 2.0728
		// P3 6.7125 1.7471
		// P4 3.7024 2.1666
		// P5 3.8926 2.282
		// P6 3.6458 2.2558
		// P7 3.682 2.3367
		// P8 3.5449 2.3077
		// P9 4.1659 2.475 2
		// P10 4.1748 3.3549
		// P11 2.7356 2.6121
		// P12 5.4435 3.2294

		setDimNorm(D_P1, new DimNorm(D_P1, 4.7391, 2.2534));
		setDimNorm(D_P2, new DimNorm(D_P2, 4.7577, 2.0728));
		setDimNorm(D_P3, new DimNorm(D_P3, 6.7125, 1.7471));
		setDimNorm(D_P4, new DimNorm(D_P4, 3.7024, 2.1666));
		setDimNorm(D_P5, new DimNorm(D_P5, 3.8926, 2.282));
		setDimNorm(D_P6, new DimNorm(D_P6, 3.6458, 2.2558));
		setDimNorm(D_P7, new DimNorm(D_P7, 3.682, 2.3367));
		setDimNorm(D_P8, new DimNorm(D_P8, 3.5449, 2.3077));
		setDimNorm(D_P9, new DimNorm(D_P9, 4.1659, 2.475));
		setDimNorm(D_P10, new DimNorm(D_P10, 4.1748, 3.3549));
		setDimNorm(D_P11, new DimNorm(D_P11, 2.7356, 2.6121));
		setDimNorm(D_P12, new DimNorm(D_P12, 5.4435, 3.2294));
	}

	private void initItemStdMap() {
		// 创建维度标准，
		CopaItStd dimStd1 = new CopaItStd(D_P1, "外倾");
		CopaItStd dimStd2 = new CopaItStd(D_P2, "聪敏");
		CopaItStd dimStd3 = new CopaItStd(D_P3, "同情");
		CopaItStd dimStd4 = new CopaItStd(D_P4, "从属");
		CopaItStd dimStd5 = new CopaItStd(D_P5, "波动");
		CopaItStd dimStd6 = new CopaItStd(D_P6, "冲动");
		CopaItStd dimStd7 = new CopaItStd(D_P7, "戒备");
		CopaItStd dimStd8 = new CopaItStd(D_P8, "自卑");
		CopaItStd dimStd9 = new CopaItStd(D_P9, "焦虑");
		CopaItStd dimStd10 = new CopaItStd(D_P10, "暴力倾向");
		CopaItStd dimStd11 = new CopaItStd(D_P11, "变态心理");
		CopaItStd dimStd12 = new CopaItStd(D_P12, "犯罪思维");

		CopaItStd dimStdL = new CopaItStd(D_L, "说谎指标");
		CopaItStd dimStdS = new CopaItStd(D_S, "认真指标");

		setItemStd(dimStd1);
		setItemStd(dimStd2);
		setItemStd(dimStd3);
		setItemStd(dimStd4);
		setItemStd(dimStd5);
		setItemStd(dimStd6);
		setItemStd(dimStd7);
		setItemStd(dimStd8);
		setItemStd(dimStd9);
		setItemStd(dimStd10);
		setItemStd(dimStd11);
		setItemStd(dimStd12);

		setItemStd(dimStdL);
		setItemStd(dimStdS);

		// 设置标准T分数等级
		for (Entry<String, ItemStd> tmp : itemStdMap.entrySet()) {
			ItemStd is = tmp.getValue();
			if (is != null){
				is.setLevel(E_T_1, L_T_1);
				is.setLevel(E_T_2, L_T_2);
				is.setLevel(E_T_3, L_T_3);
				is.setLevel(E_T_4, L_T_4);
				is.setLevel(E_T_5, L_T_5);
			};
		}

		dimStdL.setLevel(E_L_1, L_LS_1);
		dimStdL.setLevel(E_L_2, L_LS_2);
		dimStdL.setLevel(E_L_3, L_LS_3);

		dimStdS.setLevel(E_L_1, L_LS_1);
		dimStdS.setLevel(E_L_2, L_LS_2);
		dimStdS.setLevel(E_L_3, L_LS_3);

		ArrayList<String> list = null;
		try {
			list = FileUtil.readToLines(
					new ClassPathResource("copa.txt").getInputStream(),
					Charset.forName("gbk"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String s : list) {
			String[] t = s.split("\\|");

			if (t.length != 5) {
				try {
					throw new Exception("数据格式不正确：" + s);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			ItemStd is = itemStdMap.get(DataUtil.trim(t[0]));
			if (is != null) {
				is.setLvExpr(t[1], t[2], t[3], t[4]);
			} else {
				throw new IllegalArgumentException("未知的维度名称");
			}
		}
	}

	/**
	 * 每个题用“,”隔开。
	 * 
	 * 格式1：题号1,题号2,...
	 * 
	 * 格式2: “题号/关联题号/关系/关系成立得分/关系不成立得分;...”
	 * 
	 * 支持关系：相同“eae”,均是"gag",均否"lal",不同"nae",左否又是"lag",左是又否"gal"
	 * 
	 * @param dim
	 * @param qstGroup
	 * @return
	 */
	public CopaIdxHandler setDimQstGroup(String dim, String qstGroup) {
		dimQstGroupMap.put(dim, DataUtil.trimBlank(qstGroup));
		return this;
	}

	public String getDimQstGroup(String dim) {
		return dimQstGroupMap.get(dim);
	}

	public HashMap<String, String> getDimQstGroups() {
		return dimQstGroupMap;
	}

	public CopaIdxHandler setDimNorm(String dim, DimNorm dimNorm) {
		dimNormMap.put(dim, dimNorm);
		return this;
	}

	public DimNorm getDimNorm(String dim) {
		return dimNormMap.get(dim);
	}

	public CopaIdxHandler setItemStd(ItemStd ItemStd) {
		itemStdMap.put(ItemStd.getId(), ItemStd);
		return this;
	}

	public ItemStd getItemStd(String dim) {
		return itemStdMap.get(dim);
	}

	public String getDimName(String dim) {
		ItemStd tmp = itemStdMap.get(dim);
		return tmp == null ? null : tmp.getName();
	}

	public HashMap<String, String> getLevelMap(String dim) {
		ItemStd tmp = itemStdMap.get(dim);
		return tmp == null ? null : tmp.getLevelMap();
	}

	public String getDimTRange(String dim, double tVal) {
		ItemStd itStd = itemStdMap.get(dim);

		if (itStd != null) {
			return itStd.getRange(tVal);
		} else {
			throw new IllegalArgumentException("dim[" + dim + "] not found");
		}
	}

	public LevelExpr getLevelExpr(String dim, String level) {
		ItemStd tmp = itemStdMap.get(dim);
		return tmp == null ? null : tmp.getLvExpr(level);
	}

	public LevelExpr getLevelExpr(String dim, double val) {
		ItemStd tmp = itemStdMap.get(dim);
		return tmp == null ? null : tmp.getLvExpr(val);
	}

}
