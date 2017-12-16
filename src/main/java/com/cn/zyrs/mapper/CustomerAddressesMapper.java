package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.CustomerAddresses;
import com.cn.zyrs.domain.DeptAddresses;

public interface CustomerAddressesMapper {
    int deleteByPrimaryKey(String addressid);

    int insert(CustomerAddresses customeraddress);

    int insertSelective(@Param("customeraddress") CustomerAddresses customeraddress);

    CustomerAddresses selectByPrimaryKey(String addressid);
    
    List<CustomerAddresses> selectByCustomerID(@Param("customerid") String customerid);
    
    List<DeptAddresses> selectByDeptID(@Param("deptid") String deptid);

    int updateByPrimaryKeySelective(@Param("customeraddress") CustomerAddresses customeraddress);
    
    int resetIsdefault(@Param("customerid") String customerid);

    int updateByPrimaryKey(CustomerAddresses record);
}