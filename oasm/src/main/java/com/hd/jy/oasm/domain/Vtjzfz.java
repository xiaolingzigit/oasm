package com.hd.jy.oasm.domain;
/**
 * @ClassName: Vtjzfz 
 * @Description: ͳ�Ƴ����ٷ�������
 * @author liangjiaying
 * @date 2018��1��12�� ����6:13:59
 */
public class Vtjzfz {
    private String jq;//����

    private Integer jg;//����

    private Integer gd;//�߶�

    private Integer zd;//�ж�

    private Integer dd;//�Ͷ�

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