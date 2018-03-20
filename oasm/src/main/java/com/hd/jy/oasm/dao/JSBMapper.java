package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.JSB;

public interface JSBMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JSB record);

    int insertSelective(JSB record);

    JSB selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JSB record);

    int updateByPrimaryKey(JSB record);
}