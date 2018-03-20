package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBwxdj;

public interface TBwxdjMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBwxdj record);

    int insertSelective(TBwxdj record);

    TBwxdj selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBwxdj record);

    int updateByPrimaryKey(TBwxdj record);
}