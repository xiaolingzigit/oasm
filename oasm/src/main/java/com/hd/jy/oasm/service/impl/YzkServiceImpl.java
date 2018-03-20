package com.hd.jy.oasm.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.jy.oasm.annotation.DataSource;
import com.hd.jy.oasm.dao.YzkMapper;
import com.hd.jy.oasm.domain.Yzk;
import com.hd.jy.oasm.services.YzkService;
/**
 * 
* @ClassName: YzkServiceImpl 
* @Description: 查询
* @author liangjiaying
* @date 2017年11月15日 下午10:47:50 
*
 */
@DataSource("userDataSource")
@Service("yzkServiceImpl")
public class YzkServiceImpl implements YzkService{
	
	private Logger log = Logger.getLogger(YzkService.class);
	
	@Autowired
	private YzkMapper yzkMapper;
	
	@Override
	public List<Yzk> getAllYzk() {
		// TODO Auto-generated method stub
		List<Yzk> allYzk = null;
		try {
			allYzk = yzkMapper.getAllYzk();
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
		}
		return allYzk;
	}

}
