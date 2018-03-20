package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBtmb;

public interface TBtmbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBtmb record);

    int insertSelective(TBtmb record);

    TBtmb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBtmb record);

    int updateByPrimaryKey(TBtmb record);
}