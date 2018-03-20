package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBlrbb;

public interface TBlrbbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBlrbb record);

    int insertSelective(TBlrbb record);

    TBlrbb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBlrbb record);

    int updateByPrimaryKey(TBlrbb record);
}