package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.BomOrder;
import com.cn.zyrs.domain.Craft;
import com.cn.zyrs.domain.Order;
import com.cn.zyrs.domain.OrderCraft;
import com.cn.zyrs.domain.OrderSpecialCraft;
import com.cn.zyrs.domain.SpecialCraft;
import com.cn.zyrs.mapper.OrderMapper;
import com.cn.zyrs.service.IOrder;

@Service("orderService")
public class OrderServiceImpl implements IOrder {
	
	@Resource(name = "orderMapper")
	private OrderMapper orderMapper;
	
	/**
	 * 
	 * 业  务: 查询订单 <br>
	 * 英文名: getOrderByPrimaryKey 
	 * 功能号: TODO
	 * 时  间: 2016年8月8日 下午3:59:53
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：ordercode
	 * customername   servicer	status
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：List<Order>
	 */
	public List<Order> getOrder(String ordercode,String customername,String servicer,String status,String start,String end,String page,String odpid){
		int num = 0;
		if(page!=null&&!"".equalsIgnoreCase(page)){
			num =(Integer.valueOf(page) -1)*10;
			return this.orderMapper.getOrder(ordercode,customername,servicer,status,start,end,num,odpid);
		}else{
			return this.orderMapper.getOrder1(ordercode,customername,servicer,status,start,end,odpid);
		}
	}
	
//	/**
//	 * 
//	 * 业  务: 获取订单详情 <br>
//	 * 英文名: getOrderDetailByOrderCode 
//	 * 功能号: TODO
//	 * 时  间: 2016年8月10日 下午5:49:31
//	 * 应用项目: 中依睿晟新增订单APP后台管理系统
//	 * 作者: 严昊 <br>
//	 *
//	 * 入参：ordercode
//	 * TODO   TODO	TODO
//		TODO	 TODO	TODO	
//		
//	 * 
//	 * 出参：List<OrderDetail>
//	 */
//	public List<OrderDetail> getOrderDetailByOrderCode(String ordercode){
//		return this.orderMapper.getOrderDetail(ordercode);
//		
//	}
	
	@Transactional
	public int updateOrder (Order order){
		
		return this.orderMapper.updateOrder(order);
		
	}
	
	@Transactional
	public int addOrder(Order order){
		return this.orderMapper.insertSelective(order);
	}
	
	@Transactional
	public int addBomOrder(BomOrder bomorder){
		return this.orderMapper.addBomOrder(bomorder);
	}
	
	@Transactional
	public int addBomOrder1(BomOrder bomorder){
		
		return this.orderMapper.addBomOrder1(bomorder);
		
		
	}
	
	@Transactional
	public int addBomOrder2(BomOrder bomorder){
		
		return this.orderMapper.addBomOrder2(bomorder);
		
		
	}

	public Order getOrderByPrimaryKey(String ordercode) {
		return this.orderMapper.getOrderByPrimaryKey(ordercode);
	}

	@Override
	public List<Craft> getCraft(String type) {
		return this.orderMapper.getCraft(type);
	}
	
	@Override
	public List<SpecialCraft> getSpecialCraft(String type) {
		return this.orderMapper.getSpecialCraft(type);
	}

	@Transactional
	@Override
	public int addOrderCraft(OrderCraft oc) {
		return this.orderMapper.addOrderCraft(oc);
	}
	
	@Transactional
	@Override
	public int addOrderSpecialCraft(OrderSpecialCraft osc) {
		return this.orderMapper.addOrderSpecialCraft(osc);
	}

	@Override
	public List<Order> getOrderBase(String di) {
		return this.orderMapper.getOrderBase(di);
	}

}
