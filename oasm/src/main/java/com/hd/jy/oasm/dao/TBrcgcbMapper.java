package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBrcgcb;

public interface TBrcgcbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBrcgcb record);

    int insertSelective(TBrcgcb record);

    TBrcgcb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBrcgcb record);

    int updateByPrimaryKey(TBrcgcb record);
}