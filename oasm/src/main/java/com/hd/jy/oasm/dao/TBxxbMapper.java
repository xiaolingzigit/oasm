package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TBxxb;

public interface TBxxbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBxxb record);

    int insertSelective(TBxxb record);

    TBxxb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBxxb record);

    int updateByPrimaryKey(TBxxb record);
}