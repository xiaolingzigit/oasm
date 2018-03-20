package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;

import com.hd.jy.oasm.domain.Task;
/**
 * 维度因子关系共同部分管理，继承两个主键
 * @author quite 映射文件tdminAndtyz.xml
 *
 */
public class TdminfactorRelat extends TdminfactorRelatKey {
    private String creator; //管理的人

    private Date crTime; //管理创建的时间

    private Date lastModif; //管理最后修改的时间

    private String modifier; //管理最后修改的人

    private int status; //状态 1表示未启用  2表示启用
    
    private Tdmin tdmin; //关联维度
    
    private Tfactor tfactor; //关联因子
    

	public Tdmin getTdmin() {
		return tdmin;
	}

	public void setTdmin(Tdmin tdmin) {
		this.tdmin = tdmin;
	}

	public Tfactor getTfactor() {
		return tfactor;
	}

	public void setTfactor(Tfactor tfactor) {
		this.tfactor = tfactor;
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