package com.hd.jy.oasm.domain;

import java.util.Date;

public class LbBz {

    private Integer pzid;//����id

//    private String rjlbid;//�������id
//
//    private String rclbid;//�ճ�����id
//
//    private String zqlbid;//��������id

    private String cjlbid;//��������id

    private Date qysj;//����ʱ��

    private String qyr;//������

    private String zt;//״̬(0δ���ã�1������ ע��ֻ��һ������״̬��)

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