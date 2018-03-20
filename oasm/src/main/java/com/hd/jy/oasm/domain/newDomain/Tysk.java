package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/**
 * 修改设计因子表
 * @author quite
 *映射文件tyskAndwd.xml
 */
public class Tysk {
    private int ysid;  //元素ID

    private String ysbh;//元素编号4.7.7.7

    private String ysmc;//元素名称不UNIQUE允许重复

    private String yssx;//元素特质，值域：无，内在需求-稳定特质,内在需求-可变特质,环境刺激-日常改造行为

    private String sm;//说明	

    private String ytxz;//用途性质(用于管理显示时过滤)：0不作为维度或因子，1只作为因子，2只作为维度，3作为维度或因子

    private Double yzfz;//因子分值

    private int yzzpc;//因子总频次

    private int zsxgpc;//自杀相关频次

    private int xxxgpc;//行凶相关频次	

    private int ttxgpc;//脱逃相关频次	

    private int zfzxgpc;//再犯罪相关频次

    private Byte qyzt;//启用状态，值域：启用状态码	

    private Date cjsj;//创建时间

    private String cjrbh;//创建人编号，警号

    private Date xgsj;//修改时间

    private String xgrbh;//修改人编号

    public int getYsid() {
        return ysid;
    }

    public void setYsid(int ysid) {
        this.ysid = ysid;
    }

    public String getYsbh() {
        return ysbh;
    }

    public void setYsbh(String ysbh) {
        this.ysbh = ysbh == null ? null : ysbh.trim();
    }

    public String getYsmc() {
        return ysmc;
    }

    public void setYsmc(String ysmc) {
        this.ysmc = ysmc == null ? null : ysmc.trim();
    }

    public String getYssx() {
        return yssx;
    }

    public void setYssx(String yssx) {
        this.yssx = yssx == null ? null : yssx.trim();
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm == null ? null : sm.trim();
    }

    public String getYtxz() {
        return ytxz;
    }

    public void setYtxz(String ytxz) {
        this.ytxz = ytxz == null ? null : ytxz.trim();
    }

    public Double getYzfz() {
        return yzfz;
    }

    public void setYzfz(Double yzfz) {
        this.yzfz = yzfz;
    }

    public int getYzzpc() {
        return yzzpc;
    }

    public void setYzzpc(int yzzpc) {
        this.yzzpc = yzzpc;
    }

    public int getZsxgpc() {
        return zsxgpc;
    }

    public void setZsxgpc(int zsxgpc) {
        this.zsxgpc = zsxgpc;
    }

    public int getXxxgpc() {
        return xxxgpc;
    }

    public void setXxxgpc(int xxxgpc) {
        this.xxxgpc = xxxgpc;
    }

    public int getTtxgpc() {
        return ttxgpc;
    }

    public void setTtxgpc(int ttxgpc) {
        this.ttxgpc = ttxgpc;
    }

    public int getZfzxgpc() {
        return zfzxgpc;
    }

    public void setZfzxgpc(int zfzxgpc) {
        this.zfzxgpc = zfzxgpc;
    }

    public Byte getQyzt() {
        return qyzt;
    }

    public void setQyzt(Byte qyzt) {
        this.qyzt = qyzt;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public String getCjrbh() {
        return cjrbh;
    }

    public void setCjrbh(String cjrbh) {
        this.cjrbh = cjrbh == null ? null : cjrbh.trim();
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public String getXgrbh() {
        return xgrbh;
    }

    public void setXgrbh(String xgrbh) {
        this.xgrbh = xgrbh == null ? null : xgrbh.trim();
    }
}