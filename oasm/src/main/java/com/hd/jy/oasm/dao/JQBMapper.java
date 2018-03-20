package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.JQB;

public interface JQBMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JQB record);

    int insertSelective(JQB record);

    JQB selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JQB record);

    int updateByPrimaryKey(JQB record);
}