package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.VPgbgWxlx;
import com.hd.jy.oasm.domain.VTjwxcd;
import com.hd.jy.oasm.domain.VTjwxlx;
import com.hd.jy.oasm.domain.Vtjzfz;
import com.hd.jy.oasm.domain.Vwxlx;

public interface VTjwxcdMapper {
	
	/**
	 * <p>Title: listVTjwxcd</p>   
	 * <p>Description: Σ�ճ̶�ͳ��</p>   
	 */
	List<VTjwxcd> listVTjwxcd();
	
	/**
	 * <p>Title: getVjy</p>   
	 * <p>Description: ������Σ�ճ̶�ͳ������</p>   
	 */
	List<VTjwxcd> getVjy();
	
	/**
	 * <p>Title: getVPgbgWxlx</p>   
	 * <p>Description: ���߶�Σ�������б�</p>   
	 */
	List<VPgbgWxlx> getVPgbgWxlx();
	
	/**
	 * <p>Title: getVTjwxlx</p>   
	 * <p>Description: ͳ�Ƹ���������Σ����������</p>   
	 */
	List<VTjwxlx> getVTjwxlx();
	
	/**
	 * <p>Title: listTjWxlx</p>   
	 * <p>Description: ͳ�Ƹ�������Σ���������</p>   
	 */
	List<Vwxlx> listTjWxlx();

	/**
	 * <p>Title: listTjZfz</p>   
	 * <p>Description: 	ͳ���ٷ�������</p>   
	 */
	List<Vtjzfz> listTjZfz();
}

