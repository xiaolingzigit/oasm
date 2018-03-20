package com.hd.jy.oasm.domain;

/**
 * @ClassName: Twxlxbh 
 * @Description: 危险类型变化表，保存危险类型统计数据
 * @author liangjiaying
 * @date 2018年1月12日 下午6:40:12
 */
public class Twxlxbh {
    private Integer wxlxbh;//危险类型编号

    private String jq;// 监区

    private String sj;//时间

	private Integer zsjg;// 自杀极高数量

	private Integer zsgd;// 自杀高数量

	private Integer zszd;// 自杀中数量

	private Integer zsdd;// 自杀低数量

	private Integer xxjg;// 行凶极高数量

	private Integer xxgd;// 行凶高数量

	private Integer xxzd;// 行凶中数量

	private Integer xxdd;// 行凶低数量

	private Integer ttjg;// 脱逃极高数量

	private Integer ttgd;// 脱逃高数量

	private Integer ttzd;// 脱逃中数量

	private Integer ttdd;// 脱逃低数量

    public Integer getWxlxbh() {
        return wxlxbh;
    }

    public void setWxlxbh(Integer wxlxbh) {
        this.wxlxbh = wxlxbh;
    }

    public String getJq() {
        return jq;
    }

    public void setJq(String jq) {
        this.jq = jq == null ? null : jq.trim();
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj == null ? null : sj.trim();
    }

    public Integer getZsjg() {
        return zsjg;
    }

    public void setZsjg(Integer zsjg) {
        this.zsjg = zsjg;
    }

    public Integer getZsgd() {
        return zsgd;
    }

    public void setZsgd(Integer zsgd) {
        this.zsgd = zsgd;
    }

    public Integer getZszd() {
        return zszd;
    }

    public void setZszd(Integer zszd) {
        this.zszd = zszd;
    }

    public Integer getZsdd() {
        return zsdd;
    }

    public void setZsdd(Integer zsdd) {
        this.zsdd = zsdd;
    }

    public Integer getXxjg() {
        return xxjg;
    }

    public void setXxjg(Integer xxjg) {
        this.xxjg = xxjg;
    }

    public Integer getXxgd() {
        return xxgd;
    }

    public void setXxgd(Integer xxgd) {
        this.xxgd = xxgd;
    }

    public Integer getXxzd() {
        return xxzd;
    }

    public void setXxzd(Integer xxzd) {
        this.xxzd = xxzd;
    }

    public Integer getXxdd() {
        return xxdd;
    }

    public void setXxdd(Integer xxdd) {
        this.xxdd = xxdd;
    }

    public Integer getTtjg() {
        return ttjg;
    }

    public void setTtjg(Integer ttjg) {
        this.ttjg = ttjg;
    }

    public Integer getTtgd() {
        return ttgd;
    }

    public void setTtgd(Integer ttgd) {
        this.ttgd = ttgd;
    }

    public Integer getTtzd() {
        return ttzd;
    }

    public void setTtzd(Integer ttzd) {
        this.ttzd = ttzd;
    }

    public Integer getTtdd() {
        return ttdd;
    }

    public void setTtdd(Integer ttdd) {
        this.ttdd = ttdd;
    }
}