package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.Tzyrymd;

public interface TzyrymdMapper {
    int insert(Tzyrymd record);

    int insertSelective(Tzyrymd record);
    
    Tzyrymd selectBDJCbyqh(long qh); //根据囚号查出关联的警察
    
    int updateCjftzt(long qh); //更改出监已结构访谈的状态，jd为4
    
    int updateCjgczt(long qh); //更改出监已行为观察的状态，jd为4
    
    List<Tzyrymd> useZyyrymdProduce(); //调用导入数据到在押人员名单接口的存储过程返回多个囚号
    
    int crimPlaceSaveOrUpdate(Tjczjdx record); //使用excel表格导入罪犯与警察的关联信息
}