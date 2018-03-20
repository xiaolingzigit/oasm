package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.LbBz;

public interface LbBzMapper {
    int deleteByPrimaryKey(Integer pzid);

    int insert(LbBz record);

    int insertSelective(LbBz record);

    LbBz selectByPrimaryKey(Integer pzid);

    int updateByPrimaryKeySelective(LbBz record);

    int updateByPrimaryKey(LbBz record);
    
    List<LbBz> getAllLbBz();	//获取lb_bz的全部数据
}