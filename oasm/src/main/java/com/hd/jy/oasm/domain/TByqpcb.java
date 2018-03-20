package com.hd.jy.oasm.domain;
//狱情排查表
import java.util.Date;

public class TByqpcb {
    private int id;

    private Date rq;	//日期

    private String sfyc; 	//是否异常

    private String ycnr; 	//异常内容

    private String zfxl1; 	//罪犯心理状况、思想波动是否异常

    private String zfxl2;	//罪犯心理状况、思想波动备注

    private String lggzxcsfyc; 	//劳改改造现场是否异常

    private String lggzxcbz; //劳改改造现场备注

    private String shjyxjsfyc;	//生活、教育心矫是否异常

    private String shjyxjbz;	//生活、教育心矫备注

    private String hjsfyc;	//会见是否异常

    private String hjbz;	//会见备注

    private String stzksfyc;	//身体状况是否异常

    private String stzkbz; 	//身体状况备注

    private int qh;	//罪犯信息

    private int pglxb;	//评估类型表


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

    public String getZfxl1() {
        return zfxl1;
    }

    public void setZfxl1(String zfxl1) {
        this.zfxl1 = zfxl1 == null ? null : zfxl1.trim();
    }

    public String getZfxl2() {
        return zfxl2;
    }

    public void setZfxl2(String zfxl2) {
        this.zfxl2 = zfxl2 == null ? null : zfxl2.trim();
    }

    public String getLggzxcsfyc() {
        return lggzxcsfyc;
    }

    public void setLggzxcsfyc(String lggzxcsfyc) {
        this.lggzxcsfyc = lggzxcsfyc == null ? null : lggzxcsfyc.trim();
    }

    public String getLggzxcbz() {
        return lggzxcbz;
    }

    public void setLggzxcbz(String lggzxcbz) {
        this.lggzxcbz = lggzxcbz == null ? null : lggzxcbz.trim();
    }

    public String getShjyxjsfyc() {
        return shjyxjsfyc;
    }

    public void setShjyxjsfyc(String shjyxjsfyc) {
        this.shjyxjsfyc = shjyxjsfyc == null ? null : shjyxjsfyc.trim();
    }

    public String getShjyxjbz() {
        return shjyxjbz;
    }

    public void setShjyxjbz(String shjyxjbz) {
        this.shjyxjbz = shjyxjbz == null ? null : shjyxjbz.trim();
    }

    public String getHjsfyc() {
        return hjsfyc;
    }

    public void setHjsfyc(String hjsfyc) {
        this.hjsfyc = hjsfyc == null ? null : hjsfyc.trim();
    }

    public String getHjbz() {
        return hjbz;
    }

    public void setHjbz(String hjbz) {
        this.hjbz = hjbz == null ? null : hjbz.trim();
    }

    public String getStzksfyc() {
        return stzksfyc;
    }

    public void setStzksfyc(String stzksfyc) {
        this.stzksfyc = stzksfyc == null ? null : stzksfyc.trim();
    }

    public String getStzkbz() {
        return stzkbz;
    }

    public void setStzkbz(String stzkbz) {
        this.stzkbz = stzkbz == null ? null : stzkbz.trim();
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