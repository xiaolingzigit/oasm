package com.hd.jy.oasm.dao;

import java.util.List;
import java.util.Map;

import com.hd.jy.oasm.domain.BGjbxx;
import com.hd.jy.oasm.domain.JYXX;
import com.hd.jy.oasm.domain.VPgbgList;
import com.hd.jy.oasm.domain.Viewgrpgbgxx;
/***
 * 个人评估业务接口
 * @author quite
 *操作评估报告使用
 *调用：在VpgbgListService中调用
 */
public interface VPgbgListMapper {
    
    List<VPgbgList> getViewPgbg(Map<String,Object> map); //评估信息列表
    
    BGjbxx crimInfoBycrimNo(String qh); //个人评估信息，根据罪犯囚号显示他的基本信息
    
    List<VPgbgList> getGrdjbh(String qh);
    
    List<VPgbgList> getLsPgbg(String qh);
    
    List<VPgbgList> listViewPgbgAndTCzsh(Map<String,Object> map);//显示报告处理跟踪、审核、意见
    
    List<BGjbxx> selectJbxx(); //查询罪犯基本信息
}