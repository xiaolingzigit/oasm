package com.hd.jy.oasm.domain;

import java.math.BigDecimal;
import java.util.Date;
//访谈调查答案
public class Daftdc {
    private BigDecimal ftdcId;  //由时间、等级警号、囚号组成的事件编号主键

    private Date tbdate;  //时间

    private Long booker;  //等级人

    private String zsxm;  //真实姓名

    private Long qh;  //囚号

    private String b1;

    private String b2;

    private String b3;

    private String b4;

    private String b5;

    private String b6;

    private String b7;

    private String b8;

    private String b9;

    private String b10;

    private String b11;

    private String b12;

    private String b13;

    private String b14;

    private String b15;
    
    private int status; //状态，为了saveOrupdate方法

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigDecimal getFtdcId() {
        return ftdcId;
    }

    public void setFtdcId(BigDecimal ftdcId) {
        this.ftdcId = ftdcId;
    }

    public Date getTbdate() {
        return tbdate;
    }

    public void setTbdate(Date tbdate) {
        this.tbdate = tbdate;
    }

    public Long getBooker() {
        return booker;
    }

    public void setBooker(Long booker) {
        this.booker = booker;
    }

    public String getZsxm() {
        return zsxm;
    }

    public void setZsxm(String zsxm) {
        this.zsxm = zsxm == null ? null : zsxm.trim();
    }

    public Long getQh() {
        return qh;
    }

    public void setQh(Long qh) {
        this.qh = qh;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1 == null ? null : b1.trim();
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2 == null ? null : b2.trim();
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3 == null ? null : b3.trim();
    }

    public String getB4() {
        return b4;
    }

    public void setB4(String b4) {
        this.b4 = b4 == null ? null : b4.trim();
    }

    public String getB5() {
        return b5;
    }

    public void setB5(String b5) {
        this.b5 = b5 == null ? null : b5.trim();
    }

    public String getB6() {
        return b6;
    }

    public void setB6(String b6) {
        this.b6 = b6 == null ? null : b6.trim();
    }

    public String getB7() {
        return b7;
    }

    public void setB7(String b7) {
        this.b7 = b7 == null ? null : b7.trim();
    }

    public String getB8() {
        return b8;
    }

    public void setB8(String b8) {
        this.b8 = b8 == null ? null : b8.trim();
    }

    public String getB9() {
        return b9;
    }

    public void setB9(String b9) {
        this.b9 = b9 == null ? null : b9.trim();
    }

    public String getB10() {
        return b10;
    }

    public void setB10(String b10) {
        this.b10 = b10 == null ? null : b10.trim();
    }

    public String getB11() {
        return b11;
    }

    public void setB11(String b11) {
        this.b11 = b11 == null ? null : b11.trim();
    }

    public String getB12() {
        return b12;
    }

    public void setB12(String b12) {
        this.b12 = b12 == null ? null : b12.trim();
    }

    public String getB13() {
        return b13;
    }

    public void setB13(String b13) {
        this.b13 = b13 == null ? null : b13.trim();
    }

    public String getB14() {
        return b14;
    }

    public void setB14(String b14) {
        this.b14 = b14 == null ? null : b14.trim();
    }

    public String getB15() {
        return b15;
    }

    public void setB15(String b15) {
        this.b15 = b15 == null ? null : b15.trim();
    }
}