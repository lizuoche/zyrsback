package com.cn.zyrs.mapper;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.SaleSetting;

public interface SaleSettingMapper {
//    int deleteByPrimaryKey(SaleSettingKey key);

    int insert(SaleSetting record);

    int insertSelective(SaleSetting record);

//    SaleSetting selectByPrimaryKey(SaleSettingKey key);
    
    SaleSetting selectByPrimaryKeySelective(@Param("salesetting") SaleSetting salesetting);

    String getStyleDiscount(@Param("ssc") String ssc, @Param("di") String di);
    
    int updateByPrimaryKeySelective(SaleSetting record);

    int updateByPrimaryKey(SaleSetting record);
}