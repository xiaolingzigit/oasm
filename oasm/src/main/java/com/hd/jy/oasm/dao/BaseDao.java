package com.hd.jy.oasm.dao;

import java.util.List;

public interface BaseDao<T> {
	
	/**
	 * 
	 * @Date: 2017��11��1�� 
	 * @author quite
	 * @Title: selectAll   
	 * @Description: ��ѯ����
	 * @param: @return      
	 * @return: List<T>      
	 * @throws
	 */
	public List<T> selectAll();
}
