package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;

import com.hd.jy.oasm.domain.Task;
/**
 * ά�����ӹ�ϵ��ͬ���ֹ����̳���������
 * @author quite ӳ���ļ�tdminAndtyz.xml
 *
 */
public class TdminfactorRelat extends TdminfactorRelatKey {
    private String creator; //�������

    private Date crTime; //��������ʱ��

    private Date lastModif; //��������޸ĵ�ʱ��

    private String modifier; //��������޸ĵ���

    private int status; //״̬ 1��ʾδ����  2��ʾ����
    
    private Tdmin tdmin; //����ά��
    
    private Tfactor tfactor; //��������
    

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