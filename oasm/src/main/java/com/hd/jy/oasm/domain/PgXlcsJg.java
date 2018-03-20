package com.hd.jy.oasm.domain;
/**
 * 评估报告心理测试部分的分析结果行对象
 * @author admin
 */
public class PgXlcsJg {
	private String RWID;//评估任务ID,报告编号(囚号_任务类型 _发布时间YYYYMMDDHHMM)		
	private String QH;//囚号		
	private String XLWD;//心理测试维度	
	private String XLYZ;//心理测试因子	
	private double XLFS;//心理测试分数	
	private double XLTZ;//心理测试T值
	private String PGWD;//评估维度				
	private String PGYZ;//评估因子
	private double PGFS;//评估分数	
	private String BZ;//备注
	
	public PgXlcsJg() {
		
	}

	public PgXlcsJg(String rWID, String qH, String xLWD, String xLYZ,
			double xLFS, double xLTZ, String pGWD, String pGYZ, double pGFS,
			String bZ) {
		RWID = rWID;
		QH = qH;
		XLWD = xLWD;
		XLYZ = xLYZ;
		XLFS = xLFS;
		XLTZ = xLTZ;
		PGWD = pGWD;
		PGYZ = pGYZ;
		PGFS = pGFS;
		BZ = bZ;
	}

	public String getRWID() {
		return RWID;
	}

	public void setRWID(String rWID) {
		RWID = rWID;
	}

	public String getQH() {
		return QH;
	}

	public void setQH(String qH) {
		QH = qH;
	}

	public String getXLWD() {
		return XLWD;
	}

	public void setXLWD(String xLWD) {
		XLWD = xLWD;
	}

	public String getXLYZ() {
		return XLYZ;
	}

	public void setXLYZ(String xLYZ) {
		XLYZ = xLYZ;
	}

	public double getXLFS() {
		return XLFS;
	}

	public void setXLFS(double xLFS) {
		XLFS = xLFS;
	}

	public double getXLTZ() {
		return XLTZ;
	}

	public void setXLTZ(double xLTZ) {
		XLTZ = xLTZ;
	}

	public String getPGWD() {
		return PGWD;
	}

	public void setPGWD(String pGWD) {
		PGWD = pGWD;
	}

	public String getPGYZ() {
		return PGYZ;
	}

	public void setPGYZ(String pGYZ) {
		PGYZ = pGYZ;
	}

	public double getPGFS() {
		return PGFS;
	}

	public void setPGFS(double pGFS) {
		PGFS = pGFS;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String bZ) {
		BZ = bZ;
	}
}
