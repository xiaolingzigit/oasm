package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.Yzk;

public interface YzkMapper {
    int insert(Yzk record);

    int insertSelective(Yzk record);
    
    List<Yzk> getAllYzk();
}