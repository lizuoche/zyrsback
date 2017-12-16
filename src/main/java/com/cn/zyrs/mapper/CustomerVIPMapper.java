package com.cn.zyrs.mapper;

import com.cn.zyrs.domain.CustomerVIP;

public interface CustomerVIPMapper {
    int deleteByPrimaryKey(String id);

    int insert(CustomerVIP record);

    int insertSelective(CustomerVIP record);

    CustomerVIP selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerVIP record);

    int updateByPrimaryKey(CustomerVIP record);
}