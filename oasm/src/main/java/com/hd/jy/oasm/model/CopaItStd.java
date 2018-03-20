package com.hd.jy.oasm.model;

import java.util.Map;

import com.hd.jy.oasm.util.lsc.datahandle.ComparUtil;
import com.hd.jy.oasm.util.priv.C;

public class CopaItStd extends ItemStd {

	public CopaItStd(String id, String name) {
		super(id, name);
	}

	@Override
	public String getLevel(double val) {
		for (Map.Entry<String, String> s : getLevelMap().entrySet()) {
			if (ComparUtil.isFit(s.getKey(), val)) {
				return s.getValue();
			}
		}

		return C.UNKNOWN;
	}
	

	@Override
	public String getRange(double val) {
		for (Map.Entry<String, String> s : getLevelMap().entrySet()) {
			if (ComparUtil.isFit(s.getKey(), val)) {
				return s.getKey();
			}
		}
		
		return C.UNKNOWN;
	}


}
