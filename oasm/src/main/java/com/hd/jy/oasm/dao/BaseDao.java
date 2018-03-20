package com.hd.jy.oasm.dao;

import java.util.List;

public interface BaseDao<T> {
	
	/**
	 * 
	 * @Date: 2017年11月1日 
	 * @author quite
	 * @Title: selectAll   
	 * @Description: 查询所有
	 * @param: @return      
	 * @return: List<T>      
	 * @throws
	 */
	public List<T> selectAll();
}
