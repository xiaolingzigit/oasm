package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBpfb;

public interface TBpfbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBpfb record);

    int insertSelective(TBpfb record);

    TBpfb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBpfb record);

    int updateByPrimaryKey(TBpfb record);
}