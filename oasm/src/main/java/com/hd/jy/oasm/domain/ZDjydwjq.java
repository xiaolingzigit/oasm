package com.hd.jy.oasm.domain;
//������λ--����
public class ZDjydwjq {
    private int jqbm; //�������

    private String jybm; //��������

    private String jqmc; //��������

    private int jqzt; //����״̬ 1.��ʾ���  2.��ʾ���� 3.��ʾ����

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