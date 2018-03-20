package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBrcgcyx_ycyxyjxx;

public interface TBrcgcyx_ycyxyjxxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBrcgcyx_ycyxyjxx record);

    int insertSelective(TBrcgcyx_ycyxyjxx record);

    TBrcgcyx_ycyxyjxx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBrcgcyx_ycyxyjxx record);

    int updateByPrimaryKey(TBrcgcyx_ycyxyjxx record);
}