package com.hd.jy.oasm.services;

import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.Tzyrymd;

public interface TzyrymdService {
	public Tzyrymd selectBDJCbyqh(long qh); //根据囚号查出关联的警察
  
    public int updateCjftzt(long qh); //更改出监已结构访谈的状态，jd为4
	    
	public int updateCjgczt(long qh); //更改出监已行为观察的状态，jd为4
	
	public int crimPlaceSaveOrUpdate(Tjczjdx record); //使用excel表格导入罪犯与警察的关联信息
}
