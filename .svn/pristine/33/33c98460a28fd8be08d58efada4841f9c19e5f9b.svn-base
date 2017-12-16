package com.cn.zyrs.service;

import java.util.List;

import com.cn.zyrs.domain.BomOrder;
import com.cn.zyrs.domain.Craft;
import com.cn.zyrs.domain.Order;
import com.cn.zyrs.domain.OrderCraft;
import com.cn.zyrs.domain.OrderSpecialCraft;
import com.cn.zyrs.domain.SpecialCraft;

public abstract interface IOrder {
	
	List<Order> getOrder(String ordercode,String customername,String servicer,String status,String start,String end,String page,String odpid);
	
	/**
	 * 
	 * 业  务: 查询门店订单基本信息 <br>
	 * 英文名: getOrderBase 
	 * 功能号: TODO
	 * 时  间: 2017年7月31日 下午5:31:41
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<Order> getOrderBase(String di);
	
	Order getOrderByPrimaryKey(String ordercode);
	
	int updateOrder(Order order);

	int addOrder(Order order);
	
	int addBomOrder(BomOrder bomorder);
	
	int addBomOrder1(BomOrder bomorder);
	
	int addBomOrder2(BomOrder bomorder);
	
	/**
	 * 
	 * 业  务: 查询工艺信息 <br>
	 * 英文名: getCraft 
	 * 功能号: TODO
	 * 时  间: 2017年5月15日 下午7:10:10
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<Craft> getCraft(String type);
	
	
	/**
	 * 
	 * 业  务: 查询特殊工艺信息 <br>
	 * 英文名: getSpecialCraft 
	 * 功能号: TODO
	 * 时  间: 2017年5月15日 下午7:16:57
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<SpecialCraft> getSpecialCraft(String type);
	
	
	/**
	 * 
	 * 业  务: 新增订单工艺信息 <br>
	 * 英文名: addOrderCraft 
	 * 功能号: TODO
	 * 时  间: 2017年5月15日 下午8:07:01
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addOrderCraft(OrderCraft oc);
	
	/**
	 * 
	 * 业  务: 新增订单特殊工艺信息 <br>
	 * 英文名: addOrderSpecialCraft 
	 * 功能号: TODO
	 * 时  间: 2017年5月15日 下午8:09:44
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addOrderSpecialCraft(OrderSpecialCraft osc);

}
