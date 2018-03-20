package com.hd.jy.oasm.model.pad.padmodel;

import java.util.List;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;

/**
 * Created by lenovo on 2017/8/29.
 * 出监--结构性访谈：
 * 同一个人的数据，就一个答案保存一条1
 */

public class TalkNCJ extends BasicModel {
	

    private String date;  //
    private String booker;
    private String cri_name;//名字
    private String cri_num;//人员编号

    private List<TalkChoiceItem> tcList;

    public List<TalkChoiceItem> getTcList() {
        return  tcList;
    }

    public void setTcList(List<TalkChoiceItem> tcList) {
        this.tcList = tcList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBooker() {
        return booker;
    }

    public void setBooker(String booker) {
        this.booker = booker;
    }

    public String getCri_name() {
        return cri_name;
    }

    public void setCri_name(String cri_name) {
        this.cri_name = cri_name;
    }

    public String getCri_num() {
        return cri_num;
    }

    public void setCri_num(String cri_num) {
        this.cri_num = cri_num;
    }


}
