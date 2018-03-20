package com.hd.jy.oasm.domain;
//狱情记录表
import java.util.Date;

public class TByqjlb {
    private Integer id;

    private Date rq;	//日期

    private String sfyc;	//是否异常

    private String ycnr;	//异常内容

    private String zdxszctzxxlr;	//重大形势政策调整信息录入

    private String zdxszctzsfyc;	//重大形势政策调整是否异常

    private String zdxszctzbz;	//重大形势政策调整备注

    private String xqbdqkxxlr;	//刑期变动情况信息录入

    private String xqbdqksfyc;	//刑期变动情况是否异常

    private String xqbdqkbz;	//刑期变动情况备注

    private String gzbxxxlr;	//改造表现信息录入

    private String gzbxsfyc;	//改造表现是否异常

    private String gzbxbz;	//改造表现备注

    private String jcqkxxlr;	//奖惩情况信息录入
    
    private String jcqksfyc;	//奖惩情况是否异常

    private String jcqkbz;	//奖惩情况备注

    private String cydjxxlr; //处遇等级信息录入	

    private String cydjsfyx;	//处遇等级是否异常

    private String cydjbz;	//处遇等级备注

    private String zszcxxlr;	//自伤自残信息录入

    private String zszcsfyc;	//自伤自残是否异常

    private String zszcbz;	//自伤自残备注

    private String djxxlr;	//打架信息录入

    private String djsfyc;	//打架是否异常

    private String djbz;	//打架备注

    private String lhxxlr;	//离婚信息录入

    private String lhsfyx;	//离婚是否异常

    private String lhbz;	//离婚备注

    private String jrbzbwbgxxlr; 	//家人病重病危病故信息录入

    private String jrbzbwbgsfyc; //家人病重病危病故是否异常

    private String jrbzbwbgbz;	//家人病重病危病故备注

    private String zstfzzjbxxlr;	//自身突发重症疾病信息录入

    private String zstfzzjbsfyc;	//自身突发重症疾病是否异常

    private String zstfzzjbbz;	//自身突发重症疾病备注

    private String bcfcgytxxlr; 	//不吃饭超过一天信息录入

    private String bcfcgytsfyc;	//不吃饭超过一天是否异常

    private String bcfcgytbz;	//不吃饭超过一天备注

    private Integer qh;	//罪犯信息

    private Integer pglxb;	//评估类型表

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRq() {
        return rq;
    }

    public void setRq(Date rq) {
        this.rq = rq;
    }

    public String getSfyc() {
        return sfyc;
    }

    public void setSfyc(String sfyc) {
        this.sfyc = sfyc == null ? null : sfyc.trim();
    }

    public String getYcnr() {
        return ycnr;
    }

    public void setYcnr(String ycnr) {
        this.ycnr = ycnr == null ? null : ycnr.trim();
    }

    public String getZdxszctzxxlr() {
        return zdxszctzxxlr;
    }

    public void setZdxszctzxxlr(String zdxszctzxxlr) {
        this.zdxszctzxxlr = zdxszctzxxlr == null ? null : zdxszctzxxlr.trim();
    }

    public String getZdxszctzsfyc() {
        return zdxszctzsfyc;
    }

    public void setZdxszctzsfyc(String zdxszctzsfyc) {
        this.zdxszctzsfyc = zdxszctzsfyc == null ? null : zdxszctzsfyc.trim();
    }

    public String getZdxszctzbz() {
        return zdxszctzbz;
    }

    public void setZdxszctzbz(String zdxszctzbz) {
        this.zdxszctzbz = zdxszctzbz == null ? null : zdxszctzbz.trim();
    }

    public String getXqbdqkxxlr() {
        return xqbdqkxxlr;
    }

    public void setXqbdqkxxlr(String xqbdqkxxlr) {
        this.xqbdqkxxlr = xqbdqkxxlr == null ? null : xqbdqkxxlr.trim();
    }

    public String getXqbdqksfyc() {
        return xqbdqksfyc;
    }

    public void setXqbdqksfyc(String xqbdqksfyc) {
        this.xqbdqksfyc = xqbdqksfyc == null ? null : xqbdqksfyc.trim();
    }

    public String getXqbdqkbz() {
        return xqbdqkbz;
    }

    public void setXqbdqkbz(String xqbdqkbz) {
        this.xqbdqkbz = xqbdqkbz == null ? null : xqbdqkbz.trim();
    }

    public String getGzbxxxlr() {
        return gzbxxxlr;
    }

    public void setGzbxxxlr(String gzbxxxlr) {
        this.gzbxxxlr = gzbxxxlr == null ? null : gzbxxxlr.trim();
    }

    public String getGzbxsfyc() {
        return gzbxsfyc;
    }

    public void setGzbxsfyc(String gzbxsfyc) {
        this.gzbxsfyc = gzbxsfyc == null ? null : gzbxsfyc.trim();
    }

    public String getGzbxbz() {
        return gzbxbz;
    }

    public void setGzbxbz(String gzbxbz) {
        this.gzbxbz = gzbxbz == null ? null : gzbxbz.trim();
    }

    public String getJcqkxxlr() {
        return jcqkxxlr;
    }

    public void setJcqkxxlr(String jcqkxxlr) {
        this.jcqkxxlr = jcqkxxlr == null ? null : jcqkxxlr.trim();
    }

    public String getJcqksfyc() {
        return jcqksfyc;
    }

    public void setJcqksfyc(String jcqksfyc) {
        this.jcqksfyc = jcqksfyc == null ? null : jcqksfyc.trim();
    }

    public String getJcqkbz() {
        return jcqkbz;
    }

    public void setJcqkbz(String jcqkbz) {
        this.jcqkbz = jcqkbz == null ? null : jcqkbz.trim();
    }

    public String getCydjxxlr() {
        return cydjxxlr;
    }

    public void setCydjxxlr(String cydjxxlr) {
        this.cydjxxlr = cydjxxlr == null ? null : cydjxxlr.trim();
    }

    public String getCydjsfyx() {
        return cydjsfyx;
    }

    public void setCydjsfyx(String cydjsfyx) {
        this.cydjsfyx = cydjsfyx == null ? null : cydjsfyx.trim();
    }

    public String getCydjbz() {
        return cydjbz;
    }

    public void setCydjbz(String cydjbz) {
        this.cydjbz = cydjbz == null ? null : cydjbz.trim();
    }

    public String getZszcxxlr() {
        return zszcxxlr;
    }

    public void setZszcxxlr(String zszcxxlr) {
        this.zszcxxlr = zszcxxlr == null ? null : zszcxxlr.trim();
    }

    public String getZszcsfyc() {
        return zszcsfyc;
    }

    public void setZszcsfyc(String zszcsfyc) {
        this.zszcsfyc = zszcsfyc == null ? null : zszcsfyc.trim();
    }

    public String getZszcbz() {
        return zszcbz;
    }

    public void setZszcbz(String zszcbz) {
        this.zszcbz = zszcbz == null ? null : zszcbz.trim();
    }

    public String getDjxxlr() {
        return djxxlr;
    }

    public void setDjxxlr(String djxxlr) {
        this.djxxlr = djxxlr == null ? null : djxxlr.trim();
    }

    public String getDjsfyc() {
        return djsfyc;
    }

    public void setDjsfyc(String djsfyc) {
        this.djsfyc = djsfyc == null ? null : djsfyc.trim();
    }

    public String getDjbz() {
        return djbz;
    }

    public void setDjbz(String djbz) {
        this.djbz = djbz == null ? null : djbz.trim();
    }

    public String getLhxxlr() {
        return lhxxlr;
    }

    public void setLhxxlr(String lhxxlr) {
        this.lhxxlr = lhxxlr == null ? null : lhxxlr.trim();
    }

    public String getLhsfyx() {
        return lhsfyx;
    }

    public void setLhsfyx(String lhsfyx) {
        this.lhsfyx = lhsfyx == null ? null : lhsfyx.trim();
    }

    public String getLhbz() {
        return lhbz;
    }

    public void setLhbz(String lhbz) {
        this.lhbz = lhbz == null ? null : lhbz.trim();
    }

    public String getJrbzbwbgxxlr() {
        return jrbzbwbgxxlr;
    }

    public void setJrbzbwbgxxlr(String jrbzbwbgxxlr) {
        this.jrbzbwbgxxlr = jrbzbwbgxxlr == null ? null : jrbzbwbgxxlr.trim();
    }

    public String getJrbzbwbgsfyc() {
        return jrbzbwbgsfyc;
    }

    public void setJrbzbwbgsfyc(String jrbzbwbgsfyc) {
        this.jrbzbwbgsfyc = jrbzbwbgsfyc == null ? null : jrbzbwbgsfyc.trim();
    }

    public String getJrbzbwbgbz() {
        return jrbzbwbgbz;
    }

    public void setJrbzbwbgbz(String jrbzbwbgbz) {
        this.jrbzbwbgbz = jrbzbwbgbz == null ? null : jrbzbwbgbz.trim();
    }

    public String getZstfzzjbxxlr() {
        return zstfzzjbxxlr;
    }

    public void setZstfzzjbxxlr(String zstfzzjbxxlr) {
        this.zstfzzjbxxlr = zstfzzjbxxlr == null ? null : zstfzzjbxxlr.trim();
    }

    public String getZstfzzjbsfyc() {
        return zstfzzjbsfyc;
    }

    public void setZstfzzjbsfyc(String zstfzzjbsfyc) {
        this.zstfzzjbsfyc = zstfzzjbsfyc == null ? null : zstfzzjbsfyc.trim();
    }

    public String getZstfzzjbbz() {
        return zstfzzjbbz;
    }

    public void setZstfzzjbbz(String zstfzzjbbz) {
        this.zstfzzjbbz = zstfzzjbbz == null ? null : zstfzzjbbz.trim();
    }

    public String getBcfcgytxxlr() {
        return bcfcgytxxlr;
    }

    public void setBcfcgytxxlr(String bcfcgytxxlr) {
        this.bcfcgytxxlr = bcfcgytxxlr == null ? null : bcfcgytxxlr.trim();
    }

    public String getBcfcgytsfyc() {
        return bcfcgytsfyc;
    }

    public void setBcfcgytsfyc(String bcfcgytsfyc) {
        this.bcfcgytsfyc = bcfcgytsfyc == null ? null : bcfcgytsfyc.trim();
    }

    public String getBcfcgytbz() {
        return bcfcgytbz;
    }

    public void setBcfcgytbz(String bcfcgytbz) {
        this.bcfcgytbz = bcfcgytbz == null ? null : bcfcgytbz.trim();
    }

    public Integer getQh() {
        return qh;
    }

    public void setQh(Integer qh) {
        this.qh = qh;
    }

    public Integer getPglxb() {
        return pglxb;
    }

    public void setPglxb(Integer pglxb) {
        this.pglxb = pglxb;
    }
}