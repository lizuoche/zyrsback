package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(@Param("detailcode") String detailcode);

    int insert(@Param("orderdetail") OrderDetail record);

    int insertSelective(@Param("orderdetail") OrderDetail record);

    List<OrderDetail> selectByOrderCode(@Param("ordercode") String paramString1);
    
    List<OrderDetail> selectByCustomerid(String customerid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
    
    List<OrderDetail> getDetail(@Param("ordercode") String paramString1,@Param("ownerdeptid") String paramString2);
    
    int selectDetailCountByOrderCode(@Param("ordercode") String paramString1);
    
}