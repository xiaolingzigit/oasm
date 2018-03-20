package com.hd.jy.oasm.domain;

import java.math.BigDecimal;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * 自杀，行凶，脱逃，再犯罪危险类型
 * TODO
 * @author quite
 * @data 2017年12月27日
 * @see  映射文件TestMapper.xml
 *
 */
public class BGwxlx extends BasicModel{
	private String rwid; //任务编号
    private String wxlx; //危险类型
	private BigDecimal fs; //分数
    private String dj; //等级
    private String bz; //备注

    public BGwxlx() {
  		
  	}
    
    public BGwxlx(String rwid, String wxlx, double fs, String dj, String bz) {
		this.rwid = rwid;
		this.wxlx = wxlx;
		this.fs = new BigDecimal(fs);
		this.dj = dj;
		this.bz = bz;
	}

	public String getRwid() {
		return rwid;
	}

	public void setRwid(String rwid) {
		this.rwid = rwid;
	}

	public String getWxlx() {
		return wxlx;
	}

	public void setWxlx(String wxlx) {
		this.wxlx = wxlx;
	}

	public BigDecimal getFs() {
        return fs;
    }

    public void setFs(BigDecimal fs) {
        this.fs = fs;
    }

    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj == null ? null : dj.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }
}