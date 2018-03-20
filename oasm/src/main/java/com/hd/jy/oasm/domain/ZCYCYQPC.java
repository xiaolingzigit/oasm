package com.hd.jy.oasm.domain;

import java.util.Date;

public class ZCYCYQPC {
    private String guid; //记录唯一标识

    private String yqztbh; //狱情主体编号

    private String yqztmc; //狱情主体名称

    private Date fssj;  //狱情发生时间

    private String zljb; //狱情种类级别

    private String zlmc; //狱情种类名称

    private String yqjb; //狱情级别

    private String sfcz; //是否处置

    private String gjzlb; //关键字类别      从老版本导入的狱情记录存储汉字（2017年以前的狱情）；新版本存储狱情关键字类别代码。

    private String gjzmc; //关键字名称

    private String glyqbs; //关联狱情标识

    private String glyqOid;//关联狱情Oid

    private String sjjbs; //狱情升降级标识

    private String sjjsm; //狱情升降级说明

    private String yqlx; //狱情类型

    private String xzyqbs; //新增狱情标识

    private String xzyqOid; //新增狱情Oid

    private String gjxm; //异常狱情录入干警姓名

    private String jqmc; //狱情发生监区名称

    private String flag; //业务标识

    private String newFlag; //新旧数据标识

    private Date cjsj; //创建时间

    private Date xgsj; //修改时间

    private Date sbsj; //上班时间

    private String lydwbm; //数据来源单位-------单位标识码

    private String jczt; //检测状态
    
    private String yqms; //狱情描述

    private String yqfx; //狱情分析

    private String czqk; //初步处置情况

    private String czxg; //初步处置效果

    private String glyqsm; //关联狱情说明

    public String getYqms() {
        return yqms;
    }

    public void setYqms(String yqms) {
        this.yqms = yqms == null ? null : yqms.trim();
    }

    public String getYqfx() {
        return yqfx;
    }

    public void setYqfx(String yqfx) {
        this.yqfx = yqfx == null ? null : yqfx.trim();
    }

    public String getCzqk() {
        return czqk;
    }

    public void setCzqk(String czqk) {
        this.czqk = czqk == null ? null : czqk.trim();
    }

    public String getCzxg() {
        return czxg;
    }

    public void setCzxg(String czxg) {
        this.czxg = czxg == null ? null : czxg.trim();
    }

    public String getGlyqsm() {
        return glyqsm;
    }

    public void setGlyqsm(String glyqsm) {
        this.glyqsm = glyqsm == null ? null : glyqsm.trim();
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getYqztbh() {
        return yqztbh;
    }

    public void setYqztbh(String yqztbh) {
        this.yqztbh = yqztbh == null ? null : yqztbh.trim();
    }

    public String getYqztmc() {
        return yqztmc;
    }

    public void setYqztmc(String yqztmc) {
        this.yqztmc = yqztmc == null ? null : yqztmc.trim();
    }

    public Date getFssj() {
        return fssj;
    }

    public void setFssj(Date fssj) {
        this.fssj = fssj;
    }

    public String getZljb() {
        return zljb;
    }

    public void setZljb(String zljb) {
        this.zljb = zljb == null ? null : zljb.trim();
    }

    public String getZlmc() {
        return zlmc;
    }

    public void setZlmc(String zlmc) {
        this.zlmc = zlmc == null ? null : zlmc.trim();
    }

    public String getYqjb() {
        return yqjb;
    }

    public void setYqjb(String yqjb) {
        this.yqjb = yqjb == null ? null : yqjb.trim();
    }

    public String getSfcz() {
        return sfcz;
    }

    public void setSfcz(String sfcz) {
        this.sfcz = sfcz == null ? null : sfcz.trim();
    }

    public String getGjzlb() {
        return gjzlb;
    }

    public void setGjzlb(String gjzlb) {
        this.gjzlb = gjzlb == null ? null : gjzlb.trim();
    }

    public String getGjzmc() {
        return gjzmc;
    }

    public void setGjzmc(String gjzmc) {
        this.gjzmc = gjzmc == null ? null : gjzmc.trim();
    }

    public String getGlyqbs() {
        return glyqbs;
    }

    public void setGlyqbs(String glyqbs) {
        this.glyqbs = glyqbs == null ? null : glyqbs.trim();
    }

    public String getGlyqOid() {
        return glyqOid;
    }

    public void setGlyqOid(String glyqOid) {
        this.glyqOid = glyqOid == null ? null : glyqOid.trim();
    }

    public String getSjjbs() {
        return sjjbs;
    }

    public void setSjjbs(String sjjbs) {
        this.sjjbs = sjjbs == null ? null : sjjbs.trim();
    }

    public String getSjjsm() {
        return sjjsm;
    }

    public void setSjjsm(String sjjsm) {
        this.sjjsm = sjjsm == null ? null : sjjsm.trim();
    }

    public String getYqlx() {
        return yqlx;
    }

    public void setYqlx(String yqlx) {
        this.yqlx = yqlx == null ? null : yqlx.trim();
    }

    public String getXzyqbs() {
        return xzyqbs;
    }

    public void setXzyqbs(String xzyqbs) {
        this.xzyqbs = xzyqbs == null ? null : xzyqbs.trim();
    }

    public String getXzyqOid() {
        return xzyqOid;
    }

    public void setXzyqOid(String xzyqOid) {
        this.xzyqOid = xzyqOid == null ? null : xzyqOid.trim();
    }

    public String getGjxm() {
        return gjxm;
    }

    public void setGjxm(String gjxm) {
        this.gjxm = gjxm == null ? null : gjxm.trim();
    }

    public String getJqmc() {
        return jqmc;
    }

    public void setJqmc(String jqmc) {
        this.jqmc = jqmc == null ? null : jqmc.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag == null ? null : newFlag.trim();
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public Date getSbsj() {
        return sbsj;
    }

    public void setSbsj(Date sbsj) {
        this.sbsj = sbsj;
    }

    public String getLydwbm() {
        return lydwbm;
    }

    public void setLydwbm(String lydwbm) {
        this.lydwbm = lydwbm == null ? null : lydwbm.trim();
    }

    public String getJczt() {
        return jczt;
    }

    public void setJczt(String jczt) {
        this.jczt = jczt == null ? null : jczt.trim();
    }
}