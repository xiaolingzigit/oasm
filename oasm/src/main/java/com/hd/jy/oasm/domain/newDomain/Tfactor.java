package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/***
 * ���ӱ�����������ӣ��޸����Ӻͽ�������
 * @author quite
 * ����ӳ���ļ�Ϊ:tdminAndtyz.xml
 *
 */
public class Tfactor {
    private int fId; //����ID

    private String name; //��������

    private int fScore; //���ӷ���

    private Date crTime; //����ʱ��
    
    private String creator; //������
    
    private String remark;//����

    private Date lastModif; //����޸�ʱ��
    
    private String modifier; //����޸�ʱ��

    private int status; //״̬��1δ���ã�2���ã�

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