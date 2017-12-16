package com.cn.zyrs.service;

import java.util.List;

import com.cn.zyrs.domain.OrderDetail;

public abstract interface IOrderDetail {
	
	List<OrderDetail> getOrderDetail(String ordercode,String odpid);
	
	List<OrderDetail> getOrderDetaiByOrderCode(String ordercode);

	int deletdeOrderDetail(String orderdetailcode);
	
	int addOrderDetail(OrderDetail orderdetail);
	
	int selectDetailCountByOrderCode(String ordercode);
	

}
