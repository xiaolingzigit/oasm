package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBlrlxb;

public interface TBlrlxbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBlrlxb record);

    int insertSelective(TBlrlxb record);

    TBlrlxb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBlrlxb record);

    int updateByPrimaryKey(TBlrlxb record);
}