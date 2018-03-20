package com.hd.jy.oasm.domain;
/***
 * 基础档案分析量表，用于匹配档案的基础数据，得到因子和分数，生成档案报告
 * @author quite
 * 在Sjjgft.xml中调用
 *
 */
public class LBjcdafx {
    private int id; //编号

    private String wd; //维度

    private String yz; //因子

    private int minfz; //最小参数

    private int maxfz; //最大分数

    private int fs; //分数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMinfz() {
        return minfz;
    }

    public void setMinfz(int minfz) {
        this.minfz = minfz;
    }

    public int getMaxfz() {
        return maxfz;
    }

    public void setMaxfz(int maxfz) {
        this.maxfz = maxfz;
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }
}