package com.hd.jy.oasm.domain;
/**
 * @ClassName: Vtjzfz 
 * @Description: 统计出监再犯罪倾向
 * @author liangjiaying
 * @date 2018年1月12日 下午6:13:59
 */
public class Vtjzfz {
    private String jq;//监区

    private Integer jg;//极高

    private Integer gd;//高度

    private Integer zd;//中度

    private Integer dd;//低度

    public String getJq() {
        return jq;
    }

    public void setJq(String jq) {
        this.jq = jq == null ? null : jq.trim();
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