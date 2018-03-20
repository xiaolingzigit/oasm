package com.hd.jy.oasm.services;

import com.hd.jy.oasm.domain.Daftdc;


/**
 * 移动端和服务器数据同步服务
 * @author admin
 *
 */
public interface DataSynchrService {
	
	public String send(Daftdc record);
	
	public String received(Daftdc record);

}
