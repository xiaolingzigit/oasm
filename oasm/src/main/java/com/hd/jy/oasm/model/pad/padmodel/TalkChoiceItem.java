package com.hd.jy.oasm.model.pad.padmodel;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;


/**
 * Created by Marks on 2017/12/4.
 * 结构性访谈的答案项
 */

public class TalkChoiceItem extends BasicModel{

    private String talk_date;   //关联键
    private String th;//题号
    private String title;       //题目
    private String weidu;      //维度
    private String xuanx;//选择

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
