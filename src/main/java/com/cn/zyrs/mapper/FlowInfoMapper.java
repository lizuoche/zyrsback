package com.cn.zyrs.mapper;

import com.cn.zyrs.domain.FlowInfo;

public interface FlowInfoMapper {
    int deleteByPrimaryKey(String ordercode);

    int insert(FlowInfo record);

    int insertSelective(FlowInfo record);

    FlowInfo selectByPrimaryKey(String ordercode);

    int updateByPrimaryKeySelective(FlowInfo record);

    int updateByPrimaryKey(FlowInfo record);
}