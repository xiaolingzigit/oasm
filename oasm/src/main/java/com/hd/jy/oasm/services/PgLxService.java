package com.hd.jy.oasm.services;

import com.hd.jy.oasm.domain.LxCj;
import com.hd.jy.oasm.domain.LxRc;
import com.hd.jy.oasm.domain.LxRj;

public interface PgLxService {
	public LxRj selectLxByQh(long qh);  //入监类型
	
	public LxRc selectLxrc(long qh);  //日常类型
	
	public LxCj selectLxcj(long qh); //出监类型
}
