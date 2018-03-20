package com.hd.jy.oasm.domain;
/***
 * 导入罪犯和警员关系表
 * @author quite
 *映射文件:TzyrymdMapper.xml
 */
public class Tjczjdx {
    private Long qh; //囚号

    private String xm; //姓名

    private String jh; //警号

    private String jhxm; //警员姓名
    
    private String xjbh; //协警编号

    private String xjxm; //协警姓名
    
    private int status; //导入插入或更新操作标识
    
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