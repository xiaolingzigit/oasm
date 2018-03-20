package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBrcgzwxys;

public interface TBrcgzwxysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBrcgzwxys record);

    int insertSelective(TBrcgzwxys record);

    TBrcgzwxys selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBrcgzwxys record);

    int updateByPrimaryKey(TBrcgzwxys record);
}