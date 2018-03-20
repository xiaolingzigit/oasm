package com.hd.jy.oasm.domain;
import java.util.Date;
/***
 * 
 * @author quite
 *入监结构访谈，入监行为观察，日常行为观察，中期结构访谈，中期行为观察，出监结构访谈，出监行为观察整合
 *
 *所有阶段的结构访谈整合到Sjjgft.xml中
 *所有阶段的行为观察整合到Sjxwgc.xml中
 *
 *业务层
 *所有阶段的Dao整合到SjjgftAndxwgcDao中
 */

//入监结构访谈答题记录表
public class Sjrjjgft {
    private String rjftid;  //入监访谈事件编号--囚号+时间组成

    private Long qh;   //囚号

    private int booker; //记录人

    private Date sj;  //时间

    private String yz; //因子

    private int fs; //总分

    private String lbbh; //量表编号

    public String getRjftid() {
        return rjftid;
    }

    public void setRjftid(String rjftid) {
        this.rjftid = rjftid;
    }

    public Long getQh() {
        return qh;
    }

    public void setQh(Long qh) {
        this.qh = qh;
    }

    public int getBooker() {
        return booker;
    }

    public void setBooker(int booker) {
        this.booker = booker;
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getYz() {
        return yz;
    }

    public void setYz(String yz) {
        this.yz = yz == null ? null : yz.trim();
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }

    public String getLbbh() {
        return lbbh;
    }

    public void setLbbh(String lbbh) {
        this.lbbh = lbbh == null ? null : lbbh.trim();
    }
}