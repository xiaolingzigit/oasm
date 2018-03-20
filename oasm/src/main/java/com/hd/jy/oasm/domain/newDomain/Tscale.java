package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/***
 * 量表管理表
 * @author quite
 *映射文件：tdminAndtyz.xml
 *业务接口文件：TdminAndtyzDao.java
 */
public class Tscale {
    private int scaleId;//量表编号

    private String name;//量表名称

    private String type;//量表种型  如A 访谈量表  B行为观察量表 

    private String remark;//量表说明

    private String researher;//研制者

    private String creator;//创建人

    private Date crTime;//创建时间

    private Date lastModif;//最后修改时间

    private String modifier;//最后修改人

    private int status;//状态 启用状态，-1未发布，1未启用，2已启用，10已弃用	

    private String scale;//量表json字符串	

    public int getScaleId() {
        return scaleId;
    }

    public void setScaleId(int scaleId) {
        this.scaleId = scaleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getResearher() {
        return researher;
    }

    public void setResearher(String researher) {
        this.researher = researher == null ? null : researher.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCrTime() {
        return crTime;
    }

    public void setCrTime(Date crTime) {
        this.crTime = crTime;
    }

    public Date getLastModif() {
        return lastModif;
    }

    public void setLastModif(Date lastModif) {
        this.lastModif = lastModif;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }
}