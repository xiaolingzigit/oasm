package com.hd.jy.oasm.domain;
/***
 * �����ﷸ�;�Ա��ϵ��
 * @author quite
 *ӳ���ļ�:TzyrymdMapper.xml
 */
public class Tjczjdx {
    private Long qh; //����

    private String xm; //����

    private String jh; //����

    private String jhxm; //��Ա����
    
    private String xjbh; //Э�����

    private String xjxm; //Э������
    
    private int status; //����������²�����ʶ
    
	public String getXjbh() {
		return xjbh;
	}

	public void setXjbh(String xjbh) {
		this.xjbh = xjbh;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getQh() {
        return qh;
    }

    public void setQh(Long qh) {
        this.qh = qh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh == null ? null : jh.trim();
    }

    public String getJhxm() {
        return jhxm;
    }

    public void setJhxm(String jhxm) {
        this.jhxm = jhxm == null ? null : jhxm.trim();
    }

    public String getXjxm() {
        return xjxm;
    }

    public void setXjxm(String xjxm) {
        this.xjxm = xjxm == null ? null : xjxm.trim();
    }
}