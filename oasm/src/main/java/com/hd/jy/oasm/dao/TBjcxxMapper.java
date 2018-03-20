package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBjcxx;

public interface TBjcxxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBjcxx record);

    int insertSelective(TBjcxx record);

    TBjcxx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBjcxx record);

    int updateByPrimaryKey(TBjcxx record);
}