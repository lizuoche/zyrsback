package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.Customer;
import com.cn.zyrs.domain.CustomerBaseInfo;
import com.cn.zyrs.domain.CustomerVIP;

public interface CustomerMapper {
    int deleteByPrimaryKey(String customerid);

    int insert(Customer record);

    int insertSelective(@Param("customer")Customer record);
    
    int insertVIPSelective(@Param("vip")CustomerVIP vip);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    List<CustomerBaseInfo> getCustomerInfoBase(@Param("customer") Customer customer,@Param("num") int num,@Param("di") String di);
    
    Customer getCustomerInfoDetail(@Param("ci") String ci);
}