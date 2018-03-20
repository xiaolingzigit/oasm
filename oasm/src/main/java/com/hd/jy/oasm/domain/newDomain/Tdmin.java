package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/**
 * 维度表，使用于维度添加和启用禁用
 * @author quite
 *
 */
public class Tdmin {
    private int dimId; //维度id

    private String dimName; //维度名称

    private String creator; //创建者

    private Date crTime; //创建时间
    
    private String remark;//描述

    private Date lastModif; //最后修改时间

    private String modifier; //最后修改人

    private int status; //状态（1未启用 ，2启用）

    public int getDimId() {
        return dimId;
    }

    public void setDimId(int dimId) {
        this.dimId = dimId;
    }

    public String getDimName() {
        return dimName;
    }

    public void setDimName(String dimName) {
        this.dimName = dimName == null ? null : dimName.trim();
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}