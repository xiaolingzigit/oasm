package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.LxRj;

public interface LxRjMapper {
    int insert(LxRj record);

    int insertSelective(LxRj record);
    
    LxRj selectLxByQh(long qh);
}