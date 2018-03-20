package com.hd.jy.oasm.domain;

import java.util.Date;

public class TCzsh {
	//编号 (囚号_任务类型 _发布时间yyyyMMddHHmm)
	//处置情况
	//处置效果
	//处置情况录入
	//处置录入时间
    private String rwid;

    private String czqk;

    private String czxg;

    private String czlrr;

    private Date czlrsj;
    //监区具体意见
  	//监区审核结论,同意/不同意
  	//监区审核签章,名字
  	//监区审核时间

    private String jqyj;

    private String jqjl;

    private String jqqz;

    private Date jqshsj;

	//危评中心具体意见
	//危评中心结论,同意/不同意
	//危评中心签章,名字
	//危评中心处理时间
    private String wpyj;

    private String wpjl;

    private String wpqz;

    private Date wpclsj;

    public String getRwid() {
        return rwid;
    }

    public void setRwid(String rwid) {
        this.rwid = rwid == null ? null : rwid.trim();
    }

    public String getCzqk() {
        return czqk;
    }

    public void setCzqk(String czqk) {
        this.czqk = czqk == null ? null : czqk.trim();
    }

    public String getCzxg() {
        return czxg;
    }

    public void setCzxg(String czxg) {
        this.czxg = czxg == null ? null : czxg.trim();
    }

    public String getCzlrr() {
        return czlrr;
    }

    public void setCzlrr(String czlrr) {
        this.czlrr = czlrr == null ? null : czlrr.trim();
    }

    public Date getCzlrsj() {
        return czlrsj;
    }

    public void setCzlrsj(Date czlrsj) {
        this.czlrsj = czlrsj;
    }

    public String getJqyj() {
        return jqyj;
    }

    public void setJqyj(String jqyj) {
        this.jqyj = jqyj == null ? null : jqyj.trim();
    }

    public String getJqjl() {
        return jqjl;
    }

    public void setJqjl(String jqjl) {
        this.jqjl = jqjl == null ? null : jqjl.trim();
    }

    public String getJqqz() {
        return jqqz;
    }

    public void setJqqz(String jqqz) {
        this.jqqz = jqqz == null ? null : jqqz.trim();
    }

    public Date getJqshsj() {
        return jqshsj;
    }

    public void setJqshsj(Date jqshsj) {
        this.jqshsj = jqshsj;
    }

    public String getWpyj() {
        return wpyj;
    }

    public void setWpyj(String wpyj) {
        this.wpyj = wpyj == null ? null : wpyj.trim();
    }

    public String getWpjl() {
        return wpjl;
    }

    public void setWpjl(String wpjl) {
        this.wpjl = wpjl == null ? null : wpjl.trim();
    }

    public String getWpqz() {
        return wpqz;
    }

    public void setWpqz(String wpqz) {
        this.wpqz = wpqz == null ? null : wpqz.trim();
    }

    public Date getWpclsj() {
        return wpclsj;
    }

    public void setWpclsj(Date wpclsj) {
        this.wpclsj = wpclsj;
    }
}