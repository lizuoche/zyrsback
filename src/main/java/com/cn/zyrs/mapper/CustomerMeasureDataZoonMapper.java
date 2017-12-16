package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.CustomerMeasureDataZoon;

public interface CustomerMeasureDataZoonMapper {
    int deleteByPrimaryKey(String measureid);

    int insert(CustomerMeasureDataZoon record);

    int insertSelective(@Param("customermeasuredatazoon")CustomerMeasureDataZoon customermeasuredatazoon);

    CustomerMeasureDataZoon selectByPrimaryKey(String measureid);
    
    List<CustomerMeasureDataZoon> selectBySelective(@Param("customerid") String customerid, @Param("style") String style);

    int updateByPrimaryKeySelective(@Param("customermeasuredatazoon") CustomerMeasureDataZoon customermeasuredatazoon);

    int updateByPrimaryKey(CustomerMeasureDataZoon record);
}