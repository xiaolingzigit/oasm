package com.hd.jy.oasm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.SjjgftAndxwgcDao;
import com.hd.jy.oasm.dao.TestMapper;
import com.hd.jy.oasm.domain.TestNote;
import com.hd.jy.oasm.domain.ViewDafxjg;
import com.hd.jy.oasm.services.SjjgftAndxwgcService;
import com.hd.jy.oasm.util.date.DateUtil;
@Service("sjjgftAndxwgcServiceImpl")
@DataSource("userDataSource")
public class SjjgftAndxwgcServiceImpl implements SjjgftAndxwgcService {
    private Logger log = Logger.getLogger(SjjgftAndxwgcServiceImpl.class);
	
    @Autowired
    private SjjgftAndxwgcDao sjjgftAndxwgcDao;  //结构访谈和行为观察业务逻辑接口调用
    
    @Autowired
    private TestMapper testNoteDao; //答题结果显示
    
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//*********************************操作页面上档案分析数据视图部分******************************************************
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//档案分析结果表--把已有的档案分析结果数据显示在页面序号--维度--因子--分数
	@Override
	public TestNote searchDafxjg(String jcdaid) {
		// TODO Auto-generated method stub
		TestNote note = null;
		try {
			if(jcdaid!=null){
				log.info("开始根据【基础档案事件编号"+jcdaid+"】时间"+DateUtil.getTime(new Date()));
				note = testNoteDao.getNote(jcdaid);
				log.debug("查询已有的【档案分析结果】"+note.getAnswer());
			}else{
				log.error("【档案分析结果事件编号】为"+jcdaid+"，请重新确认后重试...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("根据【档案分析结果事件编号"+jcdaid+"】查询异常，请重试..."+e.getMessage());
		}
		return note;
	}

	/**
	 * @ TODO
	 * @authc quite
	 * @date 2017年12月23日
	 * @see com.hd.jy.oasm.services.SjjgftAndxwgcService#selectDafxjgbg(java.util.Map)
	 */
	@Override
	public List<ViewDafxjg> selectDafxjgbg(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<ViewDafxjg> dafxjgbg = null;
		try {
			log.info("开始全查询【档案分析结果】数据时间"+DateUtil.getTime(new Date()));
			dafxjgbg = sjjgftAndxwgcDao.selectDafxjgbg(map);
			log.info("成功查出【档案分析结果】数据"+dafxjgbg.size()+"条");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("全查询【档案分析结果】数据失败，请稍后重试..."+e.getMessage(),e);
		}
		return dafxjgbg;
	}

}
