package com.hd.jy.oasm.domain;

import java.util.Date;
/**
 * �����滻ԭ����sj_dafx,��ʾ�������������б�
 * TODO
 * @author quite
 * @data 2017��12��23��
 * @see  ӳ���ļ�Sjjgft.xml
 *
 */
public class ViewDafxjg {
    private String qh;  //����

    private String xm; //����

    private Date sj; //���ʱ��

    private String jq; //����

    private String fjq; //�ּ���

    private String jy; //����

    private String taskId; //������

    private Date deadline; //�����ֹʱ��

    private Date crTime; //����ʱ��

    private Date lastModif; //����޸�ʱ��

    private int status; //״̬
    
    private String answer; //�ش����

    private String result; //���棬����ר��

    private Double score; //���������ܷ���

    private String levl; //����������Σ�ճ̶�

    public String getQh() {
        return qh;
    }

    public void setQh(String qh) {
        this.qh = qh == null ? null : qh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getJq() {
        return jq;
    }

    public void setJq(String jq) {
        this.jq = jq == null ? null : jq.trim();
    }

    public String getFjq() {
        return fjq;
    }

    public void setFjq(String fjq) {
        this.fjq = fjq == null ? null : fjq.trim();
    }

    public String getJy() {
        return jy;
    }

    public void setJy(String jy) {
        this.jy = jy == null ? null : jy.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getLevl() {
        return levl;
    }

    public void setLevl(String levl) {
        this.levl = levl == null ? null : levl.trim();
    }

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
    
}