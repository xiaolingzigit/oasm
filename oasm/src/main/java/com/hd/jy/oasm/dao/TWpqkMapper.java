package com.hd.jy.oasm.dao;

import java.util.Date;
import java.util.List;

import com.hd.jy.oasm.domain.TWpqk;

public interface TWpqkMapper {
    
    public List<TWpqk> getDate(Date sj);	//获取某段时间的数据
    
    Date getTopDate();//返回最开始的时间 
}