package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/***
 * 因子表，用于添加因子，修改因子和禁用因子
 * @author quite
 * 所有映射文件为:tdminAndtyz.xml
 *
 */
public class Tfactor {
    private int fId; //因子ID

    private String name; //因子名称

    private int fScore; //因子分数

    private Date crTime; //创建时间
    
    private String creator; //创建者
    
    private String remark;//描述

    private Date lastModif; //最后修改时间
    
    private String modifier; //最后修改时间

    private int status; //状态（1未启用，2启用）

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public int getfScore() {
        return fScore;
    }

    public void setfScore(int fScore) {
        this.fScore = fScore;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}