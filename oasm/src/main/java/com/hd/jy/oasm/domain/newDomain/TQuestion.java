package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/***
 * �����
 * @author quite
 * 
 * ���ɵ�newMapp tdminAndtyz.xml
 * ҵ��ӿ�TdminAndtyzDao
 *
 */
public class TQuestion {
    private int qstId; //�����ţ�����������

    private int dimId; //ά�ȱ�  �������

    private String orgId; //��֯���  ��ʶ����

    private String question; //����

    private int type; //��������  1����ѡ��2����ѡ

    private String remark; //�������ж�����

    private String options; //ѡ��   �и�ʽ�ַ������磺ѡ���,ѡ������,��������ID,������������;...

    private String answer; //�� �ɿգ���ʽ��ѡ���,ѡ���,...

    private String creator;//������

    private Date crTime;//����ʱ��

    private Date lastModif;//����޸�ʱ��

    private String modifier;//����޸���

    private int status;//-1δ������1δ���ã�2�����ã�10������		
    
    private Tdmin tdmin; //��������ά�ȱ�
    
    public Tdmin getTdmin() {
		return tdmin;
	}

	public void setTdmin(Tdmin tdmin) {
		this.tdmin = tdmin;
	}

	public int getQstId() {
        return qstId;
    }

    public void setQstId(int qstId) {
        this.qstId = qstId;
    }

    public int getDimId() {
        return dimId;
    }

    public void setDimId(int dimId) {
        this.dimId = dimId;
    }
    
    public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options == null ? null : options.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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