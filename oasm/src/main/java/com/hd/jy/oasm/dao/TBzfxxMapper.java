package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBzfxx;

public interface TBzfxxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBzfxx record);

    int insertSelective(TBzfxx record);

    TBzfxx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBzfxx record);

    int updateByPrimaryKey(TBzfxx record);
}