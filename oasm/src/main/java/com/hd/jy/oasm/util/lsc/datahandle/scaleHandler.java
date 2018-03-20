package com.hd.jy.oasm.util.lsc.datahandle;

import java.util.List;

public class scaleHandler {
	// 处理方式,判断条件1#@成立结果1#&判断条件2#@成立结果2#&...#$失败结果
	// 2、字符判断：匹配，包含，以之开头，以之结尾
	// 基本数值运算，判断规则，和/或关系，
	
	
	//量表ID,条目ID,条目名称,处理方式,(输入值类型),
	
	
	public static void main(String[] args) {
		System.out.println(ComparUtil.isFit("t<=5|", 6));
		//System.out.println(RelatUtil.isFit(0, true, "-+"));
	}
	
	public static String handle(String val,String rule){
		
		return null;
	}
	
	
	public static String isfit(String val,String rule){
		//
		
		return null;
	}
	
	public static String screen(List<AnalyFactor> vals,List<ScaleRule> rules){
		
		
		return null;
	}
	
	public  static class AnalyFactor {
		public String dim;
		public String factor;
		public double val;
		
		public AnalyFactor() {
			
		}
		
		public AnalyFactor(String dim, String factor,double val) {
			this.dim = dim;
			this.factor = factor;
			this.val = val;
		}
	}
	
	public  static class ScaleRule {
	
	}
}
