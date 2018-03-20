package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBpglxb;

public interface TBpglxbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBpglxb record);

    int insertSelective(TBpglxb record);

    TBpglxb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBpglxb record);

    int updateByPrimaryKey(TBpglxb record);
}