package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TByqjlb;

public interface TByqjlbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TByqjlb record);

    int insertSelective(TByqjlb record);

    TByqjlb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TByqjlb record);

    int updateByPrimaryKey(TByqjlb record);
}