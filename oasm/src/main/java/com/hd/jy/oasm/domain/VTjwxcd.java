package com.hd.jy.oasm.domain;

public class VTjwxcd {

    private String gyjqmc;//监区

    private Integer jgdwx;//极高度危险

    private Integer gdwx;//高度危险

    private Integer zdwx;//中度危险

    private Integer ddwx;//低度危险
    
    private Integer sl;//未测试人员
    
    public Integer getSl() {
		return sl;
	}
    
    public void setSl(Integer sl) {
		this.sl = sl;
	}

    public String getGyjqmc() {
        return gyjqmc;
    }

    public void setGyjqmc(String gyjqmc) {
        this.gyjqmc = gyjqmc == null ? null : gyjqmc.trim();
    }

    public Integer getJgdwx() {
        return jgdwx;
    }

    public void setJgdwx(Integer jgdwx) {
        this.jgdwx = jgdwx;
    }

    public Integer getGdwx() {
        return gdwx;
    }

    public void setGdwx(Integer gdwx) {
        this.gdwx = gdwx;
    }

    public Integer getZdwx() {
        return zdwx;
    }

    public void setZdwx(Integer zdwx) {
        this.zdwx = zdwx;
    }

    public Integer getDdwx() {
        return ddwx;
    }

    public void setDdwx(Integer ddwx) {
        this.ddwx = ddwx;
    }
}