package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/***
 * ��������
 * @author quite
 *ӳ���ļ���tdminAndtyz.xml
 *ҵ��ӿ��ļ���TdminAndtyzDao.java
 */
public class Tscale {
    private int scaleId;//������

    private String name;//��������

    private String type;//��������  ��A ��̸����  B��Ϊ�۲����� 

    private String remark;//����˵��

    private String researher;//������

    private String creator;//������

    private Date crTime;//����ʱ��

    private Date lastModif;//����޸�ʱ��

    private String modifier;//����޸���

    private int status;//״̬ ����״̬��-1δ������1δ���ã�2�����ã�10������	

    private String scale;//����json�ַ���	

    public int getScaleId() {
        return scaleId;
    }

    public void setScaleId(int scaleId) {
        this.scaleId = scaleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getResearher() {
        return researher;
    }

    public void setResearher(String researher) {
        this.researher = researher == null ? null : researher.trim();
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

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }
}