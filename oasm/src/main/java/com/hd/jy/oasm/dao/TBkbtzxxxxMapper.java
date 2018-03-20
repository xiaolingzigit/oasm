package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBkbtzxxxx;

public interface TBkbtzxxxxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBkbtzxxxx record);

    int insertSelective(TBkbtzxxxx record);

    TBkbtzxxxx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBkbtzxxxx record);

    int updateByPrimaryKey(TBkbtzxxxx record);
}