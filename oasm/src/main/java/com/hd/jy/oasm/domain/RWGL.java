package com.hd.jy.oasm.domain;

import java.util.Date;
/***
 * �������
 * @author quite
 *�����Զ��������񣬷�������׷������
 */

//*******************�Ȳ���������ţ��������ͣ����״̬<2�����ض�����ݴ浽map��*******************************

//****************ѭ�����е������������ݣ�ͨ��key-value����ʽ�ж���û����������*****************************************

//****************���ͨ��key�����ţ���ѯvalue����û��������************************************************************

/**�������---�������
 * 
 * 
 *
 */
public class RWGL {
    private String rewglbh; //�����ţ�����_��������_ʱ��

    private Long qh; //����

    private String fbr; //������

    private String rwlx; //��������

    private Date fbsj; //����ʱ��

    private Date wcqx; //�������

    private Date xgsj; //����޸�ʱ��

    private String rwyj; //��������

    private String rwms; //��������

    private int zjjh; //ר�̾���

    private String xjxm; //Э������

    private String wczt; //���״̬��1��δ��ʼ��2��δ���/�ݴ棬3:����� ��4:������ע����

    public String getRewglbh() {
        return rewglbh;
    }

    public void setRewglbh(String rewglbh) {
        this.rewglbh = rewglbh == null ? null : rewglbh.trim();
    }

    public Long getQh() {
        return qh;
    }

    public void setQh(Long qh) {
        this.qh = qh;
    }

    public String getFbr() {
        return fbr;
    }

    public void setFbr(String fbr) {
        this.fbr = fbr == null ? null : fbr.trim();
    }

    public String getRwlx() {
        return rwlx;
    }

    public void setRwlx(String rwlx) {
        this.rwlx = rwlx == null ? null : rwlx.trim();
    }

    public Date getFbsj() {
        return fbsj;
    }

    public void setFbsj(Date fbsj) {
        this.fbsj = fbsj;
    }

    public Date getWcqx() {
        return wcqx;
    }

    public void setWcqx(Date wcqx) {
        this.wcqx = wcqx;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public String getRwyj() {
        return rwyj;
    }

    public void setRwyj(String rwyj) {
        this.rwyj = rwyj == null ? null : rwyj.trim();
    }

    public String getRwms() {
        return rwms;
    }

    public void setRwms(String rwms) {
        this.rwms = rwms == null ? null : rwms.trim();
    }

    public int getZjjh() {
        return zjjh;
    }

    public void setZjjh(int zjjh) {
        this.zjjh = zjjh;
    }

    public String getXjxm() {
        return xjxm;
    }

    public void setXjxm(String xjxm) {
        this.xjxm = xjxm == null ? null : xjxm.trim();
    }

    public String getWczt() {
        return wczt;
    }

    public void setWczt(String wczt) {
        this.wczt = wczt == null ? null : wczt.trim();
    }
}