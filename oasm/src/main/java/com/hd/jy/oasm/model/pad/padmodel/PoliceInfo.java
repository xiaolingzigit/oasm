package com.hd.jy.oasm.model.pad.padmodel;

import com.hd.jy.oasm.util.lsc.basicmodel.BasicModel;


/**
 * Created by lenovo on 2017/8/30.
 * ������Ϣ��
 */

public class PoliceInfo extends BasicModel  {
    private String pnumber;//��Ա���
    private String pname;//����
    private String sex;//�Ա�
    private String age;//����

    private String jqu;//����
    private String pswd;//����:3-16λ--��Ҫ
    private String department;//����
    private String birthday;//����
    private String telphone;//�绰
    private String email;//����
    private String address;//��ַ

    private String comment;//��ע˵��
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
