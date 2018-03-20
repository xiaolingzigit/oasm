package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TB_dafxlb;

public interface TB_dafxlbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TB_dafxlb record);

    int insertSelective(TB_dafxlb record);

    TB_dafxlb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TB_dafxlb record);

    int updateByPrimaryKey(TB_dafxlb record);
}