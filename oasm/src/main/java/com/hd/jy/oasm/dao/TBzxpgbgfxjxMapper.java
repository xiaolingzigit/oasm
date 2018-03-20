package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBzxpgbgfxjx;

public interface TBzxpgbgfxjxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBzxpgbgfxjx record);

    int insertSelective(TBzxpgbgfxjx record);

    TBzxpgbgfxjx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBzxpgbgfxjx record);

    int updateByPrimaryKey(TBzxpgbgfxjx record);
}