package com.hd.jy.oasm.model.pad.padmodel;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;


/**
 * Created by Marks on 2017/12/4.
 * �ṹ�Է�̸�Ĵ���
 */

public class TalkChoiceItem extends BasicModel{

    private String talk_date;   //������
    private String th;//���
    private String title;       //��Ŀ
    private String weidu;      //ά��
    private String xuanx;//ѡ��

    public String getTalk_date() {
        return talk_date;
    }

    public void setTalk_date(String talk_date) {
        this.talk_date = talk_date;
    }

    public String getTh() {
        return th;
    }

    public void setTh(String th) {
        this.th = th;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWeidu() {
        return weidu;
    }

    public void setWeidu(String weidu) {
        this.weidu = weidu;
    }

    public String getXuanx() {
        return xuanx;
    }

    public void setXuanx(String xuanx) {
        this.xuanx = xuanx;
    }
}
