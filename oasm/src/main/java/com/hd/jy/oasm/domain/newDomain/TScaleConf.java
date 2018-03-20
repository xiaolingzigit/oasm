package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/**
 * 量表配置表
 * @author quite
 * 映射文件：tdminAndtyz.xml
 * 业务文件：TdminAndtyzDao.java
 *
 */
public class TScaleConf extends TScaleConfKey {
    private String conf; //配置内容

    private String remark;//描述

    private String creator;//创建人

    private Date crTime;//创建时间

    private Date lastModif;//最后修改时间

    private String modifier;//最后修改人

    private int status;//状态  启用状态，1未启用，2已启用,3已弃用	

    public String getConf() {
        return conf;
    }

    public void setConf(String conf) {
        this.conf = conf == null ? null : conf.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}