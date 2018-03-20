package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.SclBz;

public interface SclBzMapper {
    int deleteByPrimaryKey(String xmid);

    int insert(SclBz record);

    int insertSelective(SclBz record);

    SclBz selectByPrimaryKey(String xmid);

    int updateByPrimaryKeySelective(SclBz record);

    int updateByPrimaryKey(SclBz record);
    
    List<SclBz> getAll();
}