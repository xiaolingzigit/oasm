package com.hd.jy.oasm.domain;

/***
 * 结构访谈重构因子表
 * TODO
 * @author quite
 * @data 2018年1月2日
 * @see  映射文件TestMapper.xml
 *
 */
public class BGgtft{
    private String rwid; //任务编号
    
    private String qh; //囚号

    private int fs; //分数

    private String wd; //维度

    private String yz; //因子

    public String getRwid() {
        return rwid;
    }

    public void setRwid(String rwid) {
        this.rwid = rwid == null ? null : rwid.trim();
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd == null ? null : wd.trim();
    }

    public String getYz() {
        return yz;
    }

    public void setYz(String yz) {
        this.yz = yz == null ? null : yz.trim();
    }

    public String getQh() {
        return qh;
    }

    public void setQh(String qh) {
        this.qh = qh == null ? null : qh.trim();
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }
}