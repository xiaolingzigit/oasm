package com.hd.jy.oasm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * 档案分析音系分析
 * @author admin
 *
 */
public class Dafxyzfx {
	//String维度名称, DimResult维度因子分析结果集合
	private HashMap<String, DimResult> dimMap = new HashMap<String, Dafxyzfx.DimResult>();
	
	public Dafxyzfx() {
		
	}

	public void addFactorResult(String dim, String result, String score) {
		DimResult dimResult = dimMap.get(dim);
		if(dimResult == null){
			dimResult = new DimResult(dim);
			dimMap.put(dim, dimResult);
		}
		dimResult.addFactorResult(result, score);
	}

	public HashMap<String, DimResult> getDimMap() {
		return dimMap;
	}

	public void setDimMap(HashMap<String, DimResult> dimMap) {
		this.dimMap = dimMap;
	}

	//维度因子分析结果集合
	public static class DimResult{
		private  String dim;
		private  List<FactorResult> factorList = new ArrayList<Dafxyzfx.FactorResult>();

		public DimResult() {
		}
		
		public DimResult(String dim) {
			this.dim = dim;
		}

		public String getDim() {
			return dim;
		}

		public void setDim(String dim) {
			this.dim = dim;
		}

		public List<FactorResult> getFactorList() {
			return factorList;
		}

		public void setFactorList(List<FactorResult> factorList) {
			this.factorList = factorList;
		}
		
		public void addFactorResult(String result, String score) {
			this.factorList.add(new FactorResult(result, score));
		}
	}	
	
	//因子分析结果
	public static class FactorResult{
		private  String result;
		private  String score;
		
		public FactorResult(String result, String score) {
			this.result = result;
			this.score = score;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		public String getScore() {
			return score;
		}

		public void setScore(String score) {
			this.score = score;
		}
	}

}
