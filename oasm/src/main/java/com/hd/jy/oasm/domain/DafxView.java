package com.hd.jy.oasm.domain;


public class DafxView{
	private String qh; //囚号

    private String zsxm; //姓名
    
    private String db; //队别

    private String hyzk; //婚姻状况

    private String lgf;  //累惯犯

    private String ssqk4; //四史情况

    private String qkqk1;//前科劣迹情况

    private String xq;//刑期

    private String syxq; //剩余刑期

    private String yfxq;//已服刑期

    private String yfxqbl;//已服刑期比例

    private String xaflb;//案犯类别

    private String ywss;//有无上诉

    private String zsqk;//终审情况

    private String fj;//罚金

    private String mscc;//没收财产

    private String fjjn;//罚金缴纳

    private String fylx;//分押类型

    private String jxcd;//减刑尺度

    private String lbc;//老病残

    private String rjnl;//入监年龄


	public String getQh() {
        return qh;
    }

    public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public void setQh(String qh) {
        this.qh = qh == null ? null : qh.trim();
    }

    public String getZsxm() {
        return zsxm;
    }

    public void setZsxm(String zsxm) {
        this.zsxm = zsxm == null ? null : zsxm.trim();
    }

    public String getHyzk() {
        return hyzk;
    }

    public void setHyzk(String hyzk) {
        this.hyzk = hyzk == null ? null : hyzk.trim();
    }

    public String getLgf() {
        return lgf;
    }

    public void setLgf(String lgf) {
        this.lgf = lgf == null ? null : lgf.trim();
    }

    public String getSsqk4() {
        return ssqk4;
    }

    public void setSsqk4(String ssqk4) {
        this.ssqk4 = ssqk4 == null ? null : ssqk4.trim();
    }

    public String getQkqk1() {
        return qkqk1;
    }

    public void setQkqk1(String qkqk1) {
        this.qkqk1 = qkqk1 == null ? null : qkqk1.trim();
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq == null ? null : xq.trim();
    }

    public String getSyxq() {
        return syxq;
    }

    public void setSyxq(String syxq) {
        this.syxq = syxq == null ? null : syxq.trim();
    }

    public String getYfxq() {
        return yfxq;
    }

    public void setYfxq(String yfxq) {
        this.yfxq = yfxq == null ? null : yfxq.trim();
    }

    public String getYfxqbl() {
        return yfxqbl;
    }

    public void setYfxqbl(String yfxqbl) {
        this.yfxqbl = yfxqbl == null ? null : yfxqbl.trim();
    }

    public String getXaflb() {
        return xaflb;
    }

    public void setXaflb(String xaflb) {
        this.xaflb = xaflb == null ? null : xaflb.trim();
    }

    public String getYwss() {
        return ywss;
    }

    public void setYwss(String ywss) {
        this.ywss = ywss == null ? null : ywss.trim();
    }

    public String getZsqk() {
        return zsqk;
    }

    public void setZsqk(String zsqk) {
        this.zsqk = zsqk == null ? null : zsqk.trim();
    }

    public String getFj() {
        return fj;
    }

    public void setFj(String fj) {
        this.fj = fj == null ? null : fj.trim();
    }

    public String getMscc() {
        return mscc;
    }

    public void setMscc(String mscc) {
        this.mscc = mscc == null ? null : mscc.trim();
    }

    public String getFjjn() {
        return fjjn;
    }

    public void setFjjn(String fjjn) {
        this.fjjn = fjjn == null ? null : fjjn.trim();
    }

    public String getFylx() {
        return fylx;
    }

    public void setFylx(String fylx) {
        this.fylx = fylx == null ? null : fylx.trim();
    }

    public String getJxcd() {
        return jxcd;
    }

    public void setJxcd(String jxcd) {
        this.jxcd = jxcd == null ? null : jxcd.trim();
    }

    public String getLbc() {
        return lbc;
    }

    public void setLbc(String lbc) {
        this.lbc = lbc == null ? null : lbc.trim();
    }

    public String getRjnl() {
        return rjnl;
    }

    public void setRjnl(String rjnl) {
        this.rjnl = rjnl == null ? null : rjnl.trim();
    }
}