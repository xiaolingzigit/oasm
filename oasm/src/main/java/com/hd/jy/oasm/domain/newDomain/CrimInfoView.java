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
 * TODO ���ڷ�װ���е�list����
 * @author quite
 * @data 2018��1��6��
 * @see  
 * 
 */
public class CrimInfoView {
    private List<TevalReport> report; //��װ���з�����������
    
//    private List<ZCYCYQPC> ycyqpc; //��װ�쳣�����Ų�
    
    private List<ViewDafxjg> dafxjg; //��װ�����������
    
    private List<Viewpggl> grft; //��װ���˷�̸
    
    private List<Viewpggl> grgc; //��װ���˹۲�
    
    private List<SearchElement> element; //��װ������Ա���
    
    private List<BGwxlx> wxlxReport; //��װΣ����������
    
    private Pgbg pgbg; //��װ�������������

    
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
