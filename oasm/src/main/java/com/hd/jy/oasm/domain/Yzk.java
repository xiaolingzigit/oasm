package com.hd.jy.oasm.domain;

public class Yzk {
    private String flbm; //�������

    private String wdbm;//ά�ȱ���(wd������)

    private Integer yzbm;//���ӱ���
   
    private String yz; //���� 		����

    private Integer rjfs;//������

    private Integer rcfs;//�ճ�����

    private Integer zqfs;  //���ڷ���

    private Integer cjfs; //�������

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