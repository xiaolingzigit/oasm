package com.hd.jy.oasm.model.pad.padmodel;

import java.util.List;

/**
 * Created by Marks on 2017/11/30.
 * 接收警员数据：
 */

public class Pols {

    private List<PoliceInfo> pols;

    public List<PoliceInfo> getPols() {
        return pols;
    }

    public void setPols(List<PoliceInfo> pols) {
        this.pols = pols;
    }

	
	public Pols(List<PoliceInfo> pols) {
		this.pols = pols;
	}
    
	public Pols() {
	}
    
}
