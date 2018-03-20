package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBpgbghzb;

public interface TBpgbghzbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBpgbghzb record);

    int insertSelective(TBpgbghzb record);

    TBpgbghzb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBpgbghzb record);

    int updateByPrimaryKey(TBpgbghzb record);
}