package com.hd.jy.oasm.domain;
/**
 * ��������������Բ��ֵķ�������ж���
 * @author admin
 */
public class PgXlcsJg {
	private String RWID;//��������ID,������(����_�������� _����ʱ��YYYYMMDDHHMM)		
	private String QH;//����		
	private String XLWD;//�������ά��	
	private String XLYZ;//�����������	
	private double XLFS;//������Է���	
	private double XLTZ;//�������Tֵ
	private String PGWD;//����ά��				
	private String PGYZ;//��������
	private double PGFS;//��������	
	private String BZ;//��ע
	
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
