package com.hd.jy.oasm.util.lsc.datahandle;

import java.util.List;

public class scaleHandler {
	// ����ʽ,�ж�����1#@�������1#&�ж�����2#@�������2#&...#$ʧ�ܽ��
	// 2���ַ��жϣ�ƥ�䣬��������֮��ͷ����֮��β
	// ������ֵ���㣬�жϹ��򣬺�/���ϵ��
	
	
	//����ID,��ĿID,��Ŀ����,����ʽ,(����ֵ����),
	
	
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
