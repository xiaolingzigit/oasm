package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBrgczjl;

public interface TBrgczjlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBrgczjl record);

    int insertSelective(TBrgczjl record);

    TBrgczjl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBrgczjl record);

    int updateByPrimaryKey(TBrgczjl record);
}