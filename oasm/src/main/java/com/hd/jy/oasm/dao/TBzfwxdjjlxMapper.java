package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBzfwxdjjlx;

public interface TBzfwxdjjlxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBzfwxdjjlx record);

    int insertSelective(TBzfwxdjjlx record);

    TBzfwxdjjlx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBzfwxdjjlx record);

    int updateByPrimaryKey(TBzfwxdjjlx record);
}