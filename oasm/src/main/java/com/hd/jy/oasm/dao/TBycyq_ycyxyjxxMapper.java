package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBycyq_ycyxyjxx;

public interface TBycyq_ycyxyjxxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBycyq_ycyxyjxx record);

    int insertSelective(TBycyq_ycyxyjxx record);

    TBycyq_ycyxyjxx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBycyq_ycyxyjxx record);

    int updateByPrimaryKey(TBycyq_ycyxyjxx record);
}