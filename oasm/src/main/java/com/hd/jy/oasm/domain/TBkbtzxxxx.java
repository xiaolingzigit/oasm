package com.hd.jy.oasm.domain;

import java.util.Date;
//可变特质详细信息
public class TBkbtzxxxx {
    private int id;

    private String qqgx;  //亲情关系

    private String jtjg; //家庭结构

    private String jtbg; //家庭变故

    private String fshjzg; //反社会的价值观

    private String dzfkf;//对犯罪的看法

    private String qxwdx; //情绪稳定性

    private String rzzk;//认知状况

    private String xgqx;//性格缺陷

    private String cylx;//成瘾类型

    private String cycd;//成瘾程度

    private String stjkzk;//身体健康状况

    private String jbfjjb;//疾病分级鉴别

    private Date zdsj;//诊断时间

    private Date lszdsj;//历史诊断时间

    private Date jzjlsj;//就诊记录时间

    private int qh;//囚号

    private int pglxb;//评估类型

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQqgx() {
        return qqgx;
    }

    public void setQqgx(String qqgx) {
        this.qqgx = qqgx == null ? null : qqgx.trim();
    }

    public String getJtjg() {
        return jtjg;
    }

    public void setJtjg(String jtjg) {
        this.jtjg = jtjg == null ? null : jtjg.trim();
    }

    public String getJtbg() {
        return jtbg;
    }

    public void setJtbg(String jtbg) {
        this.jtbg = jtbg == null ? null : jtbg.trim();
    }

    public String getFshjzg() {
        return fshjzg;
    }

    public void setFshjzg(String fshjzg) {
        this.fshjzg = fshjzg == null ? null : fshjzg.trim();
    }

    public String getDzfkf() {
        return dzfkf;
    }

    public void setDzfkf(String dzfkf) {
        this.dzfkf = dzfkf == null ? null : dzfkf.trim();
    }

    public String getQxwdx() {
        return qxwdx;
    }

    public void setQxwdx(String qxwdx) {
        this.qxwdx = qxwdx == null ? null : qxwdx.trim();
    }

    public String getRzzk() {
        return rzzk;
    }

    public void setRzzk(String rzzk) {
        this.rzzk = rzzk == null ? null : rzzk.trim();
    }

    public String getXgqx() {
        return xgqx;
    }

    public void setXgqx(String xgqx) {
        this.xgqx = xgqx == null ? null : xgqx.trim();
    }

    public String getCylx() {
        return cylx;
    }

    public void setCylx(String cylx) {
        this.cylx = cylx == null ? null : cylx.trim();
    }

    public String getCycd() {
        return cycd;
    }

    public void setCycd(String cycd) {
        this.cycd = cycd == null ? null : cycd.trim();
    }

    public String getStjkzk() {
        return stjkzk;
    }

    public void setStjkzk(String stjkzk) {
        this.stjkzk = stjkzk == null ? null : stjkzk.trim();
    }

    public String getJbfjjb() {
        return jbfjjb;
    }

    public void setJbfjjb(String jbfjjb) {
        this.jbfjjb = jbfjjb == null ? null : jbfjjb.trim();
    }

    public Date getZdsj() {
        return zdsj;
    }

    public void setZdsj(Date zdsj) {
        this.zdsj = zdsj;
    }

    public Date getLszdsj() {
        return lszdsj;
    }

    public void setLszdsj(Date lszdsj) {
        this.lszdsj = lszdsj;
    }

    public Date getJzjlsj() {
        return jzjlsj;
    }

    public void setJzjlsj(Date jzjlsj) {
        this.jzjlsj = jzjlsj;
    }

    public int getQh() {
        return qh;
    }

    public void setQh(int qh) {
        this.qh = qh;
    }

    public int getPglxb() {
        return pglxb;
    }

    public void setPglxb(int pglxb) {
        this.pglxb = pglxb;
    }
}