package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBwxlbb;

public interface TBwxlbbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBwxlbb record);

    int insertSelective(TBwxlbb record);

    TBwxlbb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBwxlbb record);

    int updateByPrimaryKey(TBwxlbb record);
}