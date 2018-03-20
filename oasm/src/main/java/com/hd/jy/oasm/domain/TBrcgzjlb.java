package com.hd.jy.oasm.domain;

import java.util.Date;
//日常改造记录表
public class TBrcgzjlb {
    private int id;  //

    private Date rq;  //日期

    private String sfyc;  //是否异常

    private String ycnr;  //异常内容

    private String xxsfyc;  //学习是否异常

    private String xxbz;  //学习备注

    private String ldsfyc;  //劳动是否异常

    private String ldbz;  //劳动备注备注

    private String rzhzsfyc;  //认罪悔罪是否异常

    private String rzhzbz;   //认罪悔罪备注

    private String zksjsfyc;  //遵规守纪是否异常

    private String zksjbz;  //遵规守纪备注

    private String hjtxsfyc;  //会见通信是否异常

    private String hjtxbz;  //会见通信备注

    private String rjgxsfyc;  //人机关系是否异常

    private String rjgx;  //人机关系备注

    private int qh;  //罪犯信息

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

    public String getXxsfyc() {
        return xxsfyc;
    }

    public void setXxsfyc(String xxsfyc) {
        this.xxsfyc = xxsfyc == null ? null : xxsfyc.trim();
    }

    public String getXxbz() {
        return xxbz;
    }

    public void setXxbz(String xxbz) {
        this.xxbz = xxbz == null ? null : xxbz.trim();
    }

    public String getLdsfyc() {
        return ldsfyc;
    }

    public void setLdsfyc(String ldsfyc) {
        this.ldsfyc = ldsfyc == null ? null : ldsfyc.trim();
    }

    public String getLdbz() {
        return ldbz;
    }

    public void setLdbz(String ldbz) {
        this.ldbz = ldbz == null ? null : ldbz.trim();
    }

    public String getRzhzsfyc() {
        return rzhzsfyc;
    }

    public void setRzhzsfyc(String rzhzsfyc) {
        this.rzhzsfyc = rzhzsfyc == null ? null : rzhzsfyc.trim();
    }

    public String getRzhzbz() {
        return rzhzbz;
    }

    public void setRzhzbz(String rzhzbz) {
        this.rzhzbz = rzhzbz == null ? null : rzhzbz.trim();
    }

    public String getZksjsfyc() {
        return zksjsfyc;
    }

    public void setZksjsfyc(String zksjsfyc) {
        this.zksjsfyc = zksjsfyc == null ? null : zksjsfyc.trim();
    }

    public String getZksjbz() {
        return zksjbz;
    }

    public void setZksjbz(String zksjbz) {
        this.zksjbz = zksjbz == null ? null : zksjbz.trim();
    }

    public String getHjtxsfyc() {
        return hjtxsfyc;
    }

    public void setHjtxsfyc(String hjtxsfyc) {
        this.hjtxsfyc = hjtxsfyc == null ? null : hjtxsfyc.trim();
    }

    public String getHjtxbz() {
        return hjtxbz;
    }

    public void setHjtxbz(String hjtxbz) {
        this.hjtxbz = hjtxbz == null ? null : hjtxbz.trim();
    }

    public String getRjgxsfyc() {
        return rjgxsfyc;
    }

    public void setRjgxsfyc(String rjgxsfyc) {
        this.rjgxsfyc = rjgxsfyc == null ? null : rjgxsfyc.trim();
    }

    public String getRjgx() {
        return rjgx;
    }

    public void setRjgx(String rjgx) {
        this.rjgx = rjgx == null ? null : rjgx.trim();
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