package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.LxRc;

public interface LxRcMapper {
    int insert(LxRc record);

    int insertSelective(LxRc record);
    
    LxRc selectLxrc(long qh);
}