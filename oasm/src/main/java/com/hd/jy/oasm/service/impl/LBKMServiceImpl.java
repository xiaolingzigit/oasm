package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.LBKMMapper;
import com.hd.jy.oasm.dao.ZCYCYQPCMapper;
import com.hd.jy.oasm.dao.newDao.TdminAndtyzDao;
import com.hd.jy.oasm.domain.LBKM;
import com.hd.jy.oasm.domain.WD;
import com.hd.jy.oasm.domain.ZCYCYQPC;
import com.hd.jy.oasm.domain.newDomain.Tscale;
import com.hd.jy.oasm.services.LBKMService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("lBKMServiceImpl")
@DataSource("userDataSource")
public class LBKMServiceImpl implements LBKMService {
	private Logger log = Logger.getLogger(LBKMServiceImpl.class);
	
	@Autowired
	private LBKMMapper lbkmDao; //量表库业务接口，集成入监、日常、中期、出监的业务接口

	@Autowired
	private ZCYCYQPCMapper zcycyqpcDao; //异常狱情排查业务接口
	
	@Autowired
	private TdminAndtyzDao tdminAndtyzDao; //量表库业务接口
	
	@Override
	public List<LBKM> selectAllkm() {
		// TODO Auto-generated method stub
		List<LBKM> list = null;
		try {
			log.info("开始全查询【LBKM】时间"+DateUtil.getTime(new Date()));
			list = lbkmDao.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询【LBKM】异常，请重试..."+e.getMessage());
		}
		return list;
	}
	
	//关闭已启用的量表
		@Override
		public int closeOrstartLBKMisLive(String lbbh) {
			// TODO Auto-generated method stub
			int i = 0;
			try {
				log.info("关闭或启用量表时间"+DateUtil.getTime(new Date()));
				i = lbkmDao.closeOrstartLBKMisLive(lbbh);
				log.info("成功关闭或启用量表"+i+"个");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("关闭或启用量表异常，请重试..."+e.getMessage());
			}
			return i;
		}

	//选出出监量表根据fl选出要答题的题目
	@Override
	public List<LBKM> cjlbtmyz(String fl) {
		// TODO Auto-generated method stub
		List<LBKM> cjlbtmyz = null;
		try {
			log.info("开始根据"+fl+"查询【出监量表因子】时间"+DateUtil.getTime(new Date()));
			cjlbtmyz = lbkmDao.cjlbtmyz(fl);
			log.info("成功查询【出监量表因子】"+cjlbtmyz.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据"+fl+"查询【出监量表因子异常】"+e.getMessage());
		}
		return cjlbtmyz;
	}

	//获取维度列表
	@Override
	public List<WD> selectAllWd() {
		// TODO Auto-generated method stub
		List<WD> selectAllWd = null;
		try {
			selectAllWd = lbkmDao.selectAllWd();
			log.info("查出"+selectAllWd.size()+"条数据");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("获取维度列表。"+e);
		}
		return selectAllWd;
	}

	//获取某个阶段的量表名
	@Override
	public List<LBKM> selectRDLB(String str) {
		// TODO Auto-generated method stub
		List<LBKM> selectRDLB = null;
		try {
			 selectRDLB = lbkmDao.selectRDLB(str);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(""+e);
		}
		return selectRDLB;
	}

	//调用异常狱情业务接口根据囚号查询异常狱情
	@Override
	public List<ZCYCYQPC> selectYCYQ(String yqztbh) {
		// TODO Auto-generated method stub
		List<ZCYCYQPC> ycyqList = null;
		try {
			if(yqztbh!=null&&yqztbh!=""){
				log.info("开始进行囚号"+yqztbh+"查询主体异常狱情时间"+DateUtil.getTime(new Date()));
				ycyqList = zcycyqpcDao.selectYCYQ(yqztbh);
			}else{
				log.error("根据囚号"+yqztbh+"查询主体异常狱情失败，请确认后重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据囚号查询主体异常狱情异常，请重试..."+e.getMessage());
		}
		return ycyqList;
	}

	//根据量表编号查询因子和维度，在后台量表详情使用
	@Override
	public String scaleRelatById(int scaleId) {
		// TODO Auto-generated method stub
		String scale = null;
		Tscale te;
		try {
			log.info("开始根据量表编号查询使用的【问题，维度，因子预览】时间"+DateUtil.getTime(new Date()));
			te = tdminAndtyzDao.getScaleByScaleId(scaleId);
			scale = te.getScale();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("量表使用的问题，维度，因子预览异常，请重试..."+e.getMessage(),e);
		}
		return scale;
	}


}
