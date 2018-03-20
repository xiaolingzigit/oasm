/**
 * 
 */
package com.hd.jy.oasm.dao.newDao;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.newDomain.Twdyzgx;
import com.hd.jy.oasm.domain.newDomain.Tysk;

/**
 * @author quite
 *修改因子维度设计DB操作层
 */
public interface TyskAndwdDao {
	/**
	 * @todo TODO 添加因子或者维度
	 * @param tysk
	 * @return
	 * @auth quite
	 * @time 2018年1月12日 下午6:21:24
	 */
	int addTysk(Tysk tysk);
	/**
	 * @todo TODO 添加维度和因子关系
	 * @param record
	 * @return
	 * @auth quite
	 * @time 2018年1月12日 下午6:22:25
	 */
	int addTwdyzgx(Twdyzgx record);
	/**
	 * @todo TODO 修改因子或者维度
	 * @param tysk
	 * @return
	 * @auth quite
	 * @time 2018年1月12日 下午6:23:21
	 */
	int updateTysk(Tysk tysk);
	/**
	 * 
	 * @todo TODO 检索一些维度
	 * @param map
	 * @return
	 * @auth quite
	 * @time 2018年1月13日 下午3:24:08
	 *
	 */
	List<Tysk> likeSomeWdKey(Map<String,String> map);
	
	/**
	 * @todo TODO 检索一些因子
	 * @param map
	 * @return
	 * @auth quite
	 * @time 2018年1月13日 下午3:23:24
	 *
	 */
	List<Tysk> likeSomeTyskKey(Map<String,String> map);
	/**
	 * 
	 * @todo TODO 总因子检索器
	 * @param map
	 * @return
	 * @auth quite
	 * @time 2018年1月13日 下午3:22:16
	 *
	 */
	List<Tysk> likeTyskKey(Map<String,String> map);
	
	
}
