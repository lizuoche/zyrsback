package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.CustomerMeasureData;

public interface CustomerMeasureDataMapper {
    int deleteByPrimaryKey(String measureid);

    int insert(CustomerMeasureData record);

    int addCustomerMeasureData(@Param("cmd") CustomerMeasureData cmd);

    CustomerMeasureData selectByPrimaryKey(String measureid);
    
    List<CustomerMeasureData> getCustomerMeasureData(@Param("ci")String ci, @Param("style") String style);

    int updateCustomerMeasureData(@Param("cmd") CustomerMeasureData cmd);

    int updateByPrimaryKey(CustomerMeasureData record);
}