package com.hd.jy.oasm.services;

import com.hd.jy.oasm.domain.Daftdc;


/**
 * �ƶ��˺ͷ���������ͬ������
 * @author admin
 *
 */
public interface DataSynchrService {
	
	public String send(Daftdc record);
	
	public String received(Daftdc record);

}
