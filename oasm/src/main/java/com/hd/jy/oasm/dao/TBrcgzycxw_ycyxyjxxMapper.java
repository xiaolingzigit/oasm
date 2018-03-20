package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBrcgzycxw_ycyxyjxx;

public interface TBrcgzycxw_ycyxyjxxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBrcgzycxw_ycyxyjxx record);

    int insertSelective(TBrcgzycxw_ycyxyjxx record);

    TBrcgzycxw_ycyxyjxx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBrcgzycxw_ycyxyjxx record);

    int updateByPrimaryKey(TBrcgzycxw_ycyxyjxx record);
}