package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TByqpcb;

public interface TByqpcbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TByqpcb record);

    int insertSelective(TByqpcb record);

    TByqpcb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TByqpcb record);

    int updateByPrimaryKey(TByqpcb record);
}