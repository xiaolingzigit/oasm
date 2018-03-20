package com.hd.jy.oasm.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 评估报告的罪犯基础信息
 * @author quite
 *
 */
public class Viewgrpgbgxx {
    private String bh; //囚犯编号

    private String xm; //姓名

    private String xbdm;//性别代码

    private Date csrq;//出生日期

    private String mzdm;//民族代码

    private String whcddm;//捕前文化程度

    private String bqzy;//捕前职业

    private int xfcs;//刑罚次数

    private String gyjqmc;//关押监区名称

    private String lydwbm;//数据来源编码

    private String bqmm;//捕前政治面貌

    private String hyzkdm;//婚姻状况代码

    private String gtfzlxdm;//共同参与类型

    private BigDecimal sg;//身高

    private BigDecimal tz;//体重

    private String xq;//刑期

    private Date qr;//刑罚开始日期

    private Date zr;//刑罚结束日期

    private String bznx;//剥夺政治权限期限

    private int qzcj;//是否祛除出境

    private String bdlbdm;//刑罚变动类别代码

    private int xzjx;//是否限制减刑
    private String aflbdm;//案犯类别

    private String mscc;//没收财产情况

    private BigDecimal fj;//罚金

    private String zkxz1dm;//重控性质1

    private String zkxz2dm;//重控性质2

    private String zklbdm;//重控类别

    private String fzss;//犯罪事实

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getXbdm() {
        return xbdm;
    }

    public void setXbdm(String xbdm) {
        this.xbdm = xbdm == null ? null : xbdm.trim();
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getMzdm() {
        return mzdm;
    }

    public void setMzdm(String mzdm) {
        this.mzdm = mzdm == null ? null : mzdm.trim();
    }

    public String getWhcddm() {
        return whcddm;
    }

    public void setWhcddm(String whcddm) {
        this.whcddm = whcddm == null ? null : whcddm.trim();
    }

    public String getBqzy() {
        return bqzy;
    }

    public void setBqzy(String bqzy) {
        this.bqzy = bqzy == null ? null : bqzy.trim();
    }

    public int getXfcs() {
        return xfcs;
    }

    public void setXfcs(int xfcs) {
        this.xfcs = xfcs;
    }

    public String getGyjqmc() {
        return gyjqmc;
    }

    public void setGyjqmc(String gyjqmc) {
        this.gyjqmc = gyjqmc == null ? null : gyjqmc.trim();
    }

    public String getLydwbm() {
        return lydwbm;
    }

    public void setLydwbm(String lydwbm) {
        this.lydwbm = lydwbm == null ? null : lydwbm.trim();
    }

    public String getBqmm() {
        return bqmm;
    }

    public void setBqmm(String bqmm) {
        this.bqmm = bqmm == null ? null : bqmm.trim();
    }

    public String getHyzkdm() {
        return hyzkdm;
    }

    public void setHyzkdm(String hyzkdm) {
        this.hyzkdm = hyzkdm == null ? null : hyzkdm.trim();
    }

    public String getGtfzlxdm() {
        return gtfzlxdm;
    }

    public void setGtfzlxdm(String gtfzlxdm) {
        this.gtfzlxdm = gtfzlxdm == null ? null : gtfzlxdm.trim();
    }

    public BigDecimal getSg() {
        return sg;
    }

    public void setSg(BigDecimal sg) {
        this.sg = sg;
    }

    public BigDecimal getTz() {
        return tz;
    }

    public void setTz(BigDecimal tz) {
        this.tz = tz;
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq == null ? null : xq.trim();
    }

    public Date getQr() {
        return qr;
    }

    public void setQr(Date qr) {
        this.qr = qr;
    }

    public Date getZr() {
        return zr;
    }

    public void setZr(Date zr) {
        this.zr = zr;
    }

    public String getBznx() {
        return bznx;
    }

    public void setBznx(String bznx) {
        this.bznx = bznx == null ? null : bznx.trim();
    }

    public int getQzcj() {
        return qzcj;
    }

    public void setQzcj(int qzcj) {
        this.qzcj = qzcj;
    }

    public String getBdlbdm() {
        return bdlbdm;
    }

    public void setBdlbdm(String bdlbdm) {
        this.bdlbdm = bdlbdm == null ? null : bdlbdm.trim();
    }

    public int getXzjx() {
        return xzjx;
    }

    public void setXzjx(int xzjx) {
        this.xzjx = xzjx;
    }

    public String getAflbdm() {
        return aflbdm;
    }

    public void setAflbdm(String aflbdm) {
        this.aflbdm = aflbdm == null ? null : aflbdm.trim();
    }

    public String getMscc() {
        return mscc;
    }

    public void setMscc(String mscc) {
        this.mscc = mscc == null ? null : mscc.trim();
    }

    public BigDecimal getFj() {
        return fj;
    }

    public void setFj(BigDecimal fj) {
        this.fj = fj;
    }

    public String getZkxz1dm() {
        return zkxz1dm;
    }

    public void setZkxz1dm(String zkxz1dm) {
        this.zkxz1dm = zkxz1dm == null ? null : zkxz1dm.trim();
    }

    public String getZkxz2dm() {
        return zkxz2dm;
    }

    public void setZkxz2dm(String zkxz2dm) {
        this.zkxz2dm = zkxz2dm == null ? null : zkxz2dm.trim();
    }

    public String getZklbdm() {
        return zklbdm;
    }

    public void setZklbdm(String zklbdm) {
        this.zklbdm = zklbdm == null ? null : zklbdm.trim();
    }

    public String getFzss() {
        return fzss;
    }

    public void setFzss(String fzss) {
        this.fzss = fzss == null ? null : fzss.trim();
    }
}