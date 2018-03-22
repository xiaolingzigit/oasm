package com.hd.jy.oasm.domain;

import java.util.Date;

public class LbBz {

    private Integer pzid;//配置id

//    private String rjlbid;//入监量表id
//
//    private String rclbid;//日常量表id
//
//    private String zqlbid;//中期量表id

    private String cjlbid;//出监量表id

    private Date qysj;//启用时间

    private String qyr;//启用人

    private String zt;//状态(0未启用，1已启用 注（只有一个启用状态）)

    public Integer getPzid() {
        return pzid;
    }

    public void setPzid(Integer pzid) {
        this.pzid = pzid;
    }

//    public String getRjlbid() {
//        return rjlbid;
//    }
//
//    public void setRjlbid(String rjlbid) {
//        this.rjlbid = rjlbid == null ? null : rjlbid.trim();
//    }
//
//    public String getRclbid() {
//        return rclbid;
//    }
//
//    public void setRclbid(String rclbid) {
//        this.rclbid = rclbid == null ? null : rclbid.trim();
//    }
//
//    public String getZqlbid() {
//        return zqlbid;
//    }
//
//    public void setZqlbid(String zqlbid) {
//        this.zqlbid = zqlbid == null ? null : zqlbid.trim();
//    }

    public String getCjlbid() {
        return cjlbid;
    }

    public void setCjlbid(String cjlbid) {
        this.cjlbid = cjlbid == null ? null : cjlbid.trim();
    }

    public Date getQysj() {
        return qysj;
    }

    public void setQysj(Date qysj) {
        this.qysj = qysj;
    }

    public String getQyr() {
        return qyr;
    }

    public void setQyr(String qyr) {
        this.qyr = qyr == null ? null : qyr.trim();
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
    }
}