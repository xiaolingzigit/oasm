package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.Tzyrymd;

public interface TzyrymdMapper {
    int insert(Tzyrymd record);

    int insertSelective(Tzyrymd record);
    
    Tzyrymd selectBDJCbyqh(long qh); //根据囚号查出关联的警察
    
    int updateRjftzt(long qh); //根据囚号更改已访谈状态状态，jd为1
    
    int updateGczt(long qh);  //根据囚号更改已观察的状态状态,jd为1
    
    
    int updateRcgczt(long qh); //根据囚号更改日常已行为观察的状态,jd为2
    
    
    int updateZqftzt(long qh); //根据囚号更改中期已结构访谈的状态,jd为3
    
    int updateZqGczt(long qh); //更改中期已行为观察的状态,jd为3
    
    
    int updateCjftzt(long qh); //更改出监已结构访谈的状态，jd为4
    
    int updateCjgczt(long qh); //更改出监已行为观察的状态，jd为4
    
    List<Tzyrymd> useZyyrymdProduce(); //调用导入数据到在押人员名单接口的存储过程返回多个囚号
    
    int crimPlaceSaveOrUpdate(Tjczjdx record); //使用excel表格导入罪犯与警察的关联信息
}