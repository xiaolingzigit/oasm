package com.hd.jy.oasm.model.pad.padmodel;

import java.util.List;

/**
 * Created by Marks on 2017/11/30.
 * 接收囚犯数据：
 */

public class Cris{

    private List<CriminalInfo> cris;

    public List<CriminalInfo> getCris() {
        return cris;
    }

    public void setCris(List<CriminalInfo> cris) {
        this.cris = cris;
    }

	
	public Cris() {
	}
    
	public Cris(List<CriminalInfo> cris) {
		this.cris = cris;
	}
    
}
