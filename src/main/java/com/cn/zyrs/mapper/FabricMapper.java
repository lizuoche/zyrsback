package com.cn.zyrs.mapper;

import com.cn.zyrs.domain.Fabric;

public interface FabricMapper {
    int deleteByPrimaryKey(String fabricid);

    int insert(Fabric record);

    int insertSelective(Fabric record);

    Fabric selectByPrimaryKey(String fabricid);

    int updateByPrimaryKeySelective(Fabric record);

    int updateByPrimaryKey(Fabric record);
}