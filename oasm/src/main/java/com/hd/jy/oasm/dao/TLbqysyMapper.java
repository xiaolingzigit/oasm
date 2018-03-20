package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TLbqysy;

public interface TLbqysyMapper {
    int deleteByPrimaryKey(Integer qyspid);

    int insert(TLbqysy record);

    int insertSelective(TLbqysy record);

    TLbqysy selectByPrimaryKey(Integer qyspid);

    int updateByPrimaryKeySelective(TLbqysy record);

    int updateByPrimaryKey(TLbqysy record);
}