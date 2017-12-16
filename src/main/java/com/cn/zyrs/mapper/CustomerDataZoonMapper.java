package com.cn.zyrs.mapper;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.CustomerDataZoon;

public interface CustomerDataZoonMapper {
    int deleteByPrimaryKey(String detailcode);

    int insert(CustomerDataZoon record);

    int insertSelective(@Param("customerdatazoon") CustomerDataZoon customerdatazoon);

    CustomerDataZoon selectByPrimaryKey(String detailcode);

    int updateByPrimaryKeySelective(CustomerDataZoon record);

    int updateByPrimaryKey(CustomerDataZoon record);
}