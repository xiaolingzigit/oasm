package com.hd.jy.oasm.services;

import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.Tzyrymd;

public interface TzyrymdService {
	public Tzyrymd selectBDJCbyqh(long qh); //根据囚号查出关联的警察
	
	public int updateRjftzt(long qh); //根据囚号更改已访谈状态,jd=1
	
	public int updateGczt(long qh);  //根据囚号更改已观察的状态,jd=1
	
	public int updateRcgczt(long qh); //根据囚号更改日常已行为观察的状态,jd为2
	    
	    
    public  int updateZqftzt(long qh); //根据囚号更改中期已结构访谈的状态,jd为3
	    
    public  int updateZqGczt(long qh); //更改中期已行为观察的状态,jd为3
	    
	    
    public int updateCjftzt(long qh); //更改出监已结构访谈的状态，jd为4
	    
	public int updateCjgczt(long qh); //更改出监已行为观察的状态，jd为4
	
	public int crimPlaceSaveOrUpdate(Tjczjdx record); //使用excel表格导入罪犯与警察的关联信息
}
