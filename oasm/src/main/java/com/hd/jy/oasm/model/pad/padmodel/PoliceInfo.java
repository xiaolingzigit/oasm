package com.hd.jy.oasm.model.pad.padmodel;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;


/**
 * Created by lenovo on 2017/8/30.
 * 警察信息：
 */

public class PoliceInfo extends BasicModel  {
    private String pnumber;//人员编号
    private String pname;//名字
    private String sex;//性别
    private String age;//年龄

    private String jqu;//监区
    private String pswd;//密码:3-16位--必要
    private String department;//部门
    private String birthday;//生日
    private String telphone;//电话
    private String email;//邮箱
    private String address;//地址

    private String comment;//备注说明
    private boolean isOnline;


    public String getJqu() {
        return jqu;
    }

    public void setJqu(String jqu) {
        this.jqu = jqu;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
