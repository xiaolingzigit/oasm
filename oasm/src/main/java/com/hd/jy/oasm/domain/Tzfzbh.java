package com.hd.jy.oasm.domain;
/**
 * @ClassName: Tzfzbh 
 * @Description: �����ٷ���ͳ�Ƽ�¼
 * @author liangjiaying
 * @date 2018��1��12�� ����6:28:22
 */
public class Tzfzbh {
    private Integer zfzbh; //�ٷ�����

    private String jq;//����

    private String sj;//ʱ��

    private Integer jg;//����

    private Integer gd;//�߶�

    private Integer zd;//�ж�

    private Integer dd;//�Ͷ�

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