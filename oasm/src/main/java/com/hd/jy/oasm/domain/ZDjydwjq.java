package com.hd.jy.oasm.domain;
//监狱单位--监区
public class ZDjydwjq {
    private int jqbm; //监区编号

    private String jybm; //监狱编码

    private String jqmc; //监区名称

    private int jqzt; //监区状态 1.表示入监  2.表示出监 3.表示其他

    public int getJqbm() {
        return jqbm;
    }

    public void setJqbm(int jqbm) {
        this.jqbm = jqbm;
    }

    public String getJybm() {
        return jybm;
    }

    public void setJybm(String jybm) {
        this.jybm = jybm == null ? null : jybm.trim();
    }

    public String getJqmc() {
        return jqmc;
    }

    public void setJqmc(String jqmc) {
        this.jqmc = jqmc == null ? null : jqmc.trim();
    }

    public int getJqzt() {
        return jqzt;
    }

    public void setJqzt(int jqzt) {
        this.jqzt = jqzt;
    }
}