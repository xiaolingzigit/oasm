package com.hd.jy.oasm.domain;
/**
 * 
 * TODO
 * @author quite
 * @data 2017��12��26��
 * @see  
 * ��ע-����  ���ڼ���Σ�յȼ��ͷ�����ʾ
 * ӳ���ļ� testMapper.xml
 *
 */
public class Bzpg {
    private Integer wxdjbm; //Σ�յȼ����
 
    private String wxdj; //Σ�յȼ�

    private Integer zdf; //��ͷ�

    private Integer zgf; //��߷�

    private String lx; //����

    public Integer getWxdjbm() {
        return wxdjbm;
    }

    public void setWxdjbm(Integer wxdjbm) {
        this.wxdjbm = wxdjbm;
    }

    public String getWxdj() {
        return wxdj;
    }

    public void setWxdj(String wxdj) {
        this.wxdj = wxdj == null ? null : wxdj.trim();
    }

    public Integer getZdf() {
        return zdf;
    }

    public void setZdf(Integer zdf) {
        this.zdf = zdf;
    }

    public Integer getZgf() {
        return zgf;
    }

    public void setZgf(Integer zgf) {
        this.zgf = zgf;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx == null ? null : lx.trim();
    }
}