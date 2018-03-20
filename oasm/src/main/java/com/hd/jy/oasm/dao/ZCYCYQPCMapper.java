package com.hd.jy.oasm.dao;

import java.util.List;

import com.hd.jy.oasm.domain.ZCYCYQPC;
/***
 *异常狱情业务接口 
 * @author quite
 *集成到LBKMSerivce
 */
public interface ZCYCYQPCMapper {
    int insert(ZCYCYQPC record);

    int insertSelective(ZCYCYQPC record);
    
    /**
     * 根据String类型的囚号查询异常狱情--矫正项目--罪犯信息查询 显示
     * 四大评--行为观察 显示
     * @auto quite
     * @param yqztbh
     * @returna
     * 下午3:19:24
     * List<ZCYCYQPC>
     */
    List<ZCYCYQPC> selectYCYQ(String yqztbh); 
    
}