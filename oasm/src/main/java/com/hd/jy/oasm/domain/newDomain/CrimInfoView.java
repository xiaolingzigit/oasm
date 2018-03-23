/**
 * @auto quite
 * 
 */
package com.hd.jy.oasm.domain.newDomain;

import java.util.List;

import com.hd.jy.oasm.domain.BGwxlx;
import com.hd.jy.oasm.domain.SearchElement;
import com.hd.jy.oasm.domain.TevalReport;
import com.hd.jy.oasm.domain.ViewDafxjg;
//import com.hd.jy.oasm.domain.ZCYCYQPC;

/**
 * TODO 用于封装所有的list集合
 * @author quite
 * @data 2018年1月6日
 * @see  
 * 
 */
public class CrimInfoView {
    private List<TevalReport> report; //封装已有分数评估报告
    
//    private List<ZCYCYQPC> ycyqpc; //封装异常狱情排查
    
    private List<ViewDafxjg> dafxjg; //封装档案分析结果
    
    private List<Viewpggl> grft; //封装个人访谈
    
    private List<Viewpggl> grgc; //封装个人观察
    
    private List<SearchElement> element; //封装心理测试报告
    
    private List<BGwxlx> wxlxReport; //封装危险类型倾向
    
    private Pgbg pgbg; //封装评估报告的因子

    
	public Pgbg getPgbg() {
		return pgbg;
	}

	public void setPgbg(Pgbg pgbg) {
		this.pgbg = pgbg;
	}

	public List<BGwxlx> getWxlxReport() {
		return wxlxReport;
	}

	public void setWxlxReport(List<BGwxlx> wxlxReport) {
		this.wxlxReport = wxlxReport;
	}

	public List<TevalReport> getReport() {
		return report;
	}

	public void setReport(List<TevalReport> report) {
		this.report = report;
	}

//	public List<ZCYCYQPC> getYcyqpc() {
//		return ycyqpc;
//	}
//
//	public void setYcyqpc(List<ZCYCYQPC> ycyqpc) {
//		this.ycyqpc = ycyqpc;
//	}

	public List<ViewDafxjg> getDafxjg() {
		return dafxjg;
	}

	public void setDafxjg(List<ViewDafxjg> dafxjg) {
		this.dafxjg = dafxjg;
	}

	public List<Viewpggl> getGrft() {
		return grft;
	}

	public void setGrft(List<Viewpggl> grft) {
		this.grft = grft;
	}

	public List<Viewpggl> getGrgc() {
		return grgc;
	}

	public void setGrgc(List<Viewpggl> grgc) {
		this.grgc = grgc;
	}

	public List<SearchElement> getElement() {
		return element;
	}

	public void setElement(List<SearchElement> element) {
		this.element = element;
	}
    
    
}
