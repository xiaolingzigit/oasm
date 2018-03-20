package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.LxCj;

public interface LxCjMapper {
    int insert(LxCj record);

    int insertSelective(LxCj record);
    
    LxCj selectLxcj(long qh);
}