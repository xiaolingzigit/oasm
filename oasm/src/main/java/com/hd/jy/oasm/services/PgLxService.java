package com.hd.jy.oasm.services;

import com.hd.jy.oasm.domain.LxCj;
import com.hd.jy.oasm.domain.LxRc;
import com.hd.jy.oasm.domain.LxRj;

public interface PgLxService {
	public LxRj selectLxByQh(long qh);  //�������
	
	public LxRc selectLxrc(long qh);  //�ճ�����
	
	public LxCj selectLxcj(long qh); //��������
}
