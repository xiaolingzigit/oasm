package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;

import com.hd.jy.oasm.domain.Task;
/**
 * ���������ϵ��
 * @author quite
 *
 */
public class TCrimScaleRelat{
	private String crimNo; //����

	private int sconfId; //���ñ��
	
    private String creator; //������

    private Date crTime;//����ʱ��

    private Date lastModif;//����޸�ʱ��

    private String modifier;//����޸���

    private int status;//״̬
    
    private TScaleConf scaleConf; //���������ù�����������������
    
    private Task task;  //���������
    
    private int conStat; //����״̬
    
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