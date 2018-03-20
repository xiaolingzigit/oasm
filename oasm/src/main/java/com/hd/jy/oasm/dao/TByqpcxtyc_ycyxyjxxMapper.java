package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TByqpcxtyc_ycyxyjxx;

public interface TByqpcxtyc_ycyxyjxxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TByqpcxtyc_ycyxyjxx record);

    int insertSelective(TByqpcxtyc_ycyxyjxx record);

    TByqpcxtyc_ycyxyjxx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TByqpcxtyc_ycyxyjxx record);

    int updateByPrimaryKey(TByqpcxtyc_ycyxyjxx record);
}