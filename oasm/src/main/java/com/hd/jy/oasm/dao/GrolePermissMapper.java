package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.GrolePermiss;
/**
 * 
* @ClassName: GrolePermissMapper 
* @Description: Ȩ�޷���
* @author quite
* @date 2017��11��1�� 
*
 */
public interface GrolePermissMapper {
	
	/**
	 * 
	 * @Date: 2018��1��11�� ����10:25:54
	 * @author quite
	 * @Title: deleteByPrimaryKey   
	 * @Description: TODO   
	 * @param: @param id
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
    int deleteByPrimaryKey(Integer id);

    int insert(GrolePermiss record);

    int insertSelective(GrolePermiss record);

    GrolePermiss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GrolePermiss record);

    int updateByPrimaryKey(GrolePermiss record);
    
    GrolePermiss selectRole(String jh);
}