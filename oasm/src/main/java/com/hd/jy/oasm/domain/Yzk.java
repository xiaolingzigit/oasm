package com.hd.jy.oasm.domain;

public class Yzk {
    private String flbm; //分类编码

    private String wdbm;//维度编码(wd表的外键)

    private Integer yzbm;//因子编码
   
    private String yz; //因子 		主键

    private Integer rjfs;//入监分数

    private Integer rcfs;//日常分数

    private Integer zqfs;  //中期分数

    private Integer cjfs; //出监分数

    public String getFlbm() {
        return flbm;
    }

    public void setFlbm(String flbm) {
        this.flbm = flbm == null ? null : flbm.trim();
    }

    public String getWdbm() {
        return wdbm;
    }

    public void setWdbm(String wdbm) {
        this.wdbm = wdbm == null ? null : wdbm.trim();
    }

    public Integer getYzbm() {
        return yzbm;
    }

    public void setYzbm(Integer yzbm) {
        this.yzbm = yzbm;
    }

    public String getYz() {
        return yz;
    }

    public void setYz(String yz) {
        this.yz = yz == null ? null : yz.trim();
    }

    public Integer getRjfs() {
        return rjfs;
    }

    public void setRjfs(Integer rjfs) {
        this.rjfs = rjfs;
    }

    public Integer getRcfs() {
        return rcfs;
    }

    public void setRcfs(Integer rcfs) {
        this.rcfs = rcfs;
    }

    public Integer getZqfs() {
        return zqfs;
    }

    public void setZqfs(Integer zqfs) {
        this.zqfs = zqfs;
    }

    public Integer getCjfs() {
        return cjfs;
    }

    public void setCjfs(Integer cjfs) {
        this.cjfs = cjfs;
    }
}