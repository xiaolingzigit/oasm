package com.hd.jy.oasm.domain;
/**
 * @ClassName: Tzfzbh 
 * @Description: 保存再犯罪统计记录
 * @author liangjiaying
 * @date 2018年1月12日 下午6:28:22
 */
public class Tzfzbh {
    private Integer zfzbh; //再犯罪编号

    private String jq;//监区

    private String sj;//时间

    private Integer jg;//极高

    private Integer gd;//高度

    private Integer zd;//中度

    private Integer dd;//低度

    public Integer getZfzbh() {
        return zfzbh;
    }

    public void setZfzbh(Integer zfzbh) {
        this.zfzbh = zfzbh;
    }

    public String getJq() {
        return jq;
    }

    public void setJq(String jq) {
        this.jq = jq == null ? null : jq.trim();
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj == null ? null : sj.trim();
    }

    public Integer getJg() {
        return jg;
    }

    public void setJg(Integer jg) {
        this.jg = jg;
    }

    public Integer getGd() {
        return gd;
    }

    public void setGd(Integer gd) {
        this.gd = gd;
    }

    public Integer getZd() {
        return zd;
    }

    public void setZd(Integer zd) {
        this.zd = zd;
    }

    public Integer getDd() {
        return dd;
    }

    public void setDd(Integer dd) {
        this.dd = dd;
    }
}