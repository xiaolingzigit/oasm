package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBrcgzjlb;

public interface TBrcgzjlbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBrcgzjlb record);

    int insertSelective(TBrcgzjlb record);

    TBrcgzjlb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBrcgzjlb record);

    int updateByPrimaryKey(TBrcgzjlb record);
}