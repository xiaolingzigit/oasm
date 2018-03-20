package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBgzfa;

public interface TBgzfaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBgzfa record);

    int insertSelective(TBgzfa record);

    TBgzfa selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBgzfa record);

    int updateByPrimaryKey(TBgzfa record);
}