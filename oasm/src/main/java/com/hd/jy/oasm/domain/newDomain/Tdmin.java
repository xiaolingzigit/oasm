package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/**
 * ά�ȱ�ʹ����ά����Ӻ����ý���
 * @author quite
 *
 */
public class Tdmin {
    private int dimId; //ά��id

    private String dimName; //ά������

    private String creator; //������

    private Date crTime; //����ʱ��
    
    private String remark;//����

    private Date lastModif; //����޸�ʱ��

    private String modifier; //����޸���

    private int status; //״̬��1δ���� ��2���ã�

    public int getDimId() {
        return dimId;
    }

    public void setDimId(int dimId) {
        this.dimId = dimId;
    }

    public String getDimName() {
        return dimName;
    }

    public void setDimName(String dimName) {
        this.dimName = dimName == null ? null : dimName.trim();
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}