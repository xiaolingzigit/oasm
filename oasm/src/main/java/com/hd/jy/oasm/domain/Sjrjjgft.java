package com.hd.jy.oasm.domain;
import java.util.Date;
/***
 * 
 * @author quite
 *���ṹ��̸�������Ϊ�۲죬�ճ���Ϊ�۲죬���ڽṹ��̸��������Ϊ�۲죬����ṹ��̸��������Ϊ�۲�����
 *
 *���н׶εĽṹ��̸���ϵ�Sjjgft.xml��
 *���н׶ε���Ϊ�۲����ϵ�Sjxwgc.xml��
 *
 *ҵ���
 *���н׶ε�Dao���ϵ�SjjgftAndxwgcDao��
 */

//���ṹ��̸�����¼��
public class Sjrjjgft {
    private String rjftid;  //����̸�¼����--����+ʱ�����

    private Long qh;   //����

    private int booker; //��¼��

    private Date sj;  //ʱ��

    private String yz; //����

    private int fs; //�ܷ�

    private String lbbh; //������

    public String getRjftid() {
        return rjftid;
    }

    public void setRjftid(String rjftid) {
        this.rjftid = rjftid;
    }

    public Long getQh() {
        return qh;
    }

    public void setQh(Long qh) {
        this.qh = qh;
    }

    public int getBooker() {
        return booker;
    }

    public void setBooker(int booker) {
        this.booker = booker;
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getYz() {
        return yz;
    }

    public void setYz(String yz) {
        this.yz = yz == null ? null : yz.trim();
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }

    public String getLbbh() {
        return lbbh;
    }

    public void setLbbh(String lbbh) {
        this.lbbh = lbbh == null ? null : lbbh.trim();
    }
}