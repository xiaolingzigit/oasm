package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.Lbdafx;

public interface LbdafxMapper {
    int deleteByPrimaryKey(Integer xh);

    int insert(Lbdafx record);

    int insertSelective(Lbdafx record);

    Lbdafx selectByPrimaryKey(Integer xh);

    int updateByPrimaryKeySelective(Lbdafx record);

    int updateByPrimaryKey(Lbdafx record);
    
//    Lbdafx selectYz(String sjxbm);
}