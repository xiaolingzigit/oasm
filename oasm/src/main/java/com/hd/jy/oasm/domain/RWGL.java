package com.hd.jy.oasm.domain;

import java.util.Date;
/***
 * 任务管理
 * @author quite
 *发布自动检索任务，发布任务，追踪任务
 */

//*******************先查出所有囚号，任务类型，完成状态<2，返回多个数据存到map中*******************************

//****************循环所有档案分析的数据，通过key-value的形式判断有没有这行数据*****************************************

//****************如果通过key（囚号）查询value里面没有数据则************************************************************

/**入监评估---根据入监
 * 
 * 
 *
 */
public class RWGL {
    private String rewglbh; //任务编号：囚号_任务类型_时间

    private Long qh; //囚号

    private String fbr; //发布人

    private String rwlx; //任务类型

    private Date fbsj; //发布时间

    private Date wcqx; //完成期限

    private Date xgsj; //最后修改时间

    private String rwyj; //任务依据

    private String rwms; //任务描述

    private int zjjh; //专教警号

    private String xjxm; //协警姓名

    private String wczt; //完成状态（1：未开始，2：未完成/暂存，3:已完成 ，4:任务已注销）

    public String getRewglbh() {
        return rewglbh;
    }

    public void setRewglbh(String rewglbh) {
        this.rewglbh = rewglbh == null ? null : rewglbh.trim();
    }

    public Long getQh() {
        return qh;
    }

    public void setQh(Long qh) {
        this.qh = qh;
    }

    public String getFbr() {
        return fbr;
    }

    public void setFbr(String fbr) {
        this.fbr = fbr == null ? null : fbr.trim();
    }

    public String getRwlx() {
        return rwlx;
    }

    public void setRwlx(String rwlx) {
        this.rwlx = rwlx == null ? null : rwlx.trim();
    }

    public Date getFbsj() {
        return fbsj;
    }

    public void setFbsj(Date fbsj) {
        this.fbsj = fbsj;
    }

    public Date getWcqx() {
        return wcqx;
    }

    public void setWcqx(Date wcqx) {
        this.wcqx = wcqx;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public String getRwyj() {
        return rwyj;
    }

    public void setRwyj(String rwyj) {
        this.rwyj = rwyj == null ? null : rwyj.trim();
    }

    public String getRwms() {
        return rwms;
    }

    public void setRwms(String rwms) {
        this.rwms = rwms == null ? null : rwms.trim();
    }

    public int getZjjh() {
        return zjjh;
    }

    public void setZjjh(int zjjh) {
        this.zjjh = zjjh;
    }

    public String getXjxm() {
        return xjxm;
    }

    public void setXjxm(String xjxm) {
        this.xjxm = xjxm == null ? null : xjxm.trim();
    }

    public String getWczt() {
        return wczt;
    }

    public void setWczt(String wczt) {
        this.wczt = wczt == null ? null : wczt.trim();
    }
}