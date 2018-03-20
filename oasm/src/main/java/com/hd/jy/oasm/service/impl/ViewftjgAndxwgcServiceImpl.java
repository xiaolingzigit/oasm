package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.ViewftjgAndxwgcDao;
import com.hd.jy.oasm.dao.newDao.ViewpgglMapper;
import com.hd.jy.oasm.domain.ViewDasjfx;
import com.hd.jy.oasm.domain.Viewcjjgft;
import com.hd.jy.oasm.domain.Viewcjxwgc;
import com.hd.jy.oasm.domain.Viewrcxwgc;
import com.hd.jy.oasm.domain.Viewrjjgft;
import com.hd.jy.oasm.domain.Viewrjxwgc;
import com.hd.jy.oasm.domain.Viewzqjgft;
import com.hd.jy.oasm.domain.Viewzqxwgc;
import com.hd.jy.oasm.domain.newDomain.Viewpggl;
import com.hd.jy.oasm.services.ViewftjgAndxwgcService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("viewftjgAndxwgcServiceImpl")
@DataSource("userDataSource")
public class ViewftjgAndxwgcServiceImpl implements ViewftjgAndxwgcService{
    private Logger log = Logger.getLogger(ViewftjgAndxwgcServiceImpl.class);
    
    @Autowired
    private ViewftjgAndxwgcDao viewftAndgcDao; //访谈和行为观察视图业务接口
    
    @Autowired
    private ViewpgglMapper viewpgglDao; //调用v_pggl视图业务接口
	
    //入监访谈视图
	@Override
	public List<Viewrjjgft> showViewrjjgft(String jh) {
		// TODO Auto-generated method stub
		List<Viewrjjgft> viewrjjgft = null;
		try {
			log.info("开始查询【入监结构访谈视图Viewrjjgft】时间"+DateUtil.getTime(new Date()));
			viewrjjgft = viewftAndgcDao.showViewrjjgft(jh);
			log.info("成功根据"+jh+"查出【入监结构访谈视图Viewrjjgft】"+viewrjjgft.size()+"条数据");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据"+jh+"查询【入监结构访谈视图Viewrjjgft】失败，请重试..."+e.getMessage());
		}
		return viewrjjgft;
	}

	//中期访谈视图
	@Override
	public List<Viewzqjgft> showViewzqjgft(String jh) {
		// TODO Auto-generated method stub
		List<Viewzqjgft> viewzqjgft = null;
		try {
			log.info("开始查询【中期访谈视图Viewzqjgft】时间"+DateUtil.getTime(new Date()));
			viewzqjgft = viewftAndgcDao.showViewzqjgft(jh);
			log.info("成功根据"+jh+"查出【中期访谈视图Viewzqjgft】"+viewzqjgft.size()+"条数据");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据"+jh+"查询【中期访谈视图Viewzqjgft】失败，请重试..."+e.getMessage());
		}
		return viewzqjgft;
	}

	//出监访谈视图
	@Override
	public List<Viewcjjgft> showViewcjjgft(String jh) {
		// TODO Auto-generated method stub
		List<Viewcjjgft> viewcjjgft = null;
		try {
			log.info("开始查询【出监访谈视图Viewcjjgft】时间"+DateUtil.getTime(new Date()));
			viewcjjgft = viewftAndgcDao.showViewcjjgft(jh);
			log.info("成功根据"+jh+"查出【出监访谈视图Viewcjjgftviewcjjgft】数据"+viewcjjgft.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据"+jh+"查询【出监访谈视图Viewcjjgftviewcjjgft】失败，请重试"+e.getMessage());
		}
		return viewcjjgft;
	}

	//入监行为观察视图
	@Override
	public List<Viewrjxwgc> findViewrjxwgc(String jh) {
		// TODO Auto-generated method stub/
		List<Viewrjxwgc> viewrjxwgc = null;
		try {
			log.info("开始查询【入监行为观察视图Viewrjxwgc】时间"+DateUtil.getTime(new Date()));
			viewrjxwgc = viewftAndgcDao.findViewrjxwgc(jh);
			log.info("成功根据"+jh+"查询【入监行为观察视图Viewrjxwgc】数据"+viewrjxwgc.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据"+jh+"查询【入监行为观察视图Viewrjxwgc】失败，请重试..."+e.getMessage());
		}
		return viewrjxwgc;
	}

	//日常观察视图
	@Override
	public List<Viewrcxwgc> findViewrcxwgc(String jh) {
		// TODO Auto-generated method stub
		List<Viewrcxwgc> viewrcxwgc = null;
		try {
			log.info("开始查询【日常观察viewrcxwgc】时间"+DateUtil.getTime(new Date()));
			viewrcxwgc = viewftAndgcDao.findViewrcxwgc(jh);
			log.info("成功根据"+jh+"【日常观察viewrcxwgc】"+viewrcxwgc.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据"+jh+"查询【日常观察viewrcxwgc】失败，请重试..."+e.getMessage());
		}
		return viewrcxwgc;
	}

	//中期观察视图
	@Override
	public List<Viewzqxwgc> findViewzqxwgc(String jh) {
		// TODO Auto-generated method stub
		List<Viewzqxwgc> viewzqxwgc = null;
		try {
			log.info("开始查询【中期观察视图Viewzqxwgc】时间"+DateUtil.getTime(new Date()));
			viewzqxwgc = viewftAndgcDao.findViewzqxwgc(jh);
			log.info("成功根据"+jh+"查询【中期观察视图Viewzqxwgc】数据"+viewzqxwgc.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据"+jh+"查询【中期观察视图Viewzqxwgc】失败，请重试..."+e.getMessage());
		}
		return viewzqxwgc;
	}

	//出监观察视图
	@Override
	public List<Viewcjxwgc> findViewcjxwgc(String jh) {
		// TODO Auto-generated method stub
		List<Viewcjxwgc> viewcjxwgc = null;
		try {
			log.info("开始查询【出监观察视图Viewcjxwgc】时间"+DateUtil.getTime(new Date()));
			viewcjxwgc = viewftAndgcDao.findViewcjxwgc(jh);
			log.info("成功根据"+jh+"查询出【出监观察视图Viewcjxwgc】"+viewcjxwgc.size()+"条数据");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据"+jh+"查询【出监观察视图Viewcjxwgc】失败，请重试..."+e.getMessage());
		}
		return viewcjxwgc;
	}

	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//********************************以上代码废弃***************************************************
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	//新入监结构访谈视图数据
	@Override
	public List<Viewpggl> rjjgftViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> rjjgftViewpggl = null;
		try {
			log.info("开始使用【警号】动态查询入监结构访谈数据时间"+DateUtil.getTime(new Date()));
			//这里判断警号为null时，应该调用角色判断依据
			
			rjjgftViewpggl = viewpgglDao.rjjgftViewpggl(map);
			log.info("成功使用警号动态查询出入监结构访谈数据"+rjjgftViewpggl.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("使用警号查询入监结构访谈数据时间异常，请重试..."+e.getMessage());
		}
		return rjjgftViewpggl;
	}

	//新入监行为观察视图数据
	@Override
	public List<Viewpggl> rjxwgcViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> rjxwgcViewpggl = null;
		try {
			log.info("开始根据警号【警号"+map.get("jh")+"查询入监行为观察数据时间"+DateUtil.getTime(new Date()));
			rjxwgcViewpggl = viewpgglDao.rjxwgcViewpggl(map);
			log.info("成功使用警号【"+map.get("jh")+"】动态查询出入监行为观察数据"+rjxwgcViewpggl.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("使用警号动态查询入监行为观察数据失败，请重试..."+e.getMessage());
		}
		return rjxwgcViewpggl;
	}

	//新日常行为观察视图数据显示
	@Override
	public List<Viewpggl> rcxwgcViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> rcxwgcViewpggl = null;
		try {
			log.info("开始根据登录警号动态查询显示【新日常行为观察】数据时间"+DateUtil.getTime(new Date()));
			rcxwgcViewpggl = viewpgglDao.rcxwgcViewpggl(map);
			log.info("成功根据警号【"+map.get("jh")+"】动态查询出新日常行为观察视图数据【"+rcxwgcViewpggl.size()+"】条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据登录警号查询信日常新闻观察视图数据异常"+e.getMessage(),e);
		}
		return rcxwgcViewpggl;
	}

	//新中期结构访谈视图数据显示
	@Override
	public List<Viewpggl> zqjgftViewpggl(Map<String,Object> map) {
		List<Viewpggl> zqjgftViewpggl = null;
		try {
			log.info("开始根据登录警号动态查询【新中期结构访谈视图】数据时间"+DateUtil.getTime(new Date()));
			zqjgftViewpggl = viewpgglDao.zqjgftViewpggl(map);
			log.info("成功根据登录警号【"+map.get("jh")+"】查询出新中期结构访谈视图数据【"+zqjgftViewpggl.size()+"】条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询新中期结构访谈视图数据异常"+e.getMessage(),e);
		}
		// TODO Auto-generated method stub
		return zqjgftViewpggl;
	}

	//新中期行为观察视图数据显示
	@Override
	public List<Viewpggl> zqxwgcViewpggl(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Viewpggl> zqxwgcViewpggl = null;
		try {
			log.info("开始查询【新中期行为观察】视图数据时间"+DateUtil.getTime(new Date()));
			zqxwgcViewpggl = viewpgglDao.zqxwgcViewpggl(map);
			log.info("成功根据警号【"+map.get("jh")+"】查询出新中期行为观察视图数据【"+zqxwgcViewpggl.size()+"】条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据警号动态查询新中期行为观察视图数据异常"+e.getMessage(),e);
		}
		return zqxwgcViewpggl;
	}

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
