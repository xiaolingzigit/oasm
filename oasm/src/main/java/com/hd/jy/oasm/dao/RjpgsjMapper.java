package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.Rjpgsj;

public interface RjpgsjMapper {
	List<Rjpgsj> selectDistinct();  //«Ù∫≈»•÷ÿ
	
    int insert(Rjpgsj record);

    int insertSelective(Rjpgsj record);
    
    List<Rjpgsj> selectByRjpgsjQh(Long qh); //«Ù∫≈
}