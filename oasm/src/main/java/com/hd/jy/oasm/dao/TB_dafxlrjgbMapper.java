package com.hd.jy.oasm.dao;

import com.hd.jy.oasm.domain.TB_dafxlrjgb;

public interface TB_dafxlrjgbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TB_dafxlrjgb record);

    int insertSelective(TB_dafxlrjgb record);

    TB_dafxlrjgb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TB_dafxlrjgb record);

    int updateByPrimaryKey(TB_dafxlrjgb record);
}