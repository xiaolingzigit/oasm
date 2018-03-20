package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TCzsh;

public interface TCzshMapper {
    int deleteByPrimaryKey(String rwid);

    int insert(TCzsh record);

    int insertSelective(TCzsh record);

    TCzsh selectByPrimaryKey(String rwid);

    int updateByPrimaryKeySelective(TCzsh record);

    int updateByPrimaryKey(TCzsh record);
}