package com.hd.jy.oasm.domain.newDomain;

import java.util.Date;
/**
 * �޸�������ӱ�
 * @author quite
 *ӳ���ļ�tyskAndwd.xml
 */
public class Tysk {
    private int ysid;  //Ԫ��ID

    private String ysbh;//Ԫ�ر��4.7.7.7

    private String ysmc;//Ԫ�����Ʋ�UNIQUE�����ظ�

    private String yssx;//Ԫ�����ʣ�ֵ���ޣ���������-�ȶ�����,��������-�ɱ�����,�����̼�-�ճ�������Ϊ

    private String sm;//˵��	

    private String ytxz;//��;����(���ڹ�����ʾʱ����)��0����Ϊά�Ȼ����ӣ�1ֻ��Ϊ���ӣ�2ֻ��Ϊά�ȣ�3��Ϊά�Ȼ�����

    private Double yzfz;//���ӷ�ֵ

    private int yzzpc;//������Ƶ��

    private int zsxgpc;//��ɱ���Ƶ��

    private int xxxgpc;//�������Ƶ��	

    private int ttxgpc;//�������Ƶ��	

    private int zfzxgpc;//�ٷ������Ƶ��

    private Byte qyzt;//����״̬��ֵ������״̬��	

    private Date cjsj;//����ʱ��

    private String cjrbh;//�����˱�ţ�����

    private Date xgsj;//�޸�ʱ��

    private String xgrbh;//�޸��˱��

    public int getYsid() {
        return ysid;
    }

    public void setYsid(int ysid) {
        this.ysid = ysid;
    }

    public String getYsbh() {
        return ysbh;
    }

    public void setYsbh(String ysbh) {
        this.ysbh = ysbh == null ? null : ysbh.trim();
    }

    public String getYsmc() {
        return ysmc;
    }

    public void setYsmc(String ysmc) {
        this.ysmc = ysmc == null ? null : ysmc.trim();
    }

    public String getYssx() {
        return yssx;
    }

    public void setYssx(String yssx) {
        this.yssx = yssx == null ? null : yssx.trim();
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm == null ? null : sm.trim();
    }

    public String getYtxz() {
        return ytxz;
    }

    public void setYtxz(String ytxz) {
        this.ytxz = ytxz == null ? null : ytxz.trim();
    }

    public Double getYzfz() {
        return yzfz;
    }

    public void setYzfz(Double yzfz) {
        this.yzfz = yzfz;
    }

    public int getYzzpc() {
        return yzzpc;
    }

    public void setYzzpc(int yzzpc) {
        this.yzzpc = yzzpc;
    }

    public int getZsxgpc() {
        return zsxgpc;
    }

    public void setZsxgpc(int zsxgpc) {
        this.zsxgpc = zsxgpc;
    }

    public int getXxxgpc() {
        return xxxgpc;
    }

    public void setXxxgpc(int xxxgpc) {
        this.xxxgpc = xxxgpc;
    }

    public int getTtxgpc() {
        return ttxgpc;
    }

    public void setTtxgpc(int ttxgpc) {
        this.ttxgpc = ttxgpc;
    }

    public int getZfzxgpc() {
        return zfzxgpc;
    }

    public void setZfzxgpc(int zfzxgpc) {
        this.zfzxgpc = zfzxgpc;
    }

    public Byte getQyzt() {
        return qyzt;
    }

    public void setQyzt(Byte qyzt) {
        this.qyzt = qyzt;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public String getCjrbh() {
        return cjrbh;
    }

    public void setCjrbh(String cjrbh) {
        this.cjrbh = cjrbh == null ? null : cjrbh.trim();
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public String getXgrbh() {
        return xgrbh;
    }

    public void setXgrbh(String xgrbh) {
        this.xgrbh = xgrbh == null ? null : xgrbh.trim();
    }
}