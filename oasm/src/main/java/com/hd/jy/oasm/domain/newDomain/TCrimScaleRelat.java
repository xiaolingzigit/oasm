package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;

import com.hd.jy.oasm.domain.Task;
/**
 * 囚犯量表关系表
 * @author quite
 *
 */
public class TCrimScaleRelat{
	private String crimNo; //囚号

	private int sconfId; //配置编号
	
    private String creator; //创建人

    private Date crTime;//创建时间

    private Date lastModif;//最后修改时间

    private String modifier;//最后修改人

    private int status;//状态
    
    private TScaleConf scaleConf; //把量表配置关联到囚犯配置这里
    
    private Task task;  //关联任务表
    
    private int conStat; //配置状态
    
    public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TScaleConf getScaleConf() {
		return scaleConf;
	}

	public void setScaleConf(TScaleConf scaleConf) {
		this.scaleConf = scaleConf;
	}

	public String getCrimNo() {
		return crimNo;
	}

	public void setCrimNo(String crimNo) {
		this.crimNo = crimNo;
	}

	public int getSconfId() {
		return sconfId;
	}

	public void setSconfId(int sconfId) {
		this.sconfId = sconfId;
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

	public int getConStat() {
		return conStat;
	}

	public void setConStat(int conStat) {
		this.conStat = conStat;
	}
}