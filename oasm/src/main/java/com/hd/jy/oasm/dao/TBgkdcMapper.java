package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBgkdc;

public interface TBgkdcMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBgkdc record);

    int insertSelective(TBgkdc record);

    TBgkdc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBgkdc record);

    int updateByPrimaryKey(TBgkdc record);
}