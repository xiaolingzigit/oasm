package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBwdtzxxxx;

public interface TBwdtzxxxxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBwdtzxxxx record);

    int insertSelective(TBwdtzxxxx record);

    TBwdtzxxxx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBwdtzxxxx record);

    int updateByPrimaryKey(TBwdtzxxxx record);
}