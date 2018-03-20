package com.hd.jy.oasm.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.TzyrymdMapper;
import com.hd.jy.oasm.domain.Tjczjdx;
import com.hd.jy.oasm.domain.Tzyrymd;
import com.hd.jy.oasm.services.TzyrymdService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("tzyrymdServiceImpl")
@DataSource("userDataSource")
public class TzyrymdServiceImpl implements TzyrymdService {
	private Logger log = Logger.getLogger(TzyrymdServiceImpl.class);

	@Autowired
	private TzyrymdMapper tzyrymdDao;  //在押罪犯业务接口
	
	@Override
	public Tzyrymd selectBDJCbyqh(long qh) {
		// TODO Auto-generated method stub
		Tzyrymd bdjCbyqh = null;
		try {
			log.info("开始根据囚号查询【绑定的警察Tzyrymd】时间"+DateUtil.getTime(new Date()));
			bdjCbyqh = tzyrymdDao.selectBDJCbyqh(qh);
			log.info("成功根据"+qh+"查询【绑定的警察Tzyrymd】");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据"+qh+"查询【绑定的警察Tzyrymd】失败"+e.getMessage());
		}
		return bdjCbyqh;
	}

	//更改rj访谈调查状态
	@Override
	public int updateRjftzt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateRjftzt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//更改rj行为观察状态
	@Override
	public int updateGczt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateGczt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//更改日常观察状态
	@Override
	public int updateRcgczt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateRcgczt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//更改中期结构访谈状态
	@Override
	public int updateZqftzt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateZqftzt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//更改中期行为观察状态
	@Override
	public int updateZqGczt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateZqGczt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//更改出监结构访谈状态
	@Override
	public int updateCjftzt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateCjftzt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//更改出监行为观察状态
	@Override
	public int updateCjgczt(long qh) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = tzyrymdDao.updateCjgczt(qh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	 //使用excel表格导入罪犯与警察的关联信息 这里只做简单的逻辑处理。实际应用应该是包括显示导入的所有内容
	@Override
	public int crimPlaceSaveOrUpdate(Tjczjdx record) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			log.info("开始【导入囚犯与警察的关系】时间"+DateUtil.getTime(new Date()));
			i = tzyrymdDao.crimPlaceSaveOrUpdate(record);
			log.info("成功导入囚犯与警察关系"+i+"条数据");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("导入囚犯与警察关系异常，请重试...");
		}
		return i;
	}

}
