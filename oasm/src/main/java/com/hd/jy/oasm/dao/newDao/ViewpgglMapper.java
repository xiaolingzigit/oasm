package com.hd.jy.oasm.dao.newDao;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.newDomain.Viewpggl;
/**
 * v_pggl视图业务接口
 * @author quite
 * 在ViewftjgAndxwgcService写业务接口
 *
 */
public interface ViewpgglMapper {
    int insert(Viewpggl record);

    int insertSelective(Viewpggl record);
    
    List<Viewpggl> cjjgftViewpggl(Map<String,Object> map);//出监访谈动态数据视图
    
    List<Viewpggl> cjxwgcViewpggl(Map<String,Object> map);//出监观察动态数据视图
    
    /**
     * 根据囚号显示罪犯已有分数的结构访谈  矫正项目--罪犯信息查询 显示
     * @auto quite
     * @param crimNo
     * @returna
     * 下午3:26:42
     * List<Viewpggl>
     */
    List<Viewpggl> crimInfoGrft(String crimNo);
    /**
     * 根据囚号显示罪犯已有分数的行为观察 矫正项目——罪犯信息查询  显示
     * @auto quite
     * @param crimNo
     * @returna
     * 下午3:27:44
     * List<Viewpggl>
     */
    List<Viewpggl> crimInfoGrgc(String crimNo);
}