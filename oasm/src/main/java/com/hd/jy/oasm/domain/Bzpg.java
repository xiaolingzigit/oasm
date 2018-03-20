package com.hd.jy.oasm.domain;
/**
 * 
 * TODO
 * @author quite
 * @data 2017年12月26日
 * @see  
 * 备注-评估  用于计算危险等级和分数显示
 * 映射文件 testMapper.xml
 *
 */
public class Bzpg {
    private Integer wxdjbm; //危险等级编号
 
    private String wxdj; //危险等级

    private Integer zdf; //最低分

    private Integer zgf; //最高分

    private String lx; //类型

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