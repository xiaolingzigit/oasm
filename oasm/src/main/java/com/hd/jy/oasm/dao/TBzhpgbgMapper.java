package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBzhpgbg;

public interface TBzhpgbgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBzhpgbg record);

    int insertSelective(TBzhpgbg record);

    TBzhpgbg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBzhpgbg record);

    int updateByPrimaryKey(TBzhpgbg record);
}