package com.hd.jy.oasm.domain;

import java.math.BigDecimal;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * ��ɱ�����ף����ӣ��ٷ���Σ������
 * TODO
 * @author quite
 * @data 2017��12��27��
 * @see  ӳ���ļ�TestMapper.xml
 *
 */
public class BGwxlx extends BasicModel{
	private String rwid; //������
    private String wxlx; //Σ������
	private BigDecimal fs; //����
    private String dj; //�ȼ�
    private String bz; //��ע

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