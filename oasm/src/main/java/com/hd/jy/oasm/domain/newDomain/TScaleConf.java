package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/**
 * �������ñ�
 * @author quite
 * ӳ���ļ���tdminAndtyz.xml
 * ҵ���ļ���TdminAndtyzDao.java
 *
 */
public class TScaleConf extends TScaleConfKey {
    private String conf; //��������

    private String remark;//����

    private String creator;//������

    private Date crTime;//����ʱ��

    private Date lastModif;//����޸�ʱ��

    private String modifier;//����޸���

    private int status;//״̬  ����״̬��1δ���ã�2������,3������	

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