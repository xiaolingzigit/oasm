package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/***
 * 评估管理所用的视图-----最新
 * @author quite
 *映射文件:Viewpggl.xml
 *业务接口ViewpgglMapper.java
 */
public class Viewpggl {
    private String taskId; //任务编号

    private String crimNo; //任务里面的囚号

    private String type; //任务里面的类型

    private Date lastModif; //任务里面的最后修改时间

    private int status; //任务里面的状态

    private String name; //任务里面的类型的名称

    private String xm; //罪犯姓名

    private String gyjq; //关押监区

    private String jh; //警号

    private String jhxm; //警察姓名

    private String xjbh; //协教警号

    private String xjxm; //协教姓名

    private Double score; //做题完的成绩

    private String levl; //做题完评估危险

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getCrimNo() {
        return crimNo;
    }

    public void setCrimNo(String crimNo) {
        this.crimNo = crimNo == null ? null : crimNo.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getLastModif() {
        return lastModif;
    }

    public void setLastModif(Date lastModif) {
        this.lastModif = lastModif;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getGyjq() {
        return gyjq;
    }

    public void setGyjq(String gyjq) {
        this.gyjq = gyjq == null ? null : gyjq.trim();
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh == null ? null : jh.trim();
    }

    public String getJhxm() {
        return jhxm;
    }

    public void setJhxm(String jhxm) {
        this.jhxm = jhxm == null ? null : jhxm.trim();
    }

    public String getXjbh() {
        return xjbh;
    }

    public void setXjbh(String xjbh) {
        this.xjbh = xjbh == null ? null : xjbh.trim();
    }

    public String getXjxm() {
        return xjxm;
    }

    public void setXjxm(String xjxm) {
        this.xjxm = xjxm == null ? null : xjxm.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getLevl() {
        return levl;
    }

    public void setLevl(String levl) {
        this.levl = levl == null ? null : levl.trim();
    }
}