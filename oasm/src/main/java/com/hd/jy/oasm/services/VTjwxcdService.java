package com.hd.jy.oasm.services;

import java.util.List;

import com.hd.jy.oasm.domain.VPgbgWxlx;
import com.hd.jy.oasm.domain.VTjwxcd;
import com.hd.jy.oasm.domain.VTjwxlx;
import com.hd.jy.oasm.domain.Vtjzfz;
import com.hd.jy.oasm.domain.Vwxlx;

/**
 * 
 * @ClassName: VTjwxcdService 
 * @Description: ͳ��Σ�յȼ�
 * @author liangjiaying
 * @date 2018��1��11�� ����10:29:18 
 *
 */
public interface VTjwxcdService {
	
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
