package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.newDao.ViewpgglMapper;
import com.hd.jy.oasm.domain.newDomain.Viewpggl;
import com.hd.jy.oasm.services.ViewftjgAndxwgcService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("viewftjgAndxwgcServiceImpl")
@DataSource("userDataSource")
public class ViewftjgAndxwgcServiceImpl implements ViewftjgAndxwgcService{
    private Logger log = Logger.getLogger(ViewftjgAndxwgcServiceImpl.class);
    
//    @Autowired
//    private ViewftjgAndxwgcDao viewftAndgcDao; //访谈和行为观察视图业务接口
    
    @Autowired
    private ViewpgglMapper viewpgglDao; //调用v_pggl视图业务接口

	//新出监结构访谈视图数据显示
	@Override
	public List<Viewpggl> cjjgftViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> cjjgftViewpggl = null;
		try {
			log.info("开始查询【新出监结构访谈】视图数据时间"+DateUtil.getTime(new Date()));
			cjjgftViewpggl = viewpgglDao.cjjgftViewpggl(map);
			log.info("成功根据警号【"+map.get("jh")+"】查询出新出监结构访谈视图数据【"+cjjgftViewpggl.size()+"】条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询新出监结构访谈视图数据异常"+e.getMessage(),e);
		}
		return cjjgftViewpggl;
	}

	//先出监行为观察视图数据显示
	@Override
	public List<Viewpggl> cjxwgcViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> cjxwgcViewpggl = null;
		try {
			log.info("开始进行查询【新出监行为观察】视图数据时间"+DateUtil.getTime(new Date()));
			cjxwgcViewpggl = viewpgglDao.cjxwgcViewpggl(map);
			log.info("成功根据警号【"+map.get("jh")+"】查询出新出监行为观察视图数据【"+cjxwgcViewpggl+"】条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询新出监行为观察视图数据异常"+e.getMessage(),e);
		}
		return cjxwgcViewpggl;
	}

}
