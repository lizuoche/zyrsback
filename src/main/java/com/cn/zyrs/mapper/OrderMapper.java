package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.BomOrder;
import com.cn.zyrs.domain.Craft;
import com.cn.zyrs.domain.Order;
import com.cn.zyrs.domain.OrderCraft;
import com.cn.zyrs.domain.OrderSpecialCraft;
import com.cn.zyrs.domain.SpecialCraft;

public interface OrderMapper {
	int deleteByPrimaryKey(String ordercode);

	int insert(Order record);

	int insertSelective(@Param("order") Order record);
	
	int addBomOrder(@Param("bomorder") BomOrder bomorder);
	
	int addBomOrder1(@Param("bomorder") BomOrder bomorder);
	
	int addBomOrder2(@Param("bomorder") BomOrder bomorder);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);

	List<Order> getOrder(@Param("ordercode") String paramString1,
			@Param("customername") String paramString2,
			@Param("servicer") String paramString3,
			@Param("orderstatus") String paramString4,
			@Param("start") String paramString5,
			@Param("end") String paramString6,
			@Param("num") int paramInt1,
			@Param("odpid") String odpid);
	
	List<Order> getOrderBase(@Param("di") String di);
	
	List<Order> getOrder1(@Param("ordercode") String paramString1,
			@Param("customername") String paramString2,
			@Param("servicer") String paramString3,
			@Param("orderstatus") String paramString4,
			@Param("start") String paramString5,
			@Param("end") String paramString6,
			@Param("odpid") String odpid);
	
	Order getOrderByPrimaryKey(@Param("ordercode") String paramString1);

	int updateOrder(@Param("order") Order order);
	
	List<Craft> getCraft(@Param("type") String type);
	
	List<SpecialCraft> getSpecialCraft(@Param("type") String type);
	
	int addOrderCraft(@Param("oc") OrderCraft oc);
	
	int addOrderSpecialCraft(@Param("osc") OrderSpecialCraft osc);

//	List<OrderDetail> getOrderDetail(@Param("ordercode") String paramString1);
}