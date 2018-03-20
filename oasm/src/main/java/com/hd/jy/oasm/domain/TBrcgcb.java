package com.hd.jy.oasm.domain;

import java.util.Date;
//日常观察表
public class TBrcgcb {
    private int id;

    private Date rq; //日期

    private String sfyc; //是否异常

    private String ycnr;  //异常内容

    private String flsfyc; //愤怒是否异常

    private String flsfwcsc; //愤怒是否完成生成任务

    private String flsfsb; //愤怒是否生病

    private String kjsfyc; //恐惧是否异常

    private String kjsfwcsc; //恐惧是否完成生成任务

    private String kjsfsb; //恐惧是否生病

    private String basfyc; //悲哀是否异常

    private String basfwcsc; //悲哀是否完成生成任务

    private String basfsb;  //悲哀是否生病

    private String pjsfyc;  //平静是否异常

    private String pjsfwcsc;  //平静是否完成生成任务

    private String pjsfsb;  //平静是否生病

    private String hxsfyc; //欢喜是否异常

    private String hxsfwcsc;  //欢喜是否完成生成任务

    private String hxsfsb; //欢喜是否生病

    private int qh; //罪犯信息

    private int pglxb;  //评估类型表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRq() {
        return rq;
    }

    public void setRq(Date rq) {
        this.rq = rq;
    }

    public String getSfyc() {
        return sfyc;
    }

    public void setSfyc(String sfyc) {
        this.sfyc = sfyc == null ? null : sfyc.trim();
    }

    public String getYcnr() {
        return ycnr;
    }

    public void setYcnr(String ycnr) {
        this.ycnr = ycnr == null ? null : ycnr.trim();
    }

    public String getFlsfyc() {
        return flsfyc;
    }

    public void setFlsfyc(String flsfyc) {
        this.flsfyc = flsfyc == null ? null : flsfyc.trim();
    }

    public String getFlsfwcsc() {
        return flsfwcsc;
    }

    public void setFlsfwcsc(String flsfwcsc) {
        this.flsfwcsc = flsfwcsc == null ? null : flsfwcsc.trim();
    }

    public String getFlsfsb() {
        return flsfsb;
    }

    public void setFlsfsb(String flsfsb) {
        this.flsfsb = flsfsb == null ? null : flsfsb.trim();
    }

    public String getKjsfyc() {
        return kjsfyc;
    }

    public void setKjsfyc(String kjsfyc) {
        this.kjsfyc = kjsfyc == null ? null : kjsfyc.trim();
    }

    public String getKjsfwcsc() {
        return kjsfwcsc;
    }

    public void setKjsfwcsc(String kjsfwcsc) {
        this.kjsfwcsc = kjsfwcsc == null ? null : kjsfwcsc.trim();
    }

    public String getKjsfsb() {
        return kjsfsb;
    }

    public void setKjsfsb(String kjsfsb) {
        this.kjsfsb = kjsfsb == null ? null : kjsfsb.trim();
    }

    public String getBasfyc() {
        return basfyc;
    }

    public void setBasfyc(String basfyc) {
        this.basfyc = basfyc == null ? null : basfyc.trim();
    }

    public String getBasfwcsc() {
        return basfwcsc;
    }

    public void setBasfwcsc(String basfwcsc) {
        this.basfwcsc = basfwcsc == null ? null : basfwcsc.trim();
    }

    public String getBasfsb() {
        return basfsb;
    }

    public void setBasfsb(String basfsb) {
        this.basfsb = basfsb == null ? null : basfsb.trim();
    }

    public String getPjsfyc() {
        return pjsfyc;
    }

    public void setPjsfyc(String pjsfyc) {
        this.pjsfyc = pjsfyc == null ? null : pjsfyc.trim();
    }

    public String getPjsfwcsc() {
        return pjsfwcsc;
    }

    public void setPjsfwcsc(String pjsfwcsc) {
        this.pjsfwcsc = pjsfwcsc == null ? null : pjsfwcsc.trim();
    }

    public String getPjsfsb() {
        return pjsfsb;
    }

    public void setPjsfsb(String pjsfsb) {
        this.pjsfsb = pjsfsb == null ? null : pjsfsb.trim();
    }

    public String getHxsfyc() {
        return hxsfyc;
    }

    public void setHxsfyc(String hxsfyc) {
        this.hxsfyc = hxsfyc == null ? null : hxsfyc.trim();
    }

    public String getHxsfwcsc() {
        return hxsfwcsc;
    }

    public void setHxsfwcsc(String hxsfwcsc) {
        this.hxsfwcsc = hxsfwcsc == null ? null : hxsfwcsc.trim();
    }

    public String getHxsfsb() {
        return hxsfsb;
    }

    public void setHxsfsb(String hxsfsb) {
        this.hxsfsb = hxsfsb == null ? null : hxsfsb.trim();
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public int getPglxb() {
        return pglxb;
    }

    public void setPglxb(int pglxb) {
        this.pglxb = pglxb;
    }
}