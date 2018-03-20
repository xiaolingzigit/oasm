package com.hd.jy.oasm.domain;
//专项评估报告分项解释
public class TBzxpgbgfxjx {
    private int id;

    private int qh;//罪犯信息

    private int zsqxjdfs;	//自杀倾向绝对分数

    private int zsqxpgfs;	//自杀倾向评估分数

    private String zsqxwxdj;	//自杀倾向危险等级

    private String zsqxsjjx;	//自杀倾向数据解释

    private int ttqxjdfs;	//脱逃倾向绝对分数

    private int ttqxpgfs;	//脱逃倾向评估分数

    private String ttqxwxdj;	//脱逃倾向危险等级

    private String ttqxsjjx;	//脱逃倾向数据解释

    private int xxqxjdfs;	//行凶倾向绝对分数

    private int xxqxwxdj;	//行凶倾向评估分数

    private String xxqxsjjx;	//行凶倾向危险等级

    private String ztjxwxlb;	//总体解释危险类别判断

    private String ztjxsjjx;	//总体解释数据解释

    private int pglxb;	//评估类型表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public int getZsqxjdfs() {
        return zsqxjdfs;
    }

    public void setZsqxjdfs(int zsqxjdfs) {
        this.zsqxjdfs = zsqxjdfs;
    }

    public int getZsqxpgfs() {
        return zsqxpgfs;
    }

    public void setZsqxpgfs(int zsqxpgfs) {
        this.zsqxpgfs = zsqxpgfs;
    }

    public String getZsqxwxdj() {
        return zsqxwxdj;
    }

    public void setZsqxwxdj(String zsqxwxdj) {
        this.zsqxwxdj = zsqxwxdj == null ? null : zsqxwxdj.trim();
    }

    public String getZsqxsjjx() {
        return zsqxsjjx;
    }

    public void setZsqxsjjx(String zsqxsjjx) {
        this.zsqxsjjx = zsqxsjjx == null ? null : zsqxsjjx.trim();
    }

    public int getTtqxjdfs() {
        return ttqxjdfs;
    }

    public void setTtqxjdfs(int ttqxjdfs) {
        this.ttqxjdfs = ttqxjdfs;
    }

    public int getTtqxpgfs() {
        return ttqxpgfs;
    }

    public void setTtqxpgfs(int ttqxpgfs) {
        this.ttqxpgfs = ttqxpgfs;
    }

    public String getTtqxwxdj() {
        return ttqxwxdj;
    }

    public void setTtqxwxdj(String ttqxwxdj) {
        this.ttqxwxdj = ttqxwxdj == null ? null : ttqxwxdj.trim();
    }

    public String getTtqxsjjx() {
        return ttqxsjjx;
    }

    public void setTtqxsjjx(String ttqxsjjx) {
        this.ttqxsjjx = ttqxsjjx == null ? null : ttqxsjjx.trim();
    }

    public int getXxqxjdfs() {
        return xxqxjdfs;
    }

    public void setXxqxjdfs(int xxqxjdfs) {
        this.xxqxjdfs = xxqxjdfs;
    }

    public int getXxqxwxdj() {
        return xxqxwxdj;
    }

    public void setXxqxwxdj(int xxqxwxdj) {
        this.xxqxwxdj = xxqxwxdj;
    }

    public String getXxqxsjjx() {
        return xxqxsjjx;
    }

    public void setXxqxsjjx(String xxqxsjjx) {
        this.xxqxsjjx = xxqxsjjx == null ? null : xxqxsjjx.trim();
    }

    public String getZtjxwxlb() {
        return ztjxwxlb;
    }

    public void setZtjxwxlb(String ztjxwxlb) {
        this.ztjxwxlb = ztjxwxlb == null ? null : ztjxwxlb.trim();
    }

    public String getZtjxsjjx() {
        return ztjxsjjx;
    }

    public void setZtjxsjjx(String ztjxsjjx) {
        this.ztjxsjjx = ztjxsjjx == null ? null : ztjxsjjx.trim();
    }

    public int getPglxb() {
        return pglxb;
    }

    public void setPglxb(int pglxb) {
        this.pglxb = pglxb;
    }
}